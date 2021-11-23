import React, { useState } from 'react';
import DropdownMenu from 'components/common/DropdownMenu';

const NationFilter = () => {
  const [selected, setSelected] = useState('관심 국가');
  const [isClicked, setIsClicked] = useState(false);

  const handleSelect = (option: string, handleClose: () => void) => {
    setSelected(option);
    setIsClicked(true);
    handleClose();
  };

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
