"use client";
import Image from "next/image";
import img from "../../assets/adop7.jpg";
import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, getPetsHome, RootState } from "store";
import Link from "next/link";
import { Loader } from "components";

const AdopcionPage = () => {
  const dispatch = useDispatch<AppDispatch>();
  const { petsHome, status } = useSelector((state: RootState) => state.pet);

  useEffect(() => {
    if (!petsHome && status !== "loading") dispatch(getPetsHome());
  }, []);

  console.log("status pets", status);

  return (
    <div className="adoptPage">
      <header className="adoptPage__header">
        <h2>Algunos de nuestros amigos que buscan un hogar</h2>
        <ul>
          <li>asdfasfd</li>
        </ul>
        <span>asdfasdf</span>
        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Nisi earum
          molestiae enim eius, sunt ea obcaecati, praesentium animi assumenda
          quisquam atque dicta inventore veritatis doloribus rerum non ratione
          quaerat eos.
        </p>
      </header>

      {!petsHome && status === "loading" && <Loader />}
      <div className="adoptPage__gallery">
        {petsHome &&
          status === "succeeded" &&
          petsHome.map((pet: any) => {
            if (
              pet.shelter.user.username === "sheltertest@gmail.com" ||
              pet.shelter.user.username === "shelter@gmail.com" ||
              pet.shelter.user.username === "anders@gmail.com" ||
              pet.shelter.user.username === "jose@gmail.com"
            )
              return null;
            return (
              <Link key={pet.petId} href={`/adopt/${pet.petId}`}>
                <div className="adoptPage__gallery--card">
                  <Image
                    src={
                      pet.multimedia[0].urlMultimedia !== "string"
                        ? pet.multimedia[0].urlMultimedia
                        : img
                    }
                    width={500}
                    height={800}
                    alt="adoption pet gallery item"
                  />
                  <div className="card-content">
                    <label>{pet.petName}</label>
                  </div>
                </div>
              </Link>
            );
          })}
      </div>
    </div>
  );
};

export default AdopcionPage;
