import Link from "next/link";
import React from "react";

const PetsShelterPage = () => {
  return (
    <section className="shelterPanel__body">
      <div className="shelterPanel__body--main">
        <div className="shelterPanel__body--row">
          <Link href={"/shelter/pets"}>listar</Link>
          <Link href={"/shleter/pets/new"}>agregar</Link>
        </div>
        <div className="row-main">lista</div>
      </div>
      <div className="shelterPanel__body--aside">aside</div>
    </section>
  );
};

export default PetsShelterPage;
