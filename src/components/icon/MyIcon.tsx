import React from 'react';
import { ReactComponent as MySVG } from 'assets/icons/my.svg';

interface MyIconProps {
  size?: number;
  color?: string;
}

function MyIcon({ size, color }: MyIconProps): JSX.Element {
  return <MySVG width={size} height={size} stroke={color} />;
}

export default MyIcon;
