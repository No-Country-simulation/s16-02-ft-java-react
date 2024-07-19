"use client";
import React, { ChangeEvent, useState } from "react";
import logo from "../../../assets/logo-horizontal.png";
import img from "../../../assets/carousel1.png";
import Image from "next/image";
import { Button, Input } from "@components";
import Link from "next/link";
import { RegisterProps, RegisterProfileProps } from "@types";
import { isValidEmailFormat, isValidPasswordFormat, isValidForm } from "@utils";
import { useRouter } from "next/navigation";

const initalProps: RegisterProps = {
  email: "",
  password: "",
  confirmPassword: "",
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
  const [registerForm, setRegisterForm] = useState<RegisterProps>(initalProps);
  const [registerProfile, setRegisterProfile] =
    useState<RegisterProfileProps>(initalProfileProps);
  const [errors, setErrors] = useState<RegisterProps>(initalProps);
  const [nav, setNav] = useState(0);
  const [isLoading, setIsLoading] = useState<boolean>(false);

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

    try {
      setIsLoading(true);
      if (nav !== 3) {
        const response = await fetch(
          `http://localhost:8090/api/auth/register`,
          {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify({
              username: registerForm.email,
              password: registerForm.password,
              roleName: nav === 2 ? "ROLE_SHELTER" : "ROLE_USER",
              active: true,
            }),
          }
        );

        if (!response.ok) {
          setIsLoading(false);
          throw new Error("Register failed");
        }

        const data = await response.json();
        localStorage.setItem("id", data.userId);
        setIsLoading(false);
        console.log(data);
        if (nav === 2) setNav(3);
      } else {
        const response = await fetch(`http://localhost:8090/api/profiles`, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            profileName: registerProfile.name,
            profileLastName: registerProfile.lastname,
            profilePhone: registerProfile.phone,
            profileDocumentType: registerProfile.documentType,
            profileDocumentNumber: registerProfile.documentNumber,
            profileAddress: registerProfile.address,
            user: {
              userId: localStorage.getItem("id"),
            },
            profileImgDocument:
              "https://w7.pngwing.com/pngs/178/595/png-transparent-user-profile-computer-icons-login-user-avatars-thumbnail.png",
            district: {
              districtId: Number(registerProfile.district),
            },
            active: true,
          }),
        });

        if (!response.ok) {
          setIsLoading(false);
          throw new Error("Register failed");
        }

        setIsLoading(false);
        router.push("/auth/login");
      }
    } catch (error) {
      console.log("error", error);
      setIsLoading(false);
    }
  };

  return (
    <div className="registerPage">
      <div className="registerPage__picture">
        <Image src={logo} alt="header logo" />
      </div>
      {nav === 0 && (
        <div className="registerPage__wrapper">
          <h3>Selección de perfil</h3>
          <div className="registerPage__wrapper--form">
            <div className="form">
              <div className="card">
                <Image src={img} alt="picture from user type" />
                <div className="card-content">
                  <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Maxime deleniti repellat veritatis recusandae voluptatibus
                    possimus modi? Deserunt ad repellendus necessitatibus atque
                  </p>
                  <Button color="primary" onClick={() => setNav(1)}>
                    tipo 1
                  </Button>
                </div>
              </div>
              <div className="card">
                <Image src={img} alt="picture from user type" />
                <div className="card-content">
                  <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Maxime deleniti repellat veritatis recusandae voluptatibus
                    possimus modi? Deserunt ad repellendus necessitatibus atque
                  </p>
                  <Button color="primary" onClick={() => setNav(2)}>
                    tipo 2
                  </Button>
                </div>
              </div>
            </div>
          </div>
          <div className="registerPage__wrapper--options">
            <div className="options-link">
              <span>Ya tienes cuenta?</span>
              <Link href={"/auth/login"}>Iniciar Sesión</Link>
            </div>
          </div>
        </div>
      )}

      {nav === 1 && (
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
              <Link href={"/auth/login"}>Iniciar Sesión</Link>
            </div>
          </div>
        </div>
      )}
      {nav === 2 && (
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
              color="primary"
              type="submit"
              onClick={handleSubmit}
              isDisabled={isValidForm(registerForm)}
              isLoading={isLoading}
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
      {nav === 3 && (
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
            <Input
              name="documentType"
              label="Tipo de documento"
              placeholder="Ingrese su documento"
              type="text"
              value={registerProfile.documentType}
              onChange={handleChangeProfile}
            />
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
