import React from 'react';
import styled from 'styled-components';

const Img = styled.img<{ width: number; height: number }>`
  width: ${({ width }) => width}px;
  height: ${({ height }) => height}px;
  image-rendering: -webkit-optimize-contrast;
`;

interface BannerImageProps {
  img: string;
  width: number;
  height: number;
}

const BannerImage = ({ img, width, height }: BannerImageProps) => {
  return <Img src={img} alt={img} width={width} height={height} />;
};

export default BannerImage;
