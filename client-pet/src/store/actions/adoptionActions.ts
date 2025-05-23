import { fetchAPI } from "helpers";
import { toast } from "sonner";
import {
  createAdoptionFailure,
  createAdoptionStart,
  createAdoptionSuccess,
  getAdoptionFailure,
  getAdoptionStart,
  getAdoptionSuccess,
} from "store/slices/adoptionSlice";

export const getAdoptionRequest =
  (shelterId: string) => async (dispatch: any) => {
    dispatch(getAdoptionStart());
    try {
      const response = await fetchAPI(
        `api/applications/by-shelter/${shelterId}`,
        "GET",
        null,
        "YES"
      );

      console.log("get adoption request", response);
      dispatch(getAdoptionSuccess(response));
    } catch (error) {
      dispatch(getAdoptionFailure(error.message));
    }
  };

export const createAdoptionRequest =
  (adoptionData: any) => async (dispatch: any) => {
    dispatch(createAdoptionStart());
    try {
      const data = {
        applicationNumber: adoptionData.applicationNumber,
        applicationState: adoptionData.applicationState,
        approved: false,
        user: {
          userId: adoptionData.userId,
        },
        pet: {
          petId: adoptionData.petId,
        },
      };
      console.log(data);
      const response = await fetchAPI("api/applications", "POST", data, "YES");

      console.log("adoption request created", response);
      toast.success("Solicitud enviada!");

      dispatch(createAdoptionSuccess(null));
    } catch (error) {
      dispatch(createAdoptionFailure(error.message));
    }
  };
