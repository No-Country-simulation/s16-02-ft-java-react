"use client";
import Link from "next/link";
import React from "react";
import { useSelector } from "react-redux";
import { RootState } from "@store";

const PetsShelterPage = () => {
  const { shelter } = useSelector((state: RootState) => state.shelter);
  const { pet, status } = useSelector((state: RootState) => state.pet);
  return (
    <section className="shelterPanel__body">
      <div className="shelterPanel__body--main">
        <div className="shelterPanel__body--row">
          <Link href={"/shelter/pets"}>listar</Link>
          <Link href={"/shleter/pets/new"}>agregar</Link>
        </div>
        <div className="row-main">
          {!pet && !shelter && status === "loading" && (
            <div>cargando datos de mascota...</div>
          )}
          {pet && status === "succeeded" && (
            <div>nombre de mascota: {pet[0].petName}</div>
          )}
        </div>
      </div>
      <div className="shelterPanel__body--aside">aside</div>
    </section>
  );
};

export default PetsShelterPage;
