import { useState } from "react";

export const Registro = () => {
	const [email, setEmail] = useState("");
	const [password, setPassword] = useState("");

	const handleSubmit = (e: React.FormEvent) => {
		e.preventDefault();
		console.log("Form submitted:", { email, password });
	};
	return (
		<div
			className="w-full max-w-md mx-auto p-6 bg-white rounded-lg shadow-md"
			style={{ marginTop: "20%", boxShadow: '8px 8px 4px black', width: 476, border: '4px solid black' }}
		>
			<h1 className="text-3xl font-bold mb-6 text-gray-800">Registro</h1>
			<form onSubmit={handleSubmit} className="space-y-4">
				<div className="space-y-2">
					<label
						htmlFor="email"
						className="block text-sm font-medium text-gray-700"
					>
						Correo
					</label>
					<input
						id="email"
						type="email"
						className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-purple-500 focus:border-purple-500 bg-white"
						placeholder="ingrese un correo electrónico"
						value={email}
						onChange={(e) => setEmail(e.target.value)}
						required
					/>
				</div>
				<div className="space-y-2">
					<label
						htmlFor="password"
						className="block text-sm font-medium text-gray-700"
					>
						Contraseña
					</label>
					<input
						id="password"
						type="password"
						className="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-purple-500 focus:border-purple-500 bg-white"
						placeholder="ingrese una contraseña"
						value={password}
						onChange={(e) => setPassword(e.target.value)}
						required
					/>
				</div>
				<button
					type="submit"
					className="w-full py-2 px-4 border bg-primary border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-purple-600 hover:bg-purple-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500"
				>
					Registrarse
				</button>
				<button
					type="button"
					className="w-full py-2 px-4 border bg-onSecondary border-gray-300 rounded-md shadow-sm text-sm font-medium text-primary bg-white hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-purple-500"
				>
					Login
				</button>
			</form>
		</div>
	);
};

export default Registro;
