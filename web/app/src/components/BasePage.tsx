import { Outlet } from '@remix-run/react';
import { type ReactNode, useEffect, useState } from 'react';

export const BasePage = ({ children }: { children: ReactNode }) => {
  return (
    <div className="overflow-hidden flex flex-col justify-start h-full w-full pr-40 pl-40 pt-20 pb-5">
      {children}
    </div>
  );
};
