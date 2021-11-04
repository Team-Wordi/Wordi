import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import LeftIcon from 'components/icon/LeftIcon';
import Header from 'components/Header';
import Review from 'components/Review';
import Introduction from 'components/Introduction';
import { mentorData } from 'constants/dummy';

const Container = styled.div`
  padding: 30px 30px 40px 30px;
  min-height: 100vh;

  & > hr {
    border-width: 0.5px;
    background-color: ${COLORS.lightblue};
  }
`;

const MentorReviewPage = ({ history }: any) => {
  const [mentorDetail, setMentorDetail] = useState<any>('');

  const goBack = () => {
    history.goBack();
  };

  useEffect(() => {
    setMentorDetail(mentorData);
  }, []);

  return (
    <Container>
      <LeftIcon size={24} color={COLORS.gray_03} onClick={goBack} />
      <Header mentorDetail={mentorDetail} />
      <hr />
      <Introduction introduction={mentorDetail.introduction} />
      <Review />
      <hr />
    </Container>
  );
};

export default MentorReviewPage;
