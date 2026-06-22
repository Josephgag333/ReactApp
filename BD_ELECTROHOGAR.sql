CREATE DATABASE IF NOT EXISTS db_electrohogar;
USE db_electrohogar;

CREATE TABLE categoria (
    id_categoria VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(150)
);

CREATE TABLE proveedor (
    id_proveedor VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    ruc VARCHAR(15),
    direccion VARCHAR(100),
    telefono VARCHAR(15),
    correo VARCHAR(100)
);

CREATE TABLE producto (
    id_producto VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    marca VARCHAR(50),
    precio DECIMAL(10,2),
    stock INT,
    descripcion VARCHAR(200),
    id_categoria VARCHAR(10),
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

CREATE TABLE producto_proveedor (
    id_producto VARCHAR(10),
    id_proveedor VARCHAR(10),
    precio_compra DECIMAL(10,2),
    PRIMARY KEY (id_producto, id_proveedor),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto),
    FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor)
);

CREATE TABLE cliente (
    id_cliente VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(100),
    dni VARCHAR(15),
    telefono VARCHAR(15),
    correo VARCHAR(100),
    direccion VARCHAR(150)
);

CREATE TABLE usuario (
    id_usuario VARCHAR(10) PRIMARY KEY,
    nombre_usuario VARCHAR(50),
    password VARCHAR(100),
    rol ENUM('ADMIN', 'VENDEDOR')
);

CREATE TABLE venta (
    id_venta VARCHAR(10) PRIMARY KEY,
    fecha DATETIME,
    total DECIMAL(10,2),
    id_cliente VARCHAR(10),
    id_usuario VARCHAR(10),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE detalle_venta (
    id_detalle VARCHAR(10) PRIMARY KEY,
    id_venta VARCHAR(10),
    id_producto VARCHAR(10),
    cantidad INT,
    subtotal DECIMAL(10,2),
    FOREIGN KEY (id_venta) REFERENCES venta(id_venta),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

CREATE TABLE pago (
    id_pago VARCHAR(10) PRIMARY KEY,
    id_venta VARCHAR(10),
    fecha DATETIME,
    monto DECIMAL(10,2),
    metodo VARCHAR(30),
    estado VARCHAR(20),
    FOREIGN KEY (id_venta) REFERENCES venta(id_venta)
);

CREATE TABLE notificacion (
    id_notificacion VARCHAR(10) PRIMARY KEY,
    tipo VARCHAR(30),
    mensaje VARCHAR(200),
    fecha DATETIME,
    id_venta VARCHAR(10),
    FOREIGN KEY (id_venta) REFERENCES venta(id_venta)
);

CREATE TABLE movimiento_stock (
    id_movimiento VARCHAR(10) PRIMARY KEY,
    id_producto VARCHAR(10),
    tipo ENUM('ENTRADA', 'SALIDA'),
    cantidad INT,
    fecha DATETIME,
    referencia VARCHAR(20),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);
