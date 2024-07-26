"use client";
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
    <div className="shelterPanel">
      <div className="shelterPanel__header">
        <header>
          <h1>Perfil de usuario.</h1>
        </header>
      </div>
      <section className="shelterPanel__body">
        <div className="shelterPanel__body--main">
          {!user && <div>cargando datos de usuario...</div>}
          {user && (
            <div>
              <div>Nombre: {user.profileName}</div>
              <div>Apellidos: {user.profileLastName}</div>
              <div>Direccion: {user.profileAddress}</div>
              <div>Tipo de documento: {user.profileDocumentType}</div>
              <div>Nro de documento: {user.profileDocumentNumber}</div>
              {/* <span>Distrito</span> */}
              {/* <div>Distrito Id: {user.districtId}</div> */}
              {/* <div>Nombre de distrito: {user.district.districtName}</div> */}
              {/* <span>Ciudad</span> */}
              {/* <div>ciuidad Id: {user.district.city.cityId}</div> */}
              {/* <div>nombre de ciudad: {user.district.city.cityName}</div> */}
            </div>
          )}
        </div>
      </section>
    </div>
  );
};

export default ShelterProfilePage;
