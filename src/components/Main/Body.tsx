import React from 'react';
import Countries from './Countries';
import MentiReviews from './MentiReviews';
import MentorTips from './MentorTips';
import PopularMentors from './PopularMentors';

const Body = () => {
  return (
    <>
      <Countries />
      <MentorTips />
      <MentiReviews />
      <PopularMentors />
    </>
  );
};

export default Body;
