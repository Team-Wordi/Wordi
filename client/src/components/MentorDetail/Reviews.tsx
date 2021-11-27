import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import ReviewIcon from 'components/icon/ReviewIcon';
import { reviewData } from 'constants/dummy';
import ReviewCard from 'components/common/ReviewCard';
import FlatList from 'components/common/FlatList';
import RightIcon from 'components/icon/RightIcon';

const TitleContainer = styled.div`
  display: flex;
  justify-content: space-between;
  padding: 0 16px;

  margin-top: 40px;
  margin-bottom: 18px;
`;

const TitleWrapper = styled.div`
  display: flex;
  align-items: center;

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

const ShowMore = styled.div`
  display: flex;
  align-items: center;

  color: ${COLORS.gray_03};
  font-size: 11px;
  line-height: 13px;

  & > svg {
    margin-left: 2px;
  }
`;

const Reviews = () => {
  const [reviews, setReviews] = useState<any>([]);

  useEffect(() => {
    setReviews(reviewData);
  }, []);

  const goColumnDetailPage = () => {};

  return (
    <>
      <TitleContainer>
        <TitleWrapper>
          <ReviewIcon size={18} color={COLORS.primary} />
          <Title>리얼 멘토링 후기!</Title>
        </TitleWrapper>
        <ShowMore>
          더 보기
          <RightIcon size={14} color={COLORS.gray_03} onClick={goColumnDetailPage} />
        </ShowMore>
      </TitleContainer>
      <FlatList>
        {reviews.map((data: any) => (
          <ReviewCard
            key={data.review}
            review={data.review}
            reviewer={data.reviewer}
            date={data.date}
          />
        ))}
      </FlatList>
    </>
  );
};

export default Reviews;
