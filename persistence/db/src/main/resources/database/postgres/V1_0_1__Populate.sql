
--
-- TOC entry 2189 (class 0 OID 38884)
-- Dependencies: 191
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, acronym, api_key, created_date, email, gender, given_names, last_modified_date, prefered_language, surname, username, createdby_id, lastmodifiedby_id) VALUES (1, 'SUPPSUPP', 'B07NKXIU4RGNTSL', '2014-04-17 08:43:17.972', 'support@gazpacho.net', NULL, 'support', '2014-04-17 08:43:17.972', NULL, 'support', 'support', 1, 1);
INSERT INTO users (id, acronym, api_key, created_date, email, gender, given_names, last_modified_date, prefered_language, surname, username, createdby_id, lastmodifiedby_id) VALUES (3, 'TYRILANN', 'LOZYDUG1KYUOLC2', '2014-04-17 08:43:18.235', 'tyrion.lannister@kingslanding.net', 'MALE', 'Tyrion', '2014-04-17 08:43:18.235', 'EN', 'Lannister', NULL, 1, 1);
INSERT INTO users (id, acronym, api_key, created_date, email, gender, given_names, last_modified_date, prefered_language, surname, username, createdby_id, lastmodifiedby_id) VALUES (4, 'JONSNOW', 'I1J2379Z17CZCTQ', '2014-04-17 08:43:18.248', 'jon.snow@nightswatch.net', 'MALE', 'Jon', '2014-04-17 08:43:18.248', 'ES', 'Snow', NULL, 1, 1);
INSERT INTO users (id, acronym, api_key, created_date, email, gender, given_names, last_modified_date, prefered_language, surname, username, createdby_id, lastmodifiedby_id) VALUES (5, 'ARYASTAR', 'RX44JTNVYJF9UCC', '2014-04-17 08:43:18.268', 'arya.stark@winterfell.net', 'FEMALE', 'Arya', '2014-04-17 08:43:18.268', NULL, 'Stark', NULL, 1, 1);
INSERT INTO users (id, acronym, api_key, created_date, email, gender, given_names, last_modified_date, prefered_language, surname, username, createdby_id, lastmodifiedby_id) VALUES (6, 'CATESTAR', '1L4X7LS7ZMSI0MP', '2014-04-17 08:43:18.283', 'catelyn.stark@winterfell.net', 'FEMALE', 'Catelyn', '2014-04-17 08:43:18.283', 'FI', 'Stark', NULL, 1, 1);


--
-- TOC entry 2177 (class 0 OID 38791)
-- Dependencies: 179
-- Data for Name: questionnair_definition; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, status, description, title, welcometext, createdby_id, lastmodifiedby_id) VALUES (7, '2014-04-17 08:43:18.359', 'EN', '2014-04-17 08:43:18.359', 'CONFIRMED', '<p>This is a <strong><em>sample questionnairDefinition</em></strong> designed for testing GazpachoSurvey.</p>', 'Sample QuestionnairDefinition', 'Thank you for taking the time to participate in this questionnairDefinition.', 1, 1);
INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, status, description, title, welcometext, createdby_id, lastmodifiedby_id) VALUES (80, '2014-04-17 08:43:20.532', 'EN', '2014-04-17 08:43:20.532', 'CONFIRMED', 'We at BIG DEES take pride in providing you with the highest standards of QUALITY, SERVICE, CLEANLINESS and VALUE in the restaurant industry.', 'Food Quality QuestionnairDefinition', 'Your opinion is extremely important in evaluating our business. Thank you for taking a moment to questionOption the following questions:', 1, 1);


--
-- TOC entry 2175 (class 0 OID 38778)
-- Dependencies: 177
-- Data for Name: question_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (9, '2014-04-17 08:43:18.483', 'EN', '2014-04-17 08:43:18.483', 'QuestionGroup 1', 1, 1, 7, 0);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (10, '2014-04-17 08:43:18.523', 'EN', '2014-04-17 08:43:18.523', 'QuestionGroup 2', 1, 1, 7, 1);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (11, '2014-04-17 08:43:18.561', 'EN', '2014-04-17 08:43:18.561', 'QuestionGroup 3', 1, 1, 7, 2);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (81, '2014-04-17 08:43:20.553', 'EN', '2014-04-17 08:43:20.553', 'Fast Food QuestionnairDefinition - QuestionGroup', 1, 1, 80, 0);


--
-- TOC entry 2174 (class 0 OID 38770)
-- Dependencies: 176
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (12, 'Q1', '2014-04-17 08:43:18.641', 'EN', '2014-04-17 08:43:18.641', true, 'S', 'What is your name?', 1, 1, NULL, 9, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (13, 'Q2', '2014-04-17 08:43:18.82', 'EN', '2014-04-17 08:43:18.82', true, 'L', 'What is your age group?', 1, 1, NULL, 9, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (29, 'Q3', '2014-04-17 08:43:18.997', 'EN', '2014-04-17 08:43:18.997', true, 'N', 'And for our records, specifically how old are you?', 1, 1, NULL, 9, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (30, 'Q4', '2014-04-17 08:43:19.06', 'EN', '2014-04-17 08:43:19.06', true, 'T', 'Please tell us a little about yourself. What was your first job, and did you enjoy it?', 1, 1, NULL, 10, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (31, 'Q5', '2014-04-17 08:43:19.087', 'EN', '2014-04-17 08:43:19.087', true, 'L', 'Given your extraordinary age, how do you find using this questionnairDefinition tool?', 1, 1, NULL, 10, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (35, 'Q6', '2014-04-17 08:43:19.135', 'EN', '2014-04-17 08:43:19.135', true, 'L', 'Which of these ads makes you want to find out more?', 1, 1, NULL, 10, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (39, 'Q7', '2014-04-17 08:43:19.228', 'EN', '2014-04-17 08:43:19.228', true, 'F', 'Please have a good look at this ad, and then complete the questions below.<br /><img src=''http://www.aptigence.com.au/images/lawyer1.jpg'' border=''1''>', 1, 1, NULL, 11, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (46, 'Q7.1', '2014-04-17 08:43:19.251', 'EN', '2014-04-17 08:43:19.251', false, 'L', 'This ad suggests the lawyer is on my side, not his own', 1, 1, 39, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (47, 'Q7.2', '2014-04-17 08:43:19.254', 'EN', '2014-04-17 08:43:19.254', false, 'L', 'This ad suggests that the lawyer is interested in a life of frugal community service', 1, 1, 39, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (48, 'Q7.3', '2014-04-17 08:43:19.258', 'EN', '2014-04-17 08:43:19.258', false, 'L', 'This ad would be enough to get me to hire this lawyer', 1, 1, 39, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (49, 'Q7.4', '2014-04-17 08:43:19.261', 'EN', '2014-04-17 08:43:19.261', false, 'L', 'This ad gives me confidence in the lawyers experience', 1, 1, 39, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (50, 'Q8', '2014-04-17 08:43:19.364', 'EN', '2014-04-17 08:43:19.364', false, 'M', 'What flavors of ice cream do you like?. Choose all that apply.', 1, 1, NULL, 11, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (82, 'Q1', '2014-04-17 08:43:20.587', 'EN', '2014-04-17 08:43:20.587', true, 'F', '<b>Food Quality</b>', 1, 1, NULL, 81, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (89, 'Q1.1', '2014-04-17 08:43:20.597', 'EN', '2014-04-17 08:43:20.597', false, 'L', 'The food is served hot and fresh', 1, 1, 82, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (90, 'Q1.2', '2014-04-17 08:43:20.599', 'EN', '2014-04-17 08:43:20.599', false, 'L', 'The menu has a good variety of items', 1, 1, 82, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (91, 'Q1.3', '2014-04-17 08:43:20.601', 'EN', '2014-04-17 08:43:20.601', false, 'L', 'The quality of food is excellent', 1, 1, 82, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (92, 'Q1.4', '2014-04-17 08:43:20.603', 'EN', '2014-04-17 08:43:20.603', false, 'L', 'The food is tasty and flavorful', 1, 1, 82, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (93, 'Q2', '2014-04-17 08:43:20.705', 'EN', '2014-04-17 08:43:20.705', true, 'F', '<b>Resturant</b>', 1, 1, NULL, 81, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (100, 'Q2.1', '2014-04-17 08:43:20.723', 'EN', '2014-04-17 08:43:20.723', false, 'L', 'My food order was correct and complete', 1, 1, 93, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (101, 'Q2.2', '2014-04-17 08:43:20.729', 'EN', '2014-04-17 08:43:20.729', false, 'L', 'Employees are patient when taking my order', 1, 1, 93, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (102, 'Q2.3', '2014-04-17 08:43:20.731', 'EN', '2014-04-17 08:43:20.731', false, 'L', 'I was served promptly', 1, 1, 93, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (103, 'Q2.4', '2014-04-17 08:43:20.734', 'EN', '2014-04-17 08:43:20.734', false, 'L', 'Availability of sauces, utensils, napkins, etc. was good', 1, 1, 93, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (104, 'Q2.5', '2014-04-17 08:43:20.737', 'EN', '2014-04-17 08:43:20.737', false, 'L', 'The menu board was easy to read', 1, 1, 93, NULL, 4, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (105, 'Q2.6', '2014-04-17 08:43:20.739', 'EN', '2014-04-17 08:43:20.739', false, 'L', 'The drive-thru sound system was cleara', 1, 1, 93, NULL, 5, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (106, 'Q3', '2014-04-17 08:43:20.842', 'EN', '2014-04-17 08:43:20.842', true, 'L', 'Indicate total household income', 1, 1, NULL, 81, NULL, 2);


--
-- TOC entry 2179 (class 0 OID 38807)
-- Dependencies: 181
-- Data for Name: research; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (57, '2014-04-17 08:43:20.035', '2014-04-17 08:43:20', '2014-04-17 08:43:20.035', 'New private Questionnair Sample QuestionnairDefinition started', '2014-04-17 08:43:20.001', 'BY_INVITATION', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (78, '2014-04-17 08:43:20.482', '2014-04-17 08:43:20.463', '2014-04-17 08:43:20.482', 'New open Questionnair Sample QuestionnairDefinition started', '2014-04-17 08:43:20.463', 'OPEN_ACCESS', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (114, '2014-04-17 08:43:21.193', '2014-04-17 08:43:21.181', '2014-04-17 08:43:21.193', 'New survey Food Quality QuestionnairDefinition started', '2014-04-17 08:43:21.181', 'BY_INVITATION', 1, 1);


--
-- TOC entry 2176 (class 0 OID 38786)
-- Dependencies: 178
-- Data for Name: questionnair; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (58, NULL, '2014-04-17 08:43:20.092', '2014-04-17 08:43:20.092', 'CONFIRMED', NULL, 1, 1, 7, 57, 6);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (63, NULL, '2014-04-17 08:43:20.275', '2014-04-17 08:43:20.275', 'CONFIRMED', NULL, 1, 1, 7, 57, 5);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (68, NULL, '2014-04-17 08:43:20.331', '2014-04-17 08:43:20.331', 'CONFIRMED', NULL, 1, 1, 7, 57, 4);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (73, NULL, '2014-04-17 08:43:20.398', '2014-04-17 08:43:20.398', 'CONFIRMED', NULL, 1, 1, 7, 57, 3);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (115, NULL, '2014-04-17 08:43:21.21', '2014-04-17 08:43:21.21', 'CONFIRMED', NULL, 1, 1, 80, 114, 6);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (119, NULL, '2014-04-17 08:43:21.248', '2014-04-17 08:43:21.248', 'CONFIRMED', NULL, 1, 1, 80, 114, 5);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (123, NULL, '2014-04-17 08:43:21.274', '2014-04-17 08:43:21.274', 'CONFIRMED', NULL, 1, 1, 80, 114, 4);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (127, NULL, '2014-04-17 08:43:21.299', '2014-04-17 08:43:21.299', 'CONFIRMED', NULL, 1, 1, 80, 114, 3);


--
-- TOC entry 2169 (class 0 OID 38733)
-- Dependencies: 171
-- Data for Name: browsed_element; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2186 (class 0 OID 38863)
-- Dependencies: 188
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO groups (id, created_date, description, last_modified_date, name, createdby_id, lastmodifiedby_id) VALUES (2, '2014-04-17 08:43:18.196', 'Respondent group', '2014-04-17 08:43:18.196', 'Respondents', 1, 1);


--
-- TOC entry 2188 (class 0 OID 38876)
-- Dependencies: 190
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO role (id, description, name, scope) VALUES (59, 'Specific role for Catelyn Stark ', 'CATESTAR', 'USER');
INSERT INTO role (id, description, name, scope) VALUES (64, 'Specific role for Arya Stark ', 'ARYASTAR', 'USER');
INSERT INTO role (id, description, name, scope) VALUES (69, 'Specific role for Jon Snow ', 'JONSNOW', 'USER');
INSERT INTO role (id, description, name, scope) VALUES (74, 'Specific role for Tyrion Lannister ', 'TYRILANN', 'USER');


--
-- TOC entry 2190 (class 0 OID 38896)
-- Dependencies: 192
-- Data for Name: group_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2168 (class 0 OID 38725)
-- Dependencies: 170
-- Data for Name: invitation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (61, 'P', 'ACTIVE', '1234567890', 57, 6);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (66, 'P', 'ACTIVE', '7BCYSFJ8S5', 57, 5);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (71, 'P', 'ACTIVE', 'PZL1WBDDOH', 57, 4);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (76, 'P', 'ACTIVE', 'VGUHBMNCEH', 57, 3);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (79, 'A', 'ACTIVE', '0123456789', 78, NULL);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (117, 'P', 'ACTIVE', 'PARA9Y4ML6', 114, 6);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (121, 'P', 'ACTIVE', '9ORTYE1NAX', 114, 5);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (125, 'P', 'ACTIVE', 'S0PQILAJQ1', 114, 4);
INSERT INTO invitation (id, type, status, token, research_id, respondent_id) VALUES (129, 'P', 'ACTIVE', 'Q4WLL1S7K0', 114, 3);


--
-- TOC entry 2171 (class 0 OID 38746)
-- Dependencies: 173
-- Data for Name: label_set; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2170 (class 0 OID 38738)
-- Dependencies: 172
-- Data for Name: label; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2180 (class 0 OID 38815)
-- Dependencies: 182
-- Data for Name: label_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2172 (class 0 OID 38754)
-- Dependencies: 174
-- Data for Name: mail_message; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (62, 'Dear Mr. Stark, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=JNDSWUNZN9">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (67, 'Estimado Sr. Stark, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=7BCYSFJ8S5">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (72, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=PZL1WBDDOH">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en una encuesta', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (77, 'Dear Mr. Lannister, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=VGUHBMNCEH">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (118, 'Dear Mr. Stark, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=PARA9Y4ML6">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (122, 'Estimado Sr. Stark, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=9ORTYE1NAX">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (126, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=S0PQILAJQ1">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en una encuesta', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (130, 'Dear Mr. Lannister, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=Q4WLL1S7K0">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'tyrion.lannister@kingslanding.net');


--
-- TOC entry 2173 (class 0 OID 38762)
-- Dependencies: 175
-- Data for Name: mail_message_template; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (55, '2014-04-17 08:43:19.51', 'support@gazpacho.net', 'EN', '2014-04-17 08:43:19.51', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'PersonalInvitation to participate in questionnairDefinition', 1, 1, 7);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (112, '2014-04-17 08:43:20.964', 'support@gazpacho.net', 'EN', '2014-04-17 08:43:20.964', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'PersonalInvitation to participate in questionnairDefinition', 1, 1, 80);


--
-- TOC entry 2181 (class 0 OID 38823)
-- Dependencies: 183
-- Data for Name: mail_message_template_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (56, '2014-04-17 08:43:19.703', 'ES', '2014-04-17 08:43:19.703', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en una encuesta', 1, 1, 55);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (113, '2014-04-17 08:43:20.983', 'ES', '2014-04-17 08:43:20.983', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en una encuesta', 1, 1, 112);


--
-- TOC entry 2187 (class 0 OID 38871)
-- Dependencies: 189
-- Data for Name: permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO permission (id, entity_id, numeral, scope, role_id) VALUES (60, 58, 3, 'Q', 59);
INSERT INTO permission (id, entity_id, numeral, scope, role_id) VALUES (65, 63, 3, 'Q', 64);
INSERT INTO permission (id, entity_id, numeral, scope, role_id) VALUES (70, 68, 3, 'Q', 69);
INSERT INTO permission (id, entity_id, numeral, scope, role_id) VALUES (75, 73, 3, 'Q', 74);
INSERT INTO permission (id, entity_id, numeral, scope, role_id) VALUES (116, 115, 3, 'Q', 59);
INSERT INTO permission (id, entity_id, numeral, scope, role_id) VALUES (120, 119, 3, 'Q', 64);
INSERT INTO permission (id, entity_id, numeral, scope, role_id) VALUES (124, 123, 3, 'Q', 69);
INSERT INTO permission (id, entity_id, numeral, scope, role_id) VALUES (128, 127, 3, 'Q', 74);


--
-- TOC entry 2182 (class 0 OID 38831)
-- Dependencies: 184
-- Data for Name: question_group_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2178 (class 0 OID 38799)
-- Dependencies: 180
-- Data for Name: question_option; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (14, 'O1', '2014-04-17 08:43:18.841', 'EN', '2014-04-17 08:43:18.841', '0-14 years', 1, 1, 13, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (15, 'O2', '2014-04-17 08:43:18.844', 'EN', '2014-04-17 08:43:18.844', '15-19 years', 1, 1, 13, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (16, 'O3', '2014-04-17 08:43:18.848', 'EN', '2014-04-17 08:43:18.848', '20-24 years', 1, 1, 13, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (17, 'O4', '2014-04-17 08:43:18.85', 'EN', '2014-04-17 08:43:18.85', '25-29 years', 1, 1, 13, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (18, 'O5', '2014-04-17 08:43:18.853', 'EN', '2014-04-17 08:43:18.853', '30-34 years', 1, 1, 13, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (19, 'O6', '2014-04-17 08:43:18.856', 'EN', '2014-04-17 08:43:18.856', '35-39 years', 1, 1, 13, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (20, 'O7', '2014-04-17 08:43:18.859', 'EN', '2014-04-17 08:43:18.859', '40-44 years', 1, 1, 13, 6);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (21, 'O8', '2014-04-17 08:43:18.862', 'EN', '2014-04-17 08:43:18.862', '45-49 years', 1, 1, 13, 7);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (22, 'O9', '2014-04-17 08:43:18.865', 'EN', '2014-04-17 08:43:18.865', '50-54 years', 1, 1, 13, 8);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (23, 'O10', '2014-04-17 08:43:18.868', 'EN', '2014-04-17 08:43:18.868', '55-59 years', 1, 1, 13, 9);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (24, 'O11', '2014-04-17 08:43:18.871', 'EN', '2014-04-17 08:43:18.871', '60-64 years', 1, 1, 13, 10);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (25, 'O12', '2014-04-17 08:43:18.874', 'EN', '2014-04-17 08:43:18.874', '65-69 years', 1, 1, 13, 11);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (26, 'O13', '2014-04-17 08:43:18.877', 'EN', '2014-04-17 08:43:18.877', '70-74 years', 1, 1, 13, 12);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (27, 'O14', '2014-04-17 08:43:18.879', 'EN', '2014-04-17 08:43:18.879', '75-79 years', 1, 1, 13, 13);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (28, 'O15', '2014-04-17 08:43:18.881', 'EN', '2014-04-17 08:43:18.881', '80 and over', 1, 1, 13, 14);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (32, 'O1', '2014-04-17 08:43:19.089', 'EN', '2014-04-17 08:43:19.089', 'Very difficult to read, my eyesight is dim', 1, 1, 31, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (33, 'O2', '2014-04-17 08:43:19.092', 'EN', '2014-04-17 08:43:19.092', 'Easy, my carer is doing it all for me', 1, 1, 31, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (34, 'O3', '2014-04-17 08:43:19.094', 'EN', '2014-04-17 08:43:19.094', 'How <b><i>dare</i></b> you insult me like that! I''m YOUNG', 1, 1, 31, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (36, 'O1', '2014-04-17 08:43:19.139', 'EN', '2014-04-17 08:43:19.139', 'Ad one', 1, 1, 35, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (37, 'O2', '2014-04-17 08:43:19.142', 'EN', '2014-04-17 08:43:19.142', 'Ad two', 1, 1, 35, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (38, 'O3', '2014-04-17 08:43:19.145', 'EN', '2014-04-17 08:43:19.145', 'Ad three', 1, 1, 35, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (40, 'O1', '2014-04-17 08:43:19.231', 'EN', '2014-04-17 08:43:19.231', 'Agree strongly', 1, 1, 39, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (41, 'O2', '2014-04-17 08:43:19.234', 'EN', '2014-04-17 08:43:19.234', 'Agree somewhat', 1, 1, 39, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (42, 'O3', '2014-04-17 08:43:19.238', 'EN', '2014-04-17 08:43:19.238', 'Neither agree nor disagree', 1, 1, 39, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (43, 'O4', '2014-04-17 08:43:19.241', 'EN', '2014-04-17 08:43:19.241', 'Disagree somewhat', 1, 1, 39, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (44, 'O5', '2014-04-17 08:43:19.244', 'EN', '2014-04-17 08:43:19.244', 'Agree strongly', 1, 1, 39, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (45, 'O6', '2014-04-17 08:43:19.248', 'EN', '2014-04-17 08:43:19.248', 'Disagree strongly', 1, 1, 39, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (51, 'O1', '2014-04-17 08:43:19.371', 'EN', '2014-04-17 08:43:19.371', 'Vanilla', 1, 1, 50, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (52, 'O2', '2014-04-17 08:43:19.375', 'EN', '2014-04-17 08:43:19.375', 'Chocolate', 1, 1, 50, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (53, 'O3', '2014-04-17 08:43:19.384', 'EN', '2014-04-17 08:43:19.384', 'Strawberry', 1, 1, 50, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (54, 'O4', '2014-04-17 08:43:19.387', 'EN', '2014-04-17 08:43:19.387', 'Pistachio', 1, 1, 50, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (83, 'O1', '2014-04-17 08:43:20.588', 'EN', '2014-04-17 08:43:20.588', 'Agree strongly', 1, 1, 82, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (84, 'O2', '2014-04-17 08:43:20.59', 'EN', '2014-04-17 08:43:20.59', 'Agree somewhat', 1, 1, 82, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (85, 'O3', '2014-04-17 08:43:20.591', 'EN', '2014-04-17 08:43:20.591', 'Neither agree nor disagree', 1, 1, 82, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (86, 'O4', '2014-04-17 08:43:20.592', 'EN', '2014-04-17 08:43:20.592', 'Disagree somewhat', 1, 1, 82, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (87, 'O5', '2014-04-17 08:43:20.594', 'EN', '2014-04-17 08:43:20.594', 'Agree strongly', 1, 1, 82, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (88, 'O6', '2014-04-17 08:43:20.595', 'EN', '2014-04-17 08:43:20.595', 'Disagree strongly', 1, 1, 82, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (94, 'O1', '2014-04-17 08:43:20.707', 'EN', '2014-04-17 08:43:20.707', 'Agree strongly', 1, 1, 93, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (95, 'O2', '2014-04-17 08:43:20.71', 'EN', '2014-04-17 08:43:20.71', 'Agree somewhat', 1, 1, 93, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (96, 'O3', '2014-04-17 08:43:20.712', 'EN', '2014-04-17 08:43:20.712', 'Neither agree nor disagree', 1, 1, 93, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (97, 'O4', '2014-04-17 08:43:20.714', 'EN', '2014-04-17 08:43:20.714', 'Disagree somewhat', 1, 1, 93, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (98, 'O5', '2014-04-17 08:43:20.717', 'EN', '2014-04-17 08:43:20.717', 'Agree strongly', 1, 1, 93, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (99, 'O6', '2014-04-17 08:43:20.721', 'EN', '2014-04-17 08:43:20.721', 'Disagree strongly', 1, 1, 93, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (107, 'O1', '2014-04-17 08:43:20.844', 'EN', '2014-04-17 08:43:20.844', 'under 25,000€', 1, 1, 106, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (108, 'O2', '2014-04-17 08:43:20.848', 'EN', '2014-04-17 08:43:20.848', '25,000 - 29,999€', 1, 1, 106, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (109, 'O3', '2014-04-17 08:43:20.85', 'EN', '2014-04-17 08:43:20.85', '30,000 - 34,999€', 1, 1, 106, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (110, 'O4', '2014-04-17 08:43:20.852', 'EN', '2014-04-17 08:43:20.852', '35,000 - 39,999€', 1, 1, 106, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (111, 'O5', '2014-04-17 08:43:20.855', 'EN', '2014-04-17 08:43:20.855', 'Over 85,000€', 1, 1, 106, 4);


--
-- TOC entry 2184 (class 0 OID 38847)
-- Dependencies: 186
-- Data for Name: question_option_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2185 (class 0 OID 38855)
-- Dependencies: 187
-- Data for Name: question_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2194 (class 0 OID 39171)
-- Dependencies: 196
-- Data for Name: questionnair_answers_7; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2195 (class 0 OID 39179)
-- Dependencies: 197
-- Data for Name: questionnair_answers_80; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2183 (class 0 OID 38839)
-- Dependencies: 185
-- Data for Name: questionnair_definition_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition_translation (id, language, description, title, welcometext, questionnairdefinition_id) VALUES (8, 'ES', '<p>Esto es una encuesta de ejemplo diseñada para GazpachoSurvey</p>', 'Ejemplo de encuesta', 'Gracias por participar en esta encuesta', 7);


--
-- TOC entry 2193 (class 0 OID 39166)
-- Dependencies: 195
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnair_answers_7_seq', 0);
INSERT INTO sequence (seq_name, seq_count) VALUES ('SEQ_GEN', 150);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnair_answers_80_seq', 0);


--
-- TOC entry 2191 (class 0 OID 38901)
-- Dependencies: 193
-- Data for Name: user_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_group (group_id, user_id) VALUES (2, 6);
INSERT INTO user_group (group_id, user_id) VALUES (2, 5);
INSERT INTO user_group (group_id, user_id) VALUES (2, 4);
INSERT INTO user_group (group_id, user_id) VALUES (2, 3);


--
-- TOC entry 2192 (class 0 OID 38906)
-- Dependencies: 194
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_role (role_id, user_id) VALUES (59, 6);
INSERT INTO user_role (role_id, user_id) VALUES (64, 5);
INSERT INTO user_role (role_id, user_id) VALUES (69, 4);
INSERT INTO user_role (role_id, user_id) VALUES (74, 3);


-- Completed on 2014-04-17 08:54:43

--
-- PostgreSQL database dump complete
--

INSERT INTO questionnair_answers_7 (id, q1, q2, q3, q4, q5, q6, q7_1, q7_2, q7_3, q7_4, q8_o1, q8_o2, q8_o3, q8_o4) VALUES (1, 'Antonio Maria Sanchez Berrocal', '05', 33, 'I started to work in IECISA, 10 years ago', '02', '01', '01', '02', '03', '01', true, true, true, NULL);

