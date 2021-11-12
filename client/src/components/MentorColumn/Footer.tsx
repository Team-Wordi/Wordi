import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import MentorProfileCard from 'components/MentorColumn/MentorProfileCard';
import RightIcon from 'components/icon/RightIcon';
import LeftIcon from 'components/icon/LeftIcon';
const Container = styled.div`
  margin-top: 20px;
`;

const Icons = styled.div`
  display: flex;
  justify-content: space-between;
  width: 100%;
  margin-top: 20px;

  & > div {
    display: flex;
    align-items: center;
    color: ${COLORS.primary};
    font-size: 14px;
  }
  & > div > svg {
    margin-right: 4px;
  }
`;

const Footer = () => {
  const goBack = () => {};
  const goNext = () => {};

  return (
    <Container>
      <MentorProfileCard />
      <hr />
      <Icons>
        <div>
          <LeftIcon size={14} color={COLORS.primary} onClick={goBack} />
          이전 칼럼
        </div>
        <div>
          다음 칼럼
          <RightIcon size={14} color={COLORS.primary} onClick={goNext} />
        </div>
      </Icons>
    </Container>
  );
};

export default Footer;
