import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Flag from './Flag';
import FlatDotIcon from 'components/icon/FlatDotIcon';
import { useHistory } from 'react-router';
import { ROUTES } from 'constants/routes';
import { nations } from 'constants/nations';
import { NationName } from 'components/common/Nation';
import { useRecoilState, useRecoilValue } from 'recoil';
import {
  getMentorData,
  isNationFilterClicked,
  mentorDataState,
  nationFilterState,
} from 'atoms/atoms';
import { rem } from 'utils/remConverter';

const CountryWrapper = styled.div`
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  align-items: center;
  grid-gap: 15px 33px;

  padding: 0 ${rem(16)};
  margin-top: 28px;
  margin-bottom: 28px;
`;

const ViewAll = styled.div`
  width: 52px;
  height: 74px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  color: ${COLORS.primary};
`;

const Icon = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;

  width: 52px;
  height: 52px;

  border: none;
  border-radius: 50%;

  background: ${COLORS.primary};

  margin-bottom: 8px;
`;

const Countries = () => {
  const history = useHistory();
  const mentorData = useRecoilValue(getMentorData);
  const [, setFilteredMentorData] = useRecoilState(mentorDataState);
  const [, setSelected] = useRecoilState(nationFilterState);
  const [, setIsClicked] = useRecoilState(isNationFilterClicked);

  const goMentorListPage = (nation: NationName) => {
    const matchValues = mentorData.filter((item: any) => {
      return item.mentorNation.includes(nation);
    });
    setFilteredMentorData(matchValues);

    setSelected(nation);
    setIsClicked(true);

    history.push(`${ROUTES.MENTOR}${nation}`);
  };

  return (
    <CountryWrapper>
      {nations.map((nation: any) => (
        <Flag key={nation} name={nation} onClick={() => goMentorListPage(nation)} />
      ))}

      <ViewAll>
        <Icon>
          <FlatDotIcon size={26} color="white" />
        </Icon>
        전체보기
      </ViewAll>
    </CountryWrapper>
  );
};

export default Countries;
