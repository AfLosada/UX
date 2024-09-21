import type { Config } from "tailwindcss";

export default {
  content: ["./app/**/{**,.client,.server}/**/*.{js,jsx,ts,tsx}"],
  theme: {
    extend: {
      fontFamily: {
        sans: [
          "Roboto"
        ],
      },
      colors: {
        primary: '#65558F',
        primaryContainer: '#EADDFF',
        onSurface: '#1D1B20'
      }
    },
  },
  plugins: [],
} satisfies Config;
