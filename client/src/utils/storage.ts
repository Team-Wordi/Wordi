interface Istorage {
  get: (key: string) => any | null;
  set: (key: string, data: any) => void;
  remove: (key: string) => void;
  clear: () => void;
}

const storage: Istorage = {
  get(key: string) {
    const data: string | null = localStorage.getItem(key);
    if (!data) return null;
    return JSON.parse(data);
  },
  set(key: string, value: any) {
    localStorage.setItem(key, JSON.stringify(value));
  },
  remove(key: string) {
    localStorage.removeItem(key);
  },
  clear() {
    localStorage.clear();
  },
};

export default storage;
