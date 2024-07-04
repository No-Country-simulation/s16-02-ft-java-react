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
        {/* <div className="authLayout__sideform--wrapper"> */}
        {/*   <div className="picture"> */}
        {/*     <Image src={logo} alt="logo" /> */}
        {/*   </div> */}
        {/*   <div className="form"> */}
        {/*     <h3>Es bueno verde de nuevo!</h3> */}
        {/*     <input placeholder="Ingrese su corrreo" /> */}
        {/*     <input placeholder="Ingrese su contraseña" /> */}
        {/*     <div className="form-options"> */}
        {/*       <span>Recordar contraseña</span> */}
        {/*       <span>Olvidaste tu contraseña?</span> */}
        {/*     </div> */}
        {/*     <button>Iniciar Sesión</button> */}
        {/*   </div> */}
        {/*   <Link href={"/auth/register"}>Crear cuenta</Link> */}
        {/* </div> */}
      </div>
    </div>
  );
};

export default AuthLayout;
