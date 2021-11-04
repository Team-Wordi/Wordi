import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import ReviewCard from 'components/ReviewCard';
import { reviewData } from 'constants/dummy';
import { COLORS } from 'styles/Theme';

const Reviews = styled.div`
  margin-bottom: 36px;
`;

const Title = styled.h2`
  font-weight: 600;
  font-size: 14px;
  color: ${COLORS.black};
  line-height: 23px;
  margin-bottom: 18px;
`;

const ReviewContainer = styled.div`
  display: flex;
  justify-content: space-between;
  overflow: auto;
  white-space: nowrap;

  &::-webkit-scrollbar {
    display: none;
  }

  & > div {
    margin-right: 36px;
  }
`;

const Review = () => {
  const [reviews, setReviews] = useState<any>([]);

  useEffect(() => {
    setReviews(reviewData);
  }, []);

  return (
    <Reviews>
      <Title>워디 후기</Title>
      <ReviewContainer>
        {reviews.map((data: any) => (
          <ReviewCard review={data.review} reviewer={data.reviewer} date={data.date} />
        ))}
      </ReviewContainer>
    </Reviews>
  );
};

export default Review;
