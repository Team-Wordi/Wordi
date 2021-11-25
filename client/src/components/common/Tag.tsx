import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.div<{ borderColor: string | undefined | null }>`
  display: flex;
  justify-content: center;
  align-items: center;

  border: ${({ borderColor }) =>
    borderColor ? `1px solid ${borderColor}` : `1px solid ${COLORS.primary}`};
  border-radius: 6px;

  color: ${COLORS.gray_04};
  font-family: 'Pretendard';

  padding: 3px 7px;
`;

interface TagProps {
  text: string;
  borderColor?: string | undefined | null;
}

const Tag = ({ text, borderColor }: TagProps) => {
  return <Container borderColor={borderColor}>#{text}</Container>;
};

export default Tag;
