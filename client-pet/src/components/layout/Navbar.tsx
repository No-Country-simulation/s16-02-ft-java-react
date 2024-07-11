import React from "react";
import Link from "next/link";
import logo from "../../assets/logo-horizontal.png";
import Image from "next/image";

const Navbar = () => {
  return (
    <nav className="main-navbar">
      <Link href={"/"} className="main-navbar__logo">
        <Image src={logo} alt="header logo" />
      </Link>
      <ul className="main-navbar__menu">
        <li>
          <Link href={"/about"}>Nostros</Link>
        </li>
        <li>
          <Link href={"/adopcion"}>Adopcion</Link>
        </li>
        <li>
          <Link href={"/cuidado"}>Cuidado</Link>
        </li>
        <li>
          <Link href={"/rescate"}>Rescate</Link>
        </li>
        <li>
          <Link href={"/blog"}>Blog</Link>
        </li>
        <li>
          <Link href={"/donar"}>Donar</Link>
        </li>
      </ul>
      <div className="main-navbar__auth">
        <Link href={"/auth/login"} className="button button__primary border">
          Iniciar Sesión
        </Link>
        <Link href={"/auth/register"} className="button button__primary border">
          Crear Cuenta
        </Link>
      </div>
    </nav>
  );
};

export default Navbar;
