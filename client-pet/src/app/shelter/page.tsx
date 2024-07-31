"use client";
import React from "react";
import { CircleCheck } from "@icons";

const RefugioPage = () => {
  return (
    <div className="shelterHome shelterPanel">
      <div className="shelterHome__header shelterPanel__header">
        <header>
          <h1>Bienvenido a Petconnet.</h1>
        </header>
      </div>
      <section className="shelterHome__body shelterPanel__body">
        <div className="shelterPanel__body--main">
          <div className="row-main">
            <h2>Primeros pasos</h2>
            <div className="row-table">
              <div className="table-item">
                <CircleCheck active />
                <span>Empieza creando tu refugio</span>
              </div>
              <div className="table-item">
                <CircleCheck />
                <span>Agrega mascotas a tu refugio</span>
              </div>
              <div className="table-item">
                <CircleCheck />
                <span>Verifica la lista de mascotas</span>
              </div>
              <div className="table-item">
                <CircleCheck />
                <span>Revisa los datos de perfil</span>
              </div>
              <div className="table-item">
                <CircleCheck />
                <span>Rivisa tus solicitudes</span>
              </div>
              <div className="table-item">
                <CircleCheck />
                <span>Acepta tu primera solicitud</span>
              </div>
            </div>
          </div>
          <div className="row-main">
            <h2>Actividades recientes</h2>
            <div className="main-activity">sin actividades recientes</div>
          </div>
          <div className="row-main">
            <h2>Nuevas solicitudes de adopción</h2>
            <div className="main-activity">aun no tienes solicitudes</div>
          </div>
        </div>
      </section>
    </div>
  );
};

export default RefugioPage;
