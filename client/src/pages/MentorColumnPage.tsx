import React from 'react';
import styled from 'styled-components';
import { Background, Divider } from 'styles/GlobalStyles';
import Header from 'components/MentorColumn/Header';
import ColumnDetail from 'components/MentorColumn/ColumnDetail';
import Footer from 'components/MentorColumn/Footer';

const Container = styled.div`
  padding: 0 16px;
`;

const MentorColumnPage = () => {
  return (
    <Background>
      <Container>
        <Header />
        <ColumnDetail />
      </Container>
      <Divider />
      <Footer />
    </Background>
  );
};

export default MentorColumnPage;
