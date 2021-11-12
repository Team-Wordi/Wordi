import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Title from 'components/common/Title';
import MessageIcon from 'components/icon/MessageIcon';
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

const Wrapper = styled.div`
  padding: 0px 16px;
`;

const MentiReviews = () => {
  return (
    <>
      <Wrapper>
        <Title text="리얼 멘토링 후기" icon={<MessageIcon size={18} color={COLORS.primary} />} />
      </Wrapper>
      <Container>
        <MentiReviewCard />
        <MentiReviewCard />
        <MentiReviewCard />
      </Container>
    </>
  );
};

export default MentiReviews;
