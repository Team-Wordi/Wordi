import React, { useEffect } from 'react';
import DropdownMenu from 'components/common/DropdownMenu';
import { useRecoilState, useRecoilValue } from 'recoil';
import {
  getMentorData,
  isKeywordFilterClicked,
  isMonthFilterClicked,
  isNationFilterClicked,
  mentorDataState,
  monthFilterState,
} from 'atoms/atoms';
import { matchExact } from 'utils/matchStringExact';

const MonthFilter = () => {
  const mentorData = useRecoilValue(getMentorData);
  const [selected, setSelected] = useRecoilState(monthFilterState);
  const [isClicked, setIsClicked] = useRecoilState(isMonthFilterClicked);
  const [filteredMentorData, setFilteredMentorData] = useRecoilState(mentorDataState);
  const [nationFilterClicked] = useRecoilState(isNationFilterClicked);
  const [keywordFilterClicked] = useRecoilState(isKeywordFilterClicked);

  const handleSelect = (option: string, handleClose: () => void) => {
    setSelected(option);
    setIsClicked(true);
    handleClose();
  };

  const handleMonthFilter = () => {
    /* 중복되는 코드입니다. 하나의 함수로 묶는 리팩토링이 필요합니다. */
    const otherFilterClicked = nationFilterClicked || keywordFilterClicked;
    const checkMultiFilter = otherFilterClicked ? filteredMentorData : mentorData;

    const matchValues = checkMultiFilter.filter((item: any) => {
      if (selected === '기간') return mentorData;
      const month = item.monthPeriod + '개월';
      return matchExact(selected, month);
    });
    setFilteredMentorData(matchValues);
  };

  useEffect(() => {
    handleMonthFilter();
  }, [selected]);

  return (
    <DropdownMenu
      width={84}
      options={['3개월', '6개월', '12개월']}
      selected={selected}
      isClicked={isClicked}
      handleSelect={handleSelect}
    />
  );
};

export default MonthFilter;
