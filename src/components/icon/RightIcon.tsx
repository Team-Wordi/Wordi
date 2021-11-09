import React from 'react';
import { ReactComponent as RightSvg } from 'assets/icons/right.svg';

interface RightIconProps {
  size?: number;
  color?: string;
  onClick?: () => void | null;
}

function RightIcon({ size, color, onClick }: RightIconProps): JSX.Element {
  return <RightSvg width={size} height={size} stroke={color} onClick={onClick} />;
}

export default RightIcon;
