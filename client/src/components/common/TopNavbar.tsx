import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import HamburgerIcon from 'components/icon/HamburgerIcon';
import ActiveNotificationIcon from 'components/icon/ActiveNoficiationIcon';
import LogoIcon from 'components/icon/LogoIcon';

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

const LogoBox = styled.div`
  display: flex;
  align-items: center;

  & > svg {
    margin-right: 9px;
  }
`;

interface TopNavbarProps {
  logo?: boolean;
  notificationColor: string | undefined;
  hamburgerColor: string | undefined;
}

const TopNavbar = ({ logo, notificationColor, hamburgerColor }: TopNavbarProps) => {
  const onHandleMenu = () => {};

  return (
    <Container logo={logo}>
      {logo && (
        <LogoBox>
          <LogoIcon size={18} />
          워디
        </LogoBox>
      )}
      <RightBox>
        <ActiveNotificationIcon size={24} color={notificationColor} />
        <HamburgerIcon size={24} color={hamburgerColor} onClick={onHandleMenu} />
      </RightBox>
    </Container>
  );
};

export default TopNavbar;
