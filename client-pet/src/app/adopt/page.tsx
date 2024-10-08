"use client";
import Image from "next/image";
import img from "../../assets/adop7.jpg";
import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, getPetsHome, RootState } from "store";

const AdopcionPage = () => {
  const dispatch = useDispatch<AppDispatch>();
  const { petsHome, status } = useSelector((state: RootState) => state.pet);

  useEffect(() => {
    if (!petsHome) dispatch(getPetsHome());
  }, []);

  console.log("status pets", status);

  // if (!pets) return <>cargando pets....</>;

  return (
    <div className="adoptPage">
      <header className="adoptPage__header">
        <h2>Algunos de nuestros amigos que buscan un hogar</h2>
      </header>
      <div className="adoptPage__gallery">
        {!petsHome && status === "loading" && <div>cargando...</div>}
        {petsHome &&
          petsHome.content &&
          status === "succeeded" &&
          petsHome.content?.map((pet: any) => {
            return (
              <div key={pet.petId} className="adoptPage__gallery--card">
                <Image src={img} alt="adoption pet gallery item" />
                <div className="card-content">
                  <label>{pet.petName}</label>
                </div>
              </div>
            );
          })}
      </div>
    </div>
  );
};

export default AdopcionPage;
