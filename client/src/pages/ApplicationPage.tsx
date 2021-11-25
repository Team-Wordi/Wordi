import React from 'react';
import Header from 'components/Application/Header';
import ScheduleApplication from 'components/Application/ScheduleApplication';
import Bottom from 'components/Application/Bottom';
import { Background, Divider } from 'styles/GlobalStyles';

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
