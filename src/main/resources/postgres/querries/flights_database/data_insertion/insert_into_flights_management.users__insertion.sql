INSERT INTO flights_management.users (
		first_name,
		last_name,
		login,
		email,
		password,
		role_id,
		gender,
		birth_date
	)
VALUES (
		'John',
		'Doe',
		'john_doe',
		'john.doe@example.com',
		'password123',
		(
			SELECT id
			FROM flights_management.roles
			WHERE role_name = 'Administrator'
		),
		'male',
		'1990-01-15'
	),
	(
		'Jane',
		'Smith',
		'jane_smith',
		'jane.smith@example.com',
		'password123',
		(
			SELECT id
			FROM flights_management.roles
			WHERE role_name = 'User'
		),
		'female',
		'1995-05-20'
	),
	(
		'Alice',
		'Brown',
		'alice_brown',
		'alice.brown@example.com',
		'password123',
		(
			SELECT id
			FROM flights_management.roles
			WHERE role_name = 'Administrator'
		),
		'female',
		'1988-08-30'
	),
	(
		'Bob',
		'White',
		'bob_white',
		'bob.white@example.com',
		'password123',
		(
			SELECT id
			FROM flights_management.roles
			WHERE role_name = 'User'
		),
		'male',
		'1992-12-01'
	),
	(
		'Charlie',
		'Davis',
		'charlie_davis',
		'charlie.davis@example.com',
		'password123',
		(
			SELECT id
			FROM flights_management.roles
			WHERE role_name = 'User'
		),
		'male',
		'1994-11-10'
	),
	(
		'David',
		'Martinez',
		'david_martinez',
		'david.martinez@example.com',
		'password123',
		(
			SELECT id
			FROM flights_management.roles
			WHERE role_name = 'Administrator'
		),
		'male',
		'1985-07-22'
	),
	(
		'Emma',
		'Garcia',
		'emma_garcia',
		'emma.garcia@example.com',
		'password123',
		(
			SELECT id
			FROM flights_management.roles
			WHERE role_name = 'User'
		),
		'female',
		'1993-04-12'
	),
	(
		'Frank',
		'Wilson',
		'frank_wilson',
		'frank.wilson@example.com',
		'password123',
		(
			SELECT id
			FROM flights_management.roles
			WHERE role_name = 'Administrator'
		),
		'male',
		'1982-02-25'
	),
	(
		'Grace',
		'Taylor',
		'grace_taylor',
		'grace.taylor@example.com',
		'password123',
		(
			SELECT id
			FROM flights_management.roles
			WHERE role_name = 'User'
		),
		'female',
		'1996-06-17'
	),
	(
		'Henry',
		'Moore',
		'henry_moore',
		'henry.moore@example.com',
		'password123',
		(
			SELECT id
			FROM flights_management.roles
			WHERE role_name = 'Administrator'
		),
		'male',
		'1989-03-08'
	);
