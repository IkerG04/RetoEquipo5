-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gestoractividadesextraescolares
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gestoractividadesextraescolares
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gestoractividadesextraescolares` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `gestoractividadesextraescolares` ;

-- -----------------------------------------------------
-- Table `gestoractividadesextraescolares`.`solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`solicitud` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mediotransporte` TINYINT NOT NULL,
  `departamento` INT NOT NULL COMMENT 'trigger',
  `comentariosadicionales` VARCHAR(45) NULL DEFAULT NULL,
  `alojamiento` TINYINT NOT NULL,
  `numeroalumnos` INT NOT NULL,
  `estado` TINYINT NOT NULL,
  `grupocurso` INT NULL DEFAULT NULL,
  `fechainicioactividad` DATE NOT NULL,
  `fechafinactividad` DATE NOT NULL,
  `prevista` TINYINT(1) NOT NULL,
  `titulo` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 42
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestoractividadesextraescolares`.`acexprogramadas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`acexprogramadas` (
  `idactividad` INT NOT NULL,
  `descripcionalojamiento` VARCHAR(45) NULL DEFAULT NULL,
  `cantidadfinalalumnos` INT NOT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idactividad`),
  CONSTRAINT `fk_acexprogramadas_solicitud1`
    FOREIGN KEY (`idactividad`)
    REFERENCES `gestoractividadesextraescolares`.`solicitud` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestoractividadesextraescolares`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`curso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codcurso` VARCHAR(5) NOT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  `etapa` ENUM('ESO', 'Bachillerato', 'FPGS', 'FPGM', 'FPB', 'FPCE') NOT NULL,
  `activo` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 25
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestoractividadesextraescolares`.`cursosparticipantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`cursosparticipantes` (
  `codigocurso` INT NOT NULL,
  `idsolicitud` INT NOT NULL,
  `alumnostotales` INT NOT NULL,
  PRIMARY KEY (`codigocurso`, `idsolicitud`),
  INDEX `fk_cursosparticipantes_solicitud1_idx` (`idsolicitud` ASC) VISIBLE,
  CONSTRAINT `fk_cursosparticipantes_curso1`
    FOREIGN KEY (`codigocurso`)
    REFERENCES `gestoractividadesextraescolares`.`curso` (`id`),
  CONSTRAINT `fk_cursosparticipantes_solicitud1`
    FOREIGN KEY (`idsolicitud`)
    REFERENCES `gestoractividadesextraescolares`.`solicitud` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestoractividadesextraescolares`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`departamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cod` CHAR(3) NOT NULL,
  `nombre` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 41
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestoractividadesextraescolares`.`fotos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`fotos` (
  `url` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`url`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestoractividadesextraescolares`.`grupos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`grupos` (
  `idgrupo` INT NOT NULL,
  `codgrupo` VARCHAR(5) NOT NULL,
  `curso` INT NOT NULL,
  `numeroalumnos` INT NOT NULL,
  `activo` TINYINT NOT NULL,
  PRIMARY KEY (`idgrupo`, `curso`),
  INDEX `fk_grupos_curso1_idx` (`curso` ASC) VISIBLE,
  CONSTRAINT `fk_grupos_curso1`
    FOREIGN KEY (`curso`)
    REFERENCES `gestoractividadesextraescolares`.`curso` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestoractividadesextraescolares`.`gruposparticipantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`gruposparticipantes` (
  `codigogrupo` INT NOT NULL,
  `idsolicitud` INT NOT NULL,
  `alumnostotales` INT NOT NULL,
  PRIMARY KEY (`codigogrupo`, `idsolicitud`),
  INDEX `fk_gruposparticipantes_solicitud1_idx` (`idsolicitud` ASC) VISIBLE,
  CONSTRAINT `fk_gruposparticipantes_grupos1`
    FOREIGN KEY (`codigogrupo`)
    REFERENCES `gestoractividadesextraescolares`.`grupos` (`idgrupo`),
  CONSTRAINT `fk_gruposparticipantes_solicitud1`
    FOREIGN KEY (`idsolicitud`)
    REFERENCES `gestoractividadesextraescolares`.`solicitud` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestoractividadesextraescolares`.`listafotos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`listafotos` (
  `idactividad` INT NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idactividad`, `url`),
  INDEX `fk_listafotos_fotos1_idx` (`url` ASC) VISIBLE,
  CONSTRAINT `fk_listafotos_acexprogramadas1`
    FOREIGN KEY (`idactividad`)
    REFERENCES `gestoractividadesextraescolares`.`acexprogramadas` (`idactividad`),
  CONSTRAINT `fk_listafotos_fotos1`
    FOREIGN KEY (`url`)
    REFERENCES `gestoractividadesextraescolares`.`fotos` (`url`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestoractividadesextraescolares`.`mediostransporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`mediostransporte` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestoractividadesextraescolares`.`listamediostransporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`listamediostransporte` (
  `idactividad` INT NOT NULL,
  `idtransporte` INT NOT NULL,
  PRIMARY KEY (`idactividad`, `idtransporte`),
  INDEX `fk_listamediostransporte_mediostransporte1_idx` (`idtransporte` ASC) VISIBLE,
  CONSTRAINT `fk_listamediostransporte_acexprogramadas1`
    FOREIGN KEY (`idactividad`)
    REFERENCES `gestoractividadesextraescolares`.`acexprogramadas` (`idactividad`),
  CONSTRAINT `fk_listamediostransporte_mediostransporte1`
    FOREIGN KEY (`idtransporte`)
    REFERENCES `gestoractividadesextraescolares`.`mediostransporte` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestoractividadesextraescolares`.`profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`profesor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(9) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `activo` TINYINT NOT NULL,
  `perfil` ENUM('SuperUsuario', 'Administrador', 'EquipoAdministrativo', 'Profesor') NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `departamento` INT NOT NULL,
  PRIMARY KEY (`id`, `correo`),
  UNIQUE INDEX `correo_UNIQUE` (`correo` ASC) VISIBLE,
  INDEX `index_correo` (`correo` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 53
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestoractividadesextraescolares`.`participa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`participa` (
  `IdProfesor` INT NOT NULL,
  `IdSolicitud` INT NOT NULL,
  `Rol` ENUM('Solicitante', 'Participante', 'Represntante') NOT NULL,
  PRIMARY KEY (`IdProfesor`, `IdSolicitud`),
  INDEX `fk_participa_solicitud1_idx` (`IdSolicitud` ASC) VISIBLE,
  CONSTRAINT `fk_participa_profesor1`
    FOREIGN KEY (`IdProfesor`)
    REFERENCES `gestoractividadesextraescolares`.`profesor` (`id`),
  CONSTRAINT `fk_participa_solicitud1`
    FOREIGN KEY (`IdSolicitud`)
    REFERENCES `gestoractividadesextraescolares`.`solicitud` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `gestoractividadesextraescolares`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`usuario` (
  `idUsuario` INT NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_usuario_profesores` (`idUsuario` ASC, `correo` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_profesores`
    FOREIGN KEY (`idUsuario` , `correo`)
    REFERENCES `gestoractividadesextraescolares`.`profesor` (`id` , `correo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
