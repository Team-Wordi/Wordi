import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.button<ButtonProps>`
  /* common */
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 13px 0;
  border-radius: 8px;

  /* size */
  width: ${({ size }) => size}%;

  /* font */
  font-weight: 700;
  font-size: 14px;
  line-height: 18px;
  letter-spacing: -1px;

  /* color */
  color: ${({ textColor }) => (textColor ? textColor : COLORS.black)};
  background-color: ${({ fill }) => (fill ? fill : COLORS.white)};
  border: ${({ border }) => (border ? `1px solid ${border}` : `1px solid ${COLORS.black}`)};
`;

interface ButtonProps {
  text?: string | null;
  size?: number | null;
  textColor?: string | undefined;
  fill?: string | undefined;
  border?: string | undefined;
  onClick: () => void;
}

const Button = ({ text, size, textColor, fill, border, onClick }: ButtonProps) => {
  return (
    <Container size={size} textColor={textColor} fill={fill} border={border} onClick={onClick}>
      {text}
    </Container>
  );
};

export default Button;
