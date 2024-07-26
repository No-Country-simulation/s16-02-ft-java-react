"use client";
import React, { ChangeEvent, useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState, createShelter, getShelter } from "@store";
import { Button, Input } from "@components";
import { ShelterProps } from "@types";

const initialShelterState: ShelterProps = {
  name: "",
  address: "",
};

const ShelterManagePage = () => {
  const [shelterForm, setShelterForm] =
    useState<ShelterProps>(initialShelterState);
  const dispatch = useDispatch<AppDispatch>();
  const { id } = useSelector((state: RootState) => state.auth);
  const { shelter, isLoading, status } = useSelector(
    (state: RootState) => state.shelter
  );

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setShelterForm((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = async () => {
    console.log(shelterForm);
    dispatch(
      createShelter({
        ...shelterForm,
        userId: id,
        districtId: 1,
      })
    );
  };

  useEffect(() => {
    if (id && !shelter && status !== "loading") dispatch(getShelter(id));
    console.log("shelter", shelter);
  }, []);
  return (
    <section className="shelterPanel__body">
      <div className="shelterPanel__body--main">
        {!shelter && status === "loading" && <div>cargando datos...</div>}
        {!shelter && status === "failed" && (
          <div>
            Nececitas crear un perfil de refugio
            {/* <div className="shelterPanel__body--nav"> */}
            {/*   <Button color="secondary" isRounded> */}
            {/*     Perfil */}
            {/*   </Button> */}
            {/*   <Button color="secondary" isRounded> */}
            {/*     Crear Perfil */}
            {/*   </Button> */}
            {/* </div> */}
          </div>
        )}
        {shelter && status === "succeeded" && <div>datos de refugio</div>}
      </div>
      {!shelter && status === "failed" && (
        <div className="shelterPanel__body--aside">crear refugio</div>
      )}

      {/* {!shelter && status === "loading" ? ( */}
      {/*   <div>cargando datos refugio...</div> */}
      {/* ) : !shelter && status === "failed" ? ( */}
      {/*   <div>crear refugio</div> */}
      {/* ) : ( */}
      {/*   <div>{shelter.shelterName}</div> */}
      {/* )} */}
      {/* {!isLoading ? ( */}
      {/*   <div> */}
      {/*     <span>crear usuario</span> */}
      {/*     <Input */}
      {/*       name="name" */}
      {/*       label="Nombre de refugio" */}
      {/*       type="text" */}
      {/*       placeholder="Ingresar nombre" */}
      {/*       value={shelterForm.name} */}
      {/*       onChange={handleChange} */}
      {/*     /> */}
      {/**/}
      {/*     <Input */}
      {/*       name="address" */}
      {/*       label="Direccion de refugio" */}
      {/*       type="text" */}
      {/*       placeholder="Ingresar dirección" */}
      {/*       value={shelterForm.address} */}
      {/*       onChange={handleChange} */}
      {/*     /> */}
      {/**/}
      {/*     <Button */}
      {/*       type="submit" */}
      {/*       color="primary" */}
      {/*       mode="primary" */}
      {/*       onClick={handleSubmit} */}
      {/*       isLoading={isLoading} */}
      {/*       loadingMessage="Creando refugio..." */}
      {/*     > */}
      {/*       Crear Refugio */}
      {/*     </Button> */}
      {/*   </div> */}
      {/* ) : ( */}
      {/*   <span>refugio</span> */}
      {/* )} */}
    </section>
  );
};

export default ShelterManagePage;