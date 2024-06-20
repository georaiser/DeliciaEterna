
create schema delicia_eterna;
use delicia_eterna;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `ADMINISTRADOR` (
  `idAdministrador` int(11) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

INSERT INTO `ADMINISTRADOR` (`idAdministrador`, `nombre`) VALUES
(1, 'administrador');

CREATE TABLE `CATEGORIA_PRODUCTO` (
  `idCategoriaProducto` int(11) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` varchar(50) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;


INSERT INTO `CATEGORIA_PRODUCTO` (`idCategoriaProducto`, `nombre`, `descripcion`) VALUES
(1, 'Bebida helada', 'café helado, te helado'),
(4, 'Alimento dulce', 'pasteles');


CREATE TABLE `CLIENTE` (
  `rutCliente` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `primerApellido` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `segundoApellido` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `comuna` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `e-mail` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `puntos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

INSERT INTO `CLIENTE` (`rutCliente`, `nombre`, `primerApellido`, `segundoApellido`, `direccion`, `comuna`, `telefono`, `e-mail`, `puntos`) VALUES
('10334538-5', 'Manuel', 'López', 'Vega', 'Bartolina Madrid 456', 'Alhue', '56928194697', 'mdzpikgw@galpc.gov', 1324),
('9334551-k', 'Rodrigo', 'Ortiz', 'Sepúlveda', 'Silvina Hurtado 2345', 'Providencia', '56850707741', 'ulaszhtp@hdnyr.com', 6016);


CREATE TABLE `COLABORADOR` (
  `rutColaborador` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `primerApellido` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `segundoApellido` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `comuna` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `rol` int(11) NOT NULL,
  `FK_idSucursal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;


INSERT INTO `COLABORADOR` (`rutColaborador`, `nombre`, `primerApellido`, `segundoApellido`, `direccion`, `comuna`, `telefono`, `rol`, `FK_idSucursal`) VALUES
('10273890-4', 'Martín', 'Jiménez', 'González', 'Eucaliptus 645', 'San Bernardo', '562443320034', 0, 5),
('25432189-6', 'Samuel', 'Moreno', 'Silva', 'Victoria 7654', 'Rancagua', '56989593708', 0, 6);

CREATE TABLE `PRODUCTO` (
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` varchar(500) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `precio` int(11) NOT NULL,
  `FK_idCategoriaProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

INSERT INTO `PRODUCTO` (`idProducto`, `nombreProducto`, `descripcion`, `precio`, `FK_idCategoriaProducto`) VALUES
(1, 'Mango limonada', NULL, 3000, 1),
(2, 'Frutilla', NULL, 3000, 1),
(45, 'Cheescake Frambuesa', NULL, 3500, 4);

CREATE TABLE `stock` (
  `idProducto` int(11) NOT NULL,
  `idSucursal` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `FK_idAdministrador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;


INSERT INTO `stock` (`idProducto`, `idSucursal`, `stock`, `FK_idAdministrador`) VALUES
(1, 1, 5, 1),
(1, 2, 44, 1),
(1, 3, 22, 1),
(45, 6, 8, 1);

CREATE TABLE `SUCURSAL` (
  `idSucursal` int(11) NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(35) COLLATE utf8_spanish2_ci NOT NULL,
  `comuna` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` varchar(15) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

INSERT INTO `SUCURSAL` (`idSucursal`, `nombre`, `direccion`, `comuna`, `telefono`) VALUES
(1, 'Bandera', 'Bandera 444', 'Santiago', '56228570011'),
(2, 'Libertad', 'Av. Libertad 543', 'Viña del Mar', '563231567924'),
(6, 'Independencia', 'Paseo Independencia 24', 'Rancagua', '727261435900');

CREATE TABLE `VENTA` (
  `idVenta` int(11) NOT NULL,
  `FK_idSucursal` int(11) NOT NULL,
  `FK_rutCliente` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `FK_idAdministrador` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

INSERT INTO `VENTA` (`idVenta`, `FK_idSucursal`, `FK_rutCliente`, `FK_idAdministrador`, `fecha`) VALUES
(1, 1, '13334533-8', 1, '2023-12-19'),
(54, 6, '21334555-2', 1, '2022-08-20'),
(55, 6, '20334545-5', 1, '2022-04-24');


ALTER TABLE `ADMINISTRADOR`
  ADD PRIMARY KEY (`idAdministrador`);


ALTER TABLE `CATEGORIA_PRODUCTO`
  ADD PRIMARY KEY (`idCategoriaProducto`);


ALTER TABLE `CLIENTE`
  ADD PRIMARY KEY (`rutCliente`);

ALTER TABLE `COLABORADOR`
  ADD PRIMARY KEY (`rutColaborador`),
  ADD KEY `FK_idSucursal` (`FK_idSucursal`);

ALTER TABLE `PRODUCTO`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `FK_idCategoriaProducto` (`FK_idCategoriaProducto`);

ALTER TABLE `stock`
  ADD PRIMARY KEY (`idProducto`,`idSucursal`),
  ADD KEY `idSucursal` (`idSucursal`),
  ADD KEY `FK_idAdministrador` (`FK_idAdministrador`);

ALTER TABLE `SUCURSAL`
  ADD PRIMARY KEY (`idSucursal`);

ALTER TABLE `VENTA`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `FK_idSucursal` (`FK_idSucursal`),
  ADD KEY `FK_rutCliente` (`FK_rutCliente`),
  ADD KEY `FK_idAdministrador` (`FK_idAdministrador`);

ALTER TABLE `COLABORADOR`
  ADD CONSTRAINT `colaborador_ibfk_1` FOREIGN KEY (`FK_idSucursal`) REFERENCES `SUCURSAL` (`idSucursal`);

ALTER TABLE `PRODUCTO`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`FK_idCategoriaProducto`) REFERENCES `CATEGORIA_PRODUCTO` (`idCategoriaProducto`);

ALTER TABLE `stock`
  ADD CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `PRODUCTO` (`idProducto`),
  ADD CONSTRAINT `stock_ibfk_2` FOREIGN KEY (`idSucursal`) REFERENCES `SUCURSAL` (`idSucursal`),
  ADD CONSTRAINT `stock_ibfk_3` FOREIGN KEY (`idProducto`) REFERENCES `PRODUCTO` (`idProducto`),
  ADD CONSTRAINT `stock_ibfk_4` FOREIGN KEY (`FK_idAdministrador`) REFERENCES `ADMINISTRADOR` (`idAdministrador`);

ALTER TABLE `VENTA`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`FK_idSucursal`) REFERENCES `SUCURSAL` (`idSucursal`),
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`FK_rutCliente`) REFERENCES `CLIENTE` (`rutCliente`),
  ADD CONSTRAINT `venta_ibfk_3` FOREIGN KEY (`FK_idAdministrador`) REFERENCES `ADMINISTRADOR` (`idAdministrador`);
COMMIT;
