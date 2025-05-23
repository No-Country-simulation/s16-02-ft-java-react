"use client";
import { Dropdown, Input, Loader } from "components";
import React, { useState } from "react";
import { useSelector } from "react-redux";
import { RootState } from "store";

const RequestPage = () => {
  const [valueDropdown, setValueDropdown] = useState<any>({
    nameValue: "Pendiente",
  });
  const { adoptionList } = useSelector((state: RootState) => state.adoption);
  const handleChange = (e: any, name: string) => {
    const value = e.target.textContent;
    setValueDropdown((prev: any) => ({
      ...prev,
      [name]: value,
    }));
  };
  return (
    <section className="shelterPanel__body">
      <div className="shelterPanel__body--main">
        <div className="row-main">
          <h2>Solicitudes de adopcion pendientes</h2>
          <div className="table-list">
            <div className="table-header">
              <div className="table-row">
                <div className="table-column">Nombre</div>
                <div className="table-column">Código</div>
                <div className="table-column">Estado</div>
                <div className="table-column">Mascota</div>
                <div className="table-column">Raza</div>
              </div>
            </div>
            <div className="table-list-body">
              {!adoptionList && <Loader />}
              {adoptionList &&
                adoptionList.map((adoption: any) => {
                  return (
                    <div key={adoption.applicationId} className="table-row">
                      <div className="table-column">
                        <a
                          href={`mailto:${adoption.user.username}`}
                          style={{
                            borderBottom: "1px solid darkgreen",
                            color: "darkgreen",
                          }}
                        >
                          {adoption.user.username}
                        </a>
                      </div>
                      <div className="table-column">
                        {adoption.applicationNumber === "string"
                          ? "petcode-21200"
                          : adoption.applicationNumber}
                      </div>
                      <div className="table-column">
                        {adoption.approved ? "Aprovado" : "Pendiente"}

                        {/* <Dropdown */}
                        {/*   name="nameValue" */}
                        {/*   options={["Pendiente", "Aprobado", "Rechazado"]} */}
                        {/*   placeholder="valor" */}
                        {/*   value={valueDropdown.nameValue} */}
                        {/*   onSelect={handleChange} */}
                        {/* /> */}
                      </div>
                      <div className="table-column">{adoption.pet.petName}</div>
                      <div className="table-column">
                        {adoption.pet.petType === "Cat" ? "Gato" : "Perro"}
                      </div>
                    </div>
                  );
                })}
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default RequestPage;
