import React from 'react';
import styled from 'styled-components';
import { COLORS } from 'styles/Theme';
import example from 'assets/img/example_profile_img.png';

const Container = styled.div<ProfileImgProps>`
  & > img {
    width: ${({ size }) => (size ? `${size}px` : '72px')};
    width: ${({ size }) => (size ? `${size}px` : '72px')};
    border-radius: 28px 28px 10px 10px;
  }
`;

interface ProfileImgProps {
  size?: number | null;
  imgURL?: string | null;
}

const ProfileImage = ({ size, imgURL }: ProfileImgProps) => {
  return (
    <Container size={size}>
      {/* 이미지 주소는 실제 기능 개발 시 imgURL로 대체 예정 */}
      <img src={example} alt={example} />
    </Container>
  );
};

export default ProfileImage;
