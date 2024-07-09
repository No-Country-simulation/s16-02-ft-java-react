import React from "react";
import logo from "../../../assets/logo-horizontal.png";
import Image from "next/image";
import { Button, Input } from "@components";
import Link from "next/link";

const RegisterPage = () => {
  return (
    <div className="registerPage">
      <div className="registerPage__picture">
        <Image src={logo} alt="header logo" />
      </div>
      <div className="registerPage__wrapper">
        <h3>Registro de Usuario</h3>
        <div className="registerPage__wrapper--form">
          <Input name="name" label="Nombre" placeholder="Nombre" type="text" />
          <Input
            name="lastname"
            label="Apellidos"
            placeholder="Apellido"
            type="text"
          />
          <Input
            name="email"
            label="Correo"
            placeholder="Ingresu su correo"
            type="email"
          />
          <Input
            name="phone"
            label="Telefono"
            placeholder="Némero de telefono"
            type="text"
          />
          <Input
            name="password"
            label="Contraseña"
            placeholder="Ingrese una contraseña"
            type="password"
          />
          <Input
            name="confirmPassword"
            label="Confirmar Contraseña"
            placeholder="Confirme la contraseña"
            type="password"
          />
        </div>
        <div className="registerPage__wrapper--options">
          <label className="options-terms">
            <input type="checkbox" checked />
            <span className="label-text">
              Acepto los términos y condiciones
            </span>
          </label>
          <Button color="primary">Crear Cuena</Button>
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
