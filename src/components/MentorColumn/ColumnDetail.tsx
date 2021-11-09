import React from 'react';
import Tag from 'components/common/Tag';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const Container = styled.div``;

const Text = styled.div`
  font-size: 16px;
  line-height: 23px;
  color: ${COLORS.gray_05};

  /* 추후 padding 수정 필요 */
  padding-left: 10px;
  padding-right: 9px;

  margin-bottom: 32px;

  & > p > strong {
    font-weight: 600;
  }
`;

const TagWrapper = styled.div`
  display: flex;
  margin-bottom: 20px;

  & > div {
    margin-right: 5px;
  }
`;

const ColumnDetail = () => {
  return (
    <Container>
      <Text>
        <p>
          아직도 생생해요. 히드로 공항을 처음 밟았을 때가.. 외국인들과 놀고 일도 하고 다양한 기회가
          있을거라 생각했지만, 실제론 집 구하는 것부터 고난이였어요. 정말 너무 막막하고
          답답하더라구요. 마치 난이도가 확 올라간 게임 같았죠.
        </p>
        <br />
        <p>
          <strong>워디를 알게된 뒤로는 두려움을 이겨낼 수 있었어요.</strong>
        </p>
        <br />
        <p>
          처음엔 지식인이나 카페에 가입해서 질문을 올렸는데 바로 답변이 안 달리는 경우가 많았어요.
          카페는 다른 글이 빨리 올라오면 답변을 못 받기도 했구요. 현지에서 쓰는 영어는 또 달라서
          작은 내용도 몰라서 올린 질문은 가끔 공부 더 하라며 질책받기도 했죠..{' '}
        </p>
        <br />
        <p>
          그런데 워디는 1:1 멘토니까 이것저것 다 물어봤는데 오히려 더 상세하게 알려주셨어요! 좋은
          분을 워디를 통해 알게되서 정말 많은 도움을 받을 수 있었어요!
        </p>
        <br />
        <p>
          워홀 온 지 곧 1년이 되는데 전혀 걱정이 없어요.{' '}
          <strong>계속 워디를 통해서 도움을 받거든요.</strong> 워디 이전은 정말로 생각하기도 싫네요.
          (웃음)
        </p>
      </Text>
      <TagWrapper>
        <Tag text="#영국" border={COLORS.gray_01} textColor={COLORS.gray_04} />
        <Tag text="#두려움" border={COLORS.gray_01} textColor={COLORS.gray_04} />
        <Tag text="#위디도움" border={COLORS.gray_01} textColor={COLORS.gray_04} />
        <Tag text="#자신감" border={COLORS.gray_01} textColor={COLORS.gray_04} />
      </TagWrapper>
      <hr />
    </Container>
  );
};

export default ColumnDetail;
