import React, { useEffect } from 'react';
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
  padding: 31px 0;
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
  padding: 0 16px;
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

  useEffect(() => {
    setFilteredMentorData(mentorData);
  }, []);

  const goMentorProfilePage = (nation: string, name: string) => {
    history.push(`${ROUTES.MENTOR}${nation}/${name}`);
  };

  return (
    <Container>
      <DropdownMenuWrapper>
        <MonthFilter />
        <KeywordFilter />
        <NationFilter />
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
            onClick={() => goMentorProfilePage(mentor.nation, mentor.name)}
          />
        ))}
      </CardWrapper>
    </Container>
  );
};

export default Body;
