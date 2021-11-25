import React from 'react';
import { ReactComponent as LogoSvg } from 'assets/icons/logo.svg';

interface LogoIconProps {
  size?: number;
}

function LogoIcon({ size }: LogoIconProps): JSX.Element {
  return <LogoSvg width={size} height={size} />;
}

export default LogoIcon;
