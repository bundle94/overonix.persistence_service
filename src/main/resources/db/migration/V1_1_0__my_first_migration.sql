CREATE TABLE players (
   id int PRIMARY KEY IDENTITY (1, 1),
   uuid varchar(36) NOT NULL,
   email varchar(50) NOT NULL,
   password varchar(255) NOT NULL
);