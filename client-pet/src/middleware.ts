import { NextRequest, NextResponse } from "next/server";

const protectedShelterRoutes = [
  "/shelter",
  "/shelter/profile",
  "/shelter/pets",
  "/shelter/manage",
  "/shelter/request",
];
const protectedUserRoutes = ["/profile"];

export default function middleware(req: NextRequest) {
  const token = req.cookies.get("token")?.value;
  const role = req.cookies.get("role")?.value;
  if (!token && protectedShelterRoutes.includes(req.nextUrl.pathname)) {
    const absoluteURL = new URL("/", req.nextUrl.origin);
    return NextResponse.redirect(absoluteURL.toString());
  }

  if (
    role !== "ROLE_SHELTER" &&
    protectedShelterRoutes.includes(req.nextUrl.pathname)
  ) {
    const absoluteURL = new URL("/", req.nextUrl.origin);
    return NextResponse.redirect(absoluteURL.toString());
  }

  if (
    role !== "ROLE_USER" &&
    protectedUserRoutes.includes(req.nextUrl.pathname)
  ) {
    const absoluteURL = new URL("/", req.nextUrl.origin);
    return NextResponse.redirect(absoluteURL.toString());
  }
}
