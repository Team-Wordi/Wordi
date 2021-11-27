import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import { dateConverter } from 'utils/dateConverter';
import Nation, { NationName } from 'components/common/Nation';

const Container = styled.div`
  display: inline-block;
  min-width: 256px;
  height: 136px;
  padding: 19px 13px 14px 13px;

  padding: 19px 13px 14px 13px;
  border: none;
  border-radius: 10px;
  background: ${COLORS.gray_06};
  color: ${COLORS.gray_04};
`;

const Text = styled.p`
  display: -webkit-box;
  font-size: 11px;
  line-height: 18px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: normal;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  word-wrap: break-word;
  margin-bottom: 14px;
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

const Header = styled.div`
  display: flex;
  align-items: center;
  margin-bottom: 6px;
`;

const MentorInfo = styled.div`
  margin-left: 8px;

  & > h2 {
    color: ${COLORS.black};
    font-weight: 600;
    font-size: 11px;
    line-height: 13px;
    margin-bottom: 2px;
  }

  & > p {
    color: ${COLORS.gray_04};
    font-size: 11px;
    line-height: 13px;
  }
`;

interface IconReviewCardProps {
  key: string;
  review?: string | null;
  reviewer?: string | undefined;
  date?: string | undefined;
  icon?: boolean;
  mentorName?: string | null;
  mentorNation?: NationName | undefined;
  mentorMonth?: string | null;
}

const IconReviewCard = ({
  key,
  review,
  reviewer,
  date,
  mentorName,
  mentorNation,
  mentorMonth,
}: IconReviewCardProps) => {
  const hiddenName = reviewer?.slice(0, 1) + '*** ';
  const convertedDate = dateConverter(date);

  return (
    <Container key={key}>
      <Header>
        <Nation name={mentorNation} size={30} />
        <MentorInfo>
          <h2>{mentorName}</h2>
          <p>{mentorMonth} 워홀러</p>
        </MentorInfo>
      </Header>
      <Text>{review}</Text>
      <Footer>
        <Reviewer>{hiddenName}님</Reviewer>
        <Date>{convertedDate}</Date>
      </Footer>
    </Container>
  );
};

export default IconReviewCard;
