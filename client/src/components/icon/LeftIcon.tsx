import React from 'react';
import { ReactComponent as LeftSvg } from 'assets/icons/left.svg';

interface LeftIconProps {
  size?: number;
  color?: string;
  onClick?: () => void | null;
}

function LeftIcon({ size, color, onClick }: LeftIconProps): JSX.Element {
  return (
    <LeftSvg
      width={size}
      height={size}
      stroke={color}
      fill={color}
      strokeWidth="0.2"
      onClick={onClick}
    />
  );
}

export default LeftIcon;
