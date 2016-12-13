CREATE TABLE `ticket`
 (
 	`id` BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
     `seat_id` BIGINT NOT NULL,
     `price` BIGINT NOT NULL,
     `flight_id` BIGINT NOT NULL,
     `state` BIGINT NOT NULL,
     `person_id` BIGINT NOT NULL,
     FOREIGN KEY (seat_id) REFERENCES seat (id),
     FOREIGN KEY (flight_id) REFERENCES flight (id),
     FOREIGN KEY (person_id) REFERENCES person (id)
 )