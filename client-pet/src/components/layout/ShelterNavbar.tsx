import Link from "next/link";
import React from "react";
import img from "../../assets/logosphere.png";
import Image from "next/image";

const menu = [
  {
    id: 1,
    name: "Home",
    href: "/",
  },
  {
    id: 1,
    name: "Perfil",
    href: "/profile",
  },
  {
    id: 1,
    name: "Solicitudes de adopción",
    href: "/adoption-request",
  },
];

const ShelterNav = () => {
  return (
    <div className="shelterNav">
      <div className="shelterNav__logo">
        <Image src={img} alt="header shelter image" />
      </div>
      <div className="shelterNav__menu">
        <ul>
          {menu.map(({ id, name, href }) => (
            <li key={id}>
              <Link href={href}>{name}</Link>
            </li>
          ))}
          <li>
            <button>Cerrar Sesión</button>
          </li>
        </ul>
      </div>
    </div>
  );
};

export default ShelterNav;
