import { ActionFunctionArgs, LoaderFunctionArgs } from '@remix-run/node'
import { Form, json, Link, redirect } from '@remix-run/react'
import { useState } from 'react'
import { defaultAlarmas } from '~/data/Alarmas'
import { COOKIE_NAME, prefs } from '~/prefs/prefs-cookie.server'

export const loader = async ({ request }: LoaderFunctionArgs) => {
  const cookieHeader = request.headers.get('Cookie')
  const parsedCookie = await prefs.parse(cookieHeader)
  console.log('registro loader')
  const cookie = {
    ...parsedCookie,
    alarmas: parsedCookie?.alarmas || defaultAlarmas,
  }
  console.log('cookie: ', cookie)
  return json(
    { ok: true },
    {
      headers: {
        'Set-Cookie': await prefs.serialize(cookie),
      },
    }
  )
}

export const Registro = () => {
  return (
    <>
      <p
        className='text-5xl text-onSecondary text-center'
        style={{
          textShadow: '0 0 6px black',
        }}
      >
        Administracion de Alarmas
      </p>
      <div
        className='w-full max-w-md mx-auto p-6 bg-white rounded-lg shadow-md'
        style={{
          marginTop: '10%',
          boxShadow: '8px 8px 4px black',
          width: 476,
          border: '4px solid black',
          marginBottom: '40%',
        }}
      >
        <h1 className='text-3xl font-bold mb-6 text-gray-800'>Registro</h1>
        <Form className='space-y-4' method='post'>
          <div className='space-y-2'>
            <label
              htmlFor='email'
              className='block text-sm font-medium text-gray-700'
            >
              Correo
            </label>
            <input
              id='email'
              type='email'
              name='email'
              className='w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-purple-500 focus:border-purple-500'
              placeholder='ingrese un correo electrónico'
              required
            />
          </div>
          <div className='space-y-2'>
            <label
              htmlFor='password'
              className='block text-sm font-medium text-gray-700'
            >
              Contraseña
            </label>
            <input
              id='password'
              type='password'
              name='password'
              className='w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-purple-500 focus:border-purple-500'
              placeholder='ingrese una contraseña'
              required
            />
          </div>
          <button
            type='submit'
            className='w-full py-2 px-4 border bg-primary border-transparent rounded-md shadow-sm text-sm font-medium text-white hover:bg-onPrimary focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500'
            style={{
              borderRadius: 100,
              boxShadow: '2px 2px 4px',
            }}
          >
            Registrarse
          </button>
          <button
            type='button'
            className='w-full py-2 px-4 border bg-onSecondary border-gray-300 rounded-md shadow-sm text-sm font-medium text-primary bg-white hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500'
            style={{
              borderRadius: 100,
              boxShadow: '2px 2px 4px',
            }}
          >
            Login
          </button>
        </Form>
      </div>
    </>
  )
}

export async function action({ request }: ActionFunctionArgs) {
  const cookieHeader = request.headers.get('Cookie')
  const parsedCookie = await prefs.parse(cookieHeader)
  const newCookie = {
    ...parsedCookie,
  }
  console.log('registro action')
  console.log('alarmas: ', newCookie)
  const formData = await request.formData()
  const email = formData.get('email')
  const password = formData.get('password')
  const image = formData.get('image')
  console.log({ email, password })
  if (!email || !password) {
    return json({ ok: false })
  }
  newCookie['user'] = {
    email,
    password,
    image: image || '/3d_avatar_1.svg',
  }
  console.log('alarmas: + password', newCookie)
  return redirect('/alarmas', {
    headers: {
      'Set-Cookie': await prefs.serialize(newCookie),
    },
  })
}

export default Registro
