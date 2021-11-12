import React from 'react';
import { ReactComponent as ActiveReviewSVG } from 'assets/icons/review.svg';
import { COLORS } from 'styles/Theme';

interface ActiveReviewIconProps {
  size?: number;
  isActive?: boolean | null;
}

function ActiveReviewIcon({ size, isActive }: ActiveReviewIconProps): JSX.Element {
  return (
    <ActiveReviewSVG
      width={size}
      height={size}
      stroke={isActive ? COLORS.primary : COLORS.gray_03}
    />
  );
}

export default ActiveReviewIcon;
