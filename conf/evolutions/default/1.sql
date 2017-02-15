
# Rooms schema

# --- !Ups

CREATE TABLE Rooms
(
  room_id SERIAL PRIMARY KEY,
  username character varying,
  password character varying
);

CREATE TABLE Characters
(
  room_id integer REFERENCES Rooms (room_id),
  character character varying
);


# --- !Downs
DROP TABLE Characters;
DROP TABLE Rooms;