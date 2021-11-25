import React from 'react';
import { ReactComponent as TempNotificationSVG } from 'assets/icons/mentorList_notification.svg';

interface TempNotificationIconProps {
  size: number;
}

function TempNotificationIcon({ size }: TempNotificationIconProps): JSX.Element {
  return <TempNotificationSVG width={size} height={size} />;
}

export default TempNotificationIcon;
