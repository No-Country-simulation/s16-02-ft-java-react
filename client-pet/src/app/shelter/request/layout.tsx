"use client";
import React, { useEffect } from "react";
import { LayoutProps } from "@types";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, getAdoptionRequest, getShelter, RootState } from "store";

const RequestsShelterLayout = ({ children }: LayoutProps) => {
  const dispatch = useDispatch<AppDispatch>();
  const { id } = useSelector((state: RootState) => state.auth);
  const { shelter } = useSelector((state: RootState) => state.shelter);
  const { adoptionList, status } = useSelector(
    (state: RootState) => state.adoption
  );
  useEffect(() => {
    if (!shelter) dispatch(getShelter(id));
    if (id && !adoptionList && shelter?.shelterId && status !== "loading")
      dispatch(getAdoptionRequest(shelter.shelterId));

    // eslint-disable-next-line
  }, [shelter, adoptionList]);
  return (
    <div className="shelterPanel">
      <div className="shelterPanel__header">
        <header>
          <h1>Solicitudes de Adopción.</h1>
        </header>
      </div>
      {children}
    </div>
  );
};

export default RequestsShelterLayout;
