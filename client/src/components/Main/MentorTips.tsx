import React from 'react';
import ReviewIcon from 'components/icon/ReviewIcon';
import styled from 'styled-components';
import Banners from './Banners';
import Title from 'components/common/Title';
import { COLORS } from 'styles/Theme';

const Wrapper = styled.div`
  padding: 0px 16px;
`;

const MentorTips = () => {
  return (
    <>
      <Wrapper>
        <Title
          text="워디멘토들은 어땠을까?"
          icon={<ReviewIcon size={18} color={COLORS.primary} />}
        />
      </Wrapper>
      <Banners />
    </>
  );
};

export default MentorTips;
