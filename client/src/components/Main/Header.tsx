import React from 'react';
import styled from 'styled-components';
import TopNavbar from 'components/common/TopNavbar';
import Carousel from 'components/common/Carousel';
import { COLORS } from 'styles/Theme';

const NavbarWrapper = styled.div`
  margin-top: 17px;
  padding: 0px 16px;
`;

const Header = () => {
  return (
    <>
      <NavbarWrapper>
        <TopNavbar logo={true} color={COLORS.gray_03} />
      </NavbarWrapper>
      <Carousel />
    </>
  );
};

export default Header;
