import React, { useEffect } from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import MentorListCard from 'components/MentorList/MentorListCard';
import MonthFilter from './MonthFilter';
import KeywordFilter from './KeywordFilter';
import NationFilter from './NationFilter';
import RefreshIcon from 'components/icon/RefreshIcon';
import { useRecoilState, useResetRecoilState } from 'recoil';
import {
  keywordFilterState,
  monthFilterState,
  nationFilterState,
  isMonthFilterClicked,
  isKeywordFilterClicked,
  isNationFilterClicked,
  mentorDataState,
} from 'atoms/atoms';
import { tempMentorData } from 'constants/tempMentorData';

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

const Body = () => {
  const [mentorData, setMentorData] = useRecoilState(mentorDataState);
  const resetMonth = useResetRecoilState(monthFilterState);
  const resetMonthFilterClicked = useResetRecoilState(isMonthFilterClicked);
  const resetKeyword = useResetRecoilState(keywordFilterState);
  const resetKeywordFilterClicked = useResetRecoilState(isKeywordFilterClicked);
  const resetNation = useResetRecoilState(nationFilterState);
  const resetNationFilterClicked = useResetRecoilState(isNationFilterClicked);

  const refreshAllSelected = () => {
    resetMonth();
    resetMonthFilterClicked();

    resetKeyword();
    resetKeywordFilterClicked();

    resetNation();
    resetNationFilterClicked();

    setMentorData(tempMentorData);
  };

  useEffect(() => {
    setMentorData(tempMentorData);
  }, []);

  // console.log('mentorData: ', mentorData);

  return (
    <Container>
      <DropdownMenuWrapper>
        <MonthFilter />
        <KeywordFilter />
        <NationFilter />
        <RefreshIcon size={24} color={COLORS.black} onClick={refreshAllSelected} />
      </DropdownMenuWrapper>

      {mentorData.map((mentor: any) => (
        <MentorListCard
          key={mentor.name}
          name={mentor.name}
          nation={mentor.nation}
          month={mentor.month}
          tags={mentor.tags}
        />
      ))}
    </Container>
  );
};

export default Body;
