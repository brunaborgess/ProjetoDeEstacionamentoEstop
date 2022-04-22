CREATE DATABASE  IF NOT EXISTS `estop` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `estop`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: estop
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assinatura`
--

DROP TABLE IF EXISTS `assinatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assinatura` (
  `idAssinatura` int(11) NOT NULL AUTO_INCREMENT,
  `dataDaAssinatura` date NOT NULL,
  `valorAssinatura` decimal(8,2) NOT NULL,
  `vencimento` date NOT NULL,
  `paga` tinyint(1) DEFAULT NULL,
  `idCliente` int(11) NOT NULL,
  `idPlano` int(11) NOT NULL,
  `idVaga` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAssinatura`),
  KEY `FK_idCliente3` (`idCliente`),
  KEY `FK_idPlano` (`idPlano`),
  KEY `FK_idVaga` (`idVaga`),
  CONSTRAINT `FK_idCliente3` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `FK_idPlano` FOREIGN KEY (`idPlano`) REFERENCES `plano` (`idPlano`),
  CONSTRAINT `FK_idVaga` FOREIGN KEY (`idVaga`) REFERENCES `vaga` (`idVaga`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assinatura`
--

LOCK TABLES `assinatura` WRITE;
/*!40000 ALTER TABLE `assinatura` DISABLE KEYS */;
/*!40000 ALTER TABLE `assinatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `telefone1` varchar(15) NOT NULL,
  `telefone2` varchar(15) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `logradouro` varchar(64) NOT NULL,
  `numero` int(11) NOT NULL,
  `complemento` varchar(64) DEFAULT NULL,
  `bairro` varchar(64) NOT NULL,
  `cidade` varchar(64) NOT NULL,
  `uf` char(2) NOT NULL,
  `cep` char(9) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fatura`
--

DROP TABLE IF EXISTS `fatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fatura` (
  `idFatura` int(11) NOT NULL AUTO_INCREMENT,
  `dataEmissao` date NOT NULL,
  `horaEmissao` time NOT NULL,
  `formaPagamento` varchar(32) NOT NULL,
  `valorFatura` decimal(8,2) NOT NULL,
  `idAssinatura` int(11) DEFAULT NULL,
  `idRotativo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFatura`),
  KEY `FK_idAssinatura1` (`idAssinatura`),
  KEY `FK_idRotativo1` (`idRotativo`),
  CONSTRAINT `FK_idAssinatura1` FOREIGN KEY (`idAssinatura`) REFERENCES `assinatura` (`idAssinatura`),
  CONSTRAINT `FK_idRotativo1` FOREIGN KEY (`idRotativo`) REFERENCES `rotativo` (`idRotativo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fatura`
--

LOCK TABLES `fatura` WRITE;
/*!40000 ALTER TABLE `fatura` DISABLE KEYS */;
/*!40000 ALTER TABLE `fatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `idFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `nomeFuncionario` varchar(128) NOT NULL,
  `nomeUsuario` varchar(32) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `nivelPermissao` int(1) DEFAULT NULL,
  PRIMARY KEY (`idFuncionario`),
  UNIQUE KEY `nomeUsuario` (`nomeUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operacaocaixa`
--

DROP TABLE IF EXISTS `operacaocaixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operacaocaixa` (
  `idOperacaoCaixa` int(11) NOT NULL AUTO_INCREMENT,
  `dataOperacao` date NOT NULL,
  `tipoOperacao` varchar(32) NOT NULL,
  `valorOperacao` decimal(8,2) NOT NULL,
  `valorCaixa` decimal(8,2) NOT NULL,
  `idFatura` int(11) DEFAULT NULL,
  `idFuncionario` int(11) NOT NULL,
  PRIMARY KEY (`idOperacaoCaixa`),
  KEY `FK_idFatura1` (`idFatura`),
  KEY `FK_idFuncionario1` (`idFuncionario`),
  CONSTRAINT `FK_idFatura1` FOREIGN KEY (`idFatura`) REFERENCES `fatura` (`idFatura`),
  CONSTRAINT `FK_idFuncionario1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operacaocaixa`
--

LOCK TABLES `operacaocaixa` WRITE;
/*!40000 ALTER TABLE `operacaocaixa` DISABLE KEYS */;
/*!40000 ALTER TABLE `operacaocaixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoafisica`
--

DROP TABLE IF EXISTS `pessoafisica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoafisica` (
  `cpf` char(14) NOT NULL,
  `nome` varchar(128) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`cpf`),
  KEY `FK_idCliente1` (`idCliente`),
  CONSTRAINT `FK_idCliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoafisica`
--

LOCK TABLES `pessoafisica` WRITE;
/*!40000 ALTER TABLE `pessoafisica` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoafisica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoajuridica`
--

DROP TABLE IF EXISTS `pessoajuridica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoajuridica` (
  `cnpj` varchar(18) NOT NULL,
  `razaoSocial` varchar(128) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`cnpj`),
  KEY `FK_idCliente2` (`idCliente`),
  CONSTRAINT `FK_idCliente2` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoajuridica`
--

LOCK TABLES `pessoajuridica` WRITE;
/*!40000 ALTER TABLE `pessoajuridica` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoajuridica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plano`
--

DROP TABLE IF EXISTS `plano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plano` (
  `idPlano` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(32) NOT NULL,
  `valor` decimal(8,2) NOT NULL,
  PRIMARY KEY (`idPlano`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plano`
--

LOCK TABLES `plano` WRITE;
/*!40000 ALTER TABLE `plano` DISABLE KEYS */;
/*!40000 ALTER TABLE `plano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preco`
--

DROP TABLE IF EXISTS `preco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preco` (
  `idPreco` int(11) NOT NULL AUTO_INCREMENT,
  `umaHora` decimal(8,2) DEFAULT NULL,
  `duasHoras` decimal(8,2) DEFAULT NULL,
  `tresHoras` decimal(8,2) DEFAULT NULL,
  `aposTres` decimal(8,2) DEFAULT NULL,
  `pernoite` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`idPreco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preco`
--

LOCK TABLES `preco` WRITE;
/*!40000 ALTER TABLE `preco` DISABLE KEYS */;
/*!40000 ALTER TABLE `preco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rotativo`
--

DROP TABLE IF EXISTS `rotativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rotativo` (
  `idRotativo` int(11) NOT NULL AUTO_INCREMENT,
  `placaVeiculo` char(7) NOT NULL,
  `dataEntrada` date NOT NULL,
  `horaEntrada` time NOT NULL,
  `dataSaida` date DEFAULT NULL,
  `horaSaida` time DEFAULT NULL,
  `idVeiculo` int(11) NOT NULL,
  `idVaga` int(11) NOT NULL,
  PRIMARY KEY (`idRotativo`),
  KEY `FK_idVeiculo2` (`idVeiculo`),
  KEY `FK_idVaga2` (`idVaga`),
  CONSTRAINT `FK_idVaga2` FOREIGN KEY (`idVaga`) REFERENCES `vaga` (`idVaga`),
  CONSTRAINT `FK_idVeiculo2` FOREIGN KEY (`idVeiculo`) REFERENCES `veiculo` (`idVeiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rotativo`
--

LOCK TABLES `rotativo` WRITE;
/*!40000 ALTER TABLE `rotativo` DISABLE KEYS */;
/*!40000 ALTER TABLE `rotativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaga`
--

DROP TABLE IF EXISTS `vaga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vaga` (
  `idVaga` int(11) NOT NULL AUTO_INCREMENT,
  `disponivel` tinyint(1) NOT NULL,
  `coberta` tinyint(1) NOT NULL,
  `tipoDeVeiculo` varchar(50) NOT NULL,
  PRIMARY KEY (`idVaga`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaga`
--

LOCK TABLES `vaga` WRITE;
/*!40000 ALTER TABLE `vaga` DISABLE KEYS */;
/*!40000 ALTER TABLE `vaga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veiculo` (
  `idVeiculo` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(128) NOT NULL,
  PRIMARY KEY (`idVeiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-22 17:08:31
