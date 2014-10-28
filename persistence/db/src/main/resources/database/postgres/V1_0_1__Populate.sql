--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2014-10-28 20:28:42


--
-- TOC entry 2274 (class 0 OID 150177)
-- Dependencies: 196
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, version, createdby_id, directory_id, lastmodifiedby_id) VALUES (1, 'E5FZPQMLZUVUC5Z', NULL, '2014-10-28 20:27:39.079', 'support@gazpacho.net', NULL, 'support', '2014-10-28 20:27:39.079', '', NULL, '283RYAA3ZS4JD33AXAMDWXS973Z58JK8', 'support', 'support', 1, 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, version, createdby_id, directory_id, lastmodifiedby_id) VALUES (4, 'V4ETEEAEHTK4UTN', NULL, '2014-10-28 20:27:39.188', 'tyrion.lannister@kingslanding.net', 'M', 'Tyrion', '2014-10-28 20:27:39.188', '', NULL, 'AFQ2FYAPQQ3RNMJZEVF7Z29DG8BP8QU4', 'Lannister', NULL, 1, 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, version, createdby_id, directory_id, lastmodifiedby_id) VALUES (6, 'WC2PX22TLCT8C7P', NULL, '2014-10-28 20:27:39.219', 'jon.snow@nightswatch.net', 'M', 'Jon', '2014-10-28 20:27:39.219', '', 'ES', 'MU9GQQ92AZFNLBB3ZN3UWZRJ5S56UXD5', 'Snow', NULL, 1, 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, version, createdby_id, directory_id, lastmodifiedby_id) VALUES (8, 'L52U43QWSQGZDLK', NULL, '2014-10-28 20:27:39.235', 'arya.stark@winterfell.net', 'F', 'Arya', '2014-10-28 20:27:39.235', '', 'EN', 'HJWU6GLZYHAK3KQLEBN22TX2XMMV6FJM', 'Stark', NULL, 1, 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, version, createdby_id, directory_id, lastmodifiedby_id) VALUES (10, 'RG5N3V2Y7C3CN6K', NULL, '2014-10-28 20:27:39.266', 'catelyn.stark@winterfell.net', 'F', 'Catelyn', '2014-10-28 20:27:39.266', '', 'FI', 'TPHGT6H8ALEJ7QGTYBVFNNRYX5Z6RDKL', 'Stark', NULL, 1, 1, NULL, 1);


--
-- TOC entry 2256 (class 0 OID 150048)
-- Dependencies: 178
-- Data for Name: questionnaire_definition; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_number_visible, questions_per_page, randomization_strategy, rendering_mode, section_info_visible, status, version, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (12, '2014-10-28 20:27:39.329', 'EN', '2014-10-28 20:27:39.329', true, true, NULL, 'N', 'SBS', true, 'C', 2, true, 'How much do you know about Europe? Answer to this questions and let''s find out!', '', 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_number_visible, questions_per_page, randomization_strategy, rendering_mode, section_info_visible, status, version, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (121, '2014-10-28 20:27:43.069', 'EN', '2014-10-28 20:27:43.069', true, true, NULL, 'N', 'AIO', true, 'C', 3, true, 'How much do you know about Europe? Answer to this questions and let''s find out!', '', 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_number_visible, questions_per_page, randomization_strategy, rendering_mode, section_info_visible, status, version, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (215, '2014-10-28 20:27:45.216', 'EN', '2014-10-28 20:27:45.216', true, true, 1, 'Q', 'SBS', true, 'C', 3, true, 'How much do you know about Europe? Answer to this questions and let''s find out!', '', 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_number_visible, questions_per_page, randomization_strategy, rendering_mode, section_info_visible, status, version, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (324, '2014-10-28 20:27:47.895', 'EN', '2014-10-28 20:27:47.895', true, true, NULL, 'S', 'SBS', true, 'C', 3, true, 'How much do you know about Europe? Answer to this questions and let''s find out!', '', 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_number_visible, questions_per_page, randomization_strategy, rendering_mode, section_info_visible, status, version, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (433, '2014-10-28 20:27:49.874', 'EN', '2014-10-28 20:27:49.874', true, true, NULL, 'N', 'SBS', true, 'C', 2, true, 'How much do you know about Europe? Answer to this questions and let''s find out!', '', 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_number_visible, questions_per_page, randomization_strategy, rendering_mode, section_info_visible, status, version, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (542, '2014-10-28 20:27:52.404', 'EN', '2014-10-28 20:27:52.404', true, true, NULL, 'N', 'SBS', true, 'C', 2, true, 'We at BIG DEES take pride in providing you with the highest standards of QUALITY, SERVICE, CLEANLINESS and VALUE in the restaurant industry.', '', 'Food Quality QuestionnaireDefinition', 'Your opinion is extremely important in evaluating our business. Thank you for taking a moment to questionOption the following questions:', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_number_visible, questions_per_page, randomization_strategy, rendering_mode, section_info_visible, status, version, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (580, '2014-10-28 20:27:53.658', 'EN', '2014-10-28 20:27:53.658', true, true, NULL, 'N', 'QBQ', true, 'C', 2, true, 'Gathering insight into Java performance world to improve our product offering.', '', 'Java Performance Tunning Survey', '<p>Each respondent will receive a subscription to use our performance monitoring solution and participates in a draw of 10 Amazon gift certificates worth $100 each. To top it off, we will also share the results of the survey with you.</p><p>Answering to the 10 questions will take less than 3 minutes of your time.</p>', 1, 1);


--
-- TOC entry 2259 (class 0 OID 150072)
-- Dependencies: 181
-- Data for Name: section; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (15, '2014-10-28 20:27:39.422', 'EN', '2014-10-28 20:27:39.422', false, '', 1, '', 'European Capitals', 1, 1, 12, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (17, '2014-10-28 20:27:39.501', 'EN', '2014-10-28 20:27:39.501', false, '', 1, '', 'European Union', 1, 1, 12, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (19, '2014-10-28 20:27:39.563', 'EN', '2014-10-28 20:27:39.563', false, '', 1, '', 'European History', 1, 1, 12, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (124, '2014-10-28 20:27:43.116', 'EN', '2014-10-28 20:27:43.116', false, '', 1, '', 'European Capitals', 1, 1, 121, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (126, '2014-10-28 20:27:43.147', 'EN', '2014-10-28 20:27:43.147', false, '', 1, '', 'European Union', 1, 1, 121, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (128, '2014-10-28 20:27:43.194', 'EN', '2014-10-28 20:27:43.194', false, '', 1, '', 'European History', 1, 1, 121, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (218, '2014-10-28 20:27:45.262', 'EN', '2014-10-28 20:27:45.262', false, '', 1, '', 'European Capitals', 1, 1, 215, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (220, '2014-10-28 20:27:45.309', 'EN', '2014-10-28 20:27:45.309', false, '', 1, '', 'European Union', 1, 1, 215, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (222, '2014-10-28 20:27:45.419', 'EN', '2014-10-28 20:27:45.419', false, '', 1, '', 'European History', 1, 1, 215, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (327, '2014-10-28 20:27:47.931', 'EN', '2014-10-28 20:27:47.931', false, '', 1, '', 'European Capitals', 1, 1, 324, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (329, '2014-10-28 20:27:47.966', 'EN', '2014-10-28 20:27:47.966', false, '', 1, '', 'European Union', 1, 1, 324, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (331, '2014-10-28 20:27:48.003', 'EN', '2014-10-28 20:27:48.003', false, '', 1, '', 'European History', 1, 1, 324, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (438, '2014-10-28 20:27:49.952', 'EN', '2014-10-28 20:27:49.952', false, '', 1, '', 'European Union', 1, 1, 433, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (440, '2014-10-28 20:27:49.999', 'EN', '2014-10-28 20:27:49.999', false, '', 1, '', 'European History', 1, 1, 433, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (436, '2014-10-28 20:27:49.921', 'EN', '2014-10-28 20:27:49.921', true, '', 2, '', 'European Capitals', 1, 1, 433, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (544, '2014-10-28 20:27:52.436', 'EN', '2014-10-28 20:27:52.436', false, '', 1, '', 'Fast Food QuestionnaireDefinition - Section', 1, 1, 542, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (581, '2014-10-28 20:27:53.658', 'EN', '2014-10-28 20:27:53.658', false, '', 1, '', '', 1, 1, 580, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (586, '2014-10-28 20:27:54.018', 'EN', '2014-10-28 20:27:54.018', false, '${q1==''yes''}', 1, '', 'In case you faced several performance issues during the past year, describe just one while answering the following questions.', 1, 1, 580, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (587, '2014-10-28 20:27:54.127', 'EN', '2014-10-28 20:27:54.127', false, '', 1, '', '', 1, 1, 580, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (655, '2014-10-28 20:27:55.446', 'EN', '2014-10-28 20:27:55.446', false, '${q1==''no''}', 1, '', 'As you do not seem to have faced any performance issues with Java applications, the rest of the survey questions were not applicable. But we are still happy to offer you the possibility to get access to 3-months license and participate in Amazon gift card raffle.', 1, 1, 580, 3);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, relevance, version, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (656, '2014-10-28 20:27:55.571', 'EN', '2014-10-28 20:27:55.571', false, '', 1, 'This data will be used to contact the winners of the Amazon gift card raffle, hand out free licenses and publish the survey results.', 'To finish the survey and submit results, please complete all fields below:', 1, 1, 580, 4);


--
-- TOC entry 2254 (class 0 OID 150035)
-- Dependencies: 176
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (21, 'Q1', '2014-10-28 20:27:39.626', 'EN', '2014-10-28 20:27:39.626', false, '', true, 'S', 1, '', 'What is the capital of Malta?', 1, 1, NULL, 15, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (23, 'Q2', '2014-10-28 20:27:39.704', 'EN', '2014-10-28 20:27:39.704', false, '', true, 'L', 1, '', 'Which the country has as capital Copenhague?', 1, 1, NULL, 15, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (33, 'Q3', '2014-10-28 20:27:40.195', 'EN', '2014-10-28 20:27:40.195', false, '', true, 'N', 1, '', 'How many European capitals were founded by Romans?', 1, 1, NULL, 15, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (35, 'Q4', '2014-10-28 20:27:40.32', 'EN', '2014-10-28 20:27:40.32', false, '', false, 'M', 1, '', 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 15, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (45, 'Q5', '2014-10-28 20:27:40.492', 'EN', '2014-10-28 20:27:40.492', false, '', true, 'S', 1, '', 'What does EU stand for??', 1, 1, NULL, 17, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (47, 'Q6', '2014-10-28 20:27:40.57', 'EN', '2014-10-28 20:27:40.57', false, '', true, 'L', 1, '', 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 17, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (57, 'Q7', '2014-10-28 20:27:40.851', 'EN', '2014-10-28 20:27:40.851', false, '', false, 'M', 1, '', 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 17, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (67, 'Q8', '2014-10-28 20:27:41.389', 'EN', '2014-10-28 20:27:41.389', false, '', true, 'N', 1, '', 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 17, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (69, 'Q9', '2014-10-28 20:27:41.499', 'EN', '2014-10-28 20:27:41.499', false, '', true, 'L', 1, '', 'Where was Christopher columbus was born?', 1, 1, NULL, 19, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (79, 'Q10', '2014-10-28 20:27:41.874', 'EN', '2014-10-28 20:27:41.874', false, '', true, 'L', 1, '', 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 19, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (89, 'Q11', '2014-10-28 20:27:41.999', 'EN', '2014-10-28 20:27:41.999', false, '', true, 'S', 1, '', 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 19, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (91, 'Q12', '2014-10-28 20:27:42.065', 'EN', '2014-10-28 20:27:42.065', false, '', true, 'L', 1, '', 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 19, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (130, 'Q1', '2014-10-28 20:27:43.241', 'EN', '2014-10-28 20:27:43.241', false, '', true, 'S', 1, '', 'What is the capital of Malta?', 1, 1, NULL, 124, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (132, 'Q2', '2014-10-28 20:27:43.287', 'EN', '2014-10-28 20:27:43.287', false, '', true, 'L', 1, '', 'Which the country has as capital Copenhague?', 1, 1, NULL, 124, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (142, 'Q3', '2014-10-28 20:27:43.397', 'EN', '2014-10-28 20:27:43.397', false, '', true, 'N', 1, '', 'How many European capitals were founded by Romans?', 1, 1, NULL, 124, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (144, 'Q4', '2014-10-28 20:27:43.461', 'EN', '2014-10-28 20:27:43.461', false, '', false, 'M', 1, '', 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 124, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (154, 'Q5', '2014-10-28 20:27:43.586', 'EN', '2014-10-28 20:27:43.586', false, '', true, 'S', 1, '', 'What does EU stand for??', 1, 1, NULL, 126, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (156, 'Q6', '2014-10-28 20:27:43.617', 'EN', '2014-10-28 20:27:43.617', false, '', true, 'L', 1, '', 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 126, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (166, 'Q7', '2014-10-28 20:27:43.742', 'EN', '2014-10-28 20:27:43.742', false, '', false, 'M', 1, '', 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 126, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (176, 'Q8', '2014-10-28 20:27:43.852', 'EN', '2014-10-28 20:27:43.852', false, '', true, 'N', 1, '', 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 126, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (178, 'Q9', '2014-10-28 20:27:43.914', 'EN', '2014-10-28 20:27:43.914', false, '', true, 'L', 1, '', 'Where was Christopher columbus was born?', 1, 1, NULL, 128, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (188, 'Q10', '2014-10-28 20:27:44.024', 'EN', '2014-10-28 20:27:44.024', false, '', true, 'L', 1, '', 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 128, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (198, 'Q11', '2014-10-28 20:27:44.18', 'EN', '2014-10-28 20:27:44.18', false, '', true, 'S', 1, '', 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 128, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (200, 'Q12', '2014-10-28 20:27:44.243', 'EN', '2014-10-28 20:27:44.243', false, '', true, 'L', 1, '', 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 128, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (224, 'Q1', '2014-10-28 20:27:45.497', 'EN', '2014-10-28 20:27:45.497', false, '', true, 'S', 1, '', 'What is the capital of Malta?', 1, 1, NULL, 218, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (226, 'Q2', '2014-10-28 20:27:45.591', 'EN', '2014-10-28 20:27:45.591', false, '', true, 'L', 1, '', 'Which the country has as capital Copenhague?', 1, 1, NULL, 218, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (236, 'Q3', '2014-10-28 20:27:45.731', 'EN', '2014-10-28 20:27:45.731', false, '', true, 'N', 1, '', 'How many European capitals were founded by Romans?', 1, 1, NULL, 218, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (238, 'Q4', '2014-10-28 20:27:45.809', 'EN', '2014-10-28 20:27:45.809', false, '', false, 'M', 1, '', 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 218, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (248, 'Q5', '2014-10-28 20:27:45.966', 'EN', '2014-10-28 20:27:45.966', false, '', true, 'S', 1, '', 'What does EU stand for??', 1, 1, NULL, 220, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (250, 'Q6', '2014-10-28 20:27:45.997', 'EN', '2014-10-28 20:27:45.997', false, '', true, 'L', 1, '', 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 220, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (260, 'Q7', '2014-10-28 20:27:46.124', 'EN', '2014-10-28 20:27:46.124', false, '', false, 'M', 1, '', 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 220, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (270, 'Q8', '2014-10-28 20:27:46.294', 'EN', '2014-10-28 20:27:46.294', false, '', true, 'N', 1, '', 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 220, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (272, 'Q9', '2014-10-28 20:27:46.357', 'EN', '2014-10-28 20:27:46.357', false, '', true, 'L', 1, '', 'Where was Christopher columbus was born?', 1, 1, NULL, 222, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (282, 'Q10', '2014-10-28 20:27:46.53', 'EN', '2014-10-28 20:27:46.53', false, '', true, 'L', 1, '', 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 222, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (292, 'Q11', '2014-10-28 20:27:46.802', 'EN', '2014-10-28 20:27:46.802', false, '', true, 'S', 1, '', 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 222, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (294, 'Q12', '2014-10-28 20:27:46.872', 'EN', '2014-10-28 20:27:46.872', false, '', true, 'L', 1, '', 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 222, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (333, 'Q1', '2014-10-28 20:27:48.039', 'EN', '2014-10-28 20:27:48.039', false, '', true, 'S', 1, '', 'What is the capital of Malta?', 1, 1, NULL, 327, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (335, 'Q2', '2014-10-28 20:27:48.076', 'EN', '2014-10-28 20:27:48.076', false, '', true, 'L', 1, '', 'Which the country has as capital Copenhague?', 1, 1, NULL, 327, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (345, 'Q3', '2014-10-28 20:27:48.184', 'EN', '2014-10-28 20:27:48.184', false, '', true, 'N', 1, '', 'How many European capitals were founded by Romans?', 1, 1, NULL, 327, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (347, 'Q4', '2014-10-28 20:27:48.23', 'EN', '2014-10-28 20:27:48.23', false, '', false, 'M', 1, '', 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 327, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (357, 'Q5', '2014-10-28 20:27:48.339', 'EN', '2014-10-28 20:27:48.339', false, '', true, 'S', 1, '', 'What does EU stand for??', 1, 1, NULL, 329, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (359, 'Q6', '2014-10-28 20:27:48.37', 'EN', '2014-10-28 20:27:48.37', false, '', true, 'L', 1, '', 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 329, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (369, 'Q7', '2014-10-28 20:27:48.48', 'EN', '2014-10-28 20:27:48.48', false, '', false, 'M', 1, '', 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 329, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (379, 'Q8', '2014-10-28 20:27:48.589', 'EN', '2014-10-28 20:27:48.589', false, '', true, 'N', 1, '', 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 329, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (381, 'Q9', '2014-10-28 20:27:48.636', 'EN', '2014-10-28 20:27:48.636', false, '', true, 'L', 1, '', 'Where was Christopher columbus was born?', 1, 1, NULL, 331, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (391, 'Q10', '2014-10-28 20:27:48.714', 'EN', '2014-10-28 20:27:48.714', false, '', true, 'L', 1, '', 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 331, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (401, 'Q11', '2014-10-28 20:27:48.808', 'EN', '2014-10-28 20:27:48.808', false, '', true, 'S', 1, '', 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 331, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (403, 'Q12', '2014-10-28 20:27:48.87', 'EN', '2014-10-28 20:27:48.87', false, '', true, 'L', 1, '', 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 331, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (442, 'Q1', '2014-10-28 20:27:50.031', 'EN', '2014-10-28 20:27:50.031', false, '', true, 'S', 1, '', 'What is the capital of Malta?', 1, 1, NULL, 436, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (444, 'Q2', '2014-10-28 20:27:50.067', 'EN', '2014-10-28 20:27:50.067', false, '', true, 'L', 1, '', 'Which the country has as capital Copenhague?', 1, 1, NULL, 436, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (454, 'Q3', '2014-10-28 20:27:50.161', 'EN', '2014-10-28 20:27:50.161', false, '', true, 'N', 1, '', 'How many European capitals were founded by Romans?', 1, 1, NULL, 436, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (468, 'Q6', '2014-10-28 20:27:50.332', 'EN', '2014-10-28 20:27:50.332', false, '', true, 'L', 1, '', 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 438, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (510, 'Q11', '2014-10-28 20:27:50.989', 'EN', '2014-10-28 20:27:50.989', false, '', true, 'S', 1, '', 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 440, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (545, 'Q1', '2014-10-28 20:27:52.482', 'EN', '2014-10-28 20:27:52.482', false, '', true, 'F', 1, '', '<b>Food Quality</b>', 1, 1, NULL, 544, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (552, 'Q1.1', '2014-10-28 20:27:52.498', 'EN', '2014-10-28 20:27:52.498', false, '', false, 'L', 1, '', 'The food is served hot and fresh', 1, 1, 545, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (553, 'Q1.2', '2014-10-28 20:27:52.498', 'EN', '2014-10-28 20:27:52.498', false, '', false, 'L', 1, '', 'The menu has a good variety of items', 1, 1, 545, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (554, 'Q1.3', '2014-10-28 20:27:52.498', 'EN', '2014-10-28 20:27:52.498', false, '', false, 'L', 1, '', 'The quality of food is excellent', 1, 1, 545, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (555, 'Q1.4', '2014-10-28 20:27:52.498', 'EN', '2014-10-28 20:27:52.498', false, '', false, 'L', 1, '', 'The food is tasty and flavorful', 1, 1, 545, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (601, 'Q5', '2014-10-28 20:27:54.441', 'EN', '2014-10-28 20:27:54.441', true, '', false, 'M', 1, '', 'Which monitoring software were you using to monitor Java application in production?', 1, 1, NULL, 587, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (648, 'Q9', '2014-10-28 20:27:55.082', 'EN', '2014-10-28 20:27:55.082', false, '', false, 'L', 1, '', 'How long did it take you to detect and fix the root cause of the performance issue ? ', 1, 1, NULL, 587, NULL, 7);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (456, 'Q4', '2014-10-28 20:27:50.207', 'EN', '2014-10-28 20:27:50.207', false, '', false, 'M', 1, '', 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 436, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (466, 'Q5', '2014-10-28 20:27:50.301', 'EN', '2014-10-28 20:27:50.301', false, '', true, 'S', 1, '', 'What does EU stand for??', 1, 1, NULL, 438, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (478, 'Q7', '2014-10-28 20:27:50.645', 'EN', '2014-10-28 20:27:50.645', false, '', false, 'M', 1, '', 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 438, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (488, 'Q8', '2014-10-28 20:27:50.754', 'EN', '2014-10-28 20:27:50.754', false, '', true, 'N', 1, '', 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 438, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (490, 'Q9', '2014-10-28 20:27:50.801', 'EN', '2014-10-28 20:27:50.801', false, '', true, 'L', 1, '', 'Where was Christopher columbus was born?', 1, 1, NULL, 440, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (512, 'Q12', '2014-10-28 20:27:51.036', 'EN', '2014-10-28 20:27:51.036', false, '', true, 'L', 1, '', 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 440, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (593, 'Q3', '2014-10-28 20:27:54.285', 'EN', '2014-10-28 20:27:54.285', true, '', false, 'M', 1, '', 'How did you find out that your Java application is facing the issue?', 1, 1, NULL, 587, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (658, 'Q12', '2014-10-28 20:27:55.729', 'EN', '2014-10-28 20:27:55.729', false, '', true, 'S', 1, '', 'Company', 1, 1, NULL, 656, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (500, 'Q10', '2014-10-28 20:27:50.879', 'EN', '2014-10-28 20:27:50.879', false, '', true, 'L', 1, '', 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 440, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (617, 'Q6', '2014-10-28 20:27:54.582', 'EN', '2014-10-28 20:27:54.582', true, '', false, 'M', 1, '', 'After understanding that your Java application has a performance issue, what tools / sources did you use to locate the root cause?', 1, 1, NULL, 587, NULL, 4);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (633, 'Q8', '2014-10-28 20:27:54.8', 'EN', '2014-10-28 20:27:54.8', true, '', false, 'M', 1, '', 'What was the root cause for the performance issue?', 1, 1, NULL, 587, NULL, 6);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (556, 'Q2', '2014-10-28 20:27:52.701', 'EN', '2014-10-28 20:27:52.701', false, '', true, 'F', 1, '', '<b>Resturant</b>', 1, 1, NULL, 544, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (563, 'Q2.1', '2014-10-28 20:27:52.717', 'EN', '2014-10-28 20:27:52.717', false, '', false, 'L', 1, '', 'My food order was correct and complete', 1, 1, 556, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (564, 'Q2.2', '2014-10-28 20:27:52.717', 'EN', '2014-10-28 20:27:52.717', false, '', false, 'L', 1, '', 'Employees are patient when taking my order', 1, 1, 556, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (565, 'Q2.3', '2014-10-28 20:27:52.717', 'EN', '2014-10-28 20:27:52.717', false, '', false, 'L', 1, '', 'I was served promptly', 1, 1, 556, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (566, 'Q2.4', '2014-10-28 20:27:52.717', 'EN', '2014-10-28 20:27:52.717', false, '', false, 'L', 1, '', 'Availability of sauces, utensils, napkins, etc. was good', 1, 1, 556, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (567, 'Q2.5', '2014-10-28 20:27:52.717', 'EN', '2014-10-28 20:27:52.717', false, '', false, 'L', 1, '', 'The menu board was easy to read', 1, 1, 556, NULL, 4, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (568, 'Q2.6', '2014-10-28 20:27:52.717', 'EN', '2014-10-28 20:27:52.717', false, '', false, 'L', 1, '', 'The drive-thru sound system was cleara', 1, 1, 556, NULL, 5, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (569, 'Q3', '2014-10-28 20:27:52.873', 'EN', '2014-10-28 20:27:52.873', false, '', true, 'L', 1, '', 'Indicate total household income', 1, 1, NULL, 544, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (583, 'Q1', '2014-10-28 20:27:53.69', 'EN', '2014-10-28 20:27:53.69', false, '', true, 'L', 1, '', 'Have you faced any Java performance issues during the past 12 months? ', 1, 1, NULL, 581, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (588, 'Q2', '2014-10-28 20:27:54.222', 'EN', '2014-10-28 20:27:54.222', true, '', false, 'M', 1, '', 'What were the symptoms surfacing the performance issue?', 1, 1, NULL, 587, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (657, 'Q11', '2014-10-28 20:27:55.698', 'EN', '2014-10-28 20:27:55.698', false, '', true, 'S', 1, '', 'Name', 1, 1, NULL, 656, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (597, 'Q4', '2014-10-28 20:27:54.347', 'EN', '2014-10-28 20:27:54.347', false, '', false, 'L', 1, '', 'Was the performance issue affecting end users? ', 1, 1, NULL, 587, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (654, 'Q10', '2014-10-28 20:27:55.352', 'EN', '2014-10-28 20:27:55.352', false, '', false, 'T', 1, '', 'What was the most time consuming part of the process? ', 1, 1, NULL, 587, NULL, 8);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (659, 'Q13', '2014-10-28 20:27:55.948', 'EN', '2014-10-28 20:27:55.948', true, '', false, 'L', 1, '', 'Role', 1, 1, NULL, 656, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, relevance, required, type, version, explanation, title, createdby_id, lastmodifiedby_id, parent_id, section_id, order_in_subquestions, order_in_section) VALUES (629, 'Q7', '2014-10-28 20:27:54.707', 'EN', '2014-10-28 20:27:54.707', false, '', false, 'L', 1, '', 'Were you able to reproduce the performance issue in the test/development environment?', 1, 1, NULL, 587, NULL, 5);


--
-- TOC entry 2258 (class 0 OID 150064)
-- Dependencies: 180
-- Data for Name: research; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (103, '2014-10-28 20:27:42.69', '2014-10-28 20:27:42.675', '2014-10-28 20:27:42.69', 'New QuizEuropean general knowledge quiz started', '2014-10-28 20:27:42.675', 'C', 'P', 2, 1, 1, 12);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (118, '2014-10-28 20:27:43.037', '2014-10-28 20:27:43.022', '2014-10-28 20:27:43.037', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-10-28 20:27:43.022', 'D', 'O', 1, 1, 1, 12);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (212, '2014-10-28 20:27:45.184', '2014-10-28 20:27:45.153', '2014-10-28 20:27:45.184', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-10-28 20:27:45.153', 'D', 'O', 1, 1, 1, 121);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (306, '2014-10-28 20:27:47.563', '2014-10-28 20:27:47.545', '2014-10-28 20:27:47.563', 'New QuizEuropean general knowledge quiz started', '2014-10-28 20:27:47.544', 'C', 'P', 2, 1, 1, 215);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (321, '2014-10-28 20:27:47.869', '2014-10-28 20:27:47.847', '2014-10-28 20:27:47.869', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-10-28 20:27:47.847', 'D', 'O', 1, 1, 1, 215);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (415, '2014-10-28 20:27:49.593', '2014-10-28 20:27:49.577', '2014-10-28 20:27:49.593', 'New QuizEuropean general knowledge quiz started', '2014-10-28 20:27:49.577', 'C', 'P', 2, 1, 1, 324);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (430, '2014-10-28 20:27:49.859', '2014-10-28 20:27:49.843', '2014-10-28 20:27:49.859', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-10-28 20:27:49.843', 'D', 'O', 1, 1, 1, 324);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (524, '2014-10-28 20:27:52.085', '2014-10-28 20:27:52.07', '2014-10-28 20:27:52.085', 'New QuizEuropean general knowledge quiz started', '2014-10-28 20:27:52.07', 'C', 'P', 2, 1, 1, 433);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (539, '2014-10-28 20:27:52.373', '2014-10-28 20:27:52.373', '2014-10-28 20:27:52.373', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-10-28 20:27:52.373', 'D', 'O', 1, 1, 1, 433);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (577, '2014-10-28 20:27:53.565', '2014-10-28 20:27:53.565', '2014-10-28 20:27:53.565', 'New customer satisfation survey Food Quality QuestionnaireDefinition started', '2014-10-28 20:27:53.565', 'D', 'O', 1, 1, 1, 542);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, status, type, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (668, '2014-10-28 20:27:56.562', '2014-10-28 20:27:56.515', '2014-10-28 20:27:56.562', 'Java Performance Survey Java Performance Tunning Survey started', '2014-10-28 20:27:56.515', 'D', 'O', 1, 1, 1, 580);


--
-- TOC entry 2255 (class 0 OID 150043)
-- Dependencies: 177
-- Data for Name: questionnaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (106, 1, '2014-10-28 20:27:42.753', '2014-10-28 20:27:42.753', 'C', NULL, 2, 1, 1, 12, 103, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (109, 2, '2014-10-28 20:27:42.831', '2014-10-28 20:27:42.831', 'C', NULL, 2, 1, 1, 12, 103, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (112, 3, '2014-10-28 20:27:42.893', '2014-10-28 20:27:42.893', 'C', NULL, 2, 1, 1, 12, 103, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (115, 4, '2014-10-28 20:27:42.94', '2014-10-28 20:27:42.94', 'C', NULL, 2, 1, 1, 12, 103, 8);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (309, 1, '2014-10-28 20:27:47.6', '2014-10-28 20:27:47.6', 'C', NULL, 2, 1, 1, 215, 306, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (312, 2, '2014-10-28 20:27:47.673', '2014-10-28 20:27:47.673', 'C', NULL, 2, 1, 1, 215, 306, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (315, 3, '2014-10-28 20:27:47.727', '2014-10-28 20:27:47.727', 'C', NULL, 2, 1, 1, 215, 306, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (318, 4, '2014-10-28 20:27:47.777', '2014-10-28 20:27:47.777', 'C', NULL, 2, 1, 1, 215, 306, 8);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (418, 1, '2014-10-28 20:27:49.624', '2014-10-28 20:27:49.624', 'C', NULL, 2, 1, 1, 324, 415, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (421, 2, '2014-10-28 20:27:49.687', '2014-10-28 20:27:49.687', 'C', NULL, 2, 1, 1, 324, 415, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (424, 3, '2014-10-28 20:27:49.734', '2014-10-28 20:27:49.734', 'C', NULL, 2, 1, 1, 324, 415, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (427, 4, '2014-10-28 20:27:49.78', '2014-10-28 20:27:49.78', 'C', NULL, 2, 1, 1, 324, 415, 8);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (527, 1, '2014-10-28 20:27:52.123', '2014-10-28 20:27:52.123', 'C', NULL, 2, 1, 1, 433, 524, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (530, 2, '2014-10-28 20:27:52.186', '2014-10-28 20:27:52.186', 'C', NULL, 2, 1, 1, 433, 524, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (533, 3, '2014-10-28 20:27:52.232', '2014-10-28 20:27:52.232', 'C', NULL, 2, 1, 1, 433, 524, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, version, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (536, 4, '2014-10-28 20:27:52.279', '2014-10-28 20:27:52.279', 'C', NULL, 2, 1, 1, 433, 524, 8);


--
-- TOC entry 2249 (class 0 OID 149998)
-- Dependencies: 171
-- Data for Name: breadcrumb; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2273 (class 0 OID 150169)
-- Dependencies: 195
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2266 (class 0 OID 150128)
-- Dependencies: 188
-- Data for Name: directory_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2272 (class 0 OID 150161)
-- Dependencies: 194
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO groups (id, created_date, description, last_modified_date, name, version, createdby_id, lastmodifiedby_id) VALUES (3, '2014-10-28 20:27:39.157', 'Respondent group', '2014-10-28 20:27:39.157', 'Respondents', 1, 1, 1);


--
-- TOC entry 2248 (class 0 OID 149990)
-- Dependencies: 170
-- Data for Name: invitation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (104, 'A', 'A', 'B2WQX68YTF', 1, 103, NULL);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (108, 'P', 'A', 'MG73SS2GYM', 1, 103, 6);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (111, 'P', 'A', '8WJAJ2VSNT', 1, 103, 4);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (114, 'P', 'A', 'KRU4V24X9Y', 1, 103, 10);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (117, 'P', 'A', 'JWPRYAJXLY', 1, 103, 8);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (119, 'A', 'A', 'G4EWDVFEPE', 1, 118, NULL);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (213, 'A', 'A', '2J5BK3F5SG', 1, 212, NULL);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (307, 'A', 'A', 'MV8ADVCDHT', 1, 306, NULL);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (311, 'P', 'A', 'B3X95KESWQ', 1, 306, 6);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (314, 'P', 'A', 'FW74HXC3QE', 1, 306, 4);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (317, 'P', 'A', 'WTTZGX23YA', 1, 306, 10);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (320, 'P', 'A', 'JHM6CYHGWG', 1, 306, 8);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (322, 'A', 'A', '8PARVKWUY5', 1, 321, NULL);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (416, 'A', 'A', '3JVM5M8NUC', 1, 415, NULL);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (420, 'P', 'A', 'KYQ8RE3TWP', 1, 415, 6);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (423, 'P', 'A', 'U784JFCBUG', 1, 415, 4);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (426, 'P', 'A', '33F97K667T', 1, 415, 10);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (429, 'P', 'A', '6SUP2NEMND', 1, 415, 8);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (431, 'A', 'A', '7LZ57NTZW2', 1, 430, NULL);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (525, 'A', 'A', 'N4TWC73SLE', 1, 524, NULL);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (529, 'P', 'A', 'JCLL4GZLPC', 1, 524, 6);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (532, 'P', 'A', 'VCST2LNQGE', 1, 524, 4);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (535, 'P', 'A', 'DPMKWCF34R', 1, 524, 10);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (538, 'P', 'A', 'EPZKCASUWY', 1, 524, 8);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (540, 'A', 'A', 'D7HNJXUGH9', 1, 539, NULL);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (578, 'A', 'A', 'H4R2CLSMLK', 1, 577, NULL);
INSERT INTO invitation (id, type, status, token, version, research_id, respondent_id) VALUES (669, 'A', 'A', 'QEBAJE8WFF', 1, 668, NULL);


--
-- TOC entry 2251 (class 0 OID 150011)
-- Dependencies: 173
-- Data for Name: label_set; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2250 (class 0 OID 150003)
-- Dependencies: 172
-- Data for Name: label; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2260 (class 0 OID 150080)
-- Dependencies: 182
-- Data for Name: label_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2252 (class 0 OID 150019)
-- Dependencies: 174
-- Data for Name: mail_message; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2253 (class 0 OID 150027)
-- Dependencies: 175
-- Data for Name: mail_message_template; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, version, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (101, '2014-10-28 20:27:42.221', 'support@gazpacho.net', 'EN', '2014-10-28 20:27:42.221', 'support@gazpacho.net', 'INVITATION', 1, 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 12);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, version, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (210, '2014-10-28 20:27:44.68', 'support@gazpacho.net', 'EN', '2014-10-28 20:27:44.68', 'support@gazpacho.net', 'INVITATION', 1, 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 121);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, version, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (304, '2014-10-28 20:27:47.163', 'support@gazpacho.net', 'EN', '2014-10-28 20:27:47.163', 'support@gazpacho.net', 'INVITATION', 1, 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 215);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, version, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (413, '2014-10-28 20:27:49.091', 'support@gazpacho.net', 'EN', '2014-10-28 20:27:49.091', 'support@gazpacho.net', 'INVITATION', 1, 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 324);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, version, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (522, '2014-10-28 20:27:51.179', 'support@gazpacho.net', 'EN', '2014-10-28 20:27:51.179', 'support@gazpacho.net', 'INVITATION', 1, 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 433);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, version, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (575, '2014-10-28 20:27:53.014', 'support@gazpacho.net', 'EN', '2014-10-28 20:27:53.014', 'support@gazpacho.net', 'INVITATION', 1, 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 542);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, version, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (666, '2014-10-28 20:27:56.01', 'support@gazpacho.net', 'EN', '2014-10-28 20:27:56.01', 'support@gazpacho.net', 'INVITATION', 1, 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 580);


--
-- TOC entry 2261 (class 0 OID 150088)
-- Dependencies: 183
-- Data for Name: mail_message_template_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, version, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (102, '2014-10-28 20:27:42.253', 'ES', '2014-10-28 20:27:42.253', 1, 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 101);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, version, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (211, '2014-10-28 20:27:44.696', 'ES', '2014-10-28 20:27:44.696', 1, 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 210);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, version, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (305, '2014-10-28 20:27:47.181', 'ES', '2014-10-28 20:27:47.181', 1, 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 304);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, version, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (414, '2014-10-28 20:27:49.091', 'ES', '2014-10-28 20:27:49.091', 1, 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 413);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, version, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (523, '2014-10-28 20:27:51.195', 'ES', '2014-10-28 20:27:51.195', 1, 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 522);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, version, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (576, '2014-10-28 20:27:53.045', 'ES', '2014-10-28 20:27:53.045', 1, 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 575);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, version, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (667, '2014-10-28 20:27:56.026', 'ES', '2014-10-28 20:27:56.026', 1, 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 666);


--
-- TOC entry 2257 (class 0 OID 150056)
-- Dependencies: 179
-- Data for Name: question_option; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (24, 'O1', '2014-10-28 20:27:39.704', 'EN', '2014-10-28 20:27:39.704', 1, 'Norway', 1, 1, 23, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (25, 'O2', '2014-10-28 20:27:39.719', 'EN', '2014-10-28 20:27:39.719', 1, 'Sweden', 1, 1, 23, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (26, 'O3', '2014-10-28 20:27:39.719', 'EN', '2014-10-28 20:27:39.719', 1, 'Denmark', 1, 1, 23, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (27, 'O4', '2014-10-28 20:27:39.719', 'EN', '2014-10-28 20:27:39.719', 1, 'Iceland', 1, 1, 23, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (36, 'O1', '2014-10-28 20:27:40.32', 'EN', '2014-10-28 20:27:40.32', 1, 'Vatican City', 1, 1, 35, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (37, 'O2', '2014-10-28 20:27:40.32', 'EN', '2014-10-28 20:27:40.32', 1, 'Roma', 1, 1, 35, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (38, 'O3', '2014-10-28 20:27:40.32', 'EN', '2014-10-28 20:27:40.32', 1, 'Helsinki', 1, 1, 35, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (39, 'O4', '2014-10-28 20:27:40.335', 'EN', '2014-10-28 20:27:40.335', 1, 'Viena', 1, 1, 35, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (48, 'O1', '2014-10-28 20:27:40.57', 'EN', '2014-10-28 20:27:40.57', 1, 'Westphalia', 1, 1, 47, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (49, 'O2', '2014-10-28 20:27:40.57', 'EN', '2014-10-28 20:27:40.57', 1, 'Rome', 1, 1, 47, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (50, 'O3', '2014-10-28 20:27:40.57', 'EN', '2014-10-28 20:27:40.57', 1, 'Brussels', 1, 1, 47, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (51, 'O4', '2014-10-28 20:27:40.585', 'EN', '2014-10-28 20:27:40.585', 1, 'Versailles', 1, 1, 47, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (58, 'O1', '2014-10-28 20:27:40.851', 'EN', '2014-10-28 20:27:40.851', 1, 'Norway', 1, 1, 57, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (59, 'O2', '2014-10-28 20:27:40.851', 'EN', '2014-10-28 20:27:40.851', 1, 'Poland', 1, 1, 57, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (60, 'O3', '2014-10-28 20:27:40.851', 'EN', '2014-10-28 20:27:40.851', 1, 'Macedonia', 1, 1, 57, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (61, 'O4', '2014-10-28 20:27:40.851', 'EN', '2014-10-28 20:27:40.851', 1, 'Chipre', 1, 1, 57, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (70, 'O1', '2014-10-28 20:27:41.499', 'EN', '2014-10-28 20:27:41.499', 1, 'Barcelona', 1, 1, 69, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (71, 'O2', '2014-10-28 20:27:41.499', 'EN', '2014-10-28 20:27:41.499', 1, 'Lisboa', 1, 1, 69, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (72, 'O3', '2014-10-28 20:27:41.499', 'EN', '2014-10-28 20:27:41.499', 1, 'Genoa', 1, 1, 69, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (73, 'O4', '2014-10-28 20:27:41.499', 'EN', '2014-10-28 20:27:41.499', 1, 'Roma', 1, 1, 69, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (80, 'O1', '2014-10-28 20:27:41.874', 'EN', '2014-10-28 20:27:41.874', 1, 'Portuguese Empire', 1, 1, 79, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (81, 'O2', '2014-10-28 20:27:41.874', 'EN', '2014-10-28 20:27:41.874', 1, 'British Empire', 1, 1, 79, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (82, 'O3', '2014-10-28 20:27:41.874', 'EN', '2014-10-28 20:27:41.874', 1, 'Spanish Empire', 1, 1, 79, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (83, 'O4', '2014-10-28 20:27:41.874', 'EN', '2014-10-28 20:27:41.874', 1, 'Dutch Empire', 1, 1, 79, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (92, 'O1', '2014-10-28 20:27:42.065', 'EN', '2014-10-28 20:27:42.065', 1, 'Adolph Hitler', 1, 1, 91, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (93, 'O2', '2014-10-28 20:27:42.065', 'EN', '2014-10-28 20:27:42.065', 1, 'Napoleon', 1, 1, 91, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (94, 'O3', '2014-10-28 20:27:42.081', 'EN', '2014-10-28 20:27:42.081', 1, 'Philip 2th King of Spain', 1, 1, 91, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (95, 'O4', '2014-10-28 20:27:42.081', 'EN', '2014-10-28 20:27:42.081', 1, 'Julius Caesar', 1, 1, 91, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (133, 'O1', '2014-10-28 20:27:43.287', 'EN', '2014-10-28 20:27:43.287', 1, 'Norway', 1, 1, 132, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (134, 'O2', '2014-10-28 20:27:43.287', 'EN', '2014-10-28 20:27:43.287', 1, 'Sweden', 1, 1, 132, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (135, 'O3', '2014-10-28 20:27:43.287', 'EN', '2014-10-28 20:27:43.287', 1, 'Denmark', 1, 1, 132, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (136, 'O4', '2014-10-28 20:27:43.287', 'EN', '2014-10-28 20:27:43.287', 1, 'Iceland', 1, 1, 132, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (145, 'O1', '2014-10-28 20:27:43.461', 'EN', '2014-10-28 20:27:43.461', 1, 'Vatican City', 1, 1, 144, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (146, 'O2', '2014-10-28 20:27:43.477', 'EN', '2014-10-28 20:27:43.477', 1, 'Roma', 1, 1, 144, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (147, 'O3', '2014-10-28 20:27:43.477', 'EN', '2014-10-28 20:27:43.477', 1, 'Helsinki', 1, 1, 144, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (148, 'O4', '2014-10-28 20:27:43.477', 'EN', '2014-10-28 20:27:43.477', 1, 'Viena', 1, 1, 144, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (157, 'O1', '2014-10-28 20:27:43.633', 'EN', '2014-10-28 20:27:43.633', 1, 'Westphalia', 1, 1, 156, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (158, 'O2', '2014-10-28 20:27:43.633', 'EN', '2014-10-28 20:27:43.633', 1, 'Rome', 1, 1, 156, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (159, 'O3', '2014-10-28 20:27:43.633', 'EN', '2014-10-28 20:27:43.633', 1, 'Brussels', 1, 1, 156, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (160, 'O4', '2014-10-28 20:27:43.633', 'EN', '2014-10-28 20:27:43.633', 1, 'Versailles', 1, 1, 156, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (167, 'O1', '2014-10-28 20:27:43.742', 'EN', '2014-10-28 20:27:43.742', 1, 'Norway', 1, 1, 166, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (168, 'O2', '2014-10-28 20:27:43.742', 'EN', '2014-10-28 20:27:43.742', 1, 'Poland', 1, 1, 166, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (169, 'O3', '2014-10-28 20:27:43.742', 'EN', '2014-10-28 20:27:43.742', 1, 'Macedonia', 1, 1, 166, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (170, 'O4', '2014-10-28 20:27:43.742', 'EN', '2014-10-28 20:27:43.742', 1, 'Chipre', 1, 1, 166, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (179, 'O1', '2014-10-28 20:27:43.914', 'EN', '2014-10-28 20:27:43.914', 1, 'Barcelona', 1, 1, 178, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (180, 'O2', '2014-10-28 20:27:43.914', 'EN', '2014-10-28 20:27:43.914', 1, 'Lisboa', 1, 1, 178, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (181, 'O3', '2014-10-28 20:27:43.914', 'EN', '2014-10-28 20:27:43.914', 1, 'Genoa', 1, 1, 178, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (182, 'O4', '2014-10-28 20:27:43.93', 'EN', '2014-10-28 20:27:43.93', 1, 'Roma', 1, 1, 178, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (189, 'O1', '2014-10-28 20:27:44.024', 'EN', '2014-10-28 20:27:44.024', 1, 'Portuguese Empire', 1, 1, 188, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (190, 'O2', '2014-10-28 20:27:44.024', 'EN', '2014-10-28 20:27:44.024', 1, 'British Empire', 1, 1, 188, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (191, 'O3', '2014-10-28 20:27:44.024', 'EN', '2014-10-28 20:27:44.024', 1, 'Spanish Empire', 1, 1, 188, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (192, 'O4', '2014-10-28 20:27:44.024', 'EN', '2014-10-28 20:27:44.024', 1, 'Dutch Empire', 1, 1, 188, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (201, 'O1', '2014-10-28 20:27:44.258', 'EN', '2014-10-28 20:27:44.258', 1, 'Adolph Hitler', 1, 1, 200, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (202, 'O2', '2014-10-28 20:27:44.258', 'EN', '2014-10-28 20:27:44.258', 1, 'Napoleon', 1, 1, 200, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (203, 'O3', '2014-10-28 20:27:44.258', 'EN', '2014-10-28 20:27:44.258', 1, 'Philip 2th King of Spain', 1, 1, 200, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (204, 'O4', '2014-10-28 20:27:44.258', 'EN', '2014-10-28 20:27:44.258', 1, 'Julius Caesar', 1, 1, 200, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (227, 'O1', '2014-10-28 20:27:45.591', 'EN', '2014-10-28 20:27:45.591', 1, 'Norway', 1, 1, 226, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (228, 'O2', '2014-10-28 20:27:45.606', 'EN', '2014-10-28 20:27:45.606', 1, 'Sweden', 1, 1, 226, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (229, 'O3', '2014-10-28 20:27:45.606', 'EN', '2014-10-28 20:27:45.606', 1, 'Denmark', 1, 1, 226, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (230, 'O4', '2014-10-28 20:27:45.606', 'EN', '2014-10-28 20:27:45.606', 1, 'Iceland', 1, 1, 226, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (239, 'O1', '2014-10-28 20:27:45.809', 'EN', '2014-10-28 20:27:45.809', 1, 'Vatican City', 1, 1, 238, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (240, 'O2', '2014-10-28 20:27:45.809', 'EN', '2014-10-28 20:27:45.809', 1, 'Roma', 1, 1, 238, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (241, 'O3', '2014-10-28 20:27:45.825', 'EN', '2014-10-28 20:27:45.825', 1, 'Helsinki', 1, 1, 238, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (242, 'O4', '2014-10-28 20:27:45.825', 'EN', '2014-10-28 20:27:45.825', 1, 'Viena', 1, 1, 238, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (251, 'O1', '2014-10-28 20:27:46.015', 'EN', '2014-10-28 20:27:46.015', 1, 'Westphalia', 1, 1, 250, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (252, 'O2', '2014-10-28 20:27:46.016', 'EN', '2014-10-28 20:27:46.016', 1, 'Rome', 1, 1, 250, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (253, 'O3', '2014-10-28 20:27:46.018', 'EN', '2014-10-28 20:27:46.018', 1, 'Brussels', 1, 1, 250, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (254, 'O4', '2014-10-28 20:27:46.02', 'EN', '2014-10-28 20:27:46.02', 1, 'Versailles', 1, 1, 250, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (261, 'O1', '2014-10-28 20:27:46.126', 'EN', '2014-10-28 20:27:46.126', 1, 'Norway', 1, 1, 260, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (262, 'O2', '2014-10-28 20:27:46.13', 'EN', '2014-10-28 20:27:46.13', 1, 'Poland', 1, 1, 260, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (263, 'O3', '2014-10-28 20:27:46.133', 'EN', '2014-10-28 20:27:46.133', 1, 'Macedonia', 1, 1, 260, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (264, 'O4', '2014-10-28 20:27:46.136', 'EN', '2014-10-28 20:27:46.136', 1, 'Chipre', 1, 1, 260, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (273, 'O1', '2014-10-28 20:27:46.359', 'EN', '2014-10-28 20:27:46.359', 1, 'Barcelona', 1, 1, 272, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (274, 'O2', '2014-10-28 20:27:46.361', 'EN', '2014-10-28 20:27:46.361', 1, 'Lisboa', 1, 1, 272, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (275, 'O3', '2014-10-28 20:27:46.363', 'EN', '2014-10-28 20:27:46.363', 1, 'Genoa', 1, 1, 272, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (276, 'O4', '2014-10-28 20:27:46.364', 'EN', '2014-10-28 20:27:46.364', 1, 'Roma', 1, 1, 272, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (283, 'O1', '2014-10-28 20:27:46.532', 'EN', '2014-10-28 20:27:46.532', 1, 'Portuguese Empire', 1, 1, 282, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (284, 'O2', '2014-10-28 20:27:46.534', 'EN', '2014-10-28 20:27:46.534', 1, 'British Empire', 1, 1, 282, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (285, 'O3', '2014-10-28 20:27:46.536', 'EN', '2014-10-28 20:27:46.536', 1, 'Spanish Empire', 1, 1, 282, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (286, 'O4', '2014-10-28 20:27:46.539', 'EN', '2014-10-28 20:27:46.539', 1, 'Dutch Empire', 1, 1, 282, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (630, 'O1', '2014-10-28 20:27:54.707', 'EN', '2014-10-28 20:27:54.707', 1, 'Yes', 1, 1, 629, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (631, 'O2', '2014-10-28 20:27:54.722', 'EN', '2014-10-28 20:27:54.722', 1, 'No', 1, 1, 629, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (632, 'O3', '2014-10-28 20:27:54.722', 'EN', '2014-10-28 20:27:54.722', 1, 'Did not need to', 1, 1, 629, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (295, 'O1', '2014-10-28 20:27:46.874', 'EN', '2014-10-28 20:27:46.874', 1, 'Adolph Hitler', 1, 1, 294, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (296, 'O2', '2014-10-28 20:27:46.876', 'EN', '2014-10-28 20:27:46.876', 1, 'Napoleon', 1, 1, 294, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (297, 'O3', '2014-10-28 20:27:46.879', 'EN', '2014-10-28 20:27:46.879', 1, 'Philip 2th King of Spain', 1, 1, 294, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (298, 'O4', '2014-10-28 20:27:46.881', 'EN', '2014-10-28 20:27:46.881', 1, 'Julius Caesar', 1, 1, 294, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (570, 'O1', '2014-10-28 20:27:52.873', 'EN', '2014-10-28 20:27:52.873', 1, 'under 25,000€', 1, 1, 569, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (571, 'O2', '2014-10-28 20:27:52.873', 'EN', '2014-10-28 20:27:52.873', 1, '25,000 - 29,999€', 1, 1, 569, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (572, 'O3', '2014-10-28 20:27:52.873', 'EN', '2014-10-28 20:27:52.873', 1, '30,000 - 34,999€', 1, 1, 569, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (573, 'O4', '2014-10-28 20:27:52.873', 'EN', '2014-10-28 20:27:52.873', 1, '35,000 - 39,999€', 1, 1, 569, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (574, 'O5', '2014-10-28 20:27:52.873', 'EN', '2014-10-28 20:27:52.873', 1, 'Over 85,000€', 1, 1, 569, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (336, 'O1', '2014-10-28 20:27:48.078', 'EN', '2014-10-28 20:27:48.078', 1, 'Norway', 1, 1, 335, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (337, 'O2', '2014-10-28 20:27:48.08', 'EN', '2014-10-28 20:27:48.08', 1, 'Sweden', 1, 1, 335, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (338, 'O3', '2014-10-28 20:27:48.081', 'EN', '2014-10-28 20:27:48.081', 1, 'Denmark', 1, 1, 335, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (339, 'O4', '2014-10-28 20:27:48.083', 'EN', '2014-10-28 20:27:48.083', 1, 'Iceland', 1, 1, 335, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (392, 'O1', '2014-10-28 20:27:48.714', 'EN', '2014-10-28 20:27:48.714', 1, 'Portuguese Empire', 1, 1, 391, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (393, 'O2', '2014-10-28 20:27:48.714', 'EN', '2014-10-28 20:27:48.714', 1, 'British Empire', 1, 1, 391, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (394, 'O3', '2014-10-28 20:27:48.714', 'EN', '2014-10-28 20:27:48.714', 1, 'Spanish Empire', 1, 1, 391, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (395, 'O4', '2014-10-28 20:27:48.73', 'EN', '2014-10-28 20:27:48.73', 1, 'Dutch Empire', 1, 1, 391, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (584, 'yes', '2014-10-28 20:27:53.69', 'EN', '2014-10-28 20:27:53.69', 1, 'Yes', 1, 1, 583, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (585, 'no', '2014-10-28 20:27:53.705', 'EN', '2014-10-28 20:27:53.705', 1, 'No', 1, 1, 583, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (589, 'O1', '2014-10-28 20:27:54.222', 'EN', '2014-10-28 20:27:54.222', 1, 'Excessive usage of resources (such as CPU, memory, disk, network, etc)', 1, 1, 588, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (590, 'O2', '2014-10-28 20:27:54.222', 'EN', '2014-10-28 20:27:54.222', 1, 'Slow user transactions', 1, 1, 588, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (591, 'O3', '2014-10-28 20:27:54.238', 'EN', '2014-10-28 20:27:54.238', 1, 'Failing user transactions', 1, 1, 588, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (592, 'O4', '2014-10-28 20:27:54.238', 'EN', '2014-10-28 20:27:54.238', 1, 'Complete service outage', 1, 1, 588, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (348, 'O1', '2014-10-28 20:27:48.23', 'EN', '2014-10-28 20:27:48.23', 1, 'Vatican City', 1, 1, 347, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (349, 'O2', '2014-10-28 20:27:48.23', 'EN', '2014-10-28 20:27:48.23', 1, 'Roma', 1, 1, 347, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (350, 'O3', '2014-10-28 20:27:48.23', 'EN', '2014-10-28 20:27:48.23', 1, 'Helsinki', 1, 1, 347, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (351, 'O4', '2014-10-28 20:27:48.23', 'EN', '2014-10-28 20:27:48.23', 1, 'Viena', 1, 1, 347, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (360, 'O1', '2014-10-28 20:27:48.37', 'EN', '2014-10-28 20:27:48.37', 1, 'Westphalia', 1, 1, 359, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (361, 'O2', '2014-10-28 20:27:48.386', 'EN', '2014-10-28 20:27:48.386', 1, 'Rome', 1, 1, 359, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (362, 'O3', '2014-10-28 20:27:48.386', 'EN', '2014-10-28 20:27:48.386', 1, 'Brussels', 1, 1, 359, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (363, 'O4', '2014-10-28 20:27:48.386', 'EN', '2014-10-28 20:27:48.386', 1, 'Versailles', 1, 1, 359, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (370, 'O1', '2014-10-28 20:27:48.48', 'EN', '2014-10-28 20:27:48.48', 1, 'Norway', 1, 1, 369, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (371, 'O2', '2014-10-28 20:27:48.48', 'EN', '2014-10-28 20:27:48.48', 1, 'Poland', 1, 1, 369, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (372, 'O3', '2014-10-28 20:27:48.48', 'EN', '2014-10-28 20:27:48.48', 1, 'Macedonia', 1, 1, 369, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (373, 'O4', '2014-10-28 20:27:48.495', 'EN', '2014-10-28 20:27:48.495', 1, 'Chipre', 1, 1, 369, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (382, 'O1', '2014-10-28 20:27:48.636', 'EN', '2014-10-28 20:27:48.636', 1, 'Barcelona', 1, 1, 381, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (383, 'O2', '2014-10-28 20:27:48.636', 'EN', '2014-10-28 20:27:48.636', 1, 'Lisboa', 1, 1, 381, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (384, 'O3', '2014-10-28 20:27:48.636', 'EN', '2014-10-28 20:27:48.636', 1, 'Genoa', 1, 1, 381, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (385, 'O4', '2014-10-28 20:27:48.636', 'EN', '2014-10-28 20:27:48.636', 1, 'Roma', 1, 1, 381, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (404, 'O1', '2014-10-28 20:27:48.87', 'EN', '2014-10-28 20:27:48.87', 1, 'Adolph Hitler', 1, 1, 403, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (405, 'O2', '2014-10-28 20:27:48.87', 'EN', '2014-10-28 20:27:48.87', 1, 'Napoleon', 1, 1, 403, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (406, 'O3', '2014-10-28 20:27:48.886', 'EN', '2014-10-28 20:27:48.886', 1, 'Philip 2th King of Spain', 1, 1, 403, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (407, 'O4', '2014-10-28 20:27:48.886', 'EN', '2014-10-28 20:27:48.886', 1, 'Julius Caesar', 1, 1, 403, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (445, 'O1', '2014-10-28 20:27:50.067', 'EN', '2014-10-28 20:27:50.067', 1, 'Norway', 1, 1, 444, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (446, 'O2', '2014-10-28 20:27:50.067', 'EN', '2014-10-28 20:27:50.067', 1, 'Sweden', 1, 1, 444, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (447, 'O3', '2014-10-28 20:27:50.067', 'EN', '2014-10-28 20:27:50.067', 1, 'Denmark', 1, 1, 444, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (448, 'O4', '2014-10-28 20:27:50.067', 'EN', '2014-10-28 20:27:50.067', 1, 'Iceland', 1, 1, 444, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (501, 'O1', '2014-10-28 20:27:50.895', 'EN', '2014-10-28 20:27:50.895', 1, 'Portuguese Empire', 1, 1, 500, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (502, 'O2', '2014-10-28 20:27:50.895', 'EN', '2014-10-28 20:27:50.895', 1, 'British Empire', 1, 1, 500, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (503, 'O3', '2014-10-28 20:27:50.895', 'EN', '2014-10-28 20:27:50.895', 1, 'Spanish Empire', 1, 1, 500, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (504, 'O4', '2014-10-28 20:27:50.895', 'EN', '2014-10-28 20:27:50.895', 1, 'Dutch Empire', 1, 1, 500, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (598, 'O1', '2014-10-28 20:27:54.347', 'EN', '2014-10-28 20:27:54.347', 1, 'Yes', 1, 1, 597, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (599, 'O2', '2014-10-28 20:27:54.347', 'EN', '2014-10-28 20:27:54.347', 1, 'No', 1, 1, 597, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (600, 'O3', '2014-10-28 20:27:54.347', 'EN', '2014-10-28 20:27:54.347', 1, 'Don''t know', 1, 1, 597, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (618, 'O1', '2014-10-28 20:27:54.582', 'EN', '2014-10-28 20:27:54.582', 1, 'Application Performance Management (APM) tools', 1, 1, 617, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (619, 'O2', '2014-10-28 20:27:54.582', 'EN', '2014-10-28 20:27:54.582', 1, 'Application Logs', 1, 1, 617, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (620, 'O3', '2014-10-28 20:27:54.582', 'EN', '2014-10-28 20:27:54.582', 1, 'Database Logs', 1, 1, 617, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (621, 'O4', '2014-10-28 20:27:54.582', 'EN', '2014-10-28 20:27:54.582', 1, 'Debuggers', 1, 1, 617, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (622, 'O5', '2014-10-28 20:27:54.582', 'EN', '2014-10-28 20:27:54.582', 1, 'Garbage Collection Logs', 1, 1, 617, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (623, 'O6', '2014-10-28 20:27:54.582', 'EN', '2014-10-28 20:27:54.582', 1, 'JVM built-in tooling (jconsole, jmc, jstat, jmap, etc)', 1, 1, 617, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (624, 'O7', '2014-10-28 20:27:54.597', 'EN', '2014-10-28 20:27:54.597', 1, 'Memory Dump Analyzer', 1, 1, 617, 6);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (625, 'O8', '2014-10-28 20:27:54.597', 'EN', '2014-10-28 20:27:54.597', 1, 'OS command-line tooling (top, free, sar, etc)', 1, 1, 617, 7);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (626, 'O9', '2014-10-28 20:27:54.597', 'EN', '2014-10-28 20:27:54.597', 1, 'Profilers', 1, 1, 617, 8);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (627, 'O10', '2014-10-28 20:27:54.597', 'EN', '2014-10-28 20:27:54.597', 1, 'Thread Dump Analyzer', 1, 1, 617, 9);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (628, 'O11', '2014-10-28 20:27:54.597', 'EN', '2014-10-28 20:27:54.597', 1, 'I asked for external help', 1, 1, 617, 10);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (634, 'O1', '2014-10-28 20:27:54.8', 'EN', '2014-10-28 20:27:54.8', 1, 'Inefficient/missing Caching', 1, 1, 633, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (635, 'O2', '2014-10-28 20:27:54.8', 'EN', '2014-10-28 20:27:54.8', 1, 'Insufficient/missing Database Connection Pooling', 1, 1, 633, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (636, 'O3', '2014-10-28 20:27:54.816', 'EN', '2014-10-28 20:27:54.816', 1, 'Slow Database Queries', 1, 1, 633, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (637, 'O4', '2014-10-28 20:27:54.816', 'EN', '2014-10-28 20:27:54.816', 1, 'Too many Database Queries', 1, 1, 633, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (638, 'O5', '2014-10-28 20:27:54.816', 'EN', '2014-10-28 20:27:54.816', 1, 'Excessive Disk IO', 1, 1, 633, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (639, 'O6', '2014-10-28 20:27:54.816', 'EN', '2014-10-28 20:27:54.816', 1, 'Inefficient Garbage Collection', 1, 1, 633, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (640, 'O7', '2014-10-28 20:27:54.816', 'EN', '2014-10-28 20:27:54.816', 1, 'HTTP Session Bloat', 1, 1, 633, 6);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (641, 'O8', '2014-10-28 20:27:54.816', 'EN', '2014-10-28 20:27:54.816', 1, 'Memory Leak', 1, 1, 633, 7);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (642, 'O9', '2014-10-28 20:27:54.816', 'EN', '2014-10-28 20:27:54.816', 1, 'Monolithic/Not Scalable Architecture', 1, 1, 633, 8);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (643, 'O10', '2014-10-28 20:27:54.816', 'EN', '2014-10-28 20:27:54.816', 1, 'Excessive Network IO', 1, 1, 633, 9);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (644, 'O11', '2014-10-28 20:27:54.816', 'EN', '2014-10-28 20:27:54.816', 1, 'Poor Transaction Configuration', 1, 1, 633, 10);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (645, 'O12', '2014-10-28 20:27:54.816', 'EN', '2014-10-28 20:27:54.816', 1, 'Synchronization Issues (Locks/Deadlocks)', 1, 1, 633, 11);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (646, 'O13', '2014-10-28 20:27:54.832', 'EN', '2014-10-28 20:27:54.832', 1, 'Insufficient/missing Thread Pooling', 1, 1, 633, 12);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (647, 'O14', '2014-10-28 20:27:54.832', 'EN', '2014-10-28 20:27:54.832', 1, 'I Do Not Have A Clue', 1, 1, 633, 13);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (660, 'O1', '2014-10-28 20:27:55.948', 'EN', '2014-10-28 20:27:55.948', 1, 'Java developer', 1, 1, 659, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (661, 'O2', '2014-10-28 20:27:55.948', 'EN', '2014-10-28 20:27:55.948', 1, 'System administrator', 1, 1, 659, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (662, 'O4', '2014-10-28 20:27:55.948', 'EN', '2014-10-28 20:27:55.948', 1, 'Application administrator', 1, 1, 659, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (663, 'O5', '2014-10-28 20:27:55.948', 'EN', '2014-10-28 20:27:55.948', 1, 'Operations manager', 1, 1, 659, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (664, 'O6', '2014-10-28 20:27:55.948', 'EN', '2014-10-28 20:27:55.948', 1, 'Development manager', 1, 1, 659, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (665, 'O7', '2014-10-28 20:27:55.948', 'EN', '2014-10-28 20:27:55.948', 1, 'Executive', 1, 1, 659, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (457, 'O1', '2014-10-28 20:27:50.207', 'EN', '2014-10-28 20:27:50.207', 1, 'Vatican City', 1, 1, 456, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (458, 'O2', '2014-10-28 20:27:50.207', 'EN', '2014-10-28 20:27:50.207', 1, 'Roma', 1, 1, 456, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (459, 'O3', '2014-10-28 20:27:50.207', 'EN', '2014-10-28 20:27:50.207', 1, 'Helsinki', 1, 1, 456, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (460, 'O4', '2014-10-28 20:27:50.207', 'EN', '2014-10-28 20:27:50.207', 1, 'Viena', 1, 1, 456, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (491, 'O1', '2014-10-28 20:27:50.801', 'EN', '2014-10-28 20:27:50.801', 1, 'Barcelona', 1, 1, 490, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (492, 'O2', '2014-10-28 20:27:50.801', 'EN', '2014-10-28 20:27:50.801', 1, 'Lisboa', 1, 1, 490, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (493, 'O3', '2014-10-28 20:27:50.801', 'EN', '2014-10-28 20:27:50.801', 1, 'Genoa', 1, 1, 490, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (494, 'O4', '2014-10-28 20:27:50.801', 'EN', '2014-10-28 20:27:50.801', 1, 'Roma', 1, 1, 490, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (513, 'O1', '2014-10-28 20:27:51.051', 'EN', '2014-10-28 20:27:51.051', 1, 'Adolph Hitler', 1, 1, 512, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (514, 'O2', '2014-10-28 20:27:51.051', 'EN', '2014-10-28 20:27:51.051', 1, 'Napoleon', 1, 1, 512, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (515, 'O3', '2014-10-28 20:27:51.051', 'EN', '2014-10-28 20:27:51.051', 1, 'Philip 2th King of Spain', 1, 1, 512, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (516, 'O4', '2014-10-28 20:27:51.051', 'EN', '2014-10-28 20:27:51.051', 1, 'Julius Caesar', 1, 1, 512, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (594, 'O1', '2014-10-28 20:27:54.285', 'EN', '2014-10-28 20:27:54.285', 1, 'Support calls / e-mails', 1, 1, 593, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (595, 'O2', '2014-10-28 20:27:54.285', 'EN', '2014-10-28 20:27:54.285', 1, 'Load / stress tests', 1, 1, 593, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (596, 'O3', '2014-10-28 20:27:54.285', 'EN', '2014-10-28 20:27:54.285', 1, 'Monitoring software', 1, 1, 593, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (469, 'O1', '2014-10-28 20:27:50.332', 'EN', '2014-10-28 20:27:50.332', 1, 'Westphalia', 1, 1, 468, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (470, 'O2', '2014-10-28 20:27:50.332', 'EN', '2014-10-28 20:27:50.332', 1, 'Rome', 1, 1, 468, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (471, 'O3', '2014-10-28 20:27:50.332', 'EN', '2014-10-28 20:27:50.332', 1, 'Brussels', 1, 1, 468, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (472, 'O4', '2014-10-28 20:27:50.332', 'EN', '2014-10-28 20:27:50.332', 1, 'Versailles', 1, 1, 468, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (479, 'O1', '2014-10-28 20:27:50.645', 'EN', '2014-10-28 20:27:50.645', 1, 'Norway', 1, 1, 478, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (480, 'O2', '2014-10-28 20:27:50.645', 'EN', '2014-10-28 20:27:50.645', 1, 'Poland', 1, 1, 478, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (481, 'O3', '2014-10-28 20:27:50.645', 'EN', '2014-10-28 20:27:50.645', 1, 'Macedonia', 1, 1, 478, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (482, 'O4', '2014-10-28 20:27:50.661', 'EN', '2014-10-28 20:27:50.661', 1, 'Chipre', 1, 1, 478, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (546, 'O1', '2014-10-28 20:27:52.482', 'EN', '2014-10-28 20:27:52.482', 1, 'Agree strongly', 1, 1, 545, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (547, 'O2', '2014-10-28 20:27:52.482', 'EN', '2014-10-28 20:27:52.482', 1, 'Agree somewhat', 1, 1, 545, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (548, 'O3', '2014-10-28 20:27:52.482', 'EN', '2014-10-28 20:27:52.482', 1, 'Neither agree nor disagree', 1, 1, 545, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (549, 'O4', '2014-10-28 20:27:52.482', 'EN', '2014-10-28 20:27:52.482', 1, 'Disagree somewhat', 1, 1, 545, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (550, 'O5', '2014-10-28 20:27:52.482', 'EN', '2014-10-28 20:27:52.482', 1, 'Agree strongly', 1, 1, 545, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (551, 'O6', '2014-10-28 20:27:52.498', 'EN', '2014-10-28 20:27:52.498', 1, 'Disagree strongly', 1, 1, 545, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (602, 'O1', '2014-10-28 20:27:54.441', 'EN', '2014-10-28 20:27:54.441', 1, 'None', 1, 1, 601, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (603, 'O2', '2014-10-28 20:27:54.441', 'EN', '2014-10-28 20:27:54.441', 1, 'AppDynamics', 1, 1, 601, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (604, 'O3', '2014-10-28 20:27:54.457', 'EN', '2014-10-28 20:27:54.457', 1, 'AppNeta', 1, 1, 601, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (605, 'O4', '2014-10-28 20:27:54.457', 'EN', '2014-10-28 20:27:54.457', 1, 'BMC Software APM', 1, 1, 601, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (606, 'O5', '2014-10-28 20:27:54.457', 'EN', '2014-10-28 20:27:54.457', 1, 'CA APM', 1, 1, 601, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (607, 'O6', '2014-10-28 20:27:54.457', 'EN', '2014-10-28 20:27:54.457', 1, 'Compuware APM', 1, 1, 601, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (608, 'O7', '2014-10-28 20:27:54.457', 'EN', '2014-10-28 20:27:54.457', 1, 'DataDog', 1, 1, 601, 6);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (609, 'O8', '2014-10-28 20:27:54.457', 'EN', '2014-10-28 20:27:54.457', 1, 'Nagios', 1, 1, 601, 7);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (610, 'O9', '2014-10-28 20:27:54.457', 'EN', '2014-10-28 20:27:54.457', 1, 'NewRelic', 1, 1, 601, 8);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (611, 'O10', '2014-10-28 20:27:54.457', 'EN', '2014-10-28 20:27:54.457', 1, 'Opsview', 1, 1, 601, 9);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (612, 'O11', '2014-10-28 20:27:54.457', 'EN', '2014-10-28 20:27:54.457', 1, 'Oracle Enterprise Manager', 1, 1, 601, 10);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (613, 'O12', '2014-10-28 20:27:54.457', 'EN', '2014-10-28 20:27:54.457', 1, 'Pingdom', 1, 1, 601, 11);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (614, 'O13', '2014-10-28 20:27:54.457', 'EN', '2014-10-28 20:27:54.457', 1, 'Plumbr', 1, 1, 601, 12);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (615, 'O14', '2014-10-28 20:27:54.472', 'EN', '2014-10-28 20:27:54.472', 1, 'Zabbix', 1, 1, 601, 13);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (616, 'O15', '2014-10-28 20:27:54.472', 'EN', '2014-10-28 20:27:54.472', 1, 'Don''t know', 1, 1, 601, 14);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (649, 'O1', '2014-10-28 20:27:55.082', 'EN', '2014-10-28 20:27:55.082', 1, 'Less than an hour', 1, 1, 648, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (650, 'O2', '2014-10-28 20:27:55.082', 'EN', '2014-10-28 20:27:55.082', 1, 'Less than a day', 1, 1, 648, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (651, 'O3', '2014-10-28 20:27:55.082', 'EN', '2014-10-28 20:27:55.082', 1, 'Less than a week', 1, 1, 648, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (652, 'O4', '2014-10-28 20:27:55.082', 'EN', '2014-10-28 20:27:55.082', 1, 'Less than a month', 1, 1, 648, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (653, 'O5', '2014-10-28 20:27:55.082', 'EN', '2014-10-28 20:27:55.082', 1, 'More than a month', 1, 1, 648, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (557, 'O1', '2014-10-28 20:27:52.701', 'EN', '2014-10-28 20:27:52.701', 1, 'Agree strongly', 1, 1, 556, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (558, 'O2', '2014-10-28 20:27:52.701', 'EN', '2014-10-28 20:27:52.701', 1, 'Agree somewhat', 1, 1, 556, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (559, 'O3', '2014-10-28 20:27:52.701', 'EN', '2014-10-28 20:27:52.701', 1, 'Neither agree nor disagree', 1, 1, 556, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (560, 'O4', '2014-10-28 20:27:52.701', 'EN', '2014-10-28 20:27:52.701', 1, 'Disagree somewhat', 1, 1, 556, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (561, 'O5', '2014-10-28 20:27:52.701', 'EN', '2014-10-28 20:27:52.701', 1, 'Agree strongly', 1, 1, 556, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, version, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (562, 'O6', '2014-10-28 20:27:52.701', 'EN', '2014-10-28 20:27:52.701', 1, 'Disagree strongly', 1, 1, 556, 5);


--
-- TOC entry 2263 (class 0 OID 150104)
-- Dependencies: 185
-- Data for Name: question_option_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (29, 'ES', 1, 'Noruega', 24);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (30, 'ES', 1, 'Suecia', 25);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (31, 'ES', 1, 'Dinamarca', 26);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (32, 'ES', 1, 'Islandia', 27);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (41, 'ES', 1, 'Ciudad del Vaticano', 36);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (42, 'ES', 1, 'Roma', 37);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (43, 'ES', 1, 'Helsinki', 38);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (44, 'ES', 1, 'Viena', 39);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (53, 'ES', 1, 'Westphalia', 48);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (54, 'ES', 1, 'Roma', 49);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (55, 'ES', 1, 'Bruselas', 50);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (56, 'ES', 1, 'Islandia', 51);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (63, 'ES', 1, 'Noruega', 58);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (64, 'ES', 1, 'Polonia', 59);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (65, 'ES', 1, 'Macedonia', 60);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (66, 'ES', 1, 'Chipre', 61);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (75, 'ES', 1, 'Barcelona', 70);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (76, 'ES', 1, 'Lisboa', 71);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (77, 'ES', 1, 'Genova', 72);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (78, 'ES', 1, 'Roma', 73);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (85, 'ES', 1, 'Imperio Portugues', 80);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (86, 'ES', 1, 'Imperio Británico', 81);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (87, 'ES', 1, 'Imperio Español', 82);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (88, 'ES', 1, 'Imperio Holandés', 83);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (97, 'ES', 1, 'Adolfo Hitler', 92);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (98, 'ES', 1, 'Napoleón', 93);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (99, 'ES', 1, 'Felipe II', 94);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (100, 'ES', 1, 'Julio Cesar', 95);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (138, 'ES', 1, 'Noruega', 133);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (139, 'ES', 1, 'Suecia', 134);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (140, 'ES', 1, 'Dinamarca', 135);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (141, 'ES', 1, 'Islandia', 136);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (150, 'ES', 1, 'Ciudad del Vaticano', 145);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (151, 'ES', 1, 'Roma', 146);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (152, 'ES', 1, 'Helsinki', 147);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (153, 'ES', 1, 'Viena', 148);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (162, 'ES', 1, 'Westphalia', 157);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (163, 'ES', 1, 'Roma', 158);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (164, 'ES', 1, 'Bruselas', 159);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (165, 'ES', 1, 'Islandia', 160);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (172, 'ES', 1, 'Noruega', 167);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (173, 'ES', 1, 'Polonia', 168);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (174, 'ES', 1, 'Macedonia', 169);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (175, 'ES', 1, 'Chipre', 170);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (184, 'ES', 1, 'Barcelona', 179);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (185, 'ES', 1, 'Lisboa', 180);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (186, 'ES', 1, 'Genova', 181);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (187, 'ES', 1, 'Roma', 182);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (194, 'ES', 1, 'Imperio Portugues', 189);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (195, 'ES', 1, 'Imperio Británico', 190);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (196, 'ES', 1, 'Imperio Español', 191);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (197, 'ES', 1, 'Imperio Holandés', 192);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (206, 'ES', 1, 'Adolfo Hitler', 201);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (207, 'ES', 1, 'Napoleón', 202);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (208, 'ES', 1, 'Felipe II', 203);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (209, 'ES', 1, 'Julio Cesar', 204);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (232, 'ES', 1, 'Noruega', 227);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (233, 'ES', 1, 'Suecia', 228);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (234, 'ES', 1, 'Dinamarca', 229);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (235, 'ES', 1, 'Islandia', 230);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (244, 'ES', 1, 'Ciudad del Vaticano', 239);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (245, 'ES', 1, 'Roma', 240);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (246, 'ES', 1, 'Helsinki', 241);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (247, 'ES', 1, 'Viena', 242);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (256, 'ES', 1, 'Westphalia', 251);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (257, 'ES', 1, 'Roma', 252);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (258, 'ES', 1, 'Bruselas', 253);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (259, 'ES', 1, 'Islandia', 254);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (266, 'ES', 1, 'Noruega', 261);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (267, 'ES', 1, 'Polonia', 262);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (268, 'ES', 1, 'Macedonia', 263);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (269, 'ES', 1, 'Chipre', 264);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (278, 'ES', 1, 'Barcelona', 273);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (279, 'ES', 1, 'Lisboa', 274);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (280, 'ES', 1, 'Genova', 275);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (281, 'ES', 1, 'Roma', 276);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (288, 'ES', 1, 'Imperio Portugues', 283);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (289, 'ES', 1, 'Imperio Británico', 284);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (290, 'ES', 1, 'Imperio Español', 285);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (291, 'ES', 1, 'Imperio Holandés', 286);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (300, 'ES', 1, 'Adolfo Hitler', 295);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (301, 'ES', 1, 'Napoleón', 296);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (302, 'ES', 1, 'Felipe II', 297);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (303, 'ES', 1, 'Julio Cesar', 298);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (341, 'ES', 1, 'Noruega', 336);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (342, 'ES', 1, 'Suecia', 337);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (343, 'ES', 1, 'Dinamarca', 338);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (344, 'ES', 1, 'Islandia', 339);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (353, 'ES', 1, 'Ciudad del Vaticano', 348);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (354, 'ES', 1, 'Roma', 349);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (355, 'ES', 1, 'Helsinki', 350);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (356, 'ES', 1, 'Viena', 351);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (365, 'ES', 1, 'Westphalia', 360);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (366, 'ES', 1, 'Roma', 361);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (367, 'ES', 1, 'Bruselas', 362);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (368, 'ES', 1, 'Islandia', 363);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (375, 'ES', 1, 'Noruega', 370);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (376, 'ES', 1, 'Polonia', 371);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (377, 'ES', 1, 'Macedonia', 372);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (378, 'ES', 1, 'Chipre', 373);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (387, 'ES', 1, 'Barcelona', 382);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (388, 'ES', 1, 'Lisboa', 383);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (389, 'ES', 1, 'Genova', 384);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (390, 'ES', 1, 'Roma', 385);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (397, 'ES', 1, 'Imperio Portugues', 392);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (398, 'ES', 1, 'Imperio Británico', 393);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (399, 'ES', 1, 'Imperio Español', 394);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (400, 'ES', 1, 'Imperio Holandés', 395);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (409, 'ES', 1, 'Adolfo Hitler', 404);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (410, 'ES', 1, 'Napoleón', 405);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (411, 'ES', 1, 'Felipe II', 406);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (412, 'ES', 1, 'Julio Cesar', 407);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (450, 'ES', 1, 'Noruega', 445);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (451, 'ES', 1, 'Suecia', 446);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (452, 'ES', 1, 'Dinamarca', 447);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (453, 'ES', 1, 'Islandia', 448);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (462, 'ES', 1, 'Ciudad del Vaticano', 457);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (463, 'ES', 1, 'Roma', 458);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (464, 'ES', 1, 'Helsinki', 459);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (465, 'ES', 1, 'Viena', 460);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (474, 'ES', 1, 'Westphalia', 469);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (475, 'ES', 1, 'Roma', 470);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (476, 'ES', 1, 'Bruselas', 471);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (477, 'ES', 1, 'Islandia', 472);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (484, 'ES', 1, 'Noruega', 479);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (485, 'ES', 1, 'Polonia', 480);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (486, 'ES', 1, 'Macedonia', 481);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (487, 'ES', 1, 'Chipre', 482);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (496, 'ES', 1, 'Barcelona', 491);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (497, 'ES', 1, 'Lisboa', 492);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (498, 'ES', 1, 'Genova', 493);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (499, 'ES', 1, 'Roma', 494);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (506, 'ES', 1, 'Imperio Portugues', 501);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (507, 'ES', 1, 'Imperio Británico', 502);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (508, 'ES', 1, 'Imperio Español', 503);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (509, 'ES', 1, 'Imperio Holandés', 504);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (518, 'ES', 1, 'Adolfo Hitler', 513);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (519, 'ES', 1, 'Napoleón', 514);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (520, 'ES', 1, 'Felipe II', 515);
INSERT INTO question_option_translation (id, language, version, title, questionoption_id) VALUES (521, 'ES', 1, 'Julio Cesar', 516);


--
-- TOC entry 2264 (class 0 OID 150112)
-- Dependencies: 186
-- Data for Name: question_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (22, 'ES', 1, '', '¿Cuál es la capital de Malta?', 21);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (28, 'ES', 1, '', '¿Qué pais tiene como capital Copenague?', 23);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (34, 'ES', 1, '', '¿Cuantas capitales europeas fueron fundadas por los romanos?', 33);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (40, 'ES', 1, '', '¿Cuantas de estas capitales Europeas estan al pie de un río?', 35);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (46, 'ES', 1, '', '¿Que significa UE?', 45);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (52, 'ES', 1, '', '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 47);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (62, 'ES', 1, '', '¿Cuál de estos países europeos pertenecen a la zona euro?', 57);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (68, 'ES', 1, '', '¿Cuantos marcos finlandeses necesitas para tener un euro?', 67);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (74, 'ES', 1, '', '¿Dónde nació Cristobal Colón?', 69);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (84, 'ES', 1, '', '¿Cuál fue el imperio más grande en el siglo XVI?', 79);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (90, 'ES', 1, '', '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 89);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (96, 'ES', 1, '', '¿Cual de estos hombres causó más bajas en Europa?', 91);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (131, 'ES', 1, '', '¿Cuál es la capital de Malta?', 130);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (137, 'ES', 1, '', '¿Qué pais tiene como capital Copenague?', 132);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (143, 'ES', 1, '', '¿Cuantas capitales europeas fueron fundadas por los romanos?', 142);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (149, 'ES', 1, '', '¿Cuantas de estas capitales Europeas estan al pie de un río?', 144);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (155, 'ES', 1, '', '¿Que significa UE?', 154);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (161, 'ES', 1, '', '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 156);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (171, 'ES', 1, '', '¿Cuál de estos países europeos pertenecen a la zona euro?', 166);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (177, 'ES', 1, '', '¿Cuantos marcos finlandeses necesitas para tener un euro?', 176);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (183, 'ES', 1, '', '¿Dónde nació Cristobal Colón?', 178);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (193, 'ES', 1, '', '¿Cuál fue el imperio más grande en el siglo XVI?', 188);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (199, 'ES', 1, '', '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 198);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (205, 'ES', 1, '', '¿Cual de estos hombres causó más bajas en Europa?', 200);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (225, 'ES', 1, '', '¿Cuál es la capital de Malta?', 224);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (231, 'ES', 1, '', '¿Qué pais tiene como capital Copenague?', 226);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (237, 'ES', 1, '', '¿Cuantas capitales europeas fueron fundadas por los romanos?', 236);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (243, 'ES', 1, '', '¿Cuantas de estas capitales Europeas estan al pie de un río?', 238);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (249, 'ES', 1, '', '¿Que significa UE?', 248);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (255, 'ES', 1, '', '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 250);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (265, 'ES', 1, '', '¿Cuál de estos países europeos pertenecen a la zona euro?', 260);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (271, 'ES', 1, '', '¿Cuantos marcos finlandeses necesitas para tener un euro?', 270);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (277, 'ES', 1, '', '¿Dónde nació Cristobal Colón?', 272);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (287, 'ES', 1, '', '¿Cuál fue el imperio más grande en el siglo XVI?', 282);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (293, 'ES', 1, '', '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 292);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (299, 'ES', 1, '', '¿Cual de estos hombres causó más bajas en Europa?', 294);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (334, 'ES', 1, '', '¿Cuál es la capital de Malta?', 333);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (340, 'ES', 1, '', '¿Qué pais tiene como capital Copenague?', 335);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (346, 'ES', 1, '', '¿Cuantas capitales europeas fueron fundadas por los romanos?', 345);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (352, 'ES', 1, '', '¿Cuantas de estas capitales Europeas estan al pie de un río?', 347);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (358, 'ES', 1, '', '¿Que significa UE?', 357);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (364, 'ES', 1, '', '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 359);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (374, 'ES', 1, '', '¿Cuál de estos países europeos pertenecen a la zona euro?', 369);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (380, 'ES', 1, '', '¿Cuantos marcos finlandeses necesitas para tener un euro?', 379);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (386, 'ES', 1, '', '¿Dónde nació Cristobal Colón?', 381);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (396, 'ES', 1, '', '¿Cuál fue el imperio más grande en el siglo XVI?', 391);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (402, 'ES', 1, '', '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 401);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (408, 'ES', 1, '', '¿Cual de estos hombres causó más bajas en Europa?', 403);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (443, 'ES', 1, '', '¿Cuál es la capital de Malta?', 442);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (449, 'ES', 1, '', '¿Qué pais tiene como capital Copenague?', 444);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (455, 'ES', 1, '', '¿Cuantas capitales europeas fueron fundadas por los romanos?', 454);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (461, 'ES', 1, '', '¿Cuantas de estas capitales Europeas estan al pie de un río?', 456);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (467, 'ES', 1, '', '¿Que significa UE?', 466);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (473, 'ES', 1, '', '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 468);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (483, 'ES', 1, '', '¿Cuál de estos países europeos pertenecen a la zona euro?', 478);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (489, 'ES', 1, '', '¿Cuantos marcos finlandeses necesitas para tener un euro?', 488);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (495, 'ES', 1, '', '¿Dónde nació Cristobal Colón?', 490);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (505, 'ES', 1, '', '¿Cuál fue el imperio más grande en el siglo XVI?', 500);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (511, 'ES', 1, '', '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 510);
INSERT INTO question_translation (id, language, version, explanation, title, question_id) VALUES (517, 'ES', 1, '', '¿Cual de estos hombres causó más bajas en Europa?', 512);


--
-- TOC entry 2278 (class 0 OID 150551)
-- Dependencies: 200
-- Data for Name: questionnaire_answers_12; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2279 (class 0 OID 150559)
-- Dependencies: 201
-- Data for Name: questionnaire_answers_121; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2280 (class 0 OID 150567)
-- Dependencies: 202
-- Data for Name: questionnaire_answers_215; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2281 (class 0 OID 150575)
-- Dependencies: 203
-- Data for Name: questionnaire_answers_324; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_324 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_324 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_324 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_324 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2282 (class 0 OID 150583)
-- Dependencies: 204
-- Data for Name: questionnaire_answers_433; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_433 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_433 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_433 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_433 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2283 (class 0 OID 150591)
-- Dependencies: 205
-- Data for Name: questionnaire_answers_542; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2284 (class 0 OID 150599)
-- Dependencies: 206
-- Data for Name: questionnaire_answers_580; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2267 (class 0 OID 150133)
-- Dependencies: 189
-- Data for Name: questionnaire_definition_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_definition_permission (id, mask, version, role_id, user_id, target_id) VALUES (13, 3, 1, NULL, 1, 12);
INSERT INTO questionnaire_definition_permission (id, mask, version, role_id, user_id, target_id) VALUES (122, 3, 1, NULL, 1, 121);
INSERT INTO questionnaire_definition_permission (id, mask, version, role_id, user_id, target_id) VALUES (216, 3, 1, NULL, 1, 215);
INSERT INTO questionnaire_definition_permission (id, mask, version, role_id, user_id, target_id) VALUES (325, 3, 1, NULL, 1, 324);
INSERT INTO questionnaire_definition_permission (id, mask, version, role_id, user_id, target_id) VALUES (434, 3, 1, NULL, 1, 433);
INSERT INTO questionnaire_definition_permission (id, mask, version, role_id, user_id, target_id) VALUES (543, 3, 1, NULL, 1, 542);
INSERT INTO questionnaire_definition_permission (id, mask, version, role_id, user_id, target_id) VALUES (582, 3, 1, NULL, 1, 580);


--
-- TOC entry 2262 (class 0 OID 150096)
-- Dependencies: 184
-- Data for Name: questionnaire_definition_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_definition_translation (id, language, version, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (14, 'ES', 1, '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', '', 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 12);
INSERT INTO questionnaire_definition_translation (id, language, version, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (123, 'ES', 1, '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', '', 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 121);
INSERT INTO questionnaire_definition_translation (id, language, version, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (217, 'ES', 1, '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', '', 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 215);
INSERT INTO questionnaire_definition_translation (id, language, version, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (326, 'ES', 1, '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', '', 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 324);
INSERT INTO questionnaire_definition_translation (id, language, version, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (435, 'ES', 1, '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', '', 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 433);


--
-- TOC entry 2268 (class 0 OID 150138)
-- Dependencies: 190
-- Data for Name: questionnaire_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (107, 3, 1, NULL, 6, 106);
INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (110, 3, 1, NULL, 4, 109);
INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (113, 3, 1, NULL, 10, 112);
INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (116, 3, 1, NULL, 8, 115);
INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (310, 3, 1, NULL, 6, 309);
INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (313, 3, 1, NULL, 4, 312);
INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (316, 3, 1, NULL, 10, 315);
INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (319, 3, 1, NULL, 8, 318);
INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (419, 3, 1, NULL, 6, 418);
INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (422, 3, 1, NULL, 4, 421);
INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (425, 3, 1, NULL, 10, 424);
INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (428, 3, 1, NULL, 8, 427);
INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (528, 3, 1, NULL, 6, 527);
INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (531, 3, 1, NULL, 4, 530);
INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (534, 3, 1, NULL, 10, 533);
INSERT INTO questionnaire_permission (id, mask, version, role_id, user_id, target_id) VALUES (537, 3, 1, NULL, 8, 536);


--
-- TOC entry 2269 (class 0 OID 150143)
-- Dependencies: 191
-- Data for Name: research_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO research_permission (id, mask, version, role_id, user_id, target_id) VALUES (105, 7, 1, NULL, 1, 103);
INSERT INTO research_permission (id, mask, version, role_id, user_id, target_id) VALUES (120, 7, 1, NULL, 1, 118);
INSERT INTO research_permission (id, mask, version, role_id, user_id, target_id) VALUES (214, 7, 1, NULL, 1, 212);
INSERT INTO research_permission (id, mask, version, role_id, user_id, target_id) VALUES (308, 7, 1, NULL, 1, 306);
INSERT INTO research_permission (id, mask, version, role_id, user_id, target_id) VALUES (323, 7, 1, NULL, 1, 321);
INSERT INTO research_permission (id, mask, version, role_id, user_id, target_id) VALUES (417, 7, 1, NULL, 1, 415);
INSERT INTO research_permission (id, mask, version, role_id, user_id, target_id) VALUES (432, 7, 1, NULL, 1, 430);
INSERT INTO research_permission (id, mask, version, role_id, user_id, target_id) VALUES (526, 7, 1, NULL, 1, 524);
INSERT INTO research_permission (id, mask, version, role_id, user_id, target_id) VALUES (541, 7, 1, NULL, 1, 539);
INSERT INTO research_permission (id, mask, version, role_id, user_id, target_id) VALUES (579, 7, 1, NULL, 1, 577);
INSERT INTO research_permission (id, mask, version, role_id, user_id, target_id) VALUES (670, 7, 1, NULL, 1, 668);


--
-- TOC entry 2265 (class 0 OID 150120)
-- Dependencies: 187
-- Data for Name: section_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO section_translation (id, language, version, description, title, section_id) VALUES (16, 'ES', 1, '', 'Capitales Europeas', 15);
INSERT INTO section_translation (id, language, version, description, title, section_id) VALUES (18, 'ES', 1, '', 'Unión Europea', 17);
INSERT INTO section_translation (id, language, version, description, title, section_id) VALUES (20, 'ES', 1, '', 'Sociedad', 19);
INSERT INTO section_translation (id, language, version, description, title, section_id) VALUES (125, 'ES', 1, '', 'Capitales Europeas', 124);
INSERT INTO section_translation (id, language, version, description, title, section_id) VALUES (127, 'ES', 1, '', 'Unión Europea', 126);
INSERT INTO section_translation (id, language, version, description, title, section_id) VALUES (129, 'ES', 1, '', 'Sociedad', 128);
INSERT INTO section_translation (id, language, version, description, title, section_id) VALUES (219, 'ES', 1, '', 'Capitales Europeas', 218);
INSERT INTO section_translation (id, language, version, description, title, section_id) VALUES (221, 'ES', 1, '', 'Unión Europea', 220);
INSERT INTO section_translation (id, language, version, description, title, section_id) VALUES (223, 'ES', 1, '', 'Sociedad', 222);
INSERT INTO section_translation (id, language, version, description, title, section_id) VALUES (328, 'ES', 1, '', 'Capitales Europeas', 327);
INSERT INTO section_translation (id, language, version, description, title, section_id) VALUES (330, 'ES', 1, '', 'Unión Europea', 329);
INSERT INTO section_translation (id, language, version, description, title, section_id) VALUES (332, 'ES', 1, '', 'Sociedad', 331);
INSERT INTO section_translation (id, language, version, description, title, section_id) VALUES (437, 'ES', 1, '', 'Capitales Europeas', 436);
INSERT INTO section_translation (id, language, version, description, title, section_id) VALUES (439, 'ES', 1, '', 'Unión Europea', 438);
INSERT INTO section_translation (id, language, version, description, title, section_id) VALUES (441, 'ES', 1, '', 'Sociedad', 440);


--
-- TOC entry 2277 (class 0 OID 150546)
-- Dependencies: 199
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_12_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_121_seq', 0);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_215_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_324_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_433_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_542_seq', 0);
INSERT INTO sequence (seq_name, seq_count) VALUES ('SEQ_GEN', 700);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_580_seq', 0);


--
-- TOC entry 2275 (class 0 OID 150191)
-- Dependencies: 197
-- Data for Name: user_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2270 (class 0 OID 150148)
-- Dependencies: 192
-- Data for Name: user_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_permission (id, mask, version, role_id, user_id, target_id) VALUES (2, 7, 1, NULL, 1, 1);
INSERT INTO user_permission (id, mask, version, role_id, user_id, target_id) VALUES (5, 7, 1, NULL, 1, 4);
INSERT INTO user_permission (id, mask, version, role_id, user_id, target_id) VALUES (7, 7, 1, NULL, 1, 6);
INSERT INTO user_permission (id, mask, version, role_id, user_id, target_id) VALUES (9, 7, 1, NULL, 1, 8);
INSERT INTO user_permission (id, mask, version, role_id, user_id, target_id) VALUES (11, 7, 1, NULL, 1, 10);


--
-- TOC entry 2276 (class 0 OID 150196)
-- Dependencies: 198
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



-- Completed on 2014-10-28 20:28:42

--
-- PostgreSQL database dump complete
--

