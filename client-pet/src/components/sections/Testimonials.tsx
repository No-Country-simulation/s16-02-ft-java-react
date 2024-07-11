"use client";
import React from "react";
import { Swiper, SwiperSlide } from "swiper/react";
import { Autoplay, Navigation } from "swiper/modules";
import { TestimonialCard } from "@components";

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
            autoplay={{
              delay: 4000,
              disableOnInteraction: true,
            }}
            breakpoints={{
              300: {
                slidesPerView: 1,
                spaceBetween: 15,
              },
              580: {
                spaceBetween: 15,
              },
              768: {
                spaceBetween: 20,
              },
              992: {
                spaceBetween: 20,
              },
              1200: {
                spaceBetween: 30,
              },
            }}
            modules={[Autoplay, Navigation]}
          >
            <SwiperSlide>
              <TestimonialCard />
            </SwiperSlide>
            <SwiperSlide>
              <TestimonialCard />
            </SwiperSlide>
            <SwiperSlide>
              <TestimonialCard />
            </SwiperSlide>
            <SwiperSlide>
              <TestimonialCard />
            </SwiperSlide>
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
