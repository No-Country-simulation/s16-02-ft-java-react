import React from "react";

interface ButtonProps {
  children: React.ReactNode;
  color: "primary" | "secondary";
}

const Button = ({ children, color }: ButtonProps) => {
  return <button className={`button button__${color}`}>{children}</button>;
};

export default Button;
