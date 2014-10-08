--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2014-10-08 16:57:14


INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (1, '3Q2JBVEASJY2SC6', NULL, '2014-09-25 16:28:39.592', 'support@gazpacho.net', NULL, 'support', '2014-09-25 16:28:39.592', NULL, NULL, 'XFQRMVGKR8R328TJ78E688J9MB8D6HS4', 'support', 'support', 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (4, 'E3QGN7V5W88GZJL', NULL, '2014-09-25 16:28:39.67', 'tyrion.lannister@kingslanding.net', 'M', 'Tyrion', '2014-09-25 16:28:39.67', NULL, NULL, 'Z8W4QC6T2665Q7VSDEV9GKWBAKUP46FM', 'Lannister', NULL, 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (6, 'M4HSHY4T9YQMNCA', NULL, '2014-09-25 16:28:39.686', 'jon.snow@nightswatch.net', 'M', 'Jon', '2014-09-25 16:28:39.686', NULL, 'ES', 'M2QA8R35VPWS9UQAXKLVBH7VKMECPFT6', 'Snow', NULL, 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (8, '8KKZRZDD4BMAS8P', NULL, '2014-09-25 16:28:39.702', 'arya.stark@winterfell.net', 'F', 'Arya', '2014-09-25 16:28:39.702', NULL, 'EN', 'RQFVVJ8SFU6FK5HYN68J23VYBC26Q975', 'Stark', NULL, 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (10, 'GMKLCL9NZJYMNZG', NULL, '2014-09-25 16:28:39.702', 'catelyn.stark@winterfell.net', 'F', 'Catelyn', '2014-09-25 16:28:39.702', NULL, 'FI', 'MXGVSBCRV8SBZNN29UF6BZEKYQPRU879', 'Stark', NULL, 1, NULL, 1);


--
-- TOC entry 2250 (class 0 OID 90283)
-- Dependencies: 179
-- Data for Name: questionnaire_definition; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_number_visible, questions_per_page, randomization_strategy, rendering_mode, section_info_visible, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (12, '2014-10-08 16:55:14.375', 'EN', '2014-10-08 16:55:14.375', true, true, NULL, 'N', 'SBS', true, 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_number_visible, questions_per_page, randomization_strategy, rendering_mode, section_info_visible, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (121, '2014-10-08 16:55:16.312', 'EN', '2014-10-08 16:55:16.312', true, true, NULL, 'N', 'AIO', true, 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_number_visible, questions_per_page, randomization_strategy, rendering_mode, section_info_visible, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (215, '2014-10-08 16:55:17.88', 'EN', '2014-10-08 16:55:17.88', true, true, 1, 'Q', 'SBS', true, 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_number_visible, questions_per_page, randomization_strategy, rendering_mode, section_info_visible, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (324, '2014-10-08 16:55:20.333', 'EN', '2014-10-08 16:55:20.333', true, true, NULL, 'S', 'SBS', true, 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_number_visible, questions_per_page, randomization_strategy, rendering_mode, section_info_visible, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (433, '2014-10-08 16:55:22.36', 'EN', '2014-10-08 16:55:22.36', true, true, NULL, 'N', 'SBS', true, 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_number_visible, questions_per_page, randomization_strategy, rendering_mode, section_info_visible, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (542, '2014-10-08 16:55:23.831', 'EN', '2014-10-08 16:55:23.831', true, true, NULL, 'N', 'SBS', true, 'C', true, 'We at BIG DEES take pride in providing you with the highest standards of QUALITY, SERVICE, CLEANLINESS and VALUE in the restaurant industry.', NULL, 'Food Quality QuestionnaireDefinition', 'Your opinion is extremely important in evaluating our business. Thank you for taking a moment to questionOption the following questions:', 1, 1);


--
-- TOC entry 2253 (class 0 OID 90307)
-- Dependencies: 182
-- Data for Name: section; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (15, '2014-10-08 16:55:14.491', 'EN', '2014-10-08 16:55:14.491', false, NULL, 'European Capitals', 1, 1, 12, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (17, '2014-10-08 16:55:14.549', 'EN', '2014-10-08 16:55:14.549', false, NULL, 'European Union', 1, 1, 12, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (19, '2014-10-08 16:55:14.6', 'EN', '2014-10-08 16:55:14.6', false, NULL, 'European History', 1, 1, 12, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (124, '2014-10-08 16:55:16.346', 'EN', '2014-10-08 16:55:16.346', false, NULL, 'European Capitals', 1, 1, 121, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (126, '2014-10-08 16:55:16.4', 'EN', '2014-10-08 16:55:16.4', false, NULL, 'European Union', 1, 1, 121, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (128, '2014-10-08 16:55:16.433', 'EN', '2014-10-08 16:55:16.433', false, NULL, 'European History', 1, 1, 121, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (218, '2014-10-08 16:55:17.917', 'EN', '2014-10-08 16:55:17.917', false, NULL, 'European Capitals', 1, 1, 215, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (220, '2014-10-08 16:55:17.95', 'EN', '2014-10-08 16:55:17.95', false, NULL, 'European Union', 1, 1, 215, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (222, '2014-10-08 16:55:17.984', 'EN', '2014-10-08 16:55:17.984', false, NULL, 'European History', 1, 1, 215, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (327, '2014-10-08 16:55:20.393', 'EN', '2014-10-08 16:55:20.393', false, NULL, 'European Capitals', 1, 1, 324, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (329, '2014-10-08 16:55:20.431', 'EN', '2014-10-08 16:55:20.431', false, NULL, 'European Union', 1, 1, 324, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (331, '2014-10-08 16:55:20.481', 'EN', '2014-10-08 16:55:20.481', false, NULL, 'European History', 1, 1, 324, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (438, '2014-10-08 16:55:22.413', 'EN', '2014-10-08 16:55:22.413', false, NULL, 'European Union', 1, 1, 433, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (440, '2014-10-08 16:55:22.439', 'EN', '2014-10-08 16:55:22.439', false, NULL, 'European History', 1, 1, 433, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (436, '2014-10-08 16:55:22.387', 'EN', '2014-10-08 16:55:22.387', true, NULL, 'European Capitals', 1, 1, 433, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (544, '2014-10-08 16:55:23.871', 'EN', '2014-10-08 16:55:23.871', false, NULL, 'Fast Food QuestionnaireDefinition - Section', 1, 1, 542, 0);


--
-- TOC entry 2248 (class 0 OID 90270)
-- Dependencies: 177
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (21, 'Q1', '2014-10-08 16:55:14.664', 'EN', '2014-10-08 16:55:14.664', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 15, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (23, 'Q2', '2014-10-08 16:55:14.72', 'EN', '2014-10-08 16:55:14.72', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 15, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (33, 'Q3', '2014-10-08 16:55:14.837', 'EN', '2014-10-08 16:55:14.837', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 15, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (35, 'Q4', '2014-10-08 16:55:14.887', 'EN', '2014-10-08 16:55:14.887', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 15, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (45, 'Q5', '2014-10-08 16:55:15.004', 'EN', '2014-10-08 16:55:15.004', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 17, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (47, 'Q6', '2014-10-08 16:55:15.048', 'EN', '2014-10-08 16:55:15.048', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 17, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (57, 'Q7', '2014-10-08 16:55:15.143', 'EN', '2014-10-08 16:55:15.143', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 17, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (67, 'Q8', '2014-10-08 16:55:15.259', 'EN', '2014-10-08 16:55:15.259', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 17, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (69, 'Q9', '2014-10-08 16:55:15.299', 'EN', '2014-10-08 16:55:15.299', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 19, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (79, 'Q10', '2014-10-08 16:55:15.408', 'EN', '2014-10-08 16:55:15.408', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 19, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (89, 'Q11', '2014-10-08 16:55:15.529', 'EN', '2014-10-08 16:55:15.529', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 19, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (91, 'Q12', '2014-10-08 16:55:15.574', 'EN', '2014-10-08 16:55:15.574', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 19, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (130, 'Q1', '2014-10-08 16:55:16.463', 'EN', '2014-10-08 16:55:16.463', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 124, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (132, 'Q2', '2014-10-08 16:55:16.496', 'EN', '2014-10-08 16:55:16.496', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 124, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (142, 'Q3', '2014-10-08 16:55:16.607', 'EN', '2014-10-08 16:55:16.607', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 124, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (144, 'Q4', '2014-10-08 16:55:16.662', 'EN', '2014-10-08 16:55:16.662', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 124, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (154, 'Q5', '2014-10-08 16:55:16.747', 'EN', '2014-10-08 16:55:16.747', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 126, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (156, 'Q6', '2014-10-08 16:55:16.773', 'EN', '2014-10-08 16:55:16.773', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 126, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (166, 'Q7', '2014-10-08 16:55:16.887', 'EN', '2014-10-08 16:55:16.887', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 126, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (176, 'Q8', '2014-10-08 16:55:17.029', 'EN', '2014-10-08 16:55:17.029', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 126, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (178, 'Q9', '2014-10-08 16:55:17.067', 'EN', '2014-10-08 16:55:17.067', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 128, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (188, 'Q10', '2014-10-08 16:55:17.168', 'EN', '2014-10-08 16:55:17.168', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 128, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (198, 'Q11', '2014-10-08 16:55:17.262', 'EN', '2014-10-08 16:55:17.262', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 128, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (200, 'Q12', '2014-10-08 16:55:17.308', 'EN', '2014-10-08 16:55:17.308', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 128, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (224, 'Q1', '2014-10-08 16:55:18.018', 'EN', '2014-10-08 16:55:18.018', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 218, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (226, 'Q2', '2014-10-08 16:55:18.058', 'EN', '2014-10-08 16:55:18.058', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 218, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (236, 'Q3', '2014-10-08 16:55:18.188', 'EN', '2014-10-08 16:55:18.188', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 218, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (238, 'Q4', '2014-10-08 16:55:18.248', 'EN', '2014-10-08 16:55:18.248', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 218, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (248, 'Q5', '2014-10-08 16:55:18.451', 'EN', '2014-10-08 16:55:18.451', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 220, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (250, 'Q6', '2014-10-08 16:55:18.491', 'EN', '2014-10-08 16:55:18.491', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 220, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (260, 'Q7', '2014-10-08 16:55:18.625', 'EN', '2014-10-08 16:55:18.625', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 220, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (270, 'Q8', '2014-10-08 16:55:18.745', 'EN', '2014-10-08 16:55:18.745', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 220, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (272, 'Q9', '2014-10-08 16:55:18.787', 'EN', '2014-10-08 16:55:18.787', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 222, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (282, 'Q10', '2014-10-08 16:55:19.022', 'EN', '2014-10-08 16:55:19.022', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 222, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (292, 'Q11', '2014-10-08 16:55:19.222', 'EN', '2014-10-08 16:55:19.222', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 222, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (294, 'Q12', '2014-10-08 16:55:19.268', 'EN', '2014-10-08 16:55:19.268', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 222, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (333, 'Q1', '2014-10-08 16:55:20.518', 'EN', '2014-10-08 16:55:20.518', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 327, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (335, 'Q2', '2014-10-08 16:55:20.549', 'EN', '2014-10-08 16:55:20.549', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 327, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (345, 'Q3', '2014-10-08 16:55:20.644', 'EN', '2014-10-08 16:55:20.644', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 327, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (347, 'Q4', '2014-10-08 16:55:20.693', 'EN', '2014-10-08 16:55:20.693', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 327, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (357, 'Q5', '2014-10-08 16:55:20.794', 'EN', '2014-10-08 16:55:20.794', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 329, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (359, 'Q6', '2014-10-08 16:55:20.826', 'EN', '2014-10-08 16:55:20.826', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 329, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (369, 'Q7', '2014-10-08 16:55:20.906', 'EN', '2014-10-08 16:55:20.906', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 329, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (379, 'Q8', '2014-10-08 16:55:21.029', 'EN', '2014-10-08 16:55:21.029', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 329, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (381, 'Q9', '2014-10-08 16:55:21.066', 'EN', '2014-10-08 16:55:21.066', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 331, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (391, 'Q10', '2014-10-08 16:55:21.159', 'EN', '2014-10-08 16:55:21.159', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 331, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (401, 'Q11', '2014-10-08 16:55:21.254', 'EN', '2014-10-08 16:55:21.254', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 331, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (403, 'Q12', '2014-10-08 16:55:21.286', 'EN', '2014-10-08 16:55:21.286', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 331, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (442, 'Q1', '2014-10-08 16:55:22.472', 'EN', '2014-10-08 16:55:22.472', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 436, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (444, 'Q2', '2014-10-08 16:55:22.492', 'EN', '2014-10-08 16:55:22.492', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 436, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (454, 'Q3', '2014-10-08 16:55:22.569', 'EN', '2014-10-08 16:55:22.569', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 436, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (456, 'Q4', '2014-10-08 16:55:22.617', 'EN', '2014-10-08 16:55:22.617', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 436, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (466, 'Q5', '2014-10-08 16:55:22.68', 'EN', '2014-10-08 16:55:22.68', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 438, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (468, 'Q6', '2014-10-08 16:55:22.702', 'EN', '2014-10-08 16:55:22.702', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 438, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (510, 'Q11', '2014-10-08 16:55:23.081', 'EN', '2014-10-08 16:55:23.081', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 440, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (545, 'Q1', '2014-10-08 16:55:23.89', 'EN', '2014-10-08 16:55:23.89', false, true, 'F', NULL, '<b>Food Quality</b>', 1, 1, NULL, 544, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (552, 'Q1.1', '2014-10-08 16:55:23.9', 'EN', '2014-10-08 16:55:23.9', false, false, 'L', NULL, 'The food is served hot and fresh', 1, 1, 545, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (553, 'Q1.2', '2014-10-08 16:55:23.901', 'EN', '2014-10-08 16:55:23.901', false, false, 'L', NULL, 'The menu has a good variety of items', 1, 1, 545, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (554, 'Q1.3', '2014-10-08 16:55:23.901', 'EN', '2014-10-08 16:55:23.901', false, false, 'L', NULL, 'The quality of food is excellent', 1, 1, 545, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (555, 'Q1.4', '2014-10-08 16:55:23.902', 'EN', '2014-10-08 16:55:23.902', false, false, 'L', NULL, 'The food is tasty and flavorful', 1, 1, 545, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (478, 'Q7', '2014-10-08 16:55:22.793', 'EN', '2014-10-08 16:55:22.793', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 438, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (488, 'Q8', '2014-10-08 16:55:22.902', 'EN', '2014-10-08 16:55:22.902', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 438, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (490, 'Q9', '2014-10-08 16:55:22.937', 'EN', '2014-10-08 16:55:22.937', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 440, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (512, 'Q12', '2014-10-08 16:55:23.118', 'EN', '2014-10-08 16:55:23.118', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 440, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (500, 'Q10', '2014-10-08 16:55:23.01', 'EN', '2014-10-08 16:55:23.01', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 440, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (556, 'Q2', '2014-10-08 16:55:23.949', 'EN', '2014-10-08 16:55:23.949', false, true, 'F', NULL, '<b>Resturant</b>', 1, 1, NULL, 544, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (563, 'Q2.1', '2014-10-08 16:55:23.955', 'EN', '2014-10-08 16:55:23.955', false, false, 'L', NULL, 'My food order was correct and complete', 1, 1, 556, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (564, 'Q2.2', '2014-10-08 16:55:23.956', 'EN', '2014-10-08 16:55:23.956', false, false, 'L', NULL, 'Employees are patient when taking my order', 1, 1, 556, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (565, 'Q2.3', '2014-10-08 16:55:23.957', 'EN', '2014-10-08 16:55:23.957', false, false, 'L', NULL, 'I was served promptly', 1, 1, 556, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (566, 'Q2.4', '2014-10-08 16:55:23.958', 'EN', '2014-10-08 16:55:23.958', false, false, 'L', NULL, 'Availability of sauces, utensils, napkins, etc. was good', 1, 1, 556, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (567, 'Q2.5', '2014-10-08 16:55:23.959', 'EN', '2014-10-08 16:55:23.959', false, false, 'L', NULL, 'The menu board was easy to read', 1, 1, 556, NULL, 4, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (568, 'Q2.6', '2014-10-08 16:55:23.96', 'EN', '2014-10-08 16:55:23.96', false, false, 'L', NULL, 'The drive-thru sound system was cleara', 1, 1, 556, NULL, 5, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (569, 'Q3', '2014-10-08 16:55:24.031', 'EN', '2014-10-08 16:55:24.031', false, true, 'L', NULL, 'Indicate total household income', 1, 1, NULL, 544, NULL, 2);


--
-- TOC entry 2252 (class 0 OID 90299)
-- Dependencies: 181
-- Data for Name: research; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (103, '2014-10-08 16:55:16.014', '2014-10-08 16:55:16.001', '2014-10-08 16:55:16.014', 'New QuizEuropean general knowledge quiz started', '2014-10-08 16:55:16', 'C', 'P', 1, 1, 12);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (118, '2014-10-08 16:55:16.283', '2014-10-08 16:55:16.275', '2014-10-08 16:55:16.283', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-10-08 16:55:16.274', 'D', 'O', 1, 1, 12);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (212, '2014-10-08 16:55:17.865', '2014-10-08 16:55:17.851', '2014-10-08 16:55:17.865', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-10-08 16:55:17.851', 'D', 'O', 1, 1, 121);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (306, '2014-10-08 16:55:19.979', '2014-10-08 16:55:19.961', '2014-10-08 16:55:19.979', 'New QuizEuropean general knowledge quiz started', '2014-10-08 16:55:19.961', 'C', 'P', 1, 1, 215);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (321, '2014-10-08 16:55:20.313', '2014-10-08 16:55:20.298', '2014-10-08 16:55:20.313', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-10-08 16:55:20.297', 'D', 'O', 1, 1, 215);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (415, '2014-10-08 16:55:21.982', '2014-10-08 16:55:21.974', '2014-10-08 16:55:21.982', 'New QuizEuropean general knowledge quiz started', '2014-10-08 16:55:21.973', 'C', 'P', 1, 1, 324);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (430, '2014-10-08 16:55:22.342', '2014-10-08 16:55:22.336', '2014-10-08 16:55:22.342', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-10-08 16:55:22.336', 'D', 'O', 1, 1, 324);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (524, '2014-10-08 16:55:23.501', '2014-10-08 16:55:23.498', '2014-10-08 16:55:23.501', 'New QuizEuropean general knowledge quiz started', '2014-10-08 16:55:23.498', 'C', 'P', 1, 1, 433);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (539, '2014-10-08 16:55:23.815', '2014-10-08 16:55:23.813', '2014-10-08 16:55:23.815', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-10-08 16:55:23.812', 'D', 'O', 1, 1, 433);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (577, '2014-10-08 16:55:24.369', '2014-10-08 16:55:24.365', '2014-10-08 16:55:24.369', 'New customer satisfation survey Food Quality QuestionnaireDefinition started', '2014-10-08 16:55:24.365', 'D', 'O', 1, 1, 542);


--
-- TOC entry 2249 (class 0 OID 90278)
-- Dependencies: 178
-- Data for Name: questionnaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (106, 1, '2014-10-08 16:55:16.057', '2014-10-08 16:55:16.057', 'C', NULL, 1, 1, 12, 103, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (109, 2, '2014-10-08 16:55:16.124', '2014-10-08 16:55:16.124', 'C', NULL, 1, 1, 12, 103, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (112, 3, '2014-10-08 16:55:16.17', '2014-10-08 16:55:16.17', 'C', NULL, 1, 1, 12, 103, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (115, 4, '2014-10-08 16:55:16.21', '2014-10-08 16:55:16.21', 'C', NULL, 1, 1, 12, 103, 8);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (309, 1, '2014-10-08 16:55:20.019', '2014-10-08 16:55:20.019', 'C', NULL, 1, 1, 215, 306, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (312, 2, '2014-10-08 16:55:20.083', '2014-10-08 16:55:20.083', 'C', NULL, 1, 1, 215, 306, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (315, 3, '2014-10-08 16:55:20.138', '2014-10-08 16:55:20.138', 'C', NULL, 1, 1, 215, 306, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (318, 4, '2014-10-08 16:55:20.206', '2014-10-08 16:55:20.206', 'C', NULL, 1, 1, 215, 306, 8);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (418, 1, '2014-10-08 16:55:22.007', '2014-10-08 16:55:22.007', 'C', NULL, 1, 1, 324, 415, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (421, 2, '2014-10-08 16:55:22.15', '2014-10-08 16:55:22.15', 'C', NULL, 1, 1, 324, 415, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (424, 3, '2014-10-08 16:55:22.257', '2014-10-08 16:55:22.257', 'C', NULL, 1, 1, 324, 415, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (427, 4, '2014-10-08 16:55:22.296', '2014-10-08 16:55:22.296', 'C', NULL, 1, 1, 324, 415, 8);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (527, 1, '2014-10-08 16:55:23.536', '2014-10-08 16:55:23.536', 'C', NULL, 1, 1, 433, 524, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (530, 2, '2014-10-08 16:55:23.571', '2014-10-08 16:55:23.571', 'C', NULL, 1, 1, 433, 524, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (533, 3, '2014-10-08 16:55:23.729', '2014-10-08 16:55:23.729', 'C', NULL, 1, 1, 433, 524, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (536, 4, '2014-10-08 16:55:23.769', '2014-10-08 16:55:23.769', 'C', NULL, 1, 1, 433, 524, 8);


--
-- TOC entry 2243 (class 0 OID 90233)
-- Dependencies: 172
-- Data for Name: breadcrumb; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2267 (class 0 OID 90404)
-- Dependencies: 196
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2260 (class 0 OID 90363)
-- Dependencies: 189
-- Data for Name: directory_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2266 (class 0 OID 90396)
-- Dependencies: 195
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO groups (id, created_date, description, last_modified_date, name, createdby_id, lastmodifiedby_id) VALUES (3, '2014-10-08 16:55:14.27', 'Respondent group', '2014-10-08 16:55:14.27', 'Respondents', 1, 1);


--
-- TOC entry 2242 (class 0 OID 90225)
-- Dependencies: 171
-- Data for Name: invitation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (104, 'A', 'A', '2LBHRWXXBT', 103, NULL);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (108, 'P', 'A', 'DLZBC9WD4L', 103, 6);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (111, 'P', 'A', '955K34NCVH', 103, 4);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (114, 'P', 'A', '4FM7Z7ESFT', 103, 10);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (117, 'P', 'A', 'QG5TMTZ6VF', 103, 8);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (119, 'A', 'A', 'FPPL5KXS2T', 118, NULL);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (213, 'A', 'A', '4S68FBLSES', 212, NULL);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (307, 'A', 'A', 'YW86N8TYQT', 306, NULL);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (311, 'P', 'A', 'YW2CZBFW9Z', 306, 6);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (314, 'P', 'A', 'QAX6M3LVBR', 306, 4);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (317, 'P', 'A', 'VXY2XESWE8', 306, 10);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (320, 'P', 'A', '9M527B9HEL', 306, 8);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (322, 'A', 'A', '5UC9A83TLA', 321, NULL);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (416, 'A', 'A', 'EECZAYQVUG', 415, NULL);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (420, 'P', 'A', 'RVRC5QQ2RY', 415, 6);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (423, 'P', 'A', 'YKHUXFYRJP', 415, 4);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (426, 'P', 'A', 'JW9VFE6GRD', 415, 10);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (429, 'P', 'A', 'HQHEJNLQ6Q', 415, 8);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (431, 'A', 'A', 'WKZRN6BY4L', 430, NULL);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (525, 'A', 'A', '4LBCT23TM7', 524, NULL);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (529, 'P', 'A', 'DLSXU5VQPP', 524, 6);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (532, 'P', 'A', '42QGPNF3FS', 524, 4);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (535, 'P', 'A', 'B69UK4MTAS', 524, 10);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (538, 'P', 'A', 'VVBZQY6SZH', 524, 8);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (540, 'A', 'A', 'TY3QFF5BN7', 539, NULL);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (578, 'A', 'A', 'VWXY3Y4EAC', 577, NULL);


--
-- TOC entry 2245 (class 0 OID 90246)
-- Dependencies: 174
-- Data for Name: label_set; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2244 (class 0 OID 90238)
-- Dependencies: 173
-- Data for Name: label; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2254 (class 0 OID 90315)
-- Dependencies: 183
-- Data for Name: label_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2246 (class 0 OID 90254)
-- Dependencies: 175
-- Data for Name: mail_message; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2247 (class 0 OID 90262)
-- Dependencies: 176
-- Data for Name: mail_message_template; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (101, '2014-10-08 16:55:15.689', 'support@gazpacho.net', 'EN', '2014-10-08 16:55:15.689', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 12);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (210, '2014-10-08 16:55:17.57', 'support@gazpacho.net', 'EN', '2014-10-08 16:55:17.57', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 121);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (304, '2014-10-08 16:55:19.639', 'support@gazpacho.net', 'EN', '2014-10-08 16:55:19.639', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 215);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (413, '2014-10-08 16:55:21.453', 'support@gazpacho.net', 'EN', '2014-10-08 16:55:21.453', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 324);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (522, '2014-10-08 16:55:23.236', 'support@gazpacho.net', 'EN', '2014-10-08 16:55:23.236', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 433);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (575, '2014-10-08 16:55:24.114', 'support@gazpacho.net', 'EN', '2014-10-08 16:55:24.114', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 542);


--
-- TOC entry 2255 (class 0 OID 90323)
-- Dependencies: 184
-- Data for Name: mail_message_template_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (102, '2014-10-08 16:55:15.716', 'ES', '2014-10-08 16:55:15.716', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 101);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (211, '2014-10-08 16:55:17.58', 'ES', '2014-10-08 16:55:17.58', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 210);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (305, '2014-10-08 16:55:19.657', 'ES', '2014-10-08 16:55:19.657', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 304);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (414, '2014-10-08 16:55:21.596', 'ES', '2014-10-08 16:55:21.596', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 413);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (523, '2014-10-08 16:55:23.243', 'ES', '2014-10-08 16:55:23.243', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 522);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (576, '2014-10-08 16:55:24.126', 'ES', '2014-10-08 16:55:24.126', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 575);


--
-- TOC entry 2251 (class 0 OID 90291)
-- Dependencies: 180
-- Data for Name: question_option; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (24, 'O1', '2014-10-08 16:55:14.725', 'EN', '2014-10-08 16:55:14.725', 'Norway', 1, 1, 23, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (25, 'O2', '2014-10-08 16:55:14.727', 'EN', '2014-10-08 16:55:14.727', 'Sweden', 1, 1, 23, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (26, 'O3', '2014-10-08 16:55:14.729', 'EN', '2014-10-08 16:55:14.729', 'Denmark', 1, 1, 23, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (27, 'O4', '2014-10-08 16:55:14.731', 'EN', '2014-10-08 16:55:14.731', 'Iceland', 1, 1, 23, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (36, 'O1', '2014-10-08 16:55:14.889', 'EN', '2014-10-08 16:55:14.889', 'Vatican City', 1, 1, 35, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (37, 'O2', '2014-10-08 16:55:14.89', 'EN', '2014-10-08 16:55:14.89', 'Roma', 1, 1, 35, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (38, 'O3', '2014-10-08 16:55:14.891', 'EN', '2014-10-08 16:55:14.891', 'Helsinki', 1, 1, 35, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (39, 'O4', '2014-10-08 16:55:14.893', 'EN', '2014-10-08 16:55:14.893', 'Viena', 1, 1, 35, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (48, 'O1', '2014-10-08 16:55:15.052', 'EN', '2014-10-08 16:55:15.052', 'Westphalia', 1, 1, 47, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (49, 'O2', '2014-10-08 16:55:15.054', 'EN', '2014-10-08 16:55:15.054', 'Rome', 1, 1, 47, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (50, 'O3', '2014-10-08 16:55:15.057', 'EN', '2014-10-08 16:55:15.057', 'Brussels', 1, 1, 47, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (51, 'O4', '2014-10-08 16:55:15.063', 'EN', '2014-10-08 16:55:15.063', 'Versailles', 1, 1, 47, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (58, 'O1', '2014-10-08 16:55:15.145', 'EN', '2014-10-08 16:55:15.145', 'Norway', 1, 1, 57, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (59, 'O2', '2014-10-08 16:55:15.146', 'EN', '2014-10-08 16:55:15.146', 'Poland', 1, 1, 57, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (60, 'O3', '2014-10-08 16:55:15.147', 'EN', '2014-10-08 16:55:15.147', 'Macedonia', 1, 1, 57, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (61, 'O4', '2014-10-08 16:55:15.148', 'EN', '2014-10-08 16:55:15.148', 'Chipre', 1, 1, 57, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (70, 'O1', '2014-10-08 16:55:15.3', 'EN', '2014-10-08 16:55:15.3', 'Barcelona', 1, 1, 69, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (71, 'O2', '2014-10-08 16:55:15.303', 'EN', '2014-10-08 16:55:15.303', 'Lisboa', 1, 1, 69, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (72, 'O3', '2014-10-08 16:55:15.305', 'EN', '2014-10-08 16:55:15.305', 'Genoa', 1, 1, 69, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (73, 'O4', '2014-10-08 16:55:15.306', 'EN', '2014-10-08 16:55:15.306', 'Roma', 1, 1, 69, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (80, 'O1', '2014-10-08 16:55:15.41', 'EN', '2014-10-08 16:55:15.41', 'Portuguese Empire', 1, 1, 79, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (81, 'O2', '2014-10-08 16:55:15.412', 'EN', '2014-10-08 16:55:15.412', 'British Empire', 1, 1, 79, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (82, 'O3', '2014-10-08 16:55:15.413', 'EN', '2014-10-08 16:55:15.413', 'Spanish Empire', 1, 1, 79, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (83, 'O4', '2014-10-08 16:55:15.414', 'EN', '2014-10-08 16:55:15.414', 'Dutch Empire', 1, 1, 79, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (92, 'O1', '2014-10-08 16:55:15.575', 'EN', '2014-10-08 16:55:15.575', 'Adolph Hitler', 1, 1, 91, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (93, 'O2', '2014-10-08 16:55:15.576', 'EN', '2014-10-08 16:55:15.576', 'Napoleon', 1, 1, 91, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (94, 'O3', '2014-10-08 16:55:15.577', 'EN', '2014-10-08 16:55:15.577', 'Philip 2th King of Spain', 1, 1, 91, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (95, 'O4', '2014-10-08 16:55:15.578', 'EN', '2014-10-08 16:55:15.578', 'Julius Caesar', 1, 1, 91, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (133, 'O1', '2014-10-08 16:55:16.497', 'EN', '2014-10-08 16:55:16.497', 'Norway', 1, 1, 132, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (134, 'O2', '2014-10-08 16:55:16.498', 'EN', '2014-10-08 16:55:16.498', 'Sweden', 1, 1, 132, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (135, 'O3', '2014-10-08 16:55:16.499', 'EN', '2014-10-08 16:55:16.499', 'Denmark', 1, 1, 132, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (136, 'O4', '2014-10-08 16:55:16.501', 'EN', '2014-10-08 16:55:16.501', 'Iceland', 1, 1, 132, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (145, 'O1', '2014-10-08 16:55:16.663', 'EN', '2014-10-08 16:55:16.663', 'Vatican City', 1, 1, 144, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (146, 'O2', '2014-10-08 16:55:16.664', 'EN', '2014-10-08 16:55:16.664', 'Roma', 1, 1, 144, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (147, 'O3', '2014-10-08 16:55:16.665', 'EN', '2014-10-08 16:55:16.665', 'Helsinki', 1, 1, 144, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (148, 'O4', '2014-10-08 16:55:16.666', 'EN', '2014-10-08 16:55:16.666', 'Viena', 1, 1, 144, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (157, 'O1', '2014-10-08 16:55:16.774', 'EN', '2014-10-08 16:55:16.774', 'Westphalia', 1, 1, 156, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (158, 'O2', '2014-10-08 16:55:16.775', 'EN', '2014-10-08 16:55:16.775', 'Rome', 1, 1, 156, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (159, 'O3', '2014-10-08 16:55:16.776', 'EN', '2014-10-08 16:55:16.776', 'Brussels', 1, 1, 156, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (160, 'O4', '2014-10-08 16:55:16.777', 'EN', '2014-10-08 16:55:16.777', 'Versailles', 1, 1, 156, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (167, 'O1', '2014-10-08 16:55:16.889', 'EN', '2014-10-08 16:55:16.889', 'Norway', 1, 1, 166, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (168, 'O2', '2014-10-08 16:55:16.89', 'EN', '2014-10-08 16:55:16.89', 'Poland', 1, 1, 166, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (169, 'O3', '2014-10-08 16:55:16.892', 'EN', '2014-10-08 16:55:16.892', 'Macedonia', 1, 1, 166, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (170, 'O4', '2014-10-08 16:55:16.893', 'EN', '2014-10-08 16:55:16.893', 'Chipre', 1, 1, 166, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (179, 'O1', '2014-10-08 16:55:17.068', 'EN', '2014-10-08 16:55:17.068', 'Barcelona', 1, 1, 178, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (180, 'O2', '2014-10-08 16:55:17.07', 'EN', '2014-10-08 16:55:17.07', 'Lisboa', 1, 1, 178, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (181, 'O3', '2014-10-08 16:55:17.071', 'EN', '2014-10-08 16:55:17.071', 'Genoa', 1, 1, 178, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (182, 'O4', '2014-10-08 16:55:17.073', 'EN', '2014-10-08 16:55:17.073', 'Roma', 1, 1, 178, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (189, 'O1', '2014-10-08 16:55:17.169', 'EN', '2014-10-08 16:55:17.169', 'Portuguese Empire', 1, 1, 188, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (190, 'O2', '2014-10-08 16:55:17.17', 'EN', '2014-10-08 16:55:17.17', 'British Empire', 1, 1, 188, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (191, 'O3', '2014-10-08 16:55:17.171', 'EN', '2014-10-08 16:55:17.171', 'Spanish Empire', 1, 1, 188, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (192, 'O4', '2014-10-08 16:55:17.173', 'EN', '2014-10-08 16:55:17.173', 'Dutch Empire', 1, 1, 188, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (201, 'O1', '2014-10-08 16:55:17.318', 'EN', '2014-10-08 16:55:17.318', 'Adolph Hitler', 1, 1, 200, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (202, 'O2', '2014-10-08 16:55:17.319', 'EN', '2014-10-08 16:55:17.319', 'Napoleon', 1, 1, 200, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (203, 'O3', '2014-10-08 16:55:17.32', 'EN', '2014-10-08 16:55:17.32', 'Philip 2th King of Spain', 1, 1, 200, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (204, 'O4', '2014-10-08 16:55:17.321', 'EN', '2014-10-08 16:55:17.321', 'Julius Caesar', 1, 1, 200, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (227, 'O1', '2014-10-08 16:55:18.06', 'EN', '2014-10-08 16:55:18.06', 'Norway', 1, 1, 226, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (228, 'O2', '2014-10-08 16:55:18.062', 'EN', '2014-10-08 16:55:18.062', 'Sweden', 1, 1, 226, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (229, 'O3', '2014-10-08 16:55:18.064', 'EN', '2014-10-08 16:55:18.064', 'Denmark', 1, 1, 226, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (230, 'O4', '2014-10-08 16:55:18.066', 'EN', '2014-10-08 16:55:18.066', 'Iceland', 1, 1, 226, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (239, 'O1', '2014-10-08 16:55:18.25', 'EN', '2014-10-08 16:55:18.25', 'Vatican City', 1, 1, 238, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (240, 'O2', '2014-10-08 16:55:18.252', 'EN', '2014-10-08 16:55:18.252', 'Roma', 1, 1, 238, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (241, 'O3', '2014-10-08 16:55:18.254', 'EN', '2014-10-08 16:55:18.254', 'Helsinki', 1, 1, 238, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (242, 'O4', '2014-10-08 16:55:18.255', 'EN', '2014-10-08 16:55:18.255', 'Viena', 1, 1, 238, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (251, 'O1', '2014-10-08 16:55:18.498', 'EN', '2014-10-08 16:55:18.498', 'Westphalia', 1, 1, 250, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (252, 'O2', '2014-10-08 16:55:18.5', 'EN', '2014-10-08 16:55:18.5', 'Rome', 1, 1, 250, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (253, 'O3', '2014-10-08 16:55:18.501', 'EN', '2014-10-08 16:55:18.501', 'Brussels', 1, 1, 250, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (254, 'O4', '2014-10-08 16:55:18.503', 'EN', '2014-10-08 16:55:18.503', 'Versailles', 1, 1, 250, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (261, 'O1', '2014-10-08 16:55:18.626', 'EN', '2014-10-08 16:55:18.626', 'Norway', 1, 1, 260, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (262, 'O2', '2014-10-08 16:55:18.627', 'EN', '2014-10-08 16:55:18.627', 'Poland', 1, 1, 260, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (263, 'O3', '2014-10-08 16:55:18.629', 'EN', '2014-10-08 16:55:18.629', 'Macedonia', 1, 1, 260, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (264, 'O4', '2014-10-08 16:55:18.63', 'EN', '2014-10-08 16:55:18.63', 'Chipre', 1, 1, 260, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (273, 'O1', '2014-10-08 16:55:18.789', 'EN', '2014-10-08 16:55:18.789', 'Barcelona', 1, 1, 272, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (274, 'O2', '2014-10-08 16:55:18.79', 'EN', '2014-10-08 16:55:18.79', 'Lisboa', 1, 1, 272, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (275, 'O3', '2014-10-08 16:55:18.791', 'EN', '2014-10-08 16:55:18.791', 'Genoa', 1, 1, 272, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (276, 'O4', '2014-10-08 16:55:18.793', 'EN', '2014-10-08 16:55:18.793', 'Roma', 1, 1, 272, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (283, 'O1', '2014-10-08 16:55:19.025', 'EN', '2014-10-08 16:55:19.025', 'Portuguese Empire', 1, 1, 282, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (284, 'O2', '2014-10-08 16:55:19.026', 'EN', '2014-10-08 16:55:19.026', 'British Empire', 1, 1, 282, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (285, 'O3', '2014-10-08 16:55:19.027', 'EN', '2014-10-08 16:55:19.027', 'Spanish Empire', 1, 1, 282, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (286, 'O4', '2014-10-08 16:55:19.029', 'EN', '2014-10-08 16:55:19.029', 'Dutch Empire', 1, 1, 282, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (295, 'O1', '2014-10-08 16:55:19.269', 'EN', '2014-10-08 16:55:19.269', 'Adolph Hitler', 1, 1, 294, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (296, 'O2', '2014-10-08 16:55:19.269', 'EN', '2014-10-08 16:55:19.269', 'Napoleon', 1, 1, 294, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (297, 'O3', '2014-10-08 16:55:19.27', 'EN', '2014-10-08 16:55:19.27', 'Philip 2th King of Spain', 1, 1, 294, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (298, 'O4', '2014-10-08 16:55:19.271', 'EN', '2014-10-08 16:55:19.271', 'Julius Caesar', 1, 1, 294, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (570, 'O1', '2014-10-08 16:55:24.033', 'EN', '2014-10-08 16:55:24.033', 'under 25,000€', 1, 1, 569, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (571, 'O2', '2014-10-08 16:55:24.034', 'EN', '2014-10-08 16:55:24.034', '25,000 - 29,999€', 1, 1, 569, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (572, 'O3', '2014-10-08 16:55:24.036', 'EN', '2014-10-08 16:55:24.036', '30,000 - 34,999€', 1, 1, 569, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (573, 'O4', '2014-10-08 16:55:24.048', 'EN', '2014-10-08 16:55:24.048', '35,000 - 39,999€', 1, 1, 569, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (574, 'O5', '2014-10-08 16:55:24.049', 'EN', '2014-10-08 16:55:24.049', 'Over 85,000€', 1, 1, 569, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (336, 'O1', '2014-10-08 16:55:20.55', 'EN', '2014-10-08 16:55:20.55', 'Norway', 1, 1, 335, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (337, 'O2', '2014-10-08 16:55:20.55', 'EN', '2014-10-08 16:55:20.55', 'Sweden', 1, 1, 335, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (338, 'O3', '2014-10-08 16:55:20.552', 'EN', '2014-10-08 16:55:20.552', 'Denmark', 1, 1, 335, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (339, 'O4', '2014-10-08 16:55:20.553', 'EN', '2014-10-08 16:55:20.553', 'Iceland', 1, 1, 335, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (392, 'O1', '2014-10-08 16:55:21.16', 'EN', '2014-10-08 16:55:21.16', 'Portuguese Empire', 1, 1, 391, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (393, 'O2', '2014-10-08 16:55:21.161', 'EN', '2014-10-08 16:55:21.161', 'British Empire', 1, 1, 391, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (394, 'O3', '2014-10-08 16:55:21.162', 'EN', '2014-10-08 16:55:21.162', 'Spanish Empire', 1, 1, 391, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (395, 'O4', '2014-10-08 16:55:21.162', 'EN', '2014-10-08 16:55:21.162', 'Dutch Empire', 1, 1, 391, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (348, 'O1', '2014-10-08 16:55:20.694', 'EN', '2014-10-08 16:55:20.694', 'Vatican City', 1, 1, 347, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (349, 'O2', '2014-10-08 16:55:20.695', 'EN', '2014-10-08 16:55:20.695', 'Roma', 1, 1, 347, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (350, 'O3', '2014-10-08 16:55:20.696', 'EN', '2014-10-08 16:55:20.696', 'Helsinki', 1, 1, 347, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (351, 'O4', '2014-10-08 16:55:20.703', 'EN', '2014-10-08 16:55:20.703', 'Viena', 1, 1, 347, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (360, 'O1', '2014-10-08 16:55:20.827', 'EN', '2014-10-08 16:55:20.827', 'Westphalia', 1, 1, 359, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (361, 'O2', '2014-10-08 16:55:20.828', 'EN', '2014-10-08 16:55:20.828', 'Rome', 1, 1, 359, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (362, 'O3', '2014-10-08 16:55:20.829', 'EN', '2014-10-08 16:55:20.829', 'Brussels', 1, 1, 359, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (363, 'O4', '2014-10-08 16:55:20.83', 'EN', '2014-10-08 16:55:20.83', 'Versailles', 1, 1, 359, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (370, 'O1', '2014-10-08 16:55:20.907', 'EN', '2014-10-08 16:55:20.907', 'Norway', 1, 1, 369, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (371, 'O2', '2014-10-08 16:55:20.908', 'EN', '2014-10-08 16:55:20.908', 'Poland', 1, 1, 369, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (372, 'O3', '2014-10-08 16:55:20.909', 'EN', '2014-10-08 16:55:20.909', 'Macedonia', 1, 1, 369, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (373, 'O4', '2014-10-08 16:55:20.91', 'EN', '2014-10-08 16:55:20.91', 'Chipre', 1, 1, 369, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (382, 'O1', '2014-10-08 16:55:21.067', 'EN', '2014-10-08 16:55:21.067', 'Barcelona', 1, 1, 381, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (383, 'O2', '2014-10-08 16:55:21.069', 'EN', '2014-10-08 16:55:21.069', 'Lisboa', 1, 1, 381, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (384, 'O3', '2014-10-08 16:55:21.07', 'EN', '2014-10-08 16:55:21.07', 'Genoa', 1, 1, 381, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (385, 'O4', '2014-10-08 16:55:21.072', 'EN', '2014-10-08 16:55:21.072', 'Roma', 1, 1, 381, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (404, 'O1', '2014-10-08 16:55:21.287', 'EN', '2014-10-08 16:55:21.287', 'Adolph Hitler', 1, 1, 403, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (405, 'O2', '2014-10-08 16:55:21.289', 'EN', '2014-10-08 16:55:21.289', 'Napoleon', 1, 1, 403, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (406, 'O3', '2014-10-08 16:55:21.29', 'EN', '2014-10-08 16:55:21.29', 'Philip 2th King of Spain', 1, 1, 403, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (407, 'O4', '2014-10-08 16:55:21.29', 'EN', '2014-10-08 16:55:21.29', 'Julius Caesar', 1, 1, 403, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (445, 'O1', '2014-10-08 16:55:22.493', 'EN', '2014-10-08 16:55:22.493', 'Norway', 1, 1, 444, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (446, 'O2', '2014-10-08 16:55:22.494', 'EN', '2014-10-08 16:55:22.494', 'Sweden', 1, 1, 444, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (447, 'O3', '2014-10-08 16:55:22.495', 'EN', '2014-10-08 16:55:22.495', 'Denmark', 1, 1, 444, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (448, 'O4', '2014-10-08 16:55:22.496', 'EN', '2014-10-08 16:55:22.496', 'Iceland', 1, 1, 444, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (501, 'O1', '2014-10-08 16:55:23.014', 'EN', '2014-10-08 16:55:23.014', 'Portuguese Empire', 1, 1, 500, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (502, 'O2', '2014-10-08 16:55:23.016', 'EN', '2014-10-08 16:55:23.016', 'British Empire', 1, 1, 500, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (503, 'O3', '2014-10-08 16:55:23.017', 'EN', '2014-10-08 16:55:23.017', 'Spanish Empire', 1, 1, 500, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (504, 'O4', '2014-10-08 16:55:23.018', 'EN', '2014-10-08 16:55:23.018', 'Dutch Empire', 1, 1, 500, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (457, 'O1', '2014-10-08 16:55:22.618', 'EN', '2014-10-08 16:55:22.618', 'Vatican City', 1, 1, 456, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (458, 'O2', '2014-10-08 16:55:22.619', 'EN', '2014-10-08 16:55:22.619', 'Roma', 1, 1, 456, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (459, 'O3', '2014-10-08 16:55:22.619', 'EN', '2014-10-08 16:55:22.619', 'Helsinki', 1, 1, 456, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (460, 'O4', '2014-10-08 16:55:22.62', 'EN', '2014-10-08 16:55:22.62', 'Viena', 1, 1, 456, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (491, 'O1', '2014-10-08 16:55:22.938', 'EN', '2014-10-08 16:55:22.938', 'Barcelona', 1, 1, 490, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (492, 'O2', '2014-10-08 16:55:22.938', 'EN', '2014-10-08 16:55:22.938', 'Lisboa', 1, 1, 490, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (493, 'O3', '2014-10-08 16:55:22.939', 'EN', '2014-10-08 16:55:22.939', 'Genoa', 1, 1, 490, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (494, 'O4', '2014-10-08 16:55:22.94', 'EN', '2014-10-08 16:55:22.94', 'Roma', 1, 1, 490, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (513, 'O1', '2014-10-08 16:55:23.121', 'EN', '2014-10-08 16:55:23.121', 'Adolph Hitler', 1, 1, 512, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (514, 'O2', '2014-10-08 16:55:23.122', 'EN', '2014-10-08 16:55:23.122', 'Napoleon', 1, 1, 512, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (515, 'O3', '2014-10-08 16:55:23.123', 'EN', '2014-10-08 16:55:23.123', 'Philip 2th King of Spain', 1, 1, 512, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (516, 'O4', '2014-10-08 16:55:23.124', 'EN', '2014-10-08 16:55:23.124', 'Julius Caesar', 1, 1, 512, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (469, 'O1', '2014-10-08 16:55:22.703', 'EN', '2014-10-08 16:55:22.703', 'Westphalia', 1, 1, 468, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (470, 'O2', '2014-10-08 16:55:22.704', 'EN', '2014-10-08 16:55:22.704', 'Rome', 1, 1, 468, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (471, 'O3', '2014-10-08 16:55:22.705', 'EN', '2014-10-08 16:55:22.705', 'Brussels', 1, 1, 468, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (472, 'O4', '2014-10-08 16:55:22.706', 'EN', '2014-10-08 16:55:22.706', 'Versailles', 1, 1, 468, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (479, 'O1', '2014-10-08 16:55:22.793', 'EN', '2014-10-08 16:55:22.793', 'Norway', 1, 1, 478, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (480, 'O2', '2014-10-08 16:55:22.794', 'EN', '2014-10-08 16:55:22.794', 'Poland', 1, 1, 478, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (481, 'O3', '2014-10-08 16:55:22.795', 'EN', '2014-10-08 16:55:22.795', 'Macedonia', 1, 1, 478, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (482, 'O4', '2014-10-08 16:55:22.796', 'EN', '2014-10-08 16:55:22.796', 'Chipre', 1, 1, 478, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (546, 'O1', '2014-10-08 16:55:23.891', 'EN', '2014-10-08 16:55:23.891', 'Agree strongly', 1, 1, 545, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (547, 'O2', '2014-10-08 16:55:23.892', 'EN', '2014-10-08 16:55:23.892', 'Agree somewhat', 1, 1, 545, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (548, 'O3', '2014-10-08 16:55:23.893', 'EN', '2014-10-08 16:55:23.893', 'Neither agree nor disagree', 1, 1, 545, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (549, 'O4', '2014-10-08 16:55:23.893', 'EN', '2014-10-08 16:55:23.893', 'Disagree somewhat', 1, 1, 545, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (550, 'O5', '2014-10-08 16:55:23.894', 'EN', '2014-10-08 16:55:23.894', 'Agree strongly', 1, 1, 545, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (551, 'O6', '2014-10-08 16:55:23.899', 'EN', '2014-10-08 16:55:23.899', 'Disagree strongly', 1, 1, 545, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (557, 'O1', '2014-10-08 16:55:23.95', 'EN', '2014-10-08 16:55:23.95', 'Agree strongly', 1, 1, 556, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (558, 'O2', '2014-10-08 16:55:23.951', 'EN', '2014-10-08 16:55:23.951', 'Agree somewhat', 1, 1, 556, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (559, 'O3', '2014-10-08 16:55:23.951', 'EN', '2014-10-08 16:55:23.951', 'Neither agree nor disagree', 1, 1, 556, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (560, 'O4', '2014-10-08 16:55:23.953', 'EN', '2014-10-08 16:55:23.953', 'Disagree somewhat', 1, 1, 556, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (561, 'O5', '2014-10-08 16:55:23.954', 'EN', '2014-10-08 16:55:23.954', 'Agree strongly', 1, 1, 556, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (562, 'O6', '2014-10-08 16:55:23.955', 'EN', '2014-10-08 16:55:23.955', 'Disagree strongly', 1, 1, 556, 5);


--
-- TOC entry 2257 (class 0 OID 90339)
-- Dependencies: 186
-- Data for Name: question_option_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (29, 'ES', 'Noruega', 24);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (30, 'ES', 'Suecia', 25);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (31, 'ES', 'Dinamarca', 26);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (32, 'ES', 'Islandia', 27);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (41, 'ES', 'Ciudad del Vaticano', 36);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (42, 'ES', 'Roma', 37);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (43, 'ES', 'Helsinki', 38);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (44, 'ES', 'Viena', 39);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (53, 'ES', 'Westphalia', 48);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (54, 'ES', 'Roma', 49);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (55, 'ES', 'Bruselas', 50);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (56, 'ES', 'Islandia', 51);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (63, 'ES', 'Noruega', 58);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (64, 'ES', 'Polonia', 59);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (65, 'ES', 'Macedonia', 60);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (66, 'ES', 'Chipre', 61);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (75, 'ES', 'Barcelona', 70);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (76, 'ES', 'Lisboa', 71);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (77, 'ES', 'Genova', 72);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (78, 'ES', 'Roma', 73);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (85, 'ES', 'Imperio Portugues', 80);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (86, 'ES', 'Imperio Británico', 81);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (87, 'ES', 'Imperio Español', 82);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (88, 'ES', 'Imperio Holandés', 83);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (97, 'ES', 'Adolfo Hitler', 92);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (98, 'ES', 'Napoleón', 93);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (99, 'ES', 'Felipe II', 94);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (100, 'ES', 'Julio Cesar', 95);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (138, 'ES', 'Noruega', 133);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (139, 'ES', 'Suecia', 134);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (140, 'ES', 'Dinamarca', 135);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (141, 'ES', 'Islandia', 136);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (150, 'ES', 'Ciudad del Vaticano', 145);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (151, 'ES', 'Roma', 146);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (152, 'ES', 'Helsinki', 147);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (153, 'ES', 'Viena', 148);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (162, 'ES', 'Westphalia', 157);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (163, 'ES', 'Roma', 158);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (164, 'ES', 'Bruselas', 159);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (165, 'ES', 'Islandia', 160);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (172, 'ES', 'Noruega', 167);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (173, 'ES', 'Polonia', 168);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (174, 'ES', 'Macedonia', 169);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (175, 'ES', 'Chipre', 170);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (184, 'ES', 'Barcelona', 179);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (185, 'ES', 'Lisboa', 180);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (186, 'ES', 'Genova', 181);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (187, 'ES', 'Roma', 182);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (194, 'ES', 'Imperio Portugues', 189);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (195, 'ES', 'Imperio Británico', 190);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (196, 'ES', 'Imperio Español', 191);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (197, 'ES', 'Imperio Holandés', 192);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (206, 'ES', 'Adolfo Hitler', 201);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (207, 'ES', 'Napoleón', 202);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (208, 'ES', 'Felipe II', 203);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (209, 'ES', 'Julio Cesar', 204);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (232, 'ES', 'Noruega', 227);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (233, 'ES', 'Suecia', 228);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (234, 'ES', 'Dinamarca', 229);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (235, 'ES', 'Islandia', 230);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (244, 'ES', 'Ciudad del Vaticano', 239);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (245, 'ES', 'Roma', 240);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (246, 'ES', 'Helsinki', 241);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (247, 'ES', 'Viena', 242);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (256, 'ES', 'Westphalia', 251);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (257, 'ES', 'Roma', 252);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (258, 'ES', 'Bruselas', 253);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (259, 'ES', 'Islandia', 254);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (266, 'ES', 'Noruega', 261);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (267, 'ES', 'Polonia', 262);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (268, 'ES', 'Macedonia', 263);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (269, 'ES', 'Chipre', 264);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (278, 'ES', 'Barcelona', 273);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (279, 'ES', 'Lisboa', 274);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (280, 'ES', 'Genova', 275);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (281, 'ES', 'Roma', 276);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (288, 'ES', 'Imperio Portugues', 283);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (289, 'ES', 'Imperio Británico', 284);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (290, 'ES', 'Imperio Español', 285);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (291, 'ES', 'Imperio Holandés', 286);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (300, 'ES', 'Adolfo Hitler', 295);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (301, 'ES', 'Napoleón', 296);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (302, 'ES', 'Felipe II', 297);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (303, 'ES', 'Julio Cesar', 298);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (341, 'ES', 'Noruega', 336);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (342, 'ES', 'Suecia', 337);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (343, 'ES', 'Dinamarca', 338);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (344, 'ES', 'Islandia', 339);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (353, 'ES', 'Ciudad del Vaticano', 348);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (354, 'ES', 'Roma', 349);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (355, 'ES', 'Helsinki', 350);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (356, 'ES', 'Viena', 351);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (365, 'ES', 'Westphalia', 360);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (366, 'ES', 'Roma', 361);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (367, 'ES', 'Bruselas', 362);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (368, 'ES', 'Islandia', 363);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (375, 'ES', 'Noruega', 370);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (376, 'ES', 'Polonia', 371);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (377, 'ES', 'Macedonia', 372);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (378, 'ES', 'Chipre', 373);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (387, 'ES', 'Barcelona', 382);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (388, 'ES', 'Lisboa', 383);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (389, 'ES', 'Genova', 384);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (390, 'ES', 'Roma', 385);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (397, 'ES', 'Imperio Portugues', 392);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (398, 'ES', 'Imperio Británico', 393);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (399, 'ES', 'Imperio Español', 394);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (400, 'ES', 'Imperio Holandés', 395);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (409, 'ES', 'Adolfo Hitler', 404);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (410, 'ES', 'Napoleón', 405);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (411, 'ES', 'Felipe II', 406);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (412, 'ES', 'Julio Cesar', 407);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (450, 'ES', 'Noruega', 445);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (451, 'ES', 'Suecia', 446);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (452, 'ES', 'Dinamarca', 447);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (453, 'ES', 'Islandia', 448);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (462, 'ES', 'Ciudad del Vaticano', 457);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (463, 'ES', 'Roma', 458);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (464, 'ES', 'Helsinki', 459);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (465, 'ES', 'Viena', 460);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (474, 'ES', 'Westphalia', 469);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (475, 'ES', 'Roma', 470);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (476, 'ES', 'Bruselas', 471);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (477, 'ES', 'Islandia', 472);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (484, 'ES', 'Noruega', 479);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (485, 'ES', 'Polonia', 480);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (486, 'ES', 'Macedonia', 481);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (487, 'ES', 'Chipre', 482);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (496, 'ES', 'Barcelona', 491);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (497, 'ES', 'Lisboa', 492);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (498, 'ES', 'Genova', 493);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (499, 'ES', 'Roma', 494);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (506, 'ES', 'Imperio Portugues', 501);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (507, 'ES', 'Imperio Británico', 502);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (508, 'ES', 'Imperio Español', 503);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (509, 'ES', 'Imperio Holandés', 504);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (518, 'ES', 'Adolfo Hitler', 513);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (519, 'ES', 'Napoleón', 514);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (520, 'ES', 'Felipe II', 515);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (521, 'ES', 'Julio Cesar', 516);


--
-- TOC entry 2258 (class 0 OID 90347)
-- Dependencies: 187
-- Data for Name: question_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_translation (id, language, help, title, question_id) VALUES (22, 'ES', NULL, '¿Cuál es la capital de Malta?', 21);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (28, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 23);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (34, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 33);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (40, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 35);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (46, 'ES', NULL, '¿Que significa UE?', 45);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (52, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 47);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (62, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 57);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (68, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 67);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (74, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 69);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (84, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 79);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (90, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 89);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (96, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 91);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (131, 'ES', NULL, '¿Cuál es la capital de Malta?', 130);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (137, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 132);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (143, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 142);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (149, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 144);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (155, 'ES', NULL, '¿Que significa UE?', 154);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (161, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 156);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (171, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 166);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (177, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 176);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (183, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 178);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (193, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 188);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (199, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 198);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (205, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 200);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (225, 'ES', NULL, '¿Cuál es la capital de Malta?', 224);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (231, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 226);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (237, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 236);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (243, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 238);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (249, 'ES', NULL, '¿Que significa UE?', 248);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (255, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 250);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (265, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 260);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (271, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 270);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (277, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 272);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (287, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 282);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (293, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 292);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (299, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 294);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (334, 'ES', NULL, '¿Cuál es la capital de Malta?', 333);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (340, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 335);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (346, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 345);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (352, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 347);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (358, 'ES', NULL, '¿Que significa UE?', 357);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (364, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 359);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (374, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 369);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (380, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 379);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (386, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 381);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (396, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 391);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (402, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 401);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (408, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 403);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (443, 'ES', NULL, '¿Cuál es la capital de Malta?', 442);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (449, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 444);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (455, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 454);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (461, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 456);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (467, 'ES', NULL, '¿Que significa UE?', 466);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (473, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 468);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (483, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 478);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (489, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 488);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (495, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 490);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (505, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 500);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (511, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 510);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (517, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 512);


--
-- TOC entry 2271 (class 0 OID 90781)
-- Dependencies: 200
-- Data for Name: questionnaire_answers_12; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2272 (class 0 OID 90789)
-- Dependencies: 201
-- Data for Name: questionnaire_answers_121; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2273 (class 0 OID 90797)
-- Dependencies: 202
-- Data for Name: questionnaire_answers_215; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2274 (class 0 OID 90805)
-- Dependencies: 203
-- Data for Name: questionnaire_answers_324; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_324 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_324 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_324 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_324 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2275 (class 0 OID 90813)
-- Dependencies: 204
-- Data for Name: questionnaire_answers_433; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_433 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_433 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_433 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_433 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2276 (class 0 OID 90821)
-- Dependencies: 205
-- Data for Name: questionnaire_answers_542; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2261 (class 0 OID 90368)
-- Dependencies: 190
-- Data for Name: questionnaire_definition_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (13, 3, NULL, 1, 12);
INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (122, 3, NULL, 1, 121);
INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (216, 3, NULL, 1, 215);
INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (325, 3, NULL, 1, 324);
INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (434, 3, NULL, 1, 433);
INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (543, 3, NULL, 1, 542);


--
-- TOC entry 2256 (class 0 OID 90331)
-- Dependencies: 185
-- Data for Name: questionnaire_definition_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_definition_translation (id, language, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (14, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 12);
INSERT INTO questionnaire_definition_translation (id, language, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (123, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 121);
INSERT INTO questionnaire_definition_translation (id, language, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (217, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 215);
INSERT INTO questionnaire_definition_translation (id, language, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (326, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 324);
INSERT INTO questionnaire_definition_translation (id, language, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (435, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 433);


--
-- TOC entry 2262 (class 0 OID 90373)
-- Dependencies: 191
-- Data for Name: questionnaire_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (107, 3, NULL, 6, 106);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (110, 3, NULL, 4, 109);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (113, 3, NULL, 10, 112);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (116, 3, NULL, 8, 115);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (310, 3, NULL, 6, 309);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (313, 3, NULL, 4, 312);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (316, 3, NULL, 10, 315);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (319, 3, NULL, 8, 318);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (419, 3, NULL, 6, 418);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (422, 3, NULL, 4, 421);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (425, 3, NULL, 10, 424);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (428, 3, NULL, 8, 427);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (528, 3, NULL, 6, 527);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (531, 3, NULL, 4, 530);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (534, 3, NULL, 10, 533);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (537, 3, NULL, 8, 536);


--
-- TOC entry 2263 (class 0 OID 90378)
-- Dependencies: 192
-- Data for Name: research_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (105, 7, NULL, 1, 103);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (120, 7, NULL, 1, 118);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (214, 7, NULL, 1, 212);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (308, 7, NULL, 1, 306);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (323, 7, NULL, 1, 321);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (417, 7, NULL, 1, 415);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (432, 7, NULL, 1, 430);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (526, 7, NULL, 1, 524);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (541, 7, NULL, 1, 539);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (579, 7, NULL, 1, 577);


--
-- TOC entry 2259 (class 0 OID 90355)
-- Dependencies: 188
-- Data for Name: section_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO section_translation (id, language, description, title, section_id) VALUES (16, 'ES', NULL, 'Capitales Europeas', 15);
INSERT INTO section_translation (id, language, description, title, section_id) VALUES (18, 'ES', NULL, 'Unión Europea', 17);
INSERT INTO section_translation (id, language, description, title, section_id) VALUES (20, 'ES', NULL, 'Sociedad', 19);
INSERT INTO section_translation (id, language, description, title, section_id) VALUES (125, 'ES', NULL, 'Capitales Europeas', 124);
INSERT INTO section_translation (id, language, description, title, section_id) VALUES (127, 'ES', NULL, 'Unión Europea', 126);
INSERT INTO section_translation (id, language, description, title, section_id) VALUES (129, 'ES', NULL, 'Sociedad', 128);
INSERT INTO section_translation (id, language, description, title, section_id) VALUES (219, 'ES', NULL, 'Capitales Europeas', 218);
INSERT INTO section_translation (id, language, description, title, section_id) VALUES (221, 'ES', NULL, 'Unión Europea', 220);
INSERT INTO section_translation (id, language, description, title, section_id) VALUES (223, 'ES', NULL, 'Sociedad', 222);
INSERT INTO section_translation (id, language, description, title, section_id) VALUES (328, 'ES', NULL, 'Capitales Europeas', 327);
INSERT INTO section_translation (id, language, description, title, section_id) VALUES (330, 'ES', NULL, 'Unión Europea', 329);
INSERT INTO section_translation (id, language, description, title, section_id) VALUES (332, 'ES', NULL, 'Sociedad', 331);
INSERT INTO section_translation (id, language, description, title, section_id) VALUES (437, 'ES', NULL, 'Capitales Europeas', 436);
INSERT INTO section_translation (id, language, description, title, section_id) VALUES (439, 'ES', NULL, 'Unión Europea', 438);
INSERT INTO section_translation (id, language, description, title, section_id) VALUES (441, 'ES', NULL, 'Sociedad', 440);


--
-- TOC entry 2241 (class 0 OID 90219)
-- Dependencies: 170
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_12_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_121_seq', 0);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_215_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_324_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_433_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('SEQ_GEN', 600);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_542_seq', 0);


--
-- TOC entry 2269 (class 0 OID 90426)
-- Dependencies: 198
-- Data for Name: user_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2264 (class 0 OID 90383)
-- Dependencies: 193
-- Data for Name: user_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (2, 7, NULL, 1, 1);
INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (5, 7, NULL, 1, 4);
INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (7, 7, NULL, 1, 6);
INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (9, 7, NULL, 1, 8);
INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (11, 7, NULL, 1, 10);


--
-- TOC entry 2270 (class 0 OID 90431)
-- Dependencies: 199
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



-- Completed on 2014-10-08 16:57:15

--
-- PostgreSQL database dump complete
--

	
