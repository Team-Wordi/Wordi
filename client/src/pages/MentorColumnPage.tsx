import React from 'react';
import { Container } from 'styles/GlobalStyles';
import Header from 'components/MentorColumn/Header';
import ColumnDetail from 'components/MentorColumn/ColumnDetail';
import Footer from 'components/MentorColumn/Footer';

const MentorColumnPage = () => {
  return (
    <Container>
      <Header />
      <ColumnDetail />
      <Footer />
    </Container>
  );
};

export default MentorColumnPage;
