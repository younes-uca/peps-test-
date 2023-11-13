-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 08 nov. 2023 à 16:53
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `peps-order`
--

-- --------------------------------------------------------

--
-- Structure de la table `etablissement`
--

CREATE TABLE `etablissement` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime(6) DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `etablissement_seq`
--

CREATE TABLE `etablissement_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `order_boutique`
--

CREATE TABLE `order_boutique` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime(6) DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime(6) DEFAULT NULL,
  `order_date` datetime(6) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `total` decimal(38,2) DEFAULT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `order_status` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `order_boutique_history`
--

CREATE TABLE `order_boutique_history` (
  `id` bigint(20) NOT NULL,
  `action_type` varchar(255) DEFAULT NULL,
  `data` text DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `date_history` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `order_boutique_history_seq`
--

CREATE TABLE `order_boutique_history_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `order_boutique_seq`
--

CREATE TABLE `order_boutique_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `order_line`
--

CREATE TABLE `order_line` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime(6) DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime(6) DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  `quantity` decimal(38,2) DEFAULT NULL,
  `quantity_received` decimal(38,2) DEFAULT NULL,
  `order_boutique` bigint(20) DEFAULT NULL,
  `product` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `order_line_seq`
--

CREATE TABLE `order_line_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `order_status`
--

CREATE TABLE `order_status` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime(6) DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `style` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `order_status_seq`
--

CREATE TABLE `order_status_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `permission`
--

CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `permission_seq`
--

CREATE TABLE `permission_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime(6) DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `product_category` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `product_category`
--

CREATE TABLE `product_category` (
  `id` bigint(20) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createdon` datetime(6) DEFAULT NULL,
  `updatedby` varchar(255) DEFAULT NULL,
  `updatedon` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `product_category_seq`
--

CREATE TABLE `product_category_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `product_seq`
--

CREATE TABLE `product_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `roles_permissions`
--

CREATE TABLE `roles_permissions` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `role_app`
--

CREATE TABLE `role_app` (
  `id` bigint(20) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `role_app_seq`
--

CREATE TABLE `role_app_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user_app`
--

CREATE TABLE `user_app` (
  `id` bigint(20) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `password_changed` bit(1) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `etablissement` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user_app_seq`
--

CREATE TABLE `user_app_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `etablissement`
--
ALTER TABLE `etablissement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `order_boutique`
--
ALTER TABLE `order_boutique`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgr52qg4tf2dysenovidndopf5` (`order_status`);

--
-- Index pour la table `order_boutique_history`
--
ALTER TABLE `order_boutique_history`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `order_line`
--
ALTER TABLE `order_line`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3ol2rnbqsvf8ob4dp2d6ukrvt` (`order_boutique`),
  ADD KEY `FK863a744knr50mljrji0krsko` (`product`);

--
-- Index pour la table `order_status`
--
ALTER TABLE `order_status`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbvdd7owwhvkamc6unq83xdcrj` (`product_category`);

--
-- Index pour la table `product_category`
--
ALTER TABLE `product_category`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `roles_permissions`
--
ALTER TABLE `roles_permissions`
  ADD KEY `FKboeuhl31go7wer3bpy6so7exi` (`permission_id`),
  ADD KEY `FK3q3rt3at2wf4ooe7npa3et6yb` (`role_id`);

--
-- Index pour la table `role_app`
--
ALTER TABLE `role_app`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FK4e8pdqeupv69eukb2bvy2ftbd` (`role_id`),
  ADD KEY `FK50gpsre6oxwwqf394f8wov1yf` (`user_id`);

--
-- Index pour la table `user_app`
--
ALTER TABLE `user_app`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2xblr2jfuwcj4ktkjxbf8ir13` (`etablissement`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `order_boutique`
--
ALTER TABLE `order_boutique`
  ADD CONSTRAINT `FKgr52qg4tf2dysenovidndopf5` FOREIGN KEY (`order_status`) REFERENCES `order_status` (`id`);

--
-- Contraintes pour la table `order_line`
--
ALTER TABLE `order_line`
  ADD CONSTRAINT `FK3ol2rnbqsvf8ob4dp2d6ukrvt` FOREIGN KEY (`order_boutique`) REFERENCES `order_boutique` (`id`),
  ADD CONSTRAINT `FK863a744knr50mljrji0krsko` FOREIGN KEY (`product`) REFERENCES `product` (`id`);

--
-- Contraintes pour la table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FKbvdd7owwhvkamc6unq83xdcrj` FOREIGN KEY (`product_category`) REFERENCES `product_category` (`id`);

--
-- Contraintes pour la table `roles_permissions`
--
ALTER TABLE `roles_permissions`
  ADD CONSTRAINT `FK3q3rt3at2wf4ooe7npa3et6yb` FOREIGN KEY (`role_id`) REFERENCES `role_app` (`id`),
  ADD CONSTRAINT `FKboeuhl31go7wer3bpy6so7exi` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`);

--
-- Contraintes pour la table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FK4e8pdqeupv69eukb2bvy2ftbd` FOREIGN KEY (`role_id`) REFERENCES `role_app` (`id`),
  ADD CONSTRAINT `FK50gpsre6oxwwqf394f8wov1yf` FOREIGN KEY (`user_id`) REFERENCES `user_app` (`id`);

--
-- Contraintes pour la table `user_app`
--
ALTER TABLE `user_app`
  ADD CONSTRAINT `FK2xblr2jfuwcj4ktkjxbf8ir13` FOREIGN KEY (`etablissement`) REFERENCES `etablissement` (`id`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
