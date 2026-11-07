import http from "node:http";
import { readFile } from "node:fs/promises";
import { join } from "node:path";

const port = Number(process.env.PORT || 3000);
const host = "0.0.0.0";
const pagePath = join(process.cwd(), "public", "simulador.html");

const server = http.createServer(async (request, response) => {
  const pathname = new URL(request.url || "/", "http://localhost").pathname;

  if (request.method !== "GET" && request.method !== "HEAD") {
    response.writeHead(405, { Allow: "GET, HEAD" });
    response.end();
    return;
  }

  if (pathname !== "/" && pathname !== "/simulador.html") {
    response.writeHead(404, { "Content-Type": "text/plain; charset=utf-8", "Cache-Control": "no-store" });
    response.end("Página não encontrada");
    return;
  }

  try {
    const html = await readFile(pagePath);
    response.writeHead(200, {
      "Content-Type": "text/html; charset=utf-8",
      "Content-Length": html.length,
      "Cache-Control": "no-store, no-cache, must-revalidate",
      "X-Content-Type-Options": "nosniff",
      "X-Frame-Options": "SAMEORIGIN"
    });
    response.end(request.method === "HEAD" ? undefined : html);
  } catch {
    response.writeHead(500, { "Content-Type": "text/plain; charset=utf-8" });
    response.end("Não foi possível carregar o simulador.");
  }
});

server.listen(port, host, () => {
  console.log(`Simulador web disponível na porta ${port}`);
});
