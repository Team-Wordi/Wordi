import React from 'react';
import styled from 'styled-components';

const Container = styled.div`
  display: flex;
  overflow: auto;
  white-space: nowrap;
  padding-left: 16px;

  &::-webkit-scrollbar {
    display: none;
  }

  & > div {
    margin-right: 8px;

    :last-child {
      margin-right: 0;
    }
  }

  & > img {
    margin-right: 8px;

    :last-child {
      margin-right: 0;
    }
  }
`;

const FlatList = ({ children }: any) => {
  return <Container>{children}</Container>;
};

export default FlatList;
