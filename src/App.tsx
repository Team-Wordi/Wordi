import React from 'react';
import { Route, Switch } from 'react-router';
import { ROUTES } from 'utils/routes';
import { Container } from 'styles/GlobalStyles';
import MainPage from 'pages/MainPage';
import MentorReviewPage from 'pages/MentorReviewPage';
import ApplicationPage from 'pages/ApplicationPage';
import MentorColumnPage from 'pages/MentorColumnPage';
import MyPage from 'pages/MyPage';

const App: React.FC<any> = () => {
  return (
    <Switch>
      <Route exact strict path={ROUTES.ROOT} component={MainPage} />
      <Route exact path={ROUTES.REVIEWS} component={MentorReviewPage} />
      <Route exact path={ROUTES.APPLICATION} component={ApplicationPage} />
      <Route exact path={ROUTES.MENTOR_COLUMN} component={MentorColumnPage} />
      <Route exact path={ROUTES.MY} component={MyPage} />
    </Switch>
  );
};

export default App;
