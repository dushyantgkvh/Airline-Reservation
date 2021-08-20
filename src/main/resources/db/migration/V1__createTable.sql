CREATE TABLE `airline` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `airline_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `airplane` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `airplane_name` varchar(255) DEFAULT NULL,
  `seats` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `airport` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `airport_name` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `confirm_password` varchar(255) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_role_id` (`role_id`),
  CONSTRAINT `FK_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
);


CREATE TABLE `flight` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `departure_time` datetime  NOT NULL,
  `arrival_time` datetime  NOT NULL, 
  `price` double DEFAULT NULL,
  `airline_id` bigint DEFAULT NULL,
  `airplane_id` bigint DEFAULT NULL,
  `source_id` bigint DEFAULT NULL,
  `destination_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_airline_id` (`airline_id`),
  KEY `FK_airplane_id` (`airplane_id`),
  KEY `FK_source_id` (`source_id`),
  KEY `FK_destination_id` (`destination_id`),
  CONSTRAINT `FK_airline_id` FOREIGN KEY (`airline_id`) REFERENCES `airline` (`id`),
  CONSTRAINT `FK_airplane_id` FOREIGN KEY (`airplane_id`) REFERENCES `airplane` (`id`),
  CONSTRAINT `FK_source_id` FOREIGN KEY (`source_id`) REFERENCES `airport` (`id`),
  CONSTRAINT `FK_destination_id` FOREIGN KEY (`destination_id`) REFERENCES `airport` (`id`)
);


CREATE TABLE `booking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `num_of_tickets` int DEFAULT NULL,
  `flight_id` bigint DEFAULT NULL,
  `passenger_id` bigint DEFAULT NULL,
  `cancel_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK-flight_id` (`flight_id`),
  KEY `FK_passenger_id` (`passenger_id`),
  CONSTRAINT `FK-flight_id` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`),
  CONSTRAINT `FK_passenger_id` FOREIGN KEY (`passenger_id`) REFERENCES `users` (`id`)
);