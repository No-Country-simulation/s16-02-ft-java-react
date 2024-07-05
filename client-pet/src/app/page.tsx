import { Navbar, Footer, Hero, About } from "@components";
import AdoptionPets from "components/sections/AdoptionPets";
import Blog from "components/sections/Blog";
import Testimonials from "components/sections/Testimonials";

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
