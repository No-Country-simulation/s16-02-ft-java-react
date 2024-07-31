import React from "react";
import img from "../../assets/adop5.png";
import Image from "next/image";
import { Button } from "@components";

const blogs = [
  {
    name: "Cataline A.",
    date: "Publicado hace 2 horas",
    title: "¿Qué comen los gatos?",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus nostrum voluptates, aliquid necessitatibus dignissimos cum voluptas ullam harum nemo possimus maiores pariatur sint consequuntur odit et cupiditate fugit amet omnis?",
  },
  {
    name: "Cataline A.",
    date: "Publicado hace 2 horas",
    title: "¿Qué comen los gatos?",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus nostrum voluptates, aliquid necessitatibus dignissimos cum voluptas ullam harum nemo possimus maiores pariatur sint consequuntur odit et cupiditate fugit amet omnis?",
  },
  {
    name: "Cataline A.",
    date: "Publicado hace 2 horas",
    title: "¿Qué comen los gatos?",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus nostrum voluptates, aliquid necessitatibus dignissimos cum voluptas ullam harum nemo possimus maiores pariatur sint consequuntur odit et cupiditate fugit amet omnis?",
  },
  {
    name: "Cataline A.",
    date: "Publicado hace 2 horas",
    title: "¿Qué comen los gatos?",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus nostrum voluptates, aliquid necessitatibus dignissimos cum voluptas ullam harum nemo possimus maiores pariatur sint consequuntur odit et cupiditate fugit amet omnis?",
  },
];

const Blog = () => {
  return (
    <section className="blog">
      <header className="blog__header">
        <h2>Ultimos post en nuestro blog</h2>
      </header>
      <div className="blog__wrapper">
        {blogs.map((blog, i) => {
          const { name, date, title, description } = blog;
          return (
            <div key={i} className="blog__wrapper--card">
              <header className="card__header">
                <div className="card__header--picture">L</div>
                <div className="card__header--content">
                  <div className="name">{name}</div>
                  <div className="date">{date}</div>
                </div>
              </header>
              <div className="card__picture">
                <Image src={img} alt="wrapper blog item" />
              </div>
              <div className="card__content">
                <h3 className="card__content--title">{title}</h3>
                <p>{description}</p>
                <Button color="secondary">Saber Más</Button>
              </div>
            </div>
          );
        })}
      </div>
    </section>
  );
};

export default Blog;
