import React from 'react';
import { ReactComponent as OrderSVG } from 'assets/icons/order.svg';

interface OrderIconProps {
  size?: number;
  color?: string;
}

function OrderIcon({ size, color }: OrderIconProps): JSX.Element {
  return <OrderSVG width={size} height={size} stroke={color} />;
}

export default OrderIcon;
