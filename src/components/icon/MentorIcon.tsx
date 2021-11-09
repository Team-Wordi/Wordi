import React from 'react';
import { ReactComponent as MentorSVG } from 'assets/icons/mentor.svg';

interface MentorIconProps {
  size?: number;
  color?: string;
}

function MentorIcon({ size, color }: MentorIconProps): JSX.Element {
  return <MentorSVG width={size} height={size} stroke={color} />;
}

export default MentorIcon;
