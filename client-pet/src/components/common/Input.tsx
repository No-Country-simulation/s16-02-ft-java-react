"use client";
import React, { useRef, useState, MouseEvent } from "react";
import { EyeSlashFilledIcon, EyeFilledIcon, ExclamationCircle } from "@icons";
import { InputProps } from "@types";

const Input = ({
  name,
  label,
  type,
  placeholder,
  value,
  isRequired,
  isBordered = true,
  className,
  onChange,
  isInvalid,
}: InputProps) => {
  const inputRef = useRef(null);
  const [isVisible, setIsVisible] = useState(false);
  const toggleVisibility = () => setIsVisible(!isVisible);

  const handleInputClick = (event: MouseEvent<HTMLDivElement>) => {
    if (event.target !== inputRef.current) {
      inputRef.current.focus();
      const event = new Event("input", { bubbles: true });
      inputRef.current.dispatchEvent(event);
    }
  };

  return (
    <div className={`input ${name} ${className}`}>
      {label ? <div className="input__label">{label}</div> : null}
      <div
        className={`input__content ${isBordered ? "border" : ""} ${isInvalid ? "error" : ""}`}
        onClick={handleInputClick}
      >
        <input
          ref={inputRef}
          name={name}
          type={type === "password" ? (isVisible ? "text" : "password") : type}
          placeholder={placeholder}
          value={value}
          onChange={onChange}
          required={isRequired ? true : false}
          autoComplete="nope"
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
      {isInvalid ? (
        <span className="input__isInvalidMessage">
          <ExclamationCircle />
          {isInvalid}
        </span>
      ) : null}
    </div>
  );
};

export default Input;
