
# Índice de Contenidos

1. [Sobre la Base de Datos](#sobre-la-base-de-datos)
   - Descripción
   - Estructura E/R
   - Diagrama Relacional
   - Archivo SQL de Importación
2. [Sobre la Web](#sobre-la-web)
   - Estructura de la Página
   - Estilos Utilizados
   - Contenidos de la Web
3. [Sobre Java](#sobre-java)
   - Diagrama de Clases
4. [Implementación y Despliegue](#implementación-y-despliegue)
   - Tecnologías Utilizadas

---

## Sobre la Base de Datos

### Descripción
La base de datos se utiliza para gestionar todas y cada una de las actividades extraescolares, así como toda la gente que forma parte, crea y disfruta de las actividades.

### Estructura E/R
Explicación: El diagrama E/R muestra las entidades clave.

[![image.png](https://i.postimg.cc/JnGJZFct/image.png)](https://postimg.cc/Q9ZHr0zr)

La base de datos gira en torno a las solicitudes, teniendo esto en cuenta hemos creado una tabla llamada solicitudes que tiene conexión con las tablas, grupos, cursos, profesores y actividades.

[![image.png](https://i.postimg.cc/T1bDHWs6/image.png)](https://postimg.cc/BPqbjtsY)

La tabla profesores está conectada a la tabla departamento de dos maneras, un profesor está si o si en uno y solo un departamento y a su vez un departamento a de tener un jefe si o si y solo uno.

[![image.png](https://i.postimg.cc/CLyDnmZL/image.png)](https://postimg.cc/MXDXh0bh)

La tabla perfil tiene dos claves ajenas sacadas de profesor, que son el id y el correo electrónico, esto se debe a que el perfil está estrechamente relacionado a los profesores, un profesor tiene un solo perfil y un perfil solo puede pertenecer a un profesor.

La tabla de profesores está relacionada con la tabla solicitudes mediante 4 roles, profesor, superusuario, administrador, personal administrativo. Dependiendo de qué rol cumpla en el instituto tendrá acceso a unas funciones u otras en la aplicación.

[![image.png](https://i.postimg.cc/VkgbTwKd/image.png)](https://postimg.cc/cvKHgpyS)

La tabla solicitud contiene toda la información sobre una actividad solicitada por un profesor incluyendo el profesor que la solicita, si una solicitud es rechaza la información se queda hay pero en estado pone rechazada, si es aceptada se creará unos campos en la tabla ACEX programadas, que utilizará el id de solicitud para crear dicha actividad.

[![image.png](https://i.postimg.cc/k55tPHHw/image.png)](https://postimg.cc/XrTvws4y)

A la tabla solicitud están conectadas las tablas de grupos y cursos, en las que se almacena toda la información sobre estos y cuando hay una actividad se elije si van a participar grupos o cursos, obviamente, los grupos contienen el curso en el que están.

[![image.png](https://i.postimg.cc/LXcqf880/image.png)](https://postimg.cc/0MC21xmp)

Luego las actividades que han sido aceptadas están conectadas con dos tablas, fotos, que contiene todas las fotos hechas y medios de transporte para saber qué medios de transporte son utilizados, ha de ser marcado en solicitud que hay medios de transporte, sino, esta opción se deshabilita.

[![image.png](https://i.postimg.cc/sx5MJCBf/image.png)](https://postimg.cc/N2fGgV7Z)

### Diagrama Relacional
Explicación: Este diagrama muestra cómo se estructuran las tablas en la base de datos.

[![image.png](https://i.postimg.cc/ZYNvmpfk/image.png)](https://postimg.cc/LhH8BYKv)

A la hora de crear una base de datos, son muy importantes los campos que contiene cada tabla así que ahora voy a explicar el porqué de cada campo creado.

En la tabla departamento solo necesitamos que tenga un id propio de cada uno, junto con su nombre y el jefe.

[![image.png](https://i.postimg.cc/dtm7kvP4/image.png)](https://postimg.cc/svxfqk2h)

En la tabla profesor necesitamos saber el id de cada profesor junto con su nombre, apellidos el correo electrónico de su cuenta.

[![image.png](https://i.postimg.cc/rwfKjJp4/image.png)](https://postimg.cc/YvmrqQY2)

En la tabla perfil, ya que esta estrechamente relacionada a profesor, necesitamos el id y el correo de cada profesor.

Entre las tablas de profesor y solicitud necesitamos una que se llame participa en la que se guarda el id del profesor, el de la actividad en cuestión y el rol que va a cumplir el profesor durante esta actividad, que puede ser solicitante, representante o participante.  

[![image.png](https://i.postimg.cc/nL5MbhBc/image.png)](https://postimg.cc/Ffyh0mT2)

La tabla de solicitud necesitamos que tenga un id para diferenciarla del resto junto con otros datos, como si tiene alojamiento, los grupos o cursos que participarán y cuanto durará la actividad, la cantidad de alumnos y otros campos.

[![image.png](https://i.postimg.cc/hjTDkbKp/image.png)](https://postimg.cc/ftWQXdt9)

Relacionadas con la tabla solicitud se generan dos tablas que son gruposParticipantes y cursosParticipantes que contienen el id de la solicitud, la cantidad de alumnos que participan y el id de los cursos o grupos participantes, a su vez están relacionadas cada una con su nombre, grupos o cursos.

[![image.png](https://i.postimg.cc/dtqsfypj/image.png)](https://postimg.cc/Sjvb2Jyn)

Curso contiene su id, la etapa(ESO,Bachiller,etc…) y una descripción, grupo por su parte contiene su código de grupo, el curso, que es clave ajena del id de curso y el número de alumnos del grupo.

[![image.png](https://i.postimg.cc/BnzJtw6m/image.png)](https://postimg.cc/ZW6GMH6N)

Las actividades que han sido aprobadas contienen el idActividad que es el mismo que el de la solicitud de dicha actividad, la descripción del alojamiento, la cantidad final de alumnos y la descripción de la actividad.

[![image.png](https://i.postimg.cc/FR5mVd0c/image.png)](https://postimg.cc/Y43JpSnq)

A la tabla de actividades se conecta otra tabla llamada medios de transporte que contiene el id de la actividad y el id de un transporte que es almacenado en una tabla llamada medioTransporte.  

[![image.png](https://i.postimg.cc/Ss64TSGP/image.png)](https://postimg.cc/Kk8C4yw7)

También está conectada a una lista de fotos que almacena todas las fotos que son propias de esta actividad y la URL de dicha foto la cual saca de una tabla llamada fotos en la que se almacenan todas las fotos de todas las actividades y una descripción de dicha foto.
### Archivo SQL de Importación
Puedes encontrar el archivo SQL de importación debajo.

[![image.png](https://i.postimg.cc/mkVs4mJN/image.png)](https://postimg.cc/Mfc4bmWv)
```sql
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
  `estado` ENUM('Aceptada', 'NoAceptada', 'Pendiente') NOT NULL,
  `grupocurso` INT NULL DEFAULT NULL,
  `fechainicioactividad` DATE NOT NULL,
  `fechafinactividad` DATE NOT NULL,
  `prevista` TINYINT(1) NOT NULL,
  `titulo` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 62
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

```


## Sobre la Web

### Estructura de la Página
La página web se divide en secciones para la página principal con información de los cursos del centro, así como un footer con las páginas oficiales de Instagram y YouTube del propio centro (Esto último está presente en toda la página), otra parte para las actividades solicitadas, en proceso y ya programadas con todos los datos de las propias actividades, otra para sobre nosotros con todos los datos del propio centro, como la ubicación, los diferentes cursos con los horarios y una muy breve historia de la historia del curso y una parte con una galería con fotos de las actividades ya realizadas.

### Estilos Utilizados
Se utiliza CSS para darle un formato agradable y plausible para un centro de educacion formal a la pagina.

### Contenidos de la Web
La web incluye:

[![image.png](https://i.postimg.cc/4dQCv8fk/image.png)](https://postimg.cc/7GhQwnJm)
[![image.png](https://i.postimg.cc/qqJP18qt/image.png)](https://postimg.cc/Q9zYtKps)

•	Lista de actividades actuales, pendientes y actividades en curso

[![image.png](https://i.postimg.cc/kXh0yRm4/image.png)](https://postimg.cc/rKxZVmzX)

•	Detalles del centro

[![image.png](https://i.postimg.cc/GmW6W09n/image.png)](https://postimg.cc/CR4v8Qjc)

•	Informacion sobre lo que ofrece el centro

[![image.png](https://i.postimg.cc/LsjGRyZY/image.png)](https://postimg.cc/QBxfJJmh)

### Sobre java

•	Diagrama de Clases

[![imagen-2024-05-17-104950154.png](https://i.postimg.cc/m2zL6L12/imagen-2024-05-17-104950154.png)](https://postimg.cc/w7zY1dkS)

Explicación: Este diagrama muestra las clases Java utilizadas en el proyecto, sus métodos y relaciones.
El sistema educativo que se describe aquí es bastante completo en términos de gestión de usuarios, departamentos, profesores, cursos, grupos de estudiantes y actividades extracurriculares. Todo esto se organiza a través de una serie de clases interrelacionadas que permiten una administración eficiente de las operaciones educativas y administrativas dentro de una institución.

Comencemos con la clase User, que representa a los usuarios del sistema. Estos usuarios pueden variar en roles, desde SuperUsuario hasta Profesor. Cada usuario tiene atributos como identificación, dni, correo, departamento, nombre, apellidos, estado activo y perfil. La relación con la clase Departamento indica la asociación de un usuario con un departamento específico, lo que facilita la asignación de roles y responsabilidades dentro de la institución.

La clase Departamento, por su parte, representa las diferentes divisiones dentro de la organización. Cada departamento tiene su propio jefe, identificación, código y nombre. La relación con la clase Profesor a través del atributo Jefe establece quién lidera cada departamento, lo que proporciona una estructura jerárquica clara.

Los profesores se representan mediante la clase Profesores, que es similar a la clase User pero específica para el personal docente. Además de los atributos compartidos con la clase User, los profesores tienen un campo adicional para indicar el departamento al que pertenecen. Esto facilita la asignación de cursos y responsabilidades docentes dentro de la institución.

Los cursos son representados por la clase Curso, que incluye atributos como identificación, etapa y descripción. Esta clase se utiliza para definir los diferentes niveles educativos disponibles en la institución, como ESO o Bachillerato, lo que ayuda a organizar el plan de estudios y la programación académica.

Los grupos de estudiantes se gestionan mediante la clase Grupo, que incluye atributos como código de grupo, curso y número de alumnos. La relación con la clase Curso indica a qué curso pertenece cada grupo, lo que facilita la asignación de estudiantes a clases específicas.

Las actividades extracurriculares y las solicitudes de actividades se gestionan mediante las clases ACEXProgramadas y Solicitud, respectivamente. Estas clases incluyen atributos para especificar detalles como la programación prevista, el transporte, el alojamiento y los participantes, lo que permite planificar y coordinar actividades fuera del plan de estudios principal.

En resumen, este sistema proporciona una estructura sólida para la gestión integral de una institución educativa, desde la asignación de roles y responsabilidades hasta la planificación y coordinación de actividades académicas y extracurriculares. La interrelación entre las diferentes clases permite una administración eficiente y organizada de todas las operaciones dentro de la institución.


## Implementación y Despliegue

### Tecnologías Utilizadas

| Tecnología    | Características                                    | Justificación                                  |
|---------------|----------------------------------------------------|------------------------------------------------|
| Chat GPT      | Facilita el desarrollo de la aplicación corrigiendo errores y explicándolos | Facilita el entendimiento del código con comentarios |
|---------------|----------------------------------------------------|------------------------------------------------|
| StackOverflow | Foro con tadas las dependencias necesarias de la aplicacion | Facil de entender y usar |
