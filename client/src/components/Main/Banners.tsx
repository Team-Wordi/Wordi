import React from 'react';
import styled from 'styled-components';
import banner1 from 'assets/img/banner/column_banner_1.png';
import banner2 from 'assets/img/banner/column_banner_3.jpg';
import BannerImage from 'components/common/BannerImage';

const Container = styled.div`
  display: flex;
  overflow: auto;
  white-space: nowrap;

  padding-left: 16px;
  padding-bottom: 3px;

  &::-webkit-scrollbar {
    display: none;
  }

  & > img {
    margin-right: 8px;
  }

  margin-bottom: 24px;
`;

const Banners = () => {
  return (
    <Container>
      <BannerImage img={banner1} width={184} height={112} />
      <BannerImage img={banner2} width={184} height={112} />
    </Container>
  );
};

export default Banners;
