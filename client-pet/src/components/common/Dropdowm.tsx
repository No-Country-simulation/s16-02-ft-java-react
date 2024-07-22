"use client";
import { Arrow } from "@icons";
import React, { useState } from "react";

const Drowpdown = ({ options, value, onSelect }: any) => {
  const [isOpen, setIsOpen] = useState<boolean>(false);

  return (
    <div className={`dropdown documentType ${isOpen ? "open" : ""}`}>
      <div className="dropdown__label">Tipo de documento</div>
      <button className="dropdown__content" onClick={() => setIsOpen(!isOpen)}>
        <span className="dropdown__content--text">
          {value ? value : "Ingrese su documento"}
        </span>
        <Arrow />
      </button>
      <div className="dropdown__list">
        {options.map((option: any, i: any) => (
          <div
            key={i}
            className="dropdown__list--option"
            onClick={(e) => {
              onSelect(e);
              setIsOpen(!isOpen);
            }}
          >
            {option}
          </div>
        ))}
      </div>
    </div>
  );
};

export default Drowpdown;
