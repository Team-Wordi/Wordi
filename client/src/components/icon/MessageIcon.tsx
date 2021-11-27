import React from 'react';
import { ReactComponent as MessageSVG } from 'assets/icons/message.svg';

interface MessageIconProps {
  size: number;
  color: string;
}

function MessageIcon({ size, color }: MessageIconProps): JSX.Element {
  return <MessageSVG width={size} height={size} stroke={color} fill={color} strokeWidth="0.2" />;
}

export default MessageIcon;
