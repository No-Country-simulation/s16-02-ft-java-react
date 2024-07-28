"use client";
import React, { ChangeEvent, useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState, createShelter, getShelter } from "@store";
import { Button, Dropdown, Input } from "@components";
import { ShelterProps } from "@types";
const initialShelterState: ShelterProps = {
  name: "",
  address: "",
  district: "",
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

  const handleDropdownChange = (e: any, name: string) => {
    const value = e.target.textContent;
    setShelterForm((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleClear = () => {
    setShelterForm(initialShelterState);
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
    if (id && !shelter && status !== "loading") {
      console.log("get shelter");
      dispatch(getShelter(id));
    }
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
        {shelter && status === "succeeded" && (
          <>
            <div className="row-variant">
              <div className="row-variant-left">
                <h2>Detalles de refugio</h2>
                <p>Lorem ipsun </p>
              </div>
              <div className="row-variant-right">
                <Input
                  label="Nombre de refugio"
                  name="name"
                  placeholder="Nombre"
                  type="text"
                  value={shelter.shelterName}
                />
                <Input
                  label="Dirección"
                  name="address"
                  placeholder="dirección"
                  type="text"
                  value={shelter.shelterAddress}
                />
              </div>
            </div>
            <div className="row-variant">
              <div className="row-variant-left">
                <h2>Mapa</h2>
                {/* <p>Lorem ipsun </p> */}
              </div>
              <div className="row-variant-right">Distrito</div>
            </div>
          </>
        )}
      </div>
      {!shelter && status === "failed" && (
        <div className="shelterPanel__body--aside">
          <div className="petsShelter__aside--form">
            <Input
              label="Nombre"
              name="name"
              type="text"
              placeholder="Nombre"
              value={shelterForm.name}
              onChange={handleChange}
            />
            <Input
              label="Dirección"
              name="address"
              type="text"
              placeholder="Dirección"
              value={shelterForm.address}
              onChange={handleChange}
            />
            <Dropdown
              label="Distrito"
              name="district"
              options={["1", "2", "4"]}
              placeholder="Distrito"
              value={shelterForm.district}
              onSelect={handleDropdownChange}
            />
          </div>
          <div className="petsShelter__aside--options">
            <Button color="primary" onClick={() => handleSubmit()}>
              Agregar
            </Button>
            <Button color="secondary" onClick={() => handleClear()}>
              Borrar
            </Button>
          </div>
        </div>
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
