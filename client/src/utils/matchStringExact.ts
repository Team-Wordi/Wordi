export const matchExact = (target: any, string: string) => {
  const match = string.match(target);
  return match && string === match[0];
};
