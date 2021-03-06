import React from 'react';
import { ReactComponent as MySVG } from 'assets/icons/my.svg';
import { COLORS } from 'styles/Theme';

interface MyIconProps {
  size?: number;
  isActive?: boolean | null;
}

function MyIcon({ size, isActive }: MyIconProps): JSX.Element {
  return (
    <MySVG
      width={size}
      height={size}
      stroke={isActive ? COLORS.primary : COLORS.gray_03}
      fill={isActive ? COLORS.primary : COLORS.gray_03}
      strokeWidth="0.2"
    />
  );
}

export default MyIcon;
