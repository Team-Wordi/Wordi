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
  font-family: 'Pretendard';
  font-weight: 700;
  font-size: 14px;
  line-height: 18px;

  /* color */
  color: ${({ textColor }) => (textColor ? textColor : COLORS.black)};
  background-color: ${({ fill }) => (fill ? fill : COLORS.white)};
  border: ${({ border }) => (border ? `1px solid ${border}` : `1px solid ${COLORS.black}`)};
`;

interface ButtonProps {
  size: number;
  text?: string | null;
  textColor?: string | undefined;
  fill?: string | undefined;
  border?: string | undefined;
  onClick: () => void;
}

const Button = ({ size, text, textColor, fill, border, onClick }: ButtonProps) => {
  return (
    <Container size={size} textColor={textColor} fill={fill} border={border} onClick={onClick}>
      {text}
    </Container>
  );
};

export default Button;
