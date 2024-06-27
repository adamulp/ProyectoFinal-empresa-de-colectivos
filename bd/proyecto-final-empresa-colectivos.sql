-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 31-05-2024 a las 23:31:40
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto-final-empresa-colectivos`
--
CREATE DATABASE IF NOT EXISTS `proyecto-final-empresa-colectivos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `proyecto-final-empresa-colectivos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Colectivos`
--

CREATE TABLE IF NOT EXISTS `Colectivos` (
  `ID_Colectivo` int(11) NOT NULL AUTO_INCREMENT,
  `Matricula` varchar(255) NOT NULL UNIQUE,
  `Marca` varchar(255) NOT NULL,
  `Modelo` varchar(255) NOT NULL,
  `Capacidad` int(11) NOT NULL,
  `Estado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_Colectivo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Horarios`
--

CREATE TABLE IF NOT EXISTS `Horarios` (
  `ID_Horario` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Ruta` int(11) NOT NULL,
  `Hora_Salida` time NOT NULL,
  `Hora_Llegada` time NOT NULL,
  `Estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID_Horario`),
  KEY `ID_Ruta` (`ID_Ruta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Pasajeros`
--

CREATE TABLE IF NOT EXISTS `Pasajeros` (
  `ID_Pasajero` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(255) NOT NULL,
  `Apellido` varchar(255) NOT NULL,
  `DNI` varchar(20) NOT NULL UNIQUE,
  `Correo` varchar(255) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `Estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID_Pasajero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Pasajes`
--

CREATE TABLE IF NOT EXISTS `Pasajes` (
  `ID_Pasaje` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Pasajero` int(11) NOT NULL,
  `ID_Colectivo` int(11) NOT NULL,
  `ID_Ruta` int(11) NOT NULL,
  `Fecha_Viaje` date NOT NULL,
  `Hora_Viaje` time NOT NULL,
  `Asiento` int(11) NOT NULL,
  `Precio` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_Pasaje`),
  KEY `ID_Pasajero` (`ID_Pasajero`),
  KEY `ID_Colectivo` (`ID_Colectivo`),
  KEY `ID_Ruta` (`ID_Ruta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Rutas`
--

CREATE TABLE IF NOT EXISTS `Rutas` (
  `ID_Ruta` int(11) NOT NULL AUTO_INCREMENT,
  `Origen` varchar(255) NOT NULL,
  `Destino` varchar(255) NOT NULL,
  `Duracion_Estimada` time NOT NULL,
  `Estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID_Ruta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Horarios`
--
ALTER TABLE `Horarios`
  ADD CONSTRAINT `Horarios_ibfk_1` FOREIGN KEY (`ID_Ruta`) REFERENCES `Rutas` (`ID_Ruta`);

--
-- Filtros para la tabla `Pasajes`
--
ALTER TABLE `Pasajes`
  ADD CONSTRAINT `Pasajes_ibfk_1` FOREIGN KEY (`ID_Pasajero`) REFERENCES `Pasajeros` (`ID_Pasajero`),
  ADD CONSTRAINT `Pasajes_ibfk_2` FOREIGN KEY (`ID_Colectivo`) REFERENCES `Colectivos` (`ID_Colectivo`),
  ADD CONSTRAINT `Pasajes_ibfk_3` FOREIGN KEY (`ID_Ruta`) REFERENCES `Rutas` (`ID_Ruta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
