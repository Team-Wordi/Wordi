import React from 'react';
import { Route, Switch } from 'react-router';
import { ROUTES } from 'utils/routes';
import MainPage from 'pages/MainPage';

import MentorReviewPage from 'pages/MentorReviewPage';
import ApplicationPage from 'pages/ApplicationPage';

const App: React.FC<any> = () => {
  return (
    <Switch>
      {console.log(ROUTES.REVIEWS)}
      <Route exact path={ROUTES.ROOT} component={MainPage} />
      <Route exact path={ROUTES.REVIEWS} component={MentorReviewPage} />
      <Route exact path={ROUTES.APPLICATION} component={ApplicationPage} />
    </Switch>
  );
};

export default App;