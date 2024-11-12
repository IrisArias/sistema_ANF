-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-11-2024 a las 05:33:44
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdplanilla`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horas_extra`
--

CREATE TABLE `horas_extra` (
  `id` int(11) NOT NULL,
  `nombre1_trabajador` text NOT NULL,
  `nombre2_trabajador` text DEFAULT NULL,
  `apellido1_trabajador` text NOT NULL,
  `apellido2_trabajador` text DEFAULT NULL,
  `sueldo_diario` double NOT NULL,
  `horas_extra_diurnas` double NOT NULL,
  `horas_extra_nocturnas` double NOT NULL,
  `horas_nocturnas` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `horas_extra`
--

INSERT INTO `horas_extra` (`id`, `nombre1_trabajador`, `nombre2_trabajador`, `apellido1_trabajador`, `apellido2_trabajador`, `sueldo_diario`, `horas_extra_diurnas`, `horas_extra_nocturnas`, `horas_nocturnas`) VALUES
(1, 'cesar', 'jaiime', 'gonzalez ', 'cubias', 23, 2, 4, 1),
(2, 'cesar', 'jaiime', 'gonzalez ', 'cubias', 23, 2, 4, 4),
(4, 'cesar', 'jaiime', 'gonzalez ', 'cubias', 23, 2, 4, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instituciones`
--

CREATE TABLE `instituciones` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `instituciones`
--

INSERT INTO `instituciones` (`id`, `nombre`) VALUES
(1, 'AFP CECER'),
(2, 'AFP CONFÍA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `planillat`
--

CREATE TABLE `planillat` (
  `id` int(11) NOT NULL,
  `salario` double NOT NULL,
  `pago_adicional` double NOT NULL,
  `monto_vacacional` double NOT NULL,
  `ingreso_base` double NOT NULL,
  `dias` int(11) NOT NULL,
  `horas` double NOT NULL,
  `dias_vacacion` int(11) DEFAULT NULL,
  `aporte_laboral` double NOT NULL,
  `aporte_patronal` double NOT NULL,
  `total_aporte` double NOT NULL,
  `cotizacion_obligatoria_empleador` double NOT NULL,
  `total_fondo` double NOT NULL,
  `cuenta_garantia_solidaria` double NOT NULL,
  `comision_afp` double NOT NULL,
  `total_a_pagar` double NOT NULL,
  `id_institucion` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `planillat`
--

INSERT INTO `planillat` (`id`, `salario`, `pago_adicional`, `monto_vacacional`, `ingreso_base`, `dias`, `horas`, `dias_vacacion`, `aporte_laboral`, `aporte_patronal`, `total_aporte`, `cotizacion_obligatoria_empleador`, `total_fondo`, `cuenta_garantia_solidaria`, `comision_afp`, `total_a_pagar`, `id_institucion`) VALUES
(3, 200, 12, 22, 22, 33, 44, 55, 0.66, 1.65, 2.31, 1.6, 1.99, 1.32, 0.22, 3.53, 1),
(5, 400, 40, 30, 400, 4, 6, 207, 12, 30, 42, 36, 36, 24, 4, 64, 2),
(6, 3, 2, 5, 5, 3, 5, 22, 0.15, 0.38, 0.53, 0.36, 0.45, 0.3, 0.05, 0.8, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `horas_extra`
--
ALTER TABLE `horas_extra`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `instituciones`
--
ALTER TABLE `instituciones`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `planillat`
--
ALTER TABLE `planillat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_institucion` (`id_institucion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `horas_extra`
--
ALTER TABLE `horas_extra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `planillat`
--
ALTER TABLE `planillat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `planillat`
--
ALTER TABLE `planillat`
  ADD CONSTRAINT `fk_institucion` FOREIGN KEY (`id_institucion`) REFERENCES `instituciones` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
