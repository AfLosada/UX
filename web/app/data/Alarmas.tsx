export type Alarma = {
	name: string;
	id: string;
	hora: string;
	dias: boolean[];
};

export const defaultAlarmas: Alarma[] = [
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

export const dias = ["L", "M", "M", "J", "V", "S", "D"];
