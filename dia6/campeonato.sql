CREATE TABLE "fases" (
  "id_fase" integer PRIMARY KEY,
  "nombre_fase" varchar
);

CREATE TABLE "grupos" (
  "id_grupo" integer PRIMARY KEY,
  "nombre_grupo" varchar
);

CREATE TABLE "equipos" (
  "id_equipo" integer PRIMARY KEY,
  "nombre_equipo" varchar,
  "pais" varchar,
  "id_grupo" integer
);

CREATE TABLE "partidos" (
  "id_partido" integer PRIMARY KEY,
  "id_fase" integer
);

CREATE TABLE "partido_equipo" (
  "id_partido" integer,
  "id_equipo" integer,
  "resultado" varchar,
  PRIMARY KEY ("id_partido", "id_equipo")
);

CREATE TABLE "jugadores" (
  "id_jugador" integer PRIMARY KEY,
  "nombre_jugador" varchar,
  "nacionalidad" varchar,
  "id_equipo" integer
);

ALTER TABLE "equipos" ADD FOREIGN KEY ("id_grupo") REFERENCES "grupos" ("id_grupo");

ALTER TABLE "partidos" ADD FOREIGN KEY ("id_fase") REFERENCES "fases" ("id_fase");

ALTER TABLE "partido_equipo" ADD FOREIGN KEY ("id_partido") REFERENCES "partidos" ("id_partido");

ALTER TABLE "partido_equipo" ADD FOREIGN KEY ("id_equipo") REFERENCES "equipos" ("id_equipo");

ALTER TABLE "jugadores" ADD FOREIGN KEY ("id_equipo") REFERENCES "equipos" ("id_equipo");
