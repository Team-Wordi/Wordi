import React from 'react';
import { Container } from 'styles/GlobalStyles';
import Header from 'components/MentorColumn/Header';
import ColumnDetail from 'components/MentorColumn/ColumnDetail';
import Footer from 'components/MentorColumn/Footer';

const MentorColumnPage = () => {
  return (
    <>
      <Header />
      <ColumnDetail />
      <Footer />
    </>
  );
};

export default MentorColumnPage;
