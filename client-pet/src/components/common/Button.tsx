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
  loadingMessage,
  isRounded,
}: ButtonProps) => {
  return (
    <button
      className={`button button__${color} ${mode} ${isBordered ? "border" : ""} ${isRounded ? "rounded" : ""} ${className}`}
      onClick={onClick}
      type={type}
      disabled={isLoading ? true : isDisabled}
    >
      {isLoading ? <div className="loader"></div> : null}{" "}
      {isLoading ? (
        <span>{loadingMessage ? loadingMessage : "Espere por favor..."}</span>
      ) : (
        <span> {children}</span>
      )}
    </button>
  );
};

export default Button;
