--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.4
-- Dumped by pg_dump version 9.2.4
-- Started on 2014-04-28 11:32:08

-- TOC entry 2175 (class 0 OID 116200)
-- Dependencies: 189
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, acronym, api_key, created_date, email, gender, given_names, last_modified_date, prefered_language, surname, username, createdby_id, lastmodifiedby_id) VALUES (1, 'SUPPSUPP', 'ON7O6AII5Q2CX2K', '2014-04-28 11:12:58.052', 'support@gazpacho.net', NULL, 'support', '2014-04-28 11:12:58.052', NULL, 'support', 'support', 1, 1);
INSERT INTO users (id, acronym, api_key, created_date, email, gender, given_names, last_modified_date, prefered_language, surname, username, createdby_id, lastmodifiedby_id) VALUES (3, 'TYRILANN', '7R3848A881SGT0Q', '2014-04-28 11:12:58.163', 'tyrion.lannister@kingslanding.net', 'MALE', 'Tyrion', '2014-04-28 11:12:58.163', 'EN', 'Lannister', NULL, 1, 1);
INSERT INTO users (id, acronym, api_key, created_date, email, gender, given_names, last_modified_date, prefered_language, surname, username, createdby_id, lastmodifiedby_id) VALUES (4, 'JONSNOW', 'TM3DDYU6V4CJLEE', '2014-04-28 11:12:58.17', 'jon.snow@nightswatch.net', 'MALE', 'Jon', '2014-04-28 11:12:58.17', 'ES', 'Snow', NULL, 1, 1);
INSERT INTO users (id, acronym, api_key, created_date, email, gender, given_names, last_modified_date, prefered_language, surname, username, createdby_id, lastmodifiedby_id) VALUES (5, 'ARYASTAR', 'UJBWL44YXQ1S6PO', '2014-04-28 11:12:58.178', 'arya.stark@winterfell.net', 'FEMALE', 'Arya', '2014-04-28 11:12:58.178', NULL, 'Stark', NULL, 1, 1);
INSERT INTO users (id, acronym, api_key, created_date, email, gender, given_names, last_modified_date, prefered_language, surname, username, createdby_id, lastmodifiedby_id) VALUES (6, 'CATESTAR', '1CWCSQND035JUZS', '2014-04-28 11:12:58.186', 'catelyn.stark@winterfell.net', 'FEMALE', 'Catelyn', '2014-04-28 11:12:58.186', 'FI', 'Stark', NULL, 1, 1);


--
-- TOC entry 2163 (class 0 OID 116107)
-- Dependencies: 177
-- Data for Name: questionnair_definition; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, status, description, title, welcometext, createdby_id, lastmodifiedby_id) VALUES (7, '2014-04-28 11:12:58.214', 'EN', '2014-04-28 11:12:58.214', 'CONFIRMED', 'How much do you know about Europe? Answer to this questions and let''s find out!', 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnair.', 1, 1);
INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, status, description, title, welcometext, createdby_id, lastmodifiedby_id) VALUES (120, '2014-04-28 11:12:59.528', 'EN', '2014-04-28 11:12:59.528', 'CONFIRMED', 'We at BIG DEES take pride in providing you with the highest standards of QUALITY, SERVICE, CLEANLINESS and VALUE in the restaurant industry.', 'Food Quality QuestionnairDefinition', 'Your opinion is extremely important in evaluating our business. Thank you for taking a moment to questionOption the following questions:', 1, 1);


--
-- TOC entry 2161 (class 0 OID 116094)
-- Dependencies: 175
-- Data for Name: question_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (9, '2014-04-28 11:12:58.294', 'EN', '2014-04-28 11:12:58.294', 'European Capitals', 1, 1, 7, 0);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (11, '2014-04-28 11:12:58.329', 'EN', '2014-04-28 11:12:58.329', 'European Union', 1, 1, 7, 1);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (13, '2014-04-28 11:12:58.357', 'EN', '2014-04-28 11:12:58.357', 'European History', 1, 1, 7, 2);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (121, '2014-04-28 11:12:59.537', 'EN', '2014-04-28 11:12:59.537', 'Fast Food QuestionnairDefinition - QuestionGroup', 1, 1, 120, 0);


--
-- TOC entry 2160 (class 0 OID 116086)
-- Dependencies: 174
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (15, 'Q1', '2014-04-28 11:12:58.406', 'EN', '2014-04-28 11:12:58.406', true, 'S', 'What is the capital of Malta?', 1, 1, NULL, 9, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (17, 'Q2', '2014-04-28 11:12:58.465', 'EN', '2014-04-28 11:12:58.465', true, 'L', 'Which the country has as capital Copenhague?', 1, 1, NULL, 9, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (27, 'Q3', '2014-04-28 11:12:58.562', 'EN', '2014-04-28 11:12:58.562', true, 'N', 'How many European capitals were founded by Romans?', 1, 1, NULL, 9, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (29, 'Q4', '2014-04-28 11:12:58.604', 'EN', '2014-04-28 11:12:58.604', false, 'M', 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 9, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (39, 'Q5', '2014-04-28 11:12:58.669', 'EN', '2014-04-28 11:12:58.669', true, 'S', 'What does EU stand for??', 1, 1, NULL, 11, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (41, 'Q6', '2014-04-28 11:12:58.691', 'EN', '2014-04-28 11:12:58.691', true, 'L', 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 11, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (51, 'Q7', '2014-04-28 11:12:58.763', 'EN', '2014-04-28 11:12:58.763', false, 'M', 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 11, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (61, 'Q8', '2014-04-28 11:12:58.817', 'EN', '2014-04-28 11:12:58.817', true, 'N', 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 11, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (63, 'Q9', '2014-04-28 11:12:58.85', 'EN', '2014-04-28 11:12:58.85', true, 'L', 'Where was Christopher columbus was born?', 1, 1, NULL, 13, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (73, 'Q10', '2014-04-28 11:12:58.893', 'EN', '2014-04-28 11:12:58.893', true, 'L', 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 13, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (83, 'Q11', '2014-04-28 11:12:58.931', 'EN', '2014-04-28 11:12:58.931', true, 'S', 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 13, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (85, 'Q12', '2014-04-28 11:12:58.957', 'EN', '2014-04-28 11:12:58.957', true, 'L', 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 13, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (122, 'Q1', '2014-04-28 11:12:59.555', 'EN', '2014-04-28 11:12:59.555', true, 'F', '<b>Food Quality</b>', 1, 1, NULL, 121, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (129, 'Q1.1', '2014-04-28 11:12:59.562', 'EN', '2014-04-28 11:12:59.562', false, 'L', 'The food is served hot and fresh', 1, 1, 122, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (130, 'Q1.2', '2014-04-28 11:12:59.563', 'EN', '2014-04-28 11:12:59.563', false, 'L', 'The menu has a good variety of items', 1, 1, 122, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (131, 'Q1.3', '2014-04-28 11:12:59.563', 'EN', '2014-04-28 11:12:59.563', false, 'L', 'The quality of food is excellent', 1, 1, 122, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (132, 'Q1.4', '2014-04-28 11:12:59.564', 'EN', '2014-04-28 11:12:59.564', false, 'L', 'The food is tasty and flavorful', 1, 1, 122, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (133, 'Q2', '2014-04-28 11:12:59.601', 'EN', '2014-04-28 11:12:59.601', true, 'F', '<b>Resturant</b>', 1, 1, NULL, 121, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (140, 'Q2.1', '2014-04-28 11:12:59.607', 'EN', '2014-04-28 11:12:59.607', false, 'L', 'My food order was correct and complete', 1, 1, 133, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (141, 'Q2.2', '2014-04-28 11:12:59.608', 'EN', '2014-04-28 11:12:59.608', false, 'L', 'Employees are patient when taking my order', 1, 1, 133, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (142, 'Q2.3', '2014-04-28 11:12:59.608', 'EN', '2014-04-28 11:12:59.608', false, 'L', 'I was served promptly', 1, 1, 133, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (143, 'Q2.4', '2014-04-28 11:12:59.609', 'EN', '2014-04-28 11:12:59.609', false, 'L', 'Availability of sauces, utensils, napkins, etc. was good', 1, 1, 133, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (144, 'Q2.5', '2014-04-28 11:12:59.61', 'EN', '2014-04-28 11:12:59.61', false, 'L', 'The menu board was easy to read', 1, 1, 133, NULL, 4, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (145, 'Q2.6', '2014-04-28 11:12:59.611', 'EN', '2014-04-28 11:12:59.611', false, 'L', 'The drive-thru sound system was cleara', 1, 1, 133, NULL, 5, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (146, 'Q3', '2014-04-28 11:12:59.65', 'EN', '2014-04-28 11:12:59.65', true, 'L', 'Indicate total household income', 1, 1, NULL, 121, NULL, 2);


--
-- TOC entry 2165 (class 0 OID 116123)
-- Dependencies: 179
-- Data for Name: research; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (97, '2014-04-28 11:12:59.354', '2014-04-28 11:12:59.341', '2014-04-28 11:12:59.354', 'New QuizEuropean general knowledge quiz started', '2014-04-28 11:12:59.342', 'BY_INVITATION', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (118, '2014-04-28 11:12:59.513', '2014-04-28 11:12:59.506', '2014-04-28 11:12:59.513', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-04-28 11:12:59.507', 'OPEN_ACCESS', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (154, '2014-04-28 11:12:59.825', '2014-04-28 11:12:59.818', '2014-04-28 11:12:59.825', 'New customer satisfation survey Food Quality QuestionnairDefinition started', '2014-04-28 11:12:59.818', 'OPEN_ACCESS', 1, 1);


--
-- TOC entry 2162 (class 0 OID 116102)
-- Dependencies: 176
-- Data for Name: questionnair; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (98, 1, '2014-04-28 11:12:59.376', '2014-04-28 11:12:59.376', 'CONFIRMED', NULL, 1, 1, 7, 97, 6);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (103, 2, '2014-04-28 11:12:59.447', '2014-04-28 11:12:59.447', 'CONFIRMED', NULL, 1, 1, 7, 97, 5);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (108, 3, '2014-04-28 11:12:59.466', '2014-04-28 11:12:59.466', 'CONFIRMED', NULL, 1, 1, 7, 97, 4);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (113, 4, '2014-04-28 11:12:59.485', '2014-04-28 11:12:59.485', 'CONFIRMED', NULL, 1, 1, 7, 97, 3);


--
-- TOC entry 2155 (class 0 OID 116049)
-- Dependencies: 169
-- Data for Name: browsed_element; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2172 (class 0 OID 116179)
-- Dependencies: 186
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO groups (id, created_date, description, last_modified_date, name, createdby_id, lastmodifiedby_id) VALUES (2, '2014-04-28 11:12:58.154', 'Respondent group', '2014-04-28 11:12:58.154', 'Respondents', 1, 1);


--
-- TOC entry 2174 (class 0 OID 116192)
-- Dependencies: 188
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO role (id, description, name, scope) VALUES (99, 'Specific role for Catelyn Stark ', 'CATESTAR', 'USER');
INSERT INTO role (id, description, name, scope) VALUES (104, 'Specific role for Arya Stark ', 'ARYASTAR', 'USER');
INSERT INTO role (id, description, name, scope) VALUES (109, 'Specific role for Jon Snow ', 'JONSNOW', 'USER');
INSERT INTO role (id, description, name, scope) VALUES (114, 'Specific role for Tyrion Lannister ', 'TYRILANN', 'USER');


--
-- TOC entry 2176 (class 0 OID 116212)
-- Dependencies: 190
-- Data for Name: group_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2154 (class 0 OID 116041)
-- Dependencies: 168
-- Data for Name: invitation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (101, 'P', 'ACTIVE', '3AO9INNVJU', 97, 6);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (106, 'P', 'ACTIVE', '8T2T6E3Y70', 97, 5);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (111, 'P', 'ACTIVE', 'VRK4AN1YAP', 97, 4);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (116, 'P', 'ACTIVE', 'XT1D3CRE1B', 97, 3);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (119, 'A', 'ACTIVE', 'JGDTL0UPZ5', 118, NULL);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (155, 'A', 'ACTIVE', '04ZPU8LWU9', 154, NULL);


--
-- TOC entry 2157 (class 0 OID 116062)
-- Dependencies: 171
-- Data for Name: label_set; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2156 (class 0 OID 116054)
-- Dependencies: 170
-- Data for Name: label; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2166 (class 0 OID 116131)
-- Dependencies: 180
-- Data for Name: label_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2158 (class 0 OID 116070)
-- Dependencies: 172
-- Data for Name: mail_message; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (102, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=3AO9INNVJU">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (107, 'Estimado Sr. Stark, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=8T2T6E3Y70">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (112, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=VRK4AN1YAP">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (117, 'Dear Mr. Lannister, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=XT1D3CRE1B">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'tyrion.lannister@kingslanding.net');


--
-- TOC entry 2159 (class 0 OID 116078)
-- Dependencies: 173
-- Data for Name: mail_message_template; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (95, '2014-04-28 11:12:59.053', 'support@gazpacho.net', 'EN', '2014-04-28 11:12:59.053', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'Invitation to participate in a questionnair', 1, 1, 7);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (152, '2014-04-28 11:12:59.69', 'support@gazpacho.net', 'EN', '2014-04-28 11:12:59.69', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'Invitation to participate in a questionnair', 1, 1, 120);


--
-- TOC entry 2167 (class 0 OID 116139)
-- Dependencies: 181
-- Data for Name: mail_message_template_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (96, '2014-04-28 11:12:59.072', 'ES', '2014-04-28 11:12:59.072', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 95);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (153, '2014-04-28 11:12:59.696', 'ES', '2014-04-28 11:12:59.696', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 152);


--
-- TOC entry 2173 (class 0 OID 116187)
-- Dependencies: 187
-- Data for Name: permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO permission (id, entity_id, numeral, scope, role_id) VALUES (100, 98, 3, 'Q', 99);
INSERT INTO permission (id, entity_id, numeral, scope, role_id) VALUES (105, 103, 3, 'Q', 104);
INSERT INTO permission (id, entity_id, numeral, scope, role_id) VALUES (110, 108, 3, 'Q', 109);
INSERT INTO permission (id, entity_id, numeral, scope, role_id) VALUES (115, 113, 3, 'Q', 114);


--
-- TOC entry 2168 (class 0 OID 116147)
-- Dependencies: 182
-- Data for Name: question_group_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_group_translation (id, language, title, questiongroup_id) VALUES (10, 'ES', 'Capitales Europeas', 9);
INSERT INTO question_group_translation (id, language, title, questiongroup_id) VALUES (12, 'ES', 'Unión Europea', 11);
INSERT INTO question_group_translation (id, language, title, questiongroup_id) VALUES (14, 'ES', 'Sociedad', 13);


--
-- TOC entry 2164 (class 0 OID 116115)
-- Dependencies: 178
-- Data for Name: question_option; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (18, 'O1', '2014-04-28 11:12:58.475', 'EN', '2014-04-28 11:12:58.475', 'Norway', 1, 1, 17, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (19, 'O2', '2014-04-28 11:12:58.477', 'EN', '2014-04-28 11:12:58.477', 'Sweden', 1, 1, 17, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (20, 'O3', '2014-04-28 11:12:58.479', 'EN', '2014-04-28 11:12:58.479', 'Denmark', 1, 1, 17, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (21, 'O4', '2014-04-28 11:12:58.48', 'EN', '2014-04-28 11:12:58.48', 'Iceland', 1, 1, 17, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (30, 'O1', '2014-04-28 11:12:58.607', 'EN', '2014-04-28 11:12:58.607', 'Vatican City', 1, 1, 29, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (31, 'O2', '2014-04-28 11:12:58.608', 'EN', '2014-04-28 11:12:58.608', 'Roma', 1, 1, 29, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (32, 'O3', '2014-04-28 11:12:58.61', 'EN', '2014-04-28 11:12:58.61', 'Helsinki', 1, 1, 29, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (33, 'O4', '2014-04-28 11:12:58.612', 'EN', '2014-04-28 11:12:58.612', 'Viena', 1, 1, 29, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (42, 'O1', '2014-04-28 11:12:58.694', 'EN', '2014-04-28 11:12:58.694', 'Westphalia', 1, 1, 41, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (43, 'O2', '2014-04-28 11:12:58.696', 'EN', '2014-04-28 11:12:58.696', 'Rome', 1, 1, 41, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (44, 'O3', '2014-04-28 11:12:58.697', 'EN', '2014-04-28 11:12:58.697', 'Brussels', 1, 1, 41, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (45, 'O4', '2014-04-28 11:12:58.698', 'EN', '2014-04-28 11:12:58.698', 'Versailles', 1, 1, 41, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (52, 'O1', '2014-04-28 11:12:58.764', 'EN', '2014-04-28 11:12:58.764', 'Norway', 1, 1, 51, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (53, 'O2', '2014-04-28 11:12:58.765', 'EN', '2014-04-28 11:12:58.765', 'Poland', 1, 1, 51, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (54, 'O3', '2014-04-28 11:12:58.766', 'EN', '2014-04-28 11:12:58.766', 'Macedonia', 1, 1, 51, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (55, 'O4', '2014-04-28 11:12:58.767', 'EN', '2014-04-28 11:12:58.767', 'Chipre', 1, 1, 51, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (64, 'O1', '2014-04-28 11:12:58.852', 'EN', '2014-04-28 11:12:58.852', 'Barcelona', 1, 1, 63, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (65, 'O2', '2014-04-28 11:12:58.853', 'EN', '2014-04-28 11:12:58.853', 'Lisboa', 1, 1, 63, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (66, 'O3', '2014-04-28 11:12:58.854', 'EN', '2014-04-28 11:12:58.854', 'Genoa', 1, 1, 63, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (67, 'O4', '2014-04-28 11:12:58.856', 'EN', '2014-04-28 11:12:58.856', 'Roma', 1, 1, 63, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (74, 'O1', '2014-04-28 11:12:58.894', 'EN', '2014-04-28 11:12:58.894', 'Portuguese Empire', 1, 1, 73, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (75, 'O2', '2014-04-28 11:12:58.895', 'EN', '2014-04-28 11:12:58.895', 'British Empire', 1, 1, 73, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (76, 'O3', '2014-04-28 11:12:58.896', 'EN', '2014-04-28 11:12:58.896', 'Spanish Empire', 1, 1, 73, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (77, 'O4', '2014-04-28 11:12:58.897', 'EN', '2014-04-28 11:12:58.897', 'Dutch Empire', 1, 1, 73, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (86, 'O1', '2014-04-28 11:12:58.958', 'EN', '2014-04-28 11:12:58.958', 'Adolph Hitler', 1, 1, 85, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (87, 'O2', '2014-04-28 11:12:58.959', 'EN', '2014-04-28 11:12:58.959', 'Napoleon', 1, 1, 85, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (88, 'O3', '2014-04-28 11:12:58.96', 'EN', '2014-04-28 11:12:58.96', 'Philip 2th King of Spain', 1, 1, 85, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (89, 'O4', '2014-04-28 11:12:58.961', 'EN', '2014-04-28 11:12:58.961', 'Julius Caesar', 1, 1, 85, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (123, 'O1', '2014-04-28 11:12:59.556', 'EN', '2014-04-28 11:12:59.556', 'Agree strongly', 1, 1, 122, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (124, 'O2', '2014-04-28 11:12:59.557', 'EN', '2014-04-28 11:12:59.557', 'Agree somewhat', 1, 1, 122, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (125, 'O3', '2014-04-28 11:12:59.558', 'EN', '2014-04-28 11:12:59.558', 'Neither agree nor disagree', 1, 1, 122, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (126, 'O4', '2014-04-28 11:12:59.559', 'EN', '2014-04-28 11:12:59.559', 'Disagree somewhat', 1, 1, 122, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (127, 'O5', '2014-04-28 11:12:59.56', 'EN', '2014-04-28 11:12:59.56', 'Agree strongly', 1, 1, 122, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (128, 'O6', '2014-04-28 11:12:59.561', 'EN', '2014-04-28 11:12:59.561', 'Disagree strongly', 1, 1, 122, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (134, 'O1', '2014-04-28 11:12:59.602', 'EN', '2014-04-28 11:12:59.602', 'Agree strongly', 1, 1, 133, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (135, 'O2', '2014-04-28 11:12:59.603', 'EN', '2014-04-28 11:12:59.603', 'Agree somewhat', 1, 1, 133, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (136, 'O3', '2014-04-28 11:12:59.603', 'EN', '2014-04-28 11:12:59.603', 'Neither agree nor disagree', 1, 1, 133, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (137, 'O4', '2014-04-28 11:12:59.604', 'EN', '2014-04-28 11:12:59.604', 'Disagree somewhat', 1, 1, 133, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (138, 'O5', '2014-04-28 11:12:59.605', 'EN', '2014-04-28 11:12:59.605', 'Agree strongly', 1, 1, 133, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (139, 'O6', '2014-04-28 11:12:59.606', 'EN', '2014-04-28 11:12:59.606', 'Disagree strongly', 1, 1, 133, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (147, 'O1', '2014-04-28 11:12:59.652', 'EN', '2014-04-28 11:12:59.652', 'under 25,000€', 1, 1, 146, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (148, 'O2', '2014-04-28 11:12:59.653', 'EN', '2014-04-28 11:12:59.653', '25,000 - 29,999€', 1, 1, 146, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (149, 'O3', '2014-04-28 11:12:59.654', 'EN', '2014-04-28 11:12:59.654', '30,000 - 34,999€', 1, 1, 146, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (150, 'O4', '2014-04-28 11:12:59.655', 'EN', '2014-04-28 11:12:59.655', '35,000 - 39,999€', 1, 1, 146, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (151, 'O5', '2014-04-28 11:12:59.657', 'EN', '2014-04-28 11:12:59.657', 'Over 85,000€', 1, 1, 146, 4);


--
-- TOC entry 2170 (class 0 OID 116163)
-- Dependencies: 184
-- Data for Name: question_option_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (23, 'ES', 'Noruega', 18);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (24, 'ES', 'Suecia', 19);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (25, 'ES', 'Dinamarca', 20);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (26, 'ES', 'Islandia', 21);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (35, 'ES', 'Ciudad del Vaticano', 30);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (36, 'ES', 'Roma', 31);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (37, 'ES', 'Helsinki', 32);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (38, 'ES', 'Viena', 33);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (47, 'ES', 'Westphalia', 30);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (48, 'ES', 'Roma', 31);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (49, 'ES', 'Bruselas', 32);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (50, 'ES', 'Islandia', 33);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (57, 'ES', 'Noruega', 52);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (58, 'ES', 'Polonia', 53);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (59, 'ES', 'Macedonia', 54);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (60, 'ES', 'Chipre', 55);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (69, 'ES', 'Barcelona', 64);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (70, 'ES', 'Lisboa', 65);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (71, 'ES', 'Genova', 66);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (72, 'ES', 'Roma', 67);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (79, 'ES', 'Imperio Portugues', 74);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (80, 'ES', 'Imperio Británico', 75);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (81, 'ES', 'Imperio Español', 76);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (82, 'ES', 'Imperio Holandés', 77);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (91, 'ES', 'Adolfo Hitler', 86);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (92, 'ES', 'Napoleón', 87);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (93, 'ES', 'Felipe II', 88);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (94, 'ES', 'Julio Cesar', 89);


--
-- TOC entry 2171 (class 0 OID 116171)
-- Dependencies: 185
-- Data for Name: question_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_translation (id, language, title, question_id) VALUES (16, 'ES', '¿Cuál es la capital de Malta?', 15);
INSERT INTO question_translation (id, language, title, question_id) VALUES (22, 'ES', '¿Qué pais tiene como capital Copenague?', 17);
INSERT INTO question_translation (id, language, title, question_id) VALUES (28, 'ES', '¿Cuantas capitales europeas fueron fundadas por los romanos?', 27);
INSERT INTO question_translation (id, language, title, question_id) VALUES (34, 'ES', '¿Cuantas de estas capitales Europeas estan al pie de un río?', 29);
INSERT INTO question_translation (id, language, title, question_id) VALUES (40, 'ES', '¿Que significa UE?', 39);
INSERT INTO question_translation (id, language, title, question_id) VALUES (46, 'ES', '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 29);
INSERT INTO question_translation (id, language, title, question_id) VALUES (56, 'ES', '¿Cuál de estos países europeos pertenecen a la zona euro?', 51);
INSERT INTO question_translation (id, language, title, question_id) VALUES (62, 'ES', '¿Cuantos marcos finlandeses necesitas para tener un euro?', 61);
INSERT INTO question_translation (id, language, title, question_id) VALUES (68, 'ES', '¿Dónde nació Cristobal Colón?', 63);
INSERT INTO question_translation (id, language, title, question_id) VALUES (78, 'ES', '¿Cuál fue el imperio más grande en el siglo XVI?', 73);
INSERT INTO question_translation (id, language, title, question_id) VALUES (84, 'ES', '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 83);
INSERT INTO question_translation (id, language, title, question_id) VALUES (90, 'ES', '¿Cual de estos hombres causó más bajas en Europa?', 85);


--
-- TOC entry 2181 (class 0 OID 116495)
-- Dependencies: 195
-- Data for Name: questionnair_answers_120; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2180 (class 0 OID 116487)
-- Dependencies: 194
-- Data for Name: questionnair_answers_7; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_answers_7 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_7 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_7 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_7 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2169 (class 0 OID 116155)
-- Dependencies: 183
-- Data for Name: questionnair_definition_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition_translation (id, language, description, title, welcometext, questionnairdefinition_id) VALUES (8, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 7);


--
-- TOC entry 2179 (class 0 OID 116482)
-- Dependencies: 193
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnair_answers_7_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('SEQ_GEN', 200);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnair_answers_120_seq', 0);


--
-- TOC entry 2177 (class 0 OID 116217)
-- Dependencies: 191
-- Data for Name: user_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_group (group_id, user_id) VALUES (2, 6);
INSERT INTO user_group (group_id, user_id) VALUES (2, 5);
INSERT INTO user_group (group_id, user_id) VALUES (2, 4);
INSERT INTO user_group (group_id, user_id) VALUES (2, 3);


--
-- TOC entry 2178 (class 0 OID 116222)
-- Dependencies: 192
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_role (role_id, user_id) VALUES (99, 6);
INSERT INTO user_role (role_id, user_id) VALUES (104, 5);
INSERT INTO user_role (role_id, user_id) VALUES (109, 4);
INSERT INTO user_role (role_id, user_id) VALUES (114, 3);


-- Completed on 2014-04-28 11:32:08

--
-- PostgreSQL database dump complete
--

