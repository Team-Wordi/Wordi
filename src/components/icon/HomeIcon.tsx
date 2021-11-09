import React from 'react';
import { ReactComponent as HomeSVG } from 'assets/icons/home.svg';

interface HomeIconProps {
  size?: number;
  color?: string;
}

function HomeIcon({ size = 22, color = '#929292' }: HomeIconProps): JSX.Element {
  return <HomeSVG width={size} height={size} stroke={color} />;
}

export default HomeIcon;
