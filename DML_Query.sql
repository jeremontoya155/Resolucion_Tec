
/*Todos los productos del rubro libreria creados hoy*/

USE Dux_Ejemeplo_Query;

/*Vemos primero cual es el id para librearia*/
SELECT * FROM rubro;
/*•Teniendo ya ese id vemos cual es que tenemos que buscar y sacando tambien que sea creado hoy*/
SELECT * FROM producto WHERE((id_rubro=8)and(fecha_creacion=curdate()));


/*• Monto total vendido por cliente (mostrar nombre del cliente y monto)*/

	SELECT C.nombre, SUM(V.precio_unitario)as `Total Vendido` FROM  cliente C JOIN venta V
	ON C.id_cliente=V.id_cliente
	group by C.nombre; 




/*• Cantidad de ventas por producto.*/

SELECT codigo_producto,count(codigo_producto) as `Cantidad Ventas` FROM venta group by codigo_producto;


/*• Cantidad de productos comprados por cliente en el mes actual.*/

SELECT codigo_producto,count(codigo_producto) as `Cantidad Ventas` FROM venta
WHERE (fecha=curdate()) 
GROUP BY codigo_producto;




/*• Ventas que tienen al menos un producto del rubro "bazar".*/


SELECT V.id_venta,COUNT(V.codigo_producto) as `Total vendido` FROM venta V JOIN producto P
ON V.codigo_producto=P.codigo
WHERE (P.id_rubro=7);







