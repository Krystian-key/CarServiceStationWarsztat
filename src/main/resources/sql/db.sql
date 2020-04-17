CREATE SCHEMA IF NOT EXISTS `CarServiceStation` DEFAULT CHARACTER SET utf8;
USE `CarServiceStation`;

CREATE TABLE IF NOT EXISTS `CarServiceStation`.`employees`
(
    `id`               INT          NOT NULL AUTO_INCREMENT,
    `first_name`       VARCHAR(245) NULL,
    `last_name`        VARCHAR(245) NULL,
    `email`            VARCHAR(245) NULL,
    `password`         VARCHAR(245) NULL,
    `super_admin`      TINYINT(10)  NULL,
    `telephone_number` INT(245)     NULL,
    `notes`            TEXT(1000)   NULL,
    `hourly_rate`      DECIMAL      NULL,
    `quantity_hours`   DECIMAL      NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE
);

CREATE TABLE IF NOT EXISTS `CarServiceStation`.customer
(
    `id`               INT          NOT NULL AUTO_INCREMENT,
    `first_name`       VARCHAR(245) NULL,
    `last_name`        VARCHAR(245) NULL,
    `email`            VARCHAR(245) NULL UNIQUE,
    `address`          VARCHAR(245) NULL,
    `telephone_number` INT(245)     NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `CarServiceStation`.`vehicles`
(
    `id`                    INT          NOT NULL AUTO_INCREMENT,
    `brand`                 VARCHAR(245) NULL,
    `engine`                VARCHAR(245) NULL,
    `colour`                VARCHAR(245) NULL,
    `production_year`       DATE         NULL,
    `gear_box`              VARCHAR(245) NULL,
    `registration_number`   VARCHAR(245) NULL,
    `model`                 VARCHAR(245) NULL,
    `next_technical_review` DATE         NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `CarServiceStation`.`orders`
(
    `id`                   INT          NOT NULL AUTO_INCREMENT,
    `accepted_date`        DATE         NULL,
    `planed_date`          DATE         NULL,
    `start_date`           DATE         NULL,
    `description_problems` VARCHAR(245) NULL,
    `description_repair`   VARCHAR(245) NULL,
    `repair_cost`          DECIMAL      NULL,
    `parts_cost`           DECIMAL      NULL,
    `hourly_rate`          INT          NULL,
    `repair_hours`         DECIMAL      NULL,
    `employees_id`         INT          NOT NULL,
    `clients_id`           INT          NOT NULL,
    `vehicles_id`          INT          NOT NULL,
    PRIMARY KEY (`id`),

    CONSTRAINT
        FOREIGN KEY (`employees_id`)
            REFERENCES `CarServiceStation`.`employees` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT
        FOREIGN KEY (`hourly_rate`)
            REFERENCES `CarServiceStation`.`employees` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT
        FOREIGN KEY (`clients_id`)
            REFERENCES `CarServiceStation`.customer (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT
        FOREIGN KEY (`vehicles_id`)
            REFERENCES `CarServiceStation`.`vehicles` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
CREATE TABLE IF NOT EXISTS `CarServiceStation`.`status`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `status`   TINYINT(10) NULL,
    `order_id` INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_workers_has_clients_order1_idx` (order_id ASC) VISIBLE,
    CONSTRAINT `fk_workers_has_clients_order1_idx`
        FOREIGN KEY (order_id)
            REFERENCES `CarServiceStation`.`orders` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
