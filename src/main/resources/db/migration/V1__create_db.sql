CREATE TABLE IF NOT EXISTS clients(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3)
);

CREATE TABLE IF NOT EXISTS planets(
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(500) NOT NULL CHECK (LENGTH(name) >= 1)
);

CREATE TABLE IF NOT EXISTS tickets(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    client_id BIGINT,
    from_planet_id VARCHAR(50),
    to_planet_id VARCHAR(50),
    FOREIGN KEY (client_id) REFERENCES clients(id),
    FOREIGN KEY (from_planet_id) REFERENCES planets(id),
    FOREIGN KEY (to_planet_id) REFERENCES planets(id)
);