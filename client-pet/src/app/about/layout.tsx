import React from "react";
import { Footer, Navbar } from "@components";
import { LayoutProps } from "@types";

const AboutLayout = ({ children }: LayoutProps) => {
  return (
    <div>
      <Navbar />
      {children}
      <Footer />
    </div>
  );
};

export default AboutLayout;
