import { fetchAPI } from "helpers";
import {
  createPetStart,
  createPetSuccess,
  createPetFailure,
  getPetStart,
  getPetSuccess,
  getPetFailure,
  getPetsHomeStart,
  getPetsHomeSuccess,
  getPetsHomeFailure,
  getSinglePetStart,
  getSinglePetSuccess,
  getSinglePetFailure,
} from "@store";
import { PetProps } from "@types";
import { toast } from "sonner";

export const createPet = (petData: any) => async (dispatch: any) => {
  dispatch(createPetStart());
  try {
    const data = {
      pet: {
        petName: petData.name,
        petAge: petData.age,
        petType: petData.type,
        petBreed: petData.breed,
        petSize: petData.size,
        petSex: petData.sex,
        petWeight: petData.weight,
        petState: petData.state,
        petTemperament: petData.temperament,
        petFoundPlace: petData.foundPlace,
        district: {
          districtId: petData.districtId,
        },
        shelter: {
          shelterId: petData.shelterId,
        },
      },
      listMultimedia: [
        {
          urlMultimedia: petData.imgUrl,
        },
      ],
    };
    console.log({ data });
    const response = await fetchAPI("api/pets", "POST", data, "YES");
    toast.success("Mascota registrada!");

    console.log("pet created", response);
    dispatch(createPetSuccess(null));
  } catch (error) {
    dispatch(createPetFailure(error.message));
  }
};

export const getSinglePet = (petId: string) => async (dispatch: any) => {
  dispatch(getSinglePetStart());
  try {
    const response = await fetchAPI(`api/pets/${petId}`, "GET", null, "YES");

    console.log("get pet", response);
    dispatch(getSinglePetSuccess(response));
  } catch (error) {
    dispatch(getSinglePetFailure(error.message));
  }
};

export const getPet = (shelterId: string) => async (dispatch: any) => {
  dispatch(getPetStart());
  try {
    console.log("hola");
    const response = await fetchAPI(
      `api/pets/by-shelter/${shelterId}`,
      "GET",
      null,
      "YES"
    );

    console.log("get pet", response);
    dispatch(getPetSuccess(response));
  } catch (error) {
    dispatch(getPetFailure(error.message));
  }
};

export const getPetsHome = () => async (dispatch: any) => {
  dispatch(getPetsHomeStart());
  try {
    const response = await fetchAPI(`api/pets/petsList`, "GET", null);

    console.log("get pet home", response);
    dispatch(getPetsHomeSuccess(response));
  } catch (error) {
    dispatch(getPetsHomeFailure(error.message));
  }
};
