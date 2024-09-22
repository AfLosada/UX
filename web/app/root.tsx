import {
  json,
  Links,
  Meta,
  Outlet,
  Scripts,
  ScrollRestoration,
  useLoaderData,
} from '@remix-run/react'
import type { LinksFunction, LoaderFunctionArgs } from '@remix-run/node'

import './tailwind.css'
import NavBar from './src/components/NavBar'
import { BasePage } from './src/components/BasePage'
import { COOKIE_NAME, prefs } from './prefs/prefs-cookie.server'

export const links: LinksFunction = () => [
  { rel: 'preconnect', href: 'https://fonts.googleapis.com' },
  {
    rel: 'preconnect',
    href: 'https://fonts.gstatic.com',
    crossOrigin: 'anonymous',
  },
  {
    rel: 'stylesheet',
    href: 'https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&display=swap',
  },
  {
    rel: 'stylesheet',
    href: 'https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap',
  },
]

export const loader = async ({ request, params }: LoaderFunctionArgs) => {
  const cookieHeader = request.headers.get(COOKIE_NAME)
  const { user = {} } = await prefs.parse(cookieHeader)
  return json({ usuario: user })
}

export function Layout({ children }: { children: React.ReactNode }) {
  const { usuario } = useLoaderData<typeof loader>()
	console.log(usuario)
  return (
    <html lang='en'>
      <head>
        <meta charSet='utf-8' />
        <meta name='viewport' content='width=device-width, initial-scale=1' />
        <Meta />
        <Links />
      </head>
      <body>
        <div
          className='flex h-screen items-center justify-center'
          style={{ background: '#9884c4' }}
        >
          <NavBar usuario={usuario} />
          <BasePage>
            <Outlet />
          </BasePage>
        </div>
        <ScrollRestoration />
        <Scripts />
      </body>
    </html>
  )
}

export default function App() {
  return <Outlet />
}
