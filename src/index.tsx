import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import GlobalStyles from 'styles/GlobalStyles';
import { BrowserRouter } from 'react-router-dom';

ReactDOM.render(
  <React.StrictMode>
    <GlobalStyles />
    <BrowserRouter basename="http://tTab1204.github.io/Wordi">
      <App />
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root'),
);
