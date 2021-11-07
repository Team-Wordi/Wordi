import React, { ChangeEvent } from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';

const StyledTextArea = styled.textarea<TextAreaProps>`
  resize: none;
  width: 100%;
  height: ${({ height }) => height}px;
  background: ${COLORS.white};

  /* border */
  border: 1px solid ${COLORS.primary};
  border-radius: 8px;

  /* font */
  color: ${COLORS.black};
  font-family: 'Pretendard';
  font-size: 14px;

  padding: 8px;

  ::placeholder {
    font-family: 'Pretendard';
    font-size: 14px;
    color: ${COLORS.gray_03};
  }

  :focus {
    outline: none;
  }
`;

interface TextAreaProps {
  value?: string | undefined;
  placeholder?: string;
  height?: number | null;
  onChange: (event: ChangeEvent<HTMLTextAreaElement>) => void;
}

const TextArea = ({ value, placeholder, height, onChange }: TextAreaProps) => {
  return (
    <StyledTextArea onChange={onChange} placeholder={placeholder} value={value} height={height} />
  );
};

export default TextArea;
