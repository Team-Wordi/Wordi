import React from 'react';
import { ReactComponent as HambugerSVG } from 'assets/icons/hambuger.svg';

interface HambugerIconProps {
  size?: number;
  color?: string;
  onClick: () => void;
}

function HambuguerIcon({ size, color, onClick }: HambugerIconProps): JSX.Element {
  return <HambugerSVG width={size} height={size} stroke={color} onClick={onClick} />;
}

export default HambuguerIcon;
