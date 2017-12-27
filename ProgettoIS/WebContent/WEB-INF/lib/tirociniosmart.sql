-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Dic 22, 2017 alle 16:25
-- Versione del server: 10.1.21-MariaDB
-- Versione PHP: 7.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tirociniosmart`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `attivita`
--

CREATE TABLE `attivita` (
  `idAttivita` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `ore` int(11) DEFAULT NULL,
  `descrizione` varchar(200) DEFAULT NULL,
  `idTirocinio` int(11) DEFAULT NULL,
  `idRegistro` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `attivita`
--

INSERT INTO `attivita` (`idAttivita`, `data`, `ore`, `descrizione`, `idTirocinio`, `idRegistro`) VALUES
(1, '2017-12-08', 3, 'attività di programmazione OO', 1, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `azienda`
--

CREATE TABLE `azienda` (
  `p_iva` varchar(45) NOT NULL,
  `nomeAzienda` varchar(45) DEFAULT NULL,
  `tutorAziendale` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `azienda`
--

INSERT INTO `azienda` (`p_iva`, `nomeAzienda`, `tutorAziendale`, `email`, `password`, `telefono`) VALUES
('000111232334', 'Human Software', 'Carmine Apicella', 'hsoftware@gmail.com', '111', '3474466912'),
('0983732387', 'I.T.System', 'Gennaro Esposito', 'itsystem@gmail.com', '111', '3452334873');

-- --------------------------------------------------------

--
-- Struttura della tabella `convenzione`
--

CREATE TABLE `convenzione` (
  `idConvenzione` int(11) NOT NULL,
  `dataConvenzione` date DEFAULT NULL,
  `dettaglioConvenzione` varchar(300) DEFAULT NULL,
  `p_iva` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `convenzione`
--

INSERT INTO `convenzione` (`idConvenzione`, `dataConvenzione`, `dettaglioConvenzione`, `p_iva`, `email`) VALUES
(1, '2017-12-11', 'I.T.System è un\'azienda che si occupa dello sviluppo di software che automatizzano i processi di gestione all\'interno dell\'azienda ', '0983732387', 'fverdi@unisa.it');

-- --------------------------------------------------------

--
-- Struttura della tabella `didattica`
--

CREATE TABLE `didattica` (
  `email` varchar(45) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `tipo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `didattica`
--

INSERT INTO `didattica` (`email`, `nome`, `cognome`, `password`, `tipo`) VALUES
('fverdi@unisa.it', 'Francesco', 'Verdi', '111', 1),
('grusso@unisa.it', 'Giuseppe', 'Russo', '111', 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `documento`
--

CREATE TABLE `documento` (
  `idDocumento` int(11) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `path` varchar(256) DEFAULT NULL,
  `matricola` varchar(45) DEFAULT NULL,
  `emailDI` varchar(45) DEFAULT NULL,
  `p_iva` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `feedback`
--

CREATE TABLE `feedback` (
  `idFeedback` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `valutazioneStudente` double DEFAULT NULL,
  `valutazioneAzienda` double DEFAULT NULL,
  `idTirocinio` int(11) DEFAULT NULL,
  `p_iva` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `registro`
--

CREATE TABLE `registro` (
  `idRegistro` int(11) NOT NULL,
  `matricola` varchar(45) DEFAULT NULL,
  `p_iva` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `registro`
--

INSERT INTO `registro` (`idRegistro`, `matricola`, `p_iva`) VALUES
(1, '051210641', '0983732387');

-- --------------------------------------------------------

--
-- Struttura della tabella `richiestatirocinio`
--

CREATE TABLE `richiestatirocinio` (
  `idRichiestaTirocinio` int(11) NOT NULL,
  `nomeTutorAccademico` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `dataInvio` date DEFAULT NULL,
  `emailTA` varchar(45) DEFAULT NULL,
  `emailDI` varchar(45) DEFAULT NULL,
  `matricola` varchar(45) DEFAULT NULL,
  `idTirocinio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `richiestatirocinio`
--

INSERT INTO `richiestatirocinio` (`idRichiestaTirocinio`, `nomeTutorAccademico`, `status`, `dataInvio`, `emailTA`, `emailDI`, `matricola`, `idTirocinio`) VALUES
(1, 'Mario Rossi', 'in attesa', '2017-12-05', 'mrossi@unisa.it', 'grusso@unisa.it', '051210645', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `studente`
--

CREATE TABLE `studente` (
  `matricola` varchar(45) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `codiceFiscale` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dataNascita` date DEFAULT NULL,
  `luogoNascita` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `studente`
--

INSERT INTO `studente` (`matricola`, `nome`, `cognome`, `password`, `codiceFiscale`, `email`, `dataNascita`, `luogoNascita`) VALUES
('0512101111', 'Mario', 'Procida', '111', 'mprcd12dgf', 'mprocida@gmail.com', '1996-10-20', 'Salerno'),
('0512103599', 'Luca', 'Lamberti', '111', 'lmbl14g06fh', 'llamberti@gmail.com', '1996-06-14', 'Salerno'),
('051210641', 'Simone', 'Torluccio', '111', 'smntrlccfh21gfh', 'storluccio@gmail.com', '1997-04-16', 'Salerno'),
('051210645', 'Anna Maria', 'Rosanova', '111', 'amns123sdn', 'amrosanova@gmail.com', '1995-03-30', 'Scafati');

-- --------------------------------------------------------

--
-- Struttura della tabella `tirocinio`
--

CREATE TABLE `tirocinio` (
  `idTirocinio` int(11) NOT NULL,
  `descrizione` varchar(400) DEFAULT NULL,
  `numPosti` int(11) DEFAULT NULL,
  `p_iva` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `tirocinio`
--

INSERT INTO `tirocinio` (`idTirocinio`, `descrizione`, `numPosti`, `p_iva`) VALUES
(1, 'tirocinio riguardante attività di sviluppo software nell\' ambito dei processi aziendali', 5, '0983732387');

-- --------------------------------------------------------

--
-- Struttura della tabella `tutoraccademico`
--

CREATE TABLE `tutoraccademico` (
  `email` varchar(45) NOT NULL,
  `codiceFiscale` varchar(20) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `tutoraccademico`
--

INSERT INTO `tutoraccademico` (`email`, `codiceFiscale`, `nome`, `cognome`, `PASSWORD`) VALUES
('mrossi@unisa.it', 'mrrss3143hds1', 'Mario', 'Rossi', '111'),
('pbianchi@unisa.it', 'psqbnc23484df', 'Pasquale', 'Bianchi', '111');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `attivita`
--
ALTER TABLE `attivita`
  ADD PRIMARY KEY (`idAttivita`),
  ADD KEY `fokey1` (`idTirocinio`),
  ADD KEY `fokey2` (`idRegistro`);

--
-- Indici per le tabelle `azienda`
--
ALTER TABLE `azienda`
  ADD PRIMARY KEY (`p_iva`);

--
-- Indici per le tabelle `convenzione`
--
ALTER TABLE `convenzione`
  ADD PRIMARY KEY (`idConvenzione`),
  ADD KEY `for1` (`p_iva`),
  ADD KEY `for2` (`email`);

--
-- Indici per le tabelle `didattica`
--
ALTER TABLE `didattica`
  ADD PRIMARY KEY (`email`);

--
-- Indici per le tabelle `documento`
--
ALTER TABLE `documento`
  ADD PRIMARY KEY (`idDocumento`),
  ADD KEY `fk1` (`matricola`),
  ADD KEY `fk2` (`p_iva`),
  ADD KEY `fk3` (`emailDI`);

--
-- Indici per le tabelle `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`idFeedback`),
  ADD KEY `forkey1` (`idTirocinio`),
  ADD KEY `forkey2` (`p_iva`);

--
-- Indici per le tabelle `registro`
--
ALTER TABLE `registro`
  ADD PRIMARY KEY (`idRegistro`),
  ADD KEY `fok1` (`p_iva`),
  ADD KEY `fok2` (`matricola`);

--
-- Indici per le tabelle `richiestatirocinio`
--
ALTER TABLE `richiestatirocinio`
  ADD PRIMARY KEY (`idRichiestaTirocinio`),
  ADD KEY `f1` (`emailTA`),
  ADD KEY `f2` (`emailDI`),
  ADD KEY `f3` (`idTirocinio`),
  ADD KEY `f4` (`matricola`);

--
-- Indici per le tabelle `studente`
--
ALTER TABLE `studente`
  ADD PRIMARY KEY (`matricola`);

--
-- Indici per le tabelle `tirocinio`
--
ALTER TABLE `tirocinio`
  ADD PRIMARY KEY (`idTirocinio`),
  ADD KEY `fo1` (`p_iva`);

--
-- Indici per le tabelle `tutoraccademico`
--
ALTER TABLE `tutoraccademico`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `attivita`
--
ALTER TABLE `attivita`
  MODIFY `idAttivita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT per la tabella `convenzione`
--
ALTER TABLE `convenzione`
  MODIFY `idConvenzione` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT per la tabella `documento`
--
ALTER TABLE `documento`
  MODIFY `idDocumento` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `feedback`
--
ALTER TABLE `feedback`
  MODIFY `idFeedback` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `registro`
--
ALTER TABLE `registro`
  MODIFY `idRegistro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT per la tabella `richiestatirocinio`
--
ALTER TABLE `richiestatirocinio`
  MODIFY `idRichiestaTirocinio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT per la tabella `tirocinio`
--
ALTER TABLE `tirocinio`
  MODIFY `idTirocinio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `attivita`
--
ALTER TABLE `attivita`
  ADD CONSTRAINT `fokey1` FOREIGN KEY (`idTirocinio`) REFERENCES `tirocinio` (`idTirocinio`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fokey2` FOREIGN KEY (`idRegistro`) REFERENCES `registro` (`idRegistro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `convenzione`
--
ALTER TABLE `convenzione`
  ADD CONSTRAINT `for1` FOREIGN KEY (`p_iva`) REFERENCES `azienda` (`p_iva`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `for2` FOREIGN KEY (`email`) REFERENCES `didattica` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `documento`
--
ALTER TABLE `documento`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`matricola`) REFERENCES `studente` (`matricola`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk2` FOREIGN KEY (`p_iva`) REFERENCES `azienda` (`p_iva`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk3` FOREIGN KEY (`emailDI`) REFERENCES `didattica` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `forkey1` FOREIGN KEY (`idTirocinio`) REFERENCES `tirocinio` (`idTirocinio`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `forkey2` FOREIGN KEY (`p_iva`) REFERENCES `azienda` (`p_iva`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `registro`
--
ALTER TABLE `registro`
  ADD CONSTRAINT `fok1` FOREIGN KEY (`p_iva`) REFERENCES `azienda` (`p_iva`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fok2` FOREIGN KEY (`matricola`) REFERENCES `studente` (`matricola`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `richiestatirocinio`
--
ALTER TABLE `richiestatirocinio`
  ADD CONSTRAINT `f1` FOREIGN KEY (`emailTA`) REFERENCES `tutoraccademico` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `f2` FOREIGN KEY (`emailDI`) REFERENCES `didattica` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `f3` FOREIGN KEY (`idTirocinio`) REFERENCES `tirocinio` (`idTirocinio`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `f4` FOREIGN KEY (`matricola`) REFERENCES `studente` (`matricola`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `tirocinio`
--
ALTER TABLE `tirocinio`
  ADD CONSTRAINT `fo1` FOREIGN KEY (`p_iva`) REFERENCES `azienda` (`p_iva`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
