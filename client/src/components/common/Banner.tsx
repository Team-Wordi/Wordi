import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.div<CardProps>`
  z-index: 3;
  position: relative;
  display: inline-block;
  min-width: 184px;
  height: 112px;
  padding: 18px 14px 8px 18px;
  background-color: ${({ color }) => (color ? color : 'white')};
  border: none;
  border-radius: 10px;

  & > img {
    position: absolute;
    z-index: 2;
    bottom: 8px;
    right: 14px;
  }
`;

const Title = styled.h1`
  position: relative;
  z-index: 1;
  max-width: 120px;
  white-space: pre-line;
  font-weight: 500;
  font-size: 16px;
  line-height: 23px;
  margin-bottom: 13px;
`;

const Description = styled.p`
  position: relative;
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
  image?: string | undefined;
}

const Banner = ({ title, description, color, image }: CardProps) => {
  console.log('image: ', image);
  return (
    <>
      {title && description && (
        <Container color={color}>
          <Title>{title}</Title>
          <Description>{description}</Description>
          <img src={image} alt={image} />
        </Container>
      )}
    </>
  );
};

export default Banner;
