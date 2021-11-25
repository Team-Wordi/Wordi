import React from 'react';
import { ReactComponent as CancelSvg } from 'assets/icons/cancel.svg';

interface CancelIconProps {
  size?: number;
  color?: string;
  onClick: () => void;
}

function CancelIcon({ size, color, onClick }: CancelIconProps): JSX.Element {
  return <CancelSvg width={size} height={size} stroke={color} onClick={onClick} />;
}

export default CancelIcon;
