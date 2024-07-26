import { combineReducers } from "@reduxjs/toolkit";

import userSlice from "./slices/userSlice";
import authReducer from "./slices/authSlice";
import shelterSlice from "./slices/shelterSlice";
import petSlice from "./slices/petSlice";

const rootReducer = combineReducers({
  user: userSlice,
  auth: authReducer,
  shelter: shelterSlice,
  pet: petSlice,
});

export default rootReducer;
