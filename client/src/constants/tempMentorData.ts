/* 백엔드와 연결 후 삭제될 데이터입니다. */
import spreadArms from 'assets/img/mentorImage/spread_arms.png';
import girl from 'assets/img/mentorImage/girl.png';
import airport from 'assets/img/mentorImage/airport.png';

export const tempMentorData = [
  {
    name: '워홀매니아',
    month: '3개월',
    tags: ['집구하기', '서류준비', '룸메찾기', '문화차이'],
    nation: '영국',
    img: spreadArms,
  },
  {
    name: '고민보다Go',
    month: '6개월',
    tags: ['일구하기', '서류준비', '취업비자', '비자연장'],
    nation: '아르헨티나',
    img: girl,
  },
  {
    name: '헌터팡',
    month: '12개월',
    tags: ['비자연장', '서류준비', '현지생활', '현지어학'],
    nation: '프랑스',
    img: airport,
  },
];
