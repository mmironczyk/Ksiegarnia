-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 05 Lis 2022, 14:40
-- Wersja serwera: 10.4.22-MariaDB
-- Wersja PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `bookstore`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `autorzy`
--

CREATE TABLE `autorzy` (
  `id_autor` int(11) NOT NULL,
  `imie` varchar(25) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `nazwisko` varchar(25) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `data_urodzenia` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `faktury`
--

CREATE TABLE `faktury` (
  `id_faktury` int(11) NOT NULL,
  `id_zamowienia` int(11) NOT NULL,
  `id_klienta` int(11) NOT NULL,
  `data_wystawienia` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klienci`
--

CREATE TABLE `klienci` (
  `id_klienta` int(11) NOT NULL,
  `login` varchar(20) COLLATE utf8mb4_polish_ci NOT NULL,
  `imie` varchar(30) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `nazwisko` varchar(30) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `miejscowosc` varchar(20) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `kod_pocztowy` varchar(6) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `ulica` varchar(20) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `nr_domu` varchar(4) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `nr_telefonu` varchar(11) COLLATE utf8mb4_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kody_rabatowe`
--

CREATE TABLE `kody_rabatowe` (
  `id_rabatu` int(11) NOT NULL,
  `kod` varchar(30) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `wartosc_rabatu` varchar(5) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `ilosc_kodow` int(5) DEFAULT 0,
  `data_wygasniecia` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `koszyk`
--

CREATE TABLE `koszyk` (
  `id_koszyka` int(11) NOT NULL,
  `id_klienta` int(11) NOT NULL,
  `id_produktu` int(11) NOT NULL,
  `ilosc` int(5) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ksiazki`
--

CREATE TABLE `ksiazki` (
  `id_ksiazki` int(11) NOT NULL,
  `tytul` varchar(25) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `cena` varchar(5) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `ilosc_sztuk` int(5) DEFAULT 0,
  `ilosc_stron` int(5) DEFAULT 0,
  `opis` varchar(1000) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `okladka` text COLLATE utf8mb4_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ksiazki_autorzy`
--

CREATE TABLE `ksiazki_autorzy` (
  `id_ksiazki` int(11) NOT NULL,
  `id_autora` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `opinie`
--

CREATE TABLE `opinie` (
  `id_opinia` int(11) NOT NULL,
  `id_klienta` int(11) NOT NULL,
  `opinia` varchar(1000) COLLATE utf8mb4_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `platnosci`
--

CREATE TABLE `platnosci` (
  `id_platnosc` int(11) NOT NULL,
  `cena_rabat` int(11) DEFAULT 0,
  `data_wyplaty` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `rezerwacje`
--

CREATE TABLE `rezerwacje` (
  `id_rezerwacji` int(11) NOT NULL,
  `id_klienta` int(11) NOT NULL,
  `id_ksiazka` int(11) NOT NULL,
  `data_rezerwacji` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `login` varchar(20) COLLATE utf8mb4_polish_ci NOT NULL,
  `haslo` varchar(255) COLLATE utf8mb4_polish_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_polish_ci NOT NULL,
  `czy_zalogowany` int(1) DEFAULT 0,
  `typ` int(1) DEFAULT 0,
  `czy_aktywne` int(1) DEFAULT 0,
  `liczba_prob` int(1) DEFAULT 0,
  `blokada` int(1) DEFAULT 0,
  `kod` varchar(50) COLLATE utf8mb4_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

--
-- Wyzwalacze `users`
--
DELIMITER $$
CREATE TRIGGER `wyzwalacz1` BEFORE UPDATE ON `users` FOR EACH ROW BEGIN
IF NEW.liczba_prob=3 THEN
SET NEW.liczba_prob=0, NEW.blokada=1;
END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zamowienia`
--

CREATE TABLE `zamowienia` (
  `id_zamowienia` int(11) NOT NULL,
  `id_klienta` int(11) NOT NULL,
  `id_ksiazka` int(11) NOT NULL,
  `id_platnosc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `autorzy`
--
ALTER TABLE `autorzy`
  ADD PRIMARY KEY (`id_autor`);

--
-- Indeksy dla tabeli `faktury`
--
ALTER TABLE `faktury`
  ADD PRIMARY KEY (`id_faktury`),
  ADD KEY `id_zamowienia` (`id_zamowienia`),
  ADD KEY `id_klienta` (`id_klienta`);

--
-- Indeksy dla tabeli `klienci`
--
ALTER TABLE `klienci`
  ADD PRIMARY KEY (`id_klienta`),
  ADD KEY `login` (`login`);

--
-- Indeksy dla tabeli `kody_rabatowe`
--
ALTER TABLE `kody_rabatowe`
  ADD PRIMARY KEY (`id_rabatu`);

--
-- Indeksy dla tabeli `koszyk`
--
ALTER TABLE `koszyk`
  ADD PRIMARY KEY (`id_koszyka`),
  ADD KEY `id_klienta` (`id_klienta`,`id_produktu`),
  ADD KEY `id_produktu` (`id_produktu`);

--
-- Indeksy dla tabeli `ksiazki`
--
ALTER TABLE `ksiazki`
  ADD PRIMARY KEY (`id_ksiazki`);

--
-- Indeksy dla tabeli `ksiazki_autorzy`
--
ALTER TABLE `ksiazki_autorzy`
  ADD KEY `id_ksiazki` (`id_ksiazki`,`id_autora`),
  ADD KEY `id_autora` (`id_autora`);

--
-- Indeksy dla tabeli `opinie`
--
ALTER TABLE `opinie`
  ADD PRIMARY KEY (`id_opinia`),
  ADD KEY `id_klienta` (`id_klienta`);

--
-- Indeksy dla tabeli `platnosci`
--
ALTER TABLE `platnosci`
  ADD PRIMARY KEY (`id_platnosc`);

--
-- Indeksy dla tabeli `rezerwacje`
--
ALTER TABLE `rezerwacje`
  ADD PRIMARY KEY (`id_rezerwacji`),
  ADD KEY `id_klienta` (`id_klienta`),
  ADD KEY `id_ksiazka` (`id_ksiazka`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `login` (`login`);

--
-- Indeksy dla tabeli `zamowienia`
--
ALTER TABLE `zamowienia`
  ADD PRIMARY KEY (`id_zamowienia`),
  ADD KEY `id_klienta` (`id_klienta`),
  ADD KEY `id_ksiazka` (`id_ksiazka`,`id_platnosc`),
  ADD KEY `id_platnosc` (`id_platnosc`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `autorzy`
--
ALTER TABLE `autorzy`
  MODIFY `id_autor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `faktury`
--
ALTER TABLE `faktury`
  MODIFY `id_faktury` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `kody_rabatowe`
--
ALTER TABLE `kody_rabatowe`
  MODIFY `id_rabatu` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `koszyk`
--
ALTER TABLE `koszyk`
  MODIFY `id_koszyka` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `ksiazki`
--
ALTER TABLE `ksiazki`
  MODIFY `id_ksiazki` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `opinie`
--
ALTER TABLE `opinie`
  MODIFY `id_opinia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `platnosci`
--
ALTER TABLE `platnosci`
  MODIFY `id_platnosc` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `rezerwacje`
--
ALTER TABLE `rezerwacje`
  MODIFY `id_rezerwacji` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `zamowienia`
--
ALTER TABLE `zamowienia`
  MODIFY `id_zamowienia` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `faktury`
--
ALTER TABLE `faktury`
  ADD CONSTRAINT `faktury_ibfk_1` FOREIGN KEY (`id_zamowienia`) REFERENCES `zamowienia` (`id_zamowienia`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `faktury_ibfk_2` FOREIGN KEY (`id_klienta`) REFERENCES `klienci` (`id_klienta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `klienci`
--
ALTER TABLE `klienci`
  ADD CONSTRAINT `klienci_ibfk_1` FOREIGN KEY (`login`) REFERENCES `users` (`login`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `koszyk`
--
ALTER TABLE `koszyk`
  ADD CONSTRAINT `koszyk_ibfk_1` FOREIGN KEY (`id_koszyka`) REFERENCES `klienci` (`id_klienta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `koszyk_ibfk_2` FOREIGN KEY (`id_produktu`) REFERENCES `ksiazki` (`id_ksiazki`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `ksiazki_autorzy`
--
ALTER TABLE `ksiazki_autorzy`
  ADD CONSTRAINT `ksiazki_autorzy_ibfk_1` FOREIGN KEY (`id_autora`) REFERENCES `autorzy` (`id_autor`),
  ADD CONSTRAINT `ksiazki_autorzy_ibfk_2` FOREIGN KEY (`id_ksiazki`) REFERENCES `ksiazki` (`id_ksiazki`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `opinie`
--
ALTER TABLE `opinie`
  ADD CONSTRAINT `opinie_ibfk_1` FOREIGN KEY (`id_klienta`) REFERENCES `klienci` (`id_klienta`);

--
-- Ograniczenia dla tabeli `rezerwacje`
--
ALTER TABLE `rezerwacje`
  ADD CONSTRAINT `rezerwacje_ibfk_1` FOREIGN KEY (`id_klienta`) REFERENCES `klienci` (`id_klienta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rezerwacje_ibfk_2` FOREIGN KEY (`id_ksiazka`) REFERENCES `ksiazki` (`id_ksiazki`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `zamowienia`
--
ALTER TABLE `zamowienia`
  ADD CONSTRAINT `zamowienia_ibfk_1` FOREIGN KEY (`id_klienta`) REFERENCES `klienci` (`id_klienta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `zamowienia_ibfk_2` FOREIGN KEY (`id_ksiazka`) REFERENCES `ksiazki` (`id_ksiazki`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `zamowienia_ibfk_3` FOREIGN KEY (`id_platnosc`) REFERENCES `platnosci` (`id_platnosc`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
