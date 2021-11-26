import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import { dateConverter } from 'utils/dateConverter';

const Container = styled.div`
  display: inline-block;
  min-width: 256px;
  height: 136px;
  padding: 32px 13px;

  padding: 32px 13px;
  border: none;
  border-radius: 10px;
  background: ${COLORS.gray_06};
  color: ${COLORS.gray_04};
`;

const Text = styled.p`
  display: -webkit-box;
  font-size: 11px;
  line-height: 18px;
  margin-bottom: 22px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: normal;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  word-wrap: break-word;
  height: 36px;
`;

const Footer = styled.div`
  display: flex;
  justify-content: space-between;
  font-weight: 500;
  font-size: 12px;
  white-space: normal;
`;

const Reviewer = styled.div``;

const Date = styled.div`
  font-weight: 400;
  color: ${COLORS.gray_04};
`;

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
