/*  배너 이미지 사용으로 다음 스프린트에 삭제될 컴포넌트입니다. */
import React from 'react';
import Slider from 'react-slick';
import BannerImage from './BannerImage';
import banner1 from 'assets/img/banner/main_banner_1.png';
import banner2 from 'assets/img/banner/main_banner_2.png';
import banner3 from 'assets/img/banner/main_banner_3.png';

const Carousel = () => {
  const settings = {
    arrows: false,
    infinite: true,
    autoplay: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
    centerMode: true,
    centerPadding: '18px',
  };

  return (
    <Slider {...settings}>
      <BannerImage img={banner1} width={318} height={152} />
      <BannerImage img={banner2} width={318} height={152} />
      <BannerImage img={banner3} width={318} height={152} />
    </Slider>
  );
};

export default Carousel;
