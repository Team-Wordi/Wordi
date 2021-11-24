import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import Nation from 'components/common/Nation';
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

  & > img {
    margin-right: 4px;
  }

  & > div {
    color: ${COLORS.gray_04};
    font-size: 11px;
  }
`;

const Date = styled.div`
  font-size: 11px;
  color: ${COLORS.gray_02};
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
          <Nation name="영국" size={12} />
          <div>워홀 매니아</div>
        </WriterBox>
        <Date>2021.11.10</Date>
      </Header>
      <Img />
    </Container>
  );
};

export default BreadCrumb;
