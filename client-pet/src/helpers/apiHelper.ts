import { FetchOptionsProps } from "@types";
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
    console.log(url);
    try {
      console.log(url);
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
  if (token === "YES") {
    const token = sessionStorage.getItem("token") || "";
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
