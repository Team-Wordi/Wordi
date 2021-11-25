import React from 'react';
import { ReactComponent as MentorSVG } from 'assets/icons/mentor.svg';
import { COLORS } from 'styles/Theme';

interface MentorIconProps {
  size?: number;
  isActive?: boolean | null;
}

function MentorIcon({ size, isActive }: MentorIconProps): JSX.Element {
  return (
    <MentorSVG
      width={size}
      height={size}
      stroke={isActive ? COLORS.primary : COLORS.gray_03}
      fill={isActive ? COLORS.primary : COLORS.gray_03}
      strokeWidth="0.2"
    />
  );
}

export default MentorIcon;
