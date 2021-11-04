import React from 'react';
import { ReactComponent as RightSvg } from 'assets/icons/right.svg';

interface RightIconProps {
  size?: number;
  color?: string;
}

function RightIcon({ size = 24, color = '#929292' }: RightIconProps): JSX.Element {
  return <RightSvg width={size} height={size} fill={color} />;
}

export default RightIcon;
