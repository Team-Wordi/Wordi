import axios from 'axios';
import { showMentorListAPI } from 'constants/api';
import { atom, selector } from 'recoil';

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
  default: [],
});

export const getMentorData = selector<any>({
  key: 'getMentorData',
  get: async () => {
    const response = await axios.get(showMentorListAPI);
    return response.data;
  },
});
