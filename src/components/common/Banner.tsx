import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.div<CardProps>`
  display: inline-block;
  min-width: 184px;
  height: 112px;
  padding: 14px 14px 24px 14px;
  background-color: ${({ color }) => (color ? color : 'white')};
  border: none;
  border-radius: 10px;
`;

const Title = styled.h1`
  font-weight: 500;
  font-size: 16px;
  line-height: 23px;
  margin-bottom: 13px;
`;

const Description = styled.p`
  color: ${COLORS.gray_04};
  font-weight: 400;
  font-size: 10px;
  line-height: 18px;
  white-space: normal;
`;

interface CardProps {
  title?: string | null;
  description?: string | null;
  color?: string | undefined;
}

const Card = ({ title, description, color }: CardProps) => {
  return (
    <>
      {title && description && (
        <Container color={color}>
          <Title>{title}</Title>
          <Description>{description}</Description>
        </Container>
      )}
    </>
  );
};

export default Card;
