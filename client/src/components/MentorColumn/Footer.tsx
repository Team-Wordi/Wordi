import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import MentorProfileCard from 'components/MentorColumn/MentorProfileCard';
import RightIcon from 'components/icon/RightIcon';
import LeftIcon from 'components/icon/LeftIcon';
import { Divider } from 'styles/GlobalStyles';

const Container = styled.div`
  padding: 0 16px;
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
    <>
      <MentorProfileCard />
      <Divider />
      <Container>
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
    </>
  );
};

export default Footer;
