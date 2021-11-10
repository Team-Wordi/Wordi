import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import UK from 'assets/img/UK.png';

const Container = styled.div`
  width: 52px;
  height: 74px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  & > img {
    width: 52px;
    height: 52px;
    margin-bottom: 8px;
  }
`;

interface FlagProps {
  flag?: string | undefined | null;
  name?: string | null;
}

const Flag = ({ flag, name }: FlagProps) => {
  return (
    <Container>
      {/* 추후 flag prop으로 대체할 예정 */}
      <img src={UK} alt="UK" />
      {name}
    </Container>
  );
};

export default Flag;
