import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.div<TagProps>`
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 3px 8px;
  border: ${({ border }) => (border ? `1px solid ${border}` : `1px solid ${COLORS.primary}`)};
  border-radius: 6px;
  font-family: 'Pretendard';
  color: ${({ textColor }) => (textColor ? `${textColor}` : `${COLORS.primary}`)};
  width: 65px;
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
