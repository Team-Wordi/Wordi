import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import ReviewIcon from 'components/icon/ReviewIcon';
import { reviewData } from 'constants/dummy';
import ReviewCard from 'components/common/ReviewCard';

const TitleWrapper = styled.div`
  display: flex;
  align-items: center;
  padding: 0 16px;
  margin-bottom: 18px;

  & > svg {
    margin-right: 6px;
  }
`;

const Title = styled.h2`
  font-weight: 600;
  font-size: 16px;
  color: ${COLORS.black};
  line-height: 19px;
`;

const ReviewContainer = styled.div`
  display: flex;
  justify-content: space-between;
  overflow: auto;
  white-space: nowrap;
  padding-left: 16px;

  &::-webkit-scrollbar {
    display: none;
  }

  & > div {
    margin-right: 8px;
  }
`;

const Reviews = () => {
  const [reviews, setReviews] = useState<any>([]);

  useEffect(() => {
    setReviews(reviewData);
  }, []);

  return (
    <>
      <TitleWrapper>
        <ReviewIcon size={18} color={COLORS.primary} />
        <Title>워디 후기</Title>
      </TitleWrapper>
      <ReviewContainer>
        {reviews.map((data: any) => (
          <ReviewCard review={data.review} reviewer={data.reviewer} date={data.date} />
        ))}
      </ReviewContainer>
    </>
  );
};

export default Reviews;
