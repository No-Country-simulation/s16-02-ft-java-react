"use client";
import React, { useEffect, useState } from "react";
import { LayoutProps } from "types";
import { ShelterNav } from "@components";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, checkShelterAuth, RootState } from "@store";

const ShelterLayout = ({ children }: LayoutProps) => {
  const [value, setValue] = useState<any>();
  const user = localStorage.getItem("user");
  const { id } = useSelector((state: RootState) => state.auth);
  const dispatch = useDispatch<AppDispatch>();
  useEffect(() => {
    if (!id) dispatch(checkShelterAuth(user));
    console.log("id", id);
  }, []);
  return (
    <div>
      <ShelterNav />
      {id ? (
        <span>
          {id}
          {children}
        </span>
      ) : (
        <span>validando id...</span>
      )}
      {/* <Footer /> */}
    </div>
  );
};

export default ShelterLayout;
