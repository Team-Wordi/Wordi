import React from 'react';
import { ReactComponent as FlatDotSVG } from 'assets/icons/flat_dot.svg';

interface FlatDotIconProps {
  size?: number;
  color?: string;
}

function FlatDotIcon({ size, color }: FlatDotIconProps): JSX.Element {
  return <FlatDotSVG width={size} height={size} stroke={color} />;
}

export default FlatDotIcon;
