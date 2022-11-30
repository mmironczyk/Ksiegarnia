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

-- Zrzut struktury tabela bookstore.klienci
CREATE TABLE IF NOT EXISTS `klienci` (
  `id_klienta` int(11) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- Zrzucanie danych dla tabeli bookstore.klienci: ~1 rows (około)
/*!40000 ALTER TABLE `klienci` DISABLE KEYS */;
INSERT INTO `klienci` (`id_klienta`, `login`, `imie`, `nazwisko`, `miejscowosc`, `kod_pocztowy`, `ulica`, `nr_domu`, `nr_telefonu`) VALUES
	(2, 'admin', 'admin', 'admin', 'adam', 'adam', 'adam', NULL, 'adam');
/*!40000 ALTER TABLE `klienci` ENABLE KEYS */;

-- Zrzut struktury tabela bookstore.ksiazki
CREATE TABLE IF NOT EXISTS `ksiazki` (
  `id_ksiazki` int(11) NOT NULL AUTO_INCREMENT,
  `tytul` varchar(40) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `cena` float unsigned DEFAULT NULL,
  `ilosc_sztuk` int(5) DEFAULT 0,
  `ilosc_stron` int(5) DEFAULT 0,
  `data_wydania` varchar(10) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `opis` varchar(5000) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `autor` varchar(1000) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `okladka` text COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `gatunek` varchar(50) COLLATE utf8mb4_polish_ci DEFAULT '0',
  PRIMARY KEY (`id_ksiazki`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- Zrzucanie danych dla tabeli bookstore.ksiazki: ~5 rows (około)
/*!40000 ALTER TABLE `ksiazki` DISABLE KEYS */;
INSERT INTO `ksiazki` (`id_ksiazki`, `tytul`, `cena`, `ilosc_sztuk`, `ilosc_stron`, `data_wydania`, `opis`, `autor`, `okladka`, `gatunek`) VALUES
	(16, 'Harry Potter i kamień filozoficzny', 27.99, 30, 352, '2015-08-09', 'Harry Potter, sierota i podrzutek, od niemowlęcia wychowywany był przez ciotkę i wuja, którzy traktowali go jak piąte koło u wozu. Pochodzenie chłopca owiane jest tajemnicą; jedyną pamiątką Harry`ego z przeszłości jest zagadkowa blizna na czole. Skąd jednak biorą się niesamowite zjawiska, które towarzyszą nieświadomemu niczego Potterowi? Wszystko zmienia się w dniu jedenastych urodzin chłopca, kiedy dowiaduje się o istnieniu świata, o którym nie miał dotąd pojęcia.\r\nNowe wydanie książki o najsłynniejszym czarodzieju świata różni się od poprzednich nie tylko okładką, ale i wnętrzem – po raz pierwszy na początku każdego tomu pojawi się mapka Hogwartu i okolic, początki rozdziałów ozdobione będą specjalnymi gwiazdkami, a na końcu pierwszego tomu na Czytelników czeka coś zupełnie wyjątkowego – akt personalny J.K. Rowling, z którego można dowiedzieć się, jakie jest ulubione zwierzę czy bohater literacki autorki.', 'J.K. Rowling', 'upload/1669814997086494238-352x500.jpg', 'Fantastyka'),
	(17, 'Bractwo pierścienia. Władca Pierścieni.', 45.67, 49, 608, '2016-09-11', 'Pierwsza część słynnego cyklu Tolkiena "Władca Pierścieni". Osadzona, jak i pozostałe, w niezwykle oryginalnym świecie, utworzonym dzięki bogactwu i sile wyobraźni autora. Świat tej powieści wciąga i fascynuje, urzeka fikcyjną rzeczywistością, ze stworzoną na jej użytek geografią, historią, kulturą i mitologią.', 'J.R.R. Tolkien', 'upload/1669815244198973981-352x500.jpg', 'Fantastyka'),
	(18, 'Morderstwo w Orient Expressie', 52.38, 90, 272, '', 'Ekskluzywna edycja kolekcjonerska wybranych dzieł Agaty Christie z okazji 100-lecia wydania pierwszej książki z Herkulesem Poirot.\r\nHerkules Poirot po rozwiązaniu sprawy kryminalnej w Azji wraca do Europy. Pociąg Orient Express, którym podróżuje, grzęźnie w zaspie śnieżnej. W nocy w niewyjaśnionych okolicznościach ginie jeden z pasażerów. Detektyw Poirot rozpoczyna dochodzenie, a jego podróż zamienia się w śledztwo. Fakty wskazują, że zabójca zajmuje przedział w tym samym wagonie… Czy Poirot zdoła rozwiązać zagadkę tajemniczego morderstwa? Sprawa nie należy do łatwych - każdy pasażer jest podejrzany…', 'Agatha Christie', 'upload/1669815365701984743-352x500.jpg', 'Kryminał'),
	(19, 'Małe kobietki', 37.89, 69, 192, '', 'Ekskluzywna edycja oprawiona w delikatną gładką tkaninę o właściwościach jedwabiu.\r\nSiostry March, bohaterki najpopularniejszej powieści Louisy May Alcott rozkochały w sobie już wiele pokoleń czytelników. W „Małych kobietkach” czytelnik znajdzie ciepłe, lecz niepozbawione refleksji portrety czterech sióstr: utalentowanej chłopczycy i przyszłej pisarki Jo, wątłej i nieśmiałej Beth o złotym sercu, pięknej i ambitnej Meg oraz romantycznej, ale rozpieszczonej Amy. O jedność i byt rodziny dzielnie walczy ich matka Marmee, podczas gdy ojciec bierze udział w wojnie secesyjnej.\r\nNie jest tajemnicą, że Alcott napisała powieść, czerpiąc z własnych doświadczeń. Kiedy jej ojciec, wolnomyślicielski reformator i abolicjonista Bronson Alcott, prowadził dysputy z takimi znakomitościami jak Emerson, Thoreau i Hawthorne, Louisa utrzymywała siebie i siostry z drobnych prac, takich jak szycie, robienie prania czy praca w charakterze pomocy domowej.\r\nWkrótce jednak odkryła, że może więcej zarobić na pisaniu. „Małe kobietki” przyniosły jej nie tylko majątek, ale i sławę, choć daleko im do „książki dla dziewczynek”, o co prosił ją pierwszy wydawca. Powieść porusza tak ponadczasowe tematy, jak miłość i śmierć, wojna i pokój, konflikty między osobistymi ambicjami, a obowiązkami rodzinnymi czy zderzenie kultur dwóch kontynentów „starej” Europy i „nowej” Ameryki.', 'Louisa May Alcott', 'upload/1669815533057939478-352x500.jpg', 'Romans'),
	(20, 'Pamiętnik', 34.45, 78, 256, '2010-11-02', 'Karty starego notatnika kryją historię romantycznej miłości. Starszy pan codziennie odczytuje ją mieszkającej w domu opieki kobiecie chorej na alzheimera. Jest to opowieść o bogatej dziewczynie z miasta i ubogim chłopaku z prowincji, których pewnego lata połączyło wyjątkowe uczucie. Wbrew sobie zostali rozdzieleni, a ich miłość wystawiona na próbę. Czy uda im się ponownie spotkać?', 'Nicholas Sparks', '../../upload/test.png', 'Romans');
/*!40000 ALTER TABLE `ksiazki` ENABLE KEYS */;

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
  PRIMARY KEY (`id`) USING BTREE,
  KEY `login` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- Zrzucanie danych dla tabeli bookstore.users: ~1 rows (około)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `login`, `haslo`, `email`, `czy_zalogowany`, `typ`, `czy_aktywne`, `liczba_prob`, `blokada`, `kod`) VALUES
	(3, 'admin', 'cf354d5d99630065fcab4b6181f7f8783cf1f261e891445c96dada381a62ed54', 'admin@admin', 0, 'admin', 1, 0, 0, 'wnUd1uRrm6YbDkryGi8f');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

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
