CREATE TABLE client
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3)
);

CREATE TABLE planet
(
    id   VARCHAR(30) PRIMARY KEY CHECK (id REGEXP '^[A-Z]*$'),
    name VARCHAR(500) NOT NULL CHECK (LENGTH(name) >= 1)
);

CREATE TABLE ticket
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id      BIGINT,
    from_planet_id VARCHAR(30),
    to_planet_id   VARCHAR(30),
    FOREIGN KEY (client_id) REFERENCES client (id),
    FOREIGN KEY (from_planet_id) REFERENCES planet (id),
    FOREIGN KEY (to_planet_id) REFERENCES planet (id)
);