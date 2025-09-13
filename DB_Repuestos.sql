drop database if exists DB_Repuestos;
create database DB_Repuestos;
use DB_Repuestos;

create table Repuestos (
    idRepuesto int auto_increment,
    nombreRepuesto varchar(100) not null,
    marca varchar(50) not null,
    precio decimal(10,2) not null,
    stock int not null,
    constraint pk_Repuestos primary key (idRepuesto)
);

create table Clientes (
    idCliente int auto_increment,
    nombreCliente varchar(100) not null,
    telefono varchar(15),
    direccion varchar(150),
    constraint pk_Clientes primary key (idCliente)
);

create table Proveedores (
    idProveedor int auto_increment,
    nombreProveedor varchar(100) not null,
    telefono varchar(15),
    direccion varchar(150),
    constraint pk_Proveedores primary key (idProveedor)
);

create table Ventas (
    idVenta int auto_increment,
    fechaVenta date not null,
    idCliente int not null,
    idRepuesto int not null,
    cantidad int not null,
    total decimal(10,2) not null,
    constraint pk_Ventas primary key (idVenta)
);

-- Repuestos (10 tuplas)
insert into Repuestos(nombreRepuesto, marca, precio, stock) values
('Bujía NGK', 'NGK', 45.00, 100),
('Filtro de Aceite', 'Bosch', 80.00, 60),
('Pastillas de Freno', 'Brembo', 350.00, 40),
('Amortiguador', 'Monroe', 750.00, 25),
('Radiador', 'Valeo', 1200.00, 15),
('Aceite de Motor 5W30', 'Castrol', 300.00, 50),
('Batería 12V', 'LTH', 1100.00, 20),
('Correa de Distribución', 'Gates', 500.00, 30),
('Filtro de Aire', 'Mann', 150.00, 70),
('Llantas 195/65R15', 'Michelin', 2000.00, 10);

-- Clientes (10 tuplas)
insert into Clientes(nombreCliente, telefono, direccion) values
('Juan Pérez', '555-1234', 'Zona 1, Ciudad'),
('María López', '555-5678', 'Zona 5, Ciudad'),
('Carlos Ruiz', '555-9012', 'Zona 10, Ciudad'),
('Ana Gómez', '555-3456', 'Zona 3, Ciudad'),
('Luis Martínez', '555-7890', 'Zona 7, Ciudad'),
('Sofía Hernández', '555-2345', 'Zona 2, Ciudad'),
('Pedro Ramírez', '555-6789', 'Zona 8, Ciudad'),
('Laura Díaz', '555-4321', 'Zona 4, Ciudad'),
('Ricardo Flores', '555-8765', 'Zona 9, Ciudad'),
('Carolina Morales', '555-1111', 'Zona 6, Ciudad');

-- Proveedores (10 tuplas)
insert into Proveedores(nombreProveedor, telefono, direccion) values
('Autopartes S.A.', '2222-1111', 'Zona 12, Ciudad'),
('Repuestos Express', '3333-2222', 'Zona 8, Ciudad'),
('Distribuidora Automotriz', '4444-3333', 'Zona 4, Ciudad'),
('Mundo Motor', '5555-4444', 'Zona 9, Ciudad'),
('Accesorios Carros GT', '6666-5555', 'Zona 6, Ciudad'),
('ServiRepuestos', '7777-6666', 'Zona 11, Ciudad'),
('Importadora El Rayo', '8888-7777', 'Zona 2, Ciudad'),
('SuperFrenos', '9999-8888', 'Zona 5, Ciudad'),
('Aceites Premium', '1010-9999', 'Zona 7, Ciudad'),
('TodoMotor', '1212-0000', 'Zona 1, Ciudad');

-- Ventas (10 tuplas)
insert into Ventas(fechaVenta, idCliente, idRepuesto, cantidad, total) values
('2025-09-01', 1, 1, 4, 180.00),
('2025-09-01', 2, 2, 2, 160.00),
('2025-09-02', 3, 3, 1, 350.00),
('2025-09-02', 4, 4, 2, 1500.00),
('2025-09-03', 5, 5, 1, 1200.00),
('2025-09-03', 6, 6, 3, 900.00),
('2025-09-04', 7, 7, 1, 1100.00),
('2025-09-04', 8, 8, 2, 1000.00),
('2025-09-05', 9, 9, 5, 750.00),
('2025-09-05', 10, 10, 2, 4000.00);

-- =========================
select * from Repuestos;
select * from Clientes;
select * from Proveedores;
select * from Ventas;
