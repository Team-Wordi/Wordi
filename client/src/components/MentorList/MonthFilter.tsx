import React, { useEffect, useState } from 'react';
import DropdownMenu from 'components/common/DropdownMenu';
import { useRecoilState } from 'recoil';
import { isMonthFilterClicked, mentorDataState, monthFilterState } from 'atoms/atoms';
import { tempMentorData } from 'constants/tempMentorData';

const MonthFilter = () => {
  const [selected, setSelected] = useRecoilState(monthFilterState);
  const [isClicked, setIsClicked] = useRecoilState(isMonthFilterClicked);
  const [filteredMentorData, setFilteredMentorData] = useRecoilState(mentorDataState);

  const handleSelect = (option: string, handleClose: () => void) => {
    setSelected(option);
    setIsClicked(true);
    handleClose();
  };

  const handleMonthFilter = () => {
    const matchValues = filteredMentorData.filter((item: any) => {
      if (selected === '기간') return [...tempMentorData];
      return item.month.includes(selected);
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
