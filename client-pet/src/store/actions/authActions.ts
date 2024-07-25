import { deleteCookie, setCookie } from "cookies-next";
import { fetchAPI } from "@helpers";
import {
  checkAuth,
  getUserFailure,
  getUserStart,
  getUserSuccess,
  loginFailure,
  loginStart,
  loginSuccess,
  logoutStart,
} from "../slices/authSlice";
import { LoginProps } from "@types";
import { defaultShelter } from "store/slices/shelterSlice";

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

export const logout = (router: any) => async (dispatch: any) => {
  dispatch(logoutStart());
  try {
    deleteCookie("token");
    deleteCookie("role");
    localStorage.clear();
    router.push("/");
    dispatch(checkAuth({ username: "", role: "" }));
    dispatch(defaultShelter());
  } catch (error) {
    console.log(error);
  }
};

export const checkAuthentication = () => async (dispatch: any) => {
  if (
    localStorage.getItem("user") !== null &&
    localStorage.getItem("role") !== null
  ) {
    dispatch(
      checkAuth({
        user: localStorage.getItem("user"),
        role: localStorage.getItem("role"),
      })
    );
    console.log("check auth with localStorage");
  }

  if (
    localStorage.getItem("user") === null &&
    localStorage.getItem("role") === null
  ) {
    dispatch(checkAuth({ user: "", role: "" }));
    console.log("check auth with'out localstorage");
  }
};

export const checkShelterAuth =
  (userEmail: string) => async (dispatch: any) => {
    dispatch(getUserStart());
    try {
      const response = await fetchAPI(
        `api/auth/user/${userEmail}`,
        "GET",
        null,
        "YES"
      );
      dispatch(getUserSuccess(response.userId));
      console.log("check userId", response.userId);
    } catch (error) {
      dispatch(getUserFailure(error.message));
    }
  };
