"use client";
import React from "react";

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
              <span>Action 1</span>
              <span>Action 2</span>
              <span>Action 3</span>
              <span>Action 4</span>
              <span>Action 5</span>
              <span>Action 6</span>
            </div>
          </div>
          <div className="row-main">
            <h2>Actividades recientes</h2>
            <div>sin actividades recientes</div>
          </div>
          <div className="row-main">
            <h2>Nuevas solicitudes de adopción</h2>
            <div>aun no tienes solicitudes</div>
          </div>
        </div>
      </section>
    </div>
  );
};

export default RefugioPage;
