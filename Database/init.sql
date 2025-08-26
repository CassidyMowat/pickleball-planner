
CREATE TABLE IF NOT EXISTS players (
    id SERIAL NOT NULL PRIMARY KEY,
    game_id integer,
    player_name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    invite_status varchar(255),
    FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE SET NULL,
);

CREATE TABLE IF NOT EXISTS games (
    id SERIAL NOT NULL PRIMARY KEY,
    title varchar(255) NOT NULL,
    game_date date NOT NULL,
    game_location varchar(255) NOT NULL,
    game_description varchar(255)
);


INSERT INTO games (id, title, game_date, game_location, game_description) VALUES 
(DEFAULT, 'test game', '2025-08-25', 'test location', 'test description');
