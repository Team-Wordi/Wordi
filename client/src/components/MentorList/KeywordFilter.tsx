import React, { useState } from 'react';
import DropdownMenu from 'components/common/DropdownMenu';

const KeywordFilter = () => {
  const [selected, setSelected] = useState('키워드');
  const [isClicked, setIsClicked] = useState(false);

  const handleSelect = (option: string, handleClose: () => void) => {
    setSelected(option);
    setIsClicked(true);
    handleClose();
  };

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
