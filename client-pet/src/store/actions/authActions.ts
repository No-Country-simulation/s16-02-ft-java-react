import { deleteCookie, setCookie } from "cookies-next";
import { fetchAPI } from "@helpers";
import {
  checkAuth,
  loginFailure,
  loginStart,
  loginSuccess,
  logoutStart,
} from "../slices/authSlice";
import { LoginProps } from "@types";

export const login =
  (credentials: LoginProps, router: any) => async (dispatch: any) => {
    dispatch(loginStart());
    try {
      const response = await fetchAPI("api/login", "POST", {
        username: credentials.email,
        password: credentials.password,
      });

      const user = {
        username: response.username,
        role: response.role[0].authority,
        token: response.token,
      };
      setCookie("token", response.token);
      setCookie("role", user.role);
      localStorage.setItem("user", user.username);
      localStorage.setItem("role", user.role);
      dispatch(loginSuccess(user));
      console.log("Login Success.");
      if (user.role === "ROLE_USER") {
        router.push("/");
      } else if (user.role === "ROLE_SHELTER") {
        router.push("/shelter");
      } else {
        router.push("/none");
      }
    } catch (error) {
      dispatch(loginFailure(error.message));
    }
  };

export const logout = () => async (dispatch: any) => {
  dispatch(logoutStart());
  localStorage.clear();
  deleteCookie("token");
};

export const checkAuthentication = () => async (dispatch: any) => {
  const user = localStorage.getItem("user");
  const role = localStorage.getItem("role");
  dispatch(checkAuth({ user, role }));
  console.log("check auth");
};
