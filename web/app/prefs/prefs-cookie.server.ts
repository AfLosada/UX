import { createCookie } from '@remix-run/node'
export const COOKIE_NAME = 'Cookie'
export const prefs = createCookie("prefs")