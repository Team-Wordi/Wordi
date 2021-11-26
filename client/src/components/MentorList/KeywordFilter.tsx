import React, { useEffect } from 'react';
import DropdownMenu from 'components/common/DropdownMenu';
import { useRecoilState, useRecoilValue } from 'recoil';
import {
  getMentorData,
  isKeywordFilterClicked,
  isMonthFilterClicked,
  isNationFilterClicked,
  keywordFilterState,
  mentorDataState,
} from 'atoms/atoms';

const KeywordFilter = () => {
  const mentorData = useRecoilValue(getMentorData);
  const [selected, setSelected] = useRecoilState(keywordFilterState);
  const [isClicked, setIsClicked] = useRecoilState(isKeywordFilterClicked);
  const [filteredMentorData, setFilteredMentorData] = useRecoilState(mentorDataState);
  const [monthFilterClicked] = useRecoilState(isMonthFilterClicked);
  const [nationFilterClicked] = useRecoilState(isNationFilterClicked);

  const handleSelect = (option: string, handleClose: () => void) => {
    setSelected(option);
    setIsClicked(true);
    handleClose();
  };

  const handleKeywordFilter = () => {
    /* 중복되는 코드입니다. 하나의 함수로 묶는 리팩토링이 필요합니다. */
    const otherFilterClicked = monthFilterClicked || nationFilterClicked;
    const checkMultiFilter = otherFilterClicked ? filteredMentorData : mentorData;

    const matchValues = checkMultiFilter.filter((item: any) => {
      if (selected === '키워드') return mentorData;
      return item.keywordList.includes(selected);
    });
    setFilteredMentorData(matchValues);
  };

  useEffect(() => {
    handleKeywordFilter();
  }, [selected]);

  return (
    <DropdownMenu
      width={94}
      options={['집구하기', '룸메찾기', '서류준비', '취업비자', '문화찾기', '어학', '아르바이트']}
      selected={selected}
      isClicked={isClicked}
      handleSelect={handleSelect}
    />
  );
};

export default KeywordFilter;
