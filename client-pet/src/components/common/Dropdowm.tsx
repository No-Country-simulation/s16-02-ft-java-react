"use client";
import { Arrow } from "@icons";
import React, { useState } from "react";
import { DropdowmProps } from "@types";

const Drowpdown = ({
  options,
  value,
  onSelect,
  placeholder,
  label,
  name,
}: DropdowmProps) => {
  const [isOpen, setIsOpen] = useState<boolean>(false);

  return (
    <div className={`dropdown documentType ${isOpen ? "open" : ""}  ${name}`}>
      {label ? <div className="dropdown__label">{label}</div> : null}
      <button className="dropdown__content" onClick={() => setIsOpen(!isOpen)}>
        <span className="dropdown__content--text">
          {value ? value : placeholder}
        </span>
        <Arrow />
      </button>
      <div className="dropdown__list">
        {options.map((option: any, i: any) => (
          <div
            key={i}
            className="dropdown__list--option"
            onClick={(e) => {
              onSelect(e, name);
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
