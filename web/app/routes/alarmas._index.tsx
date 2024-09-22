import {
  json,
  type LoaderFunctionArgs,
  type ActionFunctionArgs,
} from '@remix-run/node'
import { Link, redirect, useLoaderData } from '@remix-run/react'
import { Alarma, defaultAlarmas } from '~/data/Alarmas'
import { COOKIE_NAME, prefs } from '~/prefs/prefs-cookie.server'
import AlarmButton from '~/src/components/AlarmButton'

export const loader = async ({ request }: LoaderFunctionArgs) => {
  const cookieHeader = request.headers.get(COOKIE_NAME)
  const { alarmas } = await prefs.parse(cookieHeader)
  return json({ alarmas: (alarmas || defaultAlarmas) as Alarma[] })
}

export async function action({ params, request }: ActionFunctionArgs) {
  const cookieHeader = request.headers.get('Cookie')
  const parsedCookie = await prefs.parse(cookieHeader)
  const newCookie = {
    ...parsedCookie,
  }
  console.log('alarmas: ', newCookie)
  const formData = await request.formData()
  const email = formData.get('email')
  const password = formData.get('password')
  if (email && password) {
    newCookie['user'] = {
      email,
      password,
    }
  }
  console.log('alarmas: + password', newCookie)
  return redirect('/alarmas', {
    headers: {
      'Set-Cookie': await prefs.serialize(newCookie),
    },
  })
}

export const Dashboard = () => {
  const { alarmas } = useLoaderData<typeof loader>()

  return (
    <div className='flex flex-col h-full w-full pr-10 pl-10'>
      <div className='pt-2 pb-2 flex flex-row w-full justify-start items-center text-white gap-4'>
        <button type='button'>
          <img src='/3d_avatar_1.svg' alt='default-icon' />
        </button>
        <p>Usuario</p>
      </div>
      <div className='pt-2 pb-2 flex flex-row w-full justify-center'>
        <p
          className='text-4xl text-onSecondary text-center'
          style={{
            textShadow: '0 0 6px black',
          }}
        >
          Administracion de Alarmas
        </p>
      </div>
      <div className='pt-2 pb-2 flex flex-row w-full justify-end'>
        <Link
          to='/alarmas/crear'
          type='button'
          className='flex text-black w-fit items-center justify-between w-28 py-2 px-4 border bg-primaryContainer border-transparent rounded-md shadow-sm text-sm font-medium text-white hover:bg-onPrimary focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500'
          style={{
            borderRadius: 100,
            boxShadow: '2px 2px 2px black',
          }}
        >
          <svg
            width='12'
            height='12'
            viewBox='0 0 12 12'
            fill='none'
            xmlns='http://www.w3.org/2000/svg'
          >
            <title>Boton alarma</title>
            <path
              d='M5.25 6.75H0.75V5.25H5.25V0.75H6.75V5.25H11.25V6.75H6.75V11.25H5.25V6.75Z'
              fill='#1D1B20'
            />
          </svg>
          <p className='text-center leading-5 text-black'>Alarma</p>
        </Link>
      </div>
      <div
        className='box-border border-2 border-black rounded-xl h-full bg-surfaceVariant shadow-black'
        style={{
          boxShadow: '4px 4px black',
        }}
      >
        <div className='flex-wrap flex flex-row p-5 justify-around gap-4'>
          {alarmas.map((alarma) => (
            <AlarmButton key={alarma.id} {...alarma} />
          ))}
        </div>
      </div>
    </div>
  )
}
export default Dashboard
