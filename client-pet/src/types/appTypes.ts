import { MouseEventHandler, ChangeEventHandler } from "react";

export interface LayoutProps {
  children: React.ReactNode;
}

export interface ProviderProps {
  checkStore?: boolean;
  children: React.ReactNode;
}

export interface InputProps {
  name: string;
  label?: string;
  placeholder: string;
  value?: string | number;
  type: "text" | "password" | "email";
  isRequired?: boolean;
  isBordered?: boolean;
  className?: string;
  onChange?: ChangeEventHandler<HTMLInputElement>;
  isInvalid?: string;
}

export interface ButtonProps {
  children: React.ReactNode;
  color: "primary" | "secondary";
  mode?: "primary" | "secondary";
  className?: string;
  isBordered?: boolean;
  onClick?: MouseEventHandler<HTMLButtonElement>;
  type?: "submit" | "button" | "reset";
  isDisabled?: boolean;
  isLoading?: boolean;
  loadingMessage?: string;
  isRounded?: boolean;
}

export interface DropdowmProps {
  name: string;
  label: string;
  options: any;
  value: string;
  placeholder: string;
  onSelect?: any;
}

export interface LoginProps {
  email: string;
  password: string;
}

export interface RegisterProps {
  email: string;
  password: string;
  confirmPassword: string;
  role: "ROLE_SHELTER" | "ROLE_USER";
}

export interface RegisterProfileProps {
  name: string;
  lastname: string;
  phone: string;
  documentType: string;
  documentNumber: string;
  address: string;
  district: string;
}

export interface FetchOptionsProps {
  method: string;
  headers: {
    "Content-Type": string;
    Authorization?: string;
  };
  body?: string;
}

export interface ShelterProps {
  name: string;
  address: string;
  district: string;
}

export interface PetProps {
  name: string;
  age: number | string;
  type: string;
  breed: string;
  size: string;
  sex: "Macho" | "Hembra" | string;
  weight: number | string;
  state: string;
  temperament: string;
  foundPlace: string;
  shelterId?: string;
  districtId?: string;
  imgUrl: string;
}
