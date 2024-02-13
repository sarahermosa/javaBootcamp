-- Top clientes con más facturas
SELECT 
    c.id, 
    c.nombre, 
    c.apellido, 
    COUNT(f.cliente_id) AS "Cantidad Facturas"
FROM 
    factura f 
JOIN 
    cliente c ON c.id = f.cliente_id
GROUP BY 
    c.id, 
    c.nombre, 
    c.apellido
ORDER BY 
    COUNT(f.cliente_id) DESC;

-- Top clientes que más gastaron
SELECT 
    c.id, 
    c.nombre, 
    c.apellido, 
    TO_CHAR(SUM(fd.cantidad * p.precio), '999,999,999,999.99') AS MONTO_GASTADO
FROM 
    factura f 
JOIN 
    cliente c ON c.id = f.cliente_id
JOIN 
    factura_detalle fd ON fd.factura_id = f.id
JOIN 
    producto p ON p.id = fd.producto_id
GROUP BY 
    c.id, 
    c.nombre, 
    c.apellido
ORDER BY 
    SUM(fd.cantidad * p.precio) DESC;

-- Top monedas más utilizadas
SELECT 
    m.id, 
    m.nombre, 
    COUNT(f.moneda_id) AS cantidad 
FROM 
    moneda m 
JOIN 
    factura f ON f.moneda_id = m.id
GROUP BY 
    m.id, 
    m.nombre
ORDER BY 
    COUNT(f.moneda_id) DESC;

-- Top proveedor de productos
SELECT 
    prov.id, 
    prov.nombre, 
    prov.ruc, 
    COUNT(p.proveedor_id) AS Cantidad
FROM 
    proveedor prov 
JOIN 
    producto p ON p.proveedor_id = prov.id
GROUP BY 
    prov.id, 
    prov.nombre, 
    prov.ruc
ORDER BY 
    COUNT(p.proveedor_id) DESC;

-- Productos más vendidos
SELECT 
    p.id, 
    p.nombre, 
    SUM(fd.cantidad) AS Cantidad
FROM 
    producto p
JOIN 
    factura_detalle fd ON fd.producto_id = p.id
GROUP BY 
    p.id, 
    p.nombre
ORDER BY 
    SUM(fd.cantidad) DESC;

-- Productos menos vendidos
SELECT 
    p.id, 
    p.nombre, 
    SUM(fd.cantidad) AS Cantidad
FROM 
    producto p
JOIN 
    factura_detalle fd ON fd.producto_id = p.id
GROUP BY 
    p.id, 
    p.nombre
ORDER BY 
    SUM(fd.cantidad);

-- Consulta que muestra fecha de emisión de factura, nombre y apellido del cliente, 
-- nombres de productos de esa factura, cantidades compradas, 
-- nombre de tipo de factura de una factura específica

--Probamos con la factura_id = 97

SELECT 
    f.id AS "ID Factura", 
    f.fecha_emision, 
    c.nombre || ' ' || c.apellido AS "Cliente", 
    p.nombre AS "Producto", 
    fd.cantidad, 
    ft.nombre AS "Tipo Factura" 
FROM 
    factura f 
JOIN 
    factura_detalle fd ON f.id = fd.factura_id
JOIN 
    producto p ON p.id = fd.producto_id
JOIN 
    cliente c ON c.id = f.cliente_id
JOIN 
    factura_tipo ft ON ft.id = f.factura_tipo_id
WHERE 
	fd.factura_id = 97
ORDER BY 
    fd.factura_id;

-- Montos de facturas ordenados según totales
SELECT 
    fd.id, 
    TO_CHAR(SUM(fd.cantidad * p.precio), '999,999,999,999.99') AS "Total" 
FROM 
    factura f 
JOIN 
    factura_detalle fd ON f.id = fd.factura_id
JOIN 
    producto p ON p.id = fd.producto_id
GROUP BY 
    fd.id
ORDER BY 
    SUM(fd.cantidad * p.precio) DESC;

-- Mostrar el IVA del 10% de los montos totales de facturas 
-- (suponer que todos los productos tienen IVA del 10%)
SELECT 
    fd.id, 
    TO_CHAR(SUM(fd.cantidad * p.precio), '999,999,999,999.99') AS "Total",
    TO_CHAR(SUM(fd.cantidad * p.precio) * 0.10, '999,999,999,999.99') AS "IVA"
FROM 
    factura f 
JOIN 
    factura_detalle fd ON f.id = fd.factura_id
JOIN 
    producto p ON p.id = fd.producto_id
GROUP BY 
    fd.id
ORDER BY 
    SUM(fd.cantidad * p.precio) DESC;