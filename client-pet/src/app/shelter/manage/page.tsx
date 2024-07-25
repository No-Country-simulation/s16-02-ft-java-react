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
    // if (!shelter) dispatch(getShelter(id));
    console.log("status shelter", status);
  }, []);
  return (
    <div className="shelterPanel">
      <div className="shelterPanel__header">
        <header>
          <h2>Perfil de refugio.</h2>
        </header>
      </div>
      <section className="shelterPanel__body">
        {!shelter && status === "loading" && <div>cargando datos...</div>}
        {!shelter && status === "failed" && <div>crear refugio</div>}
        {shelter && status === "succeeded" && <div>{shelter.shelterName}</div>}
      </section>
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
    </div>
  );
};

export default ShelterManagePage;
