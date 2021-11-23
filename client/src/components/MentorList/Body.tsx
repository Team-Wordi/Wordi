import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import MentorListCard from 'components/MentorList/MentorListCard';
import MonthFilter from './MonthFilter';
import KeywordFilter from './KeywordFilter';
import NationFilter from './NationFilter';
import RefreshIcon from 'components/icon/RefreshIcon';

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

  & > div {
    margin-right: 8px;
  }

  :nth-child(3) {
    margin-right: 2px;
  }

  :last-child() {
    margin-right: 0;
  }
`;

// const SearchButton = styled.button`
//   display: flex;
//   justify-content: center;
//   align-items: center;

//   border-radius: 5px;
//   background: ${COLORS.primary};

//   font-family: 'Pretendard';
//   font-size: 14px;
//   line-height: 16px;
//   color: ${COLORS.white};

//   padding: 8px 17px;
//   margin-right: 0;
// `;

const Body = () => {
  const refreshAllSelected = () => {};

  return (
    <Container>
      <DropdownMenuWrapper>
        <MonthFilter />
        <KeywordFilter />
        <NationFilter />
        <RefreshIcon size={24} color={COLORS.black} onClick={refreshAllSelected} />
      </DropdownMenuWrapper>
      <MentorListCard />
      <MentorListCard />
      <MentorListCard />
      <MentorListCard />
      <MentorListCard />
    </Container>
  );
};

export default Body;
