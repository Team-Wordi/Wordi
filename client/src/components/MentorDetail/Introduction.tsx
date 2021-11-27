import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import SmileIcon from 'components/icon/SmileIcon';
import banner1 from 'assets/img/banner/column_banner_1.png';
import banner2 from 'assets/img/banner/column_banner_2.png';
import BannerImage from 'components/common/BannerImage';
import { useHistory } from 'react-router';
import { ROUTES } from 'constants/routes';
import FlatList from 'components/common/FlatList';

const Container = styled.div`
  padding: 0 16px;
`;

const TitleWrapper = styled.div`
  display: flex;
  margin-bottom: 15px;
  & > svg {
    margin-right: 6px;
  }
`;

const Title = styled.h2`
  font-weight: 600;
  font-size: 16px;
  color: ${COLORS.black};
  line-height: 19px;
`;

const Description = styled.p`
  color: ${COLORS.gray_04};
  font-size: 14px;
  line-height: 23px;
  padding-left: 18px;
  padding-right: 14px;

  margin-bottom: 12px;
`;

const Introduction = () => {
  const history = useHistory();

  const goMentorColumnPage = () => {
    history.push(`${ROUTES.MENTOR_COLUMN}`);
  };

  return (
    <>
      <Container>
        <TitleWrapper>
          <SmileIcon size={18} />
          <Title>워디멘토를 소개해요!</Title>
        </TitleWrapper>
      </Container>
      <Description>
        안녕하세요. 영국에 온 지 1년이 된 워홀매니아 입니다. <br /> 영국 워킹 홀리데이 서류 준비부터
        집구하고, 나아가 문화차이 까지 저 만의 노하우를 과감없이 알려드리겠습니다. <br />
        제가 겪었던 경험을 공유하며 같은 어려움을 겪는 분들께 공감과 도움을 드리고 싶습니다.
      </Description>

      <FlatList>
        <BannerImage img={banner1} width={184} height={112} onClick={goMentorColumnPage} />
        <BannerImage img={banner2} width={184} height={112} onClick={goMentorColumnPage} />
      </FlatList>
    </>
  );
};

export default Introduction;
