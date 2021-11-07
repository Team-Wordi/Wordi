import React from 'react';
import { ROUTES } from 'utils/routes';

const MainPage = ({ history }: any) => {
  const goPage = () => {
    history.push(`${ROUTES.REVIEWS}`);
  };

  return <button onClick={goPage}>리뷰 페이지 이동</button>;
};

export default MainPage;
