import React from 'react';
import { ReactComponent as OrderSVG } from 'assets/icons/order.svg';
import { COLORS } from 'styles/Theme';

interface OrderIconProps {
  size?: number;
  isActive?: boolean | null;
}

function OrderIcon({ size, isActive }: OrderIconProps): JSX.Element {
  return (
    <OrderSVG
      width={size}
      height={size}
      stroke={isActive ? COLORS.primary : COLORS.gray_03}
      fill={isActive ? COLORS.primary : COLORS.gray_03}
      strokeWidth="0.2"
    />
  );
}

export default OrderIcon;
