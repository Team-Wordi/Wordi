import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.div<{ color: string | undefined; fontWeight: number | undefined }>`
  font-weight: ${({ fontWeight }) => (fontWeight ? fontWeight : 500)};
  font-size: 14px;
  color: ${({ color }) => (color ? color : COLORS.black)};
`;

interface TextBoxProps {
  text?: string | null;
  color?: string | undefined;
  fontWeight: number | undefined;
}

const TextBox = ({ text, color, fontWeight }: TextBoxProps) => {
  return (
    <Container color={color} fontWeight={fontWeight}>
      {text}
    </Container>
  );
};

export default TextBox;
