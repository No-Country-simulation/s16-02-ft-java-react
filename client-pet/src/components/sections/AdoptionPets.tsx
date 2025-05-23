import React from "react";
import img from "../../assets/adop7.jpg";
import img2 from "../../assets/pets/pexels-pixabay-160839.jpg";
import img3 from "../../assets/pets/pexels-pixabay-257519.jpg";
import img4 from "../../assets/pets/pexels-shvetsa-4587993.jpg";
import img5 from "../../assets/pets/pexels-jhelmuth-3995452.jpg";
import img6 from "../../assets/pets/pexels-katlovessteve-551628.jpg";
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
          <Image src={img2} alt="adoption pet gallery item" />
          <div className="card-content">
            <label>Name Pet</label>
          </div>
        </div>
        <div className="adoptionPets__gallery--card">
          <Image src={img3} alt="adoption pet gallery item" />
          <div className="card-content">
            <label>Name Pet</label>
          </div>
        </div>
        <div className="adoptionPets__gallery--card">
          <Image src={img4} alt="adoption pet gallery item" />
          <div className="card-content">
            <label>Name Pet</label>
          </div>
        </div>
        <div className="adoptionPets__gallery--card">
          <Image src={img5} alt="adoption pet gallery item" />
          <div className="card-content">
            <label>Name Pet</label>
          </div>
        </div>
        <div className="adoptionPets__gallery--card">
          <Image src={img6} alt="adoption pet gallery item" />
          <div className="card-content">
            <label>Name Pet</label>
          </div>
        </div>
      </div>
    </section>
  );
};

export default AdoptionPets;
