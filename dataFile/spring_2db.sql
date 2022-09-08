-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 18 juin 2022 à 14:29
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `spring_2db`
--

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `category_id` bigint(20) NOT NULL,
  `category_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`category_id`, `category_name`) VALUES
(4, 'Huile D\'olive'),
(247, 'Huile Parfumé'),
(255, 'Huile Végétale');

-- --------------------------------------------------------

--
-- Structure de la table `cmd_quantity`
--

CREATE TABLE `cmd_quantity` (
  `cmd_cmd_id` bigint(20) NOT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `cmd_quantity`
--

INSERT INTO `cmd_quantity` (`cmd_cmd_id`, `quantity`) VALUES
(161, 50),
(161, 5),
(162, 50),
(162, 5),
(166, 10),
(166, 15),
(166, 5),
(168, 10),
(168, 15),
(168, 5),
(168, 55),
(170, 15),
(170, 5),
(170, 55),
(170, 55),
(186, 15),
(186, 5),
(186, 8),
(186, 5),
(187, 15),
(187, 5),
(187, 8),
(187, 5),
(188, 15),
(188, 5),
(188, 8),
(188, 5),
(189, 15),
(189, 5),
(189, 5),
(190, 15),
(190, 5),
(190, 5),
(192, 9),
(195, 8),
(195, 5),
(197, 48),
(199, 9),
(201, 88),
(203, 777),
(205, 2),
(260, 4),
(260, 5),
(260, 5),
(272, 5),
(272, 2),
(277, 5),
(277, 8),
(277, 2);

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `cmd_id` bigint(20) NOT NULL,
  `cmd_totale` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `cmd_date` datetime DEFAULT NULL,
  `cmd_etat` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`cmd_id`, `cmd_totale`, `user_id`, `cmd_date`, `cmd_etat`) VALUES
(260, 242, 1, '2022-05-19 15:21:24', 'En cours'),
(272, 114, 268, '2022-05-19 18:48:26', 'Envoyer'),
(277, 296, 1, '2022-05-20 19:12:11', 'En cours');

-- --------------------------------------------------------

--
-- Structure de la table `commande_product_list`
--

CREATE TABLE `commande_product_list` (
  `cmd_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commande_product_list`
--

INSERT INTO `commande_product_list` (`cmd_id`, `product_id`) VALUES
(92, 28),
(92, 27),
(92, 50),
(93, 28),
(93, 27),
(95, 28),
(95, 52),
(96, 52),
(97, 52),
(98, 52),
(99, 52),
(100, 52),
(101, 52),
(102, 52),
(103, 52),
(104, 52),
(105, 52),
(107, 52),
(107, 28),
(108, 52),
(108, 28),
(109, 52),
(109, 28),
(110, 52),
(110, 28),
(111, 52),
(111, 28),
(112, 52),
(112, 28),
(113, 52),
(113, 28),
(114, 52),
(114, 28),
(115, 28),
(116, 28),
(117, 28),
(119, 52),
(123, 28),
(147, 29),
(147, 28),
(149, 29),
(149, 28),
(149, 50),
(150, 29),
(154, 28),
(154, 50),
(155, 28),
(160, 29),
(160, 151),
(160, 28),
(160, 52),
(161, 29),
(161, 151),
(162, 29),
(162, 151),
(166, 52),
(166, 151),
(166, 50),
(168, 52),
(168, 151),
(168, 50),
(168, 28),
(170, 151),
(170, 50),
(170, 28),
(170, 27),
(186, 151),
(186, 50),
(186, 27),
(186, 28),
(187, 151),
(187, 50),
(187, 27),
(187, 28),
(188, 151),
(188, 50),
(188, 27),
(188, 28),
(189, 151),
(189, 50),
(189, 28),
(190, 151),
(190, 50),
(190, 28),
(192, 27),
(195, 28),
(195, 29),
(197, 29),
(199, 28),
(201, 28),
(203, 29),
(205, 50),
(260, 246),
(260, 249),
(260, 248),
(272, 246),
(272, 258),
(277, 246),
(277, 248),
(277, 257);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(282),
(282),
(282);

-- --------------------------------------------------------

--
-- Structure de la table `item`
--

CREATE TABLE `item` (
  `item_id` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `item_description` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_phone_number` varchar(255) DEFAULT NULL,
  `region_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `item`
--

INSERT INTO `item` (`item_id`, `image`, `item_description`, `item_name`, `item_phone_number`, `region_id`) VALUES
(263, '/resources/1652980918109.jfif', 'hektar w noss fih 9orabet 288 zitouna zitoun sa7li 3marhom 8 snin', 'Arth Lel bi3', '55315313', 15),
(264, '/resources/1652981157896.jfif', '6 hiktarat ou 163 zitoun sa7li ou dar 3rbi 9dima 9riba le rondpoint zrbiya', 'Arth Zitoun', '50706380', 16),
(265, '/resources/1652981460863.jfif', 'sabet zitoun 15 malyoun fiha .....................................................................', 'Sabet Zitoun', '23682713', 17);

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

CREATE TABLE `panier` (
  `panier_id` bigint(20) NOT NULL,
  `num` int(11) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_price` int(11) DEFAULT NULL,
  `product_unit` int(11) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `provider_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`product_id`, `image`, `product_description`, `product_name`, `product_price`, `product_unit`, `category_id`, `provider_id`) VALUES
(246, '/resources/1652968051311.jpg', '250ml', 'variété chemlali', 18, 100, 247, 228),
(248, '/resources/1652967489817.jpg', '1L', 'Marasca', 18, 50, 247, 233),
(249, '/resources/1652967749614.PNG', '1L', 'Galloncino', 16, 25, 247, 233),
(250, '/resources/1652967871175.PNG', '500ml', 'Dorica', 10, 120, 247, 233),
(254, '/resources/1652968376518.png', '500ml', 'Huile d\'olive conditionnee', 9, 50, 247, 232),
(257, '/resources/1652972014674.jpg', '5L', 'Huile de mais', 31, 20, 255, 256),
(258, '/resources/1652972061148.jpg', '1.8L', 'Huile de mais', 12, 50, 255, 256),
(261, '/resources/1652980393781.jpg', '100ml', 'Truffle noir', 33, 10, 4, 232),
(262, '/resources/1652980495317.jpg', '375ml', 'Arbosana', 11, 40, 4, 232);

-- --------------------------------------------------------

--
-- Structure de la table `provider`
--

CREATE TABLE `provider` (
  `provider_id` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `provider_description` varchar(255) DEFAULT NULL,
  `provider_name` varchar(255) DEFAULT NULL,
  `provider_num` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `provider`
--

INSERT INTO `provider` (`provider_id`, `image`, `provider_description`, `provider_name`, `provider_num`) VALUES
(228, '/resources/1652871732764.PNG', 'A chaque étape de son élaboration, notre huile d’olive bio reçoit tout notre soin, notre  passion, notre respect, et tout l’héritage de nos traditions. Nos huiles sont certifiées biologique, et demeter pour une partie de la production.', 'Mediterroir', 23753951),
(232, '/resources/1652871953180.PNG', 'Zaafrana, huilerie du Nord-Ouest de la Tunisie s’est imposée en tant que référence dans le secteur des industries Agro-Alimentaire. Elle est spécialisée dans l\'extraction, la production, la vente et l’export de l’huile d’olive extra vierge.', 'Zaafrana', 92107989),
(233, '/resources/1652872158231.PNG', 'L’huile d’olive tunisienne est fameuse pour son parfum unique, son gout inimitable, sa belle robe dorée et un savoir-faire ancestral. Précurseur et visionnaire, la famille Ben Achour sait déjà depuis 1925 ce que la presse clame aujourd’hui.', 'AlJazira', 74582691),
(256, '/resources/1652971888790.PNG', 'SAFI est la marque pionnière dans le raffinage de l’huile de mais et de tournesol en Tunisie. Depuis son lancement en 2002, elle attire la satisfaction des consommateurs par sa qualité et son goût pur et naturel.', 'Safi', 74852963);

-- --------------------------------------------------------

--
-- Structure de la table `region`
--

CREATE TABLE `region` (
  `region_id` bigint(20) NOT NULL,
  `region_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `region`
--

INSERT INTO `region` (`region_id`, `region_name`) VALUES
(14, 'Tunis'),
(15, 'Sfax'),
(16, 'Sousse'),
(17, 'Mounastir');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `active` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`user_id`, `active`, `email`, `first_name`, `last_name`, `password`, `role`) VALUES
(1, 1, 'ahmedjarr@live.fr', 'Jarraya', 'Ahmed', '$2a$10$faucZHJOFRnrkJQC4S3GKuIfIaqBd0Kz7Pb01suA7cmbFiX1whm2G', 'ADMIN'),
(121, 1, 'MaykelDkuroVadaDaken@gmail.com', 'Melek', 'Dkuro', '$2a$10$GT8nNY9kLHTv1OpEtNpUO.4EvvtVfGtoN6F6mjmQnLseEQR4Q01Xu', 'USER'),
(268, 1, 'ImenTounsi@gmail.com', 'Imen', 'Tounsi', '$2a$10$E4jKfhaZJXVC/0WCrk.LmOOYNKTiJX7DcIiXWqkYsEj6Gv3f3Ld9u', 'USER'),
(266, 1, 'MakkiAmine@gmail.com', 'Amine', 'Makki', '$2a$10$zShryzxfq3XAv1KmgWqRiOCd37yVV3y.6j6FjvVK8KWfOcDZPRe7.', 'MANAGER');

-- --------------------------------------------------------

--
-- Structure de la table `user_product_list`
--

CREATE TABLE `user_product_list` (
  `user_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user_product_list`
--

INSERT INTO `user_product_list` (`user_id`, `product_id`) VALUES
(1, 27);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Index pour la table `cmd_quantity`
--
ALTER TABLE `cmd_quantity`
  ADD KEY `FK5lrf3b1pxdi6t1f4nvje2uviq` (`cmd_cmd_id`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`cmd_id`),
  ADD KEY `FKp5deswt3amtfx764raq42rw2o` (`user_id`);

--
-- Index pour la table `commande_product_list`
--
ALTER TABLE `commande_product_list`
  ADD KEY `FK7hbqcyveq7e99mvjk08wi2hmx` (`product_id`),
  ADD KEY `FKj6fq1cocj454i8x462lk5qu5s` (`cmd_id`);

--
-- Index pour la table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`item_id`),
  ADD KEY `FKagmnsi0c491fa9w7ydfbtfqic` (`region_id`);

--
-- Index pour la table `panier`
--
ALTER TABLE `panier`
  ADD PRIMARY KEY (`panier_id`),
  ADD KEY `FK4f1a574bmslyj4ayi02nqcg30` (`product_id`),
  ADD KEY `FK3rpgajdyk0w5g56ig9h08a53b` (`user_id`);

--
-- Index pour la table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  ADD KEY `FKfmt6vehie8ep9pq0nnvv9een7` (`provider_id`);

--
-- Index pour la table `provider`
--
ALTER TABLE `provider`
  ADD PRIMARY KEY (`provider_id`);

--
-- Index pour la table `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`region_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Index pour la table `user_product_list`
--
ALTER TABLE `user_product_list`
  ADD UNIQUE KEY `UKtr728v902ldqyx8rpuu0q5gd7` (`user_id`,`product_id`),
  ADD KEY `FK3004e70hlvx5lgevqfpaum5c9` (`product_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
