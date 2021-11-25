import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import Header from 'components/MentorDetail/Header';
import Introduction from 'components/MentorDetail/Introduction';
import { mentorData } from 'constants/dummy';
import Footer from 'components/MentorDetail/Footer';
import { COLORS } from 'styles/Theme';
import Reviews from 'components/MentorDetail/Reviews';

const Divider = styled.div`
  background: ${COLORS.lightGray};
  width: 100%;
  min-width: 100%;
  margin: 24px 0;
  height: 8px;
`;

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
