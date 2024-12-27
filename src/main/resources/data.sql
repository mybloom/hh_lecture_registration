-- instructor
INSERT INTO `instructor` (`id`,`name`) VALUES
(1,'Instructor 1'),
(2,'Instructor 2'),
(3,'Instructor 3'),
(4,'Instructor 4'),
(5,'Instructor 5');

-- lecture
INSERT INTO `lecture` (`id`,`name`, `quota`, `instructor_id`) VALUES
(1, 'Lecture 1', 30, 1),
(2, 'Lecture 2', 30, 2),
(3, 'Lecture 3', 30, 3),
(4, 'Lecture 4', 30, 4),
(5, 'Lecture 5', 30, 5),
(6, 'Lecture 6', 30, 1);

-- lecture_schedule
INSERT INTO `lecture_schedule` (`id`, `lecture_id`, `scheduled_at`) VALUES
(1, 1, '2024-12-25 09:00:00'),
(2, 1, '2024-12-25 10:00:00'),
(3, 1, '2024-12-25 11:00:00'),
(4, 1, '2024-12-25 12:00:00'),
(5, 1, '2024-12-25 13:00:00'),
(6, 1, '2024-12-25 14:00:00'),
(7, 1, '2024-12-25 15:00:00'),
(8, 1, '2024-12-25 16:00:00'),
(9, 1, '2024-12-25 17:00:00'),
(10, 1, '2024-12-25 18:00:00'),

(11, 2, '2024-12-26 09:00:00'),
(12, 2, '2024-12-26 10:00:00'),
(13, 2, '2024-12-26 11:00:00'),
(14, 2, '2024-12-26 12:00:00'),
(15, 2, '2024-12-26 13:00:00'),
(16, 2, '2024-12-26 14:00:00'),
(17, 2, '2024-12-26 15:00:00'),
(18, 2, '2024-12-26 16:00:00'),
(19, 2, '2024-12-26 17:00:00'),
(20, 2, '2024-12-26 18:00:00'),

(21, 3, '2024-12-27 09:00:00'),
(22, 3, '2024-12-27 10:00:00'),
(23, 3, '2024-12-27 11:00:00'),
(24, 3, '2024-12-27 12:00:00'),
(25, 3, '2024-12-27 13:00:00'),
(26, 3, '2024-12-27 14:00:00'),
(27, 3, '2024-12-27 15:00:00'),
(28, 3, '2024-12-27 16:00:00'),
(29, 3, '2024-12-27 17:00:00'),
(30, 3, '2024-12-27 18:00:00'),

(31, 4, '2024-12-28 09:00:00'),
(32, 4, '2024-12-28 10:00:00'),
(33, 4, '2024-12-28 11:00:00'),
(34, 4, '2024-12-28 12:00:00'),
(35, 4, '2024-12-28 13:00:00'),
(36, 4, '2024-12-28 14:00:00'),
(37, 4, '2024-12-28 15:00:00'),
(38, 4, '2024-12-28 16:00:00'),
(39, 4, '2024-12-28 17:00:00'),
(40, 4, '2024-12-28 18:00:00'),

(41, 5, '2024-12-29 09:00:00'),
(42, 5, '2024-12-29 10:00:00'),
(43, 5, '2024-12-29 11:00:00'),
(44, 5, '2024-12-29 12:00:00'),
(45, 5, '2024-12-29 13:00:00'),
(46, 5, '2024-12-29 14:00:00'),
(47, 5, '2024-12-29 15:00:00'),
(48, 5, '2024-12-29 16:00:00'),
(49, 5, '2024-12-29 17:00:00'),
(50, 5, '2024-12-29 18:00:00'),

(51, 6, '2024-12-30 09:00:00'),
(52, 6, '2024-12-30 10:00:00'),
(53, 6, '2024-12-30 11:00:00'),
(54, 6, '2024-12-30 12:00:00'),
(55, 6, '2024-12-30 13:00:00'),
(56, 6, '2024-12-30 14:00:00'),
(57, 6, '2024-12-30 15:00:00'),
(58, 6, '2024-12-30 16:00:00'),
(59, 6, '2024-12-30 17:00:00'),
(60, 6, '2024-12-30 18:00:00');

-- t_user
INSERT INTO `t_user` (`id`, `name`)
VALUES
(1, 'User1'),
(2, 'User2'),
(3, 'User3'),
(4, 'User4'),
(5, 'User5'),
(6, 'User6'),
(7, 'User7'),
(8, 'User8'),
(9, 'User9'),
(10, 'User10'),
(11, 'User11'),
(12, 'User12'),
(13, 'User13'),
(14, 'User14'),
(15, 'User15'),
(16, 'User16'),
(17, 'User17'),
(18, 'User18'),
(19, 'User19'),
(20, 'User20'),
(21, 'User21'),
(22, 'User22'),
(23, 'User23'),
(24, 'User24'),
(25, 'User25'),
(26, 'User26'),
(27, 'User27'),
(28, 'User28'),
(29, 'User29'),
(30, 'User30'),
(31, 'User31'),
(32, 'User32'),
(33, 'User33'),
(34, 'User34'),
(35, 'User35'),
(36, 'User36'),
(37, 'User37'),
(38, 'User38'),
(39, 'User39'),
(40, 'User40');

-- lecture_enrollment
INSERT INTO `lecture_enrollment` (`id`, `lecture_id`, `lecture_schedule_id`, `user_id`)
VALUES
(1, 1, 1, 1),
(2, 2, 12, 1),
(3, 3, 23, 1),
(4, 4, 34, 2),
(5, 5, 45, 2),
(6, 6, 56, 2);
