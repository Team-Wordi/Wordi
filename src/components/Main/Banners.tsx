import React from 'react';
import styled from 'styled-components';
import Banner from 'components/common/Banner';
import { COLORS } from 'styles/Theme';
import working from 'assets/img/working.png';

const Container = styled.div`
  display: flex;
  overflow: auto;
  white-space: nowrap;

  padding-left: 16px;
  padding-bottom: 3px;

  &::-webkit-scrollbar {
    display: none;
  }

  & > div {
    margin-right: 8px;
  }

  margin-bottom: 24px;
`;

const Banners = () => {
  return (
    <Container>
      <Banner
        title="워킹 홀리데이 이제 겁먹지 마세요."
        description="예시입니다"
        color={COLORS.yellow_02}
        image={working}
      />
      <Banner title="영국에서 집 쉽게 구하기" description="예시입니다" color={COLORS.skyblue} />
      <Banner title="3" description="예시입니다" color={COLORS.lightGreen} />
    </Container>
  );
};

export default Banners;
