import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;

  border: 1px solid ${COLORS.primary};
  border-radius: 6px;

  color: ${COLORS.gray_04};
  font-family: 'Pretendard';

  padding: 3px 7px;
`;

interface TagProps {
  text: string;
}

const Tag = ({ text }: TagProps) => {
  return <Container>#{text}</Container>;
};

export default Tag;
