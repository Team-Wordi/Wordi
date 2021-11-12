import React from 'react';
import styled from 'styled-components';
import MentiReviewCard from './MentiReviewCard';

const Container = styled.div`
  display: flex;
  overflow: auto;
  white-space: nowrap;

  padding-left: 16px;

  &::-webkit-scrollbar {
    display: none;
  }

  & > div {
    margin-right: 8px;
  }

  margin-top: 16px;
`;

const MentiReviews = () => {
  return (
    <Container>
      <MentiReviewCard />
      <MentiReviewCard />
      <MentiReviewCard />
    </Container>
  );
};

export default MentiReviews;
