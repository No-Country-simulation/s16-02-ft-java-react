import { combineReducers } from "@reduxjs/toolkit";

import userSlice from "./slices/userSlice";
import authReducer from "./slices/authSlice";
import shelterSlice from "./slices/shelterSlice";

const rootReducer = combineReducers({
  user: userSlice,
  auth: authReducer,
  shelter: shelterSlice,
});

export default rootReducer;
