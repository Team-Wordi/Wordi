import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import LoveIcon from 'components/icon/LoveIcon';
import ProfileCard from './ProfileCard';

const Wrapper = styled.div`
  padding: 0px 16px;
`;

const Heading = styled.div`
  display: flex;
  font-weight: 600;
  font-size: 16px;

  margin-top: 22px;
  margin-bottom: 18px;

  & > svg {
    margin-right: 6px;
  }
`;

const CardWrapper = styled.div`
  display: flex;
  overflow: auto;
  white-space: nowrap;

  padding-left: 16px;
  padding-bottom: 3px;

  &::-webkit-scrollbar {
    display: none;
  }

  & > div {
    margin-right: 8px;
  }

  margin-bottom: 40px;
`;

const PopularMentors = () => {
  return (
    <>
      <Wrapper>
        <Heading>
          <LoveIcon size={18} color={COLORS.primary} />
          이번주 인기왕 워디멘토
        </Heading>
      </Wrapper>
      <CardWrapper>
        <ProfileCard />
        <ProfileCard />
        <ProfileCard />
        <ProfileCard />
        <ProfileCard />
      </CardWrapper>
    </>
  );
};

export default PopularMentors;
