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
   - JavaDoc
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

A la hora de crear una base de datos, son muy importantes los campos que contiene cada tabla así que ahora voy a explicar el porqué de cada campo creado.

En la tabla departamento solo necesitamos que tenga un id propio de cada uno, junto con su nombre y el jefe.

En la tabla profesor necesitamos saber el id de cada profesor junto con su nombre, apellidos el correo electrónico de su cuenta.

En la tabla perfil, ya que esta estrechamente relacionada a profesor, necesitamos el id y el correo de cada profesor.

Entre las tablas de profesor y solicitud necesitamos una que se llame participa en la que se guarda el id del profesor, el de la actividad en cuestión y el rol que va a cumplir el profesor durante esta actividad, que puede ser solicitante, representante o participante.  
La tabla de solicitud necesitamos que tenga un id para diferenciarla del resto junto con otros datos, como si tiene alojamiento, los grupos o cursos que participarán y cuanto durará la actividad, la cantidad de alumnos y otros campos.

Relacionadas con la tabla solicitud se generan dos tablas que son gruposParticipantes y cursosParticipantes que contienen el id de la solicitud, la cantidad de alumnos que participan y el id de los cursos o grupos participantes, a su vez están relacionadas cada una con su nombre, grupos o cursos.
 
Curso contiene su id, la etapa(ESO,Bachiller,etc…) y una descripción, grupo por su parte contiene su código de grupo, el curso, que es clave ajena del id de curso y el número de alumnos del grupo.
 
Las actividades que han sido aprobadas contienen el idActividad que es el mismo que el de la solicitud de dicha actividad, la descripción del alojamiento, la cantidad final de alumnos y la descripción de la actividad.  
A la tabla de actividades se conecta otra tabla llamada medios de transporte que contiene el id de la actividad y el id de un transporte que es almacenado en una tabla llamada medioTransporte.  

También está conectada a una lista de fotos que almacena todas las fotos que son propias de esta actividad y la URL de dicha foto la cual saca de una tabla llamada fotos en la que se almacenan todas las fotos de todas las actividades y una descripción de dicha foto.

### Archivo SQL de Importación
Puedes encontrar el archivo SQL de importación [aquí](link).

## Sobre la Web

### Estructura de la Página
La página web se divide en secciones para la página principal con información de los cursos del centro, así como un footer con las páginas oficiales de Instagram y YouTube del propio centro (Esto último está presente en toda la página), otra parte para las actividades solicitadas, en proceso y ya programadas con todos los datos de las propias actividades, otra para sobre nosotros con todos los datos del propio centro, como la ubicación, los diferentes cursos con los horarios y una muy breve historia de la historia del curso y una parte con una galería con fotos de las actividades ya realizadas.

...

## Implementación y Despliegue

### Tecnologías Utilizadas

| Tecnología    | Características                                    | Justificación                                  |
|---------------|----------------------------------------------------|------------------------------------------------|
| Chat GPT      | Facilita el desarrollo de la aplicación corrigiendo errores y explicándolos | Facilita el entendimiento del código con comentarios |
|---------------|----------------------------------------------------|------------------------------------------------|
| StackOverflow | Foro con tadas las dependencias necesarias de la aplicacion | Facil de entender y usar |

