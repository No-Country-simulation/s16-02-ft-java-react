import { NextRequest, NextResponse } from "next/server";

const protectedRoutes = ["/shelter"];

export default function middleware(req: NextRequest) {
  const token = req.cookies.get("token")?.value;
  if (!token && protectedRoutes.includes(req.nextUrl.pathname)) {
    const absoluteURL = new URL("/", req.nextUrl.origin);
    return NextResponse.redirect(absoluteURL.toString());
  }
}
