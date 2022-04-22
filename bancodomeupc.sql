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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assinatura`
--

LOCK TABLES `assinatura` WRITE;
/*!40000 ALTER TABLE `assinatura` DISABLE KEYS */;
INSERT INTO `assinatura` VALUES (1,'2018-03-23',123123.12,'2018-01-01',1,4,4,NULL),(2,'2018-03-23',123123.12,'2018-01-01',1,4,4,NULL),(3,'2018-03-23',200.00,'2018-01-01',NULL,4,2,NULL),(4,'2018-03-23',180.00,'2018-01-01',1,2,2,NULL),(5,'2018-03-23',200.00,'2018-01-01',1,2,2,NULL),(6,'2018-03-23',123123.12,'2021-06-05',1,2,4,NULL),(7,'2018-03-23',1231.56,'2018-01-01',1,2,2,NULL),(8,'2018-03-23',220.00,'2018-01-01',1,2,2,NULL),(9,'2018-03-23',200.00,'2018-01-01',1,2,2,NULL),(10,'2018-03-23',123123.00,'2018-01-01',1,2,2,NULL),(11,'2018-03-23',123123.12,'2018-01-01',NULL,5,4,NULL),(12,'2018-03-23',123.12,'2018-01-01',NULL,3,2,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'2133512059','21998087066','lojaoi@oi.com.br','Avenida Sr. dos Passos',54,'Loja','Centro','Rio de Janeiro','RJ','21370-000'),(2,'(12) 31231-2312','(  )      -    ','','Rua dos Santos',25,'Sobreloja ATeTes','Maracanã','Rio de Janeiro','AC','12312-312'),(3,'123123','','','2123123',123123,'123123','12312','3123123','RN','123123'),(4,'11111111','','','11111',1111,'1111','11111','111','AP','111111'),(5,'231','23123','12312','312',31231,'312312312','312312312','123','AC','12312'),(6,'3123','','','231',23123123,'12321312','123123','123123','AC','12314-123'),(7,'(31) 23132-1231','(12) 31231-2313','','231',2312,'231','31321','2313131','AC','23131-231');
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fatura`
--

LOCK TABLES `fatura` WRITE;
/*!40000 ALTER TABLE `fatura` DISABLE KEYS */;
INSERT INTO `fatura` VALUES (1,'2018-03-23','12:14:52','Dinheiro',30.00,NULL,3),(2,'2018-03-23','12:16:20','Dinheiro',123123.12,1,NULL),(3,'2018-03-23','12:16:24','Dinheiro',123123.12,2,NULL),(4,'2018-03-23','12:16:30','Dinheiro',123123.12,1,NULL),(5,'2018-03-23','12:16:32','Dinheiro',123123.12,2,NULL),(6,'2018-03-23','12:26:37','Dinheiro',180.00,4,NULL),(7,'2018-03-23','13:43:44','Dinheiro',1928.19,NULL,7),(8,'2018-03-23','14:24:31','Dinheiro',200.00,9,NULL),(9,'2018-03-23','16:34:47','Dinheiro',123123.00,10,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'José','jose123','123',0),(3,'1111','jose21','123123',1),(4,'ana','ana123','123',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operacaocaixa`
--

LOCK TABLES `operacaocaixa` WRITE;
/*!40000 ALTER TABLE `operacaocaixa` DISABLE KEYS */;
INSERT INTO `operacaocaixa` VALUES (1,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(2,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(3,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(4,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(5,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(6,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(7,'2018-03-23','Abertura de Caixa',50.00,50.00,NULL,1),(8,'2018-03-23','Fechamento de Caixa',-50.00,0.00,NULL,1),(9,'2018-03-23','Abertura de Caixa',50.00,50.00,NULL,1),(10,'2018-03-23','Fechamento de Caixa',-50.00,0.00,NULL,1),(11,'2018-03-23','Abertura de Caixa',50.00,50.00,NULL,1),(12,'2018-03-23','Fechamento de Caixa',-50.00,0.00,NULL,1),(13,'2018-03-23','Abertura de Caixa',50.00,50.00,NULL,1),(14,'2018-03-23','Fechamento de Caixa',-50.00,0.00,NULL,1),(15,'2018-03-23','Abertura de Caixa',500.00,500.00,NULL,1),(16,'2018-03-23','Fechamento de Caixa',-500.00,0.00,NULL,1),(17,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(18,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(19,'2018-03-23','Abertura de Caixa',5.00,5.00,NULL,1),(20,'2018-03-23','Fechamento de Caixa',-5.00,0.00,NULL,1),(21,'2018-03-23','Abertura de Caixa',500.00,500.00,NULL,1),(22,'2018-03-23','Fechamento de Caixa',-500.00,0.00,NULL,1),(23,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(24,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(25,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(26,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(27,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(28,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(29,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(30,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(31,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(32,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(33,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(34,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(35,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(36,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(37,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(38,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(39,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(40,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(41,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(42,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(43,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(44,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(45,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(46,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(47,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(48,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(49,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(50,'2018-03-23','Rotativo',30.00,30.00,1,1),(51,'2018-03-23','Assinatura',123123.12,123153.12,2,1),(52,'2018-03-23','Assinatura',123123.12,246276.24,3,1),(53,'2018-03-23','Assinatura',123123.12,369399.36,4,1),(54,'2018-03-23','Assinatura',123123.12,492522.48,5,1),(55,'2018-03-23','Fechamento de Caixa',-492522.48,0.00,NULL,1),(56,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(57,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(58,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(59,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(60,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(61,'2018-03-23','Assinatura',180.00,180.00,6,1),(62,'2018-03-23','Fechamento de Caixa',-180.00,0.00,NULL,1),(63,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(64,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(65,'2018-03-23','Abertura de Caixa',111111.11,111111.11,NULL,1),(66,'2018-03-23','Fechamento de Caixa',-111111.11,0.00,NULL,1),(67,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(68,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(69,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(70,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(71,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(72,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(73,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(74,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(75,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(76,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(77,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(78,'2018-03-23','Rotativo',1928.19,1928.19,7,1),(79,'2018-03-23','Fechamento de Caixa',-1928.19,0.00,NULL,1),(80,'2018-03-23','Abertura de Caixa',212312.00,212312.00,NULL,1),(81,'2018-03-23','Fechamento de Caixa',-212312.00,0.00,NULL,1),(82,'2018-03-23','Abertura de Caixa',9123.38,9123.38,NULL,1),(83,'2018-03-23','Fechamento de Caixa',-9123.38,0.00,NULL,1),(84,'2018-03-23','Abertura de Caixa',231239.00,231239.00,NULL,1),(85,'2018-03-23','Fechamento de Caixa',-231239.00,0.00,NULL,1),(86,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(87,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(88,'2018-03-23','Abertura de Caixa',12321.00,12321.00,NULL,1),(89,'2018-03-23','Fechamento de Caixa',-12321.00,0.00,NULL,1),(90,'2018-03-23','Abertura de Caixa',1232.12,1232.12,NULL,1),(91,'2018-03-23','Assinatura',200.00,1432.12,8,1),(92,'2018-03-23','Fechamento de Caixa',-1432.12,0.00,NULL,1),(93,'2018-03-23','Abertura de Caixa',123.00,123.00,NULL,1),(94,'2018-03-23','Fechamento de Caixa',-123.00,0.00,NULL,1),(95,'2018-03-23','Abertura de Caixa',11.00,11.00,NULL,1),(96,'2018-03-23','Fechamento de Caixa',-11.00,0.00,NULL,1),(97,'2018-03-23','Abertura de Caixa',1.00,1.00,NULL,1),(98,'2018-03-23','Fechamento de Caixa',-1.00,0.00,NULL,1),(99,'2018-03-23','Abertura de Caixa',1.00,1.00,NULL,4),(100,'2018-03-23','Fechamento de Caixa',-1.00,0.00,NULL,4),(101,'2018-03-23','Abertura de Caixa',1.00,1.00,NULL,1),(102,'2018-03-23','Fechamento de Caixa',-1.00,0.00,NULL,1),(103,'2018-03-23','Abertura de Caixa',0.00,0.00,NULL,1),(104,'2018-03-23','Fechamento de Caixa',0.00,0.00,NULL,1),(105,'2018-03-23','Abertura de Caixa',1.00,1.00,NULL,1),(106,'2018-03-23','Fechamento de Caixa',-1.00,0.00,NULL,1),(107,'2018-03-23','Abertura de Caixa',1.00,1.00,NULL,1),(108,'2018-03-23','Fechamento de Caixa',-1.00,0.00,NULL,1),(109,'2018-03-23','Abertura de Caixa',1.00,1.00,NULL,1),(110,'2018-03-23','Fechamento de Caixa',-1.00,0.00,NULL,1),(111,'2018-03-23','Abertura de Caixa',1.00,1.00,NULL,1),(112,'2018-03-23','Assinatura',123123.00,123124.00,9,1),(113,'2018-03-23','Fechamento de Caixa',-123124.00,0.00,NULL,1),(114,'2018-03-23','Abertura de Caixa',1.00,1.00,NULL,1),(115,'2018-03-23','Fechamento de Caixa',-1.00,0.00,NULL,1),(116,'2018-03-23','Abertura de Caixa',1.00,1.00,NULL,1),(117,'2018-03-23','Fechamento de Caixa',-1.00,0.00,NULL,1),(118,'2018-03-23','Abertura de Caixa',1.00,1.00,NULL,1);
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
INSERT INTO `pessoafisica` VALUES ('1','1231',6),('111.111.111-11','11111',4),('12','231231',7),('123','1231',5),('160.444.764-94','Wallace Santos',2);
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
INSERT INTO `pessoajuridica` VALUES ('000000000123','asadas',3);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plano`
--

LOCK TABLES `plano` WRITE;
/*!40000 ALTER TABLE `plano` DISABLE KEYS */;
INSERT INTO `plano` VALUES (2,'Mensal Vaga Coberta',200.00),(3,'aa',333333.33),(4,'Mensal',123123.12),(5,'123123',40.00),(6,'23232',400.00),(7,'asd',232.34);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preco`
--

LOCK TABLES `preco` WRITE;
/*!40000 ALTER TABLE `preco` DISABLE KEYS */;
INSERT INTO `preco` VALUES (1,25.00,30.00,35.55,35.00,40.00),(2,49.00,1.23,123200.11,11.00,111111.11),(3,123.23,2123.12,123.22,123.20,232.20),(4,31233.00,231.00,13.00,31231.00,231232.00),(5,12312.00,3222.00,222222.00,312.00,222222.00),(6,123.00,444.00,44.00,123.00,444.00),(7,0.00,0.00,0.00,0.00,0.00);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rotativo`
--

LOCK TABLES `rotativo` WRITE;
/*!40000 ALTER TABLE `rotativo` DISABLE KEYS */;
INSERT INTO `rotativo` VALUES (1,'ABC1234','2018-03-23','09:32:07','2018-03-23','09:34:41',1,2),(3,'ABC1234','2018-03-23','10:37:54','2018-03-23','12:14:52',3,2),(4,'ABC2222','2018-03-23','10:38:16','2018-03-23','13:43:57',4,3),(6,'ABC3333','2018-03-23','05:00:00','2018-03-23','13:34:57',1,4),(7,'DDD3333','2018-03-23','11:04:02','2018-03-23','13:43:44',5,4),(8,'ABC1234','2018-03-23','14:25:59',NULL,NULL,6,3);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaga`
--

LOCK TABLES `vaga` WRITE;
/*!40000 ALTER TABLE `vaga` DISABLE KEYS */;
INSERT INTO `vaga` VALUES (1,0,1,'Carro'),(2,1,1,'Carro'),(3,0,1,'Carro'),(4,0,1,'Carro');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
INSERT INTO `veiculo` VALUES (1,''),(2,''),(3,''),(4,''),(5,'Megane Azul'),(6,'');
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

-- Dump completed on 2018-03-23 17:14:38
