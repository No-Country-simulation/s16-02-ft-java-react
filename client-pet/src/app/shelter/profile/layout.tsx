import React from "react";
import { LayoutProps } from "@types";

const ProfileShelterLayout = ({ children }: LayoutProps) => {
  return (
    <div className="shelterPanel">
      <div className="shelterPanel__header">
        <header>
          <h1>Perfil de usuario.</h1>
        </header>
      </div>
      {children}
    </div>
  );
};

export default ProfileShelterLayout;
