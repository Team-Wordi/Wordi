import React from 'react';
import { ReactComponent as TempHambugerSVG } from 'assets/icons/mentorList_hamburger.svg';

interface TempHambugerIconProps {
  size: number;
}

function TempHamburgerIcon({ size }: TempHambugerIconProps): JSX.Element {
  return <TempHambugerSVG width={size} height={size} />;
}

export default TempHamburgerIcon;
