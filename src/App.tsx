import React from 'react';
import { Route, Switch } from 'react-router';
import { ROUTES } from 'utils/routes';
import MainPage from 'pages/MainPage';
import MentorReviewPage from 'pages/MentorReviewPage';
import ApplicationPage from 'pages/ApplicationPage';
import MentorColumnPage from 'pages/MentorColumnPage';

const App: React.FC<any> = () => {
  return (
    <Switch>
      {console.log(ROUTES.REVIEWS)}
      <Route exact path={ROUTES.ROOT} component={MainPage} />
      <Route exact path={ROUTES.REVIEWS} component={MentorReviewPage} />
      <Route exact path={ROUTES.APPLICATION} component={ApplicationPage} />
      <Route exact path={ROUTES.MENTOR_COLUMN} component={MentorColumnPage} />
    </Switch>
  );
};

export default App;
