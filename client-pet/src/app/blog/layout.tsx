import React from "react";
import { Footer, Navbar } from "@components";
import { LayoutProps } from "@types";

const BlogLayout = ({ children }: LayoutProps) => {
  return (
    <div>
      <Navbar />
      {children}
      <Footer />
    </div>
  );
};

export default BlogLayout;
