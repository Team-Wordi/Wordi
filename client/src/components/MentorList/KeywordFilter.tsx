import React, { useEffect, useState } from 'react';
import DropdownMenu from 'components/common/DropdownMenu';
import { useRecoilState } from 'recoil';
import { isKeywordFilterClicked, keywordFilterState, mentorDataState } from 'atoms/atoms';
import { tempMentorData } from 'constants/tempMentorData';

const KeywordFilter = () => {
  const [selected, setSelected] = useRecoilState(keywordFilterState);
  const [isClicked, setIsClicked] = useRecoilState(isKeywordFilterClicked);
  const [filteredMentorData, setFilteredMentorData] = useRecoilState(mentorDataState);

  const handleSelect = (option: string, handleClose: () => void) => {
    setSelected(option);
    setIsClicked(true);
    handleClose();
  };

  const handleKeywordFilter = () => {
    const matchValues = filteredMentorData.filter((item: any) => {
      if (selected === '키워드') return [...tempMentorData];
      return item.tags.includes(selected);
    });
    setFilteredMentorData(matchValues);
  };

  useEffect(() => {
    handleKeywordFilter();
  }, [selected]);

  return (
    <DropdownMenu
      width={94}
      options={['집구하기', '룸메찾기', '서류준비', '취업비자']}
      selected={selected}
      isClicked={isClicked}
      handleSelect={handleSelect}
    />
  );
};

export default KeywordFilter;
