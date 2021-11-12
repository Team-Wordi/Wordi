import React from 'react';
import { COLORS } from 'styles/Theme';
import Slider from 'react-slick';
import CarouselCard from './CarouselCard';
import MainCarouselCard from 'components/Main/MainCarouselCard';

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
      <CarouselCard color={COLORS.lightYellow}>노란색</CarouselCard>
      <MainCarouselCard />
      <CarouselCard color={COLORS.green}>초록색</CarouselCard>
    </Slider>
  );
};

export default Carousel;
