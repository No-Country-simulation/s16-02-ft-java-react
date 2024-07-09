import Image from "next/image";
import React from "react";
import { Button } from "@components";
import about1 from "../../assets/about1.png";
import about2 from "../../assets/about2.png";

const About = () => {
  return (
    <section className="about">
      <div className="about__pictures">
        <div className="about__pictures--figure">
          <Image src={about1} alt="about image one" />
          <p>Estoy buscando darle un hogar a un perro</p>
        </div>
        <div className="about__pictures--figure">
          <Image src={about2} alt="about image two" />
          <p>Estoy buscando darle un hogar a un gato</p>
        </div>
      </div>
      <div className="about__content">
        <h2>Sobre nosotros</h2>
        <p>
          Nuestra plataforma nació del amor por los animales y del deseo de
          darles una segunda oportunidad. Creemos firmemente en la adopción de
          mascotas como una forma de brindarles un hogar amoroso y afectuoso.
          Todo empezó cuando un grupo de amigos apasionados por el bienestar
          animal se unieron con el objetivo de facilitar el proceso de adopción
          y crear una comunidad de personas comprometidas con esta causa. La
          importancia de nuestra plataforma radica en su capacidad de conectar
          mascotas que buscan hogar con personas que quieren adoptarlas. Nos
          esforzamos por ofrecer un espacio seguro y confiable donde los
          posibles adoptantes puedan encontrar su compañero ideal y donde las
          mascotas puedan encontrar un hogar donde sean amadas y cuidadas.
        </p>
        <Button color="primary" className="about__content--button">
          CONTACTANOS
        </Button>
      </div>
    </section>
  );
};

export default About;
