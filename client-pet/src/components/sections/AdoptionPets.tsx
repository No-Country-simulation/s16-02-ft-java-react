import React from "react";
import img from "../../assets/adop7.jpg";
import Image from "next/image";

const AdoptionPets = () => {
  return (
    <section className="adoptionPets">
      <header className="adoptionPets__header">
        <h2>Algunos de nuestros amigos que buscan un hogar</h2>
      </header>
      <div className="adoptionPets__gallery">
        <div className="adoptionPets__gallery--card">
          <Image src={img} alt="adoption pet gallery item" />
          <div className="card-content">
            <label>Name Pet</label>
          </div>
        </div>
        <div className="adoptionPets__gallery--card">
          <Image src={img} alt="adoption pet gallery item" />
          <div className="card-content">
            <label>Name Pet</label>
          </div>
        </div>
        <div className="adoptionPets__gallery--card">
          <Image src={img} alt="adoption pet gallery item" />
          <div className="card-content">
            <label>Name Pet</label>
          </div>
        </div>
        <div className="adoptionPets__gallery--card">
          <Image src={img} alt="adoption pet gallery item" />
          <div className="card-content">
            <label>Name Pet</label>
          </div>
        </div>
        <div className="adoptionPets__gallery--card">
          <Image src={img} alt="adoption pet gallery item" />
          <div className="card-content">
            <label>Name Pet</label>
          </div>
        </div>
        <div className="adoptionPets__gallery--card">
          <Image src={img} alt="adoption pet gallery item" />
          <div className="card-content">
            <label>Name Pet</label>
          </div>
        </div>
      </div>
    </section>
  );
};

export default AdoptionPets;
