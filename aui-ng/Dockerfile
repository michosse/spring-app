FROM node:alpine as angular

WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod
FROM nginx:alpine
COPY --from=angular /app/dist/aui-ng /usr/share/nginx/html
EXPOSE 80
