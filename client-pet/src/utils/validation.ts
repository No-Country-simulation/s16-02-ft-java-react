import { Dispatch, SetStateAction } from "react";
import { LoginProps, RegisterProps } from "@types";

export const isValidForm = (formData: any) => {
  return !Object.values(formData).every((value) => value !== "");
};

export const isValidEmailFormat = (
  email: string,
  callback: Dispatch<SetStateAction<LoginProps | RegisterProps>>
) => {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(email)) {
    callback((prev) => ({
      ...prev,
      email: "Ingrese un email válido",
    }));
    return false;
  } else {
    callback((prev) => ({
      ...prev,
      email: "",
    }));
    return true;
  }
};

export const isValidPasswordFormat = (
  password: string,
  confirmPassword: string,
  callback: Dispatch<SetStateAction<LoginProps | RegisterProps>>
) => {
  if (password.length < 6) {
    callback((prev) => ({
      ...prev,
      password: "La contraseña demasiado corta",
    }));
    return false;
  } else if (password !== confirmPassword) {
    callback((prev) => ({
      ...prev,
      password: "Las contraseñas no coinciden",
      confirmPassword: "Las contraseñas no coinciden",
    }));
    return false;
  } else {
    callback((prev) => ({
      ...prev,
      password: "",
      confirmPassword: "",
    }));
    return true;
  }
};
