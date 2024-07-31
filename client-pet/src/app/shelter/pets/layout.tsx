"use client";
import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { LayoutProps } from "@types";
import { AppDispatch, defaultPet, getPet, getShelter, RootState } from "@store";

const PetsShelterLayout = ({ children }: LayoutProps) => {
  const dispatch = useDispatch<AppDispatch>();
  const { id } = useSelector((state: RootState) => state.auth);
  const { shelter } = useSelector((state: RootState) => state.shelter);
  const { pets, status } = useSelector((state: RootState) => state.pet);

  useEffect(() => {
    if (!shelter) dispatch(getShelter(id));
    if (id && shelter && !pets && status !== "loading")
      dispatch(getPet(shelter.shelterId));
    console.log({ pets, status });

    // eslint-disable-next-line
  }, [shelter, pets]);
  console.log(status);
  return (
    <div className="shelterPanel">
      <div className="shelterPanel__header">
        <header>
          <h1>Mascotas en adopción.</h1>
        </header>
      </div>
      {children}
    </div>
  );
};

export default PetsShelterLayout;
