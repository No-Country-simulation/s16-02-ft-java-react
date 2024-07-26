import React from "react";
import { LayoutProps } from "@types";

const RequestsShelterLayout = ({ children }: LayoutProps) => {
  return (
    <div className="shelterPanel">
      <div className="shelterPanel__header">
        <header>
          <h1>Solicitudes de Adopción.</h1>
        </header>
      </div>
      {children}
    </div>
  );
};

export default RequestsShelterLayout;

