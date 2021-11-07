import React from 'react';
import { ROUTES } from 'utils/routes';

const MainPage = ({ history }: any) => {
  const goReviewPage = () => {
    history.push(`${ROUTES.REVIEWS}`);
  };

  const goApplicationPage = () => {
    history.push(`${ROUTES.APPLICATION}`);
  };

  return (
    <>
      <button onClick={goReviewPage}>리뷰 페이지 이동</button>
      <button onClick={goApplicationPage}>멘토링 신청 페이지</button>
    </>
  );
};

export default MainPage;
