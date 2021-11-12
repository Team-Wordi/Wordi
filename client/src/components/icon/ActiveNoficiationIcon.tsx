import React from 'react';
import { ReactComponent as ActiveNotificationSVG } from 'assets/icons/notification_on.svg';

interface ActiveNotificationIconProps {
  size?: number;
}

function ActiveNotificationIcon({ size }: ActiveNotificationIconProps): JSX.Element {
  return <ActiveNotificationSVG width={size} height={size} />;
}

export default ActiveNotificationIcon;
