"use client";
import { Input } from "components";
import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, getUserProfile, RootState } from "store";

const ShelterProfilePage = () => {
  const dispatch = useDispatch<AppDispatch>();
  const { id } = useSelector((state: RootState) => state.auth);
  const { user, status } = useSelector((state: RootState) => state.user);
  useEffect(() => {
    if (id && !user && status !== "loading") dispatch(getUserProfile(id));
    console.log("recharge", id, user);
  }, []);
  console.log(status);
  return (
    <section className="shelterPanel__body">
      <div className="shelterPanel__body--main">
        {!user && status === "loading" && (
          <div>cargando datos de usuario...</div>
        )}
        {!user && status === "failed" && <div>Sin datos para mostrar.</div>}
        {user && status === "succeeded" && (
          <>
            <div className="row-variant">
              <div className="row-variant-left">
                <h2>Datos generales</h2>
              </div>
              <div className="row-variant-right">
                <Input
                  label="Nombre"
                  name="name"
                  placeholder="Nombre"
                  type="text"
                  value={user.profileName}
                />
                <Input
                  label="Apellidos"
                  name="lastname"
                  placeholder="Apellidos"
                  type="text"
                  value={user.profileLastName}
                />
                <Input
                  label="Dirección"
                  name="address"
                  placeholder="Dirección"
                  type="text"
                  value={user.profileAddress}
                />
              </div>
            </div>
            <div className="row-variant">
              <div className="row-variant-left">
                <h2>Datos sensibles</h2>
              </div>
              <div className="row-variant-right">
                <Input
                  label="Tipo de Documento"
                  name="profileDocument"
                  placeholder=""
                  type="text"
                  value={user.profileDocumentType}
                />
                <Input
                  label="Nro de Documento"
                  name="profileDocumentNumber"
                  placeholder="Apellidos"
                  type="text"
                  value={user.profileDocumentNumber}
                />
              </div>
            </div>
            {/* <span>Distrito</span> */}
            {/* <div>Distrito Id: {user.districtId}</div> */}
            {/* <div>Nombre de distrito: {user.district.districtName}</div> */}
            {/* <span>Ciudad</span> */}
            {/* <div>ciuidad Id: {user.district.city.cityId}</div> */}
            {/* <div>nombre de ciudad: {user.district.city.cityName}</div> */}
          </>
        )}
      </div>
    </section>
  );
};

export default ShelterProfilePage;
