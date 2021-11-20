import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import TopNavbar from 'components/common/TopNavbar';
import PinIcon from 'components/icon/PinIcon';

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

const CardWrapper = styled.div`
  display: flex;
  overflow: auto;
  white-space: nowrap;

  margin-top: 16px;
  margin-bottom: 17px;

  &::-webkit-scrollbar {
    display: none;
  }

  & > div {
    margin-right: 8px;
  }
`;

/* 디자인 쪽에서 이미지를 받으면 deprecated 될 스타일 컴포넌트입니다. */
const TempCard = styled.div`
  min-width: 184px;
  height: 112px;
  border-radius: 10px;
  background: ${COLORS.lightGreen};
`;

const Header = () => {
  return (
    <>
      <TopNavbar logo={false} color={COLORS.white} />
      <TitleWrapper>
        <PinIcon size={24} color={COLORS.white} />
        워디가 알려줄게요!
      </TitleWrapper>
      <p>워킹 홀리데이에 대한 다양한 정보를 확인해봐요.</p>
      <CardWrapper>
        <TempCard />
        <TempCard />
        <TempCard />
      </CardWrapper>
    </>
  );
};

export default Header;
