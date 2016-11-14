-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 14-Nov-2016 às 02:23
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `alugagames`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id` binary(16) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `dataNascimento` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `funcao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `sexo` char(1) NOT NULL,
  `telefone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `ativo`, `cpf`, `dataNascimento`, `email`, `funcao`, `nome`, `senha`, `sexo`, `telefone`) VALUES
(0x0a4d1333782142eba0ec1421107a7b74, 0, '33684945897', '1986-11-18 00:00:00', 'atendente@alugagames.com.br', 'Atendente', 'Atendente', 'Šöœ9~H[+À£ý…å„]', 'F', '90299930049'),
(0x3b9e63600cdf495cb7b2cf643e351baf, 0, '48456469866', '1991-11-24 00:00:00', 'tecnico@alugagames.com.br', 'Tecnico', 'Tecnico', 'Šöœ9~H[+À£ý…å„]', 'M', '91888277378'),
(0x73ff6c9db14142edbd8ffb9a52d6f578, 0, '65567217862', '1987-11-16 00:00:00', 'gerente@alugagames.com.br', 'Gerente', 'Gerente', 'Šöœ9~H[+À£ý…å„]', 'M', '99920993848');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
