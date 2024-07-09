import React from "react";
import { LayoutProps } from "types";
import { Navbar, Footer } from "@components";

const CuidadoLayout = ({ children }: LayoutProps) => {
  return (
    <div>
      <Navbar />
      {children}
      <Footer />
    </div>
  );
};

export default CuidadoLayout;
