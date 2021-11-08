import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.div`
  background: ${COLORS.gray_02};
  height: 138px;
  border: none;
  border-radius: 8px;
`;

const BreadCrumb = () => {
  return <Container />;
};

export default BreadCrumb;
