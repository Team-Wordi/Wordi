import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import CheckIcon from 'components/icon/CheckIcon';

const Container = styled.div`
  border-radius: 8px;
  background: ${COLORS.primary_02};

  width: 100%;
  padding: 16px 12px;
  margin-top: 24px;
`;

const Header = styled.div`
  display: flex;
  margin-bottom: 12px;

  & > svg {
    margin-right: 6px;
  }
`;

const Text = styled.div`
  font-size: 16px;
  font-weight: 600;
`;

const PriceButton = styled.button`
  display: flex;
  justify-content: space-between;
  align-items: center;

  border-radius: 6px;
  background: ${COLORS.primary};

  font-family: 'Pretendard';
  color: ${COLORS.white};

  width: 100%;
  padding: 11px 14px;

  & > p {
    font-size: 14px;
  }

  & > div {
    font-weight: 700;
    font-size: 21px;
  }
`;

const PaymentButton = () => {
  return (
    <Container>
      <Header>
        <CheckIcon size={18} />
        <Text>멘토링 이용 안내</Text>
      </Header>
      <PriceButton>
        <p>1회 20분 기준</p>
        <div>4,000원</div>
      </PriceButton>
    </Container>
  );
};

export default PaymentButton;
