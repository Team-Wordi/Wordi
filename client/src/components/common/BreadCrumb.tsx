import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import UKIcon from 'components/icon/UKIcon';
import DotIcon from 'components/icon/DotIcon';

const Container = styled.div``;

const Header = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 21px;
`;

const WriterBox = styled.div`
  display: flex;
  align-items: center;

  & > svg {
    margin-right: 4px;
  }

  & > div {
    color: ${COLORS.gray_04};
    font-size: 11px;
  }
`;

const Img = styled.div`
  background: ${COLORS.gray_02};
  height: 138px;
  border: none;
  border-radius: 8px;
`;

const BreadCrumb = () => {
  return (
    <Container>
      <Header>
        <WriterBox>
          <UKIcon size={14} />
          <div>워홀 매니아</div>
        </WriterBox>
        <DotIcon size={18} color={COLORS.gray_03} />
      </Header>

      <Img />
    </Container>
  );
};

export default BreadCrumb;
