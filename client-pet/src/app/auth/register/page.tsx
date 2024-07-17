"use client";
import React, { ChangeEvent, useState } from "react";
import logo from "../../../assets/logo-horizontal.png";
import Image from "next/image";
import { Button, Input } from "@components";
import Link from "next/link";
import { RegisterProps } from "@types";
import {
  validateEmailFormat,
  validatePassword,
  validateRegisterForm,
} from "@utils";

const initalProps: RegisterProps = {
  email: "",
  password: "",
  confirmPassword: "",
};

const RegisterPage = () => {
  const [registerForm, setRegisterForm] = useState(initalProps);
  const [errors, setErrors] = useState(initalProps);

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setRegisterForm((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = (e: any) => {
    e.preventDefault();
    validateEmailFormat(registerForm.email, setErrors);
    validatePassword(
      registerForm.password,
      registerForm.confirmPassword,
      setErrors
    );
  };

  return (
    <div className="registerPage">
      <div className="registerPage__picture">
        <Image src={logo} alt="header logo" />
      </div>
      <div className="registerPage__wrapper">
        <h3>Registro de Usuario</h3>
        <div className="registerPage__wrapper--form">
          {/* <Input name="name" label="Nombre" placeholder="Nombre" type="text" /> */}
          {/* <Input */}
          {/*   name="lastname" */}
          {/*   label="Apellidos" */}
          {/*   placeholder="Apellido" */}
          {/*   type="text" */}
          {/* /> */}
          <Input
            name="email"
            label="Correo"
            placeholder="Ingresu su correo"
            type="email"
            value={registerForm.email}
            onChange={handleChange}
            isInvalid={errors.email}
          />
          {/* <Input */}
          {/*   name="phone" */}
          {/*   label="Telefono" */}
          {/*   placeholder="Némero de telefono" */}
          {/*   type="text" */}
          {/* /> */}
          <Input
            name="password"
            label="Contraseña"
            placeholder="Ingrese una contraseña"
            type="password"
            value={registerForm.password}
            onChange={handleChange}
            isInvalid={errors.password}
          />
          <Input
            name="confirmPassword"
            label="Confirmar Contraseña"
            placeholder="Confirme la contraseña"
            type="password"
            value={registerForm.confirmPassword}
            onChange={handleChange}
            isInvalid={errors.confirmPassword}
          />
        </div>
        <div className="registerPage__wrapper--options">
          <label className="options-terms">
            <input type="checkbox" defaultChecked={false} />
            <span className="label-text">
              Acepto los términos y condiciones
            </span>
          </label>
          <Button
            color="primary"
            type="submit"
            onClick={handleSubmit}
            isDisabled={validateRegisterForm(registerForm)}
          >
            Crear Cuena
          </Button>
          <div className="options-link">
            <span>Ya tienes cuenta?</span>
            <Link href={"/auth/login"}>Iniciar Sesión</Link>
          </div>
        </div>
      </div>
    </div>
  );
};

export default RegisterPage;
