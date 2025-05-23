import React from "react";

const Loader = ({ minWidth, text }: { text?: string; minWidth?: string }) => {
  return (
    <div
      className="loader-content"
      style={{ minHeight: minWidth ? minWidth : "450px" }}
    >
      {text && <h2>Cargando datos de mascota...</h2>}
      <div className="loader-main"></div>
    </div>
  );
};

export default Loader;
