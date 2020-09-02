-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 02, 2020 at 05:09 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javafx`
--

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

CREATE TABLE `categorie` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categorie`
--

INSERT INTO `categorie` (`id`, `libelle`) VALUES
(1, 'Entree'),
(2, 'Plat principale'),
(3, 'Boire');

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

CREATE TABLE `commande` (
  `id` bigint(20) NOT NULL,
  `boire` varchar(255) DEFAULT NULL,
  `entree` varchar(255) DEFAULT NULL,
  `num_table` int(11) NOT NULL,
  `plat` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `commande`
--

INSERT INTO `commande` (`id`, `boire`, `entree`, `num_table`, `plat`) VALUES
(18, 'Whiskey', 'Salade fruit de mere', 34, 'Pizza Hut');

-- --------------------------------------------------------

--
-- Table structure for table `facture`
--

CREATE TABLE `facture` (
  `id` bigint(20) NOT NULL,
  `drink` varchar(255) DEFAULT NULL,
  `entree` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `plat` varchar(255) DEFAULT NULL,
  `prixd` varchar(255) DEFAULT NULL,
  `prixe` varchar(255) DEFAULT NULL,
  `prixp` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `total` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `facture`
--

INSERT INTO `facture` (`id`, `drink`, `entree`, `libelle`, `plat`, `prixd`, `prixe`, `prixp`, `time`, `total`) VALUES
(1, 'Cola', 'Salade Nisoice', 'Facture7', 'Pizza Hut', '12.00', '13.99', '39.99', '2020-09-01 13:41:18', '65.98'),
(2, 'Cola', 'Salade Tomates', 'Facture1', 'Pizza Margaretta', '12.00', '11.50', '20.00', '2020-09-01 15:41:50', '43.5'),
(3, 'Jus d orange', 'Salade Tomates', 'Facture3', 'Pizza Margaretta', '7.00', '11.50', '20.00', '2020-09-01 16:12:25', '38.5'),
(4, 'Cola', 'Salade fruit de mere', 'Facture5', 'Fromage Burger', '12.00', '25.99', '25.99', '2020-09-01 16:16:45', '63.98'),
(6, 'Cola', 'Salade Nisoice', 'Facture4', 'Pizza Chesse', '12.00', '13.99', '30.00', '2020-09-01 16:23:04', '55.99'),
(8, 'Jus d orange', 'Salade fruit de mere', 'Facture6', 'Pizza Margaretta', '7.00', '25.99', '20.00', '2020-09-01 16:25:56', '52.989999999999995'),
(9, 'Jus d orange', 'Salade Nisoice', 'Facture2', 'Pizza Chesse', '7.00', '13.99', '30.00', '2020-09-01 16:31:38', '50.99'),
(10, 'Whiskey', 'Salade Tomates', 'Facture8', 'Pizza Hut', '80.00', '11.50', '39.99', '2020-09-01 16:35:19', '131.49'),
(11, 'Jus d orange', 'Salade fruit de mere', 'Facture11', 'Pizza Chesse', '7.00', '25.99', '30.00', '2020-09-01 16:45:06', '62.989999999999995'),
(12, 'Bear', 'Salade Nisoice', 'Facture10', 'Pizza Margaretta', '15.99', '13.99', '20.00', '2020-09-01 16:49:40', '49.980000000000004'),
(13, 'Cola', 'Salade Tomates', 'Facture9', 'Pizza Hut', '12.00', '11.50', '39.99', '2020-09-01 16:50:59', '63.49'),
(14, 'Cola', 'Salade Nisoice', 'Facture12', 'Pizza Margaretta', '12.00', '13.99', '20.00', '2020-09-01 17:24:23', '45.99'),
(15, 'Whiskey', 'Salade Tomates', 'Facture16', 'Fromage Burger', '80.00', '11.50', '25.99', '2020-09-01 17:34:29', '117.49'),
(16, 'Cola', 'Salade Nisoice', 'Facture14', 'Tortilla', '12.00', '13.99', '8.00', '2020-09-01 21:11:09', '33.99'),
(17, 'Whiskey', 'Salade Tomates', 'Facture17', 'Tortilla', '80.00', '11.50', '8.00', '2020-09-02 14:25:13', '99.5'),
(18, 'Jus d orange', 'Salade Tomates', 'Facture15', 'Pizza Margaretta', '7.00', '11.50', '20.00', '2020-09-02 14:58:50', '38.5'),
(19, 'Bear', 'Salade fruit de mere', 'Facture13', 'Tacos Keftaa', '15.99', '25.99', '30.00', '2020-09-02 15:02:57', '71.97999999999999'),
(20, 'Cola', 'Salade Tomates', 'Facture19', 'Tortilla', '12.00', '11.50', '8.00', '2020-09-02 15:06:19', '31.5');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `categorie_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `description`, `nom`, `price`, `categorie_id`) VALUES
(1, 'Pizza Margaretta with Chesse', 'Pizza Margaretta', '20.00', 2),
(2, NULL, 'Pizza Chesse', '30.00', 2),
(3, NULL, 'Fromage Burger', '25.99', 2),
(4, NULL, 'Salade Nisoice', '13.99', 1),
(5, NULL, 'Salade fruit de mere', '25.99', 1),
(6, NULL, 'Salade Tomates', '11.50', 1),
(7, NULL, 'Cola', '12.00', 3),
(8, NULL, 'Jus d orange', '7.00', 3),
(9, NULL, 'Pizza Hut', '39.99', 2),
(10, NULL, 'Whiskey', '80.00', 3),
(11, NULL, 'Bear', '15.99', 3),
(12, NULL, 'Tortilla', '8.00', 2),
(13, NULL, 'Tacos Keftaa', '30.00', 2);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `libelle`) VALUES
(1, 'Admin'),
(2, 'Comptable'),
(3, 'Serveur');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `dob` tinyblob DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `p1_id` bigint(20) DEFAULT NULL,
  `p2_id` bigint(20) DEFAULT NULL,
  `p3_id` bigint(20) DEFAULT NULL,
  `cne` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `dob`, `email`, `first_name`, `gender`, `last_name`, `password`, `role`, `p1_id`, `p2_id`, `p3_id`, `cne`) VALUES
(1, NULL, 'admin@admin.com', 'admin', 'male', 'admin', 'admin', 'Admin', NULL, NULL, NULL, 'EE35980'),
(2, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007e4080e78, 'hamza@hamza.com', 'Hamza', 'Male', 'Bouigrouane', 'hamza', 'Serveur', NULL, NULL, NULL, 'Ee42091'),
(3, NULL, 'comptable@comptable.com', 'comptable', 'Homme', 'comptable', '1234', 'Comptable', NULL, NULL, NULL, 'EE35981'),
(6, NULL, 'Bendrimou@gmail.com', 'Ayoub', NULL, 'Bendrimou', 'BendrimouEE328715', 'Admin', NULL, NULL, NULL, 'EE328715'),
(7, NULL, 'Elyakoubi@gmail.com', 'Nafia', NULL, 'Elyakoubi', 'ElyakoubiEE458360', 'Serveur', NULL, NULL, NULL, 'EE458360');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2arvv8m5bofeta1w9kq08sfw2` (`categorie_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdicmc4sif64lnhhnisa8evmsk` (`p1_id`),
  ADD KEY `FK9j94qlll7q06lfv22hwd5xnhq` (`p2_id`),
  ADD KEY `FKfsstf51rfr4c10p1uluseugrp` (`p3_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `facture`
--
ALTER TABLE `facture`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK2arvv8m5bofeta1w9kq08sfw2` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK9j94qlll7q06lfv22hwd5xnhq` FOREIGN KEY (`p2_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKdicmc4sif64lnhhnisa8evmsk` FOREIGN KEY (`p1_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKfsstf51rfr4c10p1uluseugrp` FOREIGN KEY (`p3_id`) REFERENCES `product` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
