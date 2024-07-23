import { getCookie } from "cookies-next";
import { FetchOptionsProps } from "@types";
import { toast } from "sonner";
const baseUrl = process.env.NEXT_PUBLIC_API_URL;

const createOptions = (
  method: string,
  data?: any,
  token?: string
): FetchOptionsProps => {
  const options: FetchOptionsProps = {
    method,
    headers: {
      "Content-Type": "application/json",
    },
  };

  if (token) {
    options.headers["Authorization"] = `Bearer ${token}`;
  }

  if (method !== "GET") {
    options.body = JSON.stringify(data);
  }

  return options;
};

export const fetchAPI = async (
  endpoint: string,
  method: string = "GET",
  data: any,
  token: "YES" | "NO" = "NO"
): Promise<any> => {
  const url = `${baseUrl}/${endpoint}`;

  if (token === "NO") {
    const options = createOptions(method, data);
    try {
      const response = await fetch(url, options);

      const contentType = response.headers.get("content-type");
      if (!contentType || !contentType.includes("application/json")) {
        return null;
      }

      const data = await response.json();
      if (!data) return null;

      if (!response.ok) {
        if (response.status === 401 && data.message) {
          toast.error(data.message);
          return data;
        }
        throw new Error(`HTTP error! Status: ${response.status}`);
      } else if (response.status === 200 && data.message) {
        toast.success(data.message);
        return data;
      } else if (data.message) {
        toast(data.message);
        return data;
      } else {
        return data;
      }
    } catch (error) {
      console.error("Fetch error:", error);
      throw error;
    }
  }
  if (token === "YES") {
    const token = getCookie("token");
    const options = createOptions(method, data, token);

    try {
      const response = await fetch(url, options);
      if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
      }
      return await response.json();
    } catch (error) {
      console.error("Fetch error:", error);
      throw error;
    }
  }
};
