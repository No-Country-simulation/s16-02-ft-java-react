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
  const { pets } = useSelector((state: RootState) => state.pet);
  const dispatch = useDispatch<AppDispatch>();
  useEffect(() => {
    if (!id || !user) dispatch(checkShelterAuth(user));
    console.log("id", id);
    console.log("pets", pets);
  }, []);
  return (
    <div className="shelterLayout">
      <ShelterNav />
      {id ? <> {children} </> : <span>validando permisos...</span>}
      {/* {id ? <section>{children}</section> : <span>validando id...</span>} */}
      {/* <Footer /> */}
    </div>
  );
};

export default ShelterLayout;
