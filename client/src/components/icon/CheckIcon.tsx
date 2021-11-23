import React from 'react';
import { ReactComponent as CheckSvg } from 'assets/icons/check.svg';

interface CheckIconProps {
  size?: number;
}

function CheckIcon({ size }: CheckIconProps): JSX.Element {
  return <CheckSvg width={size} height={size} />;
}

export default CheckIcon;
