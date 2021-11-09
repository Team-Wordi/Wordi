import React from 'react';
import RightIcon from 'components/icon/RightIcon';
import UKIcon from 'components/icon/UKIcon';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const CardHeader = styled.div`
  display: flex;
  align-items: center;
  margin-bottom: 11px;
`;

const Img = styled.div`
  width: 50px;
  height: 50px;
  border: 1px solid black;
  border-radius: 8px;
  margin-right: 16px;
`;

const MentorInfo = styled.div`
  width: 80%;
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

  & > svg {
    margin-right: 6px;
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
    <>
      <CardHeader>
        <Img />
        <MentorInfo>
          <MentorTitle>
            <MentorNameBox>
              <UKIcon size={18} />
              워홀 매니아
            </MentorNameBox>
            <VisitProfile>
              프로필 방문
              <RightIcon size={14} />
            </VisitProfile>
          </MentorTitle>
          <Text>1년차 영국 워홀러</Text>
        </MentorInfo>
      </CardHeader>
      <Description>
        설렘 반 걱정 반으로 무작정 간 영국 워킹 홀리데이로 고생 좀 하고 지금은 워디로 광명찾고
        다양한 경험을 영국에서 하고 있습니다.
      </Description>
    </>
  );
};

export default MentorProfileCard;
