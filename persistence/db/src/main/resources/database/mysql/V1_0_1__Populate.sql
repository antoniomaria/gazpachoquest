--
-- TOC entry 2260 (class 0 OID 80140)
-- Dependencies: 196
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (1, 'LBAVULB8D2HVFDV', NULL, '2014-09-04 13:48:30.713', 'support@gazpacho.net', NULL, 'support', '2014-09-04 13:48:30.713', NULL, NULL, 'UGKNYUFKD9Y5YG886WFTADATV7NRB2Z8', 'support', 'support', 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (4, 'EBNL4RVPCQMNP57', NULL, '2014-09-04 13:48:30.857', 'tyrion.lannister@kingslanding.net', 'M', 'Tyrion', '2014-09-04 13:48:30.857', NULL, NULL, 'R2B66YTDA3LN3J6LG6VZZCLWHEGFNPYF', 'Lannister', NULL, 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (6, 'SJMF2TAGVC9FQ4U', NULL, '2014-09-04 13:48:30.866', 'jon.snow@nightswatch.net', 'M', 'Jon', '2014-09-04 13:48:30.866', NULL, 'ES', '92SF378N7P6QPK7A52MRJRHRL43L5M5R', 'Snow', NULL, 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (8, 'L3GSAX84NGV3CUX', NULL, '2014-09-04 13:48:30.876', 'arya.stark@winterfell.net', 'F', 'Arya', '2014-09-04 13:48:30.876', NULL, 'EN', 'Y8DP4CJKDV78LZRHFCTJGSV95PPXQD2W', 'Stark', NULL, 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (10, 'L68ULBB8BRPWTXQ', NULL, '2014-09-04 13:48:30.887', 'catelyn.stark@winterfell.net', 'F', 'Catelyn', '2014-09-04 13:48:30.887', NULL, 'FI', 'GQ3FSE4GNYDQTXJBY3PATTNKF8GFY7CX', 'Stark', NULL, 1, NULL, 1);


--
-- TOC entry 2243 (class 0 OID 80019)
-- Dependencies: 179
-- Data for Name: questionnaire_definition; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_group_info_visible, questions_per_page, randomization_strategy, rendering_mode, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (12, '2014-09-04 13:48:30.906', 'EN', '2014-09-04 13:48:30.906', true, true, NULL, 'N', 'GBG', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_group_info_visible, questions_per_page, randomization_strategy, rendering_mode, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (124, '2014-09-04 13:48:31.744', 'EN', '2014-09-04 13:48:31.744', true, true, NULL, 'Q', 'GBG', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_group_info_visible, questions_per_page, randomization_strategy, rendering_mode, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (236, '2014-09-04 13:48:32.51', 'EN', '2014-09-04 13:48:32.51', true, true, NULL, 'G', 'GBG', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_group_info_visible, questions_per_page, randomization_strategy, rendering_mode, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (348, '2014-09-04 13:48:33.106', 'EN', '2014-09-04 13:48:33.106', true, true, NULL, 'N', 'GBG', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, question_group_info_visible, questions_per_page, randomization_strategy, rendering_mode, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (460, '2014-09-04 13:48:33.653', 'EN', '2014-09-04 13:48:33.653', true, true, NULL, 'N', 'GBG', 'C', true, 'We at BIG DEES take pride in providing you with the highest standards of QUALITY, SERVICE, CLEANLINESS and VALUE in the restaurant industry.', NULL, 'Food Quality QuestionnaireDefinition', 'Your opinion is extremely important in evaluating our business. Thank you for taking a moment to questionOption the following questions:', 1, 1);


--
-- TOC entry 2241 (class 0 OID 80006)
-- Dependencies: 177
-- Data for Name: question_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (15, '2014-09-04 13:48:30.949', 'EN', '2014-09-04 13:48:30.949', false, NULL, 'European Capitals', 1, 1, 12, 0);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (17, '2014-09-04 13:48:30.996', 'EN', '2014-09-04 13:48:30.996', false, NULL, 'European Union', 1, 1, 12, 1);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (19, '2014-09-04 13:48:31.017', 'EN', '2014-09-04 13:48:31.017', false, NULL, 'European History', 1, 1, 12, 2);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (127, '2014-09-04 13:48:31.76', 'EN', '2014-09-04 13:48:31.76', false, NULL, 'European Capitals', 1, 1, 124, 0);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (129, '2014-09-04 13:48:31.775', 'EN', '2014-09-04 13:48:31.775', false, NULL, 'European Union', 1, 1, 124, 1);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (131, '2014-09-04 13:48:31.791', 'EN', '2014-09-04 13:48:31.791', false, NULL, 'European History', 1, 1, 124, 2);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (239, '2014-09-04 13:48:32.525', 'EN', '2014-09-04 13:48:32.525', false, NULL, 'European Capitals', 1, 1, 236, 0);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (241, '2014-09-04 13:48:32.525', 'EN', '2014-09-04 13:48:32.525', false, NULL, 'European Union', 1, 1, 236, 1);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (243, '2014-09-04 13:48:32.541', 'EN', '2014-09-04 13:48:32.541', false, NULL, 'European History', 1, 1, 236, 2);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (353, '2014-09-04 13:48:33.122', 'EN', '2014-09-04 13:48:33.122', false, NULL, 'European Union', 1, 1, 348, 1);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (355, '2014-09-04 13:48:33.137', 'EN', '2014-09-04 13:48:33.137', false, NULL, 'European History', 1, 1, 348, 2);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (351, '2014-09-04 13:48:33.106', 'EN', '2014-09-04 13:48:33.106', true, NULL, 'European Capitals', 1, 1, 348, 0);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (462, '2014-09-04 13:48:33.669', 'EN', '2014-09-04 13:48:33.669', false, NULL, 'Fast Food QuestionnaireDefinition - QuestionGroup', 1, 1, 460, 0);


--
-- TOC entry 2240 (class 0 OID 79998)
-- Dependencies: 176
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (21, 'Q1', '2014-09-04 13:48:31.046', 'EN', '2014-09-04 13:48:31.046', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 15, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (23, 'Q2', '2014-09-04 13:48:31.072', 'EN', '2014-09-04 13:48:31.072', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 15, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (33, 'Q3', '2014-09-04 13:48:31.125', 'EN', '2014-09-04 13:48:31.125', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 15, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (35, 'Q4', '2014-09-04 13:48:31.15', 'EN', '2014-09-04 13:48:31.15', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 15, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (45, 'Q5', '2014-09-04 13:48:31.188', 'EN', '2014-09-04 13:48:31.188', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 17, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (47, 'Q6', '2014-09-04 13:48:31.203', 'EN', '2014-09-04 13:48:31.203', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 17, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (57, 'Q7', '2014-09-04 13:48:31.235', 'EN', '2014-09-04 13:48:31.235', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 17, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (67, 'Q8', '2014-09-04 13:48:31.282', 'EN', '2014-09-04 13:48:31.282', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 17, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (69, 'Q9', '2014-09-04 13:48:31.297', 'EN', '2014-09-04 13:48:31.297', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 19, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (79, 'Q10', '2014-09-04 13:48:31.328', 'EN', '2014-09-04 13:48:31.328', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 19, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (89, 'Q11', '2014-09-04 13:48:31.375', 'EN', '2014-09-04 13:48:31.375', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 19, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (91, 'Q12', '2014-09-04 13:48:31.391', 'EN', '2014-09-04 13:48:31.391', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 19, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (133, 'Q1', '2014-09-04 13:48:31.807', 'EN', '2014-09-04 13:48:31.807', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 127, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (135, 'Q2', '2014-09-04 13:48:31.822', 'EN', '2014-09-04 13:48:31.822', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 127, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (145, 'Q3', '2014-09-04 13:48:31.853', 'EN', '2014-09-04 13:48:31.853', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 127, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (147, 'Q4', '2014-09-04 13:48:31.869', 'EN', '2014-09-04 13:48:31.869', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 127, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (157, 'Q5', '2014-09-04 13:48:31.9', 'EN', '2014-09-04 13:48:31.9', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 129, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (159, 'Q6', '2014-09-04 13:48:31.916', 'EN', '2014-09-04 13:48:31.916', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 129, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (169, 'Q7', '2014-09-04 13:48:31.947', 'EN', '2014-09-04 13:48:31.947', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 129, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (179, 'Q8', '2014-09-04 13:48:31.978', 'EN', '2014-09-04 13:48:31.978', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 129, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (181, 'Q9', '2014-09-04 13:48:32.01', 'EN', '2014-09-04 13:48:32.01', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 131, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (191, 'Q10', '2014-09-04 13:48:32.041', 'EN', '2014-09-04 13:48:32.041', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 131, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (201, 'Q11', '2014-09-04 13:48:32.072', 'EN', '2014-09-04 13:48:32.072', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 131, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (203, 'Q12', '2014-09-04 13:48:32.088', 'EN', '2014-09-04 13:48:32.088', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 131, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (245, 'Q1', '2014-09-04 13:48:32.557', 'EN', '2014-09-04 13:48:32.557', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 239, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (247, 'Q2', '2014-09-04 13:48:32.572', 'EN', '2014-09-04 13:48:32.572', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 239, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (257, 'Q3', '2014-09-04 13:48:32.604', 'EN', '2014-09-04 13:48:32.604', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 239, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (259, 'Q4', '2014-09-04 13:48:32.619', 'EN', '2014-09-04 13:48:32.619', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 239, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (269, 'Q5', '2014-09-04 13:48:32.65', 'EN', '2014-09-04 13:48:32.65', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 241, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (271, 'Q6', '2014-09-04 13:48:32.666', 'EN', '2014-09-04 13:48:32.666', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 241, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (281, 'Q7', '2014-09-04 13:48:32.697', 'EN', '2014-09-04 13:48:32.697', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 241, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (291, 'Q8', '2014-09-04 13:48:32.729', 'EN', '2014-09-04 13:48:32.729', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 241, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (293, 'Q9', '2014-09-04 13:48:32.744', 'EN', '2014-09-04 13:48:32.744', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 243, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (303, 'Q10', '2014-09-04 13:48:32.775', 'EN', '2014-09-04 13:48:32.775', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 243, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (313, 'Q11', '2014-09-04 13:48:32.807', 'EN', '2014-09-04 13:48:32.807', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 243, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (315, 'Q12', '2014-09-04 13:48:32.822', 'EN', '2014-09-04 13:48:32.822', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 243, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (357, 'Q1', '2014-09-04 13:48:33.153', 'EN', '2014-09-04 13:48:33.153', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 351, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (359, 'Q2', '2014-09-04 13:48:33.168', 'EN', '2014-09-04 13:48:33.168', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 351, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (369, 'Q3', '2014-09-04 13:48:33.2', 'EN', '2014-09-04 13:48:33.2', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 351, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (371, 'Q4', '2014-09-04 13:48:33.215', 'EN', '2014-09-04 13:48:33.215', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 351, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (381, 'Q5', '2014-09-04 13:48:33.247', 'EN', '2014-09-04 13:48:33.247', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 353, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (383, 'Q6', '2014-09-04 13:48:33.247', 'EN', '2014-09-04 13:48:33.247', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 353, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (393, 'Q7', '2014-09-04 13:48:33.278', 'EN', '2014-09-04 13:48:33.278', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 353, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (403, 'Q8', '2014-09-04 13:48:33.309', 'EN', '2014-09-04 13:48:33.309', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 353, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (405, 'Q9', '2014-09-04 13:48:33.325', 'EN', '2014-09-04 13:48:33.325', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 355, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (415, 'Q10', '2014-09-04 13:48:33.34', 'EN', '2014-09-04 13:48:33.34', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 355, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (425, 'Q11', '2014-09-04 13:48:33.372', 'EN', '2014-09-04 13:48:33.372', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 355, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (427, 'Q12', '2014-09-04 13:48:33.387', 'EN', '2014-09-04 13:48:33.387', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 355, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (463, 'Q1', '2014-09-04 13:48:33.669', 'EN', '2014-09-04 13:48:33.669', false, true, 'F', NULL, '<b>Food Quality</b>', 1, 1, NULL, 462, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (470, 'Q1.1', '2014-09-04 13:48:33.669', 'EN', '2014-09-04 13:48:33.669', false, false, 'L', NULL, 'The food is served hot and fresh', 1, 1, 463, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (487, 'Q3', '2014-09-04 13:48:33.731', 'EN', '2014-09-04 13:48:33.731', false, true, 'L', NULL, 'Indicate total household income', 1, 1, NULL, 462, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (471, 'Q1.2', '2014-09-04 13:48:33.669', 'EN', '2014-09-04 13:48:33.669', false, false, 'L', NULL, 'The menu has a good variety of items', 1, 1, 463, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (472, 'Q1.3', '2014-09-04 13:48:33.684', 'EN', '2014-09-04 13:48:33.684', false, false, 'L', NULL, 'The quality of food is excellent', 1, 1, 463, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (473, 'Q1.4', '2014-09-04 13:48:33.684', 'EN', '2014-09-04 13:48:33.684', false, false, 'L', NULL, 'The food is tasty and flavorful', 1, 1, 463, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (474, 'Q2', '2014-09-04 13:48:33.7', 'EN', '2014-09-04 13:48:33.7', false, true, 'F', NULL, '<b>Resturant</b>', 1, 1, NULL, 462, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (481, 'Q2.1', '2014-09-04 13:48:33.7', 'EN', '2014-09-04 13:48:33.7', false, false, 'L', NULL, 'My food order was correct and complete', 1, 1, 474, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (482, 'Q2.2', '2014-09-04 13:48:33.7', 'EN', '2014-09-04 13:48:33.7', false, false, 'L', NULL, 'Employees are patient when taking my order', 1, 1, 474, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (483, 'Q2.3', '2014-09-04 13:48:33.7', 'EN', '2014-09-04 13:48:33.7', false, false, 'L', NULL, 'I was served promptly', 1, 1, 474, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (484, 'Q2.4', '2014-09-04 13:48:33.7', 'EN', '2014-09-04 13:48:33.7', false, false, 'L', NULL, 'Availability of sauces, utensils, napkins, etc. was good', 1, 1, 474, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (485, 'Q2.5', '2014-09-04 13:48:33.7', 'EN', '2014-09-04 13:48:33.7', false, false, 'L', NULL, 'The menu board was easy to read', 1, 1, 474, NULL, 4, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (486, 'Q2.6', '2014-09-04 13:48:33.7', 'EN', '2014-09-04 13:48:33.7', false, false, 'L', NULL, 'The drive-thru sound system was cleara', 1, 1, 474, NULL, 5, NULL);


--
-- TOC entry 2245 (class 0 OID 80035)
-- Dependencies: 181
-- Data for Name: research; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (103, '2014-09-04 13:48:31.635', '2014-09-04 13:48:31.635', '2014-09-04 13:48:31.635', 'New QuizEuropean general knowledge quiz started', '2014-09-04 13:48:31.635', 'P', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (121, '2014-09-04 13:48:31.744', '2014-09-04 13:48:31.728', '2014-09-04 13:48:31.744', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-09-04 13:48:31.728', 'O', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (215, '2014-09-04 13:48:32.447', '2014-09-04 13:48:32.432', '2014-09-04 13:48:32.447', 'New QuizEuropean general knowledge quiz started', '2014-09-04 13:48:32.432', 'P', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (233, '2014-09-04 13:48:32.494', '2014-09-04 13:48:32.494', '2014-09-04 13:48:32.494', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-09-04 13:48:32.494', 'O', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (327, '2014-09-04 13:48:33.028', '2014-09-04 13:48:33.028', '2014-09-04 13:48:33.028', 'New QuizEuropean general knowledge quiz started', '2014-09-04 13:48:33.028', 'P', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (345, '2014-09-04 13:48:33.09', '2014-09-04 13:48:33.075', '2014-09-04 13:48:33.09', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-09-04 13:48:33.075', 'O', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (439, '2014-09-04 13:48:33.606', '2014-09-04 13:48:33.606', '2014-09-04 13:48:33.606', 'New QuizEuropean general knowledge quiz started', '2014-09-04 13:48:33.606', 'P', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (457, '2014-09-04 13:48:33.653', '2014-09-04 13:48:33.653', '2014-09-04 13:48:33.653', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-09-04 13:48:33.653', 'O', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (495, '2014-09-04 13:48:34.028', '2014-09-04 13:48:34.028', '2014-09-04 13:48:34.028', 'New customer satisfation survey Food Quality QuestionnaireDefinition started', '2014-09-04 13:48:34.028', 'O', 1, 1);


--
-- TOC entry 2242 (class 0 OID 80014)
-- Dependencies: 178
-- Data for Name: questionnaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (104, 1, '2014-09-04 13:48:31.65', '2014-09-04 13:48:31.65', 'C', NULL, 1, 1, 12, 103, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (108, 2, '2014-09-04 13:48:31.682', '2014-09-04 13:48:31.682', 'C', NULL, 1, 1, 12, 103, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (112, 3, '2014-09-04 13:48:31.697', '2014-09-04 13:48:31.697', 'C', NULL, 1, 1, 12, 103, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (116, 4, '2014-09-04 13:48:31.713', '2014-09-04 13:48:31.713', 'C', NULL, 1, 1, 12, 103, 8);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (216, 1, '2014-09-04 13:48:32.447', '2014-09-04 13:48:32.447', 'C', NULL, 1, 1, 124, 215, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (220, 2, '2014-09-04 13:48:32.463', '2014-09-04 13:48:32.463', 'C', NULL, 1, 1, 124, 215, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (224, 3, '2014-09-04 13:48:32.463', '2014-09-04 13:48:32.463', 'C', NULL, 1, 1, 124, 215, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (228, 4, '2014-09-04 13:48:32.478', '2014-09-04 13:48:32.478', 'C', NULL, 1, 1, 124, 215, 8);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (328, 1, '2014-09-04 13:48:33.043', '2014-09-04 13:48:33.043', 'C', NULL, 1, 1, 236, 327, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (332, 2, '2014-09-04 13:48:33.043', '2014-09-04 13:48:33.043', 'C', NULL, 1, 1, 236, 327, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (336, 3, '2014-09-04 13:48:33.059', '2014-09-04 13:48:33.059', 'C', NULL, 1, 1, 236, 327, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (340, 4, '2014-09-04 13:48:33.075', '2014-09-04 13:48:33.075', 'C', NULL, 1, 1, 236, 327, 8);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (440, 1, '2014-09-04 13:48:33.606', '2014-09-04 13:48:33.606', 'C', NULL, 1, 1, 348, 439, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (444, 2, '2014-09-04 13:48:33.622', '2014-09-04 13:48:33.622', 'C', NULL, 1, 1, 348, 439, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (448, 3, '2014-09-04 13:48:33.622', '2014-09-04 13:48:33.622', 'C', NULL, 1, 1, 348, 439, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (452, 4, '2014-09-04 13:48:33.637', '2014-09-04 13:48:33.637', 'C', NULL, 1, 1, 348, 439, 8);


--
-- TOC entry 2235 (class 0 OID 79961)
-- Dependencies: 171
-- Data for Name: breadcrumb; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2259 (class 0 OID 80132)
-- Dependencies: 195
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2252 (class 0 OID 80091)
-- Dependencies: 188
-- Data for Name: directory_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2258 (class 0 OID 80124)
-- Dependencies: 194
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO groups (id, created_date, description, last_modified_date, name, createdby_id, lastmodifiedby_id) VALUES (3, '2014-09-04 13:48:30.817', 'Respondent group', '2014-09-04 13:48:30.817', 'Respondents', 1, 1);


--
-- TOC entry 2234 (class 0 OID 79953)
-- Dependencies: 170
-- Data for Name: invitation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (106, 'P', 'A', 'XD48YL7AG4', 103, NULL, 6);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (110, 'P', 'A', '6C4JUW7ZXK', 103, NULL, 4);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (114, 'P', 'A', 'FWYADV5RF7', 103, NULL, 10);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (118, 'P', 'A', 'YEJTU8QABR', 103, NULL, 8);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (122, 'A', 'A', 'TSYPYUEWM4', 121, 12, NULL);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (218, 'P', 'A', 'DNBHF2HT9R', 215, NULL, 6);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (222, 'P', 'A', '3QGZA44WRL', 215, NULL, 4);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (226, 'P', 'A', '3L29M52QV3', 215, NULL, 10);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (230, 'P', 'A', 'CX9AHBPY84', 215, NULL, 8);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (234, 'A', 'A', 'BSSFN9YEYG', 233, 124, NULL);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (330, 'P', 'A', '8N6VV3TABE', 327, NULL, 6);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (334, 'P', 'A', 'CBYKGLYJ69', 327, NULL, 4);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (338, 'P', 'A', 'UYZ2JXF4RL', 327, NULL, 10);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (342, 'P', 'A', 'BNPGPBAU8G', 327, NULL, 8);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (346, 'A', 'A', '8FTUYQJVSG', 345, 236, NULL);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (442, 'P', 'A', 'NVBE2SVDX3', 439, NULL, 6);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (446, 'P', 'A', '2K7L56W5VN', 439, NULL, 4);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (450, 'P', 'A', '2ZLBMCAUMS', 439, NULL, 10);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (454, 'P', 'A', 'LWPL4WA37W', 439, NULL, 8);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (458, 'A', 'A', '46JHH9CUVR', 457, 348, NULL);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (496, 'A', 'A', 'ERAG8FV752', 495, 460, NULL);


--
-- TOC entry 2237 (class 0 OID 79974)
-- Dependencies: 173
-- Data for Name: label_set; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2236 (class 0 OID 79966)
-- Dependencies: 172
-- Data for Name: label; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2246 (class 0 OID 80043)
-- Dependencies: 182
-- Data for Name: label_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2238 (class 0 OID 79982)
-- Dependencies: 174
-- Data for Name: mail_message; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (107, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=XD48YL7AG4">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (111, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=6C4JUW7ZXK">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (115, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=FWYADV5RF7">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (119, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=YEJTU8QABR">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (219, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=DNBHF2HT9R">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (223, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=3QGZA44WRL">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (227, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=3L29M52QV3">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (231, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=CX9AHBPY84">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (331, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=8N6VV3TABE">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (335, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=CBYKGLYJ69">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (339, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=UYZ2JXF4RL">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (343, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=BNPGPBAU8G">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (443, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=NVBE2SVDX3">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (447, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=2K7L56W5VN">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (451, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=2ZLBMCAUMS">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (455, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=LWPL4WA37W">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'arya.stark@winterfell.net');


--
-- TOC entry 2239 (class 0 OID 79990)
-- Dependencies: 175
-- Data for Name: mail_message_template; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (101, '2014-09-04 13:48:31.438', 'support@gazpacho.net', 'EN', '2014-09-04 13:48:31.438', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 12);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (213, '2014-09-04 13:48:32.182', 'support@gazpacho.net', 'EN', '2014-09-04 13:48:32.182', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 124);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (325, '2014-09-04 13:48:32.9', 'support@gazpacho.net', 'EN', '2014-09-04 13:48:32.9', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 236);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (437, '2014-09-04 13:48:33.419', 'support@gazpacho.net', 'EN', '2014-09-04 13:48:33.419', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 348);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (493, '2014-09-04 13:48:33.762', 'support@gazpacho.net', 'EN', '2014-09-04 13:48:33.762', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 460);


--
-- TOC entry 2247 (class 0 OID 80051)
-- Dependencies: 183
-- Data for Name: mail_message_template_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (102, '2014-09-04 13:48:31.438', 'ES', '2014-09-04 13:48:31.438', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 101);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (214, '2014-09-04 13:48:32.182', 'ES', '2014-09-04 13:48:32.182', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 213);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (326, '2014-09-04 13:48:32.9', 'ES', '2014-09-04 13:48:32.9', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 325);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (438, '2014-09-04 13:48:33.419', 'ES', '2014-09-04 13:48:33.419', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 437);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (494, '2014-09-04 13:48:33.762', 'ES', '2014-09-04 13:48:33.762', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 493);


--
-- TOC entry 2248 (class 0 OID 80059)
-- Dependencies: 184
-- Data for Name: question_group_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (16, 'ES', NULL, 'Capitales Europeas', 15);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (18, 'ES', NULL, 'Unión Europea', 17);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (20, 'ES', NULL, 'Sociedad', 19);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (128, 'ES', NULL, 'Capitales Europeas', 127);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (130, 'ES', NULL, 'Unión Europea', 129);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (132, 'ES', NULL, 'Sociedad', 131);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (240, 'ES', NULL, 'Capitales Europeas', 239);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (242, 'ES', NULL, 'Unión Europea', 241);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (244, 'ES', NULL, 'Sociedad', 243);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (352, 'ES', NULL, 'Capitales Europeas', 351);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (354, 'ES', NULL, 'Unión Europea', 353);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (356, 'ES', NULL, 'Sociedad', 355);


--
-- TOC entry 2244 (class 0 OID 80027)
-- Dependencies: 180
-- Data for Name: question_option; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (24, 'O1', '2014-09-04 13:48:31.074', 'EN', '2014-09-04 13:48:31.074', 'Norway', 1, 1, 23, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (25, 'O2', '2014-09-04 13:48:31.075', 'EN', '2014-09-04 13:48:31.075', 'Sweden', 1, 1, 23, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (26, 'O3', '2014-09-04 13:48:31.076', 'EN', '2014-09-04 13:48:31.076', 'Denmark', 1, 1, 23, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (27, 'O4', '2014-09-04 13:48:31.077', 'EN', '2014-09-04 13:48:31.077', 'Iceland', 1, 1, 23, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (36, 'O1', '2014-09-04 13:48:31.151', 'EN', '2014-09-04 13:48:31.151', 'Vatican City', 1, 1, 35, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (37, 'O2', '2014-09-04 13:48:31.151', 'EN', '2014-09-04 13:48:31.151', 'Roma', 1, 1, 35, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (38, 'O3', '2014-09-04 13:48:31.152', 'EN', '2014-09-04 13:48:31.152', 'Helsinki', 1, 1, 35, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (39, 'O4', '2014-09-04 13:48:31.153', 'EN', '2014-09-04 13:48:31.153', 'Viena', 1, 1, 35, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (48, 'O1', '2014-09-04 13:48:31.203', 'EN', '2014-09-04 13:48:31.203', 'Westphalia', 1, 1, 47, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (49, 'O2', '2014-09-04 13:48:31.203', 'EN', '2014-09-04 13:48:31.203', 'Rome', 1, 1, 47, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (50, 'O3', '2014-09-04 13:48:31.203', 'EN', '2014-09-04 13:48:31.203', 'Brussels', 1, 1, 47, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (51, 'O4', '2014-09-04 13:48:31.203', 'EN', '2014-09-04 13:48:31.203', 'Versailles', 1, 1, 47, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (58, 'O1', '2014-09-04 13:48:31.25', 'EN', '2014-09-04 13:48:31.25', 'Norway', 1, 1, 57, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (59, 'O2', '2014-09-04 13:48:31.25', 'EN', '2014-09-04 13:48:31.25', 'Poland', 1, 1, 57, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (60, 'O3', '2014-09-04 13:48:31.25', 'EN', '2014-09-04 13:48:31.25', 'Macedonia', 1, 1, 57, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (61, 'O4', '2014-09-04 13:48:31.25', 'EN', '2014-09-04 13:48:31.25', 'Chipre', 1, 1, 57, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (70, 'O1', '2014-09-04 13:48:31.297', 'EN', '2014-09-04 13:48:31.297', 'Barcelona', 1, 1, 69, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (71, 'O2', '2014-09-04 13:48:31.297', 'EN', '2014-09-04 13:48:31.297', 'Lisboa', 1, 1, 69, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (72, 'O3', '2014-09-04 13:48:31.297', 'EN', '2014-09-04 13:48:31.297', 'Genoa', 1, 1, 69, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (73, 'O4', '2014-09-04 13:48:31.297', 'EN', '2014-09-04 13:48:31.297', 'Roma', 1, 1, 69, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (80, 'O1', '2014-09-04 13:48:31.328', 'EN', '2014-09-04 13:48:31.328', 'Portuguese Empire', 1, 1, 79, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (81, 'O2', '2014-09-04 13:48:31.328', 'EN', '2014-09-04 13:48:31.328', 'British Empire', 1, 1, 79, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (82, 'O3', '2014-09-04 13:48:31.328', 'EN', '2014-09-04 13:48:31.328', 'Spanish Empire', 1, 1, 79, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (83, 'O4', '2014-09-04 13:48:31.328', 'EN', '2014-09-04 13:48:31.328', 'Dutch Empire', 1, 1, 79, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (92, 'O1', '2014-09-04 13:48:31.391', 'EN', '2014-09-04 13:48:31.391', 'Adolph Hitler', 1, 1, 91, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (93, 'O2', '2014-09-04 13:48:31.391', 'EN', '2014-09-04 13:48:31.391', 'Napoleon', 1, 1, 91, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (94, 'O3', '2014-09-04 13:48:31.391', 'EN', '2014-09-04 13:48:31.391', 'Philip 2th King of Spain', 1, 1, 91, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (95, 'O4', '2014-09-04 13:48:31.391', 'EN', '2014-09-04 13:48:31.391', 'Julius Caesar', 1, 1, 91, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (136, 'O1', '2014-09-04 13:48:31.822', 'EN', '2014-09-04 13:48:31.822', 'Norway', 1, 1, 135, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (137, 'O2', '2014-09-04 13:48:31.822', 'EN', '2014-09-04 13:48:31.822', 'Sweden', 1, 1, 135, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (138, 'O3', '2014-09-04 13:48:31.822', 'EN', '2014-09-04 13:48:31.822', 'Denmark', 1, 1, 135, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (139, 'O4', '2014-09-04 13:48:31.822', 'EN', '2014-09-04 13:48:31.822', 'Iceland', 1, 1, 135, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (148, 'O1', '2014-09-04 13:48:31.869', 'EN', '2014-09-04 13:48:31.869', 'Vatican City', 1, 1, 147, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (149, 'O2', '2014-09-04 13:48:31.869', 'EN', '2014-09-04 13:48:31.869', 'Roma', 1, 1, 147, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (150, 'O3', '2014-09-04 13:48:31.869', 'EN', '2014-09-04 13:48:31.869', 'Helsinki', 1, 1, 147, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (151, 'O4', '2014-09-04 13:48:31.869', 'EN', '2014-09-04 13:48:31.869', 'Viena', 1, 1, 147, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (160, 'O1', '2014-09-04 13:48:31.916', 'EN', '2014-09-04 13:48:31.916', 'Westphalia', 1, 1, 159, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (161, 'O2', '2014-09-04 13:48:31.916', 'EN', '2014-09-04 13:48:31.916', 'Rome', 1, 1, 159, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (162, 'O3', '2014-09-04 13:48:31.916', 'EN', '2014-09-04 13:48:31.916', 'Brussels', 1, 1, 159, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (163, 'O4', '2014-09-04 13:48:31.916', 'EN', '2014-09-04 13:48:31.916', 'Versailles', 1, 1, 159, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (170, 'O1', '2014-09-04 13:48:31.947', 'EN', '2014-09-04 13:48:31.947', 'Norway', 1, 1, 169, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (171, 'O2', '2014-09-04 13:48:31.947', 'EN', '2014-09-04 13:48:31.947', 'Poland', 1, 1, 169, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (172, 'O3', '2014-09-04 13:48:31.947', 'EN', '2014-09-04 13:48:31.947', 'Macedonia', 1, 1, 169, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (173, 'O4', '2014-09-04 13:48:31.947', 'EN', '2014-09-04 13:48:31.947', 'Chipre', 1, 1, 169, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (182, 'O1', '2014-09-04 13:48:32.01', 'EN', '2014-09-04 13:48:32.01', 'Barcelona', 1, 1, 181, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (183, 'O2', '2014-09-04 13:48:32.01', 'EN', '2014-09-04 13:48:32.01', 'Lisboa', 1, 1, 181, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (184, 'O3', '2014-09-04 13:48:32.01', 'EN', '2014-09-04 13:48:32.01', 'Genoa', 1, 1, 181, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (185, 'O4', '2014-09-04 13:48:32.01', 'EN', '2014-09-04 13:48:32.01', 'Roma', 1, 1, 181, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (192, 'O1', '2014-09-04 13:48:32.041', 'EN', '2014-09-04 13:48:32.041', 'Portuguese Empire', 1, 1, 191, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (193, 'O2', '2014-09-04 13:48:32.041', 'EN', '2014-09-04 13:48:32.041', 'British Empire', 1, 1, 191, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (194, 'O3', '2014-09-04 13:48:32.041', 'EN', '2014-09-04 13:48:32.041', 'Spanish Empire', 1, 1, 191, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (195, 'O4', '2014-09-04 13:48:32.041', 'EN', '2014-09-04 13:48:32.041', 'Dutch Empire', 1, 1, 191, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (204, 'O1', '2014-09-04 13:48:32.088', 'EN', '2014-09-04 13:48:32.088', 'Adolph Hitler', 1, 1, 203, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (205, 'O2', '2014-09-04 13:48:32.088', 'EN', '2014-09-04 13:48:32.088', 'Napoleon', 1, 1, 203, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (206, 'O3', '2014-09-04 13:48:32.088', 'EN', '2014-09-04 13:48:32.088', 'Philip 2th King of Spain', 1, 1, 203, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (207, 'O4', '2014-09-04 13:48:32.088', 'EN', '2014-09-04 13:48:32.088', 'Julius Caesar', 1, 1, 203, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (248, 'O1', '2014-09-04 13:48:32.572', 'EN', '2014-09-04 13:48:32.572', 'Norway', 1, 1, 247, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (249, 'O2', '2014-09-04 13:48:32.572', 'EN', '2014-09-04 13:48:32.572', 'Sweden', 1, 1, 247, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (250, 'O3', '2014-09-04 13:48:32.572', 'EN', '2014-09-04 13:48:32.572', 'Denmark', 1, 1, 247, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (251, 'O4', '2014-09-04 13:48:32.572', 'EN', '2014-09-04 13:48:32.572', 'Iceland', 1, 1, 247, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (260, 'O1', '2014-09-04 13:48:32.619', 'EN', '2014-09-04 13:48:32.619', 'Vatican City', 1, 1, 259, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (261, 'O2', '2014-09-04 13:48:32.619', 'EN', '2014-09-04 13:48:32.619', 'Roma', 1, 1, 259, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (262, 'O3', '2014-09-04 13:48:32.619', 'EN', '2014-09-04 13:48:32.619', 'Helsinki', 1, 1, 259, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (263, 'O4', '2014-09-04 13:48:32.619', 'EN', '2014-09-04 13:48:32.619', 'Viena', 1, 1, 259, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (272, 'O1', '2014-09-04 13:48:32.666', 'EN', '2014-09-04 13:48:32.666', 'Westphalia', 1, 1, 271, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (273, 'O2', '2014-09-04 13:48:32.666', 'EN', '2014-09-04 13:48:32.666', 'Rome', 1, 1, 271, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (274, 'O3', '2014-09-04 13:48:32.666', 'EN', '2014-09-04 13:48:32.666', 'Brussels', 1, 1, 271, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (275, 'O4', '2014-09-04 13:48:32.666', 'EN', '2014-09-04 13:48:32.666', 'Versailles', 1, 1, 271, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (282, 'O1', '2014-09-04 13:48:32.697', 'EN', '2014-09-04 13:48:32.697', 'Norway', 1, 1, 281, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (283, 'O2', '2014-09-04 13:48:32.697', 'EN', '2014-09-04 13:48:32.697', 'Poland', 1, 1, 281, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (284, 'O3', '2014-09-04 13:48:32.697', 'EN', '2014-09-04 13:48:32.697', 'Macedonia', 1, 1, 281, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (285, 'O4', '2014-09-04 13:48:32.697', 'EN', '2014-09-04 13:48:32.697', 'Chipre', 1, 1, 281, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (294, 'O1', '2014-09-04 13:48:32.744', 'EN', '2014-09-04 13:48:32.744', 'Barcelona', 1, 1, 293, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (295, 'O2', '2014-09-04 13:48:32.744', 'EN', '2014-09-04 13:48:32.744', 'Lisboa', 1, 1, 293, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (296, 'O3', '2014-09-04 13:48:32.744', 'EN', '2014-09-04 13:48:32.744', 'Genoa', 1, 1, 293, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (297, 'O4', '2014-09-04 13:48:32.744', 'EN', '2014-09-04 13:48:32.744', 'Roma', 1, 1, 293, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (304, 'O1', '2014-09-04 13:48:32.775', 'EN', '2014-09-04 13:48:32.775', 'Portuguese Empire', 1, 1, 303, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (305, 'O2', '2014-09-04 13:48:32.775', 'EN', '2014-09-04 13:48:32.775', 'British Empire', 1, 1, 303, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (306, 'O3', '2014-09-04 13:48:32.775', 'EN', '2014-09-04 13:48:32.775', 'Spanish Empire', 1, 1, 303, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (307, 'O4', '2014-09-04 13:48:32.775', 'EN', '2014-09-04 13:48:32.775', 'Dutch Empire', 1, 1, 303, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (316, 'O1', '2014-09-04 13:48:32.822', 'EN', '2014-09-04 13:48:32.822', 'Adolph Hitler', 1, 1, 315, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (317, 'O2', '2014-09-04 13:48:32.822', 'EN', '2014-09-04 13:48:32.822', 'Napoleon', 1, 1, 315, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (318, 'O3', '2014-09-04 13:48:32.822', 'EN', '2014-09-04 13:48:32.822', 'Philip 2th King of Spain', 1, 1, 315, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (319, 'O4', '2014-09-04 13:48:32.822', 'EN', '2014-09-04 13:48:32.822', 'Julius Caesar', 1, 1, 315, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (360, 'O1', '2014-09-04 13:48:33.168', 'EN', '2014-09-04 13:48:33.168', 'Norway', 1, 1, 359, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (361, 'O2', '2014-09-04 13:48:33.168', 'EN', '2014-09-04 13:48:33.168', 'Sweden', 1, 1, 359, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (362, 'O3', '2014-09-04 13:48:33.168', 'EN', '2014-09-04 13:48:33.168', 'Denmark', 1, 1, 359, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (363, 'O4', '2014-09-04 13:48:33.168', 'EN', '2014-09-04 13:48:33.168', 'Iceland', 1, 1, 359, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (416, 'O1', '2014-09-04 13:48:33.34', 'EN', '2014-09-04 13:48:33.34', 'Portuguese Empire', 1, 1, 415, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (417, 'O2', '2014-09-04 13:48:33.34', 'EN', '2014-09-04 13:48:33.34', 'British Empire', 1, 1, 415, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (418, 'O3', '2014-09-04 13:48:33.34', 'EN', '2014-09-04 13:48:33.34', 'Spanish Empire', 1, 1, 415, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (419, 'O4', '2014-09-04 13:48:33.34', 'EN', '2014-09-04 13:48:33.34', 'Dutch Empire', 1, 1, 415, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (372, 'O1', '2014-09-04 13:48:33.215', 'EN', '2014-09-04 13:48:33.215', 'Vatican City', 1, 1, 371, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (373, 'O2', '2014-09-04 13:48:33.215', 'EN', '2014-09-04 13:48:33.215', 'Roma', 1, 1, 371, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (374, 'O3', '2014-09-04 13:48:33.215', 'EN', '2014-09-04 13:48:33.215', 'Helsinki', 1, 1, 371, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (375, 'O4', '2014-09-04 13:48:33.215', 'EN', '2014-09-04 13:48:33.215', 'Viena', 1, 1, 371, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (406, 'O1', '2014-09-04 13:48:33.325', 'EN', '2014-09-04 13:48:33.325', 'Barcelona', 1, 1, 405, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (407, 'O2', '2014-09-04 13:48:33.325', 'EN', '2014-09-04 13:48:33.325', 'Lisboa', 1, 1, 405, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (408, 'O3', '2014-09-04 13:48:33.325', 'EN', '2014-09-04 13:48:33.325', 'Genoa', 1, 1, 405, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (409, 'O4', '2014-09-04 13:48:33.325', 'EN', '2014-09-04 13:48:33.325', 'Roma', 1, 1, 405, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (428, 'O1', '2014-09-04 13:48:33.387', 'EN', '2014-09-04 13:48:33.387', 'Adolph Hitler', 1, 1, 427, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (429, 'O2', '2014-09-04 13:48:33.387', 'EN', '2014-09-04 13:48:33.387', 'Napoleon', 1, 1, 427, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (430, 'O3', '2014-09-04 13:48:33.387', 'EN', '2014-09-04 13:48:33.387', 'Philip 2th King of Spain', 1, 1, 427, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (431, 'O4', '2014-09-04 13:48:33.387', 'EN', '2014-09-04 13:48:33.387', 'Julius Caesar', 1, 1, 427, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (384, 'O1', '2014-09-04 13:48:33.247', 'EN', '2014-09-04 13:48:33.247', 'Westphalia', 1, 1, 383, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (385, 'O2', '2014-09-04 13:48:33.247', 'EN', '2014-09-04 13:48:33.247', 'Rome', 1, 1, 383, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (386, 'O3', '2014-09-04 13:48:33.247', 'EN', '2014-09-04 13:48:33.247', 'Brussels', 1, 1, 383, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (387, 'O4', '2014-09-04 13:48:33.247', 'EN', '2014-09-04 13:48:33.247', 'Versailles', 1, 1, 383, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (394, 'O1', '2014-09-04 13:48:33.278', 'EN', '2014-09-04 13:48:33.278', 'Norway', 1, 1, 393, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (395, 'O2', '2014-09-04 13:48:33.278', 'EN', '2014-09-04 13:48:33.278', 'Poland', 1, 1, 393, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (396, 'O3', '2014-09-04 13:48:33.278', 'EN', '2014-09-04 13:48:33.278', 'Macedonia', 1, 1, 393, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (397, 'O4', '2014-09-04 13:48:33.278', 'EN', '2014-09-04 13:48:33.278', 'Chipre', 1, 1, 393, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (488, 'O1', '2014-09-04 13:48:33.731', 'EN', '2014-09-04 13:48:33.731', 'under 25,000€', 1, 1, 487, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (489, 'O2', '2014-09-04 13:48:33.731', 'EN', '2014-09-04 13:48:33.731', '25,000 - 29,999€', 1, 1, 487, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (490, 'O3', '2014-09-04 13:48:33.731', 'EN', '2014-09-04 13:48:33.731', '30,000 - 34,999€', 1, 1, 487, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (491, 'O4', '2014-09-04 13:48:33.731', 'EN', '2014-09-04 13:48:33.731', '35,000 - 39,999€', 1, 1, 487, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (492, 'O5', '2014-09-04 13:48:33.731', 'EN', '2014-09-04 13:48:33.731', 'Over 85,000€', 1, 1, 487, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (464, 'O1', '2014-09-04 13:48:33.669', 'EN', '2014-09-04 13:48:33.669', 'Agree strongly', 1, 1, 463, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (465, 'O2', '2014-09-04 13:48:33.669', 'EN', '2014-09-04 13:48:33.669', 'Agree somewhat', 1, 1, 463, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (466, 'O3', '2014-09-04 13:48:33.669', 'EN', '2014-09-04 13:48:33.669', 'Neither agree nor disagree', 1, 1, 463, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (467, 'O4', '2014-09-04 13:48:33.669', 'EN', '2014-09-04 13:48:33.669', 'Disagree somewhat', 1, 1, 463, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (468, 'O5', '2014-09-04 13:48:33.669', 'EN', '2014-09-04 13:48:33.669', 'Agree strongly', 1, 1, 463, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (469, 'O6', '2014-09-04 13:48:33.669', 'EN', '2014-09-04 13:48:33.669', 'Disagree strongly', 1, 1, 463, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (475, 'O1', '2014-09-04 13:48:33.7', 'EN', '2014-09-04 13:48:33.7', 'Agree strongly', 1, 1, 474, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (476, 'O2', '2014-09-04 13:48:33.7', 'EN', '2014-09-04 13:48:33.7', 'Agree somewhat', 1, 1, 474, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (477, 'O3', '2014-09-04 13:48:33.7', 'EN', '2014-09-04 13:48:33.7', 'Neither agree nor disagree', 1, 1, 474, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (478, 'O4', '2014-09-04 13:48:33.7', 'EN', '2014-09-04 13:48:33.7', 'Disagree somewhat', 1, 1, 474, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (479, 'O5', '2014-09-04 13:48:33.7', 'EN', '2014-09-04 13:48:33.7', 'Agree strongly', 1, 1, 474, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (480, 'O6', '2014-09-04 13:48:33.7', 'EN', '2014-09-04 13:48:33.7', 'Disagree strongly', 1, 1, 474, 5);


--
-- TOC entry 2250 (class 0 OID 80075)
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
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (141, 'ES', 'Noruega', 136);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (142, 'ES', 'Suecia', 137);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (143, 'ES', 'Dinamarca', 138);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (144, 'ES', 'Islandia', 139);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (153, 'ES', 'Ciudad del Vaticano', 148);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (154, 'ES', 'Roma', 149);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (155, 'ES', 'Helsinki', 150);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (156, 'ES', 'Viena', 151);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (165, 'ES', 'Westphalia', 160);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (166, 'ES', 'Roma', 161);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (167, 'ES', 'Bruselas', 162);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (168, 'ES', 'Islandia', 163);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (175, 'ES', 'Noruega', 170);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (176, 'ES', 'Polonia', 171);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (177, 'ES', 'Macedonia', 172);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (178, 'ES', 'Chipre', 173);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (187, 'ES', 'Barcelona', 182);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (188, 'ES', 'Lisboa', 183);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (189, 'ES', 'Genova', 184);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (190, 'ES', 'Roma', 185);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (197, 'ES', 'Imperio Portugues', 192);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (198, 'ES', 'Imperio Británico', 193);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (199, 'ES', 'Imperio Español', 194);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (200, 'ES', 'Imperio Holandés', 195);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (209, 'ES', 'Adolfo Hitler', 204);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (210, 'ES', 'Napoleón', 205);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (211, 'ES', 'Felipe II', 206);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (212, 'ES', 'Julio Cesar', 207);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (253, 'ES', 'Noruega', 248);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (254, 'ES', 'Suecia', 249);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (255, 'ES', 'Dinamarca', 250);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (256, 'ES', 'Islandia', 251);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (265, 'ES', 'Ciudad del Vaticano', 260);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (266, 'ES', 'Roma', 261);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (267, 'ES', 'Helsinki', 262);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (268, 'ES', 'Viena', 263);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (277, 'ES', 'Westphalia', 272);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (278, 'ES', 'Roma', 273);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (279, 'ES', 'Bruselas', 274);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (280, 'ES', 'Islandia', 275);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (287, 'ES', 'Noruega', 282);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (288, 'ES', 'Polonia', 283);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (289, 'ES', 'Macedonia', 284);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (290, 'ES', 'Chipre', 285);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (299, 'ES', 'Barcelona', 294);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (300, 'ES', 'Lisboa', 295);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (301, 'ES', 'Genova', 296);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (302, 'ES', 'Roma', 297);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (309, 'ES', 'Imperio Portugues', 304);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (310, 'ES', 'Imperio Británico', 305);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (311, 'ES', 'Imperio Español', 306);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (312, 'ES', 'Imperio Holandés', 307);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (321, 'ES', 'Adolfo Hitler', 316);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (322, 'ES', 'Napoleón', 317);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (323, 'ES', 'Felipe II', 318);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (324, 'ES', 'Julio Cesar', 319);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (365, 'ES', 'Noruega', 360);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (366, 'ES', 'Suecia', 361);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (367, 'ES', 'Dinamarca', 362);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (368, 'ES', 'Islandia', 363);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (377, 'ES', 'Ciudad del Vaticano', 372);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (378, 'ES', 'Roma', 373);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (379, 'ES', 'Helsinki', 374);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (380, 'ES', 'Viena', 375);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (389, 'ES', 'Westphalia', 384);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (390, 'ES', 'Roma', 385);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (391, 'ES', 'Bruselas', 386);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (392, 'ES', 'Islandia', 387);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (399, 'ES', 'Noruega', 394);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (400, 'ES', 'Polonia', 395);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (401, 'ES', 'Macedonia', 396);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (402, 'ES', 'Chipre', 397);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (411, 'ES', 'Barcelona', 406);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (412, 'ES', 'Lisboa', 407);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (413, 'ES', 'Genova', 408);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (414, 'ES', 'Roma', 409);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (421, 'ES', 'Imperio Portugues', 416);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (422, 'ES', 'Imperio Británico', 417);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (423, 'ES', 'Imperio Español', 418);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (424, 'ES', 'Imperio Holandés', 419);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (433, 'ES', 'Adolfo Hitler', 428);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (434, 'ES', 'Napoleón', 429);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (435, 'ES', 'Felipe II', 430);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (436, 'ES', 'Julio Cesar', 431);


--
-- TOC entry 2251 (class 0 OID 80083)
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
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (134, 'ES', NULL, '¿Cuál es la capital de Malta?', 133);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (140, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 135);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (146, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 145);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (152, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 147);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (158, 'ES', NULL, '¿Que significa UE?', 157);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (164, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 159);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (174, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 169);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (180, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 179);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (186, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 181);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (196, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 191);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (202, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 201);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (208, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 203);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (246, 'ES', NULL, '¿Cuál es la capital de Malta?', 245);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (252, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 247);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (258, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 257);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (264, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 259);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (270, 'ES', NULL, '¿Que significa UE?', 269);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (276, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 271);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (286, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 281);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (292, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 291);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (298, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 293);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (308, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 303);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (314, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 313);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (320, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 315);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (358, 'ES', NULL, '¿Cuál es la capital de Malta?', 357);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (364, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 359);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (370, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 369);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (376, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 371);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (382, 'ES', NULL, '¿Que significa UE?', 381);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (388, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 383);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (398, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 393);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (404, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 403);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (410, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 405);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (420, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 415);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (426, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 425);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (432, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 427);


--
-- TOC entry 2264 (class 0 OID 80516)
-- Dependencies: 200
-- Data for Name: questionnaire_answers_12; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2265 (class 0 OID 80524)
-- Dependencies: 201
-- Data for Name: questionnaire_answers_124; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_124 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_124 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_124 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_124 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2266 (class 0 OID 80532)
-- Dependencies: 202
-- Data for Name: questionnaire_answers_236; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_236 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_236 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_236 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_236 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2267 (class 0 OID 80540)
-- Dependencies: 203
-- Data for Name: questionnaire_answers_348; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_348 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_348 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_348 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_348 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2268 (class 0 OID 80548)
-- Dependencies: 204
-- Data for Name: questionnaire_answers_460; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2253 (class 0 OID 80096)
-- Dependencies: 189
-- Data for Name: questionnaire_definition_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (13, 3, NULL, 1, 12);
INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (125, 3, NULL, 1, 124);
INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (237, 3, NULL, 1, 236);
INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (349, 3, NULL, 1, 348);
INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (461, 3, NULL, 1, 460);


--
-- TOC entry 2249 (class 0 OID 80067)
-- Dependencies: 185
-- Data for Name: questionnaire_definition_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_definition_translation (id, language, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (14, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 12);
INSERT INTO questionnaire_definition_translation (id, language, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (126, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 124);
INSERT INTO questionnaire_definition_translation (id, language, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (238, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 236);
INSERT INTO questionnaire_definition_translation (id, language, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (350, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 348);


--
-- TOC entry 2254 (class 0 OID 80101)
-- Dependencies: 190
-- Data for Name: questionnaire_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (105, 3, NULL, 6, 104);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (109, 3, NULL, 4, 108);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (113, 3, NULL, 10, 112);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (117, 3, NULL, 8, 116);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (217, 3, NULL, 6, 216);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (221, 3, NULL, 4, 220);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (225, 3, NULL, 10, 224);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (229, 3, NULL, 8, 228);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (329, 3, NULL, 6, 328);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (333, 3, NULL, 4, 332);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (337, 3, NULL, 10, 336);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (341, 3, NULL, 8, 340);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (441, 3, NULL, 6, 440);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (445, 3, NULL, 4, 444);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (449, 3, NULL, 10, 448);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (453, 3, NULL, 8, 452);


--
-- TOC entry 2255 (class 0 OID 80106)
-- Dependencies: 191
-- Data for Name: research_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (120, 7, NULL, 1, 103);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (123, 7, NULL, 1, 121);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (232, 7, NULL, 1, 215);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (235, 7, NULL, 1, 233);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (344, 7, NULL, 1, 327);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (347, 7, NULL, 1, 345);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (456, 7, NULL, 1, 439);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (459, 7, NULL, 1, 457);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (497, 7, NULL, 1, 495);


--
-- TOC entry 2263 (class 0 OID 80511)
-- Dependencies: 199
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_12_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_124_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_236_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_348_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('SEQ_GEN', 500);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_460_seq', 0);


--
-- TOC entry 2261 (class 0 OID 80154)
-- Dependencies: 197
-- Data for Name: user_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_group (group_id, user_id) VALUES (3, 6);
INSERT INTO user_group (group_id, user_id) VALUES (3, 4);
INSERT INTO user_group (group_id, user_id) VALUES (3, 10);
INSERT INTO user_group (group_id, user_id) VALUES (3, 8);


--
-- TOC entry 2256 (class 0 OID 80111)
-- Dependencies: 192
-- Data for Name: user_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (2, 7, NULL, 1, 1);
INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (5, 7, NULL, 1, 4);
INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (7, 7, NULL, 1, 6);
INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (9, 7, NULL, 1, 8);
INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (11, 7, NULL, 1, 10);


--
-- TOC entry 2262 (class 0 OID 80159)
-- Dependencies: 198
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



-- Completed on 2014-09-04 13:50:57

--
-- PostgreSQL database dump complete
--

