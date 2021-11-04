export const dateConverter = (date: string | undefined) => {
  const year = date?.substring(2, 4) + '년 ';
  const month = date?.substring(5, 7) + '월 ';
  const day = date?.substring(8) + '일 ';

  const newDate = year + month + day;

  return newDate;
};
