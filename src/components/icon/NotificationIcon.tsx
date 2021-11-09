import React from 'react';
import { ReactComponent as NotificationSVG } from 'assets/icons/notification_off.svg';

interface NotificationIconProps {
  size?: number;
  color?: string;
}

function NotificationIcon({ size, color }: NotificationIconProps): JSX.Element {
  return <NotificationSVG width={size} height={size} fill={color} />;
}

export default NotificationIcon;
