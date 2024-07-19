"use client";
import React, { ChangeEvent, useState } from "react";
import Image from "next/image";
import Link from "next/link";
import logo from "../../../assets/logosphere.png";
import { Button, Input } from "@components";
import { LoginProps } from "@types";
import { isValidEmailFormat, isValidForm } from "@utils";
import { fetchAPI } from "@helpers";

const initialState: LoginProps = {
  email: "",
  password: "",
};

const LoginPage = () => {
  const [loginForm, setLoginForm] = useState(initialState);
  const [errors, setErrors] = useState(initialState);
  const [isLoading, setIsLoading] = useState(false);

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setLoginForm((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleSubmit = async (e: any) => {
    e.preventDefault();
    if (!isValidEmailFormat(loginForm.email, setErrors)) return;

    try {
      setIsLoading(true);
      const response = await fetchAPI("api/login", "POST", {
        username: loginForm.email,
        password: loginForm.password,
      });

      sessionStorage.setItem("token", response.token);
      console.log("Login Success.");
      setIsLoading(false);
    } catch (error) {
      console.log(error);
      setIsLoading(false);
    }
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
          isInvalid={errors.email}
        />
        <Input
          isRequired
          name="password"
          label="Contraseña"
          placeholder="Ingrese su contraseña"
          type="password"
          value={loginForm.password}
          onChange={handleChange}
          isInvalid={errors.password}
        />
        <div className="form-options">
          <span>Recordar contraseña</span>
          <span>Olvidaste tu contraseña?</span>
        </div>
        <Button
          color="primary"
          type="submit"
          onClick={handleSubmit}
          isDisabled={isValidForm(loginForm)}
          isLoading={isLoading}
        >
          Iniciar Sesión
        </Button>
      </div>
      <div className="loginPage__register">
        <span>Aun no tienes cuenta?</span>
        <Link href={"/auth/register"}>Crear cuenta</Link>
      </div>
    </div>
  );
};

export default LoginPage;
