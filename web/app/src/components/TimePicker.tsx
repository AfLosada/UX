import { useState } from "react";

export enum DayPeriod {
	AM = "AM",
	PM = "PM",
}

export const TimePicker = ({
	onClose,
	onSubmit,
}: { onClose: () => void; onSubmit: (hora: string) => void }) => {
	const [selectedPeriod, setSelectedPeriod] = useState(DayPeriod.PM);
	const [selectedHour, setSelectedHour] = useState("");
	const [selectedMinute, setSelectedMinute] = useState("");
	return (
		<div className="bg-primaryContainer p-6 rounded-3xl shadow-lg w-80 h-fit">
			<h2 className="text-primary text-xl mb-4">Enter time</h2>
			<div className="flex items-center justify-between mb-4">
				<div className="w-24 h-16 bg-white rounded-xl flex items-center justify-center border-2 border-primary">
					<input
						type="number"
						className="text-4xl text-primary w-full text-center bg-transparent focus:outline-none"
						placeholder="09"
						maxLength={2}
						value={selectedHour}
						onChange={(e) => setSelectedHour(e.target.value)}
					/>
				</div>
				<span className="text-4xl text-primary">:</span>
				<div className="w-24 h-16 bg-white rounded-xl flex items-center justify-center">
					<input
						type="number"
						className="text-4xl text-primary w-full text-center bg-transparent focus:outline-none"
						placeholder="00"
						maxLength={2}
						value={selectedMinute}
						onChange={(e) => setSelectedMinute(e.target.value)}
					/>
				</div>
				<div className="w-16  h-16 bg-white rounded-xl flex flex-col text-center">
					<button
						type="button"
						className={`h-1/2 border border-primary text-primary font-bold ${selectedPeriod === DayPeriod.AM ? "bg-secondary" : ""} text-primary rounded-t-xl`}
						onClick={() => {
							setSelectedPeriod(DayPeriod.AM);
						}}
					>
						AM
					</button>
					<button
						type="button"
						className={`h-1/2 border border-primary text-primary font-bold ${selectedPeriod === DayPeriod.PM ? "bg-secondary" : ""} rounded-b-xl`}
						onClick={() => {
							setSelectedPeriod(DayPeriod.PM);
						}}
					>
						PM
					</button>
				</div>
			</div>
			<div className="flex items-center justify-between text-primary text-sm mb-6">
				<span>Hour</span>
				<span className="ml-6">Minute</span>
			</div>
			<div className="flex items-center justify-between">
				<button type="button" className="text-primary">
					<svg
						xmlns="http://www.w3.org/2000/svg"
						className="h-6 w-6"
						fill="none"
						viewBox="0 0 24 24"
						stroke="currentColor"
					>
						<title>Date icon</title>
						<path
							stroke-linecap="round"
							stroke-linejoin="round"
							stroke-width="2"
							d="M12 8v4l3 3m6-3a9 9 0 11-18 0 9 9 0 0118 0z"
						/>
					</svg>
				</button>
				<div>
					<button type="button" className="text-primary mr-4" onClick={onClose}>
						Cancel
					</button>
					<button
						type="button"
						className="text-primary font-bold"
						onClick={() =>
							onSubmit(
								`${selectedPeriod === DayPeriod.AM ? selectedHour : Number(selectedHour) + 12}:${selectedMinute}`,
							)
						}
					>
						OK
					</button>
				</div>
			</div>
		</div>
	);
};

export default TimePicker;
