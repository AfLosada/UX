import { Outlet } from "@remix-run/react";
import { useEffect, useState, type ReactNode } from "react";

export const BasePage = ({ children }: { children: ReactNode }) => {
	return (
		<div
			className="flex flex-col justify-start h-full"
			style={{ paddingTop: "10%" }}
		>
			<p className="text-5xl">Administracion de Alarmas</p>
			{children}
		</div>
	);
};
