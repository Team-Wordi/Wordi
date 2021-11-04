import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.div`
  font-family: 'Pretendard';
  display: inline-block;
  width: 176px;
  height: 110px;
  padding: 14px 14px 24px 14px;
  background-color: ${COLORS.yellow};
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
`;

interface CardProps {
  title?: string | null;
  description?: string | null;
}

const Card = ({ title, description }: CardProps) => {
  return (
    <>
      {title && description && (
        <Container>
          <Title>{title}</Title>
          <Description>{description}</Description>
        </Container>
      )}
    </>
  );
};

export default Card;
