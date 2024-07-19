import { sessionStatus } from "utils/session";
import { NextRequest, NextResponse } from "next/server";

const protectedRoutes = ["/shelter"];

export default function middleware(req: NextRequest) {
  if (!sessionStatus && protectedRoutes.includes(req.nextUrl.pathname)) {
    const absoluteURL = new URL("/", req.nextUrl.origin);
    return NextResponse.redirect(absoluteURL.toString());
  }
}
