import React from "react";
import { LayoutProps } from "@types";

const PetsShelterLayout = ({ children }: LayoutProps) => {
  return (
    <div className="shelterPanel">
      <div className="shelterPanel__header">
        <header>
          <h1>Mascotas en adopción.</h1>
        </header>
      </div>
      {children}
    </div>
  );
};

export default PetsShelterLayout;
