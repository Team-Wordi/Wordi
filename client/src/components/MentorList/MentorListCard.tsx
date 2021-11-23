import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Tag from 'components/common/Tag';
import ProfileImage from 'components/common/ProfileImage';
import UKIcon from 'components/icon/UKIcon';

const Container = styled.div`
  width: 326px;

  border-radius: 8px;
  background: ${COLORS.white};

  padding: 21px 24px;
  box-shadow: 1px 3px 0px 0px ${COLORS.lightGray};
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

  & > svg {
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
  name: string;
  nation: string;
  month: number;
  tags: string[];
}

const MentorListCard = ({ name, nation, month, tags }: MentorListCardProps) => {
  return (
    <Container>
      <Header>
        <ProfileImage />
        <MentorInfo>
          <Title>
            {name}
            {nation}
            <UKIcon size={16} />
          </Title>
          <Description>{month} 워홀러</Description>
        </MentorInfo>
      </Header>
      <Tags>
        {tags.map((tag: string) => (
          <Tag text={tag} textColor={COLORS.black} border={COLORS.primary} />
        ))}
      </Tags>
    </Container>
  );
};

export default MentorListCard;
