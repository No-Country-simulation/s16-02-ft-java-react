import { Dispatch, SetStateAction } from "react";
import { LoginProps, RegisterProps } from "@types";

export const validateLoginForm = (data: LoginProps): boolean => {
  return !data.email || !data.password ? true : false;
};

export const validateRegisterForm = (data: RegisterProps): boolean => {
  if (!data.email || !data.password || !data.confirmPassword) return true;
  return false;
};

export const validateEmailFormat = (
  email: string,
  callback: Dispatch<SetStateAction<LoginProps | RegisterProps>>
) => {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(email)) {
    callback((prev) => ({
      ...prev,
      email: "Ingrese un email válido",
    }));
  } else {
    callback((prev) => ({
      ...prev,
      email: "",
    }));
  }
};

export const validatePassword = (
  password: string,
  confirmPassword: string,
  callback: Dispatch<SetStateAction<LoginProps | RegisterProps>>
) => {
  if (password.length < 6) {
    callback((prev) => ({
      ...prev,
      password: "La contraseña demasiado corta",
    }));
  } else if (password !== confirmPassword) {
    callback((prev) => ({
      ...prev,
      password: "Las contraseñas no coinciden",
      confirmPassword: "Las contraseñas no coinciden",
    }));
  } else {
    callback((prev) => ({
      ...prev,
      password: "",
      confirmPassword: "",
    }));
  }
};
