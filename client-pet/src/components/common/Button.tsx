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
}: ButtonProps) => {
  return (
    <button
      className={`button button__${color} ${mode} ${isBordered ? "border" : ""} ${className}`}
      onClick={onClick}
      type={type}
      disabled={isDisabled}
    >
      <span>{children}</span>
    </button>
  );
};

export default Button;
