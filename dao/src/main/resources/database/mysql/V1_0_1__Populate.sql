--
-- TOC entry 2067 (class 0 OID 109417)
-- Dependencies: 166 2086
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, created_date, email, first_name, last_modified_date, last_name, createdby_id, lastmodifiedby_id) VALUES (1, '2014-02-22 16:19:11.518', 'support.temporal@gazpacho.net', 'temporal.support', '2014-02-22 16:19:11.518', 'support', 1, 1);


--
-- TOC entry 2076 (class 0 OID 109488)
-- Dependencies: 175 2067 2067 2086
-- Data for Name: participant; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO participant (id, created_date, email, firstname, gender, last_modified_date, lastname, prefered_language, createdby_id, lastmodifiedby_id) VALUES (2, '2014-02-22 16:19:11.611', 'tyrion.lannister@kingslanding.net', 'Tyrion', 'MALE', '2014-02-22 16:19:11.611', 'Lannister', 'EN', 1, 1);
INSERT INTO participant (id, created_date, email, firstname, gender, last_modified_date, lastname, prefered_language, createdby_id, lastmodifiedby_id) VALUES (3, '2014-02-22 16:19:11.632', 'jon.snow@nightswatch.net', 'Jon', 'MALE', '2014-02-22 16:19:11.632', 'Snow', 'ES', 1, 1);
INSERT INTO participant (id, created_date, email, firstname, gender, last_modified_date, lastname, prefered_language, createdby_id, lastmodifiedby_id) VALUES (4, '2014-02-22 16:19:11.655', 'arya.stark@winterfell.net', 'Arya', 'FEMALE', '2014-02-22 16:19:11.655', 'Stark', NULL, 1, 1);
INSERT INTO participant (id, created_date, email, firstname, gender, last_modified_date, lastname, prefered_language, createdby_id, lastmodifiedby_id) VALUES (5, '2014-02-22 16:19:11.676', 'catelyn.stark@winterfell.net', 'Catelyn', 'FEMALE', '2014-02-22 16:19:11.676', 'Stark', 'FI', 1, 1);


--
-- TOC entry 2071 (class 0 OID 109451)
-- Dependencies: 170 2067 2067 2086
-- Data for Name: questionnair_definition; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, status, description, title, welcometext, createdby_id, lastmodifiedby_id) VALUES (6, '2014-02-22 16:19:11.745', 'EN', '2014-02-22 16:19:11.745', 'CONFIRMED', '<p>This is a <strong><em>sample questionnairDefinition</em></strong> designed for testing GazpachoSurvey.</p>', 'Sample QuestionnairDefinition', 'Thank you for taking the time to participate in this questionnairDefinition.', 1, 1);
INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, status, description, title, welcometext, createdby_id, lastmodifiedby_id) VALUES (75, '2014-02-22 16:19:14.044', 'EN', '2014-02-22 16:19:14.044', 'CONFIRMED', 'We at BIG DEES take pride in providing you with the highest standards of QUALITY, SERVICE, CLEANLINESS and VALUE in the restaurant industry.', 'Food Quality QuestionnairDefinition', 'Your opinion is extremely important in evaluating our business. Thank you for taking a moment to questionOption the following questions:', 1, 1);


--
-- TOC entry 2074 (class 0 OID 109472)
-- Dependencies: 173 2067 2071 2067 2086
-- Data for Name: question_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (8, '2014-02-22 16:19:11.92', 'EN', '2014-02-22 16:19:11.92', 'QuestionGroup 1', 1, 1, 6, 0);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (9, '2014-02-22 16:19:12.01', 'EN', '2014-02-22 16:19:12.01', 'QuestionGroup 2', 1, 1, 6, 1);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (10, '2014-02-22 16:19:12.063', 'EN', '2014-02-22 16:19:12.063', 'QuestionGroup 3', 1, 1, 6, 2);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (76, '2014-02-22 16:19:14.074', 'EN', '2014-02-22 16:19:14.074', 'Fast Food QuestionnairDefinition - QuestionGroup', 1, 1, 75, 0);


--
-- TOC entry 2070 (class 0 OID 109443)
-- Dependencies: 169 2067 2074 2067 2086
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (17, 'Q1', '2014-02-22 16:19:12.375', 'EN', '2014-02-22 16:19:12.375', true, 'S', 'What is your name?', 1, 1, NULL, 8, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (18, 'Q2', '2014-02-22 16:19:12.587', 'EN', '2014-02-22 16:19:12.587', true, 'L', 'What is your age group?', 1, 1, NULL, 8, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (34, 'Q3', '2014-02-22 16:19:13.044', 'EN', '2014-02-22 16:19:13.044', true, 'N', 'And for our records, specifically how old are you?', 1, 1, NULL, 8, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (35, 'Q4', '2014-02-22 16:19:13.11', 'EN', '2014-02-22 16:19:13.11', true, 'T', 'Please tell us a little about yourself. What was your first job, and did you enjoy it?', 1, 1, NULL, 9, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (36, 'Q5', '2014-02-22 16:19:13.147', 'EN', '2014-02-22 16:19:13.147', true, 'L', 'Given your extraordinary age, how do you find using this questionnairDefinition tool?', 1, 1, NULL, 9, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (40, 'Q6', '2014-02-22 16:19:13.195', 'EN', '2014-02-22 16:19:13.195', true, 'L', 'Which of these ads makes you want to find out more?', 1, 1, NULL, 9, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (44, 'Q7', '2014-02-22 16:19:13.28', 'EN', '2014-02-22 16:19:13.28', true, 'F', 'Please have a good look at this ad, and then complete the questions below.<br /><img src=''http://www.aptigence.com.au/images/lawyer1.jpg'' border=''1''>', 1, 1, NULL, 10, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (51, 'Q7.1', '2014-02-22 16:19:13.296', 'EN', '2014-02-22 16:19:13.296', false, 'L', 'This ad suggests the lawyer is on my side, not his own', 1, 1, 44, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (52, 'Q7.2', '2014-02-22 16:19:13.297', 'EN', '2014-02-22 16:19:13.297', false, 'L', 'This ad suggests that the lawyer is interested in a life of frugal community service', 1, 1, 44, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (53, 'Q7.3', '2014-02-22 16:19:13.298', 'EN', '2014-02-22 16:19:13.298', false, 'L', 'This ad would be enough to get me to hire this lawyer', 1, 1, 44, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (54, 'Q7.4', '2014-02-22 16:19:13.299', 'EN', '2014-02-22 16:19:13.299', false, 'L', 'This ad gives me confidence in the lawyers experience', 1, 1, 44, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (55, 'Q8', '2014-02-22 16:19:13.402', 'EN', '2014-02-22 16:19:13.402', false, 'M', 'What flavors of ice cream do you like?. Choose all that apply.', 1, 1, NULL, 10, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (77, 'Q1', '2014-02-22 16:19:14.108', 'EN', '2014-02-22 16:19:14.108', true, 'F', '<b>Food Quality</b>', 1, 1, NULL, 76, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (84, 'Q1.1', '2014-02-22 16:19:14.118', 'EN', '2014-02-22 16:19:14.118', false, 'L', 'The food is served hot and fresh', 1, 1, 77, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (85, 'Q1.2', '2014-02-22 16:19:14.119', 'EN', '2014-02-22 16:19:14.119', false, 'L', 'The menu has a good variety of items', 1, 1, 77, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (86, 'Q1.3', '2014-02-22 16:19:14.119', 'EN', '2014-02-22 16:19:14.119', false, 'L', 'The quality of food is excellent', 1, 1, 77, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (87, 'Q1.4', '2014-02-22 16:19:14.12', 'EN', '2014-02-22 16:19:14.12', false, 'L', 'The food is tasty and flavorful', 1, 1, 77, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (88, 'Q2', '2014-02-22 16:19:14.213', 'EN', '2014-02-22 16:19:14.213', true, 'F', '<b>Resturant</b>', 1, 1, NULL, 76, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (95, 'Q2.1', '2014-02-22 16:19:14.219', 'EN', '2014-02-22 16:19:14.219', false, 'L', 'My food order was correct and complete', 1, 1, 88, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (96, 'Q2.2', '2014-02-22 16:19:14.22', 'EN', '2014-02-22 16:19:14.22', false, 'L', 'Employees are patient when taking my order', 1, 1, 88, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (97, 'Q2.3', '2014-02-22 16:19:14.22', 'EN', '2014-02-22 16:19:14.22', false, 'L', 'I was served promptly', 1, 1, 88, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (98, 'Q2.4', '2014-02-22 16:19:14.221', 'EN', '2014-02-22 16:19:14.221', false, 'L', 'Availability of sauces, utensils, napkins, etc. was good', 1, 1, 88, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (99, 'Q2.5', '2014-02-22 16:19:14.222', 'EN', '2014-02-22 16:19:14.222', false, 'L', 'The menu board was easy to read', 1, 1, 88, NULL, 4, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (100, 'Q2.6', '2014-02-22 16:19:14.223', 'EN', '2014-02-22 16:19:14.223', false, 'L', 'The drive-thru sound system was cleara', 1, 1, 88, NULL, 5, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (101, 'Q3', '2014-02-22 16:19:14.36', 'EN', '2014-02-22 16:19:14.36', true, 'L', 'Indicate total household income', 1, 1, NULL, 76, NULL, 2);


--
-- TOC entry 2077 (class 0 OID 109496)
-- Dependencies: 176 2067 2067 2086
-- Data for Name: study; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO study (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (62, '2014-02-22 16:19:13.83', '2014-02-22 16:19:13.795', '2014-02-22 16:19:13.83', 'New survey Sample QuestionnairDefinition started', '2014-02-22 16:19:13.795', 'BY_INVITATION', 1, 1);
INSERT INTO study (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (109, '2014-02-22 16:19:14.793', '2014-02-22 16:19:14.774', '2014-02-22 16:19:14.793', 'New survey Food Quality QuestionnairDefinition started', '2014-02-22 16:19:14.774', 'BY_INVITATION', 1, 1);


--
-- TOC entry 2079 (class 0 OID 109512)
-- Dependencies: 178 2076 2067 2071 2077 2067 2086
-- Data for Name: questionnair; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (63, 1, '2014-02-22 16:19:13.862', '2014-02-22 16:19:13.862', 'CONFIRMED', NULL, 1, 1, 2, 6, 62);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (66, NULL, '2014-02-22 16:19:13.926', '2014-02-22 16:19:13.926', 'CONFIRMED', NULL, 1, 1, 5, 6, 62);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (69, NULL, '2014-02-22 16:19:13.976', '2014-02-22 16:19:13.976', 'CONFIRMED', NULL, 1, 1, 4, 6, 62);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (72, NULL, '2014-02-22 16:19:14.001', '2014-02-22 16:19:14.001', 'CONFIRMED', NULL, 1, 1, 3, 6, 62);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (113, NULL, '2014-02-22 16:19:14.808', '2014-02-22 16:19:14.808', 'CONFIRMED', NULL, 1, 1, 5, 75, 109);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (110, NULL, '2014-02-22 16:19:14.802', '2014-02-22 16:19:14.802', 'CONFIRMED', NULL, 1, 1, 2, 75, 109);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (116, NULL, '2014-02-22 16:19:14.838', '2014-02-22 16:19:14.838', 'CONFIRMED', NULL, 1, 1, 4, 75, 109);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (119, NULL, '2014-02-22 16:19:14.856', '2014-02-22 16:19:14.856', 'CONFIRMED', NULL, 1, 1, 3, 75, 109);


--
-- TOC entry 2072 (class 0 OID 109459)
-- Dependencies: 171 2067 2067 2070 2079 2074 2086
-- Data for Name: browsed_element; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2066 (class 0 OID 109409)
-- Dependencies: 165 2077 2076 2086
-- Data for Name: invitation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (67, 'P', 'ACTIVE', '5YM3TILSKZ', 62, 5);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (70, 'P', 'ACTIVE', 'UG22FEUD32', 62, 4);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (73, 'P', 'ACTIVE', 'UZUWWWPW95', 62, 3);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (114, 'P', 'ACTIVE', 'X56QWODXF9', 109, 5);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (117, 'P', 'ACTIVE', '51DTVUNJHT', 109, 4);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (120, 'P', 'ACTIVE', '6ARFD2SE2X', 109, 3);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (64, 'P', 'ACTIVE', '12345678', 62, 2);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (111, 'P', 'ACTIVE', '87654321', 109, 2);


--
-- TOC entry 2078 (class 0 OID 109504)
-- Dependencies: 177 2086
-- Data for Name: label_set; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO label_set (id, language, name) VALUES (11, 'EN', 'Feelings');


--
-- TOC entry 2069 (class 0 OID 109435)
-- Dependencies: 168 2067 2078 2067 2086
-- Data for Name: label; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO label (id, created_date, language, last_modified_date, title, createdby_id, labelset_id, lastmodifiedby_id, sort_order) VALUES (13, '2014-02-22 16:19:12.193', 'EN', '2014-02-22 16:19:12.193', 'Agree somewhat', 1, 11, 1, 1);
INSERT INTO label (id, created_date, language, last_modified_date, title, createdby_id, labelset_id, lastmodifiedby_id, sort_order) VALUES (12, '2014-02-22 16:19:12.189', 'EN', '2014-02-22 16:19:12.189', 'Agree strongly', 1, 11, 1, 0);
INSERT INTO label (id, created_date, language, last_modified_date, title, createdby_id, labelset_id, lastmodifiedby_id, sort_order) VALUES (14, '2014-02-22 16:19:12.197', 'EN', '2014-02-22 16:19:12.197', 'Neither agree nor disagree', 1, 11, 1, 2);
INSERT INTO label (id, created_date, language, last_modified_date, title, createdby_id, labelset_id, lastmodifiedby_id, sort_order) VALUES (15, '2014-02-22 16:19:12.202', 'EN', '2014-02-22 16:19:12.202', 'Disagree somewhat', 1, 11, 1, 3);
INSERT INTO label (id, created_date, language, last_modified_date, title, createdby_id, labelset_id, lastmodifiedby_id, sort_order) VALUES (16, '2014-02-22 16:19:12.207', 'EN', '2014-02-22 16:19:12.207', 'Disagree strongly', 1, 11, 1, 4);


--
-- TOC entry 2085 (class 0 OID 109557)
-- Dependencies: 184 2069 2086
-- Data for Name: label_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2068 (class 0 OID 109427)
-- Dependencies: 167 2086
-- Data for Name: mail_message; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (65, 'Dear Mr. Lannister, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=8ZIBGE201G">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (68, 'Dear Mr. Stark, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=5YM3TILSKZ">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (71, 'Estimado Sr. Stark, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=UG22FEUD32">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (74, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=UZUWWWPW95">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en una encuesta', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (112, 'Dear Mr. Lannister, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=Z3KPA8TI7N">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (115, 'Dear Mr. Stark, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=X56QWODXF9">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (118, 'Estimado Sr. Stark, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=51DTVUNJHT">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (121, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=6ARFD2SE2X">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en una encuesta', 'jon.snow@nightswatch.net');


--
-- TOC entry 2075 (class 0 OID 109480)
-- Dependencies: 174 2067 2067 2071 2086
-- Data for Name: mail_message_template; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (60, '2014-02-22 16:19:13.519', 'support@gazpacho.net', 'EN', '2014-02-22 16:19:13.519', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'PersonalInvitation to participate in questionnairDefinition', 1, 1, 6);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (107, '2014-02-22 16:19:14.449', 'support@gazpacho.net', 'EN', '2014-02-22 16:19:14.449', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'PersonalInvitation to participate in questionnairDefinition', 1, 1, 75);


--
-- TOC entry 2081 (class 0 OID 109525)
-- Dependencies: 180 2067 2067 2075 2086
-- Data for Name: mail_message_template_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (61, '2014-02-22 16:19:13.568', 'ES', '2014-02-22 16:19:13.568', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en una encuesta', 1, 1, 60);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (108, '2014-02-22 16:19:14.468', 'ES', '2014-02-22 16:19:14.468', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en una encuesta', 1, 1, 107);


--
-- TOC entry 2084 (class 0 OID 109549)
-- Dependencies: 183 2074 2086
-- Data for Name: question_group_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2073 (class 0 OID 109464)
-- Dependencies: 172 2067 2070 2067 2086
-- Data for Name: question_option; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (19, 'O1', '2014-02-22 16:19:12.605', 'EN', '2014-02-22 16:19:12.605', '0-14 years', 1, 1, 18, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (20, 'O2', '2014-02-22 16:19:12.607', 'EN', '2014-02-22 16:19:12.607', '15-19 years', 1, 1, 18, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (21, 'O3', '2014-02-22 16:19:12.609', 'EN', '2014-02-22 16:19:12.609', '20-24 years', 1, 1, 18, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (22, 'O4', '2014-02-22 16:19:12.611', 'EN', '2014-02-22 16:19:12.611', '25-29 years', 1, 1, 18, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (23, 'O5', '2014-02-22 16:19:12.613', 'EN', '2014-02-22 16:19:12.613', '30-34 years', 1, 1, 18, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (24, 'O6', '2014-02-22 16:19:12.616', 'EN', '2014-02-22 16:19:12.616', '35-39 years', 1, 1, 18, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (25, 'O7', '2014-02-22 16:19:12.617', 'EN', '2014-02-22 16:19:12.617', '40-44 years', 1, 1, 18, 6);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (26, 'O8', '2014-02-22 16:19:12.619', 'EN', '2014-02-22 16:19:12.619', '45-49 years', 1, 1, 18, 7);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (27, 'O9', '2014-02-22 16:19:12.621', 'EN', '2014-02-22 16:19:12.621', '50-54 years', 1, 1, 18, 8);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (28, 'O10', '2014-02-22 16:19:12.624', 'EN', '2014-02-22 16:19:12.624', '55-59 years', 1, 1, 18, 9);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (29, 'O11', '2014-02-22 16:19:12.626', 'EN', '2014-02-22 16:19:12.626', '60-64 years', 1, 1, 18, 10);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (30, 'O12', '2014-02-22 16:19:12.628', 'EN', '2014-02-22 16:19:12.628', '65-69 years', 1, 1, 18, 11);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (31, 'O13', '2014-02-22 16:19:12.63', 'EN', '2014-02-22 16:19:12.63', '70-74 years', 1, 1, 18, 12);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (32, 'O14', '2014-02-22 16:19:12.632', 'EN', '2014-02-22 16:19:12.632', '75-79 years', 1, 1, 18, 13);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (33, 'O15', '2014-02-22 16:19:12.634', 'EN', '2014-02-22 16:19:12.634', '80 and over', 1, 1, 18, 14);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (37, 'O1', '2014-02-22 16:19:13.148', 'EN', '2014-02-22 16:19:13.148', 'Very difficult to read, my eyesight is dim', 1, 1, 36, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (38, 'O2', '2014-02-22 16:19:13.148', 'EN', '2014-02-22 16:19:13.148', 'Easy, my carer is doing it all for me', 1, 1, 36, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (39, 'O3', '2014-02-22 16:19:13.149', 'EN', '2014-02-22 16:19:13.149', 'How <b><i>dare</i></b> you insult me like that! I''m YOUNG', 1, 1, 36, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (41, 'O1', '2014-02-22 16:19:13.197', 'EN', '2014-02-22 16:19:13.197', 'Ad one', 1, 1, 40, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (42, 'O2', '2014-02-22 16:19:13.198', 'EN', '2014-02-22 16:19:13.198', 'Ad two', 1, 1, 40, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (43, 'O3', '2014-02-22 16:19:13.199', 'EN', '2014-02-22 16:19:13.199', 'Ad three', 1, 1, 40, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (45, 'O1', '2014-02-22 16:19:13.282', 'EN', '2014-02-22 16:19:13.282', 'Agree strongly', 1, 1, 44, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (46, 'O2', '2014-02-22 16:19:13.284', 'EN', '2014-02-22 16:19:13.284', 'Agree somewhat', 1, 1, 44, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (47, 'O3', '2014-02-22 16:19:13.285', 'EN', '2014-02-22 16:19:13.285', 'Neither agree nor disagree', 1, 1, 44, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (48, 'O4', '2014-02-22 16:19:13.288', 'EN', '2014-02-22 16:19:13.288', 'Disagree somewhat', 1, 1, 44, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (49, 'O5', '2014-02-22 16:19:13.29', 'EN', '2014-02-22 16:19:13.29', 'Agree strongly', 1, 1, 44, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (50, 'O6', '2014-02-22 16:19:13.291', 'EN', '2014-02-22 16:19:13.291', 'Disagree strongly', 1, 1, 44, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (56, 'O1', '2014-02-22 16:19:13.403', 'EN', '2014-02-22 16:19:13.403', 'Vanilla', 1, 1, 55, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (57, 'O2', '2014-02-22 16:19:13.403', 'EN', '2014-02-22 16:19:13.403', 'Chocolate', 1, 1, 55, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (58, 'O3', '2014-02-22 16:19:13.405', 'EN', '2014-02-22 16:19:13.405', 'Strawberry', 1, 1, 55, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (59, 'O4', '2014-02-22 16:19:13.406', 'EN', '2014-02-22 16:19:13.406', 'Pistachio', 1, 1, 55, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (78, 'O1', '2014-02-22 16:19:14.11', 'EN', '2014-02-22 16:19:14.11', 'Agree strongly', 1, 1, 77, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (79, 'O2', '2014-02-22 16:19:14.111', 'EN', '2014-02-22 16:19:14.111', 'Agree somewhat', 1, 1, 77, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (80, 'O3', '2014-02-22 16:19:14.113', 'EN', '2014-02-22 16:19:14.113', 'Neither agree nor disagree', 1, 1, 77, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (81, 'O4', '2014-02-22 16:19:14.115', 'EN', '2014-02-22 16:19:14.115', 'Disagree somewhat', 1, 1, 77, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (82, 'O5', '2014-02-22 16:19:14.116', 'EN', '2014-02-22 16:19:14.116', 'Agree strongly', 1, 1, 77, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (83, 'O6', '2014-02-22 16:19:14.117', 'EN', '2014-02-22 16:19:14.117', 'Disagree strongly', 1, 1, 77, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (89, 'O1', '2014-02-22 16:19:14.215', 'EN', '2014-02-22 16:19:14.215', 'Agree strongly', 1, 1, 88, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (90, 'O2', '2014-02-22 16:19:14.215', 'EN', '2014-02-22 16:19:14.215', 'Agree somewhat', 1, 1, 88, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (91, 'O3', '2014-02-22 16:19:14.216', 'EN', '2014-02-22 16:19:14.216', 'Neither agree nor disagree', 1, 1, 88, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (92, 'O4', '2014-02-22 16:19:14.217', 'EN', '2014-02-22 16:19:14.217', 'Disagree somewhat', 1, 1, 88, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (93, 'O5', '2014-02-22 16:19:14.217', 'EN', '2014-02-22 16:19:14.217', 'Agree strongly', 1, 1, 88, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (94, 'O6', '2014-02-22 16:19:14.218', 'EN', '2014-02-22 16:19:14.218', 'Disagree strongly', 1, 1, 88, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (102, 'O1', '2014-02-22 16:19:14.361', 'EN', '2014-02-22 16:19:14.361', 'under 25,000€', 1, 1, 101, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (103, 'O2', '2014-02-22 16:19:14.362', 'EN', '2014-02-22 16:19:14.362', '25,000 - 29,999€', 1, 1, 101, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (104, 'O3', '2014-02-22 16:19:14.363', 'EN', '2014-02-22 16:19:14.363', '30,000 - 34,999€', 1, 1, 101, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (105, 'O4', '2014-02-22 16:19:14.365', 'EN', '2014-02-22 16:19:14.365', '35,000 - 39,999€', 1, 1, 101, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (106, 'O5', '2014-02-22 16:19:14.366', 'EN', '2014-02-22 16:19:14.366', 'Over 85,000€', 1, 1, 101, 4);


--
-- TOC entry 2083 (class 0 OID 109541)
-- Dependencies: 182 2073 2086
-- Data for Name: question_option_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2080 (class 0 OID 109517)
-- Dependencies: 179 2070 2086
-- Data for Name: question_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: questionnair_definition_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition_translation (id, language, description, title, welcometext, questionnairdefinition_id) VALUES (7, 'ES', '<p>Esto es una encuesta de ejemplo diseñada para GazpachoSurvey</p>', 'Ejemplo de encuesta', 'Gracias por participar en esta encuesta', 6);


INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnair_answers_6_seq', 5);
INSERT INTO sequence (seq_name, seq_count) VALUES ('SEQ_GEN', 150);

INSERT INTO questionnair_answers_6 (id, q1, q2, q3, q4, q5, q6, q7_1, q7_2, q7_3, q7_4, q8_o1, q8_o2, q8_o3, q8_o4) VALUES (1, 'Antonio Maria Sanchez Berrocal', '05', 33, 'I started to work in IECISA, 10 years ago', '02', '01', '01', '02', '03', '01', true, true, true, NULL);
