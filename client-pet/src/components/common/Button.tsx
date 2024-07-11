import React from "react";

interface ButtonProps {
  children: React.ReactNode;
  color: "primary" | "secondary";
  type?: "primary" | "secondary";
  className?: string;
  border?: boolean;
}

const Button = ({
  children,
  color,
  type,
  className,
  border = true,
}: ButtonProps) => {
  return (
    <button
      className={`button button__${color} ${type} ${border ? "border" : ""} ${className}`}
    >
      {children}
    </button>
  );
};

export default Button;
