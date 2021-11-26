import React, { useState } from 'react';
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
  const [toggle1, setToggle1] = useState(false);
  const [toggle2, setToggle2] = useState(false);

  const handleButton1 = () => {
    setToggle1(!toggle1);
  };

  const handleButton2 = () => {
    setToggle2(!toggle2);
  };

  return (
    <Container>
      <DatePickerBox>
        <TextBox text="1순위 일정" color={COLORS.gray_04} />

        <Button
          size={75}
          text={toggle1 ? `11/20(수) 20:00pm` : `희망 일정선택`}
          fill={toggle1 ? COLORS.primary : COLORS.white}
          border={COLORS.primary}
          textColor={toggle1 ? COLORS.white : COLORS.primary}
          onClick={handleButton1}
        />
      </DatePickerBox>
      <DatePickerBox>
        <TextBox text="2순위 일정" color={COLORS.gray_04} />
        <Button
          size={75}
          text={toggle2 ? `11/21(목) 21:00pm` : `희망 일정선택`}
          fill={toggle2 ? COLORS.primary : COLORS.white}
          border={COLORS.primary}
          textColor={toggle2 ? COLORS.white : COLORS.primary}
          onClick={handleButton2}
        />
      </DatePickerBox>
    </Container>
  );
};

export default ScheduleApplication;
