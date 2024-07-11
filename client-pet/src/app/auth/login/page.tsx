"use client";
import React, { ChangeEvent, useState } from "react";
import Image from "next/image";
import Link from "next/link";
import logo from "../../../assets/logosphere.png";
import { Button, Input } from "@components";

const LoginPage = () => {
  const [loginForm, setLoginForm] = useState({
    email: "",
    password: "",
  });

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setLoginForm((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  return (
    <div className="loginPage">
      <div className="loginPage__picture">
        <Image src={logo} alt="logo" />
      </div>
      <div className="loginPage__form">
        <h3>Es bueno verte de nuevo!</h3>
        <Input
          isRequired
          name="email"
          label="Email"
          placeholder="Ingrese su correo"
          type="text"
          value={loginForm.email}
          onChange={handleChange}
        />
        <Input
          isRequired
          name="password"
          label="Contraseña"
          placeholder="Ingrese su contraseña"
          type="password"
          value={loginForm.password}
          onChange={handleChange}
        />
        <div className="form-options">
          <span>Recordar contraseña</span>
          <span>Olvidaste tu contraseña?</span>
        </div>
        <Button color="primary">Iniciar Sesión</Button>
      </div>
      <div className="loginPage__register">
        <span>Aun no tienes cuenta?</span>
        <Link href={"/auth/register"}>Crear cuenta</Link>
      </div>
    </div>
  );
};

export default LoginPage;
