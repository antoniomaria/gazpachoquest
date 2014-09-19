--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2014-09-07 18:22:48

-- TOC entry 2379 (class 0 OID 91218)
-- Dependencies: 201
-- Data for Name: directory; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2382 (class 0 OID 91242)
-- Dependencies: 204
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (1, '3Q2JBVEASJY2SC6', NULL, '2014-09-07 18:12:57.807', 'support@gazpacho.net', NULL, 'support', '2014-09-07 18:12:57.807', NULL, NULL, 'XFQRMVGKR8R328TJ78E688J9MB8D6HS4', 'support', 'support', 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (4, 'CD6EKABJ47WGGLR', NULL, '2014-09-07 18:12:57.994', 'tyrion.lannister@kingslanding.net', 'M', 'Tyrion', '2014-09-07 18:12:57.994', NULL, NULL, '75AW8E3ZGZFBAW63R9BFNYEJ5JJYGWNE', 'Lannister', NULL, 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (6, 'ESNKHAFLEEH32Y4', NULL, '2014-09-07 18:12:58.041', 'jon.snow@nightswatch.net', 'M', 'Jon', '2014-09-07 18:12:58.041', NULL, 'ES', 'VA47ZZBU6EMVJ5B7442TPM3BZ6PE5BGN', 'Snow', NULL, 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (8, 'TBALWC9URDNMSQR', NULL, '2014-09-07 18:12:58.088', 'arya.stark@winterfell.net', 'F', 'Arya', '2014-09-07 18:12:58.088', NULL, 'EN', 'V3QWVS6ZALC255S5QWYC3S68CLL6CNS9', 'Stark', NULL, 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (10, 'JUF5BU9U857X6DG', NULL, '2014-09-07 18:12:58.135', 'catelyn.stark@winterfell.net', 'F', 'Catelyn', '2014-09-07 18:12:58.135', NULL, 'FI', '3ZZVRB9BXBHEKKZN6BLYRBZ8SFWSMDYB', 'Stark', NULL, 1, NULL, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (601, 'CXQ4MF4XCPP3KEP', NULL, '2014-09-07 18:19:36.466', 'no-reply@gazpachoquest.net', NULL, 'anonymous', '2014-09-07 18:19:36.466', NULL, NULL, 'DF22K3NA2EYM5DVKXLV7Y29VHPT9MEVB', 'anonymous', NULL, NULL, NULL, NULL);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, directory_id, lastmodifiedby_id) VALUES (610, 'ZJTSLZ48TKHEVUK', NULL, '2014-09-07 18:20:12.057', 'no-reply@gazpachoquest.net', NULL, 'anonymous', '2014-09-07 18:20:12.057', NULL, NULL, 'QSJM9DZGAT64WJEWY2XWSWJXQJ2K52EF', 'anonymous', NULL, NULL, NULL, NULL);


--
-- TOC entry 2365 (class 0 OID 91121)
-- Dependencies: 187
-- Data for Name: questionnaire_definition; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, section_info_visible, questions_per_page, randomization_strategy, rendering_mode, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (12, '2014-09-07 18:12:58.182', 'EN', '2014-09-07 18:12:58.182', true, true, NULL, 'N', 'SBS', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, section_info_visible, questions_per_page, randomization_strategy, rendering_mode, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (124, '2014-09-07 18:12:59.883', 'EN', '2014-09-07 18:12:59.883', true, true, NULL, 'N', 'AIO', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, section_info_visible, questions_per_page, randomization_strategy, rendering_mode, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (215, '2014-09-07 18:13:00.368', 'EN', '2014-09-07 18:13:00.368', true, true, 1, 'Q', 'SBS', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, section_info_visible, questions_per_page, randomization_strategy, rendering_mode, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (327, '2014-09-07 18:13:00.923', 'EN', '2014-09-07 18:13:00.923', true, true, NULL, 'G', 'SBS', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, section_info_visible, questions_per_page, randomization_strategy, rendering_mode, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (439, '2014-09-07 18:13:01.456', 'EN', '2014-09-07 18:13:01.456', true, true, NULL, 'N', 'SBS', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnaire.', 1, 1);
INSERT INTO questionnaire_definition (id, created_date, language, last_modified_date, progress_visible, section_info_visible, questions_per_page, randomization_strategy, rendering_mode, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (551, '2014-09-07 18:13:01.841', 'EN', '2014-09-07 18:13:01.841', true, true, NULL, 'N', 'SBS', 'C', true, 'We at BIG DEES take pride in providing you with the highest standards of QUALITY, SERVICE, CLEANLINESS and VALUE in the restaurant industry.', NULL, 'Food Quality QuestionnaireDefinition', 'Your opinion is extremely important in evaluating our business. Thank you for taking a moment to questionOption the following questions:', 1, 1);


--
-- TOC entry 2363 (class 0 OID 91108)
-- Dependencies: 185
-- Data for Name: section; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (15, '2014-09-07 18:12:58.291', 'EN', '2014-09-07 18:12:58.291', false, NULL, 'European Capitals', 1, 1, 12, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (17, '2014-09-07 18:12:58.353', 'EN', '2014-09-07 18:12:58.353', false, NULL, 'European Union', 1, 1, 12, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (19, '2014-09-07 18:12:58.4', 'EN', '2014-09-07 18:12:58.4', false, NULL, 'European History', 1, 1, 12, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (127, '2014-09-07 18:12:59.899', 'EN', '2014-09-07 18:12:59.899', false, NULL, 'European Capitals', 1, 1, 124, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (129, '2014-09-07 18:12:59.915', 'EN', '2014-09-07 18:12:59.915', false, NULL, 'European Union', 1, 1, 124, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (131, '2014-09-07 18:12:59.93', 'EN', '2014-09-07 18:12:59.93', false, NULL, 'European History', 1, 1, 124, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (218, '2014-09-07 18:13:00.383', 'EN', '2014-09-07 18:13:00.383', false, NULL, 'European Capitals', 1, 1, 215, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (220, '2014-09-07 18:13:00.399', 'EN', '2014-09-07 18:13:00.399', false, NULL, 'European Union', 1, 1, 215, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (222, '2014-09-07 18:13:00.415', 'EN', '2014-09-07 18:13:00.415', false, NULL, 'European History', 1, 1, 215, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (330, '2014-09-07 18:13:00.923', 'EN', '2014-09-07 18:13:00.923', false, NULL, 'European Capitals', 1, 1, 327, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (332, '2014-09-07 18:13:00.938', 'EN', '2014-09-07 18:13:00.938', false, NULL, 'European Union', 1, 1, 327, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (334, '2014-09-07 18:13:00.954', 'EN', '2014-09-07 18:13:00.954', false, NULL, 'European History', 1, 1, 327, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (444, '2014-09-07 18:13:01.476', 'EN', '2014-09-07 18:13:01.476', false, NULL, 'European Union', 1, 1, 439, 1);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (446, '2014-09-07 18:13:01.487', 'EN', '2014-09-07 18:13:01.487', false, NULL, 'European History', 1, 1, 439, 2);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (442, '2014-09-07 18:13:01.466', 'EN', '2014-09-07 18:13:01.466', true, NULL, 'European Capitals', 1, 1, 439, 0);
INSERT INTO section (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairedefinition_id, order_in_questionnaire) VALUES (553, '2014-09-07 18:13:01.841', 'EN', '2014-09-07 18:13:01.841', false, NULL, 'Fast Food QuestionnaireDefinition - QuestionGroup', 1, 1, 551, 0);


--
-- TOC entry 2362 (class 0 OID 91100)
-- Dependencies: 184
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (21, 'Q1', '2014-09-07 18:12:58.432', 'EN', '2014-09-07 18:12:58.432', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 15, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (23, 'Q2', '2014-09-07 18:12:58.463', 'EN', '2014-09-07 18:12:58.463', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 15, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (33, 'Q3', '2014-09-07 18:12:58.525', 'EN', '2014-09-07 18:12:58.525', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 15, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (35, 'Q4', '2014-09-07 18:12:58.557', 'EN', '2014-09-07 18:12:58.557', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 15, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (45, 'Q5', '2014-09-07 18:12:58.791', 'EN', '2014-09-07 18:12:58.791', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 17, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (47, 'Q6', '2014-09-07 18:12:58.853', 'EN', '2014-09-07 18:12:58.853', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 17, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (57, 'Q7', '2014-09-07 18:12:58.9', 'EN', '2014-09-07 18:12:58.9', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 17, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (67, 'Q8', '2014-09-07 18:12:59.119', 'EN', '2014-09-07 18:12:59.119', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 17, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (69, 'Q9', '2014-09-07 18:12:59.166', 'EN', '2014-09-07 18:12:59.166', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 19, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (79, 'Q10', '2014-09-07 18:12:59.228', 'EN', '2014-09-07 18:12:59.228', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 19, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (89, 'Q11', '2014-09-07 18:12:59.432', 'EN', '2014-09-07 18:12:59.432', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 19, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (91, 'Q12', '2014-09-07 18:12:59.494', 'EN', '2014-09-07 18:12:59.494', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 19, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (133, 'Q1', '2014-09-07 18:12:59.946', 'EN', '2014-09-07 18:12:59.946', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 127, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (135, 'Q2', '2014-09-07 18:12:59.961', 'EN', '2014-09-07 18:12:59.961', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 127, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (145, 'Q3', '2014-09-07 18:12:59.993', 'EN', '2014-09-07 18:12:59.993', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 127, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (147, 'Q4', '2014-09-07 18:13:00.008', 'EN', '2014-09-07 18:13:00.008', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 127, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (157, 'Q5', '2014-09-07 18:13:00.055', 'EN', '2014-09-07 18:13:00.055', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 129, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (159, 'Q6', '2014-09-07 18:13:00.055', 'EN', '2014-09-07 18:13:00.055', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 129, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (169, 'Q7', '2014-09-07 18:13:00.086', 'EN', '2014-09-07 18:13:00.086', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 129, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (179, 'Q8', '2014-09-07 18:13:00.133', 'EN', '2014-09-07 18:13:00.133', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 129, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (181, 'Q9', '2014-09-07 18:13:00.149', 'EN', '2014-09-07 18:13:00.149', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 131, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (191, 'Q10', '2014-09-07 18:13:00.18', 'EN', '2014-09-07 18:13:00.18', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 131, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (201, 'Q11', '2014-09-07 18:13:00.211', 'EN', '2014-09-07 18:13:00.211', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 131, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (203, 'Q12', '2014-09-07 18:13:00.227', 'EN', '2014-09-07 18:13:00.227', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 131, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (224, 'Q1', '2014-09-07 18:13:00.415', 'EN', '2014-09-07 18:13:00.415', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 218, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (226, 'Q2', '2014-09-07 18:13:00.43', 'EN', '2014-09-07 18:13:00.43', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 218, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (236, 'Q3', '2014-09-07 18:13:00.461', 'EN', '2014-09-07 18:13:00.461', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 218, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (238, 'Q4', '2014-09-07 18:13:00.477', 'EN', '2014-09-07 18:13:00.477', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 218, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (248, 'Q5', '2014-09-07 18:13:00.524', 'EN', '2014-09-07 18:13:00.524', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 220, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (250, 'Q6', '2014-09-07 18:13:00.524', 'EN', '2014-09-07 18:13:00.524', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 220, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (260, 'Q7', '2014-09-07 18:13:00.571', 'EN', '2014-09-07 18:13:00.571', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 220, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (270, 'Q8', '2014-09-07 18:13:00.602', 'EN', '2014-09-07 18:13:00.602', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 220, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (272, 'Q9', '2014-09-07 18:13:00.618', 'EN', '2014-09-07 18:13:00.618', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 222, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (282, 'Q10', '2014-09-07 18:13:00.633', 'EN', '2014-09-07 18:13:00.633', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 222, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (292, 'Q11', '2014-09-07 18:13:00.665', 'EN', '2014-09-07 18:13:00.665', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 222, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (294, 'Q12', '2014-09-07 18:13:00.68', 'EN', '2014-09-07 18:13:00.68', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 222, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (336, 'Q1', '2014-09-07 18:13:00.969', 'EN', '2014-09-07 18:13:00.969', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 330, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (338, 'Q2', '2014-09-07 18:13:00.969', 'EN', '2014-09-07 18:13:00.969', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 330, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (348, 'Q3', '2014-09-07 18:13:01.001', 'EN', '2014-09-07 18:13:01.001', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 330, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (350, 'Q4', '2014-09-07 18:13:01.016', 'EN', '2014-09-07 18:13:01.016', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 330, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (360, 'Q5', '2014-09-07 18:13:01.048', 'EN', '2014-09-07 18:13:01.048', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 332, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (362, 'Q6', '2014-09-07 18:13:01.063', 'EN', '2014-09-07 18:13:01.063', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 332, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (372, 'Q7', '2014-09-07 18:13:01.095', 'EN', '2014-09-07 18:13:01.095', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 332, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (382, 'Q8', '2014-09-07 18:13:01.126', 'EN', '2014-09-07 18:13:01.126', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 332, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (384, 'Q9', '2014-09-07 18:13:01.141', 'EN', '2014-09-07 18:13:01.141', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 334, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (394, 'Q10', '2014-09-07 18:13:01.173', 'EN', '2014-09-07 18:13:01.173', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 334, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (404, 'Q11', '2014-09-07 18:13:01.204', 'EN', '2014-09-07 18:13:01.204', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 334, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (406, 'Q12', '2014-09-07 18:13:01.22', 'EN', '2014-09-07 18:13:01.22', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 334, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (448, 'Q1', '2014-09-07 18:13:01.498', 'EN', '2014-09-07 18:13:01.498', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 442, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (450, 'Q2', '2014-09-07 18:13:01.507', 'EN', '2014-09-07 18:13:01.507', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 442, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (460, 'Q3', '2014-09-07 18:13:01.534', 'EN', '2014-09-07 18:13:01.534', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 442, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (462, 'Q4', '2014-09-07 18:13:01.548', 'EN', '2014-09-07 18:13:01.548', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 442, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (472, 'Q5', '2014-09-07 18:13:01.575', 'EN', '2014-09-07 18:13:01.575', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 444, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (474, 'Q6', '2014-09-07 18:13:01.583', 'EN', '2014-09-07 18:13:01.583', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 444, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (516, 'Q11', '2014-09-07 18:13:01.684', 'EN', '2014-09-07 18:13:01.684', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 446, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (484, 'Q7', '2014-09-07 18:13:01.59', 'EN', '2014-09-07 18:13:01.59', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 444, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (494, 'Q8', '2014-09-07 18:13:01.622', 'EN', '2014-09-07 18:13:01.622', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 444, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (496, 'Q9', '2014-09-07 18:13:01.637', 'EN', '2014-09-07 18:13:01.637', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 446, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (518, 'Q12', '2014-09-07 18:13:01.684', 'EN', '2014-09-07 18:13:01.684', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 446, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (554, 'Q1', '2014-09-07 18:13:01.856', 'EN', '2014-09-07 18:13:01.856', false, true, 'F', NULL, '<b>Food Quality</b>', 1, 1, NULL, 553, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (561, 'Q1.1', '2014-09-07 18:13:01.856', 'EN', '2014-09-07 18:13:01.856', false, false, 'L', NULL, 'The food is served hot and fresh', 1, 1, 554, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (562, 'Q1.2', '2014-09-07 18:13:01.856', 'EN', '2014-09-07 18:13:01.856', false, false, 'L', NULL, 'The menu has a good variety of items', 1, 1, 554, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (563, 'Q1.3', '2014-09-07 18:13:01.856', 'EN', '2014-09-07 18:13:01.856', false, false, 'L', NULL, 'The quality of food is excellent', 1, 1, 554, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (564, 'Q1.4', '2014-09-07 18:13:01.856', 'EN', '2014-09-07 18:13:01.856', false, false, 'L', NULL, 'The food is tasty and flavorful', 1, 1, 554, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (506, 'Q10', '2014-09-07 18:13:01.653', 'EN', '2014-09-07 18:13:01.653', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 446, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (565, 'Q2', '2014-09-07 18:13:01.887', 'EN', '2014-09-07 18:13:01.887', false, true, 'F', NULL, '<b>Resturant</b>', 1, 1, NULL, 553, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (572, 'Q2.1', '2014-09-07 18:13:01.887', 'EN', '2014-09-07 18:13:01.887', false, false, 'L', NULL, 'My food order was correct and complete', 1, 1, 565, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (573, 'Q2.2', '2014-09-07 18:13:01.887', 'EN', '2014-09-07 18:13:01.887', false, false, 'L', NULL, 'Employees are patient when taking my order', 1, 1, 565, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (574, 'Q2.3', '2014-09-07 18:13:01.887', 'EN', '2014-09-07 18:13:01.887', false, false, 'L', NULL, 'I was served promptly', 1, 1, 565, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (575, 'Q2.4', '2014-09-07 18:13:01.887', 'EN', '2014-09-07 18:13:01.887', false, false, 'L', NULL, 'Availability of sauces, utensils, napkins, etc. was good', 1, 1, 565, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (576, 'Q2.5', '2014-09-07 18:13:01.887', 'EN', '2014-09-07 18:13:01.887', false, false, 'L', NULL, 'The menu board was easy to read', 1, 1, 565, NULL, 4, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (577, 'Q2.6', '2014-09-07 18:13:01.887', 'EN', '2014-09-07 18:13:01.887', false, false, 'L', NULL, 'The drive-thru sound system was cleara', 1, 1, 565, NULL, 5, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, SECTION_ID, order_in_subquestions, order_in_section) VALUES (578, 'Q3', '2014-09-07 18:13:01.903', 'EN', '2014-09-07 18:13:01.903', false, true, 'L', NULL, 'Indicate total household income', 1, 1, NULL, 553, NULL, 2);


--
-- TOC entry 2367 (class 0 OID 91137)
-- Dependencies: 189
-- Data for Name: research; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (103, '2014-09-07 18:12:59.774', '2014-09-07 18:12:59.774', '2014-09-07 18:12:59.774', 'New QuizEuropean general knowledge quiz started', '2014-09-07 18:12:59.774', 'P', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (121, '2014-09-07 18:12:59.883', '2014-09-07 18:12:59.868', '2014-09-07 18:12:59.883', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-09-07 18:12:59.868', 'O', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (306, '2014-09-07 18:13:00.844', '2014-09-07 18:13:00.844', '2014-09-07 18:13:00.844', 'New QuizEuropean general knowledge quiz started', '2014-09-07 18:13:00.844', 'P', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (324, '2014-09-07 18:13:00.907', '2014-09-07 18:13:00.907', '2014-09-07 18:13:00.907', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-09-07 18:13:00.907', 'O', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (418, '2014-09-07 18:13:01.394', '2014-09-07 18:13:01.385', '2014-09-07 18:13:01.394', 'New QuizEuropean general knowledge quiz started', '2014-09-07 18:13:01.385', 'P', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (436, '2014-09-07 18:13:01.449', '2014-09-07 18:13:01.442', '2014-09-07 18:13:01.449', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-09-07 18:13:01.442', 'O', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (530, '2014-09-07 18:13:01.794', '2014-09-07 18:13:01.778', '2014-09-07 18:13:01.794', 'New QuizEuropean general knowledge quiz started', '2014-09-07 18:13:01.778', 'P', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (548, '2014-09-07 18:13:01.825', '2014-09-07 18:13:01.825', '2014-09-07 18:13:01.825', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-09-07 18:13:01.825', 'O', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (586, '2014-09-07 18:13:02.001', '2014-09-07 18:13:02.001', '2014-09-07 18:13:02.001', 'New customer satisfation survey Food Quality QuestionnaireDefinition started', '2014-09-07 18:13:02.001', 'O', 1, 1);


--
-- TOC entry 2364 (class 0 OID 91116)
-- Dependencies: 186
-- Data for Name: questionnaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (104, 401, '2014-09-07 18:12:59.79', '2014-09-07 18:12:59.79', 'C', NULL, 1, 1, 12, 103, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (108, 402, '2014-09-07 18:12:59.821', '2014-09-07 18:12:59.821', 'C', NULL, 1, 1, 12, 103, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (112, 403, '2014-09-07 18:12:59.836', '2014-09-07 18:12:59.836', 'C', NULL, 1, 1, 12, 103, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (116, 404, '2014-09-07 18:12:59.852', '2014-09-07 18:12:59.852', 'C', NULL, 1, 1, 12, 103, 8);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (307, 201, '2014-09-07 18:13:00.86', '2014-09-07 18:13:00.86', 'C', NULL, 1, 1, 215, 306, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (311, 202, '2014-09-07 18:13:00.876', '2014-09-07 18:13:00.876', 'C', NULL, 1, 1, 215, 306, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (315, 203, '2014-09-07 18:13:00.876', '2014-09-07 18:13:00.876', 'C', NULL, 1, 1, 215, 306, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (319, 204, '2014-09-07 18:13:00.891', '2014-09-07 18:13:00.891', 'C', NULL, 1, 1, 215, 306, 8);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (419, 201, '2014-09-07 18:13:01.401', '2014-09-07 18:13:01.401', 'C', NULL, 1, 1, 327, 418, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (423, 202, '2014-09-07 18:13:01.414', '2014-09-07 18:13:01.414', 'C', NULL, 1, 1, 327, 418, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (427, 203, '2014-09-07 18:13:01.423', '2014-09-07 18:13:01.423', 'C', NULL, 1, 1, 327, 418, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (431, 204, '2014-09-07 18:13:01.432', '2014-09-07 18:13:01.432', 'C', NULL, 1, 1, 327, 418, 8);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (531, 201, '2014-09-07 18:13:01.794', '2014-09-07 18:13:01.794', 'C', NULL, 1, 1, 439, 530, 6);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (535, 202, '2014-09-07 18:13:01.809', '2014-09-07 18:13:01.809', 'C', NULL, 1, 1, 439, 530, 4);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (539, 203, '2014-09-07 18:13:01.809', '2014-09-07 18:13:01.809', 'C', NULL, 1, 1, 439, 530, 10);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (543, 204, '2014-09-07 18:13:01.825', '2014-09-07 18:13:01.825', 'C', NULL, 1, 1, 439, 530, 8);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (603, 451, '2014-09-07 18:19:36.481', '2014-09-07 18:19:36.481', 'C', NULL, NULL, NULL, 12, 121, 601);
INSERT INTO questionnaire (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairedefinition_id, research_id, respondent_id) VALUES (612, 251, '2014-09-07 18:20:12.057', '2014-09-07 18:20:12.057', 'C', NULL, NULL, NULL, 215, 324, 610);




--
-- TOC entry 2381 (class 0 OID 91234)
-- Dependencies: 203
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2374 (class 0 OID 91193)
-- Dependencies: 196
-- Data for Name: directory_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2380 (class 0 OID 91226)
-- Dependencies: 202
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO groups (id, created_date, description, last_modified_date, name, createdby_id, lastmodifiedby_id) VALUES (3, '2014-09-07 18:12:57.978', 'Respondent group', '2014-09-07 18:12:57.978', 'Respondents', 1, 1);


--
-- TOC entry 2356 (class 0 OID 91055)
-- Dependencies: 178
-- Data for Name: invitation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (106, 'P', 'A', 'XVKDAB45XG', 103, NULL, 6);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (110, 'P', 'A', '3B5GKVKCKK', 103, NULL, 4);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (114, 'P', 'A', 'R4MZDKVLZS', 103, NULL, 10);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (118, 'P', 'A', '77ZSPNQB7C', 103, NULL, 8);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (122, 'A', 'A', '7ESWZMSQ8H', 121, 12, NULL);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (309, 'P', 'A', 'NS9M4GG5EU', 306, NULL, 6);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (313, 'P', 'A', 'BGBT6AA3AU', 306, NULL, 4);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (317, 'P', 'A', 'F3ZVFHMZ5W', 306, NULL, 10);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (321, 'P', 'A', 'EPUD7K67BZ', 306, NULL, 8);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (325, 'A', 'A', 'FFWXDVNCZG', 324, 215, NULL);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (421, 'P', 'A', 'QLM7MVK3RG', 418, NULL, 6);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (425, 'P', 'A', 'BQBTBE3SNP', 418, NULL, 4);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (429, 'P', 'A', '4AQ9BR7ABH', 418, NULL, 10);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (433, 'P', 'A', 'HK4MK3KR23', 418, NULL, 8);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (437, 'A', 'A', '8FSXJDJ8UJ', 436, 327, NULL);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (533, 'P', 'A', 'BNTEGYGVYD', 530, NULL, 6);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (537, 'P', 'A', '7Y7P4W6NF5', 530, NULL, 4);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (541, 'P', 'A', 'JXD5EUJDSK', 530, NULL, 10);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (545, 'P', 'A', 'EXWEHLBMDJ', 530, NULL, 8);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (549, 'A', 'A', 'B6YB5QAMMN', 548, 439, NULL);
INSERT INTO invitation (id, type, status, token, research_id, questionnairedefinition_id, respondent_id) VALUES (587, 'A', 'A', 'SLJ5Z26HNB', 586, 551, NULL);


--
-- TOC entry 2359 (class 0 OID 91076)
-- Dependencies: 181
-- Data for Name: label_set; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2358 (class 0 OID 91068)
-- Dependencies: 180
-- Data for Name: label; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2368 (class 0 OID 91145)
-- Dependencies: 190
-- Data for Name: label_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2360 (class 0 OID 91084)
-- Dependencies: 182
-- Data for Name: mail_message; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (107, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=XVKDAB45XG">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (111, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=3B5GKVKCKK">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (115, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=R4MZDKVLZS">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (119, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=77ZSPNQB7C">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (310, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=NS9M4GG5EU">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (314, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=BGBT6AA3AU">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (318, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=F3ZVFHMZ5W">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (322, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=EPUD7K67BZ">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (422, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=QLM7MVK3RG">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (426, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=BQBTBE3SNP">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (430, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=4AQ9BR7ABH">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (434, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=HK4MK3KR23">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (534, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=BNTEGYGVYD">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (538, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=7Y7P4W6NF5">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (542, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=JXD5EUJDSK">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (546, 'Dear Mr. Stark, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=EXWEHLBMDJ">Click here</a> to take the questionnaireDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnaire', 'arya.stark@winterfell.net');


--
-- TOC entry 2361 (class 0 OID 91092)
-- Dependencies: 183
-- Data for Name: mail_message_template; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (101, '2014-09-07 18:12:59.635', 'support@gazpacho.net', 'EN', '2014-09-07 18:12:59.635', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 12);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (213, '2014-09-07 18:13:00.305', 'support@gazpacho.net', 'EN', '2014-09-07 18:13:00.305', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 124);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (304, '2014-09-07 18:13:00.774', 'support@gazpacho.net', 'EN', '2014-09-07 18:13:00.774', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 215);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (416, '2014-09-07 18:13:01.299', 'support@gazpacho.net', 'EN', '2014-09-07 18:13:01.299', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 327);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (528, '2014-09-07 18:13:01.731', 'support@gazpacho.net', 'EN', '2014-09-07 18:13:01.731', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 439);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairedefinition_id) VALUES (584, '2014-09-07 18:13:01.934', 'support@gazpacho.net', 'EN', '2014-09-07 18:13:01.934', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnaireDefinition', 'Invitation to participate in a questionnaire', 1, 1, 551);


--
-- TOC entry 2369 (class 0 OID 91153)
-- Dependencies: 191
-- Data for Name: mail_message_template_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (102, '2014-09-07 18:12:59.65', 'ES', '2014-09-07 18:12:59.65', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 101);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (214, '2014-09-07 18:13:00.305', 'ES', '2014-09-07 18:13:00.305', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 213);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (305, '2014-09-07 18:13:00.774', 'ES', '2014-09-07 18:13:00.774', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 304);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (417, '2014-09-07 18:13:01.303', 'ES', '2014-09-07 18:13:01.303', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 416);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (529, '2014-09-07 18:13:01.731', 'ES', '2014-09-07 18:13:01.731', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 528);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (585, '2014-09-07 18:13:01.934', 'ES', '2014-09-07 18:13:01.934', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 584);


--
-- TOC entry 2370 (class 0 OID 91161)
-- Dependencies: 192
-- Data for Name: section_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO section_translation (id, language, description, title, SECTION_ID) VALUES (16, 'ES', NULL, 'Capitales Europeas', 15);
INSERT INTO section_translation (id, language, description, title, SECTION_ID) VALUES (18, 'ES', NULL, 'Unión Europea', 17);
INSERT INTO section_translation (id, language, description, title, SECTION_ID) VALUES (20, 'ES', NULL, 'Sociedad', 19);
INSERT INTO section_translation (id, language, description, title, SECTION_ID) VALUES (128, 'ES', NULL, 'Capitales Europeas', 127);
INSERT INTO section_translation (id, language, description, title, SECTION_ID) VALUES (130, 'ES', NULL, 'Unión Europea', 129);
INSERT INTO section_translation (id, language, description, title, SECTION_ID) VALUES (132, 'ES', NULL, 'Sociedad', 131);
INSERT INTO section_translation (id, language, description, title, SECTION_ID) VALUES (219, 'ES', NULL, 'Capitales Europeas', 218);
INSERT INTO section_translation (id, language, description, title, SECTION_ID) VALUES (221, 'ES', NULL, 'Unión Europea', 220);
INSERT INTO section_translation (id, language, description, title, SECTION_ID) VALUES (223, 'ES', NULL, 'Sociedad', 222);
INSERT INTO section_translation (id, language, description, title, SECTION_ID) VALUES (331, 'ES', NULL, 'Capitales Europeas', 330);
INSERT INTO section_translation (id, language, description, title, SECTION_ID) VALUES (333, 'ES', NULL, 'Unión Europea', 332);
INSERT INTO section_translation (id, language, description, title, SECTION_ID) VALUES (335, 'ES', NULL, 'Sociedad', 334);
INSERT INTO section_translation (id, language, description, title, SECTION_ID) VALUES (443, 'ES', NULL, 'Capitales Europeas', 442);
INSERT INTO section_translation (id, language, description, title, SECTION_ID) VALUES (445, 'ES', NULL, 'Unión Europea', 444);
INSERT INTO section_translation (id, language, description, title, SECTION_ID) VALUES (447, 'ES', NULL, 'Sociedad', 446);


--
-- TOC entry 2366 (class 0 OID 91129)
-- Dependencies: 188
-- Data for Name: question_option; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (24, 'O1', '2014-09-07 18:12:58.463', 'EN', '2014-09-07 18:12:58.463', 'Norway', 1, 1, 23, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (25, 'O2', '2014-09-07 18:12:58.463', 'EN', '2014-09-07 18:12:58.463', 'Sweden', 1, 1, 23, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (26, 'O3', '2014-09-07 18:12:58.463', 'EN', '2014-09-07 18:12:58.463', 'Denmark', 1, 1, 23, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (27, 'O4', '2014-09-07 18:12:58.463', 'EN', '2014-09-07 18:12:58.463', 'Iceland', 1, 1, 23, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (36, 'O1', '2014-09-07 18:12:58.557', 'EN', '2014-09-07 18:12:58.557', 'Vatican City', 1, 1, 35, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (37, 'O2', '2014-09-07 18:12:58.557', 'EN', '2014-09-07 18:12:58.557', 'Roma', 1, 1, 35, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (38, 'O3', '2014-09-07 18:12:58.557', 'EN', '2014-09-07 18:12:58.557', 'Helsinki', 1, 1, 35, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (39, 'O4', '2014-09-07 18:12:58.557', 'EN', '2014-09-07 18:12:58.557', 'Viena', 1, 1, 35, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (48, 'O1', '2014-09-07 18:12:58.853', 'EN', '2014-09-07 18:12:58.853', 'Westphalia', 1, 1, 47, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (49, 'O2', '2014-09-07 18:12:58.853', 'EN', '2014-09-07 18:12:58.853', 'Rome', 1, 1, 47, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (50, 'O3', '2014-09-07 18:12:58.853', 'EN', '2014-09-07 18:12:58.853', 'Brussels', 1, 1, 47, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (51, 'O4', '2014-09-07 18:12:58.853', 'EN', '2014-09-07 18:12:58.853', 'Versailles', 1, 1, 47, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (58, 'O1', '2014-09-07 18:12:58.9', 'EN', '2014-09-07 18:12:58.9', 'Norway', 1, 1, 57, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (59, 'O2', '2014-09-07 18:12:58.9', 'EN', '2014-09-07 18:12:58.9', 'Poland', 1, 1, 57, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (60, 'O3', '2014-09-07 18:12:58.9', 'EN', '2014-09-07 18:12:58.9', 'Macedonia', 1, 1, 57, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (61, 'O4', '2014-09-07 18:12:58.9', 'EN', '2014-09-07 18:12:58.9', 'Chipre', 1, 1, 57, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (70, 'O1', '2014-09-07 18:12:59.166', 'EN', '2014-09-07 18:12:59.166', 'Barcelona', 1, 1, 69, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (71, 'O2', '2014-09-07 18:12:59.166', 'EN', '2014-09-07 18:12:59.166', 'Lisboa', 1, 1, 69, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (72, 'O3', '2014-09-07 18:12:59.166', 'EN', '2014-09-07 18:12:59.166', 'Genoa', 1, 1, 69, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (73, 'O4', '2014-09-07 18:12:59.166', 'EN', '2014-09-07 18:12:59.166', 'Roma', 1, 1, 69, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (80, 'O1', '2014-09-07 18:12:59.228', 'EN', '2014-09-07 18:12:59.228', 'Portuguese Empire', 1, 1, 79, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (81, 'O2', '2014-09-07 18:12:59.228', 'EN', '2014-09-07 18:12:59.228', 'British Empire', 1, 1, 79, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (82, 'O3', '2014-09-07 18:12:59.228', 'EN', '2014-09-07 18:12:59.228', 'Spanish Empire', 1, 1, 79, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (83, 'O4', '2014-09-07 18:12:59.228', 'EN', '2014-09-07 18:12:59.228', 'Dutch Empire', 1, 1, 79, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (92, 'O1', '2014-09-07 18:12:59.494', 'EN', '2014-09-07 18:12:59.494', 'Adolph Hitler', 1, 1, 91, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (93, 'O2', '2014-09-07 18:12:59.494', 'EN', '2014-09-07 18:12:59.494', 'Napoleon', 1, 1, 91, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (94, 'O3', '2014-09-07 18:12:59.51', 'EN', '2014-09-07 18:12:59.51', 'Philip 2th King of Spain', 1, 1, 91, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (95, 'O4', '2014-09-07 18:12:59.51', 'EN', '2014-09-07 18:12:59.51', 'Julius Caesar', 1, 1, 91, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (136, 'O1', '2014-09-07 18:12:59.961', 'EN', '2014-09-07 18:12:59.961', 'Norway', 1, 1, 135, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (137, 'O2', '2014-09-07 18:12:59.961', 'EN', '2014-09-07 18:12:59.961', 'Sweden', 1, 1, 135, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (138, 'O3', '2014-09-07 18:12:59.961', 'EN', '2014-09-07 18:12:59.961', 'Denmark', 1, 1, 135, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (139, 'O4', '2014-09-07 18:12:59.961', 'EN', '2014-09-07 18:12:59.961', 'Iceland', 1, 1, 135, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (148, 'O1', '2014-09-07 18:13:00.008', 'EN', '2014-09-07 18:13:00.008', 'Vatican City', 1, 1, 147, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (149, 'O2', '2014-09-07 18:13:00.008', 'EN', '2014-09-07 18:13:00.008', 'Roma', 1, 1, 147, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (150, 'O3', '2014-09-07 18:13:00.008', 'EN', '2014-09-07 18:13:00.008', 'Helsinki', 1, 1, 147, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (151, 'O4', '2014-09-07 18:13:00.008', 'EN', '2014-09-07 18:13:00.008', 'Viena', 1, 1, 147, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (160, 'O1', '2014-09-07 18:13:00.055', 'EN', '2014-09-07 18:13:00.055', 'Westphalia', 1, 1, 159, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (161, 'O2', '2014-09-07 18:13:00.055', 'EN', '2014-09-07 18:13:00.055', 'Rome', 1, 1, 159, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (162, 'O3', '2014-09-07 18:13:00.055', 'EN', '2014-09-07 18:13:00.055', 'Brussels', 1, 1, 159, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (163, 'O4', '2014-09-07 18:13:00.055', 'EN', '2014-09-07 18:13:00.055', 'Versailles', 1, 1, 159, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (170, 'O1', '2014-09-07 18:13:00.086', 'EN', '2014-09-07 18:13:00.086', 'Norway', 1, 1, 169, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (171, 'O2', '2014-09-07 18:13:00.086', 'EN', '2014-09-07 18:13:00.086', 'Poland', 1, 1, 169, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (172, 'O3', '2014-09-07 18:13:00.086', 'EN', '2014-09-07 18:13:00.086', 'Macedonia', 1, 1, 169, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (173, 'O4', '2014-09-07 18:13:00.086', 'EN', '2014-09-07 18:13:00.086', 'Chipre', 1, 1, 169, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (182, 'O1', '2014-09-07 18:13:00.149', 'EN', '2014-09-07 18:13:00.149', 'Barcelona', 1, 1, 181, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (183, 'O2', '2014-09-07 18:13:00.149', 'EN', '2014-09-07 18:13:00.149', 'Lisboa', 1, 1, 181, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (184, 'O3', '2014-09-07 18:13:00.149', 'EN', '2014-09-07 18:13:00.149', 'Genoa', 1, 1, 181, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (185, 'O4', '2014-09-07 18:13:00.149', 'EN', '2014-09-07 18:13:00.149', 'Roma', 1, 1, 181, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (192, 'O1', '2014-09-07 18:13:00.18', 'EN', '2014-09-07 18:13:00.18', 'Portuguese Empire', 1, 1, 191, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (193, 'O2', '2014-09-07 18:13:00.18', 'EN', '2014-09-07 18:13:00.18', 'British Empire', 1, 1, 191, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (194, 'O3', '2014-09-07 18:13:00.18', 'EN', '2014-09-07 18:13:00.18', 'Spanish Empire', 1, 1, 191, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (195, 'O4', '2014-09-07 18:13:00.18', 'EN', '2014-09-07 18:13:00.18', 'Dutch Empire', 1, 1, 191, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (204, 'O1', '2014-09-07 18:13:00.227', 'EN', '2014-09-07 18:13:00.227', 'Adolph Hitler', 1, 1, 203, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (205, 'O2', '2014-09-07 18:13:00.227', 'EN', '2014-09-07 18:13:00.227', 'Napoleon', 1, 1, 203, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (206, 'O3', '2014-09-07 18:13:00.227', 'EN', '2014-09-07 18:13:00.227', 'Philip 2th King of Spain', 1, 1, 203, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (207, 'O4', '2014-09-07 18:13:00.227', 'EN', '2014-09-07 18:13:00.227', 'Julius Caesar', 1, 1, 203, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (227, 'O1', '2014-09-07 18:13:00.43', 'EN', '2014-09-07 18:13:00.43', 'Norway', 1, 1, 226, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (228, 'O2', '2014-09-07 18:13:00.43', 'EN', '2014-09-07 18:13:00.43', 'Sweden', 1, 1, 226, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (229, 'O3', '2014-09-07 18:13:00.43', 'EN', '2014-09-07 18:13:00.43', 'Denmark', 1, 1, 226, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (230, 'O4', '2014-09-07 18:13:00.43', 'EN', '2014-09-07 18:13:00.43', 'Iceland', 1, 1, 226, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (239, 'O1', '2014-09-07 18:13:00.477', 'EN', '2014-09-07 18:13:00.477', 'Vatican City', 1, 1, 238, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (240, 'O2', '2014-09-07 18:13:00.477', 'EN', '2014-09-07 18:13:00.477', 'Roma', 1, 1, 238, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (241, 'O3', '2014-09-07 18:13:00.477', 'EN', '2014-09-07 18:13:00.477', 'Helsinki', 1, 1, 238, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (242, 'O4', '2014-09-07 18:13:00.493', 'EN', '2014-09-07 18:13:00.493', 'Viena', 1, 1, 238, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (251, 'O1', '2014-09-07 18:13:00.54', 'EN', '2014-09-07 18:13:00.54', 'Westphalia', 1, 1, 250, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (252, 'O2', '2014-09-07 18:13:00.54', 'EN', '2014-09-07 18:13:00.54', 'Rome', 1, 1, 250, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (253, 'O3', '2014-09-07 18:13:00.54', 'EN', '2014-09-07 18:13:00.54', 'Brussels', 1, 1, 250, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (254, 'O4', '2014-09-07 18:13:00.54', 'EN', '2014-09-07 18:13:00.54', 'Versailles', 1, 1, 250, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (261, 'O1', '2014-09-07 18:13:00.571', 'EN', '2014-09-07 18:13:00.571', 'Norway', 1, 1, 260, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (262, 'O2', '2014-09-07 18:13:00.571', 'EN', '2014-09-07 18:13:00.571', 'Poland', 1, 1, 260, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (263, 'O3', '2014-09-07 18:13:00.571', 'EN', '2014-09-07 18:13:00.571', 'Macedonia', 1, 1, 260, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (264, 'O4', '2014-09-07 18:13:00.571', 'EN', '2014-09-07 18:13:00.571', 'Chipre', 1, 1, 260, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (273, 'O1', '2014-09-07 18:13:00.618', 'EN', '2014-09-07 18:13:00.618', 'Barcelona', 1, 1, 272, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (274, 'O2', '2014-09-07 18:13:00.618', 'EN', '2014-09-07 18:13:00.618', 'Lisboa', 1, 1, 272, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (275, 'O3', '2014-09-07 18:13:00.618', 'EN', '2014-09-07 18:13:00.618', 'Genoa', 1, 1, 272, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (276, 'O4', '2014-09-07 18:13:00.618', 'EN', '2014-09-07 18:13:00.618', 'Roma', 1, 1, 272, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (283, 'O1', '2014-09-07 18:13:00.633', 'EN', '2014-09-07 18:13:00.633', 'Portuguese Empire', 1, 1, 282, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (284, 'O2', '2014-09-07 18:13:00.633', 'EN', '2014-09-07 18:13:00.633', 'British Empire', 1, 1, 282, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (285, 'O3', '2014-09-07 18:13:00.633', 'EN', '2014-09-07 18:13:00.633', 'Spanish Empire', 1, 1, 282, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (286, 'O4', '2014-09-07 18:13:00.633', 'EN', '2014-09-07 18:13:00.633', 'Dutch Empire', 1, 1, 282, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (295, 'O1', '2014-09-07 18:13:00.68', 'EN', '2014-09-07 18:13:00.68', 'Adolph Hitler', 1, 1, 294, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (296, 'O2', '2014-09-07 18:13:00.68', 'EN', '2014-09-07 18:13:00.68', 'Napoleon', 1, 1, 294, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (297, 'O3', '2014-09-07 18:13:00.68', 'EN', '2014-09-07 18:13:00.68', 'Philip 2th King of Spain', 1, 1, 294, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (298, 'O4', '2014-09-07 18:13:00.696', 'EN', '2014-09-07 18:13:00.696', 'Julius Caesar', 1, 1, 294, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (579, 'O1', '2014-09-07 18:13:01.903', 'EN', '2014-09-07 18:13:01.903', 'under 25,000€', 1, 1, 578, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (580, 'O2', '2014-09-07 18:13:01.903', 'EN', '2014-09-07 18:13:01.903', '25,000 - 29,999€', 1, 1, 578, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (581, 'O3', '2014-09-07 18:13:01.919', 'EN', '2014-09-07 18:13:01.919', '30,000 - 34,999€', 1, 1, 578, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (582, 'O4', '2014-09-07 18:13:01.919', 'EN', '2014-09-07 18:13:01.919', '35,000 - 39,999€', 1, 1, 578, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (583, 'O5', '2014-09-07 18:13:01.919', 'EN', '2014-09-07 18:13:01.919', 'Over 85,000€', 1, 1, 578, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (339, 'O1', '2014-09-07 18:13:00.969', 'EN', '2014-09-07 18:13:00.969', 'Norway', 1, 1, 338, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (340, 'O2', '2014-09-07 18:13:00.969', 'EN', '2014-09-07 18:13:00.969', 'Sweden', 1, 1, 338, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (341, 'O3', '2014-09-07 18:13:00.969', 'EN', '2014-09-07 18:13:00.969', 'Denmark', 1, 1, 338, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (342, 'O4', '2014-09-07 18:13:00.969', 'EN', '2014-09-07 18:13:00.969', 'Iceland', 1, 1, 338, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (351, 'O1', '2014-09-07 18:13:01.016', 'EN', '2014-09-07 18:13:01.016', 'Vatican City', 1, 1, 350, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (352, 'O2', '2014-09-07 18:13:01.016', 'EN', '2014-09-07 18:13:01.016', 'Roma', 1, 1, 350, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (353, 'O3', '2014-09-07 18:13:01.016', 'EN', '2014-09-07 18:13:01.016', 'Helsinki', 1, 1, 350, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (354, 'O4', '2014-09-07 18:13:01.016', 'EN', '2014-09-07 18:13:01.016', 'Viena', 1, 1, 350, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (385, 'O1', '2014-09-07 18:13:01.141', 'EN', '2014-09-07 18:13:01.141', 'Barcelona', 1, 1, 384, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (386, 'O2', '2014-09-07 18:13:01.141', 'EN', '2014-09-07 18:13:01.141', 'Lisboa', 1, 1, 384, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (387, 'O3', '2014-09-07 18:13:01.141', 'EN', '2014-09-07 18:13:01.141', 'Genoa', 1, 1, 384, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (388, 'O4', '2014-09-07 18:13:01.141', 'EN', '2014-09-07 18:13:01.141', 'Roma', 1, 1, 384, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (395, 'O1', '2014-09-07 18:13:01.173', 'EN', '2014-09-07 18:13:01.173', 'Portuguese Empire', 1, 1, 394, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (396, 'O2', '2014-09-07 18:13:01.173', 'EN', '2014-09-07 18:13:01.173', 'British Empire', 1, 1, 394, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (397, 'O3', '2014-09-07 18:13:01.173', 'EN', '2014-09-07 18:13:01.173', 'Spanish Empire', 1, 1, 394, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (398, 'O4', '2014-09-07 18:13:01.173', 'EN', '2014-09-07 18:13:01.173', 'Dutch Empire', 1, 1, 394, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (407, 'O1', '2014-09-07 18:13:01.22', 'EN', '2014-09-07 18:13:01.22', 'Adolph Hitler', 1, 1, 406, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (408, 'O2', '2014-09-07 18:13:01.22', 'EN', '2014-09-07 18:13:01.22', 'Napoleon', 1, 1, 406, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (409, 'O3', '2014-09-07 18:13:01.22', 'EN', '2014-09-07 18:13:01.22', 'Philip 2th King of Spain', 1, 1, 406, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (410, 'O4', '2014-09-07 18:13:01.22', 'EN', '2014-09-07 18:13:01.22', 'Julius Caesar', 1, 1, 406, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (451, 'O1', '2014-09-07 18:13:01.508', 'EN', '2014-09-07 18:13:01.508', 'Norway', 1, 1, 450, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (452, 'O2', '2014-09-07 18:13:01.509', 'EN', '2014-09-07 18:13:01.509', 'Sweden', 1, 1, 450, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (453, 'O3', '2014-09-07 18:13:01.509', 'EN', '2014-09-07 18:13:01.509', 'Denmark', 1, 1, 450, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (454, 'O4', '2014-09-07 18:13:01.509', 'EN', '2014-09-07 18:13:01.509', 'Iceland', 1, 1, 450, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (507, 'O1', '2014-09-07 18:13:01.653', 'EN', '2014-09-07 18:13:01.653', 'Portuguese Empire', 1, 1, 506, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (508, 'O2', '2014-09-07 18:13:01.653', 'EN', '2014-09-07 18:13:01.653', 'British Empire', 1, 1, 506, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (509, 'O3', '2014-09-07 18:13:01.653', 'EN', '2014-09-07 18:13:01.653', 'Spanish Empire', 1, 1, 506, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (510, 'O4', '2014-09-07 18:13:01.653', 'EN', '2014-09-07 18:13:01.653', 'Dutch Empire', 1, 1, 506, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (566, 'O1', '2014-09-07 18:13:01.887', 'EN', '2014-09-07 18:13:01.887', 'Agree strongly', 1, 1, 565, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (567, 'O2', '2014-09-07 18:13:01.887', 'EN', '2014-09-07 18:13:01.887', 'Agree somewhat', 1, 1, 565, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (568, 'O3', '2014-09-07 18:13:01.887', 'EN', '2014-09-07 18:13:01.887', 'Neither agree nor disagree', 1, 1, 565, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (569, 'O4', '2014-09-07 18:13:01.887', 'EN', '2014-09-07 18:13:01.887', 'Disagree somewhat', 1, 1, 565, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (570, 'O5', '2014-09-07 18:13:01.887', 'EN', '2014-09-07 18:13:01.887', 'Agree strongly', 1, 1, 565, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (571, 'O6', '2014-09-07 18:13:01.887', 'EN', '2014-09-07 18:13:01.887', 'Disagree strongly', 1, 1, 565, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (363, 'O1', '2014-09-07 18:13:01.063', 'EN', '2014-09-07 18:13:01.063', 'Westphalia', 1, 1, 362, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (364, 'O2', '2014-09-07 18:13:01.063', 'EN', '2014-09-07 18:13:01.063', 'Rome', 1, 1, 362, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (365, 'O3', '2014-09-07 18:13:01.063', 'EN', '2014-09-07 18:13:01.063', 'Brussels', 1, 1, 362, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (366, 'O4', '2014-09-07 18:13:01.063', 'EN', '2014-09-07 18:13:01.063', 'Versailles', 1, 1, 362, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (475, 'O1', '2014-09-07 18:13:01.583', 'EN', '2014-09-07 18:13:01.583', 'Westphalia', 1, 1, 474, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (476, 'O2', '2014-09-07 18:13:01.584', 'EN', '2014-09-07 18:13:01.584', 'Rome', 1, 1, 474, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (477, 'O3', '2014-09-07 18:13:01.584', 'EN', '2014-09-07 18:13:01.584', 'Brussels', 1, 1, 474, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (478, 'O4', '2014-09-07 18:13:01.584', 'EN', '2014-09-07 18:13:01.584', 'Versailles', 1, 1, 474, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (373, 'O1', '2014-09-07 18:13:01.095', 'EN', '2014-09-07 18:13:01.095', 'Norway', 1, 1, 372, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (374, 'O2', '2014-09-07 18:13:01.095', 'EN', '2014-09-07 18:13:01.095', 'Poland', 1, 1, 372, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (375, 'O3', '2014-09-07 18:13:01.095', 'EN', '2014-09-07 18:13:01.095', 'Macedonia', 1, 1, 372, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (376, 'O4', '2014-09-07 18:13:01.095', 'EN', '2014-09-07 18:13:01.095', 'Chipre', 1, 1, 372, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (463, 'O1', '2014-09-07 18:13:01.549', 'EN', '2014-09-07 18:13:01.549', 'Vatican City', 1, 1, 462, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (464, 'O2', '2014-09-07 18:13:01.549', 'EN', '2014-09-07 18:13:01.549', 'Roma', 1, 1, 462, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (465, 'O3', '2014-09-07 18:13:01.549', 'EN', '2014-09-07 18:13:01.549', 'Helsinki', 1, 1, 462, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (466, 'O4', '2014-09-07 18:13:01.55', 'EN', '2014-09-07 18:13:01.55', 'Viena', 1, 1, 462, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (497, 'O1', '2014-09-07 18:13:01.637', 'EN', '2014-09-07 18:13:01.637', 'Barcelona', 1, 1, 496, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (498, 'O2', '2014-09-07 18:13:01.637', 'EN', '2014-09-07 18:13:01.637', 'Lisboa', 1, 1, 496, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (499, 'O3', '2014-09-07 18:13:01.637', 'EN', '2014-09-07 18:13:01.637', 'Genoa', 1, 1, 496, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (500, 'O4', '2014-09-07 18:13:01.637', 'EN', '2014-09-07 18:13:01.637', 'Roma', 1, 1, 496, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (519, 'O1', '2014-09-07 18:13:01.684', 'EN', '2014-09-07 18:13:01.684', 'Adolph Hitler', 1, 1, 518, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (520, 'O2', '2014-09-07 18:13:01.684', 'EN', '2014-09-07 18:13:01.684', 'Napoleon', 1, 1, 518, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (521, 'O3', '2014-09-07 18:13:01.7', 'EN', '2014-09-07 18:13:01.7', 'Philip 2th King of Spain', 1, 1, 518, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (522, 'O4', '2014-09-07 18:13:01.7', 'EN', '2014-09-07 18:13:01.7', 'Julius Caesar', 1, 1, 518, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (555, 'O1', '2014-09-07 18:13:01.856', 'EN', '2014-09-07 18:13:01.856', 'Agree strongly', 1, 1, 554, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (556, 'O2', '2014-09-07 18:13:01.856', 'EN', '2014-09-07 18:13:01.856', 'Agree somewhat', 1, 1, 554, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (557, 'O3', '2014-09-07 18:13:01.856', 'EN', '2014-09-07 18:13:01.856', 'Neither agree nor disagree', 1, 1, 554, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (558, 'O4', '2014-09-07 18:13:01.856', 'EN', '2014-09-07 18:13:01.856', 'Disagree somewhat', 1, 1, 554, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (559, 'O5', '2014-09-07 18:13:01.856', 'EN', '2014-09-07 18:13:01.856', 'Agree strongly', 1, 1, 554, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (560, 'O6', '2014-09-07 18:13:01.856', 'EN', '2014-09-07 18:13:01.856', 'Disagree strongly', 1, 1, 554, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (485, 'O1', '2014-09-07 18:13:01.59', 'EN', '2014-09-07 18:13:01.59', 'Norway', 1, 1, 484, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (486, 'O2', '2014-09-07 18:13:01.59', 'EN', '2014-09-07 18:13:01.59', 'Poland', 1, 1, 484, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (487, 'O3', '2014-09-07 18:13:01.59', 'EN', '2014-09-07 18:13:01.59', 'Macedonia', 1, 1, 484, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (488, 'O4', '2014-09-07 18:13:01.606', 'EN', '2014-09-07 18:13:01.606', 'Chipre', 1, 1, 484, 3);


--
-- TOC entry 2372 (class 0 OID 91177)
-- Dependencies: 194
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
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (344, 'ES', 'Noruega', 339);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (345, 'ES', 'Suecia', 340);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (346, 'ES', 'Dinamarca', 341);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (347, 'ES', 'Islandia', 342);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (356, 'ES', 'Ciudad del Vaticano', 351);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (357, 'ES', 'Roma', 352);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (358, 'ES', 'Helsinki', 353);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (359, 'ES', 'Viena', 354);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (368, 'ES', 'Westphalia', 363);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (369, 'ES', 'Roma', 364);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (370, 'ES', 'Bruselas', 365);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (371, 'ES', 'Islandia', 366);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (378, 'ES', 'Noruega', 373);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (379, 'ES', 'Polonia', 374);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (380, 'ES', 'Macedonia', 375);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (381, 'ES', 'Chipre', 376);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (390, 'ES', 'Barcelona', 385);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (391, 'ES', 'Lisboa', 386);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (392, 'ES', 'Genova', 387);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (393, 'ES', 'Roma', 388);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (400, 'ES', 'Imperio Portugues', 395);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (401, 'ES', 'Imperio Británico', 396);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (402, 'ES', 'Imperio Español', 397);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (403, 'ES', 'Imperio Holandés', 398);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (412, 'ES', 'Adolfo Hitler', 407);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (413, 'ES', 'Napoleón', 408);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (414, 'ES', 'Felipe II', 409);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (415, 'ES', 'Julio Cesar', 410);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (456, 'ES', 'Noruega', 451);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (457, 'ES', 'Suecia', 452);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (458, 'ES', 'Dinamarca', 453);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (459, 'ES', 'Islandia', 454);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (468, 'ES', 'Ciudad del Vaticano', 463);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (469, 'ES', 'Roma', 464);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (470, 'ES', 'Helsinki', 465);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (471, 'ES', 'Viena', 466);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (480, 'ES', 'Westphalia', 475);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (481, 'ES', 'Roma', 476);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (482, 'ES', 'Bruselas', 477);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (483, 'ES', 'Islandia', 478);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (490, 'ES', 'Noruega', 485);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (491, 'ES', 'Polonia', 486);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (492, 'ES', 'Macedonia', 487);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (493, 'ES', 'Chipre', 488);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (502, 'ES', 'Barcelona', 497);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (503, 'ES', 'Lisboa', 498);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (504, 'ES', 'Genova', 499);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (505, 'ES', 'Roma', 500);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (512, 'ES', 'Imperio Portugues', 507);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (513, 'ES', 'Imperio Británico', 508);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (514, 'ES', 'Imperio Español', 509);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (515, 'ES', 'Imperio Holandés', 510);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (524, 'ES', 'Adolfo Hitler', 519);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (525, 'ES', 'Napoleón', 520);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (526, 'ES', 'Felipe II', 521);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (527, 'ES', 'Julio Cesar', 522);


--
-- TOC entry 2373 (class 0 OID 91185)
-- Dependencies: 195
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
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (337, 'ES', NULL, '¿Cuál es la capital de Malta?', 336);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (343, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 338);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (349, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 348);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (355, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 350);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (361, 'ES', NULL, '¿Que significa UE?', 360);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (367, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 362);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (377, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 372);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (383, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 382);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (389, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 384);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (399, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 394);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (405, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 404);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (411, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 406);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (449, 'ES', NULL, '¿Cuál es la capital de Malta?', 448);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (455, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 450);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (461, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 460);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (467, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 462);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (473, 'ES', NULL, '¿Que significa UE?', 472);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (479, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 474);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (489, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 484);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (495, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 494);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (501, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 496);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (511, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 506);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (517, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 516);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (523, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 518);


--
-- TOC entry 2350 (class 0 OID 86504)
-- Dependencies: 172
-- Data for Name: questionnaire_answers_12; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (51, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (52, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (53, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (54, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (101, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (102, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (103, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (104, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (151, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (152, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (153, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (154, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (201, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (202, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (203, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (204, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (251, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (252, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (253, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (254, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (301, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (302, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (303, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (304, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (351, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (352, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (353, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (354, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (401, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (402, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (403, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (404, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (451, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2351 (class 0 OID 86512)
-- Dependencies: 173
-- Data for Name: questionnaire_answers_124; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2352 (class 0 OID 86520)
-- Dependencies: 174
-- Data for Name: questionnaire_answers_215; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (51, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (52, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (53, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (54, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (101, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (102, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (103, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (104, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (151, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (152, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (153, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (154, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (201, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (202, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (203, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (204, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_215 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (251, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2353 (class 0 OID 86528)
-- Dependencies: 175
-- Data for Name: questionnaire_answers_327; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (51, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (52, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (53, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (54, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (101, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (102, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (103, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (104, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (151, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (152, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (153, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (154, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (201, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (202, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (203, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_327 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (204, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2354 (class 0 OID 86536)
-- Dependencies: 176
-- Data for Name: questionnaire_answers_439; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (51, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (52, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (53, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (54, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (101, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (102, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (103, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (104, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (151, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (152, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (153, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (154, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (201, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (202, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (203, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnaire_answers_439 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (204, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2355 (class 0 OID 86544)
-- Dependencies: 177
-- Data for Name: questionnaire_answers_551; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2375 (class 0 OID 91198)
-- Dependencies: 197
-- Data for Name: questionnaire_definition_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (13, 3, NULL, 1, 12);
INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (125, 3, NULL, 1, 124);
INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (216, 3, NULL, 1, 215);
INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (328, 3, NULL, 1, 327);
INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (440, 3, NULL, 1, 439);
INSERT INTO questionnaire_definition_permission (id, mask, role_id, user_id, target_id) VALUES (552, 3, NULL, 1, 551);


--
-- TOC entry 2371 (class 0 OID 91169)
-- Dependencies: 193
-- Data for Name: questionnaire_definition_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_definition_translation (id, language, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (14, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 12);
INSERT INTO questionnaire_definition_translation (id, language, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (126, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 124);
INSERT INTO questionnaire_definition_translation (id, language, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (217, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 215);
INSERT INTO questionnaire_definition_translation (id, language, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (329, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 327);
INSERT INTO questionnaire_definition_translation (id, language, description, end_text, title, welcome_text, questionnairedefinition_id) VALUES (441, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 439);


--
-- TOC entry 2376 (class 0 OID 91203)
-- Dependencies: 198
-- Data for Name: questionnaire_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (105, 3, NULL, 6, 104);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (109, 3, NULL, 4, 108);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (113, 3, NULL, 10, 112);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (117, 3, NULL, 8, 116);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (308, 3, NULL, 6, 307);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (312, 3, NULL, 4, 311);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (316, 3, NULL, 10, 315);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (320, 3, NULL, 8, 319);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (420, 3, NULL, 6, 419);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (424, 3, NULL, 4, 423);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (428, 3, NULL, 10, 427);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (432, 3, NULL, 8, 431);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (532, 3, NULL, 6, 531);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (536, 3, NULL, 4, 535);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (540, 3, NULL, 10, 539);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (544, 3, NULL, 8, 543);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (604, 3, NULL, 601, 603);
INSERT INTO questionnaire_permission (id, mask, role_id, user_id, target_id) VALUES (613, 3, NULL, 610, 612);


--
-- TOC entry 2377 (class 0 OID 91208)
-- Dependencies: 199
-- Data for Name: research_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (120, 7, NULL, 1, 103);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (123, 7, NULL, 1, 121);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (323, 7, NULL, 1, 306);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (326, 7, NULL, 1, 324);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (435, 7, NULL, 1, 418);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (438, 7, NULL, 1, 436);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (547, 7, NULL, 1, 530);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (550, 7, NULL, 1, 548);
INSERT INTO research_permission (id, mask, role_id, user_id, target_id) VALUES (588, 7, NULL, 1, 586);


--
-- TOC entry 2348 (class 0 OID 85804)
-- Dependencies: 170
-- Data for Name: schema_version; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2349 (class 0 OID 86499)
-- Dependencies: 171
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_124_seq', 0);
INSERT INTO sequence (seq_name, seq_count) VALUES ('SEQ_GEN', 650);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_551_seq', 0);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_12_seq', 500);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_215_seq', 300);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_327_seq', 250);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnaire_answers_439_seq', 250);


--
-- TOC entry 2383 (class 0 OID 91256)
-- Dependencies: 205
-- Data for Name: user_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_group (group_id, user_id) VALUES (3, 6);
INSERT INTO user_group (group_id, user_id) VALUES (3, 4);
INSERT INTO user_group (group_id, user_id) VALUES (3, 10);
INSERT INTO user_group (group_id, user_id) VALUES (3, 8);


--
-- TOC entry 2378 (class 0 OID 91213)
-- Dependencies: 200
-- Data for Name: user_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (2, 7, NULL, 1, 1);
INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (5, 7, NULL, 1, 4);
INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (7, 7, NULL, 1, 6);
INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (9, 7, NULL, 1, 8);
INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (11, 7, NULL, 1, 10);
INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (602, 7, NULL, NULL, 601);
INSERT INTO user_permission (id, mask, role_id, user_id, target_id) VALUES (611, 7, NULL, NULL, 610);


--
-- TOC entry 2384 (class 0 OID 91261)
-- Dependencies: 206
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



-- Completed on 2014-09-07 18:22:48

--
-- PostgreSQL database dump complete
--

