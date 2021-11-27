import React from 'react';
import { ReactComponent as SmileSvg } from 'assets/icons/smile.svg';

interface SmileIconProps {
  size?: number;
  color?: string;
}

function SmileIcon({ size, color }: SmileIconProps): JSX.Element {
  return <SmileSvg width={size} height={size} stroke={color} strokeWidth="0.5" />;
}

export default SmileIcon;
