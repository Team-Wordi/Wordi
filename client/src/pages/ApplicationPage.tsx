import React from 'react';
import { Container } from 'styles/GlobalStyles';
import Header from 'components/Application/Header';
import ScheduleApplication from 'components/Application/ScheduleApplication';
import Bottom from 'components/Application/Bottom';

const ApplicationPage = () => {
  return (
    <Container>
      <Header />
      <hr />
      <ScheduleApplication />
      <hr />
      <Bottom />
    </Container>
  );
};

export default ApplicationPage;
