"use client";
import React, {
  ChangeEvent,
  ChangeEventHandler,
  useEffect,
  useRef,
  useState,
  MouseEvent,
} from "react";
import { EyeSlashFilledIcon, EyeFilledIcon } from "@icons";

interface InputProps {
  name: string;
  label?: string;
  placeholder: string;
  value?: string | number;
  type: "text" | "password" | "email";
  isRequired?: boolean;
  className?: string;
  onChange?: ChangeEventHandler<HTMLInputElement>;
}

const Input = ({
  name,
  label,
  type,
  placeholder,
  value,
  isRequired,
  className,
  onChange,
}: InputProps) => {
  const inputRef = useRef(null);
  const [isVisible, setIsVisible] = useState(false);
  const toggleVisibility = () => setIsVisible(!isVisible);

  const handleInputClick = (event: MouseEvent<HTMLDivElement>) => {
    if (event.target !== inputRef.current) {
      inputRef.current.focus();
      const event = new Event("input", { bubbles: true });
      inputRef.current.dispatchEvent(event);
    }
  };

  return (
    <div className={`input ${name} ${className}`}>
      <div className="input__label">{label}</div>
      <div className="input__content" onClick={handleInputClick}>
        <input
          ref={inputRef}
          name={name}
          type={type === "password" ? (isVisible ? "text" : "password") : type}
          placeholder={placeholder}
          value={value}
          onChange={onChange}
          required={isRequired ? true : false}
          autoComplete="nope"
        />
        {type === "password" ? (
          <button className="input__content--icon" onClick={toggleVisibility}>
            {isVisible ? (
              <EyeSlashFilledIcon className="" />
            ) : (
              <EyeFilledIcon className="" />
            )}
          </button>
        ) : null}
      </div>
    </div>
  );
};

export default Input;
