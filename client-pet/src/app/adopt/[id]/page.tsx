"use client";
import { Button, Input, Loader } from "components";
import Image from "next/image";
import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  AppDispatch,
  createAdoptionRequest,
  getSinglePet,
  RootState,
} from "store";

const PetSinglePage = ({ params }: { params: { id: string } }) => {
  const dispatch = useDispatch<AppDispatch>();
  const { pet, status, isLoading } = useSelector(
    (state: RootState) => state.pet
  );

  const handleSubmit = async () => {
    const data = {
      applicationNumber: pet.petName + "0001",
      applicationState: "ApplicationSent",
      approved: false,
      userId: "56b1590c-a7f4-48e5-b026-57a85ff949b0",
      petId: pet.petId,
    };
    dispatch(createAdoptionRequest(data));
  };

  useEffect(() => {
    if (status !== "loading") dispatch(getSinglePet(params.id));
  }, []);

  console.log(pet);

  return (
    <div className="">
      {pet && status === "succeeded" ? (
        <div className="singlePet">
          {/* <div className="singlePet__header">{pet.petName}</div> */}
          <div className="singlePet__body">
            <div className="singlePet__body--picture">
              <Image
                src={pet.multimedia[0].urlMultimedia}
                height={800}
                width={500}
                alt={pet.petName}
              />
            </div>
            <div className="singlePet__body--content">
              <header>
                <h2>{pet.petName}</h2>
              </header>
              <div className="content-row">
                <span>Edad:</span>
                <span>{pet.petAge} Años</span>
              </div>
              <div className="content-row">
                <span>Peso:</span>
                <span>{pet.petAge} Kilos</span>
              </div>
              <div className="content-row">
                <span>Tamaño:</span>
                <span>
                  {pet.petSize === "Toy" && "Pequeño"}
                  {pet.petSize === "Little" && "Pequeño"}
                  {pet.petSize === "Medium" && "Mediano"}
                  {pet.petSize === "Large" && "Grande"}
                  {pet.petSize === "Giant" && "Grande"}
                </span>
              </div>
              <div className="content-row">
                <span>Temperamento:</span>
                <span>{pet.petTemperament}</span>
              </div>
              <Button
                color="primary"
                isLoading={isLoading}
                onClick={handleSubmit}
              >
                Solicitar Adopción
              </Button>
            </div>
          </div>
        </div>
      ) : (
        <Loader text="Cargando datos de mascota.." />
      )}
    </div>
  );
};

export default PetSinglePage;
