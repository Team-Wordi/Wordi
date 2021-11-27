import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.div`
  width: 100%;
  height: 121px;
  background: ${COLORS.gray_01};

  padding: 18px 16px 0px 16px;
  margin-top: 45px;
`;

const Text = styled.div`
  font-weight: 400;
  margin-bottom: 4px;
  color: ${COLORS.gray_03};

  & > strong {
    font-weight: 700;
  }

  :nth-child(1) {
    font-weight: 500;
  }

  :nth-child(2) {
    margin-bottom: 16px;
  }

  :last-child {
    margin-bottom: 0px;
  }
`;

const Footer = () => {
  return (
    <Container>
      <Text>
        <strong>워디</strong> | 우리들의 워홀 친구
      </Text>
      <Text>E-mail : mix1nt@naver.com</Text>
      <Text>이용약관 &nbsp;&nbsp; 개인정보처리방침 &nbsp;&nbsp; 제휴문의</Text>
      <Text>ⓒ 2021 워디 Wordi All Rights Reserved.</Text>
    </Container>
  );
};

export default Footer;
