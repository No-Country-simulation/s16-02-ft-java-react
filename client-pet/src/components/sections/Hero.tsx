import React from "react";
import img1 from "../../assets/carousel1.png";
import img2 from "../../assets/carousel2.png";
import img3 from "../../assets/carousel3.png";
import img4 from "../../assets/carousel4.png";
import Image from "next/image";
import { Button } from "@components";

const Hero = () => {
  return (
    <section className="hero">
      <div className="hero__header">
        <h1>
          Adoptar una mascota es abrir tu corazón a un nuevo miembro de la
          familia, trayendo amor y un hogar lleno de felicidad.
        </h1>
        <Button color="primary" mode="primary">
          Adopta una mascota
        </Button>
      </div>
      <div className="hero__carousel">
        <div className="hero__carousel--wrapper">
          <div className="wrapper-row">
            <div className="picture-wrapper">
              <Image src={img1} alt="carousel hero img1" />
            </div>
            <div className="picture-wrapper">
              <Image src={img2} alt="carousel hero img1" />
            </div>
            <div className="picture-wrapper">
              <Image src={img3} alt="carousel hero img1" />
            </div>
            <div className="picture-wrapper">
              <Image src={img4} alt="carousel hero img1" />
            </div>
            <div className="picture-wrapper">
              <Image src={img1} alt="carousel hero img1" />
            </div>
            <div className="picture-wrapper">
              <Image src={img2} alt="carousel hero img1" />
            </div>
            <div className="picture-wrapper">
              <Image src={img3} alt="carousel hero img1" />
            </div>
            <div className="picture-wrapper">
              <Image src={img4} alt="carousel hero img1" />
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Hero;
