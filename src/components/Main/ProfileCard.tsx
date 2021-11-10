import React from 'react';
import ProfileImage from 'components/common/ProfileImage';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import UKIcon from 'components/icon/UKIcon';

const Container = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  width: 121px;
  height: 146px;

  background: ${COLORS.white};

  border: none;
  border-radius: 8px;
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

  & > svg {
    margin-right: 4px;
  }
`;

const Description = styled.div`
  font-size: 11px;
  color: ${COLORS.gray_04};

  margin-top: 4px;
`;

const ProfileCard = () => {
  return (
    <Container>
      <MentorInfoWrapper>
        <ProfileImage size={72} />
        <MentorInfo>
          <Title>
            <UKIcon size={16} />
            워홀 매니아
          </Title>
          <Description>12개월 워홀러</Description>
        </MentorInfo>
      </MentorInfoWrapper>
    </Container>
  );
};

export default ProfileCard;
