import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import HamburgerIcon from 'components/icon/HamburgerIcon';
import ActiveNotificationIcon from 'components/icon/ActiveNoficiationIcon';

const Container = styled.div`
  display: flex;
  justify-content: space-between;
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

const TopNavbar = () => {
  const onHandleMenu = () => {};

  return (
    <Container>
      워디
      <RightBox>
        <ActiveNotificationIcon size={24} />
        <HamburgerIcon size={24} color={COLORS.gray_03} onClick={onHandleMenu} />
      </RightBox>
    </Container>
  );
};

export default TopNavbar;
