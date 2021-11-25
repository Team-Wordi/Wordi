import React from 'react';
import styled from 'styled-components';
import { Divider } from 'styles/GlobalStyles';
import Header from 'components/MentorColumn/Header';
import ColumnDetail from 'components/MentorColumn/ColumnDetail';
import Footer from 'components/MentorColumn/Footer';

const Container = styled.div`
  padding: 0 16px;
`;

const MentorColumnPage = () => {
  return (
    <>
      <Container>
        <Header />
        <ColumnDetail />
      </Container>
      <Divider />
      <Footer />
    </>
  );
};

export default MentorColumnPage;
