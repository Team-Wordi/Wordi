import React, { useEffect, useState } from 'react';
import { COLORS } from 'styles/Theme';
import LeftIcon from 'components/icon/LeftIcon';
import Header from 'components/MentorDetail/Header';
import Review from 'components/MentorDetail/Review';
import Introduction from 'components/MentorDetail/Introduction';
import { mentorData } from 'constants/dummy';
import { Container } from 'styles/GlobalStyles';
import Footer from 'components/MentorDetail/Footer';
import { useHistory } from 'react-router';

const MentorDetailPage = () => {
  const history = useHistory();
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
      <Footer />
    </Container>
  );
};

export default MentorDetailPage;
