import React from 'react';
import { ReactComponent as LeftSvg } from 'assets/icons/left.svg';

interface LeftIconProps {
  size?: number;
  color?: string;
  onClick: () => void;
}

function LeftIcon({ size, color, onClick }: LeftIconProps): JSX.Element {
  return <LeftSvg width={size} height={size} fill={color} onClick={onClick} />;
}

export default LeftIcon;
