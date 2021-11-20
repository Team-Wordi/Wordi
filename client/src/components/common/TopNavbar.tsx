import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import HamburgerIcon from 'components/icon/HamburgerIcon';
import ActiveNotificationIcon from 'components/icon/ActiveNoficiationIcon';

const Container = styled.div<{ logo: any }>`
  display: flex;
  justify-content: ${({ logo }) => (logo ? 'space-between' : 'flex-end')};
  align-items: center;

  background: transparent;
  color: ${COLORS.primary};

  font-weight: 700;
  font-size: 16px;

  margin-bottom: 21px;
`;

const RightBox = styled.div`
  display: flex;

  svg:first-child {
    margin-right: 6px;
  }
`;

const LogoBox = styled.div``;

interface TopNavbarProps {
  logo?: boolean;
  color: string | undefined;
}

const TopNavbar = ({ logo, color }: TopNavbarProps) => {
  const onHandleMenu = () => {};

  return (
    <Container logo={logo}>
      {logo && <LogoBox>워디</LogoBox>}
      <RightBox>
        <ActiveNotificationIcon size={24} color={color} />
        <HamburgerIcon size={24} color={color} onClick={onHandleMenu} />
      </RightBox>
    </Container>
  );
};

export default TopNavbar;
