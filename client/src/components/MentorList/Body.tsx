import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import MentorListCard from 'components/MentorList/MentorListCard';

const Container = styled.div`
  padding: 31px 24px;
  background: ${COLORS.white};
  min-height: 100vh;
  border-radius: 30px 30px 0 0;

  & > div {
    margin-bottom: 16px;
  }
`;

const DropdownMenuWrapper = styled.div`
  display: flex;
  align-items: center;
  margin-bottom: 24px;

  /* 추후 Dropdown Menu 컴포넌트 개발 이후 삭제될 속성들입니다. */
  width: 100%;
  height: 32px;
  border: 1px solid ${COLORS.primary};
  border-radius: 10px;
  justify-content: center;
`;

const Body = () => {
  return (
    <Container>
      <DropdownMenuWrapper>Dropdown Menu 컴포넌트가 추가될 공간입니다!</DropdownMenuWrapper>
      <MentorListCard />
      <MentorListCard />
      <MentorListCard />
      <MentorListCard />
      <MentorListCard />
    </Container>
  );
};

export default Body;
