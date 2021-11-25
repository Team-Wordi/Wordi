import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Button from 'components/common/Button';
import PaymentButton from './PaymentButton';
import { useHistory } from 'react-router';
import { ROUTES } from 'utils/routes';

const Container = styled.div`
  padding: 0 16px;
  padding-bottom: 22px;
`;

const TextWrapper = styled.div`
  margin-bottom: 34px;
`;

const Text = styled.div`
  color: ${COLORS.gray_04};
  font-size: 14px;
  line-height: 26px;
  padding: 0 6px;
`;

const Footer = () => {
  const history = useHistory();

  const goApplicationPage = () => {
    history.push(ROUTES.APPLICATION);
  };

  return (
    <Container>
      <PaymentButton />
      <TextWrapper>
        <Text>월요일: 9:00 AM ~ 12:00 AM / 15:20 PM ~ 18:40 PM</Text>
        <Text>화요일: 9:00 AM ~ 12:00 PM</Text>
        <Text>수요일: 9:00 AM ~ 23:00 PM</Text>
        <Text>목요일: 9:00 AM ~ 12:00 PM</Text>
        <Text>금요일: 9:00 AM ~ 12:00 PM / 15:20 PM ~ 18:40 PM</Text>
        <Text>토요일: 13:00 AM ~ 15:00 PM</Text>
        <Text>일요일: 13:00 AM ~ 15:00 PM</Text>
      </TextWrapper>
      <Button
        size={100}
        text="신청하기"
        fill={COLORS.black}
        border={COLORS.black}
        textColor={COLORS.white}
        onClick={goApplicationPage}
      />
    </Container>
  );
};

export default Footer;
