import React from 'react';
import styled from 'styled-components';
import LeftIcon from 'components/icon/LeftIcon';
import { COLORS } from 'styles/Theme';
import HambuguerIcon from 'components/icon/HamburgerIcon';
import NotificationIcon from 'components/icon/NotificationIcon';
import BreadCrumb from 'components/common/BreadCrumb';

const Container = styled.div`
  margin-bottom: 21px;
`;

const Icons = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;

  margin-bottom: 20px;
`;

const RightAlignIcons = styled.div`
  display: flex;
  align-items: center;

  svg:first-child {
    margin-right: 4px;
  }
`;

const Title = styled.div`
  font-weight: 600;
  font-size: 18px;

  margin-bottom: 8px;
`;

const Description = styled.div`
  font-size: 14px;
  line-height: 23px;
  color: ${COLORS.gray_04};

  margin-bottom: 12px;
`;

const Header = () => {
  const goBack = () => {};
  const onHandleMenu = () => {};

  return (
    <Container>
      <Icons>
        <LeftIcon size={24} color={COLORS.gray_03} onClick={goBack} />
        <RightAlignIcons>
          <NotificationIcon size={24} color={COLORS.gray_03} />
          <HambuguerIcon size={24} color={COLORS.gray_03} onClick={onHandleMenu} />
        </RightAlignIcons>
      </Icons>
      <Title>"워홀, 걱정하지 마세요!"</Title>
      <Description>
        두려웠던 영국 워킹 홀리데이, 지금은 괜한 걱정이였다고 생각할 정도로 너무 편해요!
      </Description>
      <BreadCrumb />
    </Container>
  );
};

export default Header;
