"use client";
import React, { ChangeEvent, useState } from "react";
import Image from "next/image";
import Link from "next/link";
import { useRouter } from "next/navigation";
import logo from "../../../assets/logosphere.png";
import { Button, Input } from "@components";
import { LoginProps } from "@types";
import { isValidEmailFormat, isValidForm } from "@utils";
import { AppDispatch, login, navDefault, RootState } from "@store";
import { useDispatch, useSelector } from "react-redux";

const initialState: LoginProps = {
  email: "",
  password: "",
};

const LoginPage = () => {
  const dispatch = useDispatch<AppDispatch>();
  const { isLoading } = useSelector((state: RootState) => state.auth);

  const router = useRouter();
  const [loginForm, setLoginForm] = useState(initialState);
  const [errors, setErrors] = useState(initialState);

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
    dispatch(login(loginForm, router));
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
        <Link href={"/auth/register"} onClick={() => dispatch(navDefault())}>
          Crear cuenta
        </Link>
      </div>
    </div>
  );
};

export default LoginPage;
