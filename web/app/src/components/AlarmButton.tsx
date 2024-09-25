import { Link } from '@remix-run/react';
import type { Alarma } from '~/data/Alarmas';

export default function AlarmButton({ name, hora, dias, id }: Alarma) {
  return (
    <div className="w-auto flex items-center justify-center">
      <div
        className="border-2 border-black w-fit max-w-md pr-4 pl-4 pt-4 pb-4 bg-white rounded-xl shadow-md flex items-center justify-between space-x-4"
        style={{
          boxShadow: '4px 4px 8px black',
        }}
      >
        <div className="w-full">
          <div className="flex flex-row items-center justify-between">
            <div className="font-semibold text-sm">{name}</div>
            <div className="text-sm text-gray-600">{hora}</div>
          </div>
          <div className="flex gap-1.5">
            {dias.map((isEnabled, i) => (
              <div
                // biome-ignore lint/suspicious/noArrayIndexKey: <explanation>
                key={i}
                className={`border border-primary w-4 h-4 rounded-full shadow-black shadow ${isEnabled ? 'bg-primary' : 'bg-white'}`}
              />
            ))}
          </div>
        </div>
        <div className="flex flex-row gap-4">
          <label className="inline-flex items-center cursor-pointer">
            <input type="checkbox" value="" className="sr-only peer" />
            <div className="relative w-14 h-8 bg-gray-200 peer-focus:outline-none peer-focus:ring-4 peer-focus:ring-primary rounded-full peer peer-checked:after:translate-x-full rtl:peer-checked:after:-translate-x-full peer-checked:after:border-white after:content-[''] after:absolute after:top-[4px] after:start-[2px] after:bg-white after:border-gray-300 after:border after:rounded-full after:h-6 after:w-6 after:transition-all peer-checked:bg-primary" />
          </label>
          <Link className="w-8 h-8 text-primary" to={`/alarmas/configuracion/${id}`}>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
            >
              <title>Settings</title>
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={2}
                d="M10.325 4.317c.426-1.756 2.924-1.756 3.35 0a1.724 1.724 0 002.573 1.066c1.543-.94 3.31.826 2.37 2.37a1.724 1.724 0 001.065 2.572c1.756.426 1.756 2.924 0 3.35a1.724 1.724 0 00-1.066 2.573c.94 1.543-.826 3.31-2.37 2.37a1.724 1.724 0 00-2.572 1.065c-.426 1.756-2.924 1.756-3.35 0a1.724 1.724 0 00-2.573-1.066c-1.543.94-3.31-.826-2.37-2.37a1.724 1.724 0 00-1.065-2.572c-1.756-.426-1.756-2.924 0-3.35a1.724 1.724 0 001.066-2.573c-.94-1.543.826-3.31 2.37-2.37.996.608 2.296.07 2.572-1.065z"
              />
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={2}
                d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"
              />
            </svg>
          </Link>
        </div>
      </div>
    </div>
  );
}
