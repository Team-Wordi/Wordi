import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Title from 'components/common/Title';
import MessageIcon from 'components/icon/MessageIcon';
import IconReviewCard from './IconReviewCard';
import { reviewData } from 'constants/dummy';
import FlatList from 'components/common/FlatList';

const Container = styled.div`
  padding: 0px 16px;
  margin-top: 24px;
`;

const MentiReviews = () => {
  const [reviews, setReviews] = useState<any>([]);

  useEffect(() => {
    setReviews(reviewData);
  }, []);

  return (
    <>
      <Container>
        <Title text="실시간 멘토링 후기" icon={<MessageIcon size={18} color={COLORS.primary} />} />
      </Container>
      <FlatList>
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
      </FlatList>
    </>
  );
};

export default MentiReviews;
