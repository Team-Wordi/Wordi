import React from 'react';
import { ReactComponent as RefreshSVG } from 'assets/icons/refresh.svg';

interface RefreshIconProps {
  size?: number;
  color?: string;
  onClick: () => void;
}

function RefreshIcon({ size, color }: RefreshIconProps): JSX.Element {
  return <RefreshSVG width={size} height={size} stroke={color} fill={color} />;
}

export default RefreshIcon;
