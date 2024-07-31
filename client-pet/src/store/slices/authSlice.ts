import { createSlice } from "@reduxjs/toolkit";

interface AuthStateProps {
  isAuth: boolean;
  status: "idle" | "loading" | "succeeded" | "failed";
  error: string | null;
  isLoading: boolean;
  user: any;
  id: string;
}

const initialState: AuthStateProps = {
  isAuth: false,
  status: "idle",
  error: null,
  isLoading: false,
  user: {
    role: "",
    username: "",
  },
  id: null,
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
      state.id = null;
    },
    logoutSuccess: (state) => {
      state.status = "succeeded";
      state.isLoading = false;
      state.isAuth = false;
      state.id = null;
    },
    logoutFailure: (state, action) => {
      state.status = "failed";
      state.isLoading = false;
      state.error = action.payload;
    },
    checkAuth: (state, action) => {
      console.log(action.payload);
      state.user = action.payload || { username: "", role: "" };
      // state.isAuth = localStorage.getItem("access_token") !== null;
      // state.user = JSON.parse(localStorage.getItem("user")) || null;
    },
    getUserStart: (state) => {
      state.status = "loading";
      state.isLoading = true;
      state.error = null;
    },
    getUserSuccess: (state, action) => {
      state.status = "succeeded";
      state.isLoading = false;
      state.id = action.payload;
    },
    getUserFailure: (state, action) => {
      state.status = "failed";
      state.isLoading = false;
      state.error = action.payload;
    },
  },
});

export const {
  loginStart,
  loginSuccess,
  loginFailure,
  logoutStart,
  checkAuth,
  getUserFailure,
  getUserSuccess,
  getUserStart,
} = authSlice.actions;

export default authSlice.reducer;
