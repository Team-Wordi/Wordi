import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import UK from 'assets/img/UK.png';

const Container = styled.div<FlagProps>`
  width: 52px;
  height: 74px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  & > img {
    width: ${({ size }) => size};
    height: ${({ size }) => size};
    margin-bottom: 8px;
  }
`;

interface FlagProps {
  flag?: string | undefined | null;
  name?: string | null;
  size?: number;
}

const Flag = ({ flag, name, size }: FlagProps) => {
  return (
    <Container>
      {/* 추후 flag prop으로 대체할 예정 */}
      <img src={UK} alt="UK" />
      {name}
    </Container>
  );
};

export default Flag;
