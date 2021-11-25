import React, { useState, useEffect, useRef } from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import DownIcon from 'components/icon/DownIcon';

const Container = styled.div`
  max-width: 111px;
`;

const SelectBox = styled.div<{ isActive: boolean; isClicked: boolean; width: number }>`
  display: flex;
  justify-content: space-between;
  align-items: center;

  border: 1px solid ${COLORS.primary};
  border-bottom: ${({ isActive }) => isActive && 'none'};
  border-radius: ${({ isActive }) => (isActive ? '6px 6px 0 0' : '6px')};
  background: ${({ isClicked }) => (isClicked ? COLORS.primary : COLORS.white)};

  color: ${({ isClicked }) => (isClicked ? COLORS.white : COLORS.black)};
  font-size: 13px;
  line-height: 16px;

  width: ${({ width }) => width}px;
  height: 32px;
  padding: 8px 12px;
`;

const Options = styled.div<{ isActive: boolean; width: number }>`
  position: absolute;
  display: ${({ isActive }) => (isActive ? 'block' : 'none')};
  border: 1px solid ${COLORS.primary};
  border-top: ${({ isActive }) => isActive && 'none'};
  border-radius: ${({ isActive }) => isActive && '0 0 6px 6px '};
  background: ${COLORS.white};
  width: ${({ width }) => width}px;
  max-width: 111px;
`;

const Option = styled.div`
  position: relative;
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-family: 'Pretendard';
  font-size: 13px;
  line-height: 16px;
  color: ${COLORS.black};
  max-width: 111px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  padding: 8px 12px;

  &:hover {
    background: ${COLORS.lightGray};
  }
`;

interface DropdownMenuProps {
  width: number;
  options: string[];
  selected: string;
  isClicked: boolean;
  handleSelect: (option: string, close: () => void) => void;
}

const DropdownMenu = ({
  width,
  options,
  selected,
  isClicked,
  handleSelect,
}: DropdownMenuProps): JSX.Element => {
  const [isActive, setIsActive] = useState(false);

  const handleActive = () => {
    setIsActive(!isActive);
  };

  const handleClose = () => {
    setIsActive(false);
  };

  /* 리팩토링이 필요한 코드입니다. handleCheckOutside를 따로 hook으로 관리 필요 */
  const handleCheckOutside = (ref: React.RefObject<HTMLDivElement>) => {
    // eslint-disable-next-line react-hooks/rules-of-hooks
    useEffect(() => {
      const handleClickOutside = (event: { target: HTMLDivElement | any }) => {
        if (ref.current && !ref.current.contains(event.target)) {
          handleClose();
        }
      };
      document.addEventListener('mousedown', handleClickOutside);

      return () => {
        document.removeEventListener('mousedown', handleClickOutside);
      };
    }, [ref]);
  };

  const wrapperRef = useRef(null);
  handleCheckOutside(wrapperRef);

  return (
    <Container ref={wrapperRef}>
      <SelectBox width={width} onClick={handleActive} isActive={isActive} isClicked={isClicked}>
        {selected}
        <DownIcon size={16} color={isClicked ? COLORS.white : COLORS.gray_03} />
      </SelectBox>
      <Options isActive={isActive} width={width}>
        {options.map((option) => (
          <Option key={option} onClick={() => handleSelect(option, handleClose)}>
            {option}
          </Option>
        ))}
      </Options>
    </Container>
  );
};

export default DropdownMenu;
