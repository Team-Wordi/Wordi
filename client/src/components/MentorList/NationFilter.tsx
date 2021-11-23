import React, { useEffect } from 'react';
import DropdownMenu from 'components/common/DropdownMenu';
import { useRecoilState } from 'recoil';
import { isNationFilterClicked, mentorDataState, nationFilterState } from 'atoms/atoms';
import { tempMentorData } from 'constants/tempMentorData';

const NationFilter = () => {
  const [selected, setSelected] = useRecoilState(nationFilterState);
  const [isClicked, setIsClicked] = useRecoilState(isNationFilterClicked);
  const [filteredMentorData, setFilteredMentorData] = useRecoilState(mentorDataState);

  const handleSelect = (option: string, handleClose: () => void) => {
    setSelected(option);
    setIsClicked(true);
    handleClose();
  };

  const handleKeywordFilter = () => {
    const matchValues = filteredMentorData.filter((item: any) => {
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
