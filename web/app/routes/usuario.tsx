import type { ActionFunctionArgs, LoaderFunctionArgs } from '@remix-run/node'
import {
  Form,
  json,
  redirect,
  useLoaderData,
  useSubmit,
} from '@remix-run/react'
import { useRef, useState } from 'react'
import { COOKIE_NAME, prefs } from '~/prefs/prefs-cookie.server'

export const loader = async ({ request, params }: LoaderFunctionArgs) => {
  const cookieHeader = request.headers.get(COOKIE_NAME)
  const {
    user = {
      image: '/3d_avatar_1.svg',
    },
  } = await prefs.parse(cookieHeader)
  return json({ usuario: user })
}

export const Usuario = () => {
  const { usuario } = useLoaderData<typeof loader>()

  const [nombre, setNombre] = useState(usuario.email)
  const [password, setPassword] = useState(usuario.password)
  const [imagen, setImagen] = useState(usuario.image)

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
        className='flex flex-row'
        style={{
          marginTop: '5%',
          marginBottom: '30%',
        }}
      >
        <div
          className='w-full max-w-md mx-auto p-6 bg-white rounded-lg shadow-md'
          style={{
            boxShadow: '8px 8px 4px black',
            width: 476,
            border: '4px solid black',
          }}
        >
          <div className='flex flex-row w-full'>
            <h1 className='text-4xl font-bold mb-6 text-gray-800'>
              Configuracion de Perfil
            </h1>
            <img src={imagen} className='w-24 h-24' />
          </div>
          <Form className='space-y-4' method='PUT'>
            <div className='space-y-2'>
              <label
                htmlFor='nombre'
                className='block text-sm font-medium text-gray-700'
              >
                Nombre
              </label>
              <input
                id='email'
                type='email'
                name='email'
                className='w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-purple-500 focus:border-purple-500'
                placeholder='123@correo.com'
                value={nombre}
                onChange={(e) => setNombre(e.target.value)}
                required
              />
              <p className='text-gray-600 text-xs'>
                Ingrese el nombre de la alarma
              </p>
            </div>
            <div className='space-y-2'>
              <label
                htmlFor='hora'
                className='block text-sm font-medium text-gray-700'
              >
                Hora
              </label>
              <input
                id='password'
                type='password'
                name='password'
                className='w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-purple-500 focus:border-purple-500'
                placeholder='ingrese una contraseña'
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>
            <div className='space-y-2'>
              <label
                htmlFor='hora'
                className='block text-sm font-medium text-gray-700'
              >
                Imagen
              </label>
              <input
                id='image'
                type='url'
                name='image'
                className='w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-purple-500 focus:border-purple-500'
                placeholder='url de la imagen'
                value={imagen}
                onChange={(e) => setImagen(e.target.value)}
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
              Actualizar
            </button>
          </Form>
        </div>
      </div>
    </>
  )
}

export async function action({ params, request }: ActionFunctionArgs) {
  const formData = await request.formData()
  const usuarioUpdated = {
    email: formData.get('email'),
    password: formData.get('password'),
    image: formData.get('image'),
  }
  const cookie = await prefs.parse(request.headers.get('Cookie'))
  const newCookie = {
    ...cookie,
    user: usuarioUpdated,
  }

  return redirect('/alarmas', {
    headers: {
      'Set-Cookie': await prefs.serialize(newCookie),
    },
  })
}

export default Usuario
