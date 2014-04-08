--
-- PostgreSQL database dump
--

-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, type, api_key, created_date, email, gender, given_names, last_modified_date, prefered_language, surname, createdby_id, lastmodifiedby_id, username) VALUES (1, 'M', 'COBDXRLJEM3YTSU', '2014-04-04 09:26:04.64', 'support@gazpacho.net', NULL, 'support', '2014-04-04 09:26:04.64', NULL, 'support', 1, 1, 'support');
INSERT INTO users (id, type, api_key, created_date, email, gender, given_names, last_modified_date, prefered_language, surname, createdby_id, lastmodifiedby_id, username) VALUES (2, 'P', 'C27U559SERCFI0P', '2014-04-04 09:26:04.964', 'tyrion.lannister@kingslanding.net', 'MALE', 'Tyrion', '2014-04-04 09:26:04.964', 'EN', 'Lannister', 1, 1, NULL);
INSERT INTO users (id, type, api_key, created_date, email, gender, given_names, last_modified_date, prefered_language, surname, createdby_id, lastmodifiedby_id, username) VALUES (3, 'P', 'P4EVK8OA4Y700YH', '2014-04-04 09:26:04.989', 'jon.snow@nightswatch.net', 'MALE', 'Jon', '2014-04-04 09:26:04.989', 'ES', 'Snow', 1, 1, NULL);
INSERT INTO users (id, type, api_key, created_date, email, gender, given_names, last_modified_date, prefered_language, surname, createdby_id, lastmodifiedby_id, username) VALUES (4, 'P', '7N291UO29FL033P', '2014-04-04 09:26:05.009', 'arya.stark@winterfell.net', 'FEMALE', 'Arya', '2014-04-04 09:26:05.009', NULL, 'Stark', 1, 1, NULL);
INSERT INTO users (id, type, api_key, created_date, email, gender, given_names, last_modified_date, prefered_language, surname, createdby_id, lastmodifiedby_id, username) VALUES (5, 'P', 'F6RPL2O9XB0YEOJ', '2014-04-04 09:26:05.031', 'catelyn.stark@winterfell.net', 'FEMALE', 'Catelyn', '2014-04-04 09:26:05.031', 'FI', 'Stark', 1, 1, NULL);


--
-- Data for Name: questionnair_definition; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, status, description, title, welcometext, createdby_id, lastmodifiedby_id) VALUES (6, '2014-04-04 09:26:05.17', 'EN', '2014-04-04 09:26:05.17', 'CONFIRMED', '<p>This is a <strong><em>sample questionnairDefinition</em></strong> designed for testing GazpachoSurvey.</p>', 'Sample QuestionnairDefinition', 'Thank you for taking the time to participate in this questionnairDefinition.', 1, 1);
INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, status, description, title, welcometext, createdby_id, lastmodifiedby_id) VALUES (71, '2014-04-04 09:26:08.621', 'EN', '2014-04-04 09:26:08.621', 'CONFIRMED', 'We at BIG DEES take pride in providing you with the highest standards of QUALITY, SERVICE, CLEANLINESS and VALUE in the restaurant industry.', 'Food Quality QuestionnairDefinition', 'Your opinion is extremely important in evaluating our business. Thank you for taking a moment to questionOption the following questions:', 1, 1);


--
-- Data for Name: question_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (8, '2014-04-04 09:26:05.526', 'EN', '2014-04-04 09:26:05.526', 'QuestionGroup 1', 1, 1, 6, 0);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (9, '2014-04-04 09:26:05.623', 'EN', '2014-04-04 09:26:05.623', 'QuestionGroup 2', 1, 1, 6, 1);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (10, '2014-04-04 09:26:05.702', 'EN', '2014-04-04 09:26:05.702', 'QuestionGroup 3', 1, 1, 6, 2);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (72, '2014-04-04 09:26:08.65', 'EN', '2014-04-04 09:26:08.65', 'Fast Food QuestionnairDefinition - QuestionGroup', 1, 1, 71, 0);


--
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (11, 'Q1', '2014-04-04 09:26:05.875', 'EN', '2014-04-04 09:26:05.875', true, 'S', 'What is your name?', 1, 1, NULL, 8, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (12, 'Q2', '2014-04-04 09:26:06.076', 'EN', '2014-04-04 09:26:06.076', true, 'L', 'What is your age group?', 1, 1, NULL, 8, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (28, 'Q3', '2014-04-04 09:26:06.545', 'EN', '2014-04-04 09:26:06.545', true, 'N', 'And for our records, specifically how old are you?', 1, 1, NULL, 8, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (29, 'Q4', '2014-04-04 09:26:06.661', 'EN', '2014-04-04 09:26:06.661', true, 'T', 'Please tell us a little about yourself. What was your first job, and did you enjoy it?', 1, 1, NULL, 9, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (30, 'Q5', '2014-04-04 09:26:06.763', 'EN', '2014-04-04 09:26:06.763', true, 'L', 'Given your extraordinary age, how do you find using this questionnairDefinition tool?', 1, 1, NULL, 9, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (34, 'Q6', '2014-04-04 09:26:06.84', 'EN', '2014-04-04 09:26:06.84', true, 'L', 'Which of these ads makes you want to find out more?', 1, 1, NULL, 9, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (38, 'Q7', '2014-04-04 09:26:07.072', 'EN', '2014-04-04 09:26:07.072', true, 'F', 'Please have a good look at this ad, and then complete the questions below.<br /><img src=''http://www.aptigence.com.au/images/lawyer1.jpg'' border=''1''>', 1, 1, NULL, 10, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (45, 'Q7.1', '2014-04-04 09:26:07.099', 'EN', '2014-04-04 09:26:07.099', false, 'L', 'This ad suggests the lawyer is on my side, not his own', 1, 1, 38, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (46, 'Q7.2', '2014-04-04 09:26:07.103', 'EN', '2014-04-04 09:26:07.103', false, 'L', 'This ad suggests that the lawyer is interested in a life of frugal community service', 1, 1, 38, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (47, 'Q7.3', '2014-04-04 09:26:07.107', 'EN', '2014-04-04 09:26:07.107', false, 'L', 'This ad would be enough to get me to hire this lawyer', 1, 1, 38, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (48, 'Q7.4', '2014-04-04 09:26:07.111', 'EN', '2014-04-04 09:26:07.111', false, 'L', 'This ad gives me confidence in the lawyers experience', 1, 1, 38, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (49, 'Q8', '2014-04-04 09:26:07.312', 'EN', '2014-04-04 09:26:07.312', false, 'M', 'What flavors of ice cream do you like?. Choose all that apply.', 1, 1, NULL, 10, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (73, 'Q1', '2014-04-04 09:26:08.692', 'EN', '2014-04-04 09:26:08.692', true, 'F', '<b>Food Quality</b>', 1, 1, NULL, 72, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (80, 'Q1.1', '2014-04-04 09:26:08.706', 'EN', '2014-04-04 09:26:08.706', false, 'L', 'The food is served hot and fresh', 1, 1, 73, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (81, 'Q1.2', '2014-04-04 09:26:08.708', 'EN', '2014-04-04 09:26:08.708', false, 'L', 'The menu has a good variety of items', 1, 1, 73, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (82, 'Q1.3', '2014-04-04 09:26:08.711', 'EN', '2014-04-04 09:26:08.711', false, 'L', 'The quality of food is excellent', 1, 1, 73, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (83, 'Q1.4', '2014-04-04 09:26:08.713', 'EN', '2014-04-04 09:26:08.713', false, 'L', 'The food is tasty and flavorful', 1, 1, 73, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (84, 'Q2', '2014-04-04 09:26:08.795', 'EN', '2014-04-04 09:26:08.795', true, 'F', '<b>Resturant</b>', 1, 1, NULL, 72, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (91, 'Q2.1', '2014-04-04 09:26:08.816', 'EN', '2014-04-04 09:26:08.816', false, 'L', 'My food order was correct and complete', 1, 1, 84, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (92, 'Q2.2', '2014-04-04 09:26:08.819', 'EN', '2014-04-04 09:26:08.819', false, 'L', 'Employees are patient when taking my order', 1, 1, 84, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (93, 'Q2.3', '2014-04-04 09:26:08.82', 'EN', '2014-04-04 09:26:08.82', false, 'L', 'I was served promptly', 1, 1, 84, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (94, 'Q2.4', '2014-04-04 09:26:08.822', 'EN', '2014-04-04 09:26:08.822', false, 'L', 'Availability of sauces, utensils, napkins, etc. was good', 1, 1, 84, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (95, 'Q2.5', '2014-04-04 09:26:08.823', 'EN', '2014-04-04 09:26:08.823', false, 'L', 'The menu board was easy to read', 1, 1, 84, NULL, 4, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (96, 'Q2.6', '2014-04-04 09:26:08.824', 'EN', '2014-04-04 09:26:08.824', false, 'L', 'The drive-thru sound system was cleara', 1, 1, 84, NULL, 5, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (97, 'Q3', '2014-04-04 09:26:08.937', 'EN', '2014-04-04 09:26:08.937', true, 'L', 'Indicate total household income', 1, 1, NULL, 72, NULL, 2);


--
-- Data for Name: study; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO study (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (56, '2014-04-04 09:26:08.293', '2014-04-04 09:26:08.232', '2014-04-04 09:26:08.293', 'New private Questionnair Sample QuestionnairDefinition started', '2014-04-04 09:26:08.232', 'BY_INVITATION', 1, 1);
INSERT INTO study (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (69, '2014-04-04 09:26:08.579', '2014-04-04 09:26:08.564', '2014-04-04 09:26:08.579', 'New open Questionnair Sample QuestionnairDefinition started', '2014-04-04 09:26:08.564', 'OPEN_ACCESS', 1, 1);
INSERT INTO study (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (105, '2014-04-04 09:26:09.32', '2014-04-04 09:26:09.306', '2014-04-04 09:26:09.32', 'New survey Food Quality QuestionnairDefinition started', '2014-04-04 09:26:09.306', 'BY_INVITATION', 1, 1);


--
-- Data for Name: questionnair; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (57, NULL, '2014-04-04 09:26:08.358', '2014-04-04 09:26:08.358', 'CONFIRMED', NULL, 1, 1, 2, 6, 56);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (60, NULL, '2014-04-04 09:26:08.447', '2014-04-04 09:26:08.447', 'CONFIRMED', NULL, 1, 1, 5, 6, 56);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (63, NULL, '2014-04-04 09:26:08.491', '2014-04-04 09:26:08.491', 'CONFIRMED', NULL, 1, 1, 4, 6, 56);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (66, NULL, '2014-04-04 09:26:08.51', '2014-04-04 09:26:08.51', 'CONFIRMED', NULL, 1, 1, 3, 6, 56);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (109, NULL, '2014-04-04 09:26:09.332', '2014-04-04 09:26:09.332', 'CONFIRMED', NULL, 1, 1, 5, 71, 105);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (106, NULL, '2014-04-04 09:26:09.328', '2014-04-04 09:26:09.328', 'CONFIRMED', NULL, 1, 1, 2, 71, 105);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (112, NULL, '2014-04-04 09:26:09.355', '2014-04-04 09:26:09.355', 'CONFIRMED', NULL, 1, 1, 4, 71, 105);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (115, NULL, '2014-04-04 09:26:09.366', '2014-04-04 09:26:09.366', 'CONFIRMED', NULL, 1, 1, 3, 71, 105);


--
-- Data for Name: browsed_element; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: invitation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (61, 'P', 'ACTIVE', 'UOXCQ209X9', 56, 5);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (58, 'P', 'ACTIVE', 'GSILNX7EZ6', 56, 2);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (64, 'P', 'ACTIVE', '3OG2TG7O51', 56, 4);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (67, 'P', 'ACTIVE', 'DYJBOGV45O', 56, 3);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (70, 'A', 'ACTIVE', 'XJXEKLTOUF', 69, NULL);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (110, 'P', 'ACTIVE', 'V5MMW6XC7X', 105, 5);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (107, 'P', 'ACTIVE', 'CDIGMFWJSV', 105, 2);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (113, 'P', 'ACTIVE', 'D3MQBOB2YP', 105, 4);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (116, 'P', 'ACTIVE', 'MGMSWPL8B2', 105, 3);


--
-- Data for Name: label_set; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: label; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: label_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: mail_message; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (59, 'Dear Mr. Lannister, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=GSILNX7EZ6">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (62, 'Dear Mr. Stark, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=UOXCQ209X9">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (65, 'Estimado Sr. Stark, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=3OG2TG7O51">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (68, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=DYJBOGV45O">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en una encuesta', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (108, 'Dear Mr. Lannister, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=CDIGMFWJSV">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (111, 'Dear Mr. Stark, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=V5MMW6XC7X">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (114, 'Estimado Sr. Stark, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=D3MQBOB2YP">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (117, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=MGMSWPL8B2">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en una encuesta', 'jon.snow@nightswatch.net');


--
-- Data for Name: mail_message_template; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (54, '2014-04-04 09:26:07.562', 'support@gazpacho.net', 'EN', '2014-04-04 09:26:07.562', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'PersonalInvitation to participate in questionnairDefinition', 1, 1, 6);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (103, '2014-04-04 09:26:09.049', 'support@gazpacho.net', 'EN', '2014-04-04 09:26:09.049', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'PersonalInvitation to participate in questionnairDefinition', 1, 1, 71);


--
-- Data for Name: mail_message_template_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (55, '2014-04-04 09:26:07.677', 'ES', '2014-04-04 09:26:07.677', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en una encuesta', 1, 1, 54);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (104, '2014-04-04 09:26:09.076', 'ES', '2014-04-04 09:26:09.076', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en una encuesta', 1, 1, 103);


--
-- Data for Name: question_group_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: question_option; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (13, 'O1', '2014-04-04 09:26:06.127', 'EN', '2014-04-04 09:26:06.127', '0-14 years', 1, 1, 12, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (14, 'O2', '2014-04-04 09:26:06.134', 'EN', '2014-04-04 09:26:06.134', '15-19 years', 1, 1, 12, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (15, 'O3', '2014-04-04 09:26:06.143', 'EN', '2014-04-04 09:26:06.143', '20-24 years', 1, 1, 12, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (16, 'O4', '2014-04-04 09:26:06.16', 'EN', '2014-04-04 09:26:06.16', '25-29 years', 1, 1, 12, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (17, 'O5', '2014-04-04 09:26:06.176', 'EN', '2014-04-04 09:26:06.176', '30-34 years', 1, 1, 12, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (18, 'O6', '2014-04-04 09:26:06.18', 'EN', '2014-04-04 09:26:06.18', '35-39 years', 1, 1, 12, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (19, 'O7', '2014-04-04 09:26:06.188', 'EN', '2014-04-04 09:26:06.188', '40-44 years', 1, 1, 12, 6);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (20, 'O8', '2014-04-04 09:26:06.192', 'EN', '2014-04-04 09:26:06.192', '45-49 years', 1, 1, 12, 7);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (21, 'O9', '2014-04-04 09:26:06.203', 'EN', '2014-04-04 09:26:06.203', '50-54 years', 1, 1, 12, 8);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (22, 'O10', '2014-04-04 09:26:06.22', 'EN', '2014-04-04 09:26:06.22', '55-59 years', 1, 1, 12, 9);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (23, 'O11', '2014-04-04 09:26:06.23', 'EN', '2014-04-04 09:26:06.23', '60-64 years', 1, 1, 12, 10);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (24, 'O12', '2014-04-04 09:26:06.239', 'EN', '2014-04-04 09:26:06.239', '65-69 years', 1, 1, 12, 11);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (25, 'O13', '2014-04-04 09:26:06.258', 'EN', '2014-04-04 09:26:06.258', '70-74 years', 1, 1, 12, 12);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (26, 'O14', '2014-04-04 09:26:06.274', 'EN', '2014-04-04 09:26:06.274', '75-79 years', 1, 1, 12, 13);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (27, 'O15', '2014-04-04 09:26:06.278', 'EN', '2014-04-04 09:26:06.278', '80 and over', 1, 1, 12, 14);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (31, 'O1', '2014-04-04 09:26:06.767', 'EN', '2014-04-04 09:26:06.767', 'Very difficult to read, my eyesight is dim', 1, 1, 30, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (32, 'O2', '2014-04-04 09:26:06.77', 'EN', '2014-04-04 09:26:06.77', 'Easy, my carer is doing it all for me', 1, 1, 30, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (33, 'O3', '2014-04-04 09:26:06.773', 'EN', '2014-04-04 09:26:06.773', 'How <b><i>dare</i></b> you insult me like that! I''m YOUNG', 1, 1, 30, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (35, 'O1', '2014-04-04 09:26:06.844', 'EN', '2014-04-04 09:26:06.844', 'Ad one', 1, 1, 34, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (36, 'O2', '2014-04-04 09:26:06.847', 'EN', '2014-04-04 09:26:06.847', 'Ad two', 1, 1, 34, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (37, 'O3', '2014-04-04 09:26:06.866', 'EN', '2014-04-04 09:26:06.866', 'Ad three', 1, 1, 34, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (39, 'O1', '2014-04-04 09:26:07.075', 'EN', '2014-04-04 09:26:07.075', 'Agree strongly', 1, 1, 38, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (40, 'O2', '2014-04-04 09:26:07.079', 'EN', '2014-04-04 09:26:07.079', 'Agree somewhat', 1, 1, 38, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (41, 'O3', '2014-04-04 09:26:07.083', 'EN', '2014-04-04 09:26:07.083', 'Neither agree nor disagree', 1, 1, 38, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (42, 'O4', '2014-04-04 09:26:07.087', 'EN', '2014-04-04 09:26:07.087', 'Disagree somewhat', 1, 1, 38, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (43, 'O5', '2014-04-04 09:26:07.091', 'EN', '2014-04-04 09:26:07.091', 'Agree strongly', 1, 1, 38, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (44, 'O6', '2014-04-04 09:26:07.095', 'EN', '2014-04-04 09:26:07.095', 'Disagree strongly', 1, 1, 38, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (50, 'O1', '2014-04-04 09:26:07.316', 'EN', '2014-04-04 09:26:07.316', 'Vanilla', 1, 1, 49, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (51, 'O2', '2014-04-04 09:26:07.323', 'EN', '2014-04-04 09:26:07.323', 'Chocolate', 1, 1, 49, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (52, 'O3', '2014-04-04 09:26:07.327', 'EN', '2014-04-04 09:26:07.327', 'Strawberry', 1, 1, 49, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (53, 'O4', '2014-04-04 09:26:07.331', 'EN', '2014-04-04 09:26:07.331', 'Pistachio', 1, 1, 49, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (74, 'O1', '2014-04-04 09:26:08.694', 'EN', '2014-04-04 09:26:08.694', 'Agree strongly', 1, 1, 73, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (75, 'O2', '2014-04-04 09:26:08.696', 'EN', '2014-04-04 09:26:08.696', 'Agree somewhat', 1, 1, 73, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (76, 'O3', '2014-04-04 09:26:08.697', 'EN', '2014-04-04 09:26:08.697', 'Neither agree nor disagree', 1, 1, 73, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (77, 'O4', '2014-04-04 09:26:08.699', 'EN', '2014-04-04 09:26:08.699', 'Disagree somewhat', 1, 1, 73, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (78, 'O5', '2014-04-04 09:26:08.701', 'EN', '2014-04-04 09:26:08.701', 'Agree strongly', 1, 1, 73, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (79, 'O6', '2014-04-04 09:26:08.704', 'EN', '2014-04-04 09:26:08.704', 'Disagree strongly', 1, 1, 73, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (85, 'O1', '2014-04-04 09:26:08.803', 'EN', '2014-04-04 09:26:08.803', 'Agree strongly', 1, 1, 84, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (86, 'O2', '2014-04-04 09:26:08.806', 'EN', '2014-04-04 09:26:08.806', 'Agree somewhat', 1, 1, 84, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (87, 'O3', '2014-04-04 09:26:08.808', 'EN', '2014-04-04 09:26:08.808', 'Neither agree nor disagree', 1, 1, 84, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (88, 'O4', '2014-04-04 09:26:08.81', 'EN', '2014-04-04 09:26:08.81', 'Disagree somewhat', 1, 1, 84, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (89, 'O5', '2014-04-04 09:26:08.813', 'EN', '2014-04-04 09:26:08.813', 'Agree strongly', 1, 1, 84, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (90, 'O6', '2014-04-04 09:26:08.814', 'EN', '2014-04-04 09:26:08.814', 'Disagree strongly', 1, 1, 84, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (98, 'O1', '2014-04-04 09:26:08.939', 'EN', '2014-04-04 09:26:08.939', 'under 25,000€', 1, 1, 97, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (99, 'O2', '2014-04-04 09:26:08.941', 'EN', '2014-04-04 09:26:08.941', '25,000 - 29,999€', 1, 1, 97, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (100, 'O3', '2014-04-04 09:26:08.944', 'EN', '2014-04-04 09:26:08.944', '30,000 - 34,999€', 1, 1, 97, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (101, 'O4', '2014-04-04 09:26:08.948', 'EN', '2014-04-04 09:26:08.948', '35,000 - 39,999€', 1, 1, 97, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (102, 'O5', '2014-04-04 09:26:08.951', 'EN', '2014-04-04 09:26:08.951', 'Over 85,000€', 1, 1, 97, 4);


--
-- Data for Name: question_option_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: question_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- Data for Name: questionnair_definition_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition_translation (id, language, description, title, welcometext, questionnairdefinition_id) VALUES (7, 'ES', '<p>Esto es una encuesta de ejemplo diseñada para GazpachoSurvey</p>', 'Ejemplo de encuesta', 'Gracias por participar en esta encuesta', 6);


--
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnair_answers_6_seq', 0);
INSERT INTO sequence (seq_name, seq_count) VALUES ('SEQ_GEN', 150);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnair_answers_71_seq', 0);


--
-- Data for Name: questionnair_answers_6; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_answers_6 (id, q1, q2, q3, q4, q5, q6, q7_1, q7_2, q7_3, q7_4, q8_o1, q8_o2, q8_o3, q8_o4) VALUES (1, 'Antonio Maria Sanchez Berrocal', '05', 33, 'I started to work in IECISA, 10 years ago', '02', '01', '01', '02', '03', '01', true, true, true, NULL);



--
-- Data for Name: questionnair_answers_71; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- PostgreSQL database dump complete
--

