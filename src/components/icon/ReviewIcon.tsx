import React from 'react';
import { ReactComponent as ReviewSVG } from 'assets/icons/review.svg';

interface ReviewIconProps {
  size?: number;
  color?: string;
}

function ActiveReviewIcon({ size, color }: ReviewIconProps): JSX.Element {
  return <ReviewSVG width={size} height={size} stroke={color} />;
}

export default ActiveReviewIcon;
