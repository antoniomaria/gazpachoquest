
--
-- TOC entry 2059 (class 0 OID 107069)
-- Dependencies: 164 2078
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, created_date, email, first_name, last_modified_date, last_name, createdby_id, lastmodifiedby_id) VALUES (1, '2014-02-22 12:58:01.75', 'support.temporal@gazpacho.net', 'temporal.support', '2014-02-22 12:58:01.75', 'support', 1, 1);


--
-- TOC entry 2068 (class 0 OID 107140)
-- Dependencies: 173 2059 2059 2078
-- Data for Name: participant; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO participant (id, created_date, email, firstname, gender, last_modified_date, lastname, prefered_language, createdby_id, lastmodifiedby_id) VALUES (2, '2014-02-22 12:58:01.893', 'tyrion.lannister@kingslanding.net', 'Tyrion', 0, '2014-02-22 12:58:01.893', 'Lannister', 0, 1, 1);
INSERT INTO participant (id, created_date, email, firstname, gender, last_modified_date, lastname, prefered_language, createdby_id, lastmodifiedby_id) VALUES (3, '2014-02-22 12:58:01.924', 'jon.snow@nightswatch.net', 'Jon', 0, '2014-02-22 12:58:01.924', 'Snow', 1, 1, 1);
INSERT INTO participant (id, created_date, email, firstname, gender, last_modified_date, lastname, prefered_language, createdby_id, lastmodifiedby_id) VALUES (4, '2014-02-22 12:58:01.943', 'arya.stark@winterfell.net', 'Arya', 1, '2014-02-22 12:58:01.943', 'Stark', NULL, 1, 1);
INSERT INTO participant (id, created_date, email, firstname, gender, last_modified_date, lastname, prefered_language, createdby_id, lastmodifiedby_id) VALUES (5, '2014-02-22 12:58:01.976', 'catelyn.stark@winterfell.net', 'Catelyn', 1, '2014-02-22 12:58:01.976', 'Stark', 2, 1, 1);


--
-- TOC entry 2063 (class 0 OID 107103)
-- Dependencies: 168 2059 2059 2078
-- Data for Name: questionnair_definition; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, status, description, title, welcometext, createdby_id, lastmodifiedby_id) VALUES (6, '2014-02-22 12:58:02.042', 'EN', '2014-02-22 12:58:02.042', 'CONFIRMED', '<p>This is a <strong><em>sample questionnairDefinition</em></strong> designed for testing GazpachoSurvey.</p>', 'Sample QuestionnairDefinition', 'Thank you for taking the time to participate in this questionnairDefinition.', 1, 1);


--
-- TOC entry 2066 (class 0 OID 107124)
-- Dependencies: 171 2059 2063 2059 2078
-- Data for Name: question_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (8, '2014-02-22 12:58:02.239', 'EN', '2014-02-22 12:58:02.239', 'QuestionGroup 1', 1, 1, 6, 0);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (9, '2014-02-22 12:58:02.326', 'EN', '2014-02-22 12:58:02.326', 'QuestionGroup 2', 1, 1, 6, 1);
INSERT INTO question_group (id, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (10, '2014-02-22 12:58:02.377', 'EN', '2014-02-22 12:58:02.377', 'QuestionGroup 3', 1, 1, 6, 2);


--
-- TOC entry 2062 (class 0 OID 107095)
-- Dependencies: 167 2059 2066 2059 2078
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (12, 'Q1', '2014-02-22 12:58:02.516', 'EN', '2014-02-22 12:58:02.516', true, 'S', 'What is your name?', 1, 1, NULL, 8, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (13, 'Q2', '2014-02-22 12:58:02.654', 'EN', '2014-02-22 12:58:02.654', true, 'L', 'What is your age group?', 1, 1, NULL, 8, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (29, 'Q3', '2014-02-22 12:58:02.946', 'EN', '2014-02-22 12:58:02.946', true, 'N', 'And for our records, specifically how old are you?', 1, 1, NULL, 8, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (30, 'Q4', '2014-02-22 12:58:02.997', 'EN', '2014-02-22 12:58:02.997', true, 'T', 'Please tell us a little about yourself. What was your first job, and did you enjoy it?', 1, 1, NULL, 9, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (31, 'Q5', '2014-02-22 12:58:03.034', 'EN', '2014-02-22 12:58:03.034', true, 'L', 'Given your extraordinary age, how do you find using this questionnairDefinition tool?', 1, 1, NULL, 9, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (35, 'Q6', '2014-02-22 12:58:03.084', 'EN', '2014-02-22 12:58:03.084', true, 'L', 'Which of these ads makes you want to find out more?', 1, 1, NULL, 9, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (39, 'Q7', '2014-02-22 12:58:03.17', 'EN', '2014-02-22 12:58:03.17', true, 'F', 'Please have a good look at this ad, and then complete the questions below.<br /><img src=''http://www.aptigence.com.au/images/lawyer1.jpg'' border=''1''>', 1, 1, NULL, 10, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (46, 'Q7.1', '2014-02-22 12:58:03.177', 'EN', '2014-02-22 12:58:03.177', false, 'L', 'This ad suggests the lawyer is on my side, not his own', 1, 1, 39, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (47, 'Q7.2', '2014-02-22 12:58:03.178', 'EN', '2014-02-22 12:58:03.178', false, 'L', 'This ad suggests that the lawyer is interested in a life of frugal community service', 1, 1, 39, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (48, 'Q7.3', '2014-02-22 12:58:03.179', 'EN', '2014-02-22 12:58:03.179', false, 'L', 'This ad would be enough to get me to hire this lawyer', 1, 1, 39, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (49, 'Q7.4', '2014-02-22 12:58:03.18', 'EN', '2014-02-22 12:58:03.18', false, 'L', 'This ad gives me confidence in the lawyers experience', 1, 1, 39, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, required, type, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (50, 'Q8', '2014-02-22 12:58:03.269', 'EN', '2014-02-22 12:58:03.269', false, 'M', 'What flavors of ice cream do you like?. Choose all that apply.', 1, 1, NULL, 10, NULL, 1);


--
-- TOC entry 2069 (class 0 OID 107148)
-- Dependencies: 174 2059 2059 2078
-- Data for Name: study; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO study (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (57, '2014-02-22 12:58:03.822', '2014-02-22 12:58:03.788', '2014-02-22 12:58:03.822', 'New survey Sample QuestionnairDefinition started', '2014-02-22 12:58:03.788', 'BY_INVITATION', 1, 1);


--
-- TOC entry 2071 (class 0 OID 107164)
-- Dependencies: 176 2068 2059 2063 2069 2059 2078
-- Data for Name: questionnair; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (61, NULL, '2014-02-22 12:58:03.889', '2014-02-22 12:58:03.889', 'CONFIRMED', NULL, 1, 1, 5, 6, 57);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (58, NULL, '2014-02-22 12:58:03.847', '2014-02-22 12:58:03.847', 'CONFIRMED', NULL, 1, 1, 2, 6, 57);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (64, NULL, '2014-02-22 12:58:03.932', '2014-02-22 12:58:03.932', 'CONFIRMED', NULL, 1, 1, 4, 6, 57);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, participant_id, questionnairdefinition_id, study_id) VALUES (67, NULL, '2014-02-22 12:58:03.956', '2014-02-22 12:58:03.956', 'CONFIRMED', NULL, 1, 1, 3, 6, 57);


--
-- TOC entry 2064 (class 0 OID 107111)
-- Dependencies: 169 2059 2059 2062 2071 2066 2078
-- Data for Name: browsed_element; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2058 (class 0 OID 107061)
-- Dependencies: 163 2069 2068 2078
-- Data for Name: invitation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (59, 'P', 'ACTIVE', 'DRZ0EASDR6', 57, 2);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (62, 'P', 'ACTIVE', 'FRPMU3AWYO', 57, 5);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (65, 'P', 'ACTIVE', 'T16QO2WA9H', 57, 4);
INSERT INTO invitation (id, type, status, token, study_id, participant_id) VALUES (68, 'P', 'ACTIVE', 'CSX6MD41OB', 57, 3);


--
-- TOC entry 2070 (class 0 OID 107156)
-- Dependencies: 175 2078
-- Data for Name: label_set; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO label_set (id, language, name) VALUES (11, 'EN', 'Feelings');


--
-- TOC entry 2061 (class 0 OID 107087)
-- Dependencies: 166 2059 2070 2059 2078
-- Data for Name: label; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2077 (class 0 OID 107209)
-- Dependencies: 182 2061 2078
-- Data for Name: label_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2060 (class 0 OID 107079)
-- Dependencies: 165 2078
-- Data for Name: mail_message; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (60, 'Dear Mr. Lannister, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=DRZ0EASDR6">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (63, 'Dear Mr. Stark, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=FRPMU3AWYO">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (66, 'Estimado Sr. Stark, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=T16QO2WA9H">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'PersonalInvitation to participate in questionnairDefinition', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (69, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=CSX6MD41OB">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en una encuesta', 'jon.snow@nightswatch.net');


--
-- TOC entry 2067 (class 0 OID 107132)
-- Dependencies: 172 2059 2059 2063 2078
-- Data for Name: mail_message_template; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (55, '2014-02-22 12:58:03.379', 'support@gazpacho.net', 'EN', '2014-02-22 12:58:03.379', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnairDefinition. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'PersonalInvitation to participate in questionnairDefinition', 1, 1, 6);


--
-- TOC entry 2073 (class 0 OID 107177)
-- Dependencies: 178 2059 2059 2067 2078
-- Data for Name: mail_message_template_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (56, '2014-02-22 12:58:03.428', 'ES', '2014-02-22 12:58:03.428', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta encuesta <br>Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en una encuesta', 1, 1, 55);


--
-- TOC entry 2076 (class 0 OID 107201)
-- Dependencies: 181 2066 2078
-- Data for Name: question_group_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2065 (class 0 OID 107116)
-- Dependencies: 170 2059 2062 2059 2078
-- Data for Name: question_option; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (14, 'O1', '2014-02-22 12:58:02.671', 'EN', '2014-02-22 12:58:02.671', '0-14 years', 1, 1, 13, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (15, 'O2', '2014-02-22 12:58:02.673', 'EN', '2014-02-22 12:58:02.673', '15-19 years', 1, 1, 13, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (16, 'O3', '2014-02-22 12:58:02.676', 'EN', '2014-02-22 12:58:02.676', '20-24 years', 1, 1, 13, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (17, 'O4', '2014-02-22 12:58:02.678', 'EN', '2014-02-22 12:58:02.678', '25-29 years', 1, 1, 13, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (18, 'O5', '2014-02-22 12:58:02.68', 'EN', '2014-02-22 12:58:02.68', '30-34 years', 1, 1, 13, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (19, 'O6', '2014-02-22 12:58:02.681', 'EN', '2014-02-22 12:58:02.681', '35-39 years', 1, 1, 13, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (20, 'O7', '2014-02-22 12:58:02.683', 'EN', '2014-02-22 12:58:02.683', '40-44 years', 1, 1, 13, 6);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (21, 'O8', '2014-02-22 12:58:02.684', 'EN', '2014-02-22 12:58:02.684', '45-49 years', 1, 1, 13, 7);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (22, 'O9', '2014-02-22 12:58:02.686', 'EN', '2014-02-22 12:58:02.686', '50-54 years', 1, 1, 13, 8);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (23, 'O10', '2014-02-22 12:58:02.687', 'EN', '2014-02-22 12:58:02.687', '55-59 years', 1, 1, 13, 9);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (24, 'O11', '2014-02-22 12:58:02.689', 'EN', '2014-02-22 12:58:02.689', '60-64 years', 1, 1, 13, 10);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (25, 'O12', '2014-02-22 12:58:02.69', 'EN', '2014-02-22 12:58:02.69', '65-69 years', 1, 1, 13, 11);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (26, 'O13', '2014-02-22 12:58:02.692', 'EN', '2014-02-22 12:58:02.692', '70-74 years', 1, 1, 13, 12);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (27, 'O14', '2014-02-22 12:58:02.693', 'EN', '2014-02-22 12:58:02.693', '75-79 years', 1, 1, 13, 13);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (28, 'O15', '2014-02-22 12:58:02.695', 'EN', '2014-02-22 12:58:02.695', '80 and over', 1, 1, 13, 14);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (32, 'O1', '2014-02-22 12:58:03.034', 'EN', '2014-02-22 12:58:03.034', 'Very difficult to read, my eyesight is dim', 1, 1, 31, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (33, 'O2', '2014-02-22 12:58:03.035', 'EN', '2014-02-22 12:58:03.035', 'Easy, my carer is doing it all for me', 1, 1, 31, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (34, 'O3', '2014-02-22 12:58:03.036', 'EN', '2014-02-22 12:58:03.036', 'How <b><i>dare</i></b> you insult me like that! I''m YOUNG', 1, 1, 31, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (36, 'O1', '2014-02-22 12:58:03.086', 'EN', '2014-02-22 12:58:03.086', 'Ad one', 1, 1, 35, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (37, 'O2', '2014-02-22 12:58:03.087', 'EN', '2014-02-22 12:58:03.087', 'Ad two', 1, 1, 35, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (38, 'O3', '2014-02-22 12:58:03.088', 'EN', '2014-02-22 12:58:03.088', 'Ad three', 1, 1, 35, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (40, 'O1', '2014-02-22 12:58:03.172', 'EN', '2014-02-22 12:58:03.172', 'Agree strongly', 1, 1, 39, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (41, 'O2', '2014-02-22 12:58:03.173', 'EN', '2014-02-22 12:58:03.173', 'Agree somewhat', 1, 1, 39, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (42, 'O3', '2014-02-22 12:58:03.173', 'EN', '2014-02-22 12:58:03.173', 'Neither agree nor disagree', 1, 1, 39, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (43, 'O4', '2014-02-22 12:58:03.174', 'EN', '2014-02-22 12:58:03.174', 'Disagree somewhat', 1, 1, 39, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (44, 'O5', '2014-02-22 12:58:03.175', 'EN', '2014-02-22 12:58:03.175', 'Agree strongly', 1, 1, 39, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (45, 'O6', '2014-02-22 12:58:03.176', 'EN', '2014-02-22 12:58:03.176', 'Disagree strongly', 1, 1, 39, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (51, 'O1', '2014-02-22 12:58:03.273', 'EN', '2014-02-22 12:58:03.273', 'Vanilla', 1, 1, 50, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (52, 'O2', '2014-02-22 12:58:03.275', 'EN', '2014-02-22 12:58:03.275', 'Chocolate', 1, 1, 50, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (53, 'O3', '2014-02-22 12:58:03.276', 'EN', '2014-02-22 12:58:03.276', 'Strawberry', 1, 1, 50, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (54, 'O4', '2014-02-22 12:58:03.277', 'EN', '2014-02-22 12:58:03.277', 'Pistachio', 1, 1, 50, 3);


--
-- TOC entry 2075 (class 0 OID 107193)
-- Dependencies: 180 2065 2078
-- Data for Name: question_option_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2072 (class 0 OID 107169)
-- Dependencies: 177 2062 2078
-- Data for Name: question_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2074 (class 0 OID 107185)
-- Dependencies: 179 2063 2078
-- Data for Name: questionnair_definition_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition_translation (id, language, description, title, welcometext, questionnairdefinition_id) VALUES (7, 'ES', '<p>Esto es una encuesta de ejemplo diseñada para GazpachoSurvey</p>', 'Ejemplo de encuesta', 'Gracias por participar en esta encuesta', 6);


--
-- TOC entry 2057 (class 0 OID 107056)
-- Dependencies: 162 2078
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sequence (seq_name, seq_count) VALUES ('SEQ_GEN', 100);
-- INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnair_answers_6_seq', 0);


-- Completed on 2014-02-22 13:13:37 EET

--
-- PostgreSQL database dump complete
--
