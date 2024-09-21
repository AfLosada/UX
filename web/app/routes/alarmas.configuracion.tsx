import { Form } from "@remix-run/react";
import { useState } from "react";
import TimePicker from "~/src/components/TimePicker";

export const Configuracion = () => {
	const [nombre, setNombre] = useState("");
	const [hora, setHora] = useState("");

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
							<p className="text-gray-600 text-xs">
								Ingrese la hora de la alarma
							</p>
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
							type="button"
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
