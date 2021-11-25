/*  배너 이미지 사용으로 다음 스프린트에 삭제될 컴포넌트입니다. */
import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import CarouselCard from 'components/common/CarouselCard';
import world from 'assets/img/the_world.png';

const TextContainer = styled.div`
  display: flex;
  flex-direction: column;
`;

const Title = styled.h2`
  background: ${COLORS.yellow_03};
  font-weight: 600;
  font-size: 21px;
  line-height: 23px;
  color: ${COLORS.black};
  padding: 2px 4px;

  &:first-child {
    width: 82px;
  }
  :nth-child(2) {
    width: 130px;
  }
`;

const SubTitle = styled.h3`
  font-size: 14px;
  color: ${COLORS.white};
  margin-top: 6px;
  line-height: 18px;
`;

const HighligtedText = styled.div`
  font-weight: 500;
  font-size: 11px;
  color: ${COLORS.yellow_03};
  margin-top: 6px;
`;

const Img = styled.img`
  width: 123px;
  height: 98px;
`;

const MainCarouselCard = () => {
  return (
    <CarouselCard color={COLORS.primary}>
      <TextContainer>
        <Title>슬기로운</Title>
        <Title>워디 생활 모음</Title>
        <SubTitle>
          100% 워디를 활용하는 <br /> 방법을 알려드려요.
        </SubTitle>
        <HighligtedText>{`보러가기 >`} </HighligtedText>
      </TextContainer>
      <Img src={world} alt="world" />
    </CarouselCard>
  );
};

export default MainCarouselCard;
