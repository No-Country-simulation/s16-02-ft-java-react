import { fetchAPI } from "@helpers";
import {
  createUserSuccess,
  createUserFailure,
  createUserStart,
  navUserProfile,
  navDefault,
} from "../slices/userSlice";

export const registerUser =
  (userData: any, router?: any) => async (dispatch: any) => {
    dispatch(createUserStart());
    try {
      console.log("userdata", userData);
      const response = await fetchAPI("api/auth/register", "POST", {
        username: userData.email,
        password: userData.password,
        roleName: userData.role,
        active: true,
      });
      console.log("user", response);

      localStorage.setItem("id", response?.userId);
      dispatch(createUserSuccess(userData));
      if (router === "next") {
        dispatch(navUserProfile());
      } else {
        router.push("/auth/login");
        dispatch(navDefault());
      }
    } catch (error) {
      dispatch(createUserFailure(error.message));
    }
  };

export const registerProfileUser =
  (userData: any, router?: any) => async (dispatch: any) => {
    dispatch(createUserStart());
    try {
      const userId = localStorage.getItem("id");
      console.log(userData, userId);
      const response = await fetchAPI("api/profiles", "POST", {
        profileName: userData.name,
        profileLastName: userData.lastname,
        profilePhone: userData.phone,
        profileDocumentType: userData.documentType,
        profileDocumentNumber: userData.documentNumber,
        profileAddress: userData.address,
        user: {
          userId: userId,
        },
        profileImgDocument:
          "https://w7.pngwing.com/pngs/178/595/png-transparent-user-profile-computer-icons-login-user-avatars-thumbnail.png",
        district: {
          districtId: Number(userData.district),
        },
        active: true,
      });

      console.log("res", response);

      dispatch(createUserSuccess(userData));
      dispatch(navDefault());
      router.push("/auth/login");
    } catch (error) {
      console.log(error);
      dispatch(createUserFailure(error.message));
    }
  };
