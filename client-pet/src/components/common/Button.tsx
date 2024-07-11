import React from "react";

interface ButtonProps {
  children: React.ReactNode;
  color: "primary" | "secondary";
  type?: "primary" | "secondary";
  className?: string;
  isBordered?: boolean;
}

const Button = ({
  children,
  color,
  type,
  className,
  isBordered = true,
}: ButtonProps) => {
  return (
    <button
      className={`button button__${color} ${type} ${isBordered ? "border" : ""} ${className}`}
    >
      <label>{children}</label>
      {/* {children} */}
    </button>
  );
};

export default Button;
