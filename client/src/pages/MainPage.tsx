import React from 'react';
import Header from 'components/Main/Header';
import Body from 'components/Main/Body';
import Footer from 'components/Main/Footer';
import BottomTabBar from 'components/common/BottomTabBar';
import { Background } from 'styles/GlobalStyles';

const MainPage = () => {
  return (
    <Background>
      <Header />
      <Body />
      <Footer />
      <BottomTabBar />
    </Background>
  );
};

export default MainPage;
