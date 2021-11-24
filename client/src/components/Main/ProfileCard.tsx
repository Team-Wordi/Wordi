import React from 'react';
import ProfileImage from 'components/common/ProfileImage';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Nation, { NationName } from 'components/common/Nation';

const Container = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  min-width: 121px;
  height: 146px;

  background: ${COLORS.white};

  border: none;
  border-radius: 8px;
  box-shadow: 1px 2px 0px 0px ${COLORS.lightGray};
`;

const MentorInfoWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

const MentorInfo = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

const Title = styled.div`
  display: flex;
  align-items: center;
  font-weight: 600;
  font-size: 12px;

  margin-top: 9px;

  & > img {
    margin-right: 4px;
  }
`;

const Description = styled.div`
  font-size: 11px;
  color: ${COLORS.gray_04};

  margin-top: 4px;
`;

interface ProfileCardProps {
  nation: NationName;
  name: string;
  month: string;
}

const ProfileCard = ({ nation, name, month }: ProfileCardProps) => {
  return (
    <Container>
      <MentorInfoWrapper>
        <ProfileImage size={72} />
        <MentorInfo>
          <Title>
            <Nation name={nation} size={14} />
            {name}
          </Title>
          <Description>{month} 워홀러</Description>
        </MentorInfo>
      </MentorInfoWrapper>
    </Container>
  );
};

export default ProfileCard;
