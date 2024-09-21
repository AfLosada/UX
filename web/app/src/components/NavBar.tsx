import { useEffect, useState } from "react";

const MenuIcon = () => {
	return (
		<svg
			xmlns="http://www.w3.org/2000/svg"
			height="24"
			viewBox="0 0 24 24"
			width="24"
			name="sadas"
		>
			<title>Menu Icon</title>
			<path d="M0 0h24v24H0z" fill="none" />
			<path d="M3 18h18v-2H3v2zm0-5h18v-2H3v2zm0-7v2h18V6H3z" />
		</svg>
	);
};

export default function NavBar() {

	return (
		<div
			className="absolute left-0 top-0 bottom-0 w-16 flex justify-center items-center flex-col"
			style={{ background: "#D0BCFF", boxShadow: '4px 4px 4px rgba(0,0,0,0.25)' }}
		>
			<MenuIcon />
			<button type="button">
				<img src="/3d_avatar_1.svg" alt="default-icon" />
			</button>
		</div>
	);
}
