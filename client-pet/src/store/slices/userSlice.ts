import { createSlice } from "@reduxjs/toolkit";

interface ExampleState {
  value: number;
}

const initialState: ExampleState = {
  value: 3,
};

const exampleSlice = createSlice({
  name: "name example",
  initialState,
  reducers: {
    increment: (state) => {
      state.value += 1;
    },
    decrement: (state) => {
      state.value -= 1;
    },
  },
});

export const { increment, decrement } = exampleSlice.actions;

export default exampleSlice.reducer;
