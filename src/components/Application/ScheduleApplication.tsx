import React from 'react';
import { COLORS } from 'styles/Theme';
import Button from 'components/common/Button';
import TextArea from 'components/common/TextArea';
import styled from 'styled-components';
import TextBox from 'components/common/TextBox';

const Container = styled.div`
  margin-top: 20px;
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
          text="희망 일정"
          fill={COLORS.white}
          border={COLORS.primary}
          textColor={COLORS.primary}
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
