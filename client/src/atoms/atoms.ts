import { atom } from 'recoil';
import { tempMentorData } from 'constants/tempMentorData';

export const monthFilterState = atom<string>({
  key: 'monthFilterState',
  default: '기간',
});

export const isMonthFilterClicked = atom<boolean>({
  key: 'isMonthFilterClicked',
  default: false,
});

export const keywordFilterState = atom<string>({
  key: 'showSuccessState',
  default: '키워드',
});

export const isKeywordFilterClicked = atom<boolean>({
  key: 'isKeywordFilterClicked',
  default: false,
});

export const nationFilterState = atom<string>({
  key: 'nationFilterState',
  default: '관심 국가',
});

export const isNationFilterClicked = atom<boolean>({
  key: 'isNationFilterClicked',
  default: false,
});

export const mentorDataState = atom<any>({
  key: 'mentorDataState',
  default: tempMentorData,
});
