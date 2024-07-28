import { createSlice } from "@reduxjs/toolkit";

interface UserStateProps {
  user: any;
  isAuth: boolean;
  status: "idle" | "loading" | "succeeded" | "failed";
  error: string | null;
  isLoading: boolean;
  nav: "select" | "user" | "user_shelter" | "user_profile";
}

const initialState: UserStateProps = {
  user: null,
  isAuth: false,
  status: "idle",
  error: null,
  isLoading: false,
  nav: "select",
};

const userSlice = createSlice({
  name: "user",
  initialState,
  reducers: {
    createUserStart: (state) => {
      state.isLoading = true;
      state.error = null;
      state.status = "loading";
    },
    createUserSuccess(state, action) {
      state.isLoading = false;
      state.user = action.payload;
      state.status = "succeeded";
    },
    createUserFailure(state, action) {
      state.isLoading = false;
      state.error = action.payload;
      state.status = "failed";
    },
    navDefault: (state) => {
      state.nav = "select";
    },
    navUser: (state) => {
      state.nav = "user";
    },
    navUserShelter: (state) => {
      state.nav = "user_shelter";
    },
    navUserProfile: (state) => {
      state.nav = "user_profile";
    },
    getUserProfileStart: (state) => {
      state.isLoading = true;
      state.error = null;
      state.status = "loading";
    },
    getUserProfileSuccess: (state, action) => {
      state.isLoading = false;
      state.user = action.payload;
      state.status = "succeeded";
    },
    getUserProfileFailure: (state, action) => {
      state.isLoading = false;
      state.status = "failed";
      state.error = action.payload;
    },
    defaultUser: (state) => {
      state.user = null;
    },
  },
});

export const {
  createUserStart,
  createUserFailure,
  createUserSuccess,
  navUser,
  navUserShelter,
  navDefault,
  navUserProfile,
  getUserProfileFailure,
  getUserProfileSuccess,
  getUserProfileStart,
  defaultUser,
} = userSlice.actions;

export default userSlice.reducer;
