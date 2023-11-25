BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE pokemon(
    pokemon_id SERIAL PRIMARY KEY,
    api_id int NOT NULL,
    name varchar(50) NOT NULL,
    url varchar(100)

);

COMMIT TRANSACTION;
