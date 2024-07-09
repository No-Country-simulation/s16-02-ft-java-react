import React from "react";

interface ButtonProps {
  children: React.ReactNode;
  color: "primary" | "secondary";
  className?: string;
}

const Button = ({ children, color, className }: ButtonProps) => {
  return (
    <button className={`button button__${color} ${className}`}>
      {children}
    </button>
  );
};

export default Button;
