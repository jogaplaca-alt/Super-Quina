import { NextRequest, NextResponse } from "next/server";

/**
 * Navigation restrictions are intentionally not enforced here yet.
 * The cashier workflow depends on several page and API routes; keep all
 * existing navigation available until the complete route/dependency audit
 * is finished and tested end-to-end.
 */
export function proxy(_request: NextRequest) {
  return NextResponse.next();
}

export const config = {
  matcher: ["/((?!api/|_next/|.*\\..*).*)"],
};
