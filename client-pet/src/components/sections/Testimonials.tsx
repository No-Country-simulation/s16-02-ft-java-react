"use client";
import React, { useEffect, useRef } from "react";
import { Card } from "@components";
import { Swiper, SwiperSlide } from "swiper/react";
import { Pagination, Navigation, Autoplay } from "swiper";

import "swiper/css/bundle";
import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/navigation";

const Testimonials = () => {
  const swiperRef = useRef<HTMLDivElement>();
  // useEffect(() => {
  //   const swipwer = new Swiper(swiperRef.current, {
  //     loop: true,
  //     slidesPerView: 3,
  //     spaceBetween: 30,
  //     slidesPerGroup: 1,
  //     autoplay: {
  //       delay: 2000,
  //       disableOnInteraction: false,
  //     },
  //     breakpoints: {
  //       992: {
  //         slidesPerView: 1,
  //         spaceBetween: 60,
  //       },
  //     },
  //     navigation: {
  //       nextEl: ".swiper-button-next",
  //       prevEl: ".swiper-button-prev",
  //     },
  //   });
  // }, []);
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
            // loopFillGroupWithBlank={true}
            autoplay={{
              delay: 5000,
              disableOnInteraction: false,
            }}
            breakpoints={{
              1024: {
                slidesPerView: 3,
                spaceBetween: 30,
              },
              1200: {
                slidesPerView: 3,
                spaceBetween: 30,
              },
            }}
            modules={[]}
          >
            <SwiperSlide>Slide 1</SwiperSlide>
            <SwiperSlide>Slide 2</SwiperSlide>
            <SwiperSlide>Slide 3</SwiperSlide>
            <SwiperSlide>Slide 4</SwiperSlide>
            <SwiperSlide>Slide 4</SwiperSlide>
            <SwiperSlide>Slide 4</SwiperSlide>
            <SwiperSlide>Slide 4</SwiperSlide>
            <SwiperSlide>Slide 4</SwiperSlide>
            <SwiperSlide>Slide 4</SwiperSlide>
            {/* <div className="swiper-wrapper"> */}
            {/*   <div className="swiper-slide"> */}
            {/*     <div className="card"> */}
            {/*       <Card /> */}
            {/*     </div> */}
            {/*   </div> */}
            {/*   <div className="swiper-slide"> */}
            {/*     <div className="card">Card 2</div> */}
            {/*   </div> */}
            {/*   <div className="swiper-slide"> */}
            {/*     <div className="card">Card 3</div> */}
            {/*   </div> */}
            {/*   <div className="swiper-slide"> */}
            {/*     <div className="card">Card 4</div> */}
            {/*   </div> */}
            {/*   <div className="swiper-slide"> */}
            {/*     <div className="card">Card 5</div> */}
            {/*   </div> */}
            {/*   <div className="swiper-slide"> */}
            {/*     <div className="card">Card 6</div> */}
            {/*   </div> */}
            {/* </div> */}
            {/* <div className="swiper-button-prev"></div> */}
            {/* <div className="swiper-button-next"></div> */}
          </Swiper>
        </div>
      </header>
    </section>
  );
};

export default Testimonials;
