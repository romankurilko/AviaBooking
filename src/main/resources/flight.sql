  CREATE TABLE `flight`
(
	`id` BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `flight_number` VARCHAR(128) NOT NULL,
    `plane_id` BIGINT NOT NULL,
    `departure_id` BIGINT NOT NULL,
    `arrival_id` BIGINT NOT NULL,
    `departure_date` DATETIME NOT NULL,
    `arrival_date` DATETIME NOT NULL,
     FOREIGN KEY (plane_id) REFERENCES plane (id),
     FOREIGN KEY (departure_id) REFERENCES location (id),
     FOREIGN KEY (arrival_id) REFERENCES location (id)
)