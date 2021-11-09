import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.div<TagProps>`
  font-family: 'Pretendard';
  font-weight: 400;
  display: inline-block;
  padding: 3px 8px;
  border: ${({ border }) => (border ? `1px solid ${border}` : `1px solid ${COLORS.primary}`)};
  color: ${({ textColor }) => (textColor ? `${textColor}` : `${COLORS.primary}`)};
  border-radius: 6px;
`;

interface TagProps {
  text?: string | null;
  textColor?: string | undefined | null;
  border?: string | undefined | null;
}

const Tag = ({ text, textColor, border }: TagProps) => {
  return (
    <>
      {text && (
        <Container textColor={textColor} border={border}>
          {text}
        </Container>
      )}
    </>
  );
};

export default Tag;
