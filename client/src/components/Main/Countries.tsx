import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Flag from './Flag';
import FlatDotIcon from 'components/icon/FlatDotIcon';

const CountryWrapper = styled.div`
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  align-items: center;
  grid-gap: 15px 33px;

  padding: 0px 34px;
  margin-top: 28px;
  margin-bottom: 28px;
`;

const ViewAll = styled.div`
  width: 52px;
  height: 74px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  color: ${COLORS.primary};
`;

const Icon = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;

  width: 52px;
  height: 52px;

  border: none;
  border-radius: 50%;

  background: ${COLORS.primary};

  margin-bottom: 8px;
`;

const Countries = () => {
  return (
    <CountryWrapper>
      <Flag name="영국" />
      <Flag name="캐나다" />
      <Flag name="프랑스" />
      <Flag name="일본" />
      <Flag name="호주" />
      <Flag name="아르헨티나" />
      <Flag name="이탈리아" />

      <ViewAll>
        <Icon>
          <FlatDotIcon size={26} color="white" />
        </Icon>
        전체보기
      </ViewAll>
    </CountryWrapper>
  );
};

export default Countries;
