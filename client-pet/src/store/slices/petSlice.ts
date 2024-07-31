import { createSlice } from "@reduxjs/toolkit";

interface PetStateProps {
  pets: any;
  petsHome: any;
  status: "idle" | "loading" | "succeeded" | "failed";
  error: string | null;
  isLoading: boolean;
}

const initialState: PetStateProps = {
  petsHome: null,
  pets: null,
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
      state.pets = action.payload;
      state.status = "succeeded";
    },
    createPetFailure(state, action) {
      state.isLoading = false;
      state.error = action.payload;
      state.status = "failed";
    },
    getPetsHomeStart: (state) => {
      state.isLoading = true;
      state.error = null;
      state.status = "loading";
    },
    getPetsHomeSuccess: (state, action) => {
      state.isLoading = false;
      state.petsHome = action.payload;
      state.status = "succeeded";
    },
    getPetsHomeFailure: (state, action) => {
      state.isLoading = false;
      state.status = "failed";
      state.error = action.payload;
    },
    getPetStart: (state) => {
      state.isLoading = true;
      state.error = null;
      state.status = "loading";
    },
    getPetSuccess: (state, action) => {
      state.isLoading = false;
      state.pets = action.payload;
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
      state.pets = null;
      state.petsHome = null;
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
  getPetsHomeStart,
  getPetsHomeFailure,
  getPetsHomeSuccess,
} = petSlice.actions;

export default petSlice.reducer;
