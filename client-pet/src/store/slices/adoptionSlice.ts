import { createSlice } from "@reduxjs/toolkit";

interface AdoptionStateProps {
  adoptionList: any;
  status: "idle" | "loading" | "succeeded" | "failed";
  error: string | null;
  isLoading: boolean;
}

const initialState: AdoptionStateProps = {
  adoptionList: null,
  status: "idle",
  error: null,
  isLoading: false,
};

const adoptionSlice = createSlice({
  name: "adoption",
  initialState,
  reducers: {
    createAdoptionStart: (state) => {
      state.isLoading = true;
      state.error = null;
      state.status = "loading";
    },
    createAdoptionSuccess(state, action) {
      state.isLoading = false;
      state.adoptionList = action.payload;
      state.status = "succeeded";
    },
    createAdoptionFailure(state, action) {
      state.isLoading = false;
      state.error = action.payload;
      state.status = "failed";
    },
    getAdoptionStart: (state) => {
      state.isLoading = true;
      state.error = null;
      state.status = "loading";
    },
    getAdoptionSuccess: (state, action) => {
      state.isLoading = false;
      state.adoptionList = action.payload;
      state.status = "succeeded";
    },
    getAdoptionFailure: (state, action) => {
      state.isLoading = false;
      state.status = "failed";
      state.error = action.payload;
    },
    defaultAdoption: (state) => {
      state.status = "idle";
      state.error = null;
      state.adoptionList = null;
    },
  },
});

export const {
  createAdoptionStart,
  createAdoptionSuccess,
  createAdoptionFailure,
  getAdoptionStart,
  getAdoptionSuccess,
  getAdoptionFailure,
} = adoptionSlice.actions;

export default adoptionSlice.reducer;
