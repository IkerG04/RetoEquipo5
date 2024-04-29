create database if not exists gestoractividadesextraescolares;
use gestoractividadesextraescolares;

CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`profesor` (
  `id` INT AUTO_INCREMENT primary key,
  `dni` VARCHAR(9) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `departamento` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `activo` TINYINT NOT NULL,
  `perfil` ENUM("SuperUsuario", "Administrador", "EquipoAdministrativo", "Profesor") NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL);
  
  CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`usuario` (
  `idUsuario` INT NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45)  NOT NULL);
  alter table usuario add primary key(idUsuario);
  
  CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`departamento` (
  `id` INT NOT NULL AUTO_INCREMENT primary key,
  `jefe` INT NOT NULL,
  `cod` char(3) NOT NULL,
  `nombre` VARCHAR(15) NOT NULL);
 
  
  CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`solicitud` (
  `id` INT NOT NULL AUTO_INCREMENT primary key,
  `mediotransporte` TINYINT NOT NULL,
  `departamento` INT NOT NULL comment 'trigger' ,
  `comentariosadicionales` VARCHAR(45) NULL,
  `alojamiento` TINYINT NOT NULL,
  `numeroalumnos` INT NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `grupocurso` INT NULL,
  `fechainicioactividad` DATE NOT NULL,
  `fechafinactividad` DATE NOT NULL,
  `prevista` BOOLEAN NOT NULL ,
  `titulo` VARCHAR(15) NOT NULL);
  
  
  CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`participa` (
  `IdProfesor` INT NOT NULL,
  `IdSolicitud` INT NOT NULL,
  `Rol` enum('Solicitante','Participante','Represntante') NOT NULL);
  alter table participa add primary key(idProfesor,IdSolicitud);
  
  CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`grupos` (
  `codigogrupo` varchar(8) NOT NULL,
  `curso` INT NOT NULL,
  `numeroalumnos` INT NOT NULL);
  alter table grupos add primary key(codigogrupo,curso);
  
  CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`curso` (
  `id` INT NOT NULL auto_increment primary key,
  `etapa` ENUM("ESO", "Bachillerato", "FPGS", "FPGM", "FPB", "FPCE") NOT NULL,
  `descripcion` VARCHAR(45) NULL);
  
  
  CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`acexprogramadas` (
  `idactividad` INT NOT NULL,
  `descripcionalojamiento` VARCHAR(45) NULL,
  `cantidadfinalalumnos` INT NOT NULL,
  `descripcion` VARCHAR(45) NULL);
  alter table acexprogramadas add primary key(idactividad);
  
  CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`fotos` (
  `url` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL);
  alter table fotos add primary key(url);
  
  CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`listafotos` (
  `idactividad` INT NOT NULL auto_increment,
  `url` VARCHAR(45) NOT NULL,
  primary key(idactividad,url));
  
  CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`mediostransporte` (
  `id` INT NOT NULL AUTO_INCREMENT primary key,
  `descripcion` VARCHAR(45) NULL);
  
  CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`listamediostransporte` (
  `idactividad` INT NOT NULL,
  `idtransporte` INT NOT NULL);
  alter table listamediostransporte add primary key(idactividad,idtransporte);
  
  CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`gruposparticipantes` (
  `codigogrupo` INT NOT NULL,
  `idsolicitud` INT NOT NULL,
  `alumnostotales` INT NOT NULL);
   alter table gruposparticipantes add primary key(codigogrupo,idsolicitud);
  
  CREATE TABLE IF NOT EXISTS `gestoractividadesextraescolares`.`cursosparticipantes` (
  `codigocurso` INT NOT NULL,
  `idsolicitud` INT NOT NULL,
  `alumnostotales` INT NOT NULL); 
alter table cursosparticipantes add primary key(codigocurso,idsolicitud);

-- por si no me da tiempo, literalmente las claves ajenas salen en el diagrama relacional


alter table departamento add constraint fk_Departamento_Profesor foreign key (Jefe) references Profesor(id);
