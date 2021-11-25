import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import TextBox from 'components/common/TextBox';
import Nation from 'components/common/Nation';
import MarketIcon from 'components/icon/MarketIcon';
import CancelIcon from 'components/icon/CancelIcon';
import { useHistory } from 'react-router';
import { ROUTES } from 'utils/routes';

const Container = styled.div`
  display: flex;
  flex-direction: column;
  border-radius: 30px 30px 0 0;
  background: ${COLORS.white};
  padding: 17px 16px 0px 16px;

  & > svg {
    margin-left: auto;
    margin-bottom: 31px;
  }
`;

const TitleBox = styled.div`
  display: flex;
  margin-bottom: 19px;

  & > svg {
    margin-right: 12px;
  }
`;

const Title = styled.h2`
  font-weight: 600;
  font-size: 18px;
  color: ${COLORS.black};
`;

const HeaderInfo = styled.div`
  display: flex;
  margin-bottom: 12px;

  :last-child {
    margin-bottom: 0;
  }

  div:first-child {
    margin-right: 27px;
  }
`;

const FlagBox = styled.div`
  display: inline-flex;

  & > img {
    margin-right: 4px;
  }
`;

const Header = () => {
  const history = useHistory();

  const goBack = () => {
    history.push(ROUTES.ROOT);
  };

  return (
    <Container>
      <CancelIcon size={14} color={COLORS.gray_02} onClick={goBack} />
      <TitleBox>
        <MarketIcon size={18} color={COLORS.primary} />
        <Title>워디링 신청하기</Title>
      </TitleBox>
      <HeaderInfo>
        <TextBox text="워디멘토" color={COLORS.gray_04} />
        <FlagBox>
          <Nation size={14} name="영국" />
          <TextBox text="워홀매니아" color={COLORS.black} />
        </FlagBox>
      </HeaderInfo>
      <HeaderInfo>
        <TextBox text="신청 가격" color={COLORS.gray_04} />
        <TextBox text="5,000" fontWeight={600} />
      </HeaderInfo>
    </Container>
  );
};

export default Header;
