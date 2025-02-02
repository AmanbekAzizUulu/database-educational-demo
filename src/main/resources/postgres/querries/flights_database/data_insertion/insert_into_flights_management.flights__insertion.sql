INSERT INTO flights_management.flights (
		flight_no,
		departure_date,
		departure_airport_code,
		arrival_date,
		arrival_airport_code,
		aircraft_id,
		status
	)
VALUES (
		'QH101',
		'2025-02-03 08:30:00',
		'FRU',
		'2025-02-03 10:00:00',
		'OSS',
		1,
		'scheduled'
	),
	(
		'QH102',
		'2025-02-03 11:00:00',
		'OSS',
		'2025-02-03 12:30:00',
		'FRU',
		2,
		'boarding'
	),
	(
		'QH201',
		'2025-02-04 09:15:00',
		'FRU',
		'2025-02-04 10:45:00',
		'IKU',
		3,
		'scheduled'
	),
	(
		'QH202',
		'2025-02-04 13:00:00',
		'IKU',
		'2025-02-04 14:30:00',
		'FRU',
		4,
		'scheduled'
	),
	(
		'QH301',
		'2025-02-05 07:45:00',
		'FRU',
		'2025-02-05 09:30:00',
		'DMB',
		5,
		'departed'
	),
	(
		'QH302',
		'2025-02-05 10:30:00',
		'DMB',
		'2025-02-05 12:15:00',
		'FRU',
		6,
		'scheduled'
	),
	(
		'QH401',
		'2025-02-06 06:00:00',
		'FRU',
		'2025-02-06 07:40:00',
		'BDJ',
		7,
		'arrived'
	),
	(
		'QH402',
		'2025-02-06 08:30:00',
		'BDJ',
		'2025-02-06 10:15:00',
		'FRU',
		8,
		'boarding'
	),
	(
		'QH501',
		'2025-02-07 15:20:00',
		'OSS',
		'2025-02-07 16:50:00',
		'TAS',
		9,
		'cancelled'
	),
	(
		'QH502',
		'2025-02-07 18:10:00',
		'TAS',
		'2025-02-07 19:40:00',
		'OSS',
		10,
		'scheduled'
	);
