-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Wersja serwera:               10.11.0-MariaDB - mariadb.org binary distribution
-- Serwer OS:                    Win64
-- HeidiSQL Wersja:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Zrzut struktury tabela bookstore.autorzy
CREATE TABLE IF NOT EXISTS `autorzy` (
  `id_autor` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(25) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `nazwisko` varchar(25) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `data_urodzenia` date DEFAULT NULL,
  PRIMARY KEY (`id_autor`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- Zrzucanie danych dla tabeli bookstore.autorzy: ~7 rows (około)
/*!40000 ALTER TABLE `autorzy` DISABLE KEYS */;
INSERT INTO `autorzy` (`id_autor`, `imie`, `nazwisko`, `data_urodzenia`) VALUES
	(1, 'Joanne', 'Murray', '1965-07-31'),
	(2, 'John Ronald Reuel', 'Tolkien', '1892-01-03'),
	(3, 'George', 'Orwell', '1903-01-21'),
	(4, 'Agatha', 'Christie', '1890-10-15'),
	(5, 'Arthur Conan', 'Doyle', '1859-05-22'),
	(6, 'Louisa May', 'Alcott', '1888-11-29'),
	(7, 'Nicholas', 'Sparks', '1965-12-31');
/*!40000 ALTER TABLE `autorzy` ENABLE KEYS */;

-- Zrzut struktury tabela bookstore.faktury
CREATE TABLE IF NOT EXISTS `faktury` (
  `id_faktury` int(11) NOT NULL AUTO_INCREMENT,
  `id_zamowienia` int(11) NOT NULL,
  `id_klienta` int(11) NOT NULL,
  `data_wystawienia` date DEFAULT NULL,
  PRIMARY KEY (`id_faktury`),
  KEY `id_zamowienia` (`id_zamowienia`),
  KEY `id_klienta` (`id_klienta`),
  CONSTRAINT `faktury_ibfk_1` FOREIGN KEY (`id_zamowienia`) REFERENCES `zamowienia` (`id_zamowienia`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `faktury_ibfk_2` FOREIGN KEY (`id_klienta`) REFERENCES `klienci` (`id_klienta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- Zrzucanie danych dla tabeli bookstore.faktury: ~0 rows (około)
/*!40000 ALTER TABLE `faktury` DISABLE KEYS */;
/*!40000 ALTER TABLE `faktury` ENABLE KEYS */;

-- Zrzut struktury tabela bookstore.klienci
CREATE TABLE IF NOT EXISTS `klienci` (
  `id_klienta` int(11) NOT NULL,
  `login` varchar(20) COLLATE utf8mb4_polish_ci NOT NULL,
  `imie` varchar(30) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `nazwisko` varchar(30) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `miejscowosc` varchar(20) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `kod_pocztowy` varchar(6) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `ulica` varchar(20) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `nr_domu` varchar(4) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `nr_telefonu` varchar(11) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  PRIMARY KEY (`id_klienta`),
  KEY `login` (`login`),
  CONSTRAINT `klienci_ibfk_1` FOREIGN KEY (`login`) REFERENCES `users` (`login`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- Zrzucanie danych dla tabeli bookstore.klienci: ~0 rows (około)
/*!40000 ALTER TABLE `klienci` DISABLE KEYS */;
/*!40000 ALTER TABLE `klienci` ENABLE KEYS */;

-- Zrzut struktury tabela bookstore.kody_rabatowe
CREATE TABLE IF NOT EXISTS `kody_rabatowe` (
  `id_rabatu` int(11) NOT NULL AUTO_INCREMENT,
  `kod` varchar(30) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `wartosc_rabatu` varchar(5) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `ilosc_kodow` int(5) DEFAULT 0,
  `data_wygasniecia` date DEFAULT NULL,
  PRIMARY KEY (`id_rabatu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- Zrzucanie danych dla tabeli bookstore.kody_rabatowe: ~0 rows (około)
/*!40000 ALTER TABLE `kody_rabatowe` DISABLE KEYS */;
/*!40000 ALTER TABLE `kody_rabatowe` ENABLE KEYS */;

-- Zrzut struktury tabela bookstore.koszyk
CREATE TABLE IF NOT EXISTS `koszyk` (
  `id_koszyka` int(11) NOT NULL AUTO_INCREMENT,
  `id_klienta` int(11) NOT NULL,
  `id_produktu` int(11) NOT NULL,
  `ilosc` int(5) DEFAULT 0,
  PRIMARY KEY (`id_koszyka`),
  KEY `id_klienta` (`id_klienta`,`id_produktu`),
  KEY `id_produktu` (`id_produktu`),
  CONSTRAINT `koszyk_ibfk_1` FOREIGN KEY (`id_koszyka`) REFERENCES `klienci` (`id_klienta`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `koszyk_ibfk_2` FOREIGN KEY (`id_produktu`) REFERENCES `ksiazki` (`id_ksiazki`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- Zrzucanie danych dla tabeli bookstore.koszyk: ~0 rows (około)
/*!40000 ALTER TABLE `koszyk` DISABLE KEYS */;
/*!40000 ALTER TABLE `koszyk` ENABLE KEYS */;

-- Zrzut struktury tabela bookstore.ksiazki
CREATE TABLE IF NOT EXISTS `ksiazki` (
  `id_ksiazki` int(11) NOT NULL AUTO_INCREMENT,
  `tytul` varchar(40) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `cena` double unsigned DEFAULT NULL,
  `ilosc_sztuk` int(5) DEFAULT 0,
  `ilosc_stron` int(5) DEFAULT 0,
  `opis` varchar(1000) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `okladka` text COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `gatunek` varchar(50) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `data_wydania` varchar(10) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  PRIMARY KEY (`id_ksiazki`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- Zrzucanie danych dla tabeli bookstore.ksiazki: ~15 rows (około)
/*!40000 ALTER TABLE `ksiazki` DISABLE KEYS */;
INSERT INTO `ksiazki` (`id_ksiazki`, `tytul`, `cena`, `ilosc_sztuk`, `ilosc_stron`, `opis`, `okladka`, `gatunek`, `data_wydania`) VALUES
	(1, 'Harry Potter i kamień filoficzny', 27.99, 40, 352, NULL, NULL, 'Fantastyka', '2015-08-09'),
	(2, 'Harry Potter i Komnata Tajemnic', 23.89, 36, 348, NULL, NULL, 'Fantastyka', '2016-12-12'),
	(3, 'Harry Potter i Więzień Azkabanu', 26.12, 71, 320, NULL, NULL, 'Fantastyka', '2016-08-12'),
	(4, 'Harry Potter i Czara Ognia', 32.94, 28, 275, NULL, NULL, 'Fantastyka', '2017-01-14'),
	(5, 'Harry Potter i Zakon Feniksa', 50.54, 41, 310, NULL, NULL, 'Fantastyka', '2018-02-12'),
	(6, 'Harry Potter i Książę Półkrwi', 31.99, 47, 312, NULL, NULL, 'Fantastyka', '2019-05-03'),
	(7, 'Harry Potter i Insygnia Śmierci', 31.99, 51, 340, NULL, NULL, 'Fantastyka', '2020-07-24'),
	(8, 'Bractwo pierścienia. Władca Pierścieni', 47.31, 78, 512, NULL, NULL, 'Fantastyka', '2005-01-12'),
	(9, 'Dwie wieże. Władca Pierścieni', 48.79, 59, 432, NULL, NULL, 'Fantastyka', '2007-04-2'),
	(10, 'Powrót króla. Władca pierścieni', 44.91, 91, 368, NULL, NULL, 'Fantastyka', '2009-12-31'),
	(11, 'Rok 1984', 31.21, 20, 352, NULL, NULL, 'Antyutopia', '2007-03-12'),
	(12, 'Morderstwo w Orient Expressie', 44.89, 60, 272, NULL, NULL, 'Kryminał', '2004-12-06'),
	(13, 'Sherlock Holmes', 80.99, 31, 901, NULL, NULL, 'Kryminał', '2010-11-09'),
	(14, 'Małe kobietki', 26.67, 67, 350, NULL, NULL, 'Romans', '2021-12-03'),
	(15, 'Pamiętnik', 24.41, 120, 256, NULL, NULL, 'Romans', '2015-11-09');
/*!40000 ALTER TABLE `ksiazki` ENABLE KEYS */;

-- Zrzut struktury tabela bookstore.ksiazki_autorzy
CREATE TABLE IF NOT EXISTS `ksiazki_autorzy` (
  `id_ksiazki` int(11) NOT NULL,
  `id_autora` int(11) NOT NULL,
  KEY `id_ksiazki` (`id_ksiazki`,`id_autora`),
  KEY `id_autora` (`id_autora`),
  CONSTRAINT `ksiazki_autorzy_ibfk_1` FOREIGN KEY (`id_autora`) REFERENCES `autorzy` (`id_autor`),
  CONSTRAINT `ksiazki_autorzy_ibfk_2` FOREIGN KEY (`id_ksiazki`) REFERENCES `ksiazki` (`id_ksiazki`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- Zrzucanie danych dla tabeli bookstore.ksiazki_autorzy: ~15 rows (około)
/*!40000 ALTER TABLE `ksiazki_autorzy` DISABLE KEYS */;
INSERT INTO `ksiazki_autorzy` (`id_ksiazki`, `id_autora`) VALUES
	(1, 1),
	(2, 1),
	(3, 1),
	(4, 1),
	(5, 1),
	(6, 1),
	(7, 1),
	(8, 2),
	(9, 2),
	(10, 2),
	(11, 3),
	(12, 4),
	(13, 5),
	(14, 6),
	(15, 7);
/*!40000 ALTER TABLE `ksiazki_autorzy` ENABLE KEYS */;

-- Zrzut struktury tabela bookstore.opinie
CREATE TABLE IF NOT EXISTS `opinie` (
  `id_opinia` int(11) NOT NULL AUTO_INCREMENT,
  `id_klienta` int(11) NOT NULL,
  `opinia` varchar(1000) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  PRIMARY KEY (`id_opinia`),
  KEY `id_klienta` (`id_klienta`),
  CONSTRAINT `opinie_ibfk_1` FOREIGN KEY (`id_klienta`) REFERENCES `klienci` (`id_klienta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- Zrzucanie danych dla tabeli bookstore.opinie: ~0 rows (około)
/*!40000 ALTER TABLE `opinie` DISABLE KEYS */;
/*!40000 ALTER TABLE `opinie` ENABLE KEYS */;

-- Zrzut struktury tabela bookstore.platnosci
CREATE TABLE IF NOT EXISTS `platnosci` (
  `id_platnosc` int(11) NOT NULL AUTO_INCREMENT,
  `cena_rabat` int(11) DEFAULT 0,
  `data_wyplaty` date DEFAULT NULL,
  PRIMARY KEY (`id_platnosc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- Zrzucanie danych dla tabeli bookstore.platnosci: ~0 rows (około)
/*!40000 ALTER TABLE `platnosci` DISABLE KEYS */;
/*!40000 ALTER TABLE `platnosci` ENABLE KEYS */;

-- Zrzut struktury tabela bookstore.rezerwacje
CREATE TABLE IF NOT EXISTS `rezerwacje` (
  `id_rezerwacji` int(11) NOT NULL AUTO_INCREMENT,
  `id_klienta` int(11) NOT NULL,
  `id_ksiazka` int(11) NOT NULL,
  `data_rezerwacji` date DEFAULT NULL,
  PRIMARY KEY (`id_rezerwacji`),
  KEY `id_klienta` (`id_klienta`),
  KEY `id_ksiazka` (`id_ksiazka`),
  CONSTRAINT `rezerwacje_ibfk_1` FOREIGN KEY (`id_klienta`) REFERENCES `klienci` (`id_klienta`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rezerwacje_ibfk_2` FOREIGN KEY (`id_ksiazka`) REFERENCES `ksiazki` (`id_ksiazki`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- Zrzucanie danych dla tabeli bookstore.rezerwacje: ~0 rows (około)
/*!40000 ALTER TABLE `rezerwacje` DISABLE KEYS */;
/*!40000 ALTER TABLE `rezerwacje` ENABLE KEYS */;

-- Zrzut struktury tabela bookstore.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) COLLATE utf8mb4_polish_ci NOT NULL,
  `haslo` varchar(255) COLLATE utf8mb4_polish_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_polish_ci NOT NULL,
  `czy_zalogowany` int(1) DEFAULT 0,
  `typ` varchar(10) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `czy_aktywne` int(1) DEFAULT 0,
  `liczba_prob` int(1) DEFAULT 0,
  `blokada` int(1) DEFAULT 0,
  `kod` varchar(50) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `login` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- Zrzucanie danych dla tabeli bookstore.users: ~0 rows (około)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Zrzut struktury tabela bookstore.zamowienia
CREATE TABLE IF NOT EXISTS `zamowienia` (
  `id_zamowienia` int(11) NOT NULL AUTO_INCREMENT,
  `id_klienta` int(11) NOT NULL,
  `id_ksiazka` int(11) NOT NULL,
  `id_platnosc` int(11) NOT NULL,
  PRIMARY KEY (`id_zamowienia`),
  KEY `id_klienta` (`id_klienta`),
  KEY `id_ksiazka` (`id_ksiazka`,`id_platnosc`),
  KEY `id_platnosc` (`id_platnosc`),
  CONSTRAINT `zamowienia_ibfk_1` FOREIGN KEY (`id_klienta`) REFERENCES `klienci` (`id_klienta`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `zamowienia_ibfk_2` FOREIGN KEY (`id_ksiazka`) REFERENCES `ksiazki` (`id_ksiazki`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `zamowienia_ibfk_3` FOREIGN KEY (`id_platnosc`) REFERENCES `platnosci` (`id_platnosc`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- Zrzucanie danych dla tabeli bookstore.zamowienia: ~0 rows (około)
/*!40000 ALTER TABLE `zamowienia` DISABLE KEYS */;
/*!40000 ALTER TABLE `zamowienia` ENABLE KEYS */;

-- Zrzut struktury wyzwalacz bookstore.wyzwalacz1
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
DELIMITER //
CREATE TRIGGER `wyzwalacz1` BEFORE UPDATE ON `users` FOR EACH ROW BEGIN
IF NEW.liczba_prob=3 THEN
SET NEW.liczba_prob=0, NEW.blokada=1;
END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
