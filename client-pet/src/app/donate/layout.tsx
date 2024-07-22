import React from "react";
import { Footer, Navbar } from "@components";
import { LayoutProps } from "@types";

const DonateLayout = ({ children }: LayoutProps) => {
  return (
    <div>
      <Navbar />
      {children}
      <Footer />
    </div>
  );
};

export default DonateLayout;
