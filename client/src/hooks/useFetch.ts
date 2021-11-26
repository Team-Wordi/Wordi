import React, { useState, useEffect } from 'react';
import axios from 'axios';

const useFetch = (api: string) => {
  const [url] = useState(api);
  const [value, setValue] = useState([]);

  const fetchData = async () => {
    try {
      const response = await axios.get(url);
      setValue(response.data);
    } catch (e) {
      console.error(e);
    }
  };

  useEffect(() => {
    fetchData();
  }, [url]);

  return [value, setValue];
};

export default useFetch;
