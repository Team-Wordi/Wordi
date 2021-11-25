import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Header from 'components/Application/Header';
import ScheduleApplication from 'components/Application/ScheduleApplication';
import Bottom from 'components/Application/Bottom';
import { Background, Divider } from 'styles/GlobalStyles';

const Container = styled.div`
  background: ${COLORS.primary};
  height: 30px;
`;

const ApplicationPage = () => {
  return (
    <Background>
      <Header />
      <Divider />
      <ScheduleApplication />
      <Divider />
      <Bottom />
    </Background>
  );
};

export default ApplicationPage;
