INSERT INTO client(name)
values('John'),
      ('Max'),
      ('Anna'),
      ('Din'),
      ('Robert'),
      ('Mary'),
      ('David'),
      ('Barbara'),
      ('Linda'),
      ('Thomas');

INSERT INTO planet
values('MARS', 'Mars'),
      ('MER', 'Mercury'),
      ('NEP', 'Neptune'),
      ('SAT', 'Saturn'),
      ('URAN', 'Uranus');

INSERT INTO ticket(client_id, from_planet_id, to_planet_id)
values(1, 'MARS', 'URAN'),
      (2, 'MER', 'MARS'),
      (3, 'NEP', 'SAT'),
      (4, 'SAT', 'MER'),
      (5, 'URAN', 'NEP'),
      (6, 'MARS', 'NEP'),
      (7, 'MER', 'SAT'),
      (8, 'NEP', 'MARS'),
      (9, 'SAT', 'URAN'),
      (10, 'URAN', 'MER');