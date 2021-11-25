import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Flag from './Flag';
import FlatDotIcon from 'components/icon/FlatDotIcon';
import { useHistory } from 'react-router';
import { ROUTES } from 'utils/routes';
import { nations } from 'constants/dummy';
import { NationName } from 'components/common/Nation';
import { useRecoilState } from 'recoil';
import { isNationFilterClicked, nationFilterState } from 'atoms/atoms';

const CountryWrapper = styled.div`
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  align-items: center;
  grid-gap: 15px 33px;

  padding: 0px 34px;
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
  const [, setSelected] = useRecoilState(nationFilterState);
  const [, setIsClicked] = useRecoilState(isNationFilterClicked);

  const goMentorListPage = (nation: NationName) => {
    history.push(`${ROUTES.MENTOR_LIST}${nation}`);
    setSelected(nation);
    setIsClicked(true);
  };

  return (
    <CountryWrapper>
      {nations.map((nation: any) => (
        <Flag name={nation.name} onClick={() => goMentorListPage(nation.name)} />
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
