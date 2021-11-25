/*
  ReviewCard 컴포넌트 재사용으로 인해
  다음 스프린트에 삭제될 컴포넌트입니다.
*/
import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.div`
  min-width: 256px;
  height: 136px;

  background: ${COLORS.gray_01};
  border-radius: 10px;

  padding: 14px;
`;

const Header = styled.div`
  display: flex;
  align-items: center;
`;

const Paragraph = styled.div``;

const Footer = styled.div``;

const MentiReviewCard = () => {
  return (
    <Container>
      <Header></Header>

      <Paragraph></Paragraph>

      <Footer></Footer>
    </Container>
  );
};

export default MentiReviewCard;
