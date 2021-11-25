import React from 'react';
import { ReactComponent as MessageSVG } from 'assets/icons/message.svg';

interface MessageIconProps {
  size?: number;
  color?: string;
}

function MessageIcon({ size, color }: MessageIconProps): JSX.Element {
  return <MessageSVG width={size} height={size} stroke={color} stroke-width="0.5" />;
}

export default MessageIcon;
