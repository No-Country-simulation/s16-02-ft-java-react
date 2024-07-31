import { fetchAPI } from "helpers";
import {
  createShelterFailure,
  createShelterStart,
  createShelterSuccess,
  getShelterFailure,
  getShelterStart,
  getShelterSuccess,
} from "store/slices/shelterSlice";

export const createShelter = (shelterData: any) => async (dispatch: any) => {
  dispatch(createShelterStart());
  try {
    console.log(shelterData);
    const response = await fetchAPI(
      "api/shelter",
      "POST",
      {
        shelterName: shelterData.name,
        shelterAuthorization: "123456789",
        shelterImgAuthorization: "asdasd.png",
        shelterAddress: shelterData.address,
        user: {
          userId: shelterData.userId,
        },
        district: {
          districtId: shelterData.districtId,
        },
      },
      "YES"
    );

    console.log("shelter created", response);
    dispatch(createShelterSuccess(null));
  } catch (error) {
    dispatch(createShelterFailure(error.message));
  }
};

export const getShelter = (userId: any) => async (dispatch: any) => {
  dispatch(getShelterStart());
  try {
    const response = await fetchAPI(
      `api/shelter/byUserId/${userId}`,
      "GET",
      null,
      "YES"
    );

    console.log("get shelter", response);
    dispatch(getShelterSuccess(response));
  } catch (error) {
    dispatch(getShelterFailure(error.message));
  }
};
