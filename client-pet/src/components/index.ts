import dynamic from "next/dynamic";
import NavbarSkeleton from "./layout/NavbarSkeleton";

export { default as Hero } from "./sections/Hero";
export { default as About } from "./sections/About";

export { default as Input } from "./common/Input";
export { default as Button } from "./common/Button";
export { default as Card } from "./common/Card";
export { default as TestimonialCard } from "./common/TestimonialCard";
export { default as Dropdown } from "./common/Dropdowm";

// export { default as Navbar } from "./layout/Navbar";
export { default as Footer } from "./layout/Footer";

export { default as ShelterNav } from "./layout/ShelterNavbar";

export const Navbar = dynamic(() => import("./layout/Navbar"), {
  ssr: false,
  loading: NavbarSkeleton,
});
