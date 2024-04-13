# GapsiTestBack
Se integro informacion para la bd en mysql para tener un ejemplo mas completo

- Para fines practicos se creo la bd con la siguiente configuracion
- spring.datasource.url=jdbc:mysql://localhost:3306/TestGapsiDB?autoReconnect=true&useSSL=false
  spring.datasource.username=root
  spring.datasource.password=
- Se necesita crear solamente una bd local TestGapsiDB las tablas se generan solas el application properties
el user es root y el password nulo en caso de en su locar ser diferente solo basta con agregar sus CREDENCIALES.

- Se corre con jdk 17
- mvn clean install
- y al generar la aplicacion springboot de GapsiBackAplication solo basta con dar Run y correra en el puerto 8080

QUERY PARA LA DB
CREATE DATABASE `TestGapsiDB` /*!40100 DEFAULT CHARACTER SET utf8 */;

