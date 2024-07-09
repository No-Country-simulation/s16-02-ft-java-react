import Link from "next/link";
import React from "react";

const Navbar = () => {
  return (
    <nav className="main-navbar">
      <ul className="main-navbar__menu">
        <li>
          <Link href={"/"}>Home</Link>
        </li>
        <li>
          <Link href={"/adopcion"}>Adopcion</Link>
        </li>
        <li>
          <Link href={"/cuidado"}>Cuidado</Link>
        </li>
      </ul>
      <div className="main-navbar__auth">
        <Link href={"/auth/login"}>Iniciar Sesión</Link>
        <Link href={"/auth/register"}>Crear Cuenta</Link>
      </div>
    </nav>
  );
};

export default Navbar;
