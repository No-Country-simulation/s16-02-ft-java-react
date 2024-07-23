"use client";
import { Footer, Hero, About } from "@components";
import AdoptionPets from "components/sections/AdoptionPets";
import Blog from "components/sections/Blog";
import Testimonials from "components/sections/Testimonials";
import dynamic from "next/dynamic";

const Navbar = dynamic(() => import("../components/layout/Navbar"), {
  ssr: false,
});

export default function Home() {
  return (
    <>
      <Navbar />
      <main id="main-content">
        <Hero />
        <About />
        <AdoptionPets />
        <Blog />
        <Testimonials />
      </main>
      <Footer />
    </>
  );
}
