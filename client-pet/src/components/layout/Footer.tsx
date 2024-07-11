import React from "react";
import { Button, Input } from "@components";
import Link from "next/link";
import img from "../../assets/logo-horizontal.png";
import Image from "next/image";

const Footer = () => {
  return (
    <footer>
      <div className="footer">
        <div className="footer__logo">
          <div className="footer__logo--picture">
            <Image src={img} alt="footer logo horizintal" />
          </div>
          <div className="footer__logo--newsletter">
            <span>Suscríbete</span>
            <div className="input-footer">
              <Input
                name="email"
                placeholder="Ingresa tu correo"
                type="email"
              />
              <Button color="primary" isBordered={false}>
                {">"}
              </Button>
            </div>
          </div>
        </div>
        <div className="footer__nav">
          <ul>
            <li className="label">Adopta</li>
            <li>
              <Link href={"/"}>Gatos</Link>
            </li>
            <li>
              <Link href={"/"}>Perros</Link>
            </li>
          </ul>
          <ul>
            <li className="label">Sobre</li>
            <li>
              <Link href={"/"}>Historia</Link>
            </li>
            <li>
              <Link href={"/"}>Equipo</Link>
            </li>
          </ul>
          <ul>
            <li className="label">Ayudar</li>
            <li>
              <Link href={"/"}>Donar</Link>
            </li>
            <li>
              <Link href={"/"}>Ser voluntario</Link>
            </li>
          </ul>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
