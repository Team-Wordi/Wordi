import React, { useState } from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import HomeIcon from 'components/icon/HomeIcon';
import ActiveReviewIcon from 'components/icon/ActiveReviewIcon';
import MentorIcon from 'components/icon/MentorIcon';
import OrderIcon from 'components/icon/OrderIcon';
import MyIcon from 'components/icon/MyIcon';
import { Link, useHistory } from 'react-router-dom';
import { ROUTES } from 'utils/routes';

const Container = styled.div`
  position: sticky;
  bottom: 0;
  left: 0;
  right: 0;

  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 59px;
  padding: 0 10px;
  background: ${COLORS.white};
  border-top: 1px solid ${COLORS.gray_01};

  will-change: transform; // 확실한 이해가 필요한 속성
`;

const Tab = styled(Link)<{ isActive: boolean }>`
  width: 20%;
  color: ${({ isActive }) => (isActive ? `${COLORS.primary}` : `${COLORS.gray_03}`)};
`;

const Content = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;

  font-family: 'Pretendard';
  font-size: 11px;
  line-height: 13px;

  & > svg {
    margin-bottom: 4px;
  }
`;

const BottomTabBar = () => {
  const history = useHistory();
  const currentPath = history.location.pathname;

  const [activeTab, setActiveTab] = useState(currentPath);

  return (
    <Container>
      <Tab
        to={ROUTES.ROOT}
        onClick={() => setActiveTab(ROUTES.ROOT)}
        isActive={ROUTES.ROOT === activeTab}
      >
        <Content>
          <HomeIcon size={22} isActive={ROUTES.ROOT === activeTab} />홈
        </Content>
      </Tab>
      <Tab
        to={ROUTES.MENTOR_COLUMN}
        onClick={() => setActiveTab(ROUTES.MENTOR_COLUMN)}
        isActive={ROUTES.MENTOR_COLUMN === activeTab}
      >
        <Content>
          <ActiveReviewIcon size={22} isActive={ROUTES.MENTOR_COLUMN === activeTab} />
          칼럼
        </Content>
      </Tab>
      <Tab
        to={ROUTES.MENTOR_LIST}
        onClick={() => setActiveTab(ROUTES.MENTOR_LIST)}
        isActive={ROUTES.MENTOR_LIST === activeTab}
      >
        <Content>
          <MentorIcon size={22} isActive={ROUTES.MENTOR_LIST === activeTab} />
          멘토
        </Content>
      </Tab>
      <Tab
        to={ROUTES.APPLICATION}
        onClick={() => setActiveTab(ROUTES.APPLICATION)}
        isActive={ROUTES.APPLICATION === activeTab}
      >
        <Content>
          <OrderIcon size={22} isActive={ROUTES.APPLICATION === activeTab} /> 신청 내역
        </Content>
      </Tab>
      <Tab
        to={ROUTES.MY}
        onClick={() => setActiveTab(ROUTES.MY)}
        isActive={ROUTES.MY === activeTab}
      >
        <Content>
          <MyIcon size={22} isActive={ROUTES.MY === activeTab} />
          마이
        </Content>
      </Tab>
    </Container>
  );
};

export default BottomTabBar;
