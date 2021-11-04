import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.div`
  font-family: 'Pretendard';
  font-weight: 400;
  display: inline-block;
  padding: 3px 8px;
  border: 1px solid ${COLORS.primary};
  color: ${COLORS.primary};
  border-radius: 6px;
`;

interface TagProps {
  text?: string | null;
}

const Tag = ({ text }: TagProps) => {
  return <>{text && <Container>{text}</Container>}</>;
};

export default Tag;
