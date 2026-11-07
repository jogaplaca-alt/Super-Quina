import "server-only";
import { cookies } from "next/headers";
import { redirect } from "next/navigation";
import { getSessionUser, SESSION_COOKIE } from "@/lib/auth/session";

export async function requireCashierAppUser() {
  const cookieStore = await cookies();
  const user = await getSessionUser(cookieStore.get(SESSION_COOKIE)?.value);
  if (!user) redirect("/cashier-app-login");
  if (user.role !== "CASHIER") redirect("/cashier-app-login?reason=cashier-only");
  if (user.mustChangePassword) redirect("/cashier-app-change-password");
  return user;
}
