import React from 'react';
import { ReactComponent as RefreshSVG } from 'assets/icons/refresh.svg';

interface RefreshIconProps {
  size?: number;
  color?: string;
  onClick: () => void;
}

function RefreshIcon({ size, color, onClick }: RefreshIconProps): JSX.Element {
  return <RefreshSVG width={size} height={size} stroke={color} fill={color} onClick={onClick} />;
}

export default RefreshIcon;
