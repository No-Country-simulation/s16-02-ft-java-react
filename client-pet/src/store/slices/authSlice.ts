import { createSlice } from "@reduxjs/toolkit";

interface AuthStateProps {
  isAuth: boolean;
  status: "idle" | "loading" | "succeeded" | "failed";
  error: string | null;
  isLoading: boolean;
  user: any;
}

const initialState: AuthStateProps = {
  isAuth: false,
  status: "idle",
  error: null,
  isLoading: false,
  user: {
    // role: "",
    // username: "",
  },
};

const authSlice = createSlice({
  name: "auth",
  initialState,
  reducers: {
    loginStart: (state) => {
      state.status = "loading";
      state.isLoading = true;
      state.error = null;
    },
    loginSuccess: (state, action) => {
      state.status = "succeeded";
      state.isLoading = false;
      state.isAuth = true;
      state.user = action.payload;
    },
    loginFailure: (state, action) => {
      state.status = "failed";
      state.isLoading = false;
      state.error = action.payload;
    },
    logoutStart: (state) => {
      state.status = "loading";
      state.error = null;
    },
    logoutSuccess: (state) => {
      state.status = "succeeded";
      state.isLoading = false;
      state.isAuth = false;
    },
    logoutFailure: (state, action) => {
      state.status = "failed";
      state.isLoading = false;
      state.error = action.payload;
    },
    checkAuth: (state, action) => {
      state.user = action.payload;
      // state.isAuth = localStorage.getItem("access_token") !== null;
      // state.user = JSON.parse(localStorage.getItem("user")) || null;
    },
    // openLogin: (state) => {
    //   state.isOpen = true;
    // },
    // closeLogin: (state) => {
    //   state.isOpen = false;
    // },
    // loginStart: (state) => {
    //   state.isLoading = true;
    //   state.error = null;
    // },
    // loginSuccess: (state, action) => {
    //   state.isLoading = false;
    //   state.user = action.payload;
    // },
    // loginFailure: (state, action) => {
    //   state.isLoading = false;
    //   state.error = action.payload;
    // },
    // logout: (state) => {
    //   state.user = null;
    //   state.error = null;
    // },
  },
});

export const {
  loginStart,
  loginSuccess,
  loginFailure,
  logoutStart,
  checkAuth,
} = authSlice.actions;

export default authSlice.reducer;
