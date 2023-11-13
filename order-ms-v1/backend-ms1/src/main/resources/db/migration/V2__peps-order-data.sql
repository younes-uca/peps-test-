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

--
-- Déchargement des données de la table `etablissement_seq`
--

INSERT INTO `etablissement_seq` (`next_val`) VALUES
(1);

--
-- Déchargement des données de la table `order_boutique_history`
--

INSERT INTO `order_boutique_history` (`id`, `action_type`, `data`, `object_id`, `object_name`, `user_id`, `username`, `date_history`) VALUES
(7, 'DELETE', '{\"id\":16,\"reference\":\"order-1\",\"orderDate\":\"10/31/2023 21:43\",\"total\":110.00,\"orderStatus\":{\"id\":1,\"libelle\":\"Initialisation\",\"code\":\"init\"},\"orderLines\":[{\"id\":31,\"price\":3.00,\"quantity\":10.00,\"quantityReceived\":0.00,\"product\":{\"id\":1,\"libelle\":\"p1\",\"code\":\"p1\"}},{\"id\":32,\"price\":4.00,\"quantity\":20.00,\"quantityReceived\":0.00,\"product\":{\"id\":2,\"libelle\":\"p2\",\"code\":\"p2\"}}]}', 16, 'OrderBoutique', NULL, NULL, '2023-11-01 05:02:30.000000'),
(8, 'DELETE', '{\"id\":17,\"reference\":\"order-9\",\"orderDate\":\"11/07/2023 15:59\",\"total\":35.00,\"orderStatus\":{\"id\":1,\"libelle\":\"Initialisation\",\"code\":\"init\"},\"orderLines\":[{\"id\":33,\"price\":10.00,\"quantity\":2.00,\"quantityReceived\":7.00,\"product\":{\"id\":1,\"libelle\":\"p1\",\"code\":\"p1\"}},{\"id\":34,\"price\":5.00,\"quantity\":3.00,\"quantityReceived\":0.00,\"product\":{\"id\":2,\"libelle\":\"p2\",\"code\":\"p2\"}}]}', 17, 'OrderBoutique', NULL, NULL, '2023-11-07 14:04:06.000000'),
(9, 'DELETE', '{\"id\":18,\"reference\":\"order-9\",\"orderDate\":\"11/07/2023 16:19\",\"total\":35.00,\"orderStatus\":{\"id\":1,\"libelle\":\"Initialisation\",\"code\":\"init\"},\"orderLines\":[{\"id\":35,\"price\":10.00,\"quantity\":2.00,\"quantityReceived\":7.00,\"product\":{\"id\":1,\"libelle\":\"p1\",\"code\":\"p1\"}},{\"id\":36,\"price\":5.00,\"quantity\":3.00,\"quantityReceived\":0.00,\"product\":{\"id\":2,\"libelle\":\"p2\",\"code\":\"p2\"}}]}', 18, 'OrderBoutique', NULL, NULL, '2023-11-07 14:21:39.000000'),
(10, 'DELETE', '{\"id\":19,\"reference\":\"order-9\",\"orderDate\":\"11/07/2023 16:21\",\"total\":35.00,\"orderStatus\":{\"id\":1,\"libelle\":\"Initialisation\",\"code\":\"init\"},\"orderLines\":[{\"id\":37,\"price\":10.00,\"quantity\":2.00,\"quantityReceived\":7.00,\"product\":{\"id\":1,\"libelle\":\"p1\",\"code\":\"p1\"}},{\"id\":38,\"price\":5.00,\"quantity\":3.00,\"quantityReceived\":0.00,\"product\":{\"id\":2,\"libelle\":\"p2\",\"code\":\"p2\"}}]}', 19, 'OrderBoutique', NULL, NULL, '2023-11-07 14:22:00.000000'),
(11, 'DELETE', '{\"id\":20,\"reference\":\"order-9\",\"orderDate\":\"11/07/2023 16:23\",\"total\":35.00,\"orderStatus\":{\"id\":1,\"libelle\":\"Initialisation\",\"code\":\"init\"},\"orderLines\":[{\"id\":39,\"price\":10.00,\"quantity\":2.00,\"quantityReceived\":7.00,\"product\":{\"id\":1,\"libelle\":\"p1\",\"code\":\"p1\"}},{\"id\":40,\"price\":5.00,\"quantity\":3.00,\"quantityReceived\":0.00,\"product\":{\"id\":2,\"libelle\":\"p2\",\"code\":\"p2\"}}]}', 20, 'OrderBoutique', NULL, NULL, '2023-11-07 14:24:03.000000'),
(12, 'DELETE', '{\"id\":21,\"reference\":\"order-9\",\"orderDate\":\"11/08/2023 17:10\",\"total\":35.00,\"orderStatus\":{\"id\":1,\"libelle\":\"Initialisation\",\"code\":\"init\"},\"orderLines\":[{\"id\":41,\"price\":10.00,\"quantity\":2.00,\"quantityReceived\":7.00,\"product\":{\"id\":1,\"libelle\":\"p1\",\"code\":\"p1\"}},{\"id\":42,\"price\":5.00,\"quantity\":3.00,\"quantityReceived\":0.00,\"product\":{\"id\":2,\"libelle\":\"p2\",\"code\":\"p2\"}}]}', 21, 'OrderBoutique', NULL, NULL, '2023-11-08 15:11:28.000000');

--
-- Déchargement des données de la table `order_boutique_history_seq`
--

INSERT INTO `order_boutique_history_seq` (`next_val`) VALUES
(13);

--
-- Déchargement des données de la table `order_boutique_seq`
--

INSERT INTO `order_boutique_seq` (`next_val`) VALUES
(22);

--
-- Déchargement des données de la table `order_line_seq`
--

INSERT INTO `order_line_seq` (`next_val`) VALUES
(43);

--
-- Déchargement des données de la table `order_status`
--

INSERT INTO `order_status` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `style`) VALUES
(1, 'anonymousUser', '2023-10-30 10:49:58.000000', '', NULL, 'init', 'Initialisation', NULL);

--
-- Déchargement des données de la table `order_status_seq`
--

INSERT INTO `order_status_seq` (`next_val`) VALUES
(2);

--
-- Déchargement des données de la table `permission`
--

INSERT INTO `permission` (`id`, `name`) VALUES
(1, 'Product.edit'),
(2, 'Product.list'),
(3, 'Product.view'),
(4, 'Product.add'),
(5, 'Product.delete'),
(6, 'OrderStatus.edit'),
(7, 'OrderStatus.list'),
(8, 'OrderStatus.view'),
(9, 'OrderStatus.add'),
(10, 'OrderStatus.delete'),
(11, 'ProductCategory.edit'),
(12, 'ProductCategory.list'),
(13, 'ProductCategory.view'),
(14, 'ProductCategory.add'),
(15, 'ProductCategory.delete'),
(16, 'OrderBoutique.edit'),
(17, 'OrderBoutique.list'),
(18, 'OrderBoutique.view'),
(19, 'OrderBoutique.add'),
(20, 'OrderBoutique.delete'),
(21, 'OrderLine.edit'),
(22, 'OrderLine.list'),
(23, 'OrderLine.view'),
(24, 'OrderLine.add'),
(25, 'OrderLine.delete');

--
-- Déchargement des données de la table `permission_seq`
--

INSERT INTO `permission_seq` (`next_val`) VALUES
(101);

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`id`, `createdby`, `createdon`, `updatedby`, `updatedon`, `code`, `libelle`, `product_category`) VALUES
(1, '', '2023-10-30 10:44:10.000000', '', NULL, 'p1', 'p1', NULL),
(2, '', '2023-10-30 10:44:10.000000', '', NULL, 'p2', 'p2', NULL);

--
-- Déchargement des données de la table `product_category_seq`
--

INSERT INTO `product_category_seq` (`next_val`) VALUES
(1);

--
-- Déchargement des données de la table `product_seq`
--

INSERT INTO `product_seq` (`next_val`) VALUES
(3);

--
-- Déchargement des données de la table `roles_permissions`
--

INSERT INTO `roles_permissions` (`role_id`, `permission_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(1, 17),
(1, 18),
(1, 19),
(1, 20),
(1, 21),
(1, 22),
(1, 23),
(1, 24),
(1, 25);

--
-- Déchargement des données de la table `role_app`
--

INSERT INTO `role_app` (`id`, `authority`, `created_at`, `label`, `updated_at`) VALUES
(1, 'ROLE_ADMIN', NULL, NULL, NULL);

--
-- Déchargement des données de la table `role_app_seq`
--

INSERT INTO `role_app_seq` (`next_val`) VALUES
(51);

--
-- Déchargement des données de la table `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 1);

--
-- Déchargement des données de la table `user_app`
--

INSERT INTO `user_app` (`id`, `created_by`, `created_on`, `updated_by`, `updated_on`, `account_non_expired`, `account_non_locked`, `created_at`, `credentials_non_expired`, `email`, `enabled`, `password`, `password_changed`, `updated_at`, `username`, `etablissement`) VALUES
(1, NULL, '2023-10-30 10:44:10.000000', NULL, NULL, b'1', b'1', '2023-10-30 10:44:10.000000', b'1', 'admin', b'1', '$2a$10$MayJAaAkS6qu9WyZTqZoU.A5k/T7XXyD.XLRJG.DSR3AXXI0RYSDi', b'0', NULL, 'admin', NULL);

--
-- Déchargement des données de la table `user_app_seq`
--

INSERT INTO `user_app_seq` (`next_val`) VALUES
(51);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
