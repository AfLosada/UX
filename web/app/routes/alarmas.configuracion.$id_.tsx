import type { ActionFunctionArgs, LoaderFunctionArgs } from "@remix-run/node";
import { Form, json, redirect, useLoaderData } from "@remix-run/react";
import { useState } from "react";
import { dias, getAlarma, updateAlarma } from "~/data/Alarmas";
import { prefs } from "~/prefs/prefs-cookie";
import TimePicker from "~/src/components/TimePicker";

export const loader = async ({ request, params }: LoaderFunctionArgs) => {
	const cookieHeader = request.headers.get("Cookie");
	return json({ alarma: await getAlarma(cookieHeader || "", params.id || "") });
};

export const action = async ({ params, request }: ActionFunctionArgs) => {
	const alarmaUpdated = await request.json();
	const cookieHeader = request.headers.get("Cookie") || "";
	const alarma = updateAlarma(cookieHeader, {
		id: params.id,
		...alarmaUpdated,
	});
	return json(alarma, {
		headers: {
			"Set-Cookie": await prefs.serialize(alarma),
		},
	});
};

export const Configuracion = () => {
	const { alarma } = useLoaderData<typeof loader>();

	const [nombre, setNombre] = useState(alarma?.name);
	const [hora, setHora] = useState(alarma?.hora);
	const [repeticion, setRepeticion] = useState(alarma?.dias);
	const [showTimePicker, setShowTimePicker] = useState(false);

	return (
		<>
			<p
				className="text-5xl text-onSecondary text-center"
				style={{
					textShadow: "0 0 6px black",
				}}
			>
				Administracion de Alarmas
			</p>
			<div
				className="flex flex-row"
				style={{
					marginTop: "20%",
				}}
			>
				<div
					className="w-full max-w-md mx-auto p-6 bg-white rounded-lg shadow-md"
					style={{
						boxShadow: "8px 8px 4px black",
						width: 476,
						border: "4px solid black",
					}}
				>
					<h1 className="text-3xl font-bold mb-6 text-gray-800">
						Configuracion
					</h1>
					<Form className="space-y-4" action="/alarmas/dashboard" method="POST">
						<div className="space-y-2">
							<label
								htmlFor="nombre"
								className="block text-sm font-medium text-gray-700"
							>
								Nombre
							</label>
							<input
								id="nombre"
								type="nombre"
								className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-purple-500 focus:border-purple-500"
								placeholder="Despertar"
								value={nombre}
								onChange={(e) => setNombre(e.target.value)}
								required
							/>
							<p className="text-gray-600 text-xs">
								Ingrese el nombre de la alarma
							</p>
						</div>
						<div className="space-y-2">
							<label
								htmlFor="hora"
								className="block text-sm font-medium text-gray-700"
							>
								Hora
							</label>
							<input
								id="hora"
								type="time"
								className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-purple-500 focus:border-purple-500"
								placeholder="ingrese una contraseña"
								value={hora}
								onChange={(e) => setHora(e.target.value)}
								onClick={() => {
									setShowTimePicker(true);
								}}
								required
							/>
							<p className="text-gray-600 text-xs">Repeticion</p>
							<div className="flex flex-row gap-2">
								{repeticion?.map((habilitado, i) => {
									return (
										<button
											// biome-ignore lint/suspicious/noArrayIndexKey: <explanation>
											key={i}
											type="button"
											onClick={() => {
												setRepeticion((repeticiones = []) => {
													const copy = [...repeticiones];
													repeticiones[i] = !repeticiones[i];
													console.log(repeticiones);
													return copy;
												});
											}}
											className={`content-center border border-primary w-8 h-8 rounded-full shadow-black shadow ${habilitado ? "bg-primary" : "bg-white"}`}
										>
											<p
												className={`text-center ${habilitado ? "text-white" : "text-primary"}`}
											>
												{dias[i]}
											</p>
										</button>
									);
								})}
							</div>
						</div>
						<button
							type="submit"
							className="w-full py-2 px-4 border bg-primary border-transparent rounded-md shadow-sm text-sm font-medium text-white hover:bg-onPrimary focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500"
							style={{
								borderRadius: 100,
								boxShadow: "2px 2px 4px",
							}}
						>
							Configurar
						</button>
						<button
							type="submit"
							className="w-full py-2 px-4 border bg-onSecondary border-gray-300 rounded-md shadow-sm text-sm font-medium text-primary bg-white hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500"
							style={{
								borderRadius: 100,
								boxShadow: "2px 2px 4px",
							}}
						>
							Cancelar
						</button>
					</Form>
				</div>
				{showTimePicker && (
					<TimePicker
						onClose={() => {
							setShowTimePicker(false);
						}}
						onSubmit={(hora: string) => {
							setHora(hora);
							setShowTimePicker(false);
						}}
					/>
				)}
			</div>
		</>
	);
};

export default Configuracion;
