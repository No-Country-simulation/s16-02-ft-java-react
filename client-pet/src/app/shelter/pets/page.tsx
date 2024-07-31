"use client";
import React, { ChangeEvent, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, createPet, RootState } from "@store";
import img from "../../../assets/carousel1.png";
import Image from "next/image";
import { Button, Dropdown, Input } from "@components";
import { PetProps } from "@types";
import { isValidForm } from "@utils";
import {
  getDownloadURL,
  ref,
  uploadBytes,
  uploadBytesResumable,
} from "firebase/storage";
import { storeDB } from "../../../firebase/firebase";

const initialPetState: PetProps = {
  name: "",
  age: "",
  type: "",
  breed: "",
  size: "",
  state: "",
  temperament: "",
  foundPlace: "",
  weight: "",
  sex: "",
  imgUrl: "",
};

const PetsShelterPage = () => {
  const dispatch = useDispatch<AppDispatch>();
  const [imgUpload, setImgUpload] = useState<any>();
  const [petForm, setPetForm] = useState<PetProps>(initialPetState);
  const { shelter } = useSelector((state: RootState) => state.shelter);
  const { pets, status, isLoading } = useSelector(
    (state: RootState) => state.pet
  );
  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setPetForm((prev: any) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleDropdownChange = (e: any, name: string) => {
    const value = e.target.textContent;
    setPetForm((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = async () => {
    console.log(petForm);
    // dispatch(
    //   createPet({ ...petForm, shelterId: shelter.shelterId, districtId: "4" })
    // );
  };

  const handleUpload = async () => {
    const imgRef = ref(storeDB, `files/${imgUpload.name}`);
    const uploadTask = uploadBytesResumable(imgRef, imgUpload);
    uploadTask.on(
      "state_changed",
      (snapshot) => {
        const progress =
          (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
        console.log("Upload is " + progress + "% done");
        switch (snapshot.state) {
          case "paused":
            console.log("Upload is paused");
            break;
          case "running":
            console.log("Upload is running");
            break;
        }
      },
      (error) => {},
      () => {
        getDownloadURL(uploadTask.snapshot.ref).then((downloadURL) => {
          console.log("File available at", downloadURL);
          setPetForm((prev) => ({
            ...prev,
            imgUrl: downloadURL,
          }));
        });
      }
    );
  };

  const handleClear = () => {
    setPetForm(initialPetState);
  };

  return (
    <section className="shelterPanel__body petsShelter">
      <div className="shelterPanel__body--main petsShelter__main">
        <div className="shelterPanel__body--row petsShelter__main--header">
          <div className="row-main">
            <h2>Mascotas que necesitan adopción</h2>
          </div>
        </div>
        <div className="row-main">
          {!pets && status === "loading" && (
            <div>cargando datos de mascota...</div>
          )}
          {!shelter && <div>cargando datos de refugio...</div>}
          {pets !== null && status === "succeeded" && (
            <div className="petsWrapper">
              {pets.map((pet: any, i: any) => {
                return (
                  <div key={i} className="petsWrapper__card">
                    <div className="petsWrapper__card--picture">
                      <Image
                        src={pet.multimedia[0].urlMultimedia}
                        width={500}
                        height={500}
                        alt={pet.petName + i}
                      />
                    </div>
                    <div className="petsWrapper__card--content">
                      {pet.petName}
                    </div>
                  </div>
                );
              })}
            </div>
          )}
          {!pets && status === "failed" && <div>Error de conexion...</div>}
        </div>
      </div>
      <div className="shelterPanel__body--aside">
        <div className="sticky-wrapper">
          <div className="sticky">
            <div className="petsShelter__aside--form">
              <div className="imgDB">
                hola
                <input
                  type="file"
                  onChange={(e) => setImgUpload(e.target.files[0])}
                />
                <button onClick={handleUpload}>Upload</button>
              </div>
              <Input
                label="Nombre"
                name="name"
                type="text"
                placeholder="Nombre"
                value={petForm.name}
                onChange={handleChange}
              />
              <Input
                label="Edad"
                name="age"
                type="text"
                placeholder="Edad años"
                value={petForm.age}
                onChange={handleChange}
              />
              <Dropdown
                label="Tipo"
                name="type"
                options={["Cat", "Dog"]}
                placeholder="Gato/Perro"
                value={petForm.type}
                onSelect={handleDropdownChange}
              />
              {/* <Input */}
              {/*   label="Tipo" */}
              {/*   name="type" */}
              {/*   type="text" */}
              {/*   placeholder="Gato/Perro" */}
              {/*   value={petForm.type} */}
              {/*   onChange={handleChange} */}
              {/* /> */}
              <Input
                label="Raza"
                name="breed"
                type="text"
                placeholder="Raza"
                value={petForm.breed}
                onChange={handleChange}
              />
              <Dropdown
                name="sex"
                label="Sexo"
                placeholder="Ingrese el sexo"
                options={["Male", "Female"]}
                value={petForm.sex}
                onSelect={handleDropdownChange}
              />
              <Input
                label="Peso"
                name="weight"
                type="text"
                placeholder="Peso kilos aprox."
                value={petForm.weight}
                onChange={handleChange}
              />
              <Dropdown
                label="Tamaño"
                name="size"
                placeholder="Tamaño"
                options={["Toy", "Little", "Medium", "Large", "Giant"]}
                value={petForm.size}
                onSelect={handleDropdownChange}
              />
              <Dropdown
                label="Estado"
                name="state"
                placeholder="Estado"
                options={["Lost", "Rescued"]}
                value={petForm.state}
                onSelect={handleDropdownChange}
              />
              <Input
                label="Temperamento"
                name="temperament"
                type="text"
                placeholder="Temperamento"
                value={petForm.temperament}
                onChange={handleChange}
              />
              <Input
                label="Lugar de encuentro"
                name="foundPlace"
                type="text"
                placeholder="Encontrado en.."
                value={petForm.foundPlace}
                onChange={handleChange}
              />
            </div>
            <div className="petsShelter__aside--options">
              <Button
                color="primary"
                isDisabled={isValidForm(petForm)}
                onClick={() => handleSubmit()}
              >
                Agregar
              </Button>
              <Button color="secondary" onClick={() => handleClear()}>
                Borrar
              </Button>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default PetsShelterPage;
