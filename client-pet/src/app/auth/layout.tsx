import React from "react";
import { LayoutProps } from "@types";
import Image from "next/image";
import loginbg from "../../assets/loginbg.png";
import Link from "next/link";
import { ArrowBarLeft } from "@icons";

const AuthLayout = ({ children }: LayoutProps) => {
  return (
    <div className="authLayout">
      <div className="authLayout__picture">
        <Image src={loginbg} alt="login background" />
      </div>
      <div className="authLayout__sideform">
        <Link className="nav-link" href={"/"}>
          <span>
            <ArrowBarLeft />
          </span>
          Volver a Inicio
        </Link>

        {children}
      </div>
    </div>
  );
};

export default AuthLayout;
