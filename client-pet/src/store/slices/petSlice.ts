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

const petSlice = createSlice({
  name: "shelter",
  initialState,
  reducers: {
    createPetStart: (state) => {
      state.isLoading = true;
      state.error = null;
      state.status = "loading";
    },
    createPetSuccess(state, action) {
      state.isLoading = false;
      state.shelter = action.payload;
      state.status = "succeeded";
    },
    createPetFailure(state, action) {
      state.isLoading = false;
      state.error = action.payload;
      state.status = "failed";
    },
    getPetStart: (state) => {
      state.isLoading = true;
      state.error = null;
      state.status = "loading";
    },
    getPetSuccess: (state, action) => {
      state.isLoading = false;
      state.shelter = action.payload;
      state.status = "succeeded";
    },
    getPetFailure: (state, action) => {
      state.isLoading = false;
      state.status = "failed";
      state.error = action.payload;
    },
    defaultPet: (state) => {
      state.status = "idle";
      state.error = null;
      state.shelter = null;
    },
  },
});

export const {
  createPetStart,
  createPetSuccess,
  createPetFailure,
  getPetStart,
  getPetSuccess,
  getPetFailure,
  defaultPet,
} = petSlice.actions;

export default petSlice.reducer;
