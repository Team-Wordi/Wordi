import React from 'react';
import { ReactComponent as ActiveNotificationSVG } from 'assets/icons/notification_on.svg';

interface ActiveNotificationIconProps {
  size?: number;
  color?: string;
}

function ActiveNotificationIcon({ size, color }: ActiveNotificationIconProps): JSX.Element {
  return <ActiveNotificationSVG width={size} height={size} stroke={color} fill={color} />;
}

export default ActiveNotificationIcon;
