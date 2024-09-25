import type { Config } from 'tailwindcss';

export default {
  content: ['./app/**/{**,.client,.server}/**/*.{js,jsx,ts,tsx}'],
  theme: {
    extend: {
      fontFamily: {
        sans: ['Roboto'],
      },
      colors: {
        primary: '#65558F',
        onPrimary: '#4F378A',
        primaryContainer: '#EADDFF',
        secondary: '#E8DEF8',
        onSecondary: '#FFFFFF',
        onSurface: '#1D1B20',
        surfaceVariant: '#E7E0EC',
      },
    },
  },
  plugins: [],
} satisfies Config;
