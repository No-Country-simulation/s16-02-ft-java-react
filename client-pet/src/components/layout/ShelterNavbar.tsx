"use client";
import Link from "next/link";
import React from "react";
import img from "../../assets/logo-horizontal.png";
import Image from "next/image";
import { AppDispatch, logout } from "store";
import { useDispatch } from "react-redux";
import { useRouter } from "next/navigation";

const menu = [
  {
    id: 1,
    name: "Home",
    href: "/shelter",
  },
  {
    id: 2,
    name: "Refugio",
    href: "/shelter/manage",
  },

  {
    id: 4,
    name: "Mascotas",
    href: "/shelter/pets",
  },
  {
    id: 5,
    name: "Perfil",
    href: "/shelter/profile",
  },
  {
    id: 6,
    name: "Solicitudes de adopción",
    href: "/shelter/request",
  },
];

const ShelterNav = () => {
  const dispatch = useDispatch<AppDispatch>();
  const router = useRouter();
  return (
    <div className="shelterNav">
      <div className="shelterNav__logo">
        <Link href={"/"}>
          <Image src={img} alt="header shelter image" />
        </Link>
      </div>
      <div className="shelterNav__menu">
        <ul>
          {menu.map(({ id, name, href }) => (
            <li key={id}>
              <Link href={href}>{name}</Link>
            </li>
          ))}
          <li>
            <button
              onClick={() => {
                dispatch(logout(router));
              }}
            >
              Cerrar Sesión
            </button>
          </li>
        </ul>
      </div>
    </div>
  );
};

export default ShelterNav;
