import React, { useEffect } from 'react';
import DropdownMenu from 'components/common/DropdownMenu';
import { useRecoilState } from 'recoil';
import {
  isKeywordFilterClicked,
  isMonthFilterClicked,
  isNationFilterClicked,
  mentorDataState,
  nationFilterState,
} from 'atoms/atoms';
import { tempMentorData } from 'constants/tempMentorData';

const NationFilter = () => {
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

  const handleKeywordFilter = () => {
    /* 중복되는 코드입니다. 하나의 함수로 묶는 리팩토링이 필요합니다. */
    const otherFilterClicked = monthFilterClicked || keywordFilterClicked;
    const checkMultiFilter = otherFilterClicked ? filteredMentorData : tempMentorData;

    const matchValues = checkMultiFilter.filter((item: any) => {
      if (selected === '관심 국가') return [...tempMentorData];
      return item.nation.includes(selected);
    });

    setFilteredMentorData(matchValues);
  };

  useEffect(() => {
    handleKeywordFilter();
  }, [selected]);

  return (
    <DropdownMenu
      width={111}
      options={['독일', '프랑스', '영국', '이탈리아', '아르헨티나']}
      selected={selected}
      isClicked={isClicked}
      handleSelect={handleSelect}
    />
  );
};

export default NationFilter;
