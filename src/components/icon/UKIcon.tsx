import React from 'react';
import { ReactComponent as UKSVG } from 'assets/icons/UK.svg';

interface UKIconProps {
  size?: number;
  color?: string;
}

function UKIcon({ size, color }: UKIconProps): JSX.Element {
  return <UKSVG width={size} height={size} stroke={color} />;
}

export default UKIcon;
