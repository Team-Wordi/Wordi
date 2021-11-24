import React from 'react';
import styled from 'styled-components';

const Container = styled.div<ProfileImgProps>`
  & > img {
    width: ${({ size }) => (size ? `${size}px` : '72px')};
    height: ${({ size }) => (size ? `${size}px` : '72px')};
    border-radius: 28px 28px 10px 10px;
  }
`;

interface ProfileImgProps {
  size?: number | null;
  img?: string | undefined;
}

const ProfileImage = ({ size, img }: ProfileImgProps) => {
  return (
    <Container size={size}>
      <img src={img} alt={img} />
    </Container>
  );
};

export default ProfileImage;
