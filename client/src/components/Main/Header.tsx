import React from 'react';
import styled from 'styled-components';
import TopNavbar from 'components/common/TopNavbar';
import Carousel from 'components/common/Carousel';

const NavbarWrapper = styled.div`
  margin-top: 17px;
  padding: 0px 16px;
`;

const Header = () => {
  return (
    <>
      <NavbarWrapper>
        <TopNavbar />
      </NavbarWrapper>
      <Carousel />
    </>
  );
};

export default Header;
