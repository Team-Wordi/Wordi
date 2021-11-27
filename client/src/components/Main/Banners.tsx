import React from 'react';
import styled from 'styled-components';
import banner1 from 'assets/img/banner/column_banner_1.png';
import banner2 from 'assets/img/banner/column_banner_3.png';
import BannerImage from 'components/common/BannerImage';
import FlatList from 'components/common/FlatList';

const Banners = () => {
  return (
    <FlatList>
      <BannerImage img={banner1} width={184} height={112} />
      <BannerImage img={banner2} width={184} height={112} />
    </FlatList>
  );
};

export default Banners;
