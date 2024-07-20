import { combineReducers } from "@reduxjs/toolkit";

import userSlice from "./slices/userSlice";
import authReducer from "./slices/authSlice";

const rootReducer = combineReducers({
  user: userSlice,
  auth: authReducer,
});

export default rootReducer;
