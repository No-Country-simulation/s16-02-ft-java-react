import React from "react";
import { LayoutProps } from "types";
import { ShelterNav } from "@components";

const ShelterLayout = ({ children }: LayoutProps) => {
  return (
    <div>
      <ShelterNav />
      {children}
      {/* <Footer /> */}
    </div>
  );
};

export default ShelterLayout;
