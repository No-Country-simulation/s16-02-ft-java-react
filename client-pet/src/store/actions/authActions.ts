import { setCookie } from "cookies-next";
import { fetchAPI } from "@helpers";
import { loginFailure, loginStart, loginSuccess } from "../slices/authSlice";
import { LoginProps } from "@types";

export const login =
  (credentials: LoginProps, router: any) => async (dispatch: any) => {
    dispatch(loginStart());
    try {
      const response = await fetchAPI("api/login", "POST", {
        username: credentials.email,
        password: credentials.password,
      });

      setCookie("token", response.token);
      console.log("Login Success.");
      dispatch(loginSuccess());
      router.push("/shelter");
    } catch (error) {
      dispatch(loginFailure(error.message));
    }
  };
