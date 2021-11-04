import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import { dateConverter } from 'utils/dateConverter';

const Container = styled.div`
  display: inline-block;
  min-width: 258px;
  padding: 16px 14px;
  border: none;
  border-radius: 10px;
  background-color: ${COLORS.apricot};
  color: ${COLORS.gray_04};
`;

const Text = styled.p`
  font-size: 14px;
  line-height: 23px;
  white-space: normal;
`;

const Footer = styled.div`
  margin-top: 22px;
  display: flex;
  justify-content: space-between;
  font-size: 12px;
  line-height: 23px;
  white-space: normal;
`;

const Reviewer = styled.div``;

const Date = styled.div``;

interface ReviewCardProps {
  review?: string | null;
  reviewer?: string | undefined;
  date?: string | undefined;
}

const ReviewCard = ({ review, reviewer, date }: ReviewCardProps) => {
  const hiddenName = reviewer?.slice(0, 1) + '*** ';
  const newDate = dateConverter(date);

  return (
    <Container>
      <Text>{review}</Text>
      <Footer>
        <Reviewer>{hiddenName}님</Reviewer>
        <Date>{newDate}</Date>
      </Footer>
    </Container>
  );
};

export default ReviewCard;
