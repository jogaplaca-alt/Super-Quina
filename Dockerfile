# Aplicação web estática: não instala dependências, não executa Prisma e não usa banco.
FROM node:22-alpine
WORKDIR /app
COPY public/simulador.html ./public/simulador.html
COPY server.mjs ./server.mjs
ENV NODE_ENV=production
ENV PORT=3000
EXPOSE 3000
CMD ["node", "server.mjs"]
