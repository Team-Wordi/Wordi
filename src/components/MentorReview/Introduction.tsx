import React from 'react';
import styled from 'styled-components';
import Banner from 'components/common/Banner';
import { COLORS } from 'styles/Theme';

const Intro = styled.div`
  margin-top: 36px;
`;

const Title = styled.h2`
  font-weight: 600;
  font-size: 14px;
  color: ${COLORS.black};
  line-height: 23px;
  margin-bottom: 18px;
`;

const Description = styled.p`
  color: ${COLORS.gray_04};
  font-size: 14px;
  line-height: 23px;
  margin-bottom: 42px;
`;

const CardContainer = styled.div`
  display: flex;
  justify-content: space-between;
  overflow: auto;
  white-space: nowrap;
  margin-bottom: 36px;

  &::-webkit-scrollbar {
    display: none;
  }

  & > div {
    margin-right: 8px;
  }
`;

const Introduction = ({ introduction }: any) => {
  return (
    <Intro>
      <Title>워디 소개</Title>
      <Description>{introduction}</Description>
      <CardContainer>
        {/* 데이터 들어오면 반복문으로 만들기 */}
        <Banner
          title="워홀, 겁먹지 마세요!"
          description="걱정을 안고 떠난 영국 워킹 홀리데이, 
지금은 괜한 걱정이었다 생각하죠!"
          color={COLORS.yellow}
        />
        <Banner
          title="영국에서 집 쉽게 구하기"
          description="영국에서 집 구하기? 누워서 떡 먹기!"
          color={COLORS.lightGreen}
        />
        <Banner
          title="영국에서 집 쉽게 구하기"
          description="영국에서 집 구하기? 누워서 떡 먹기!"
          color={COLORS.lightblue}
        />
      </CardContainer>
    </Intro>
  );
};

export default Introduction;
