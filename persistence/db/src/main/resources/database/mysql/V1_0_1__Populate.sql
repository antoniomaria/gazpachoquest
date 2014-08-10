--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2014-08-10 19:57:58

-- Import Only Data, Uses Insert Column

--
-- TOC entry 2214 (class 0 OID 83632)
-- Dependencies: 190
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO role VALUES (2, 'Specific role for support support ', 'User Role');
INSERT INTO role VALUES (5, 'Specific role for Tyrion Lannister ', 'User Role');
INSERT INTO role VALUES (7, 'Specific role for Jon Snow ', 'User Role');
INSERT INTO role VALUES (9, 'Specific role for Arya Stark ', 'User Role');
INSERT INTO role VALUES (11, 'Specific role for Catelyn Stark ', 'User Role');


--
-- TOC entry 2215 (class 0 OID 83640)
-- Dependencies: 191
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users VALUES (1, '3F9ZGQ38MZUFE9X', NULL, '2014-08-10 19:57:02.545', 'support@gazpacho.net', NULL, 'support', '2014-08-10 19:57:02.545', NULL, NULL, 'HPVY7FX3NCPTBMVL3N4BAG34J5GR4NTS', 'support', 'support', 1, 2, 1);
INSERT INTO users VALUES (4, 'HN5HD3EH3SJG9GW', NULL, '2014-08-10 19:57:02.987', 'tyrion.lannister@kingslanding.net', 'M', 'Tyrion', '2014-08-10 19:57:02.987', NULL, NULL, 'D9JF5CYK2KWFWGCR8N99Y4QQKDZXVBS3', 'Lannister', NULL, 1, 5, 1);
INSERT INTO users VALUES (6, 'BHR6FUPBCADFEQS', NULL, '2014-08-10 19:57:03.021', 'jon.snow@nightswatch.net', 'M', 'Jon', '2014-08-10 19:57:03.021', NULL, 'ES', 'MQ787HAZWFYSE7VT2U2H7W6H5AQQKY6F', 'Snow', NULL, 1, 7, 1);
INSERT INTO users VALUES (8, 'H64Q4G3J6XG4VEL', NULL, '2014-08-10 19:57:03.048', 'arya.stark@winterfell.net', 'F', 'Arya', '2014-08-10 19:57:03.048', NULL, 'EN', 'CCQU86Q82JB4QPF6TPMXPHVXYKWPFGQQ', 'Stark', NULL, 1, 9, 1);
INSERT INTO users VALUES (10, 'B5DATQ556LWXTQ2', NULL, '2014-08-10 19:57:03.074', 'catelyn.stark@winterfell.net', 'F', 'Catelyn', '2014-08-10 19:57:03.074', NULL, 'FI', 'HE5XHRDD3FJR2KJ29ZRRZWZ2QHCXU2FD', 'Stark', NULL, 1, 11, 1);


--
-- TOC entry 2203 (class 0 OID 83547)
-- Dependencies: 179
-- Data for Name: questionnair_definition; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition VALUES (12, '2014-08-10 19:57:03.152', 'EN', '2014-08-10 19:57:03.152', true, true, NULL, 'N', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnair.', 1, 1);
INSERT INTO questionnair_definition VALUES (121, '2014-08-10 19:57:06.295', 'EN', '2014-08-10 19:57:06.295', true, true, NULL, 'Q', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnair.', 1, 1);
INSERT INTO questionnair_definition VALUES (230, '2014-08-10 19:57:08.069', 'EN', '2014-08-10 19:57:08.069', true, true, NULL, 'G', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnair.', 1, 1);
INSERT INTO questionnair_definition VALUES (339, '2014-08-10 19:57:09.453', 'EN', '2014-08-10 19:57:09.453', true, true, NULL, 'N', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnair.', 1, 1);
INSERT INTO questionnair_definition VALUES (448, '2014-08-10 19:57:10.849', 'EN', '2014-08-10 19:57:10.849', true, true, NULL, 'N', 'C', true, 'We at BIG DEES take pride in providing you with the highest standards of QUALITY, SERVICE, CLEANLINESS and VALUE in the restaurant industry.', NULL, 'Food Quality QuestionnairDefinition', 'Your opinion is extremely important in evaluating our business. Thank you for taking a moment to questionOption the following questions:', 1, 1);


--
-- TOC entry 2201 (class 0 OID 83534)
-- Dependencies: 177
-- Data for Name: question_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_group VALUES (14, '2014-08-10 19:57:03.294', 'EN', '2014-08-10 19:57:03.294', false, NULL, 'European Capitals', 1, 1, 12, 0);
INSERT INTO question_group VALUES (16, '2014-08-10 19:57:03.398', 'EN', '2014-08-10 19:57:03.398', false, NULL, 'European Union', 1, 1, 12, 1);
INSERT INTO question_group VALUES (18, '2014-08-10 19:57:03.476', 'EN', '2014-08-10 19:57:03.476', false, NULL, 'European History', 1, 1, 12, 2);
INSERT INTO question_group VALUES (123, '2014-08-10 19:57:06.337', 'EN', '2014-08-10 19:57:06.337', false, NULL, 'European Capitals', 1, 1, 121, 0);
INSERT INTO question_group VALUES (125, '2014-08-10 19:57:06.383', 'EN', '2014-08-10 19:57:06.383', false, NULL, 'European Union', 1, 1, 121, 1);
INSERT INTO question_group VALUES (127, '2014-08-10 19:57:06.433', 'EN', '2014-08-10 19:57:06.433', false, NULL, 'European History', 1, 1, 121, 2);
INSERT INTO question_group VALUES (232, '2014-08-10 19:57:08.103', 'EN', '2014-08-10 19:57:08.103', false, NULL, 'European Capitals', 1, 1, 230, 0);
INSERT INTO question_group VALUES (234, '2014-08-10 19:57:08.13', 'EN', '2014-08-10 19:57:08.13', false, NULL, 'European Union', 1, 1, 230, 1);
INSERT INTO question_group VALUES (236, '2014-08-10 19:57:08.163', 'EN', '2014-08-10 19:57:08.163', false, NULL, 'European History', 1, 1, 230, 2);
INSERT INTO question_group VALUES (343, '2014-08-10 19:57:09.509', 'EN', '2014-08-10 19:57:09.509', false, NULL, 'European Union', 1, 1, 339, 1);
INSERT INTO question_group VALUES (345, '2014-08-10 19:57:09.538', 'EN', '2014-08-10 19:57:09.538', false, NULL, 'European History', 1, 1, 339, 2);
INSERT INTO question_group VALUES (341, '2014-08-10 19:57:09.473', 'EN', '2014-08-10 19:57:09.473', true, NULL, 'European Capitals', 1, 1, 339, 0);
INSERT INTO question_group VALUES (449, '2014-08-10 19:57:10.859', 'EN', '2014-08-10 19:57:10.859', false, NULL, 'Fast Food QuestionnairDefinition - QuestionGroup', 1, 1, 448, 0);


--
-- TOC entry 2200 (class 0 OID 83526)
-- Dependencies: 176
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question VALUES (20, 'Q1', '2014-08-10 19:57:03.586', 'EN', '2014-08-10 19:57:03.586', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 14, NULL, 0);
INSERT INTO question VALUES (22, 'Q2', '2014-08-10 19:57:03.702', 'EN', '2014-08-10 19:57:03.702', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 14, NULL, 1);
INSERT INTO question VALUES (32, 'Q3', '2014-08-10 19:57:03.95', 'EN', '2014-08-10 19:57:03.95', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 14, NULL, 2);
INSERT INTO question VALUES (34, 'Q4', '2014-08-10 19:57:04.06', 'EN', '2014-08-10 19:57:04.06', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 14, NULL, 3);
INSERT INTO question VALUES (44, 'Q5', '2014-08-10 19:57:04.26', 'EN', '2014-08-10 19:57:04.26', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 16, NULL, 0);
INSERT INTO question VALUES (46, 'Q6', '2014-08-10 19:57:04.343', 'EN', '2014-08-10 19:57:04.343', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 16, NULL, 1);
INSERT INTO question VALUES (56, 'Q7', '2014-08-10 19:57:04.567', 'EN', '2014-08-10 19:57:04.567', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 16, NULL, 2);
INSERT INTO question VALUES (66, 'Q8', '2014-08-10 19:57:04.777', 'EN', '2014-08-10 19:57:04.777', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 16, NULL, 3);
INSERT INTO question VALUES (68, 'Q9', '2014-08-10 19:57:04.86', 'EN', '2014-08-10 19:57:04.86', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 18, NULL, 0);
INSERT INTO question VALUES (78, 'Q10', '2014-08-10 19:57:04.991', 'EN', '2014-08-10 19:57:04.991', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 18, NULL, 1);
INSERT INTO question VALUES (88, 'Q11', '2014-08-10 19:57:05.16', 'EN', '2014-08-10 19:57:05.16', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 18, NULL, 2);
INSERT INTO question VALUES (90, 'Q12', '2014-08-10 19:57:05.251', 'EN', '2014-08-10 19:57:05.251', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 18, NULL, 3);
INSERT INTO question VALUES (129, 'Q1', '2014-08-10 19:57:06.476', 'EN', '2014-08-10 19:57:06.476', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 123, NULL, 0);
INSERT INTO question VALUES (131, 'Q2', '2014-08-10 19:57:06.514', 'EN', '2014-08-10 19:57:06.514', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 123, NULL, 1);
INSERT INTO question VALUES (141, 'Q3', '2014-08-10 19:57:06.641', 'EN', '2014-08-10 19:57:06.641', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 123, NULL, 2);
INSERT INTO question VALUES (143, 'Q4', '2014-08-10 19:57:06.701', 'EN', '2014-08-10 19:57:06.701', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 123, NULL, 3);
INSERT INTO question VALUES (153, 'Q5', '2014-08-10 19:57:06.832', 'EN', '2014-08-10 19:57:06.832', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 125, NULL, 0);
INSERT INTO question VALUES (155, 'Q6', '2014-08-10 19:57:06.871', 'EN', '2014-08-10 19:57:06.871', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 125, NULL, 1);
INSERT INTO question VALUES (165, 'Q7', '2014-08-10 19:57:06.985', 'EN', '2014-08-10 19:57:06.985', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 125, NULL, 2);
INSERT INTO question VALUES (175, 'Q8', '2014-08-10 19:57:07.173', 'EN', '2014-08-10 19:57:07.173', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 125, NULL, 3);
INSERT INTO question VALUES (177, 'Q9', '2014-08-10 19:57:07.259', 'EN', '2014-08-10 19:57:07.259', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 127, NULL, 0);
INSERT INTO question VALUES (187, 'Q10', '2014-08-10 19:57:07.398', 'EN', '2014-08-10 19:57:07.398', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 127, NULL, 1);
INSERT INTO question VALUES (197, 'Q11', '2014-08-10 19:57:07.518', 'EN', '2014-08-10 19:57:07.518', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 127, NULL, 2);
INSERT INTO question VALUES (199, 'Q12', '2014-08-10 19:57:07.593', 'EN', '2014-08-10 19:57:07.593', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 127, NULL, 3);
INSERT INTO question VALUES (238, 'Q1', '2014-08-10 19:57:08.19', 'EN', '2014-08-10 19:57:08.19', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 232, NULL, 0);
INSERT INTO question VALUES (240, 'Q2', '2014-08-10 19:57:08.227', 'EN', '2014-08-10 19:57:08.227', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 232, NULL, 1);
INSERT INTO question VALUES (250, 'Q3', '2014-08-10 19:57:08.316', 'EN', '2014-08-10 19:57:08.316', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 232, NULL, 2);
INSERT INTO question VALUES (252, 'Q4', '2014-08-10 19:57:08.352', 'EN', '2014-08-10 19:57:08.352', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 232, NULL, 3);
INSERT INTO question VALUES (262, 'Q5', '2014-08-10 19:57:08.445', 'EN', '2014-08-10 19:57:08.445', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 234, NULL, 0);
INSERT INTO question VALUES (264, 'Q6', '2014-08-10 19:57:08.467', 'EN', '2014-08-10 19:57:08.467', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 234, NULL, 1);
INSERT INTO question VALUES (274, 'Q7', '2014-08-10 19:57:08.535', 'EN', '2014-08-10 19:57:08.535', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 234, NULL, 2);
INSERT INTO question VALUES (284, 'Q8', '2014-08-10 19:57:08.631', 'EN', '2014-08-10 19:57:08.631', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 234, NULL, 3);
INSERT INTO question VALUES (286, 'Q9', '2014-08-10 19:57:08.666', 'EN', '2014-08-10 19:57:08.666', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 236, NULL, 0);
INSERT INTO question VALUES (296, 'Q10', '2014-08-10 19:57:08.728', 'EN', '2014-08-10 19:57:08.728', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 236, NULL, 1);
INSERT INTO question VALUES (306, 'Q11', '2014-08-10 19:57:08.795', 'EN', '2014-08-10 19:57:08.795', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 236, NULL, 2);
INSERT INTO question VALUES (308, 'Q12', '2014-08-10 19:57:08.832', 'EN', '2014-08-10 19:57:08.832', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 236, NULL, 3);
INSERT INTO question VALUES (347, 'Q1', '2014-08-10 19:57:09.568', 'EN', '2014-08-10 19:57:09.568', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 341, NULL, 0);
INSERT INTO question VALUES (349, 'Q2', '2014-08-10 19:57:09.585', 'EN', '2014-08-10 19:57:09.585', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 341, NULL, 1);
INSERT INTO question VALUES (359, 'Q3', '2014-08-10 19:57:09.67', 'EN', '2014-08-10 19:57:09.67', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 341, NULL, 2);
INSERT INTO question VALUES (361, 'Q4', '2014-08-10 19:57:09.708', 'EN', '2014-08-10 19:57:09.708', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 341, NULL, 3);
INSERT INTO question VALUES (371, 'Q5', '2014-08-10 19:57:09.801', 'EN', '2014-08-10 19:57:09.801', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 343, NULL, 0);
INSERT INTO question VALUES (373, 'Q6', '2014-08-10 19:57:09.821', 'EN', '2014-08-10 19:57:09.821', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 343, NULL, 1);
INSERT INTO question VALUES (383, 'Q7', '2014-08-10 19:57:09.889', 'EN', '2014-08-10 19:57:09.889', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 343, NULL, 2);
INSERT INTO question VALUES (393, 'Q8', '2014-08-10 19:57:09.951', 'EN', '2014-08-10 19:57:09.951', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 343, NULL, 3);
INSERT INTO question VALUES (395, 'Q9', '2014-08-10 19:57:09.98', 'EN', '2014-08-10 19:57:09.98', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 345, NULL, 0);
INSERT INTO question VALUES (405, 'Q10', '2014-08-10 19:57:10.051', 'EN', '2014-08-10 19:57:10.051', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 345, NULL, 1);
INSERT INTO question VALUES (415, 'Q11', '2014-08-10 19:57:10.139', 'EN', '2014-08-10 19:57:10.139', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 345, NULL, 2);
INSERT INTO question VALUES (417, 'Q12', '2014-08-10 19:57:10.171', 'EN', '2014-08-10 19:57:10.171', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 345, NULL, 3);
INSERT INTO question VALUES (450, 'Q1', '2014-08-10 19:57:10.888', 'EN', '2014-08-10 19:57:10.888', false, true, 'F', NULL, '<b>Food Quality</b>', 1, 1, NULL, 449, NULL, 0);
INSERT INTO question VALUES (457, 'Q1.1', '2014-08-10 19:57:10.895', 'EN', '2014-08-10 19:57:10.895', false, false, 'L', NULL, 'The food is served hot and fresh', 1, 1, 450, NULL, 0, NULL);
INSERT INTO question VALUES (458, 'Q1.2', '2014-08-10 19:57:10.895', 'EN', '2014-08-10 19:57:10.895', false, false, 'L', NULL, 'The menu has a good variety of items', 1, 1, 450, NULL, 1, NULL);
INSERT INTO question VALUES (459, 'Q1.3', '2014-08-10 19:57:10.896', 'EN', '2014-08-10 19:57:10.896', false, false, 'L', NULL, 'The quality of food is excellent', 1, 1, 450, NULL, 2, NULL);
INSERT INTO question VALUES (460, 'Q1.4', '2014-08-10 19:57:10.896', 'EN', '2014-08-10 19:57:10.896', false, false, 'L', NULL, 'The food is tasty and flavorful', 1, 1, 450, NULL, 3, NULL);
INSERT INTO question VALUES (461, 'Q2', '2014-08-10 19:57:10.934', 'EN', '2014-08-10 19:57:10.934', false, true, 'F', NULL, '<b>Resturant</b>', 1, 1, NULL, 449, NULL, 1);
INSERT INTO question VALUES (468, 'Q2.1', '2014-08-10 19:57:10.938', 'EN', '2014-08-10 19:57:10.938', false, false, 'L', NULL, 'My food order was correct and complete', 1, 1, 461, NULL, 0, NULL);
INSERT INTO question VALUES (469, 'Q2.2', '2014-08-10 19:57:10.939', 'EN', '2014-08-10 19:57:10.939', false, false, 'L', NULL, 'Employees are patient when taking my order', 1, 1, 461, NULL, 1, NULL);
INSERT INTO question VALUES (470, 'Q2.3', '2014-08-10 19:57:10.939', 'EN', '2014-08-10 19:57:10.939', false, false, 'L', NULL, 'I was served promptly', 1, 1, 461, NULL, 2, NULL);
INSERT INTO question VALUES (471, 'Q2.4', '2014-08-10 19:57:10.94', 'EN', '2014-08-10 19:57:10.94', false, false, 'L', NULL, 'Availability of sauces, utensils, napkins, etc. was good', 1, 1, 461, NULL, 3, NULL);
INSERT INTO question VALUES (472, 'Q2.5', '2014-08-10 19:57:10.94', 'EN', '2014-08-10 19:57:10.94', false, false, 'L', NULL, 'The menu board was easy to read', 1, 1, 461, NULL, 4, NULL);
INSERT INTO question VALUES (473, 'Q2.6', '2014-08-10 19:57:10.941', 'EN', '2014-08-10 19:57:10.941', false, false, 'L', NULL, 'The drive-thru sound system was cleara', 1, 1, 461, NULL, 5, NULL);
INSERT INTO question VALUES (474, 'Q3', '2014-08-10 19:57:10.98', 'EN', '2014-08-10 19:57:10.98', false, true, 'L', NULL, 'Indicate total household income', 1, 1, NULL, 449, NULL, 2);


--
-- TOC entry 2205 (class 0 OID 83563)
-- Dependencies: 181
-- Data for Name: research; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO research VALUES (102, '2014-08-10 19:57:05.864', '2014-08-10 19:57:05.841', '2014-08-10 19:57:05.864', 'New QuizEuropean general knowledge quiz started', '2014-08-10 19:57:05.841', 'P', 1, 1);
INSERT INTO research VALUES (119, '2014-08-10 19:57:06.258', '2014-08-10 19:57:06.233', '2014-08-10 19:57:06.258', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-08-10 19:57:06.233', 'O', 1, 1);
INSERT INTO research VALUES (211, '2014-08-10 19:57:07.89', '2014-08-10 19:57:07.875', '2014-08-10 19:57:07.89', 'New QuizEuropean general knowledge quiz started', '2014-08-10 19:57:07.875', 'P', 1, 1);
INSERT INTO research VALUES (228, '2014-08-10 19:57:08.054', '2014-08-10 19:57:08.025', '2014-08-10 19:57:08.054', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-08-10 19:57:08.025', 'O', 1, 1);
INSERT INTO research VALUES (320, '2014-08-10 19:57:09.296', '2014-08-10 19:57:09.274', '2014-08-10 19:57:09.296', 'New QuizEuropean general knowledge quiz started', '2014-08-10 19:57:09.275', 'P', 1, 1);
INSERT INTO research VALUES (337, '2014-08-10 19:57:09.441', '2014-08-10 19:57:09.425', '2014-08-10 19:57:09.441', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-08-10 19:57:09.426', 'O', 1, 1);
INSERT INTO research VALUES (429, '2014-08-10 19:57:10.741', '2014-08-10 19:57:10.735', '2014-08-10 19:57:10.741', 'New QuizEuropean general knowledge quiz started', '2014-08-10 19:57:10.735', 'P', 1, 1);
INSERT INTO research VALUES (446, '2014-08-10 19:57:10.841', '2014-08-10 19:57:10.837', '2014-08-10 19:57:10.841', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-08-10 19:57:10.837', 'O', 1, 1);
INSERT INTO research VALUES (482, '2014-08-10 19:57:11.28', '2014-08-10 19:57:11.275', '2014-08-10 19:57:11.28', 'New customer satisfation survey Food Quality QuestionnairDefinition started', '2014-08-10 19:57:11.275', 'O', 1, 1);


--
-- TOC entry 2202 (class 0 OID 83542)
-- Dependencies: 178
-- Data for Name: questionnair; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair VALUES (103, 1, '2014-08-10 19:57:05.9', '2014-08-10 19:57:05.9', 'C', NULL, 1, 1, 12, 102, 6);
INSERT INTO questionnair VALUES (107, 2, '2014-08-10 19:57:06.049', '2014-08-10 19:57:06.049', 'C', NULL, 1, 1, 12, 102, 4);
INSERT INTO questionnair VALUES (111, 3, '2014-08-10 19:57:06.1', '2014-08-10 19:57:06.1', 'C', NULL, 1, 1, 12, 102, 10);
INSERT INTO questionnair VALUES (115, 4, '2014-08-10 19:57:06.159', '2014-08-10 19:57:06.159', 'C', NULL, 1, 1, 12, 102, 8);
INSERT INTO questionnair VALUES (212, 1, '2014-08-10 19:57:07.901', '2014-08-10 19:57:07.901', 'C', NULL, 1, 1, 121, 211, 6);
INSERT INTO questionnair VALUES (216, 2, '2014-08-10 19:57:07.932', '2014-08-10 19:57:07.932', 'C', NULL, 1, 1, 121, 211, 4);
INSERT INTO questionnair VALUES (220, 3, '2014-08-10 19:57:07.959', '2014-08-10 19:57:07.959', 'C', NULL, 1, 1, 121, 211, 10);
INSERT INTO questionnair VALUES (224, 4, '2014-08-10 19:57:07.985', '2014-08-10 19:57:07.985', 'C', NULL, 1, 1, 121, 211, 8);
INSERT INTO questionnair VALUES (321, 1, '2014-08-10 19:57:09.31', '2014-08-10 19:57:09.31', 'C', NULL, 1, 1, 230, 320, 6);
INSERT INTO questionnair VALUES (325, 2, '2014-08-10 19:57:09.343', '2014-08-10 19:57:09.343', 'C', NULL, 1, 1, 230, 320, 4);
INSERT INTO questionnair VALUES (329, 3, '2014-08-10 19:57:09.366', '2014-08-10 19:57:09.366', 'C', NULL, 1, 1, 230, 320, 10);
INSERT INTO questionnair VALUES (333, 4, '2014-08-10 19:57:09.39', '2014-08-10 19:57:09.39', 'C', NULL, 1, 1, 230, 320, 8);
INSERT INTO questionnair VALUES (430, 1, '2014-08-10 19:57:10.758', '2014-08-10 19:57:10.758', 'C', NULL, 1, 1, 339, 429, 6);
INSERT INTO questionnair VALUES (434, 2, '2014-08-10 19:57:10.787', '2014-08-10 19:57:10.787', 'C', NULL, 1, 1, 339, 429, 4);
INSERT INTO questionnair VALUES (438, 3, '2014-08-10 19:57:10.805', '2014-08-10 19:57:10.805', 'C', NULL, 1, 1, 339, 429, 10);
INSERT INTO questionnair VALUES (442, 4, '2014-08-10 19:57:10.822', '2014-08-10 19:57:10.822', 'C', NULL, 1, 1, 339, 429, 8);


--
-- TOC entry 2195 (class 0 OID 83489)
-- Dependencies: 171
-- Data for Name: breadcrumb; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2212 (class 0 OID 83619)
-- Dependencies: 188
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO groups VALUES (3, '2014-08-10 19:57:02.952', 'Respondent group', '2014-08-10 19:57:02.952', 'Respondents', 1, 1);


--
-- TOC entry 2216 (class 0 OID 83654)
-- Dependencies: 192
-- Data for Name: group_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2194 (class 0 OID 83481)
-- Dependencies: 170
-- Data for Name: invitation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO invitation VALUES (105, 'P', 'A', 'VCXFLDZCPX', 102, NULL, 6);
INSERT INTO invitation VALUES (109, 'P', 'A', '3W88CUDBVP', 102, NULL, 4);
INSERT INTO invitation VALUES (113, 'P', 'A', 'GN2TATTGX5', 102, NULL, 10);
INSERT INTO invitation VALUES (117, 'P', 'A', '2F2W38TNVH', 102, NULL, 8);
INSERT INTO invitation VALUES (120, 'A', 'A', 'WR526EN4BZ', 119, 12, NULL);
INSERT INTO invitation VALUES (214, 'P', 'A', '3V8HRMB9XJ', 211, NULL, 6);
INSERT INTO invitation VALUES (218, 'P', 'A', 'V7SEHCHLGN', 211, NULL, 4);
INSERT INTO invitation VALUES (222, 'P', 'A', '2YGHEP3WF5', 211, NULL, 10);
INSERT INTO invitation VALUES (226, 'P', 'A', '66AHPBNBTB', 211, NULL, 8);
INSERT INTO invitation VALUES (229, 'A', 'A', 'A6WQEVMYHB', 228, 121, NULL);
INSERT INTO invitation VALUES (323, 'P', 'A', 'E84SWJCQY8', 320, NULL, 6);
INSERT INTO invitation VALUES (327, 'P', 'A', 'JB75SMGXZJ', 320, NULL, 4);
INSERT INTO invitation VALUES (331, 'P', 'A', 'JV9H6GZWGW', 320, NULL, 10);
INSERT INTO invitation VALUES (335, 'P', 'A', 'H563NDZ9YY', 320, NULL, 8);
INSERT INTO invitation VALUES (338, 'A', 'A', 'E9QJAWUCCT', 337, 230, NULL);
INSERT INTO invitation VALUES (432, 'P', 'A', 'T9CG75FZWL', 429, NULL, 6);
INSERT INTO invitation VALUES (436, 'P', 'A', 'R63K6GVPRX', 429, NULL, 4);
INSERT INTO invitation VALUES (440, 'P', 'A', '5MS85TX59G', 429, NULL, 10);
INSERT INTO invitation VALUES (444, 'P', 'A', '983PMEAELA', 429, NULL, 8);
INSERT INTO invitation VALUES (447, 'A', 'A', 'CSJMV89CXQ', 446, 339, NULL);
INSERT INTO invitation VALUES (483, 'A', 'A', 'JLLGA4JWZ6', 482, 448, NULL);


--
-- TOC entry 2197 (class 0 OID 83502)
-- Dependencies: 173
-- Data for Name: label_set; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2196 (class 0 OID 83494)
-- Dependencies: 172
-- Data for Name: label; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2206 (class 0 OID 83571)
-- Dependencies: 182
-- Data for Name: label_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2198 (class 0 OID 83510)
-- Dependencies: 174
-- Data for Name: mail_message; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message VALUES (106, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=VCXFLDZCPX">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message VALUES (110, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=3W88CUDBVP">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message VALUES (114, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=GN2TATTGX5">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message VALUES (118, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=2F2W38TNVH">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'arya.stark@winterfell.net');
INSERT INTO mail_message VALUES (215, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=3V8HRMB9XJ">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message VALUES (219, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=V7SEHCHLGN">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message VALUES (223, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=2YGHEP3WF5">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message VALUES (227, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=66AHPBNBTB">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'arya.stark@winterfell.net');
INSERT INTO mail_message VALUES (324, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=E84SWJCQY8">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message VALUES (328, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=JB75SMGXZJ">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message VALUES (332, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=JV9H6GZWGW">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message VALUES (336, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=H563NDZ9YY">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'arya.stark@winterfell.net');
INSERT INTO mail_message VALUES (433, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=T9CG75FZWL">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message VALUES (437, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=R63K6GVPRX">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message VALUES (441, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=5MS85TX59G">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message VALUES (445, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=983PMEAELA">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'arya.stark@winterfell.net');


--
-- TOC entry 2199 (class 0 OID 83518)
-- Dependencies: 175
-- Data for Name: mail_message_template; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template VALUES (100, '2014-08-10 19:57:05.424', 'support@gazpacho.net', 'EN', '2014-08-10 19:57:05.424', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'Invitation to participate in a questionnair', 1, 1, 12);
INSERT INTO mail_message_template VALUES (209, '2014-08-10 19:57:07.763', 'support@gazpacho.net', 'EN', '2014-08-10 19:57:07.763', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'Invitation to participate in a questionnair', 1, 1, 121);
INSERT INTO mail_message_template VALUES (318, '2014-08-10 19:57:08.99', 'support@gazpacho.net', 'EN', '2014-08-10 19:57:08.99', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'Invitation to participate in a questionnair', 1, 1, 230);
INSERT INTO mail_message_template VALUES (427, '2014-08-10 19:57:10.245', 'support@gazpacho.net', 'EN', '2014-08-10 19:57:10.245', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'Invitation to participate in a questionnair', 1, 1, 339);
INSERT INTO mail_message_template VALUES (480, '2014-08-10 19:57:11.017', 'support@gazpacho.net', 'EN', '2014-08-10 19:57:11.017', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'Invitation to participate in a questionnair', 1, 1, 448);


--
-- TOC entry 2207 (class 0 OID 83579)
-- Dependencies: 183
-- Data for Name: mail_message_template_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template_translation VALUES (101, '2014-08-10 19:57:05.465', 'ES', '2014-08-10 19:57:05.465', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 100);
INSERT INTO mail_message_template_translation VALUES (210, '2014-08-10 19:57:07.772', 'ES', '2014-08-10 19:57:07.772', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 209);
INSERT INTO mail_message_template_translation VALUES (319, '2014-08-10 19:57:09.01', 'ES', '2014-08-10 19:57:09.01', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 318);
INSERT INTO mail_message_template_translation VALUES (428, '2014-08-10 19:57:10.251', 'ES', '2014-08-10 19:57:10.251', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 427);
INSERT INTO mail_message_template_translation VALUES (481, '2014-08-10 19:57:11.157', 'ES', '2014-08-10 19:57:11.157', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 480);


--
-- TOC entry 2213 (class 0 OID 83627)
-- Dependencies: 189
-- Data for Name: permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO permission VALUES (104, 103, 3, 'Q', 7);
INSERT INTO permission VALUES (108, 107, 3, 'Q', 5);
INSERT INTO permission VALUES (112, 111, 3, 'Q', 11);
INSERT INTO permission VALUES (116, 115, 3, 'Q', 9);
INSERT INTO permission VALUES (213, 212, 3, 'Q', 7);
INSERT INTO permission VALUES (217, 216, 3, 'Q', 5);
INSERT INTO permission VALUES (221, 220, 3, 'Q', 11);
INSERT INTO permission VALUES (225, 224, 3, 'Q', 9);
INSERT INTO permission VALUES (322, 321, 3, 'Q', 7);
INSERT INTO permission VALUES (326, 325, 3, 'Q', 5);
INSERT INTO permission VALUES (330, 329, 3, 'Q', 11);
INSERT INTO permission VALUES (334, 333, 3, 'Q', 9);
INSERT INTO permission VALUES (431, 430, 3, 'Q', 7);
INSERT INTO permission VALUES (435, 434, 3, 'Q', 5);
INSERT INTO permission VALUES (439, 438, 3, 'Q', 11);
INSERT INTO permission VALUES (443, 442, 3, 'Q', 9);


--
-- TOC entry 2208 (class 0 OID 83587)
-- Dependencies: 184
-- Data for Name: question_group_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_group_translation VALUES (15, 'ES', NULL, 'Capitales Europeas', 14);
INSERT INTO question_group_translation VALUES (17, 'ES', NULL, 'Unión Europea', 16);
INSERT INTO question_group_translation VALUES (19, 'ES', NULL, 'Sociedad', 18);
INSERT INTO question_group_translation VALUES (124, 'ES', NULL, 'Capitales Europeas', 123);
INSERT INTO question_group_translation VALUES (126, 'ES', NULL, 'Unión Europea', 125);
INSERT INTO question_group_translation VALUES (128, 'ES', NULL, 'Sociedad', 127);
INSERT INTO question_group_translation VALUES (233, 'ES', NULL, 'Capitales Europeas', 232);
INSERT INTO question_group_translation VALUES (235, 'ES', NULL, 'Unión Europea', 234);
INSERT INTO question_group_translation VALUES (237, 'ES', NULL, 'Sociedad', 236);
INSERT INTO question_group_translation VALUES (342, 'ES', NULL, 'Capitales Europeas', 341);
INSERT INTO question_group_translation VALUES (344, 'ES', NULL, 'Unión Europea', 343);
INSERT INTO question_group_translation VALUES (346, 'ES', NULL, 'Sociedad', 345);


--
-- TOC entry 2204 (class 0 OID 83555)
-- Dependencies: 180
-- Data for Name: question_option; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option VALUES (23, 'O1', '2014-08-10 19:57:03.712', 'EN', '2014-08-10 19:57:03.712', 'Norway', 1, 1, 22, 0);
INSERT INTO question_option VALUES (24, 'O2', '2014-08-10 19:57:03.717', 'EN', '2014-08-10 19:57:03.717', 'Sweden', 1, 1, 22, 1);
INSERT INTO question_option VALUES (25, 'O3', '2014-08-10 19:57:03.721', 'EN', '2014-08-10 19:57:03.721', 'Denmark', 1, 1, 22, 2);
INSERT INTO question_option VALUES (26, 'O4', '2014-08-10 19:57:03.725', 'EN', '2014-08-10 19:57:03.725', 'Iceland', 1, 1, 22, 3);
INSERT INTO question_option VALUES (35, 'O1', '2014-08-10 19:57:04.063', 'EN', '2014-08-10 19:57:04.063', 'Vatican City', 1, 1, 34, 0);
INSERT INTO question_option VALUES (36, 'O2', '2014-08-10 19:57:04.066', 'EN', '2014-08-10 19:57:04.066', 'Roma', 1, 1, 34, 1);
INSERT INTO question_option VALUES (37, 'O3', '2014-08-10 19:57:04.068', 'EN', '2014-08-10 19:57:04.068', 'Helsinki', 1, 1, 34, 2);
INSERT INTO question_option VALUES (38, 'O4', '2014-08-10 19:57:04.07', 'EN', '2014-08-10 19:57:04.07', 'Viena', 1, 1, 34, 3);
INSERT INTO question_option VALUES (47, 'O1', '2014-08-10 19:57:04.348', 'EN', '2014-08-10 19:57:04.348', 'Westphalia', 1, 1, 46, 0);
INSERT INTO question_option VALUES (48, 'O2', '2014-08-10 19:57:04.351', 'EN', '2014-08-10 19:57:04.351', 'Rome', 1, 1, 46, 1);
INSERT INTO question_option VALUES (49, 'O3', '2014-08-10 19:57:04.353', 'EN', '2014-08-10 19:57:04.353', 'Brussels', 1, 1, 46, 2);
INSERT INTO question_option VALUES (50, 'O4', '2014-08-10 19:57:04.355', 'EN', '2014-08-10 19:57:04.355', 'Versailles', 1, 1, 46, 3);
INSERT INTO question_option VALUES (57, 'O1', '2014-08-10 19:57:04.57', 'EN', '2014-08-10 19:57:04.57', 'Norway', 1, 1, 56, 0);
INSERT INTO question_option VALUES (58, 'O2', '2014-08-10 19:57:04.573', 'EN', '2014-08-10 19:57:04.573', 'Poland', 1, 1, 56, 1);
INSERT INTO question_option VALUES (59, 'O3', '2014-08-10 19:57:04.576', 'EN', '2014-08-10 19:57:04.576', 'Macedonia', 1, 1, 56, 2);
INSERT INTO question_option VALUES (60, 'O4', '2014-08-10 19:57:04.579', 'EN', '2014-08-10 19:57:04.579', 'Chipre', 1, 1, 56, 3);
INSERT INTO question_option VALUES (69, 'O1', '2014-08-10 19:57:04.862', 'EN', '2014-08-10 19:57:04.862', 'Barcelona', 1, 1, 68, 0);
INSERT INTO question_option VALUES (70, 'O2', '2014-08-10 19:57:04.864', 'EN', '2014-08-10 19:57:04.864', 'Lisboa', 1, 1, 68, 1);
INSERT INTO question_option VALUES (71, 'O3', '2014-08-10 19:57:04.866', 'EN', '2014-08-10 19:57:04.866', 'Genoa', 1, 1, 68, 2);
INSERT INTO question_option VALUES (72, 'O4', '2014-08-10 19:57:04.869', 'EN', '2014-08-10 19:57:04.869', 'Roma', 1, 1, 68, 3);
INSERT INTO question_option VALUES (79, 'O1', '2014-08-10 19:57:04.993', 'EN', '2014-08-10 19:57:04.993', 'Portuguese Empire', 1, 1, 78, 0);
INSERT INTO question_option VALUES (80, 'O2', '2014-08-10 19:57:04.995', 'EN', '2014-08-10 19:57:04.995', 'British Empire', 1, 1, 78, 1);
INSERT INTO question_option VALUES (81, 'O3', '2014-08-10 19:57:04.997', 'EN', '2014-08-10 19:57:04.997', 'Spanish Empire', 1, 1, 78, 2);
INSERT INTO question_option VALUES (82, 'O4', '2014-08-10 19:57:05', 'EN', '2014-08-10 19:57:05', 'Dutch Empire', 1, 1, 78, 3);
INSERT INTO question_option VALUES (91, 'O1', '2014-08-10 19:57:05.254', 'EN', '2014-08-10 19:57:05.254', 'Adolph Hitler', 1, 1, 90, 0);
INSERT INTO question_option VALUES (92, 'O2', '2014-08-10 19:57:05.256', 'EN', '2014-08-10 19:57:05.256', 'Napoleon', 1, 1, 90, 1);
INSERT INTO question_option VALUES (93, 'O3', '2014-08-10 19:57:05.258', 'EN', '2014-08-10 19:57:05.258', 'Philip 2th King of Spain', 1, 1, 90, 2);
INSERT INTO question_option VALUES (94, 'O4', '2014-08-10 19:57:05.26', 'EN', '2014-08-10 19:57:05.26', 'Julius Caesar', 1, 1, 90, 3);
INSERT INTO question_option VALUES (132, 'O1', '2014-08-10 19:57:06.516', 'EN', '2014-08-10 19:57:06.516', 'Norway', 1, 1, 131, 0);
INSERT INTO question_option VALUES (133, 'O2', '2014-08-10 19:57:06.517', 'EN', '2014-08-10 19:57:06.517', 'Sweden', 1, 1, 131, 1);
INSERT INTO question_option VALUES (134, 'O3', '2014-08-10 19:57:06.52', 'EN', '2014-08-10 19:57:06.52', 'Denmark', 1, 1, 131, 2);
INSERT INTO question_option VALUES (135, 'O4', '2014-08-10 19:57:06.522', 'EN', '2014-08-10 19:57:06.522', 'Iceland', 1, 1, 131, 3);
INSERT INTO question_option VALUES (144, 'O1', '2014-08-10 19:57:06.703', 'EN', '2014-08-10 19:57:06.703', 'Vatican City', 1, 1, 143, 0);
INSERT INTO question_option VALUES (145, 'O2', '2014-08-10 19:57:06.705', 'EN', '2014-08-10 19:57:06.705', 'Roma', 1, 1, 143, 1);
INSERT INTO question_option VALUES (146, 'O3', '2014-08-10 19:57:06.706', 'EN', '2014-08-10 19:57:06.706', 'Helsinki', 1, 1, 143, 2);
INSERT INTO question_option VALUES (147, 'O4', '2014-08-10 19:57:06.707', 'EN', '2014-08-10 19:57:06.707', 'Viena', 1, 1, 143, 3);
INSERT INTO question_option VALUES (156, 'O1', '2014-08-10 19:57:06.872', 'EN', '2014-08-10 19:57:06.872', 'Westphalia', 1, 1, 155, 0);
INSERT INTO question_option VALUES (157, 'O2', '2014-08-10 19:57:06.874', 'EN', '2014-08-10 19:57:06.874', 'Rome', 1, 1, 155, 1);
INSERT INTO question_option VALUES (158, 'O3', '2014-08-10 19:57:06.875', 'EN', '2014-08-10 19:57:06.875', 'Brussels', 1, 1, 155, 2);
INSERT INTO question_option VALUES (159, 'O4', '2014-08-10 19:57:06.876', 'EN', '2014-08-10 19:57:06.876', 'Versailles', 1, 1, 155, 3);
INSERT INTO question_option VALUES (166, 'O1', '2014-08-10 19:57:06.986', 'EN', '2014-08-10 19:57:06.986', 'Norway', 1, 1, 165, 0);
INSERT INTO question_option VALUES (167, 'O2', '2014-08-10 19:57:06.99', 'EN', '2014-08-10 19:57:06.99', 'Poland', 1, 1, 165, 1);
INSERT INTO question_option VALUES (168, 'O3', '2014-08-10 19:57:06.993', 'EN', '2014-08-10 19:57:06.993', 'Macedonia', 1, 1, 165, 2);
INSERT INTO question_option VALUES (169, 'O4', '2014-08-10 19:57:06.994', 'EN', '2014-08-10 19:57:06.994', 'Chipre', 1, 1, 165, 3);
INSERT INTO question_option VALUES (178, 'O1', '2014-08-10 19:57:07.261', 'EN', '2014-08-10 19:57:07.261', 'Barcelona', 1, 1, 177, 0);
INSERT INTO question_option VALUES (179, 'O2', '2014-08-10 19:57:07.262', 'EN', '2014-08-10 19:57:07.262', 'Lisboa', 1, 1, 177, 1);
INSERT INTO question_option VALUES (180, 'O3', '2014-08-10 19:57:07.264', 'EN', '2014-08-10 19:57:07.264', 'Genoa', 1, 1, 177, 2);
INSERT INTO question_option VALUES (181, 'O4', '2014-08-10 19:57:07.265', 'EN', '2014-08-10 19:57:07.265', 'Roma', 1, 1, 177, 3);
INSERT INTO question_option VALUES (188, 'O1', '2014-08-10 19:57:07.399', 'EN', '2014-08-10 19:57:07.399', 'Portuguese Empire', 1, 1, 187, 0);
INSERT INTO question_option VALUES (189, 'O2', '2014-08-10 19:57:07.4', 'EN', '2014-08-10 19:57:07.4', 'British Empire', 1, 1, 187, 1);
INSERT INTO question_option VALUES (190, 'O3', '2014-08-10 19:57:07.401', 'EN', '2014-08-10 19:57:07.401', 'Spanish Empire', 1, 1, 187, 2);
INSERT INTO question_option VALUES (191, 'O4', '2014-08-10 19:57:07.403', 'EN', '2014-08-10 19:57:07.403', 'Dutch Empire', 1, 1, 187, 3);
INSERT INTO question_option VALUES (200, 'O1', '2014-08-10 19:57:07.594', 'EN', '2014-08-10 19:57:07.594', 'Adolph Hitler', 1, 1, 199, 0);
INSERT INTO question_option VALUES (201, 'O2', '2014-08-10 19:57:07.604', 'EN', '2014-08-10 19:57:07.604', 'Napoleon', 1, 1, 199, 1);
INSERT INTO question_option VALUES (202, 'O3', '2014-08-10 19:57:07.606', 'EN', '2014-08-10 19:57:07.606', 'Philip 2th King of Spain', 1, 1, 199, 2);
INSERT INTO question_option VALUES (203, 'O4', '2014-08-10 19:57:07.607', 'EN', '2014-08-10 19:57:07.607', 'Julius Caesar', 1, 1, 199, 3);
INSERT INTO question_option VALUES (241, 'O1', '2014-08-10 19:57:08.228', 'EN', '2014-08-10 19:57:08.228', 'Norway', 1, 1, 240, 0);
INSERT INTO question_option VALUES (242, 'O2', '2014-08-10 19:57:08.229', 'EN', '2014-08-10 19:57:08.229', 'Sweden', 1, 1, 240, 1);
INSERT INTO question_option VALUES (243, 'O3', '2014-08-10 19:57:08.229', 'EN', '2014-08-10 19:57:08.229', 'Denmark', 1, 1, 240, 2);
INSERT INTO question_option VALUES (244, 'O4', '2014-08-10 19:57:08.23', 'EN', '2014-08-10 19:57:08.23', 'Iceland', 1, 1, 240, 3);
INSERT INTO question_option VALUES (253, 'O1', '2014-08-10 19:57:08.353', 'EN', '2014-08-10 19:57:08.353', 'Vatican City', 1, 1, 252, 0);
INSERT INTO question_option VALUES (254, 'O2', '2014-08-10 19:57:08.353', 'EN', '2014-08-10 19:57:08.353', 'Roma', 1, 1, 252, 1);
INSERT INTO question_option VALUES (255, 'O3', '2014-08-10 19:57:08.355', 'EN', '2014-08-10 19:57:08.355', 'Helsinki', 1, 1, 252, 2);
INSERT INTO question_option VALUES (256, 'O4', '2014-08-10 19:57:08.355', 'EN', '2014-08-10 19:57:08.355', 'Viena', 1, 1, 252, 3);
INSERT INTO question_option VALUES (265, 'O1', '2014-08-10 19:57:08.469', 'EN', '2014-08-10 19:57:08.469', 'Westphalia', 1, 1, 264, 0);
INSERT INTO question_option VALUES (266, 'O2', '2014-08-10 19:57:08.47', 'EN', '2014-08-10 19:57:08.47', 'Rome', 1, 1, 264, 1);
INSERT INTO question_option VALUES (267, 'O3', '2014-08-10 19:57:08.471', 'EN', '2014-08-10 19:57:08.471', 'Brussels', 1, 1, 264, 2);
INSERT INTO question_option VALUES (268, 'O4', '2014-08-10 19:57:08.472', 'EN', '2014-08-10 19:57:08.472', 'Versailles', 1, 1, 264, 3);
INSERT INTO question_option VALUES (275, 'O1', '2014-08-10 19:57:08.536', 'EN', '2014-08-10 19:57:08.536', 'Norway', 1, 1, 274, 0);
INSERT INTO question_option VALUES (276, 'O2', '2014-08-10 19:57:08.537', 'EN', '2014-08-10 19:57:08.537', 'Poland', 1, 1, 274, 1);
INSERT INTO question_option VALUES (277, 'O3', '2014-08-10 19:57:08.537', 'EN', '2014-08-10 19:57:08.537', 'Macedonia', 1, 1, 274, 2);
INSERT INTO question_option VALUES (278, 'O4', '2014-08-10 19:57:08.538', 'EN', '2014-08-10 19:57:08.538', 'Chipre', 1, 1, 274, 3);
INSERT INTO question_option VALUES (287, 'O1', '2014-08-10 19:57:08.668', 'EN', '2014-08-10 19:57:08.668', 'Barcelona', 1, 1, 286, 0);
INSERT INTO question_option VALUES (288, 'O2', '2014-08-10 19:57:08.669', 'EN', '2014-08-10 19:57:08.669', 'Lisboa', 1, 1, 286, 1);
INSERT INTO question_option VALUES (289, 'O3', '2014-08-10 19:57:08.67', 'EN', '2014-08-10 19:57:08.67', 'Genoa', 1, 1, 286, 2);
INSERT INTO question_option VALUES (290, 'O4', '2014-08-10 19:57:08.671', 'EN', '2014-08-10 19:57:08.671', 'Roma', 1, 1, 286, 3);
INSERT INTO question_option VALUES (297, 'O1', '2014-08-10 19:57:08.729', 'EN', '2014-08-10 19:57:08.729', 'Portuguese Empire', 1, 1, 296, 0);
INSERT INTO question_option VALUES (298, 'O2', '2014-08-10 19:57:08.73', 'EN', '2014-08-10 19:57:08.73', 'British Empire', 1, 1, 296, 1);
INSERT INTO question_option VALUES (299, 'O3', '2014-08-10 19:57:08.731', 'EN', '2014-08-10 19:57:08.731', 'Spanish Empire', 1, 1, 296, 2);
INSERT INTO question_option VALUES (300, 'O4', '2014-08-10 19:57:08.732', 'EN', '2014-08-10 19:57:08.732', 'Dutch Empire', 1, 1, 296, 3);
INSERT INTO question_option VALUES (309, 'O1', '2014-08-10 19:57:08.834', 'EN', '2014-08-10 19:57:08.834', 'Adolph Hitler', 1, 1, 308, 0);
INSERT INTO question_option VALUES (310, 'O2', '2014-08-10 19:57:08.835', 'EN', '2014-08-10 19:57:08.835', 'Napoleon', 1, 1, 308, 1);
INSERT INTO question_option VALUES (311, 'O3', '2014-08-10 19:57:08.836', 'EN', '2014-08-10 19:57:08.836', 'Philip 2th King of Spain', 1, 1, 308, 2);
INSERT INTO question_option VALUES (312, 'O4', '2014-08-10 19:57:08.837', 'EN', '2014-08-10 19:57:08.837', 'Julius Caesar', 1, 1, 308, 3);
INSERT INTO question_option VALUES (350, 'O1', '2014-08-10 19:57:09.587', 'EN', '2014-08-10 19:57:09.587', 'Norway', 1, 1, 349, 0);
INSERT INTO question_option VALUES (351, 'O2', '2014-08-10 19:57:09.591', 'EN', '2014-08-10 19:57:09.591', 'Sweden', 1, 1, 349, 1);
INSERT INTO question_option VALUES (352, 'O3', '2014-08-10 19:57:09.593', 'EN', '2014-08-10 19:57:09.593', 'Denmark', 1, 1, 349, 2);
INSERT INTO question_option VALUES (353, 'O4', '2014-08-10 19:57:09.594', 'EN', '2014-08-10 19:57:09.594', 'Iceland', 1, 1, 349, 3);
INSERT INTO question_option VALUES (362, 'O1', '2014-08-10 19:57:09.709', 'EN', '2014-08-10 19:57:09.709', 'Vatican City', 1, 1, 361, 0);
INSERT INTO question_option VALUES (363, 'O2', '2014-08-10 19:57:09.71', 'EN', '2014-08-10 19:57:09.71', 'Roma', 1, 1, 361, 1);
INSERT INTO question_option VALUES (364, 'O3', '2014-08-10 19:57:09.71', 'EN', '2014-08-10 19:57:09.71', 'Helsinki', 1, 1, 361, 2);
INSERT INTO question_option VALUES (365, 'O4', '2014-08-10 19:57:09.711', 'EN', '2014-08-10 19:57:09.711', 'Viena', 1, 1, 361, 3);
INSERT INTO question_option VALUES (374, 'O1', '2014-08-10 19:57:09.823', 'EN', '2014-08-10 19:57:09.823', 'Westphalia', 1, 1, 373, 0);
INSERT INTO question_option VALUES (375, 'O2', '2014-08-10 19:57:09.823', 'EN', '2014-08-10 19:57:09.823', 'Rome', 1, 1, 373, 1);
INSERT INTO question_option VALUES (376, 'O3', '2014-08-10 19:57:09.825', 'EN', '2014-08-10 19:57:09.825', 'Brussels', 1, 1, 373, 2);
INSERT INTO question_option VALUES (377, 'O4', '2014-08-10 19:57:09.826', 'EN', '2014-08-10 19:57:09.826', 'Versailles', 1, 1, 373, 3);
INSERT INTO question_option VALUES (384, 'O1', '2014-08-10 19:57:09.891', 'EN', '2014-08-10 19:57:09.891', 'Norway', 1, 1, 383, 0);
INSERT INTO question_option VALUES (385, 'O2', '2014-08-10 19:57:09.892', 'EN', '2014-08-10 19:57:09.892', 'Poland', 1, 1, 383, 1);
INSERT INTO question_option VALUES (386, 'O3', '2014-08-10 19:57:09.893', 'EN', '2014-08-10 19:57:09.893', 'Macedonia', 1, 1, 383, 2);
INSERT INTO question_option VALUES (387, 'O4', '2014-08-10 19:57:09.894', 'EN', '2014-08-10 19:57:09.894', 'Chipre', 1, 1, 383, 3);
INSERT INTO question_option VALUES (396, 'O1', '2014-08-10 19:57:09.981', 'EN', '2014-08-10 19:57:09.981', 'Barcelona', 1, 1, 395, 0);
INSERT INTO question_option VALUES (397, 'O2', '2014-08-10 19:57:09.982', 'EN', '2014-08-10 19:57:09.982', 'Lisboa', 1, 1, 395, 1);
INSERT INTO question_option VALUES (398, 'O3', '2014-08-10 19:57:09.983', 'EN', '2014-08-10 19:57:09.983', 'Genoa', 1, 1, 395, 2);
INSERT INTO question_option VALUES (399, 'O4', '2014-08-10 19:57:09.984', 'EN', '2014-08-10 19:57:09.984', 'Roma', 1, 1, 395, 3);
INSERT INTO question_option VALUES (406, 'O1', '2014-08-10 19:57:10.052', 'EN', '2014-08-10 19:57:10.052', 'Portuguese Empire', 1, 1, 405, 0);
INSERT INTO question_option VALUES (407, 'O2', '2014-08-10 19:57:10.053', 'EN', '2014-08-10 19:57:10.053', 'British Empire', 1, 1, 405, 1);
INSERT INTO question_option VALUES (408, 'O3', '2014-08-10 19:57:10.054', 'EN', '2014-08-10 19:57:10.054', 'Spanish Empire', 1, 1, 405, 2);
INSERT INTO question_option VALUES (409, 'O4', '2014-08-10 19:57:10.055', 'EN', '2014-08-10 19:57:10.055', 'Dutch Empire', 1, 1, 405, 3);
INSERT INTO question_option VALUES (418, 'O1', '2014-08-10 19:57:10.172', 'EN', '2014-08-10 19:57:10.172', 'Adolph Hitler', 1, 1, 417, 0);
INSERT INTO question_option VALUES (419, 'O2', '2014-08-10 19:57:10.172', 'EN', '2014-08-10 19:57:10.172', 'Napoleon', 1, 1, 417, 1);
INSERT INTO question_option VALUES (420, 'O3', '2014-08-10 19:57:10.173', 'EN', '2014-08-10 19:57:10.173', 'Philip 2th King of Spain', 1, 1, 417, 2);
INSERT INTO question_option VALUES (421, 'O4', '2014-08-10 19:57:10.173', 'EN', '2014-08-10 19:57:10.173', 'Julius Caesar', 1, 1, 417, 3);
INSERT INTO question_option VALUES (451, 'O1', '2014-08-10 19:57:10.891', 'EN', '2014-08-10 19:57:10.891', 'Agree strongly', 1, 1, 450, 0);
INSERT INTO question_option VALUES (452, 'O2', '2014-08-10 19:57:10.891', 'EN', '2014-08-10 19:57:10.891', 'Agree somewhat', 1, 1, 450, 1);
INSERT INTO question_option VALUES (453, 'O3', '2014-08-10 19:57:10.892', 'EN', '2014-08-10 19:57:10.892', 'Neither agree nor disagree', 1, 1, 450, 2);
INSERT INTO question_option VALUES (454, 'O4', '2014-08-10 19:57:10.892', 'EN', '2014-08-10 19:57:10.892', 'Disagree somewhat', 1, 1, 450, 3);
INSERT INTO question_option VALUES (455, 'O5', '2014-08-10 19:57:10.893', 'EN', '2014-08-10 19:57:10.893', 'Agree strongly', 1, 1, 450, 4);
INSERT INTO question_option VALUES (456, 'O6', '2014-08-10 19:57:10.894', 'EN', '2014-08-10 19:57:10.894', 'Disagree strongly', 1, 1, 450, 5);
INSERT INTO question_option VALUES (462, 'O1', '2014-08-10 19:57:10.935', 'EN', '2014-08-10 19:57:10.935', 'Agree strongly', 1, 1, 461, 0);
INSERT INTO question_option VALUES (463, 'O2', '2014-08-10 19:57:10.935', 'EN', '2014-08-10 19:57:10.935', 'Agree somewhat', 1, 1, 461, 1);
INSERT INTO question_option VALUES (464, 'O3', '2014-08-10 19:57:10.936', 'EN', '2014-08-10 19:57:10.936', 'Neither agree nor disagree', 1, 1, 461, 2);
INSERT INTO question_option VALUES (465, 'O4', '2014-08-10 19:57:10.937', 'EN', '2014-08-10 19:57:10.937', 'Disagree somewhat', 1, 1, 461, 3);
INSERT INTO question_option VALUES (466, 'O5', '2014-08-10 19:57:10.937', 'EN', '2014-08-10 19:57:10.937', 'Agree strongly', 1, 1, 461, 4);
INSERT INTO question_option VALUES (467, 'O6', '2014-08-10 19:57:10.938', 'EN', '2014-08-10 19:57:10.938', 'Disagree strongly', 1, 1, 461, 5);
INSERT INTO question_option VALUES (475, 'O1', '2014-08-10 19:57:10.981', 'EN', '2014-08-10 19:57:10.981', 'under 25,000€', 1, 1, 474, 0);
INSERT INTO question_option VALUES (476, 'O2', '2014-08-10 19:57:10.981', 'EN', '2014-08-10 19:57:10.981', '25,000 - 29,999€', 1, 1, 474, 1);
INSERT INTO question_option VALUES (477, 'O3', '2014-08-10 19:57:10.982', 'EN', '2014-08-10 19:57:10.982', '30,000 - 34,999€', 1, 1, 474, 2);
INSERT INTO question_option VALUES (478, 'O4', '2014-08-10 19:57:10.982', 'EN', '2014-08-10 19:57:10.982', '35,000 - 39,999€', 1, 1, 474, 3);
INSERT INTO question_option VALUES (479, 'O5', '2014-08-10 19:57:10.983', 'EN', '2014-08-10 19:57:10.983', 'Over 85,000€', 1, 1, 474, 4);


--
-- TOC entry 2210 (class 0 OID 83603)
-- Dependencies: 186
-- Data for Name: question_option_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option_translation VALUES (28, 'ES', 'Noruega', 23);
INSERT INTO question_option_translation VALUES (29, 'ES', 'Suecia', 24);
INSERT INTO question_option_translation VALUES (30, 'ES', 'Dinamarca', 25);
INSERT INTO question_option_translation VALUES (31, 'ES', 'Islandia', 26);
INSERT INTO question_option_translation VALUES (40, 'ES', 'Ciudad del Vaticano', 35);
INSERT INTO question_option_translation VALUES (41, 'ES', 'Roma', 36);
INSERT INTO question_option_translation VALUES (42, 'ES', 'Helsinki', 37);
INSERT INTO question_option_translation VALUES (43, 'ES', 'Viena', 38);
INSERT INTO question_option_translation VALUES (52, 'ES', 'Westphalia', 47);
INSERT INTO question_option_translation VALUES (53, 'ES', 'Roma', 48);
INSERT INTO question_option_translation VALUES (54, 'ES', 'Bruselas', 49);
INSERT INTO question_option_translation VALUES (55, 'ES', 'Islandia', 50);
INSERT INTO question_option_translation VALUES (62, 'ES', 'Noruega', 57);
INSERT INTO question_option_translation VALUES (63, 'ES', 'Polonia', 58);
INSERT INTO question_option_translation VALUES (64, 'ES', 'Macedonia', 59);
INSERT INTO question_option_translation VALUES (65, 'ES', 'Chipre', 60);
INSERT INTO question_option_translation VALUES (74, 'ES', 'Barcelona', 69);
INSERT INTO question_option_translation VALUES (75, 'ES', 'Lisboa', 70);
INSERT INTO question_option_translation VALUES (76, 'ES', 'Genova', 71);
INSERT INTO question_option_translation VALUES (77, 'ES', 'Roma', 72);
INSERT INTO question_option_translation VALUES (84, 'ES', 'Imperio Portugues', 79);
INSERT INTO question_option_translation VALUES (85, 'ES', 'Imperio Británico', 80);
INSERT INTO question_option_translation VALUES (86, 'ES', 'Imperio Español', 81);
INSERT INTO question_option_translation VALUES (87, 'ES', 'Imperio Holandés', 82);
INSERT INTO question_option_translation VALUES (96, 'ES', 'Adolfo Hitler', 91);
INSERT INTO question_option_translation VALUES (97, 'ES', 'Napoleón', 92);
INSERT INTO question_option_translation VALUES (98, 'ES', 'Felipe II', 93);
INSERT INTO question_option_translation VALUES (99, 'ES', 'Julio Cesar', 94);
INSERT INTO question_option_translation VALUES (137, 'ES', 'Noruega', 132);
INSERT INTO question_option_translation VALUES (138, 'ES', 'Suecia', 133);
INSERT INTO question_option_translation VALUES (139, 'ES', 'Dinamarca', 134);
INSERT INTO question_option_translation VALUES (140, 'ES', 'Islandia', 135);
INSERT INTO question_option_translation VALUES (149, 'ES', 'Ciudad del Vaticano', 144);
INSERT INTO question_option_translation VALUES (150, 'ES', 'Roma', 145);
INSERT INTO question_option_translation VALUES (151, 'ES', 'Helsinki', 146);
INSERT INTO question_option_translation VALUES (152, 'ES', 'Viena', 147);
INSERT INTO question_option_translation VALUES (161, 'ES', 'Westphalia', 156);
INSERT INTO question_option_translation VALUES (162, 'ES', 'Roma', 157);
INSERT INTO question_option_translation VALUES (163, 'ES', 'Bruselas', 158);
INSERT INTO question_option_translation VALUES (164, 'ES', 'Islandia', 159);
INSERT INTO question_option_translation VALUES (171, 'ES', 'Noruega', 166);
INSERT INTO question_option_translation VALUES (172, 'ES', 'Polonia', 167);
INSERT INTO question_option_translation VALUES (173, 'ES', 'Macedonia', 168);
INSERT INTO question_option_translation VALUES (174, 'ES', 'Chipre', 169);
INSERT INTO question_option_translation VALUES (183, 'ES', 'Barcelona', 178);
INSERT INTO question_option_translation VALUES (184, 'ES', 'Lisboa', 179);
INSERT INTO question_option_translation VALUES (185, 'ES', 'Genova', 180);
INSERT INTO question_option_translation VALUES (186, 'ES', 'Roma', 181);
INSERT INTO question_option_translation VALUES (193, 'ES', 'Imperio Portugues', 188);
INSERT INTO question_option_translation VALUES (194, 'ES', 'Imperio Británico', 189);
INSERT INTO question_option_translation VALUES (195, 'ES', 'Imperio Español', 190);
INSERT INTO question_option_translation VALUES (196, 'ES', 'Imperio Holandés', 191);
INSERT INTO question_option_translation VALUES (205, 'ES', 'Adolfo Hitler', 200);
INSERT INTO question_option_translation VALUES (206, 'ES', 'Napoleón', 201);
INSERT INTO question_option_translation VALUES (207, 'ES', 'Felipe II', 202);
INSERT INTO question_option_translation VALUES (208, 'ES', 'Julio Cesar', 203);
INSERT INTO question_option_translation VALUES (246, 'ES', 'Noruega', 241);
INSERT INTO question_option_translation VALUES (247, 'ES', 'Suecia', 242);
INSERT INTO question_option_translation VALUES (248, 'ES', 'Dinamarca', 243);
INSERT INTO question_option_translation VALUES (249, 'ES', 'Islandia', 244);
INSERT INTO question_option_translation VALUES (258, 'ES', 'Ciudad del Vaticano', 253);
INSERT INTO question_option_translation VALUES (259, 'ES', 'Roma', 254);
INSERT INTO question_option_translation VALUES (260, 'ES', 'Helsinki', 255);
INSERT INTO question_option_translation VALUES (261, 'ES', 'Viena', 256);
INSERT INTO question_option_translation VALUES (270, 'ES', 'Westphalia', 265);
INSERT INTO question_option_translation VALUES (271, 'ES', 'Roma', 266);
INSERT INTO question_option_translation VALUES (272, 'ES', 'Bruselas', 267);
INSERT INTO question_option_translation VALUES (273, 'ES', 'Islandia', 268);
INSERT INTO question_option_translation VALUES (280, 'ES', 'Noruega', 275);
INSERT INTO question_option_translation VALUES (281, 'ES', 'Polonia', 276);
INSERT INTO question_option_translation VALUES (282, 'ES', 'Macedonia', 277);
INSERT INTO question_option_translation VALUES (283, 'ES', 'Chipre', 278);
INSERT INTO question_option_translation VALUES (292, 'ES', 'Barcelona', 287);
INSERT INTO question_option_translation VALUES (293, 'ES', 'Lisboa', 288);
INSERT INTO question_option_translation VALUES (294, 'ES', 'Genova', 289);
INSERT INTO question_option_translation VALUES (295, 'ES', 'Roma', 290);
INSERT INTO question_option_translation VALUES (302, 'ES', 'Imperio Portugues', 297);
INSERT INTO question_option_translation VALUES (303, 'ES', 'Imperio Británico', 298);
INSERT INTO question_option_translation VALUES (304, 'ES', 'Imperio Español', 299);
INSERT INTO question_option_translation VALUES (305, 'ES', 'Imperio Holandés', 300);
INSERT INTO question_option_translation VALUES (314, 'ES', 'Adolfo Hitler', 309);
INSERT INTO question_option_translation VALUES (315, 'ES', 'Napoleón', 310);
INSERT INTO question_option_translation VALUES (316, 'ES', 'Felipe II', 311);
INSERT INTO question_option_translation VALUES (317, 'ES', 'Julio Cesar', 312);
INSERT INTO question_option_translation VALUES (355, 'ES', 'Noruega', 350);
INSERT INTO question_option_translation VALUES (356, 'ES', 'Suecia', 351);
INSERT INTO question_option_translation VALUES (357, 'ES', 'Dinamarca', 352);
INSERT INTO question_option_translation VALUES (358, 'ES', 'Islandia', 353);
INSERT INTO question_option_translation VALUES (367, 'ES', 'Ciudad del Vaticano', 362);
INSERT INTO question_option_translation VALUES (368, 'ES', 'Roma', 363);
INSERT INTO question_option_translation VALUES (369, 'ES', 'Helsinki', 364);
INSERT INTO question_option_translation VALUES (370, 'ES', 'Viena', 365);
INSERT INTO question_option_translation VALUES (379, 'ES', 'Westphalia', 374);
INSERT INTO question_option_translation VALUES (380, 'ES', 'Roma', 375);
INSERT INTO question_option_translation VALUES (381, 'ES', 'Bruselas', 376);
INSERT INTO question_option_translation VALUES (382, 'ES', 'Islandia', 377);
INSERT INTO question_option_translation VALUES (389, 'ES', 'Noruega', 384);
INSERT INTO question_option_translation VALUES (390, 'ES', 'Polonia', 385);
INSERT INTO question_option_translation VALUES (391, 'ES', 'Macedonia', 386);
INSERT INTO question_option_translation VALUES (392, 'ES', 'Chipre', 387);
INSERT INTO question_option_translation VALUES (401, 'ES', 'Barcelona', 396);
INSERT INTO question_option_translation VALUES (402, 'ES', 'Lisboa', 397);
INSERT INTO question_option_translation VALUES (403, 'ES', 'Genova', 398);
INSERT INTO question_option_translation VALUES (404, 'ES', 'Roma', 399);
INSERT INTO question_option_translation VALUES (411, 'ES', 'Imperio Portugues', 406);
INSERT INTO question_option_translation VALUES (412, 'ES', 'Imperio Británico', 407);
INSERT INTO question_option_translation VALUES (413, 'ES', 'Imperio Español', 408);
INSERT INTO question_option_translation VALUES (414, 'ES', 'Imperio Holandés', 409);
INSERT INTO question_option_translation VALUES (423, 'ES', 'Adolfo Hitler', 418);
INSERT INTO question_option_translation VALUES (424, 'ES', 'Napoleón', 419);
INSERT INTO question_option_translation VALUES (425, 'ES', 'Felipe II', 420);
INSERT INTO question_option_translation VALUES (426, 'ES', 'Julio Cesar', 421);


--
-- TOC entry 2211 (class 0 OID 83611)
-- Dependencies: 187
-- Data for Name: question_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_translation VALUES (21, 'ES', NULL, '¿Cuál es la capital de Malta?', 20);
INSERT INTO question_translation VALUES (27, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 22);
INSERT INTO question_translation VALUES (33, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 32);
INSERT INTO question_translation VALUES (39, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 34);
INSERT INTO question_translation VALUES (45, 'ES', NULL, '¿Que significa UE?', 44);
INSERT INTO question_translation VALUES (51, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 46);
INSERT INTO question_translation VALUES (61, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 56);
INSERT INTO question_translation VALUES (67, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 66);
INSERT INTO question_translation VALUES (73, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 68);
INSERT INTO question_translation VALUES (83, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 78);
INSERT INTO question_translation VALUES (89, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 88);
INSERT INTO question_translation VALUES (95, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 90);
INSERT INTO question_translation VALUES (130, 'ES', NULL, '¿Cuál es la capital de Malta?', 129);
INSERT INTO question_translation VALUES (136, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 131);
INSERT INTO question_translation VALUES (142, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 141);
INSERT INTO question_translation VALUES (148, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 143);
INSERT INTO question_translation VALUES (154, 'ES', NULL, '¿Que significa UE?', 153);
INSERT INTO question_translation VALUES (160, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 155);
INSERT INTO question_translation VALUES (170, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 165);
INSERT INTO question_translation VALUES (176, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 175);
INSERT INTO question_translation VALUES (182, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 177);
INSERT INTO question_translation VALUES (192, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 187);
INSERT INTO question_translation VALUES (198, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 197);
INSERT INTO question_translation VALUES (204, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 199);
INSERT INTO question_translation VALUES (239, 'ES', NULL, '¿Cuál es la capital de Malta?', 238);
INSERT INTO question_translation VALUES (245, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 240);
INSERT INTO question_translation VALUES (251, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 250);
INSERT INTO question_translation VALUES (257, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 252);
INSERT INTO question_translation VALUES (263, 'ES', NULL, '¿Que significa UE?', 262);
INSERT INTO question_translation VALUES (269, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 264);
INSERT INTO question_translation VALUES (279, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 274);
INSERT INTO question_translation VALUES (285, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 284);
INSERT INTO question_translation VALUES (291, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 286);
INSERT INTO question_translation VALUES (301, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 296);
INSERT INTO question_translation VALUES (307, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 306);
INSERT INTO question_translation VALUES (313, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 308);
INSERT INTO question_translation VALUES (348, 'ES', NULL, '¿Cuál es la capital de Malta?', 347);
INSERT INTO question_translation VALUES (354, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 349);
INSERT INTO question_translation VALUES (360, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 359);
INSERT INTO question_translation VALUES (366, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 361);
INSERT INTO question_translation VALUES (372, 'ES', NULL, '¿Que significa UE?', 371);
INSERT INTO question_translation VALUES (378, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 373);
INSERT INTO question_translation VALUES (388, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 383);
INSERT INTO question_translation VALUES (394, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 393);
INSERT INTO question_translation VALUES (400, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 395);
INSERT INTO question_translation VALUES (410, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 405);
INSERT INTO question_translation VALUES (416, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 415);
INSERT INTO question_translation VALUES (422, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 417);


--
-- TOC entry 2220 (class 0 OID 83944)
-- Dependencies: 196
-- Data for Name: questionnair_answers_12; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_answers_12 VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_12 VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_12 VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_12 VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2221 (class 0 OID 83952)
-- Dependencies: 197
-- Data for Name: questionnair_answers_121; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_answers_121 VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_121 VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_121 VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_121 VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2222 (class 0 OID 83960)
-- Dependencies: 198
-- Data for Name: questionnair_answers_230; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_answers_230 VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_230 VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_230 VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_230 VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2223 (class 0 OID 83968)
-- Dependencies: 199
-- Data for Name: questionnair_answers_339; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_answers_339 VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_339 VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_339 VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_339 VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2224 (class 0 OID 83976)
-- Dependencies: 200
-- Data for Name: questionnair_answers_448; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2209 (class 0 OID 83595)
-- Dependencies: 185
-- Data for Name: questionnair_definition_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition_translation VALUES (13, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 12);
INSERT INTO questionnair_definition_translation VALUES (122, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 121);
INSERT INTO questionnair_definition_translation VALUES (231, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 230);
INSERT INTO questionnair_definition_translation VALUES (340, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 339);


--
-- TOC entry 2219 (class 0 OID 83939)
-- Dependencies: 195
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sequence VALUES ('questionnair_answers_12_seq', 50);
INSERT INTO sequence VALUES ('questionnair_answers_121_seq', 50);
INSERT INTO sequence VALUES ('questionnair_answers_230_seq', 50);
INSERT INTO sequence VALUES ('questionnair_answers_339_seq', 50);
INSERT INTO sequence VALUES ('SEQ_GEN', 500);
INSERT INTO sequence VALUES ('questionnair_answers_448_seq', 0);


--
-- TOC entry 2217 (class 0 OID 83659)
-- Dependencies: 193
-- Data for Name: user_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_group VALUES (3, 6);
INSERT INTO user_group VALUES (3, 4);
INSERT INTO user_group VALUES (3, 10);
INSERT INTO user_group VALUES (3, 8);


--
-- TOC entry 2218 (class 0 OID 83664)
-- Dependencies: 194
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_role VALUES (2, 1);
INSERT INTO user_role VALUES (5, 4);
INSERT INTO user_role VALUES (7, 6);
INSERT INTO user_role VALUES (9, 8);
INSERT INTO user_role VALUES (11, 10);


-- Completed on 2014-08-10 19:57:59

--
-- PostgreSQL database dump complete
--

