import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Header from 'components/MentorList/Header';
import MentorListCard from 'components/MentorList/MentorListCard';

const Container = styled.div`
  padding: 8px 16px 24px 16px;
  min-height: 100vh;
  background: ${COLORS.primary};

  & > p {
    color: ${COLORS.white};
  }
`;

const MentorListPage = () => {
  return (
    <Container>
      <Header />
      <MentorListCard />
    </Container>
  );
};

export default MentorListPage;
