import React from 'react';
import { Route, Switch } from 'react-router';
import { ROUTES } from 'utils/routes';
import MainPage from 'pages/MainPage';
import MentorListPage from 'pages/MentorListPage';
import MentorProfilePage from 'pages/MentorProfilePage';
import ApplicationPage from 'pages/ApplicationPage';
import MentorReviewPage from 'pages/MentorReviewPage';

const App: React.FC<any> = () => {
  return (
    <Switch>
      <Route exact path={ROUTES.ROOT} component={MainPage} />
      <Route path={ROUTES.NATION.MAIN} component={MentorListPage} />
      <Route path={ROUTES.NATION.NAME} component={MentorProfilePage} />
      <Route path={ROUTES.NATION.APPLICATION} component={ApplicationPage} />
      <Route path={ROUTES.REVEIWS} component={MentorReviewPage} />
    </Switch>
  );
};

export default App;
