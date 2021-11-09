import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import HambuguerIcon from 'components/icon/HamburgerIcon';
import MarketIcon from 'components/icon/MarketIcon';
import TextBox from 'components/common/TextBox';
import UKIcon from 'components/icon/UKIcon';

const Container = styled.div`
  display: flex;
  flex-direction: column;

  & > svg {
    margin-left: auto;
    margin-bottom: 16px;
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

  div:first-child {
    margin-right: 27px;
  }
`;

const FlagBox = styled.div`
  display: inline-flex;

  & > svg {
    margin-right: 4px;
  }
`;

const Header = () => {
  const showMenu = () => {};
  return (
    <Container>
      <HambuguerIcon size={24} color={COLORS.gray_03} onClick={showMenu} />
      <TitleBox>
        <MarketIcon size={18} color={COLORS.primary} />
        <Title>워디링 신청하기</Title>
      </TitleBox>
      <HeaderInfo>
        <TextBox text="워디멘토" color={COLORS.gray_04} />
        <FlagBox>
          <UKIcon size={16} />
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
