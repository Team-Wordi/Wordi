import React, { ReactElement } from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import RightIcon from 'components/icon/RightIcon';

const TitleBox = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;

  margin-bottom: 16px;
`;

const LeftContents = styled.div`
  display: flex;
  font-weight: 600;
  font-size: 16px;

  & > svg {
    margin-right: 6px;
  }
`;

const ShowMore = styled.div`
  display: flex;
  align-items: center;
  font-size: 11px;
  color: ${COLORS.gray_03};

  & > svg {
    margin-left: 2px;
  }
`;

interface TitleProps {
  text: string;
  icon: ReactElement;
}

const Title = ({ text, icon }: TitleProps) => {
  return (
    <TitleBox>
      <LeftContents>
        {icon}
        {text}
      </LeftContents>
      <ShowMore>
        더 보기
        <RightIcon size={14} />
      </ShowMore>
    </TitleBox>
  );
};

export default Title;
