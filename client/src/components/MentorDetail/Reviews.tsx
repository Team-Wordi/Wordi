import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import ReviewIcon from 'components/icon/ReviewIcon';
import { reviewData } from 'constants/dummy';
import ReviewCard from 'components/common/ReviewCard';
import FlatList from 'components/common/FlatList';

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
      <FlatList>
        {reviews.map((data: any) => (
          <ReviewCard review={data.review} reviewer={data.reviewer} date={data.date} />
        ))}
      </FlatList>
    </>
  );
};

export default Reviews;
