import { prefs } from "~/prefs/prefs-cookie";

export type Alarma = {
	name: string;
	id: string;
	hora: string;
	dias: boolean[];
};

const defaultAlarmas: Alarma[] = [
	{
		name: "Despertar",
		dias: [true, true, true, true, true, true, true],
		id: "1",
		hora: "05:01",
	},
	{
		name: "Dormir",
		dias: [true, true, true, true, true, true, true],
		id: "2",
		hora: "19:00",
	},
	{
		name: "Escuela",
		dias: [true, true, true, true, true, false, false],
		id: "3",
		hora: "15:00",
	},
];

export const getAlarmas = async (cookie: string) => {
	const cookieStuff: Alarma[] = await prefs.parse(cookie);
	return cookieStuff || defaultAlarmas;
};

export const getAlarma = async (cookie: string, id: string) => {
	return (await getAlarmas(cookie)).find((alarma) => alarma.id === id);
};

export const updateAlarma = async (cookie: string, alarma: Alarma) => {
	const alarmas = (await getAlarmas(cookie)).map((al) =>
		alarma.id === al.id ? alarma : al,
	);
	return alarmas;
};

export const createAlarma = async (cookie: string, alarma: Alarma) => {
	const alarmas = await getAlarmas(cookie);
	alarmas.push(alarma);
	return alarmas;
};

export const dias = ["L", "M", "M", "J", "V", "S", "D"];
