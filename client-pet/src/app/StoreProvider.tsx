"use client";
import React from "react";
import { useRef } from "react";
import { Provider } from "react-redux";
import { makeStore, AppStore, checkAuthentication } from "@store";
import { ProviderProps } from "@types";

export default function StoreProvider({ children }: ProviderProps) {
  const storeRef = useRef<AppStore>();
  if (!storeRef.current) {
    storeRef.current = makeStore();
    storeRef.current.dispatch(checkAuthentication());
  }

  return <Provider store={storeRef.current}>{children}</Provider>;
}
