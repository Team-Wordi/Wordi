import React from 'react';
import { ReactComponent as MarketSVG } from 'assets/icons/market.svg';

interface MarketIconProps {
  size?: number;
  color?: string;
}

function MarketIcon({ size, color }: MarketIconProps): JSX.Element {
  return <MarketSVG width={size} height={size} stroke={color} />;
}

export default MarketIcon;
