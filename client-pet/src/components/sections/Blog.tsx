import React from "react";
import img from "../../assets/adop5.png";
import Image from "next/image";
import { Button } from "@components";

const Blog = () => {
  return (
    <section className="blog">
      <header className="blog__header">
        <h2>Ultimos post en nuestro blog</h2>
      </header>
      <div className="blog__wrapper">
        <div className="blog__wrapper--card">
          <header className="card__header">
            <div className="card__header--picture">L</div>
            <div className="card__header--content">
              <div className="name">Catalina A.</div>
              <div className="date">Publicado hace 2 horas</div>
            </div>
          </header>
          <div className="card__picture">
            <Image src={img} alt="wrapper blog item" />
          </div>
          <div className="card__content">
            <h3 className="card__content--title">¿Qué comen los gatos?</h3>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus
              nostrum voluptates, aliquid necessitatibus dignissimos cum
              voluptas ullam harum nemo possimus maiores pariatur sint
              consequuntur odit et cupiditate fugit amet omnis?
            </p>
            <Button color="primary">Saber Mas</Button>
          </div>
        </div>

        <div className="blog__wrapper--card">
          <header className="card__header">
            <div className="card__header--picture">L</div>
            <div className="card__header--content">
              <div className="name">Catalina A.</div>
              <div className="date">Publicado hace 2 horas</div>
            </div>
          </header>
          <div className="card__picture">
            <Image src={img} alt="wrapper blog item" />
          </div>
          <div className="card__content">
            <h3 className="card__content--title">¿Qué comen los gatos?</h3>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus
              nostrum voluptates, aliquid necessitatibus dignissimos cum
              voluptas ullam harum nemo possimus maiores pariatur sint
              consequuntur odit et cupiditate fugit amet omnis?
            </p>
            <Button color="primary">Saber Mas</Button>
          </div>
        </div>
        <div className="blog__wrapper--card">
          <header className="card__header">
            <div className="card__header--picture">L</div>
            <div className="card__header--content">
              <div className="name">Catalina A.</div>
              <div className="date">Publicado hace 2 horas</div>
            </div>
          </header>
          <div className="card__picture">
            <Image src={img} alt="wrapper blog item" />
          </div>
          <div className="card__content">
            <h3 className="card__content--title">¿Qué comen los gatos?</h3>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus
              nostrum voluptates, aliquid necessitatibus dignissimos cum
              voluptas ullam harum nemo possimus maiores pariatur sint
              consequuntur odit et cupiditate fugit amet omnis?
            </p>
            <Button color="primary">Saber Mas</Button>
          </div>
        </div>
        <div className="blog__wrapper--card">
          <header className="card__header">
            <div className="card__header--picture">L</div>
            <div className="card__header--content">
              <div className="name">Catalina A.</div>
              <div className="date">Publicado hace 2 horas</div>
            </div>
          </header>
          <div className="card__picture">
            <Image src={img} alt="wrapper blog item" />
          </div>
          <div className="card__content">
            <h3 className="card__content--title">¿Qué comen los gatos?</h3>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus
              nostrum voluptates, aliquid necessitatibus dignissimos cum
              voluptas ullam harum nemo possimus maiores pariatur sint
              consequuntur odit et cupiditate fugit amet omnis?
            </p>
            <Button color="primary">Saber Mas</Button>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Blog;
