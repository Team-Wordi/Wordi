import React from 'react';
import { Route, Switch } from 'react-router';
import { ROUTES } from 'utils/routes';
import MainPage from 'pages/MainPage';

import MentorReviewPage from 'pages/MentorReviewPage';

const App: React.FC<any> = () => {
  return (
    <Switch>
      <Route exact path={ROUTES.ROOT} component={MainPage} />
      <Route exact path={ROUTES.REVEIWS} component={MentorReviewPage} />
    </Switch>
  );
};

export default App;
