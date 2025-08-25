
CREATE TABLE players (
    id SERIAL NOT NULL PRIMARY KEY,
    player_name varchar(255) NOT NULL,
    email varchar(255) NOT NULL
);

CREATE TABLE games (
    id SERIAL NOT NULL PRIMARY KEY,
    title varchar(255) NOT NULL,
    game_date date NOT NULL,
    game_location varchar(255) NOT NULL,
    game_description varchar(255)
);

CREATE TABLE players_games (
    id SERIAL NOT NULL PRIMARY KEY,
    player_id integer NOT NULL,
    game_id integer NOT NULL,
    player_status varchar(255) NOT NULL,
    FOREIGN KEY (player_id) REFERENCES players(id) ON DELETE SET NULL,
    FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE SET NULL
);
