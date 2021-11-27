import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import MentorListCard from 'components/MentorList/MentorListCard';
import MonthFilter from './MonthFilter';
import KeywordFilter from './KeywordFilter';
import NationFilter from './NationFilter';
import RefreshIcon from 'components/icon/RefreshIcon';
import { useRecoilState, useRecoilValue, useResetRecoilState } from 'recoil';
import {
  keywordFilterState,
  monthFilterState,
  nationFilterState,
  isMonthFilterClicked,
  isKeywordFilterClicked,
  isNationFilterClicked,
  mentorDataState,
  getMentorData,
} from 'atoms/atoms';
import { ROUTES } from 'constants/routes';
import { useHistory } from 'react-router';

const Container = styled.div`
  border-radius: 30px 30px 0 0;
  background: ${COLORS.white};
  min-height: 100vh;
  padding: 31px 0;
  margin-top: 21px;

  & > div {
    margin-bottom: 16px;
  }
`;

const DropdownMenuWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 16px;
  margin-bottom: 24px;
`;

const CardWrapper = styled.div`
  width: 100%;
  padding: 0 20px;
`;

const Body = () => {
  const history = useHistory();
  const mentorData = useRecoilValue(getMentorData);
  const [filteredMentorData, setFilteredMentorData] = useRecoilState(mentorDataState);
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

    setFilteredMentorData(mentorData);
  };

  const goMentorProfilePage = (nation: string, name: string) => {
    history.push(`${ROUTES.MENTOR}${nation}/${name}`);
  };

  return (
    <Container>
      <DropdownMenuWrapper>
        <NationFilter />
        <KeywordFilter />
        <MonthFilter />
        <RefreshIcon size={24} color={COLORS.black} onClick={refreshAllSelected} />
      </DropdownMenuWrapper>
      <CardWrapper>
        {filteredMentorData.map((mentor: any) => (
          <MentorListCard
            key={mentor.id}
            profileImageUrl={mentor.profileImageUrl}
            nickname={mentor.nickname}
            mentorNation={mentor.mentorNation}
            monthPeriod={mentor.monthPeriod}
            keywordList={mentor.keywordList}
            onClick={() => goMentorProfilePage(mentor.mentorNation, mentor.nickname)}
          />
        ))}
      </CardWrapper>
    </Container>
  );
};

export default Body;
