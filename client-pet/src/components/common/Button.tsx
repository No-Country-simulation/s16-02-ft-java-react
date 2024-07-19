import React, { MouseEventHandler } from "react";
import { ButtonProps } from "@types";

const Button = ({
  children,
  color,
  mode,
  className,
  isBordered = true,
  onClick,
  type,
  isDisabled = false,
  isLoading = false,
}: ButtonProps) => {
  return (
    <button
      className={`button button__${color} ${mode} ${isBordered ? "border" : ""} ${className}`}
      onClick={onClick}
      type={type}
      disabled={isLoading ? true : isDisabled}
    >
      {isLoading ? <div className="loader"></div> : null}{" "}
      {isLoading ? <span>Ingresando...</span> : <span> {children}</span>}
    </button>
  );
};

export default Button;
