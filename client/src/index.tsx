import React, { Suspense } from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import GlobalStyles from 'styles/GlobalStyles';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import { BrowserRouter } from 'react-router-dom';
import { RecoilRoot } from 'recoil';
import ScrollToTop from 'components/common/ScrollToTop';

ReactDOM.render(
  <React.StrictMode>
    <RecoilRoot>
      <Suspense fallback={<div>Loading...</div>}>
        <GlobalStyles />
        <BrowserRouter>
          <ScrollToTop />
          <App />
        </BrowserRouter>
      </Suspense>
    </RecoilRoot>
  </React.StrictMode>,
  document.getElementById('root'),
);
