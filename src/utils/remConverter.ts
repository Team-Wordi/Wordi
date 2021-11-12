const fontSize = 12;

export const rem = (value: number): string => {
  return `${value / fontSize}rem`;
};
