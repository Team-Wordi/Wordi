import React from 'react';
import { ReactComponent as ReviewSVG } from 'assets/icons/review.svg';

interface ReviewIconProps {
  size?: number;
  color: string;
}

function ReviewIcon({ size, color }: ReviewIconProps): JSX.Element {
  return <ReviewSVG width={size} height={size} stroke={color} fill={color} stroke-width="0.5" />;
}

export default ReviewIcon;
