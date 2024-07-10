"use client";
import React from "react";
import { Card } from "@components";
import { Swiper, SwiperSlide } from "swiper/react";
import { Autoplay, Navigation } from "swiper/modules";

import "swiper/css/bundle";
import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/navigation";

const Testimonials = () => {
  return (
    <section className="testimonials">
      <header className="testimonials__header">
        <h2>Historias de amor</h2>
      </header>
      <header className="testimonials__carousel">
        <div className="carousel-wrapper">
          <Swiper
            className="swiper"
            slidesPerView={3}
            spaceBetween={30}
            slidesPerGroup={1}
            loop={true}
            navigation={{
              nextEl: ".next",
              prevEl: ".prev",
            }}
            // loopFillGroupWithBlank={true}
            // autoplay={{
            //   delay: 1000,
            //   disableOnInteraction: true,
            // }}
            // breakpoints={{
            //   1024: {
            //     slidesPerView: 3,
            //     spaceBetween: 30,
            //   },
            //   1200: {
            //     slidesPerView: 3,
            //     spaceBetween: 30,
            //   },
            // }}
            modules={[Autoplay, Navigation]}
          >
            <SwiperSlide>Slide 1</SwiperSlide>
            <SwiperSlide>Slide 2</SwiperSlide>
            <SwiperSlide>Slide 3</SwiperSlide>
            <SwiperSlide>Slide 4</SwiperSlide>
          </Swiper>
        </div>
        <div className="arrow-buttons">
          <button className="prev">{"<"}</button>
          <button className="next">{">"}</button>
        </div>
      </header>
    </section>
  );
};

export default Testimonials;
