CREATE TABLE "films" (
  "id" uuid PRIMARY KEY,
  "title" varchar NOT NULL,
  "year" int,
  "description" text,
  "age_limit" varchar(3),
  "url_photo" varchar,
  "url_trailer" varchar,
  "url_films" varchar,
  "oscars" boolean
);

CREATE TABLE "actors" (
  "id" uuid PRIMARY KEY,
  "last_name" varchar,
  "name" varchar,
  "surname" varchar
);

CREATE TABLE "genre" (
  "id" int PRIMARY KEY,
  "genre" varchar
);

CREATE TABLE "directors" (
  "id" uuid PRIMARY KEY,
  "last_name" varchar,
  "name" varchar,
  "surname" varchar
);

CREATE TABLE "country" (
  "id" int PRIMARY KEY,
  "country" varchar
);

CREATE TABLE "film_genre" (
  "id_film" uuid,
  "id_genre" int,
  PRIMARY KEY ("id_film", "id_genre")
);

CREATE TABLE "film_director" (
  "id_film" uuid,
  "id_director" uuid,
  PRIMARY KEY ("id_film", "id_director")
);

CREATE TABLE "film_country" (
  "id_film" uuid,
  "id_country" int,
  PRIMARY KEY ("id_film", "id_country")
);

CREATE TABLE "film_actors" (
  "id_film" uuid,
  "id_actor" uuid,
  PRIMARY KEY ("id_film", "id_actor")
);

ALTER TABLE "film_genre" ADD FOREIGN KEY ("id_film") REFERENCES "films" ("id");
ALTER TABLE "film_genre" ADD FOREIGN KEY ("id_genre") REFERENCES "genre" ("id");

ALTER TABLE "film_director" ADD FOREIGN KEY ("id_film") REFERENCES "films" ("id");
ALTER TABLE "film_director" ADD FOREIGN KEY ("id_director") REFERENCES "directors" ("id");

ALTER TABLE "film_actors" ADD FOREIGN KEY ("id_film") REFERENCES "films" ("id");
ALTER TABLE "film_actors" ADD FOREIGN KEY ("id_actor") REFERENCES "actors" ("id");

ALTER TABLE "film_country" ADD FOREIGN KEY ("id_film") REFERENCES "films" ("id");
ALTER TABLE "film_country" ADD FOREIGN KEY ("id_country") REFERENCES "country" ("id");
