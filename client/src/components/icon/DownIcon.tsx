import React from 'react';
import { ReactComponent as DownSvg } from 'assets/icons/down.svg';

interface DownIconProps {
  size?: number;
  color?: string;
}

function DownIcon({ size, color }: DownIconProps): JSX.Element {
  return <DownSvg width={size} height={size} stroke={color} fill={color} strokeWidth="0.5" />;
}

export default DownIcon;
