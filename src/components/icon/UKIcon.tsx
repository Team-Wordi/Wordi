import React from 'react';
import { ReactComponent as UKSVG } from 'assets/icons/UK.svg';

interface UKIconProps {
  size?: number;
}

function UKIcon({ size }: UKIconProps): JSX.Element {
  return <UKSVG width={size} height={size} />;
}

export default UKIcon;
