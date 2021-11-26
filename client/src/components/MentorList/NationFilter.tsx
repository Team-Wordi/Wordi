import React, { useEffect } from 'react';
import DropdownMenu from 'components/common/DropdownMenu';
import { useRecoilState, useRecoilValue } from 'recoil';
import {
  getMentorData,
  isKeywordFilterClicked,
  isMonthFilterClicked,
  isNationFilterClicked,
  mentorDataState,
  nationFilterState,
} from 'atoms/atoms';
import { nations } from 'constants/nations';

const NationFilter = () => {
  const mentorData = useRecoilValue(getMentorData);
  const [selected, setSelected] = useRecoilState(nationFilterState);
  const [isClicked, setIsClicked] = useRecoilState(isNationFilterClicked);
  const [filteredMentorData, setFilteredMentorData] = useRecoilState(mentorDataState);
  const [monthFilterClicked] = useRecoilState(isMonthFilterClicked);
  const [keywordFilterClicked] = useRecoilState(isKeywordFilterClicked);

  const handleSelect = (option: string, handleClose: () => void) => {
    setSelected(option);
    setIsClicked(true);
    handleClose();
  };

  const handleNationFilter = () => {
    /* 중복되는 코드입니다. 하나의 함수로 묶는 리팩토링이 필요합니다. */
    const otherFilterClicked = monthFilterClicked || keywordFilterClicked;
    const checkMultiFilter = otherFilterClicked ? filteredMentorData : mentorData;

    const matchValues = checkMultiFilter.filter((item: any) => {
      if (selected === '관심 국가') return mentorData;
      return item.mentorNation.includes(selected);
    });

    setFilteredMentorData(matchValues);
  };

  useEffect(() => {
    handleNationFilter();
  }, [selected]);

  return (
    <DropdownMenu
      width={111}
      options={nations}
      selected={selected}
      isClicked={isClicked}
      handleSelect={handleSelect}
    />
  );
};

export default NationFilter;
