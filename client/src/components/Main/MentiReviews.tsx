import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Title from 'components/common/Title';
import MessageIcon from 'components/icon/MessageIcon';
import IconReviewCard from './IconReviewCard';
import { reviewData } from 'constants/dummy';

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
  const [reviews, setReviews] = useState<any>([]);

  useEffect(() => {
    setReviews(reviewData);
  }, []);

  return (
    <>
      <Wrapper>
        <Title text="리얼 멘토링 후기" icon={<MessageIcon size={18} color={COLORS.primary} />} />
      </Wrapper>
      <Container>
        {reviews.map((data: any) => (
          <IconReviewCard
            review={data.review}
            reviewer={data.reviewer}
            date={data.date}
            mentorName={data.mentorName}
            mentorNation={data.mentorNation}
            mentorMonth={data.mentorMonth}
          />
        ))}
      </Container>
    </>
  );
};

export default MentiReviews;
