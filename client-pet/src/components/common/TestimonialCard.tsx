import React from "react";
import img from "../../assets/carousel1.png";
import Image from "next/image";

const TestimonialCard = () => {
  return (
    <div className="testimonialCard">
      <div className="testimonialCard__picture">
        <Image src={img} alt="img from testimonial card" />
      </div>
      <div className="testimonialCard__content">
        <header className="testimonialCard__content--header">
          <label>Malena y Pablo</label>
          <span>Adoptantes de Milo</span>
        </header>
        <p>
          Cuando encontramos a Milo en la plataforma de adopción, no podíamos
          creer lo adorable que era. Su carita de cachorro travieso y esos ojos
          brillantes nos conquistaron al instante. Sin dudarlo, decidimos
          conocerlo en persona. Al llegar al refugio, Milo nos recibió con
          saltos y lametones, como si supiera que nosotros éramos su nueva
          familia. Desde entonces, Milo ha llenado nuestra casa de alegría y
          energía. Sus travesuras diarias y su amor incondicional nos han
          enseñado el verdadero significado de la felicidad. Adoptar a Milo fue
          la mejor decisión que pudimos tomar, y estamos agradecidos cada día
          por tenerlo en nuestras vidas.
        </p>
      </div>
    </div>
  );
};

export default TestimonialCard;
