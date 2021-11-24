import React from 'react';
import styled from 'styled-components';
import Nation from 'components/common/Nation';
import { NationName } from 'components/common/Nation';

const Container = styled.div<{ size: number | undefined }>`
  width: 52px;
  height: 74px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  & > img {
    width: ${({ size }) => size}px;
    height: ${({ size }) => size}px;
    margin-bottom: 8px;
  }
`;

interface FlagProps {
  name: NationName;
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
