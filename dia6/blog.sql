CREATE TABLE "usuarios" (
  "id" integer PRIMARY KEY,
  "username" varchar,
  "email" varchar,
  "role" varchar,
  "created_at" timestamp
);

CREATE TABLE "posts" (
  "id" integer PRIMARY KEY,
  "titulo" varchar,
  "mensaje" text,
  "user_id" integer,
  "estado" varchar,
  "created_at" timestamp
);

CREATE TABLE "comentarios" (
  "id" integer PRIMARY KEY,
  "comentario" text,
  "user_id" integer,
  "post_id" integer,
  "estado" varchar,
  "created_at" timestamp
);

CREATE TABLE "seguidores" (
  "seguidor_user_id" integer,
  "seguido_user_id" integer,
  "created_at" timestamp
);

COMMENT ON COLUMN "posts"."mensaje" IS 'Cuerpo del post';

COMMENT ON COLUMN "comentarios"."comentario" IS 'Comentario sobre un post';

ALTER TABLE "posts" ADD FOREIGN KEY ("user_id") REFERENCES "usuarios" ("id");

ALTER TABLE "comentarios" ADD FOREIGN KEY ("user_id") REFERENCES "usuarios" ("id");

ALTER TABLE "comentarios" ADD FOREIGN KEY ("post_id") REFERENCES "posts" ("id");

ALTER TABLE "seguidores" ADD FOREIGN KEY ("seguidor_user_id") REFERENCES "usuarios" ("id");

ALTER TABLE "seguidores" ADD FOREIGN KEY ("seguido_user_id") REFERENCES "usuarios" ("id");
