import { NextRequest, NextResponse } from "next/server";

const CASHIER_APP_USER_AGENT = "SuperQuinaCashierApp/1";
const ALLOWED_APP_PATHS = ["/cashier", "/cashier-app-login", "/change-password"];

export function proxy(request: NextRequest) {
  const userAgent = request.headers.get("user-agent") ?? "";
  if (!userAgent.includes(CASHIER_APP_USER_AGENT)) {
    return NextResponse.next();
  }

  const pathname = request.nextUrl.pathname;
  const isAllowed = ALLOWED_APP_PATHS.some(
    (allowedPath) => pathname === allowedPath || pathname.startsWith(`${allowedPath}/`),
  );

  if (isAllowed) {
    return NextResponse.next();
  }

  const destination = request.nextUrl.clone();
  destination.pathname = "/cashier";
  destination.search = "";
  return NextResponse.redirect(destination);
}

export const config = {
  matcher: ["/((?!api/|_next/|.*\\..*).*)"],
};
