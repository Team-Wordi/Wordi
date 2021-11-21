import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Header from 'components/MentorList/Header';
import Body from 'components/MentorList/Body';
import BottomTabBar from 'components/common/BottomTabBar';

const Container = styled.div`
  min-height: 100vh;
  background: ${COLORS.primary};
`;

const MentorListPage = () => {
  return (
    <>
      <Container>
        <Header />
        <Body />
      </Container>
      <BottomTabBar />
    </>
  );
};

export default MentorListPage;
