import { createSlice } from "@reduxjs/toolkit";

interface UserStateProps {
  shelter: any;
  status: "idle" | "loading" | "succeeded" | "failed";
  error: string | null;
  isLoading: boolean;
}

const initialState: UserStateProps = {
  shelter: null,
  status: "idle",
  error: null,
  isLoading: false,
};

const shelterSlice = createSlice({
  name: "shelter",
  initialState,
  reducers: {
    createShelterStart: (state) => {
      state.isLoading = true;
      state.error = null;
      state.status = "loading";
    },
    createShelterSuccess(state, action) {
      state.isLoading = false;
      state.shelter = action.payload;
      state.status = "succeeded";
    },
    createShelterFailure(state, action) {
      state.isLoading = false;
      state.error = action.payload;
      state.status = "failed";
    },
    getShelterStart: (state) => {
      state.isLoading = true;
      state.error = null;
      state.status = "loading";
    },
    getShelterSuccess: (state, action) => {
      state.isLoading = false;
      state.shelter = action.payload;
      state.status = "succeeded";
    },
    getShelterFailure: (state, action) => {
      state.isLoading = false;
      state.status = "failed";
      state.error = action.payload;
    },
  },
});

export const {
  createShelterStart,
  createShelterSuccess,
  createShelterFailure,
  getShelterStart,
  getShelterSuccess,
  getShelterFailure,
} = shelterSlice.actions;

export default shelterSlice.reducer;
