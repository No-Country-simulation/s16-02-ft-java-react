"use client";
import React, { ChangeEvent, ChangeEventHandler, useState } from "react";
import { EyeSlashFilledIcon, EyeFilledIcon } from "@icons";

interface InputProps {
  name: string;
  label: string;
  placeholder: string;
  value: string | number;
  type: "text" | "password";
  isRequired?: boolean;
  className?: string;
  onChange: ChangeEventHandler<HTMLInputElement>;
}

const Input = ({
  name,
  label,
  type,
  placeholder,
  value,
  isRequired,
  className,
  onChange,
}: InputProps) => {
  const [isVisible, setIsVisible] = useState(false);
  const toggleVisibility = () => setIsVisible(!isVisible);
  return (
    <div className="input">
      <div className="input__label">{label}</div>
      <div className="input__content">
        <input
          name={name}
          type={type === "password" ? (isVisible ? "text" : "password") : type}
          placeholder={placeholder}
          value={value}
          onChange={onChange}
          required={isRequired ? true : false}
        // className={`input__content--element`}
        />
        {type === "password" ? (
          <button className="input__content--icon" onClick={toggleVisibility}>
            {isVisible ? (
              <EyeSlashFilledIcon className="" />
            ) : (
              <EyeFilledIcon className="" />
            )}
          </button>
        ) : null}
      </div>
    </div>
  );
};

export default Input;
