import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.div<CarouselCardProps>`
  display: flex;
  justify-content: space-between;
  background: ${({ color }) => (color ? color : COLORS.primary)};
  height: 152px;

  border: none;
  border-radius: 8px;
  margin-right: 8px;
  padding: 22px 31px 21px 31px;
`;

interface CarouselCardProps {
  color?: string | undefined;
  children: React.ReactNode | null;
}

const CarouselCard = ({ color, children }: CarouselCardProps) => {
  return <Container color={color}>{children}</Container>;
};

export default CarouselCard;
