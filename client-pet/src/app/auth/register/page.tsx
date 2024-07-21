"use client";
import React, { ChangeEvent, useState } from "react";
import logo from "../../../assets/logo-horizontal.png";
import img from "../../../assets/carousel1.png";
import Image from "next/image";
import { Button, Dropdown, Input } from "@components";
import Link from "next/link";
import { RegisterProps, RegisterProfileProps } from "@types";
import { isValidEmailFormat, isValidPasswordFormat, isValidForm } from "@utils";
import { useRouter } from "next/navigation";
import { useDispatch, useSelector } from "react-redux";
import {
  AppDispatch,
  RootState,
  navDefault,
  navUser,
  navUserShelter,
  registerUser,
  registerProfileUser,
} from "@store";

const initalProps: RegisterProps = {
  email: "",
  password: "",
  confirmPassword: "",
  role: "ROLE_USER",
};

const initalProfileProps: RegisterProfileProps = {
  name: "",
  lastname: "",
  phone: "",
  documentType: "",
  documentNumber: "",
  address: "",
  district: "",
};

const RegisterPage = () => {
  const router = useRouter();
  const dispatch = useDispatch<AppDispatch>();
  const { nav, status, isLoading } = useSelector(
    (state: RootState) => state.user
  );
  const [registerForm, setRegisterForm] = useState<RegisterProps>(initalProps);
  const [registerProfile, setRegisterProfile] =
    useState<RegisterProfileProps>(initalProfileProps);
  const [errors, setErrors] = useState<RegisterProps>(initalProps);

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setRegisterForm((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleChangeProfile = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setRegisterProfile((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleDocumentTypeChange = (e: any) => {
    const value = e.target.textContent;
    setRegisterProfile((prev) => ({
      ...prev,
      documentType: value,
    }));
  };

  const handleSubmit = async (e: any) => {
    e.preventDefault();
    if (
      !isValidEmailFormat(registerForm.email, setErrors) ||
      !isValidPasswordFormat(
        registerForm.password,
        registerForm.confirmPassword,
        setErrors
      )
    ) {
      return;
    }

    // switch (nav) {
    //   case "user":
    //     dispatch(registerUser(registerForm, router));
    //     break;
    //   case "user_shelter":
    //     dispatch(registerUser(registerForm, "next"));
    //     break;
    //   case "user_profile":
    //     dispatch(registerProfileUser(registerProfile, router));
    //     break;
    //   default:
    //     dispatch(navDefault());
    //     break;
    // }

    if (nav === "user") dispatch(registerUser(registerForm, router));
    if (nav === "user_shelter") dispatch(registerUser(registerForm, "next"));
    if (nav === "user_profile")
      dispatch(registerProfileUser(registerProfile, router));
  };

  return (
    <div className="registerPage">
      <div className="registerPage__picture">
        <Image src={logo} alt="header logo" />
      </div>
      {nav === "select" && (
        <div className="registerPage__wrapper">
          <h3>Selección de perfil</h3>
          <div className="registerPage__wrapper--form">
            <div className="form">
              <div className="card">
                <Image src={img} alt="picture from user type" />
                <div className="card-content">
                  <span className="title">Soy adoptante/usuario</span>
                  <p>
                    Publica anuncios de mascotas perdidas y encuentra a tu
                    compañero. También puedes adoptar y darles un hogar amoroso
                    a quienes lo necesitan.
                  </p>
                  <Button
                    color="secondary"
                    onClick={() => {
                      dispatch(navUser());
                      setRegisterForm((prev) => ({
                        ...prev,
                        role: "ROLE_USER",
                      }));
                    }}
                  >
                    Seleccionar
                  </Button>
                </div>
              </div>
              <div className="card">
                <Image src={img} alt="picture from user type" />
                <div className="card-content">
                  <span className="title">Soy parte de un refugio</span>
                  <p>
                    Publica mascotas para adopción y lleva un seguimiento. Ayuda
                    a encontrar hogares amorosos para cada animal en tu refugio.
                  </p>
                  <Button
                    color="secondary"
                    onClick={() => {
                      dispatch(navUserShelter());
                      setRegisterForm((prev) => ({
                        ...prev,
                        role: "ROLE_SHELTER",
                      }));
                    }}
                  >
                    Seleccionar
                  </Button>
                </div>
              </div>
            </div>
          </div>
          <div className="registerPage__wrapper--options">
            <div className="options-link">
              <span>Ya tienes cuenta?</span>
              <Link href={"/auth/login"} onClick={() => dispatch(navDefault())}>
                Iniciar Sesión
              </Link>
            </div>
          </div>
        </div>
      )}

      {nav === "user" && (
        <div className="registerPage__wrapper">
          <h3>Registro de Usuario 1</h3>
          <div className="registerPage__wrapper--form">
            <Input
              name="email"
              label="Correo"
              placeholder="Ingresu su correo"
              type="email"
              value={registerForm.email}
              onChange={handleChange}
              isInvalid={errors.email}
            />
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
              isDisabled={isValidForm(registerForm)}
              isLoading={isLoading}
            >
              Crear Cuena
            </Button>
            <div className="options-link">
              <span>Ya tienes cuenta?</span>
              <Link href={"/auth/login"} onClick={() => dispatch(navDefault())}>
                Iniciar Sesión
              </Link>
            </div>
          </div>
        </div>
      )}
      {nav === "user_shelter" && (
        <div className="registerPage__wrapper">
          <h3>Registro de Usuario 1</h3>
          <div className="registerPage__wrapper--form">
            <Input
              name="email"
              label="Correo"
              placeholder="Ingresu su correo"
              type="email"
              value={registerForm.email}
              onChange={handleChange}
              isInvalid={errors.email}
            />
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
            <Button
              color="secondary"
              type="submit"
              onClick={handleSubmit}
              isDisabled={isValidForm(registerForm)}
              isLoading={isLoading}
              loadingMessage="Creando perfil..."
            >
              Siguiente
            </Button>
            <div className="options-link">
              <span>Ya tienes cuenta?</span>
              <Link href={"/auth/login"}>Iniciar Sesión</Link>
            </div>
          </div>
        </div>
      )}
      {nav === "user_profile" && (
        <div className="registerPage__wrapper">
          <h3>Registro de Usuario 2</h3>
          <div className="registerPage__wrapper--form">
            <Input
              name="name"
              label="Nombre"
              placeholder="Ingresu su nombre"
              type="text"
              value={registerProfile.name}
              onChange={handleChangeProfile}
            />
            <Input
              name="lastname"
              label="Apellidos"
              placeholder="Ingresu sus apellidos"
              type="text"
              value={registerProfile.lastname}
              onChange={handleChangeProfile}
            />
            <Input
              name="phone"
              label="Telefono"
              placeholder="Ingrese una telefono"
              type="text"
              value={registerProfile.phone}
              onChange={handleChangeProfile}
            />
            <br />
            <Dropdown
              options={["DNI", "CarnetExtranjeria", "Pasaporte"]}
              value={registerProfile.documentType}
              onSelect={handleDocumentTypeChange}
            />
            {/* <Input */}
            {/*   name="documentType" */}
            {/*   label="Tipo de documento" */}
            {/*   placeholder="Ingrese su documento" */}
            {/*   type="text" */}
            {/*   value={registerProfile.documentType} */}
            {/*   onChange={handleChangeProfile} */}
            {/* /> */}
            <Input
              name="documentNumber"
              label="Número de documento"
              placeholder="Ingrese su documento"
              type="text"
              value={registerProfile.documentNumber}
              onChange={handleChangeProfile}
            />
            <Input
              name="address"
              label="Dirección"
              placeholder="Ingrese su dirección"
              type="text"
              value={registerProfile.address}
              onChange={handleChangeProfile}
            />
            <Input
              name="district"
              label="Distrito"
              placeholder="Ingrese su dirección"
              type="text"
              value={registerProfile.district}
              onChange={handleChangeProfile}
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
              isDisabled={isValidForm(registerProfile)}
              isLoading={isLoading}
              loadingMessage="Creando cuenta..."
            >
              Crear Cuena
            </Button>
            <div className="options-link">
              <span>Ya tienes cuenta?</span>
              <Link href={"/auth/login"}>Iniciar Sesión</Link>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default RegisterPage;
