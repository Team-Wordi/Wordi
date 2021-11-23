import { atom } from 'recoil';

export const monthFilterState = atom<string>({
  key: 'monthFilterState',
  default: '기간',
});

export const keywordFilterState = atom<string>({
  key: 'showSuccessState',
  default: '키워드',
});

export const nationFilterState = atom<string>({
  key: 'nationFilterState',
  default: '관심 국가',
});
