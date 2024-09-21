import type { MetaFunction } from "@remix-run/node";
import { Link, useNavigate } from "@remix-run/react";
import { useEffect, useState } from "react";

export const meta: MetaFunction = () => {
	return [
		{ title: "Administracion de Alarmas" },
		{
			name: "description",
			content: "Bienvenida a la página de administración de alarmas",
		},
	];
};

export default function Index() {
	return (
		<div>
			<p
				className="text-5xl text-onSecondary text-center"
				style={{
					textShadow: "0 0 6px black",
				}}
			>
				Administracion de Alarmas
			</p>
			<div
				className="flex flex-col justify-start items-center gap-8"
				style={{ paddingTop: "50%" }}
			>
				<Link to="/registro">
					<button
						type="button"
						style={{
							width: 278,
							padding: 10,
							background: "black",
							borderRadius: 100,
							boxShadow: "4px 4px 4px black",
							color: "white",
						}}
					>
						Registrarse
					</button>
				</Link>
				<button
					type="button"
					style={{
						width: 278,
						padding: 10,
						background: "white",
						borderRadius: 100,
						boxShadow: "4px 4px 4px black",
						color: "black",
					}}
				>
					Login
				</button>
			</div>
		</div>
	);
}
