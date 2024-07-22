"use client";
import Link from "next/link";
import React from "react";
import img from "../../assets/logosphere.png";
import Image from "next/image";
import { AppDispatch, logout } from "store";
import { useDispatch } from "react-redux";
import { useRouter } from "next/navigation";

const menu = [
  {
    id: 1,
    name: "Home",
    href: "/",
  },
  {
    id: 2,
    name: "Refugio",
    href: "/shelter",
  },
  {
    id: 3,
    name: "Perfil",
    href: "/shelter/profile",
  },
  {
    id: 4,
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
            <button
              onClick={() => {
                dispatch(logout());
                router.push("/");
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
