import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import GlobalStyles from 'styles/GlobalStyles';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import { BrowserRouter } from 'react-router-dom';
import { RecoilRoot } from 'recoil';

ReactDOM.render(
  <React.StrictMode>
    <RecoilRoot>
      <GlobalStyles />
      <BrowserRouter>
        <App />
      </BrowserRouter>
    </RecoilRoot>
  </React.StrictMode>,
  document.getElementById('root'),
);
