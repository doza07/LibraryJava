CREATE TABLE person
(
    id            bigserial PRIMARY KEY,
    email         VARCHAR(127) NOT NULL UNIQUE,
    pass          VARCHAR      NOT NULL,
    first_name    VARCHAR(127),
    last_name     VARCHAR(127),
    date_of_birth DATE
);
