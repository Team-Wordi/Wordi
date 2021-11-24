import React from 'react';
import Canada from 'assets/img/nations/Canada.png';
import Japan from 'assets/img/nations/Japan.png';
import Denmark from 'assets/img/nations/Denmark.png';
import France from 'assets/img/nations/France.png';
import Germany from 'assets/img/nations/Germany.png';
import Hongkong from 'assets/img/nations/Hongkong.png';
import Italy from 'assets/img/nations/Italy.png';
import Argentina from 'assets/img/nations/Argentina.png';
import Australia from 'assets/img/nations/Australia.png';
import UK from 'assets/img/nations/UK.png';

type NationName =
  | '캐나다'
  | '일본'
  | '덴마크'
  | '프랑스'
  | '독일'
  | '홍콩'
  | '이탈리아'
  | '아르헨티나'
  | '호주'
  | '영국';

interface NationProps {
  name?: NationName;
}

type NationType = {
  [index: string]: string;
  캐나다: string;
  일본: string;
  덴마크: string;
  프랑스: string;
  독일: string;
  홍콩: string;
  이탈리아: string;
  아르헨티나: string;
  호주: string;
  영국: string;
};

const nations: NationType = {
  캐나다: Canada,
  일본: Japan,
  덴마크: Denmark,
  프랑스: France,
  독일: Germany,
  홍콩: Hongkong,
  이탈리아: Italy,
  아르헨티나: Argentina,
  호주: Australia,
  영국: UK,
};

const Nation = ({ name }: NationProps): JSX.Element => <img src={nations[name!]} alt={name} />;

export default Nation;
