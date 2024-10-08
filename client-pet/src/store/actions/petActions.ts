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
} from "@store";
import { PetProps } from "@types";

export const createPet = (petData: PetProps) => async (dispatch: any) => {
  dispatch(createPetStart());
  try {
    const data = {
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
    };
    console.log({ data });
    const response = await fetchAPI("api/pets", "POST", data, "YES");

    console.log("pet created", response);
    dispatch(createPetSuccess(null));
  } catch (error) {
    dispatch(createPetFailure(error.message));
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
    const response = await fetchAPI(`api/pets/pageable`, "GET", null);

    console.log("get pet home", response);
    dispatch(getPetsHomeSuccess(response));
  } catch (error) {
    dispatch(getPetsHomeFailure(error.message));
  }
};
