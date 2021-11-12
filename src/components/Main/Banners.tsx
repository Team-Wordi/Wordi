import React from 'react';
import styled from 'styled-components';
import Banner from 'components/common/Banner';
import { COLORS } from 'styles/Theme';

const Container = styled.div`
  display: flex;
  overflow: auto;
  white-space: nowrap;

  padding-left: 16px;
  padding-bottom: 3px;

  &::-webkit-scrollbar {
    display: none;
  }

  & > div {
    margin-right: 8px;
  }

  margin-bottom: 24px;
`;

const Banners = () => {
  return (
    <Container>
      <Banner title="응애" description="응애응애" color={COLORS.yellow_02} />
      <Banner title="응애" description="응애응애" color={COLORS.skyblue} />
      <Banner title="응애" description="응애응애" color={COLORS.yellow_02} />
    </Container>
  );
};

export default Banners;
