import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.div`
  min-width: 256px;
  // 임시 height -> 추후 삭제 예정
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
