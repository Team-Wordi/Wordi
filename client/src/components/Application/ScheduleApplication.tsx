import React from 'react';
import { COLORS } from 'styles/Theme';
import Button from 'components/common/Button';
import styled from 'styled-components';
import TextBox from 'components/common/TextBox';

const Container = styled.div`
  padding: 0 16px;
`;

const DatePickerBox = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 23px;
`;

const ScheduleApplication = () => {
  const handleButton = () => {};

  return (
    <Container>
      <DatePickerBox>
        <TextBox text="1순위 일정" color={COLORS.gray_03} />

        <Button
          size={75}
          text="11/20(수) 20:00pm"
          fill={COLORS.primary}
          border={COLORS.primary}
          textColor={COLORS.white}
          onClick={handleButton}
        />
      </DatePickerBox>
      <DatePickerBox>
        <TextBox text="2순위 일정" color={COLORS.gray_03} />
        <Button
          size={75}
          text="희망 일정"
          fill={COLORS.white}
          border={COLORS.primary}
          textColor={COLORS.primary}
          onClick={handleButton}
        />
      </DatePickerBox>
    </Container>
  );
};

export default ScheduleApplication;
