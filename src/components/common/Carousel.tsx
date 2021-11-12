import React from 'react';
import { COLORS } from 'styles/Theme';
import Slider from 'react-slick';
import CarouselCard from './CarouselCard';

const Carousel = () => {
  const settings = {
    arrows: false,
    infinite: true,
    autoplay: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
    centerMode: true,
    centerPadding: '16px',
  };

  return (
    <Slider {...settings}>
      <CarouselCard color={COLORS.lightYellow}>1</CarouselCard>
      <CarouselCard color={COLORS.primary}>2</CarouselCard>
      <CarouselCard color={COLORS.green}>3</CarouselCard>
    </Slider>
  );
};

export default Carousel;
