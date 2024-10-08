"use client";
import React from "react";
import Link from "next/link";
import logo from "../../assets/logo-horizontal.png";
import Image from "next/image";
import { useDispatch, useSelector } from "react-redux";
import { RootState, AppDispatch, logout, navDefault, defaultPet } from "@store";
import { Button } from "@components";
import { useRouter } from "next/navigation";

const menu = [
  {
    id: 1,
    name: "Inicio",
    href: "/",
  },
  {
    id: 2,
    name: "Adopta",
    href: "/adopt",
  },
  {
    id: 3,
    name: "Donar",
    href: "/donate",
  },
  {
    id: 4,
    name: "Blog",
    href: "/blog",
  },
];

const Navbar = () => {
  const dispatch = useDispatch<AppDispatch>();
  const router = useRouter();
  const { isLoading, user } = useSelector((state: RootState) => state.auth);
  const { role } = user;

  return (
    <nav className="main-navbar">
      <Link href={"/"} className="main-navbar__logo">
        <Image src={logo} alt="header logo" />
      </Link>
      <ul className="main-navbar__menu">
        {menu.map(({ id, name, href }) => (
          <li key={id}>
            <Link href={href}>{name}</Link>
          </li>
        ))}
      </ul>
      {role === "ROLE_USER" && (
        <div className="main-navbar__auth">
          <Link href={"/profile"} className="button button__secondary border">
            Perfil de Usuario
          </Link>
          <Button
            color="secondary"
            onClick={() => {
              dispatch(navDefault());
              dispatch(logout(router));
              router.push("/");
            }}
            isLoading={isLoading}
          >
            Cerrar Sesión
          </Button>
        </div>
      )}

      {role === "ROLE_SHELTER" && (
        <div className="main-navbar__auth">
          <Link href={"/shelter"} className="button button__secondary border">
            Perfil de Refugio
          </Link>
          <Button
            color="secondary"
            onClick={() => {
              dispatch(navDefault());
              dispatch(logout(router));
            }}
            isLoading={isLoading}
          >
            Cerrar Sesión
          </Button>
        </div>
      )}

      {!role && (
        <div className="main-navbar__auth">
          <Link
            href={"/auth/login"}
            className="button button__secondary border pink"
          >
            Iniciar Sesión
          </Link>
          <Link
            href={"/auth/register"}
            onClick={() => {
              dispatch(navDefault());
            }}
            className="button button__secondary border pink"
          >
            Crear Cuenta
          </Link>
        </div>
      )}
    </nav>
  );
};

export default Navbar;
