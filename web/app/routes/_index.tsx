import type { MetaFunction } from "@remix-run/node";
import NavBar from "~/src/components/NavBar";

export const meta: MetaFunction = () => {
  return [
    { title: "New Remix App" },
    { name: "description", content: "Welcome to Remix!" },
  ];
};

export default function Index() {
  return (
    <div>
      
    </div>
  );
}
