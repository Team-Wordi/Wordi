import React from 'react';
import RightIcon from 'components/icon/RightIcon';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import ProfileImage from 'components/common/ProfileImage';
import Nation from 'components/common/Nation';
import spreadArms from 'assets/img/mentorImage/spread_arms.png';

const Container = styled.div`
  padding: 0 16px;
`;

const CardHeader = styled.div`
  display: flex;
  align-items: center;
  margin-bottom: 11px;
`;

const MentorInfo = styled.div`
  width: 80%;
  margin-left: 16px;
`;

const Text = styled.div`
  color: ${COLORS.gray_04};
`;

const Description = styled.div`
  color: ${COLORS.gray_03};
  line-height: 20px;
`;

const MentorNameBox = styled.div`
  display: flex;
  align-items: center;
  font-size: 14px;
  font-weight: 500;

  & > img {
    margin-left: 6px;
  }
`;

const VisitProfile = styled.div`
  display: flex;
  align-items: center;
  font-size: 11px;
  color: ${COLORS.gray_03};

  & > svg {
    margin-left: 4px;
  }
`;

const MentorTitle = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 8px;
`;

const MentorProfileCard = () => {
  return (
    <Container>
      <CardHeader>
        <ProfileImage size={50} img={spreadArms} />
        <MentorInfo>
          <MentorTitle>
            <MentorNameBox>
              워홀 매니아
              <Nation size={14} name="영국" />
            </MentorNameBox>
            <VisitProfile>
              프로필 방문
              <RightIcon size={14} />
            </VisitProfile>
          </MentorTitle>
          <Text>12개월 워홀러</Text>
        </MentorInfo>
      </CardHeader>
      <Description>
        설렘 반 걱정 반으로 무작정 간 영국 워킹 홀리데이로 고생 좀 하고 지금은 워디로 광명찾고
        다양한 경험을 영국에서 하고 있습니다.
      </Description>
    </Container>
  );
};

export default MentorProfileCard;
