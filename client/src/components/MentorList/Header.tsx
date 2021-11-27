import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import PinIcon from 'components/icon/PinIcon';
import BannerImage from 'components/common/BannerImage';
import banner1 from 'assets/img/banner/mentorList_banner_1.png';
import banner2 from 'assets/img/banner/mentorList_banner_2.png';
import TempNotificationIcon from 'components/icon/TempNotificationIcon';
import TempHamburgerIcon from 'components/icon/TempHamburgerIcon';
import FlatList from 'components/common/FlatList';

const Container = styled.div`
  padding: 0 16px;
  margin-bottom: 16px;

  & > p {
    color: ${COLORS.white};
  }
`;

const TitleWrapper = styled.div`
  display: flex;
  align-items: center;
  font-weight: 700;
  font-size: 21px;
  color: ${COLORS.white};
  margin-bottom: 4px;

  & > svg {
    margin-right: 4px;
  }
`;

const NavbarWrapper = styled.div`
  display: flex;
  justify-content: flex-end;
  align-items: center;

  background: transparent;

  color: ${COLORS.primary};
  font-weight: 700;
  font-size: 16px;

  margin-bottom: 25px;
`;

const Icons = styled.div`
  display: flex;

  svg:first-child {
    margin-right: 6px;
  }
`;

const Header = () => {
  return (
    <>
      <Container>
        <NavbarWrapper>
          <Icons>
            <TempNotificationIcon size={24} />
            <TempHamburgerIcon size={24} />
          </Icons>
        </NavbarWrapper>

        <TitleWrapper>
          <PinIcon size={24} color={COLORS.white} />
          워디가 알려줄게요!
        </TitleWrapper>
        <p>워킹 홀리데이에 대한 다양한 정보를 확인해봐요.</p>
      </Container>
      <FlatList>
        <BannerImage img={banner1} width={184} height={112} />
        <BannerImage img={banner2} width={184} height={112} />
      </FlatList>
    </>
  );
};

export default Header;
