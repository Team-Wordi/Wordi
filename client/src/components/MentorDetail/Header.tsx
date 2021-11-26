import React from 'react';
import Nation from 'components/common/Nation';
import ProfileImage from 'components/common/ProfileImage';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Tag from 'components/common/Tag';
import spreadArms from 'assets/img/mentorImage/spread_arms.png';
import LeftIcon from 'components/icon/LeftIcon';
import { useHistory } from 'react-router';

const Container = styled.div`
  padding: 8px 16px 0px 16px;
`;

const ProfileContainer = styled.div`
  display: flex;
  align-items: center;
  margin-top: 18px;
  margin-bottom: 12px;
`;

const MentorName = styled.div`
  margin-left: 16px;

  & > p {
    color: ${COLORS.gray_04};
    margin-top: 8px;
  }
`;

const TagsContainer = styled.div`
  display: flex;
  margin-top: 12px;
  margin-bottom: 24px;

  & > div {
    margin-right: 9px;
  }

  & > div:last-child {
    margin-right: 0;
  }
`;

const TitleBox = styled.div`
  display: flex;
  align-items: center;

  & > h2 {
    color: ${COLORS.black};
    font-weight: 500;
    font-size: 14px;
    line-height: 17px;
  }

  & > img {
    margin-left: 4px;
  }
`;

const Description = styled.div`
  color: ${COLORS.gray_04};
  line-height: 20px;
`;

const Header = ({ mentorDetail }: any) => {
  const history = useHistory();

  const goBack = () => {
    history.goBack();
  };

  const { name, smallTitle, tags } = mentorDetail;

  return (
    <Container>
      <LeftIcon size={24} color={COLORS.gray_02} onClick={goBack} />
      <ProfileContainer>
        <ProfileImage size={50} img={spreadArms} />
        <MentorName>
          <TitleBox>
            <h2>{name}</h2>
            <Nation name="영국" size={14} />
          </TitleBox>
          <p>{smallTitle}</p>
        </MentorName>
      </ProfileContainer>
      <Description>
        설렘 반 걱정 반으로 무작정 간 영국 워킹 홀리데이로 고생 좀 하고 <br /> 지금은 워디로
        광명찾고 다양한 경험을 영국에서 하고 있습니다.
      </Description>
      <TagsContainer>
        {tags?.map((tag: string) => (
          <Tag text={tag} />
        ))}
      </TagsContainer>
    </Container>
  );
};

export default Header;
