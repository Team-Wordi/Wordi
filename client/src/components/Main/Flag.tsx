import React from 'react';
import styled from 'styled-components';
import Nation from 'components/common/Nation';
import { NationName } from 'components/common/Nation';
import { COLORS } from 'styles/Theme';

const Container = styled.div<{ size: number | undefined }>`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  font-family: 'Pretendard';
  color: ${COLORS.gray_04};
  width: 54px;
  height: 74px;

  & > img {
    width: ${({ size }) => size}px;
    height: ${({ size }) => size}px;
    margin-bottom: 8px;
  }
`;

interface FlagProps {
  name: NationName;
  size?: number;
  onClick: () => void;
}

const Flag = ({ name, size, onClick }: FlagProps) => {
  return (
    <Container size={size} onClick={onClick}>
      <Nation name={name} />
      {name}
    </Container>
  );
};

export default Flag;
