# Administracion de Alarmas APP

This app was created for the UX course of the Masters in Software Engineering. I decided to build it using remix + vite, as I wanted to learn how to work in these SSR frameworks. The app is also hosted in vercel and can be found by asking me for the link.

## Notes:

- There is no database connection, all state is stored in cookies that are SSR'd
- There is no real user management.

# Requirements

A node/javascript runtime ([npm](https://www.npmjs.com/) or [bun](https://bun.sh/)). We recommend the following versions:
- node: 20.10.0 or greater (this one requires npm > 10.2.3)
- bun: 1.1.18 or greater

# Instructions

1. Install the dependencies, you can use any of these commands (given the requirements above)
  - `bun install`
  - `npm install`
2. You have two options: 
  - Build and serve the app
    - Execute the following command(s) in your terminal: `npm run build && npm run serve`. If you are using bun replace `npm` for `bun`.
    - Open the app in `http://localhost:3000`
  - Run the app on dev mode
    - Exetue the following command(s) in your terminal: `npm run dev`. If you are using bun replace `npm` for `bun`.
    - Open the app in `http://localhost:5173`
3. Done!