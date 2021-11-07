import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Tag from './common/Tag';

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
`;

const HeaderImg = styled.div`
  width: 82px;
  height: 82px;
  background-color: ${COLORS.lightYellow};
  border: 1px solid ${COLORS.primary};
  border-radius: 28px 28px 10px 10px;
`;

const Header = ({ mentorDetail }: any) => {
  const { name, smallTitle, tags } = mentorDetail;

  return (
    <HeaderContainer>
      <HeaderInfo>
        <h2>{name}</h2>
        <p>{smallTitle}</p>
        <TagsContainer>
          {tags?.map((tag: any) => (
            <Tag text={tag} />
          ))}
        </TagsContainer>
      </HeaderInfo>
      <HeaderImg />
    </HeaderContainer>
  );
};

export default Header;
