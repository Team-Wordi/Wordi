import React, { useEffect, useState } from 'react';
import Header from 'components/MentorDetail/Header';
import Introduction from 'components/MentorDetail/Introduction';
import { mentorData } from 'constants/dummy';
import Footer from 'components/MentorDetail/Footer';
import Reviews from 'components/MentorDetail/Reviews';
import { Divider } from 'styles/GlobalStyles';

const MentorDetailPage = () => {
  const [mentorDetail, setMentorDetail] = useState<any>('');

  useEffect(() => {
    setMentorDetail(mentorData);
  }, []);

  return (
    <>
      <Header mentorDetail={mentorDetail} />
      <Divider />
      <Introduction />
      <Reviews />
      <Divider />
      <Footer />
    </>
  );
};

export default MentorDetailPage;
