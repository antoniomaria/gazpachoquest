--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.4
-- Dumped by pg_dump version 9.2.4
-- Started on 2014-04-29 14:18:09

--
-- TOC entry 2173 (class 0 OID 125170)
-- Dependencies: 188
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO role (id, description, name) VALUES (2, 'Specific role for support support ', 'User Role');
INSERT INTO role (id, description, name) VALUES (5, 'Specific role for Tyrion Lannister ', 'User Role');
INSERT INTO role (id, description, name) VALUES (7, 'Specific role for Jon Snow ', 'User Role');
INSERT INTO role (id, description, name) VALUES (9, 'Specific role for Arya Stark ', 'User Role');
INSERT INTO role (id, description, name) VALUES (11, 'Specific role for Catelyn Stark ', 'User Role');


--
-- TOC entry 2174 (class 0 OID 125178)
-- Dependencies: 189
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, api_key, secret, created_date, email, gender, given_names, last_modified_date, preferred_language, surname, username, createdby_id, defaultrole_id, lastmodifiedby_id) VALUES (1, 'PKCC00D3YH83KEP', 'L0LTMJ1XAMEY13FT27MWZMQX1LWK8I1L', '2014-04-29 14:09:28.906', 'support@gazpacho.net', NULL, 'support', '2014-04-29 14:09:28.906', NULL, 'support', 'support', 1, 2, 1);
INSERT INTO users (id, api_key, secret, created_date, email, gender, given_names, last_modified_date, preferred_language, surname, username, createdby_id, defaultrole_id, lastmodifiedby_id) VALUES (4, 'TKIETCJZ3V6NOSM', 'IQO27YUZO8NJ7RADIK6SJ9BQZNYP4EMO', '2014-04-29 14:09:29.042', 'tyrion.lannister@kingslanding.net', 'M', 'Tyrion', '2014-04-29 14:09:29.042', 'EN', 'Lannister', NULL, 1, 5, 1);
INSERT INTO users (id, api_key, secret, created_date, email, gender, given_names, last_modified_date, preferred_language, surname, username, createdby_id, defaultrole_id, lastmodifiedby_id) VALUES (6, 'FGFQM8T6YPVSW4Q', '39JYOYPWYR46R38OAOTVRZJMEXNJ46HL', '2014-04-29 14:09:29.05', 'jon.snow@nightswatch.net', 'M', 'Jon', '2014-04-29 14:09:29.05', 'ES', 'Snow', NULL, 1, 7, 1);
INSERT INTO users (id, api_key, secret, created_date, email, gender, given_names, last_modified_date, preferred_language, surname, username, createdby_id, defaultrole_id, lastmodifiedby_id) VALUES (8, 'WR7MZM016D4YXN5', 'ZBH1QL28VZEE00XHH7N4R16Q8ZRURU5P', '2014-04-29 14:09:29.058', 'arya.stark@winterfell.net', 'F', 'Arya', '2014-04-29 14:09:29.058', NULL, 'Stark', NULL, 1, 9, 1);
INSERT INTO users (id, api_key, secret, created_date, email, gender, given_names, last_modified_date, preferred_language, surname, username, createdby_id, defaultrole_id, lastmodifiedby_id) VALUES (10, 'HC00N1926K0ZKAF', 'EQSV5ARQY1LLHKDLO8EF9RMBKV9T95K5', '2014-04-29 14:09:29.067', 'catelyn.stark@winterfell.net', 'F', 'Catelyn', '2014-04-29 14:09:29.067', 'FI', 'Stark', NULL, 1, 11, 1);


--
-- TOC entry 2162 (class 0 OID 125085)
-- Dependencies: 177
-- Data for Name: questionnair_definition; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, status, description, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (12, '2014-04-29 14:09:29.094', 'EN', '2014-04-29 14:09:29.094', 'C', 'How much do you know about Europe? Answer to this questions and let''s find out!', 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnair.', 1, 1);
INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, status, description, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (121, '2014-04-29 14:09:30.128', 'EN', '2014-04-29 14:09:30.128', 'C', 'We at BIG DEES take pride in providing you with the highest standards of QUALITY, SERVICE, CLEANLINESS and VALUE in the restaurant industry.', 'Food Quality QuestionnairDefinition', 'Your opinion is extremely important in evaluating our business. Thank you for taking a moment to questionOption the following questions:', 1, 1);


--
-- TOC entry 2160 (class 0 OID 125072)
-- Dependencies: 175
-- Data for Name: question_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (14, '2014-04-29 14:09:29.15', 'EN', '2014-04-29 14:09:29.15', 'European Capitals', 1, 1, 12, 0);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (16, '2014-04-29 14:09:29.185', 'EN', '2014-04-29 14:09:29.185', 'European Union', 1, 1, 12, 1);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (18, '2014-04-29 14:09:29.209', 'EN', '2014-04-29 14:09:29.209', 'European History', 1, 1, 12, 2);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (122, '2014-04-29 14:09:30.137', 'EN', '2014-04-29 14:09:30.137', 'Fast Food QuestionnairDefinition - QuestionGroup', 1, 1, 121, 0);


--
-- TOC entry 2159 (class 0 OID 125064)
-- Dependencies: 174
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (20, 'Q1', '2014-04-29 14:09:29.268', 'EN', '2014-04-29 14:09:29.268', true, 'S', 'What is the capital of Malta?', 1, 1, NULL, 14, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (22, 'Q2', '2014-04-29 14:09:29.321', 'EN', '2014-04-29 14:09:29.321', true, 'L', 'Which the country has as capital Copenhague?', 1, 1, NULL, 14, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (32, 'Q3', '2014-04-29 14:09:29.393', 'EN', '2014-04-29 14:09:29.393', true, 'N', 'How many European capitals were founded by Romans?', 1, 1, NULL, 14, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (34, 'Q4', '2014-04-29 14:09:29.423', 'EN', '2014-04-29 14:09:29.423', false, 'M', 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 14, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (44, 'Q5', '2014-04-29 14:09:29.47', 'EN', '2014-04-29 14:09:29.47', true, 'S', 'What does EU stand for??', 1, 1, NULL, 16, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (46, 'Q6', '2014-04-29 14:09:29.49', 'EN', '2014-04-29 14:09:29.49', true, 'L', 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 16, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (56, 'Q7', '2014-04-29 14:09:29.535', 'EN', '2014-04-29 14:09:29.535', false, 'M', 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 16, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (66, 'Q8', '2014-04-29 14:09:29.58', 'EN', '2014-04-29 14:09:29.58', true, 'N', 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 16, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (68, 'Q9', '2014-04-29 14:09:29.603', 'EN', '2014-04-29 14:09:29.603', true, 'L', 'Where was Christopher columbus was born?', 1, 1, NULL, 18, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (78, 'Q10', '2014-04-29 14:09:29.64', 'EN', '2014-04-29 14:09:29.64', true, 'L', 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 18, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (88, 'Q11', '2014-04-29 14:09:29.68', 'EN', '2014-04-29 14:09:29.68', true, 'S', 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 18, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (90, 'Q12', '2014-04-29 14:09:29.704', 'EN', '2014-04-29 14:09:29.704', true, 'L', 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 18, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (123, 'Q1', '2014-04-29 14:09:30.154', 'EN', '2014-04-29 14:09:30.154', true, 'F', '<b>Food Quality</b>', 1, 1, NULL, 122, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (130, 'Q1.1', '2014-04-29 14:09:30.16', 'EN', '2014-04-29 14:09:30.16', false, 'L', 'The food is served hot and fresh', 1, 1, 123, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (131, 'Q1.2', '2014-04-29 14:09:30.16', 'EN', '2014-04-29 14:09:30.16', false, 'L', 'The menu has a good variety of items', 1, 1, 123, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (132, 'Q1.3', '2014-04-29 14:09:30.161', 'EN', '2014-04-29 14:09:30.161', false, 'L', 'The quality of food is excellent', 1, 1, 123, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (133, 'Q1.4', '2014-04-29 14:09:30.162', 'EN', '2014-04-29 14:09:30.162', false, 'L', 'The food is tasty and flavorful', 1, 1, 123, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (134, 'Q2', '2014-04-29 14:09:30.194', 'EN', '2014-04-29 14:09:30.194', true, 'F', '<b>Resturant</b>', 1, 1, NULL, 122, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (141, 'Q2.1', '2014-04-29 14:09:30.2', 'EN', '2014-04-29 14:09:30.2', false, 'L', 'My food order was correct and complete', 1, 1, 134, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (142, 'Q2.2', '2014-04-29 14:09:30.201', 'EN', '2014-04-29 14:09:30.201', false, 'L', 'Employees are patient when taking my order', 1, 1, 134, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (143, 'Q2.3', '2014-04-29 14:09:30.202', 'EN', '2014-04-29 14:09:30.202', false, 'L', 'I was served promptly', 1, 1, 134, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (144, 'Q2.4', '2014-04-29 14:09:30.202', 'EN', '2014-04-29 14:09:30.202', false, 'L', 'Availability of sauces, utensils, napkins, etc. was good', 1, 1, 134, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (145, 'Q2.5', '2014-04-29 14:09:30.203', 'EN', '2014-04-29 14:09:30.203', false, 'L', 'The menu board was easy to read', 1, 1, 134, NULL, 4, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (146, 'Q2.6', '2014-04-29 14:09:30.204', 'EN', '2014-04-29 14:09:30.204', false, 'L', 'The drive-thru sound system was cleara', 1, 1, 134, NULL, 5, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (147, 'Q3', '2014-04-29 14:09:30.242', 'EN', '2014-04-29 14:09:30.242', true, 'L', 'Indicate total household income', 1, 1, NULL, 122, NULL, 2);


--
-- TOC entry 2164 (class 0 OID 125101)
-- Dependencies: 179
-- Data for Name: research; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (102, '2014-04-29 14:09:29.979', '2014-04-29 14:09:29.966', '2014-04-29 14:09:29.979', 'New QuizEuropean general knowledge quiz started', '2014-04-29 14:09:29.966', 'P', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (119, '2014-04-29 14:09:30.114', '2014-04-29 14:09:30.108', '2014-04-29 14:09:30.114', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-04-29 14:09:30.108', 'O', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (155, '2014-04-29 14:09:30.427', '2014-04-29 14:09:30.42', '2014-04-29 14:09:30.427', 'New customer satisfation survey Food Quality QuestionnairDefinition started', '2014-04-29 14:09:30.42', 'O', 1, 1);


--
-- TOC entry 2161 (class 0 OID 125080)
-- Dependencies: 176
-- Data for Name: questionnair; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (103, 1, '2014-04-29 14:09:30', '2014-04-29 14:09:30', 'C', NULL, 1, 1, 12, 102, 6);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (107, 2, '2014-04-29 14:09:30.055', '2014-04-29 14:09:30.055', 'C', NULL, 1, 1, 12, 102, 4);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (111, 3, '2014-04-29 14:09:30.071', '2014-04-29 14:09:30.071', 'C', NULL, 1, 1, 12, 102, 10);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (115, 4, '2014-04-29 14:09:30.087', '2014-04-29 14:09:30.087', 'C', NULL, 1, 1, 12, 102, 8);


--
-- TOC entry 2154 (class 0 OID 125027)
-- Dependencies: 169
-- Data for Name: browsed_element; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2171 (class 0 OID 125157)
-- Dependencies: 186
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO groups (id, created_date, description, last_modified_date, name, createdby_id, lastmodifiedby_id) VALUES (3, '2014-04-29 14:09:29.033', 'Respondent group', '2014-04-29 14:09:29.033', 'Respondents', 1, 1);


--
-- TOC entry 2175 (class 0 OID 125188)
-- Dependencies: 190
-- Data for Name: group_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2153 (class 0 OID 125019)
-- Dependencies: 168
-- Data for Name: invitation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (105, 'P', 'A', 'YAS5ICHRBE', 102, 6);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (109, 'P', 'A', 'UCVZ45JZ3T', 102, 4);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (113, 'P', 'A', '76HHP9M9FQ', 102, 10);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (117, 'P', 'A', 'R7CHFY0YHQ', 102, 8);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id, questionnairdefinition_id) VALUES (120, 'A', 'A', '6O6PDUQLKN', 119, NULL, 12);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id, questionnairdefinition_id) VALUES (156, 'A', 'A', 'P0C6Q2NN3H', 155, NULL, 121);


--
-- TOC entry 2156 (class 0 OID 125040)
-- Dependencies: 171
-- Data for Name: label_set; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2155 (class 0 OID 125032)
-- Dependencies: 170
-- Data for Name: label; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2165 (class 0 OID 125109)
-- Dependencies: 180
-- Data for Name: label_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2157 (class 0 OID 125048)
-- Dependencies: 172
-- Data for Name: mail_message; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (106, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=YAS5ICHRBE">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (110, 'Dear Mr. Lannister, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=UCVZ45JZ3T">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (114, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=76HHP9M9FQ">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (118, 'Estimado Sr. Stark, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=R7CHFY0YHQ">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'arya.stark@winterfell.net');


--
-- TOC entry 2158 (class 0 OID 125056)
-- Dependencies: 173
-- Data for Name: mail_message_template; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (100, '2014-04-29 14:09:29.763', 'support@gazpacho.net', 'EN', '2014-04-29 14:09:29.763', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'Invitation to participate in a questionnair', 1, 1, 12);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (153, '2014-04-29 14:09:30.279', 'support@gazpacho.net', 'EN', '2014-04-29 14:09:30.279', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'Invitation to participate in a questionnair', 1, 1, 121);


--
-- TOC entry 2166 (class 0 OID 125117)
-- Dependencies: 181
-- Data for Name: mail_message_template_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (101, '2014-04-29 14:09:29.782', 'ES', '2014-04-29 14:09:29.782', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 100);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (154, '2014-04-29 14:09:30.285', 'ES', '2014-04-29 14:09:30.285', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 153);


--
-- TOC entry 2172 (class 0 OID 125165)
-- Dependencies: 187
-- Data for Name: permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (104, 103, 3, 'Q', 7);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (108, 107, 3, 'Q', 5);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (112, 111, 3, 'Q', 11);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (116, 115, 3, 'Q', 9);


--
-- TOC entry 2167 (class 0 OID 125125)
-- Dependencies: 182
-- Data for Name: question_group_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_group_translation (id, language, title, questiongroup_id) VALUES (15, 'ES', 'Capitales Europeas', 14);
INSERT INTO question_group_translation (id, language, title, questiongroup_id) VALUES (17, 'ES', 'Unión Europea', 16);
INSERT INTO question_group_translation (id, language, title, questiongroup_id) VALUES (19, 'ES', 'Sociedad', 18);


--
-- TOC entry 2163 (class 0 OID 125093)
-- Dependencies: 178
-- Data for Name: question_option; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (23, 'O1', '2014-04-29 14:09:29.331', 'EN', '2014-04-29 14:09:29.331', 'Norway', 1, 1, 22, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (24, 'O2', '2014-04-29 14:09:29.332', 'EN', '2014-04-29 14:09:29.332', 'Sweden', 1, 1, 22, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (25, 'O3', '2014-04-29 14:09:29.333', 'EN', '2014-04-29 14:09:29.333', 'Denmark', 1, 1, 22, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (26, 'O4', '2014-04-29 14:09:29.334', 'EN', '2014-04-29 14:09:29.334', 'Iceland', 1, 1, 22, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (35, 'O1', '2014-04-29 14:09:29.424', 'EN', '2014-04-29 14:09:29.424', 'Vatican City', 1, 1, 34, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (36, 'O2', '2014-04-29 14:09:29.425', 'EN', '2014-04-29 14:09:29.425', 'Roma', 1, 1, 34, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (37, 'O3', '2014-04-29 14:09:29.426', 'EN', '2014-04-29 14:09:29.426', 'Helsinki', 1, 1, 34, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (38, 'O4', '2014-04-29 14:09:29.427', 'EN', '2014-04-29 14:09:29.427', 'Viena', 1, 1, 34, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (47, 'O1', '2014-04-29 14:09:29.492', 'EN', '2014-04-29 14:09:29.492', 'Westphalia', 1, 1, 46, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (48, 'O2', '2014-04-29 14:09:29.493', 'EN', '2014-04-29 14:09:29.493', 'Rome', 1, 1, 46, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (49, 'O3', '2014-04-29 14:09:29.494', 'EN', '2014-04-29 14:09:29.494', 'Brussels', 1, 1, 46, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (50, 'O4', '2014-04-29 14:09:29.495', 'EN', '2014-04-29 14:09:29.495', 'Versailles', 1, 1, 46, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (57, 'O1', '2014-04-29 14:09:29.536', 'EN', '2014-04-29 14:09:29.536', 'Norway', 1, 1, 56, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (58, 'O2', '2014-04-29 14:09:29.537', 'EN', '2014-04-29 14:09:29.537', 'Poland', 1, 1, 56, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (59, 'O3', '2014-04-29 14:09:29.538', 'EN', '2014-04-29 14:09:29.538', 'Macedonia', 1, 1, 56, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (60, 'O4', '2014-04-29 14:09:29.539', 'EN', '2014-04-29 14:09:29.539', 'Chipre', 1, 1, 56, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (69, 'O1', '2014-04-29 14:09:29.604', 'EN', '2014-04-29 14:09:29.604', 'Barcelona', 1, 1, 68, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (70, 'O2', '2014-04-29 14:09:29.605', 'EN', '2014-04-29 14:09:29.605', 'Lisboa', 1, 1, 68, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (71, 'O3', '2014-04-29 14:09:29.606', 'EN', '2014-04-29 14:09:29.606', 'Genoa', 1, 1, 68, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (72, 'O4', '2014-04-29 14:09:29.607', 'EN', '2014-04-29 14:09:29.607', 'Roma', 1, 1, 68, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (79, 'O1', '2014-04-29 14:09:29.641', 'EN', '2014-04-29 14:09:29.641', 'Portuguese Empire', 1, 1, 78, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (80, 'O2', '2014-04-29 14:09:29.642', 'EN', '2014-04-29 14:09:29.642', 'British Empire', 1, 1, 78, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (81, 'O3', '2014-04-29 14:09:29.643', 'EN', '2014-04-29 14:09:29.643', 'Spanish Empire', 1, 1, 78, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (82, 'O4', '2014-04-29 14:09:29.644', 'EN', '2014-04-29 14:09:29.644', 'Dutch Empire', 1, 1, 78, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (91, 'O1', '2014-04-29 14:09:29.705', 'EN', '2014-04-29 14:09:29.705', 'Adolph Hitler', 1, 1, 90, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (92, 'O2', '2014-04-29 14:09:29.706', 'EN', '2014-04-29 14:09:29.706', 'Napoleon', 1, 1, 90, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (93, 'O3', '2014-04-29 14:09:29.707', 'EN', '2014-04-29 14:09:29.707', 'Philip 2th King of Spain', 1, 1, 90, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (94, 'O4', '2014-04-29 14:09:29.708', 'EN', '2014-04-29 14:09:29.708', 'Julius Caesar', 1, 1, 90, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (124, 'O1', '2014-04-29 14:09:30.155', 'EN', '2014-04-29 14:09:30.155', 'Agree strongly', 1, 1, 123, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (125, 'O2', '2014-04-29 14:09:30.155', 'EN', '2014-04-29 14:09:30.155', 'Agree somewhat', 1, 1, 123, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (126, 'O3', '2014-04-29 14:09:30.156', 'EN', '2014-04-29 14:09:30.156', 'Neither agree nor disagree', 1, 1, 123, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (127, 'O4', '2014-04-29 14:09:30.157', 'EN', '2014-04-29 14:09:30.157', 'Disagree somewhat', 1, 1, 123, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (128, 'O5', '2014-04-29 14:09:30.158', 'EN', '2014-04-29 14:09:30.158', 'Agree strongly', 1, 1, 123, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (129, 'O6', '2014-04-29 14:09:30.159', 'EN', '2014-04-29 14:09:30.159', 'Disagree strongly', 1, 1, 123, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (135, 'O1', '2014-04-29 14:09:30.195', 'EN', '2014-04-29 14:09:30.195', 'Agree strongly', 1, 1, 134, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (136, 'O2', '2014-04-29 14:09:30.196', 'EN', '2014-04-29 14:09:30.196', 'Agree somewhat', 1, 1, 134, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (137, 'O3', '2014-04-29 14:09:30.197', 'EN', '2014-04-29 14:09:30.197', 'Neither agree nor disagree', 1, 1, 134, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (138, 'O4', '2014-04-29 14:09:30.198', 'EN', '2014-04-29 14:09:30.198', 'Disagree somewhat', 1, 1, 134, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (139, 'O5', '2014-04-29 14:09:30.198', 'EN', '2014-04-29 14:09:30.198', 'Agree strongly', 1, 1, 134, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (140, 'O6', '2014-04-29 14:09:30.199', 'EN', '2014-04-29 14:09:30.199', 'Disagree strongly', 1, 1, 134, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (148, 'O1', '2014-04-29 14:09:30.243', 'EN', '2014-04-29 14:09:30.243', 'under 25,000€', 1, 1, 147, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (149, 'O2', '2014-04-29 14:09:30.244', 'EN', '2014-04-29 14:09:30.244', '25,000 - 29,999€', 1, 1, 147, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (150, 'O3', '2014-04-29 14:09:30.245', 'EN', '2014-04-29 14:09:30.245', '30,000 - 34,999€', 1, 1, 147, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (151, 'O4', '2014-04-29 14:09:30.247', 'EN', '2014-04-29 14:09:30.247', '35,000 - 39,999€', 1, 1, 147, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (152, 'O5', '2014-04-29 14:09:30.248', 'EN', '2014-04-29 14:09:30.248', 'Over 85,000€', 1, 1, 147, 4);


--
-- TOC entry 2169 (class 0 OID 125141)
-- Dependencies: 184
-- Data for Name: question_option_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (28, 'ES', 'Noruega', 23);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (29, 'ES', 'Suecia', 24);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (30, 'ES', 'Dinamarca', 25);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (31, 'ES', 'Islandia', 26);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (40, 'ES', 'Ciudad del Vaticano', 35);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (41, 'ES', 'Roma', 36);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (42, 'ES', 'Helsinki', 37);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (43, 'ES', 'Viena', 38);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (52, 'ES', 'Westphalia', 35);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (53, 'ES', 'Roma', 36);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (54, 'ES', 'Bruselas', 37);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (55, 'ES', 'Islandia', 38);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (62, 'ES', 'Noruega', 57);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (63, 'ES', 'Polonia', 58);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (64, 'ES', 'Macedonia', 59);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (65, 'ES', 'Chipre', 60);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (74, 'ES', 'Barcelona', 69);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (75, 'ES', 'Lisboa', 70);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (76, 'ES', 'Genova', 71);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (77, 'ES', 'Roma', 72);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (84, 'ES', 'Imperio Portugues', 79);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (85, 'ES', 'Imperio Británico', 80);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (86, 'ES', 'Imperio Español', 81);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (87, 'ES', 'Imperio Holandés', 82);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (96, 'ES', 'Adolfo Hitler', 91);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (97, 'ES', 'Napoleón', 92);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (98, 'ES', 'Felipe II', 93);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (99, 'ES', 'Julio Cesar', 94);


--
-- TOC entry 2170 (class 0 OID 125149)
-- Dependencies: 185
-- Data for Name: question_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_translation (id, language, title, question_id) VALUES (21, 'ES', '¿Cuál es la capital de Malta?', 20);
INSERT INTO question_translation (id, language, title, question_id) VALUES (27, 'ES', '¿Qué pais tiene como capital Copenague?', 22);
INSERT INTO question_translation (id, language, title, question_id) VALUES (33, 'ES', '¿Cuantas capitales europeas fueron fundadas por los romanos?', 32);
INSERT INTO question_translation (id, language, title, question_id) VALUES (39, 'ES', '¿Cuantas de estas capitales Europeas estan al pie de un río?', 34);
INSERT INTO question_translation (id, language, title, question_id) VALUES (45, 'ES', '¿Que significa UE?', 44);
INSERT INTO question_translation (id, language, title, question_id) VALUES (51, 'ES', '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 34);
INSERT INTO question_translation (id, language, title, question_id) VALUES (61, 'ES', '¿Cuál de estos países europeos pertenecen a la zona euro?', 56);
INSERT INTO question_translation (id, language, title, question_id) VALUES (67, 'ES', '¿Cuantos marcos finlandeses necesitas para tener un euro?', 66);
INSERT INTO question_translation (id, language, title, question_id) VALUES (73, 'ES', '¿Dónde nació Cristobal Colón?', 68);
INSERT INTO question_translation (id, language, title, question_id) VALUES (83, 'ES', '¿Cuál fue el imperio más grande en el siglo XVI?', 78);
INSERT INTO question_translation (id, language, title, question_id) VALUES (89, 'ES', '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 88);
INSERT INTO question_translation (id, language, title, question_id) VALUES (95, 'ES', '¿Cual de estos hombres causó más bajas en Europa?', 90);


--
-- TOC entry 2179 (class 0 OID 125468)
-- Dependencies: 194
-- Data for Name: questionnair_answers_12; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2180 (class 0 OID 125476)
-- Dependencies: 195
-- Data for Name: questionnair_answers_121; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2168 (class 0 OID 125133)
-- Dependencies: 183
-- Data for Name: questionnair_definition_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition_translation (id, language, description, title, welcome_text, questionnairdefinition_id) VALUES (13, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 12);


--
-- TOC entry 2178 (class 0 OID 125463)
-- Dependencies: 193
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnair_answers_12_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('SEQ_GEN', 200);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnair_answers_121_seq', 0);


--
-- TOC entry 2176 (class 0 OID 125193)
-- Dependencies: 191
-- Data for Name: user_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_group (group_id, user_id) VALUES (3, 6);
INSERT INTO user_group (group_id, user_id) VALUES (3, 4);
INSERT INTO user_group (group_id, user_id) VALUES (3, 10);
INSERT INTO user_group (group_id, user_id) VALUES (3, 8);


--
-- TOC entry 2177 (class 0 OID 125198)
-- Dependencies: 192
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_role (role_id, user_id) VALUES (2, 1);
INSERT INTO user_role (role_id, user_id) VALUES (5, 4);
INSERT INTO user_role (role_id, user_id) VALUES (7, 6);
INSERT INTO user_role (role_id, user_id) VALUES (9, 8);
INSERT INTO user_role (role_id, user_id) VALUES (11, 10);


-- Completed on 2014-04-29 14:18:09

--
-- PostgreSQL database dump complete
--

