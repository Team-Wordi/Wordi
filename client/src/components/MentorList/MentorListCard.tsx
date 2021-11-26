import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Tag from 'components/common/Tag';
import ProfileImage from 'components/common/ProfileImage';
import Nation from 'components/common/Nation';

const Container = styled.div`
  width: 100%;

  border: 1px solid ${COLORS.lightGray};
  border-bottom: 3px solid ${COLORS.lightGray};
  border-radius: 8px;

  background: ${COLORS.white};

  padding: 21px 22px;
`;

const Header = styled.div`
  display: flex;
  align-items: center;
  margin-bottom: 16px;
`;

const MentorInfo = styled.div`
  margin-left: 16px;
`;

const Title = styled.div`
  display: flex;
  align-items: center;
  font-weight: 600;
  font-size: 16px;

  & > img {
    margin-left: 3px;
  }
`;

const Description = styled.div`
  color: ${COLORS.gray_04};
  margin-top: 4px;
`;

const Tags = styled.div`
  display: flex;

  & > div {
    margin-right: 6px;

    :last-child {
      margin-right: 0;
    }
  }
`;

interface MentorListCardProps {
  nickname: string;
  mentorNation: any;
  profileImageUrl: string;
  monthPeriod: number;
  keywordList: string[];
  onClick: () => void;
}

const MentorListCard = ({
  nickname,
  mentorNation,
  monthPeriod,
  keywordList,
  profileImageUrl,
  onClick,
}: MentorListCardProps) => {
  return (
    <Container onClick={onClick}>
      <Header>
        <ProfileImage size={50} img={profileImageUrl} />
        <MentorInfo>
          <Title>
            {nickname}
            <Nation size={14} name={mentorNation} />
          </Title>
          <Description>{monthPeriod}개월 워홀러</Description>
        </MentorInfo>
      </Header>
      <Tags>
        {keywordList?.map((keyword: string) => (
          <Tag text={keyword} />
        ))}
      </Tags>
    </Container>
  );
};

export default MentorListCard;
