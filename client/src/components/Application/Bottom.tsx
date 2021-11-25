import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import TextArea from 'components/common/TextArea';
import Button from 'components/common/Button';
import MessageIcon from 'components/icon/MessageIcon';
import TextBox from 'components/common/TextBox';

const Container = styled.div`
  padding: 0 16px;

  & > textarea {
    margin-bottom: 14px;
  }
`;

const TitleWrapper = styled.div`
  display: flex;
  align-items: center;
  margin-top: 20px;
  margin-bottom: 12px;

  & > svg {
    margin-right: 6px;
  }
`;

const Notification = styled.ul`
  list-style: none;

  & > li {
    margin-bottom: 10px;
    line-height: 17px;
  }

  & > li:nth-child(2) {
    max-width: 321px;
  }

  & > li:last-child {
    margin-bottom: 36px;
  }
`;

const Bottom = () => {
  const handleButton = () => {};
  const handleChange = () => {};
  return (
    <Container>
      <TitleWrapper>
        <MessageIcon size={18} color={COLORS.primary} strokeWidth={0.2} />
        <TextBox text="워디 멘토에게 하고 싶은 말을 자유롭게 써 주세요!" color={COLORS.gray_04} />
      </TitleWrapper>
      <TextArea
        placeholder="집구할 때 어떤 사이트나 서류가 필요한지 궁금합니다!"
        height={138}
        onChange={handleChange}
      />
      <Notification>
        <li>
          <TextBox
            text="• 워디멘토가 일정을 승인하면, 멘토링이 확정됩니다."
            color={COLORS.gray_04}
            fontWeight={400}
          />
        </li>
        <li>
          <TextBox
            text="• 워디링이 확정되면, 예약확정 알림과 유의사항이 문자로
      발송됩니다."
            color={COLORS.gray_04}
            fontWeight={400}
          />
        </li>
        <li>
          <TextBox
            text="• 확정된 멘토링 시작 20분 전, 채팅 링크가 전달됩니다."
            color={COLORS.gray_04}
            fontWeight={400}
          />
        </li>
        <li>
          <TextBox
            text="• 확정된 멘토링 시간에 맞춰 채팅방에 입장해 주세요!"
            color={COLORS.gray_04}
            fontWeight={400}
          />
        </li>
      </Notification>
      <Button
        size={100}
        text="결제하기"
        fill={COLORS.black}
        border={COLORS.black}
        textColor={COLORS.white}
        onClick={handleButton}
      />
    </Container>
  );
};

export default Bottom;
