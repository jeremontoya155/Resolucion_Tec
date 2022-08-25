/*Definicion de la base de datos */
CREATE DATABASE Dux_Ejemeplo_Query;

USE Dux_Ejemeplo_Query;



CREATE TABLE rubro(
	id_rubro BIGINT PRIMARY KEY,
    rubro VARCHAR(45) NOT NULL
);

CREATE TABLE producto(
		codigo VARCHAR(45) PRIMARY KEY,
        nombre VARCHAR(45) NOT NULL,
        fecha_creacion DATE NOT NULL,
        id_rubro BIGINT NOT NULL,
        FOREIGN KEY(id_rubro) REFERENCES rubro(id_rubro)
        
);




CREATE TABLE cliente(
	id_cliente BIGINT PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    cuit date NOT NULL
); 


CREATE TABLE venta(
	id_venta BIGINT PRIMARY KEY,
    rubro VARCHAR(45) NOT NULL,
    codigo_producto VARCHAR(45) NOT NULL,
    fecha DATE NOT NULL,
    cantidad BIGINT NOT NULL,
    precio_unitario DOUBLE NOT NULL,
    id_cliente BIGINT NOT NULL,
    FOREIGN KEY(codigo_producto) REFERENCES producto(codigo),
    FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente)
);

/*Descripcion de cada tabla*/

DESC rubro;
DESC producto;
DESC cliente;
DESC venta;

INSERT INTO rubro(id_rubro,rubro)
VALUES(1,'Autopartes'),
(2,'Comidas'),
(3,'Indumentaria'),
(4,'Bebidas'),
(5,'Gimnasios'),
(6,'Peluquerias'),
(7,'Bazar'),
(8,'Libreria');


SELECT * FROM rubro;

INSERT INTO producto(codigo,nombre,fecha_creacion,id_rubro)
VALUES('1a','Ruedas',"2019-03-12",1),
('2a','Retrovisores',"2019-04-12",1),
('3a','Paragolpes',"2019-03-12",1),
('4a','Hambuguesas',"2022-08-12",2),
('5a','Oreo',"2022-07-12",2),
('6a','Remera',"2021-03-13",3),
('1b','Bermuda',"2020-09-22",3),
('2b','Coca',"2022-08-21",4),
('3b','Pepsi',"2022-08-12",4),
('4b','Pesas',curdate(),5),
('5b','Sogas',curdate(),5),
('6b','Cera ',"2022-03-12",6),
('7c','Shampoo',"2022-01-12",6),
('1e','Vaso ',curdate(),7),
('2j','Cuaderno',curdate(),8),
('1c','Acondicionador',curdate(),6);


SELECT * FROM producto;

INSERT INTO cliente(id_cliente,nombre,apellido,cuit)
VALUES(1,"Jeremias","Montoya","2022-05-12"),
(2,"Jeronimo","Montes","2021-05-12"),
(3,"Martin","Montoya","2022-05-13"),
(4,"Javier","Montoya","2019-05-12"),
(5,"Jesus","Martinez","2022-05-19"),
(6,"Jose","Montalvan","2020-05-12"),
(7,"Jaime","Montoya","2022-07-12"),
(8,"Hernan","Tagliafico","2022-11-12");

INSERT INTO venta(id_venta,codigo_producto,fecha,cantidad,precio_unitario,id_cliente)
VALUES(1,'1a',"2022-08-21",4,11000,1),
(2,'2a',"2022-08-21",4,10000,4),
(3,'3a',"2022-08-21",4,5000,3),
(4,'1b',"2022-08-22",4,3000,2),
(5,'2b',"2022-08-22",4,2000,6),
(6,'5b',curdate(),4,15000,7),
(7,'7c',curdate(),4,1000,5),
(8,'1c',curdate(),4,50000,8),
(9,'1a',"2022-08-22",4,11000,1),
(10,'1a',"2021-08-22",4,11000,1);



SELECT * FROM venta;



/*
Acciones
• Todos los productos del rubro "librería", creados hoy.
• Monto total vendido por cliente (mostrar nombre del cliente y monto).
• Cantidad de ventas por producto.
• Cantidad de productos comprados por cliente en el mes actual.
• Ventas que tienen al menos un producto del rubro "bazar".
• Rubros que no tienen ventas en los últimos 2 meses

*/
