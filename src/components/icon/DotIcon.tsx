import React from 'react';
import { ReactComponent as DotSvg } from 'assets/icons/dot.svg';

interface DotIconProps {
  size?: number;
  color?: string;
}

function DotIcon({ size, color }: DotIconProps): JSX.Element {
  return <DotSvg width={size} height={size} stroke={color} />;
}

export default DotIcon;
