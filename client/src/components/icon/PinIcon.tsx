import React from 'react';
import { ReactComponent as PinSVG } from 'assets/icons/Pin.svg';

interface PinIconProps {
  size?: number;
  color?: string;
}

function PinIcon({ size, color }: PinIconProps): JSX.Element {
  return <PinSVG width={size} height={size} stroke={color} stroke-width="0.5" />;
}

export default PinIcon;
