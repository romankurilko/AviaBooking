CREATE TABLE `seat`
 (
 	`id` BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
     `number` INTEGER NOT NULL,
     `plane_id` BIGINT NOT NULL,
     `business` BOOLEAN NOT NULL,
     FOREIGN KEY (plane_id) REFERENCES plane (id)
 )