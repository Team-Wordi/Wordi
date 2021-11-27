import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import LoveIcon from 'components/icon/LoveIcon';
import ProfileCard from './ProfileCard';
import spreadArms from 'assets/img/mentorImage/spread_arms.png';
import marchingBand from 'assets/img/mentorImage/marching_band.png';
import beach from 'assets/img/mentorImage/beach.png';
import FlatList from 'components/common/FlatList';

const Wrapper = styled.div`
  padding: 0px 16px;
`;

const Heading = styled.div`
  display: flex;
  font-weight: 600;
  font-size: 16px;

  margin-top: 22px;
  margin-bottom: 18px;

  & > svg {
    margin-right: 6px;
  }
`;

const PopularMentors = () => {
  return (
    <>
      <Wrapper>
        <Heading>
          <LoveIcon size={18} color={COLORS.primary} />
          이번주 인기왕 워디멘토
        </Heading>
      </Wrapper>
      <FlatList>
        <ProfileCard nation="영국" name="워홀매니아" month="12개월" img={spreadArms} />
        <ProfileCard nation="이탈리아" name="Makeyourlife" month="9개월" img={marchingBand} />
        <ProfileCard nation="프랑스" name="마이크로맨" month="1개월" img={beach} />
      </FlatList>
    </>
  );
};

export default PopularMentors;
