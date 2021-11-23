import React, { useState } from 'react';
import DropdownMenu from 'components/common/DropdownMenu';

const MonthFilter = () => {
  const [selected, setSelected] = useState('기간');
  const [isClicked, setIsClicked] = useState(false);

  const handleSelect = (option: string, handleClose: () => void) => {
    setSelected(option);
    setIsClicked(true);
    handleClose();
  };

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
