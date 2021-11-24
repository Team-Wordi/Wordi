import React from 'react';
import Nation from 'components/common/Nation';
import ProfileImage from 'components/common/ProfileImage';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Tag from 'components/common/Tag';
import spreadArms from 'assets/img/mentorImage/spread_arms.png';

const HeaderContainer = styled.div`
  display: flex;
  margin-top: 18px;
  justify-content: space-between;
  margin-bottom: 42px;
`;

const HeaderInfo = styled.div`
  margin-right: 30px;

  & > h2 {
    color: ${COLORS.black};
    font-weight: 600;
    font-size: 21px;
  }

  & > p {
    color: ${COLORS.gray_04};
    line-height: 23px;
    margin-bottom: 12px;
  }
`;

const TagsContainer = styled.div`
  display: flex;
  justify-content: space-between;

  & > div {
    margin-right: 9px;
  }
`;

const HeaderImg = styled.div`
  width: 82px;
  height: 82px;
  background-color: ${COLORS.lightYellow};
  border: 1px solid ${COLORS.primary};
  border-radius: 28px 28px 10px 10px;
`;

const TitleBox = styled.div`
  display: flex;
  align-items: center;

  & > img {
    margin-left: 4px;
  }
`;

const Header = ({ mentorDetail }: any) => {
  const { name, smallTitle, tags } = mentorDetail;

  return (
    <HeaderContainer>
      <HeaderInfo>
        <TitleBox>
          <h2>{name}</h2>
          <Nation name="영국" size={14} />
        </TitleBox>
        <p>{smallTitle}</p>
        <TagsContainer>
          {tags?.map((tag: any) => (
            <Tag text={tag} />
          ))}
        </TagsContainer>
      </HeaderInfo>
      <ProfileImage size={82} img={spreadArms} />
    </HeaderContainer>
  );
};

export default Header;
