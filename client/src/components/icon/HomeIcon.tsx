import React from 'react';
import { ReactComponent as HomeSVG } from 'assets/icons/home.svg';
import { COLORS } from 'styles/Theme';

interface HomeIconProps {
  size?: number;
  isActive?: boolean | null;
}

function HomeIcon({ size, isActive }: HomeIconProps): JSX.Element {
  return (
    <HomeSVG
      width={size}
      height={size}
      stroke={isActive ? COLORS.primary : COLORS.gray_03}
      fill={isActive ? COLORS.primary : COLORS.gray_03}
      strokeWidth="0.2"
    />
  );
}

export default HomeIcon;
