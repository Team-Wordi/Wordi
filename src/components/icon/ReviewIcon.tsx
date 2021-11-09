import React from 'react';
import { ReactComponent as ReviewSVG } from 'assets/icons/review.svg';
import { COLORS } from 'styles/Theme';

interface ReviewIconProps {
  size?: number;
  isActive?: boolean | null;
}

function ReviewIcon({ size, isActive }: ReviewIconProps): JSX.Element {
  return (
    <ReviewSVG width={size} height={size} stroke={isActive ? COLORS.primary : COLORS.gray_03} />
  );
}

export default ReviewIcon;
