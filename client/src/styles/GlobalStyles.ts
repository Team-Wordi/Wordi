import styled, { createGlobalStyle } from 'styled-components';
import { reset } from 'styled-reset';
import { COLORS } from './Theme';

const GlobalStyles = createGlobalStyle`
${reset}
* {
  box-sizing: border-box;
}

body {
  margin: 0;
  padding: 0;
  font-family: 'Pretendard';
  font-size: 12px;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

button {
  cursor: pointer;
  outline: none;
  border: none;
}
code {
  font-family: source-code-pro, Menlo, Monaco, Consolas, 'Courier New',
    monospace;
}
a {
  text-decoration: none;
  color: inherit;
}
hr {
  // border-color: ${COLORS.primary};
  background-color: ${COLORS.primary};
}
`;

export const Container = styled.div`
  padding: 8px 16px 24px 16px;
  min-height: 100vh;
`;

export default GlobalStyles;
