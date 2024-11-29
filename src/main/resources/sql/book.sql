CREATE TABLE book
(
    id          bigserial PRIMARY KEY,
    title       VARCHAR(127) NOT NULL,
    author      VARCHAR(127) NOT NULL,
    description VARCHAR(1024),
    publication TIMESTAMP(127),
    is_free     boolean,
    renter      INT REFERENCES person (id)
);
