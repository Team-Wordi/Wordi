import React from 'react';
import { ROUTES } from 'utils/routes';

const MainPage = ({ history }: any) => {
  const goReviewPage = () => {
    history.push(`${ROUTES.REVIEWS}`);
  };

  const goApplicationPage = () => {
    history.push(`${ROUTES.APPLICATION}`);
  };

  const goMentorColumnPage = () => {
    history.push(`${ROUTES.MENTOR_COLUMN}`);
  };

  return (
    <>
      <button onClick={goReviewPage}>멘토 프로필 페이지</button>
      <button onClick={goApplicationPage}>멘토링 신청 페이지</button>
      <button onClick={goMentorColumnPage}>멘토 칼럼 페이지</button>
    </>
  );
};

export default MainPage;
