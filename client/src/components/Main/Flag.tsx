import React from 'react';
import styled from 'styled-components';
import Nation from 'components/common/Nation';

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

type NationName =
  | '캐나다'
  | '일본'
  | '덴마크'
  | '프랑스'
  | '독일'
  | '홍콩'
  | '이탈리아'
  | '아르헨티나'
  | '호주'
  | '영국';

interface FlagProps {
  name?: NationName;
  size?: number;
}

const Flag = ({ name, size }: FlagProps) => {
  return (
    <Container size={size}>
      <Nation name={name} />
      {name}
    </Container>
  );
};

export default Flag;
