INSERT INTO clients (name)
VALUES
    ('Andy'),
    ('Vladislav'),
    ('Pablo'),
    ('Andrew'),
    ('Michael'),
    ('Frodo'),
    ('Tayler'),
    ('Jora'),
    ('Thomas'),
    ('Bohdan');

INSERT INTO planets (id, name)
VALUES
    ('MER', 'Mercury'),
    ('VEN', 'Venus'),
    ('EAR', 'Earth'),
    ('MARS', 'Mars'),
    ('PLUT', 'Pluto');

INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id)
VALUES
    (CURRENT_TIMESTAMP(), 1, 'MER', 'VEN'),
    (CURRENT_TIMESTAMP(), 2, 'VEN', 'MER'),
    (CURRENT_TIMESTAMP(), 3, 'EAR', 'MARS'),
    (CURRENT_TIMESTAMP(), 4, 'MARS', 'EAR'),
    (CURRENT_TIMESTAMP(), 5, 'MER', 'PLUT'),
    (CURRENT_TIMESTAMP(), 6, 'PLUT', 'MER'),
    (CURRENT_TIMESTAMP(), 7, 'VEN', 'MARS'),
    (CURRENT_TIMESTAMP(), 8, 'MARS', 'VEN'),
    (CURRENT_TIMESTAMP(), 9, 'MER', 'EAR'),
    (CURRENT_TIMESTAMP(), 10, 'EAR', 'PLUT');
