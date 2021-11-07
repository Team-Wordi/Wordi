import React from 'react';
import { ReactComponent as MessageSVG } from 'assets/icons/message.svg';

interface MessageIconProps {
  size?: number;
  color?: string;
  strokeWidth?: number;
}

function MessageIcon({ size, color, strokeWidth }: MessageIconProps): JSX.Element {
  return <MessageSVG width={size} height={size} stroke={color} stroke-width={strokeWidth} />;
}

export default MessageIcon;
