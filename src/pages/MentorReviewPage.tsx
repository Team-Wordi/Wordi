import React, { useEffect, useState } from 'react';
import { COLORS } from 'styles/Theme';
import LeftIcon from 'components/icon/LeftIcon';
import Header from 'components/MentorReview/Header';
import Review from 'components/MentorReview/Review';
import Introduction from 'components/MentorReview/Introduction';
import { mentorData } from 'constants/dummy';
import { Container } from 'styles/GlobalStyles';

const MentorReviewPage = ({ history }: any) => {
  const [mentorDetail, setMentorDetail] = useState<any>('');

  const goBack = () => {
    history.goBack();
  };

  useEffect(() => {
    setMentorDetail(mentorData);
  }, []);

  return (
    <>
      <LeftIcon size={24} color={COLORS.gray_03} onClick={goBack} />
      <Header mentorDetail={mentorDetail} />
      <hr />
      <Introduction introduction={mentorDetail.introduction} />
      <Review />
      <hr />
    </>
  );
};

export default MentorReviewPage;
