--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2014-08-08 15:38:19

--
-- TOC entry 2291 (class 0 OID 62079)
-- Dependencies: 171
-- Data for Name: breadcrumb; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2312 (class 0 OID 62244)
-- Dependencies: 192
-- Data for Name: group_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2308 (class 0 OID 62209)
-- Dependencies: 188
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO groups (id, created_date, description, last_modified_date, name, createdby_id, lastmodifiedby_id) VALUES (3, '2014-08-08 15:34:44.337', 'Respondent group', '2014-08-08 15:34:44.337', 'Respondents', 1, 1);


--
-- TOC entry 2290 (class 0 OID 62071)
-- Dependencies: 170
-- Data for Name: invitation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (105, 'P', 'A', 'UCVZ45JZ3T', 102, NULL, 6);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (109, 'P', 'A', 'YAS5ICHRBE', 102, NULL, 4);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (113, 'P', 'A', '76HHP9M9FQ', 102, NULL, 10);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (117, 'P', 'A', 'R7CHFY0YHQ', 102, NULL, 8);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (120, 'A', 'A', '6O6PDUQLKN', 119, 12, NULL);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (214, 'P', 'A', 'UHHSCW4HML', 211, NULL, 6);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (218, 'P', 'A', 'MPFXCPEU8C', 211, NULL, 4);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (222, 'P', 'A', '75Q949SUA4', 211, NULL, 10);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (226, 'P', 'A', '7BSC9A9VMA', 211, NULL, 8);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (229, 'A', 'A', 'USFYBC5A4M', 228, 121, NULL);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (323, 'P', 'A', '9QJRLX3DHG', 320, NULL, 6);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (327, 'P', 'A', 'X63XLRKH5C', 320, NULL, 4);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (331, 'P', 'A', 'U2XVTSMARD', 320, NULL, 10);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (335, 'P', 'A', 'M95AFV77BT', 320, NULL, 8);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (338, 'A', 'A', 'HR3VP7TYTR', 337, 230, NULL);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (432, 'P', 'A', '49VQ7ZH8FG', 429, NULL, 6);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (436, 'P', 'A', 'JN9S9X7GPK', 429, NULL, 4);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (440, 'P', 'A', '5SL4U54TUR', 429, NULL, 10);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (444, 'P', 'A', 'YGSS3EVK78', 429, NULL, 8);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (447, 'A', 'A', 'YGUD4EC8CT', 446, 339, NULL);
INSERT INTO invitation (id, type, status, token, research_id, questionnairdefinition_id, respondent_id) VALUES (483, 'A', 'A', 'P0C6Q2NN3H', 482, 448, NULL);


--
-- TOC entry 2292 (class 0 OID 62084)
-- Dependencies: 172
-- Data for Name: label; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2293 (class 0 OID 62092)
-- Dependencies: 173
-- Data for Name: label_set; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2302 (class 0 OID 62161)
-- Dependencies: 182
-- Data for Name: label_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2294 (class 0 OID 62100)
-- Dependencies: 174
-- Data for Name: mail_message; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (106, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=F4AAQLT2B9">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (110, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=W5RKMWGV7P">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (114, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=Y99M45TD98">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (118, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=LH5UH9387X">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (215, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=UHHSCW4HML">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (219, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=MPFXCPEU8C">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (223, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=75Q949SUA4">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (227, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=7BSC9A9VMA">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (324, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=9QJRLX3DHG">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (328, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=X63XLRKH5C">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (332, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=U2XVTSMARD">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (336, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=M95AFV77BT">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'arya.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (433, 'Estimado Sr. Snow, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=49VQ7ZH8FG">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitación para participar en un cuestionario', 'jon.snow@nightswatch.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (437, 'Estimado Sr. Lannister, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="http://localhost:8080/questionaires-ui/token=JN9S9X7GPK">Click aqui</a> para empezar', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'tyrion.lannister@kingslanding.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (441, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=5SL4U54TUR">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'catelyn.stark@winterfell.net');
INSERT INTO mail_message (id, body, delivery_attempts, from_address, reply_to, sent_date, subject, to_address) VALUES (445, 'Dear Mr. Stark, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="http://localhost:8080/questionaires-ui/token=YGSS3EVK78">Click here</a> to take the questionnairDefinition', NULL, 'support@gazpacho.net', 'support@gazpacho.net', NULL, 'Invitation to participate in a questionnair', 'arya.stark@winterfell.net');


--
-- TOC entry 2295 (class 0 OID 62108)
-- Dependencies: 175
-- Data for Name: mail_message_template; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (100, '2014-08-08 15:34:45.174', 'support@gazpacho.net', 'EN', '2014-08-08 15:34:45.174', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'Invitation to participate in a questionnair', 1, 1, 12);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (209, '2014-08-08 15:34:47.239', 'support@gazpacho.net', 'EN', '2014-08-08 15:34:47.239', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'Invitation to participate in a questionnair', 1, 1, 121);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (318, '2014-08-08 15:34:48.421', 'support@gazpacho.net', 'EN', '2014-08-08 15:34:48.421', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'Invitation to participate in a questionnair', 1, 1, 230);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (427, '2014-08-08 15:34:49.284', 'support@gazpacho.net', 'EN', '2014-08-08 15:34:49.284', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'Invitation to participate in a questionnair', 1, 1, 339);
INSERT INTO mail_message_template (id, created_date, from_address, language, last_modified_date, reply_to, type, body, subject, createdby_id, lastmodifiedby_id, questionnairdefinition_id) VALUES (480, '2014-08-08 15:34:49.66', 'support@gazpacho.net', 'EN', '2014-08-08 15:34:49.66', 'support@gazpacho.net', 'INVITATION', 'Dear Mr. $lastname, <br> You have been invited to take this questionnair. <br>The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off.<a href="$link">Click here</a> to take the questionnairDefinition', 'Invitation to participate in a questionnair', 1, 1, 448);


--
-- TOC entry 2303 (class 0 OID 62169)
-- Dependencies: 183
-- Data for Name: mail_message_template_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (101, '2014-08-08 15:34:45.19', 'ES', '2014-08-08 15:34:45.19', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 100);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (210, '2014-08-08 15:34:47.247', 'ES', '2014-08-08 15:34:47.247', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 209);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (319, '2014-08-08 15:34:48.427', 'ES', '2014-08-08 15:34:48.427', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 318);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (428, '2014-08-08 15:34:49.289', 'ES', '2014-08-08 15:34:49.289', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 427);
INSERT INTO mail_message_template_translation (id, created_date, language, last_modified_date, body, subject, createdby_id, lastmodifiedby_id, mailmessagetemplate_id) VALUES (481, '2014-08-08 15:34:49.666', 'ES', '2014-08-08 15:34:49.666', 'Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario<a href="$link">Click aqui</a> para empezar', 'Invitación para participar en un cuestionario', 1, 1, 480);


--
-- TOC entry 2309 (class 0 OID 62217)
-- Dependencies: 189
-- Data for Name: permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (104, 103, 3, 'Q', 7);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (108, 107, 3, 'Q', 5);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (112, 111, 3, 'Q', 11);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (116, 115, 3, 'Q', 9);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (213, 212, 3, 'Q', 7);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (217, 216, 3, 'Q', 5);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (221, 220, 3, 'Q', 11);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (225, 224, 3, 'Q', 9);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (322, 321, 3, 'Q', 7);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (326, 325, 3, 'Q', 5);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (330, 329, 3, 'Q', 11);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (334, 333, 3, 'Q', 9);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (431, 430, 3, 'Q', 7);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (435, 434, 3, 'Q', 5);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (439, 438, 3, 'Q', 11);
INSERT INTO permission (id, entity_id, mask, scope, role_id) VALUES (443, 442, 3, 'Q', 9);


--
-- TOC entry 2296 (class 0 OID 62116)
-- Dependencies: 176
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (20, 'Q1', '2014-08-08 15:34:44.527', 'EN', '2014-08-08 15:34:44.527', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 14, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (22, 'Q2', '2014-08-08 15:34:44.558', 'EN', '2014-08-08 15:34:44.558', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 14, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (32, 'Q3', '2014-08-08 15:34:44.635', 'EN', '2014-08-08 15:34:44.635', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 14, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (34, 'Q4', '2014-08-08 15:34:44.672', 'EN', '2014-08-08 15:34:44.672', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 14, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (44, 'Q5', '2014-08-08 15:34:44.737', 'EN', '2014-08-08 15:34:44.737', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 16, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (46, 'Q6', '2014-08-08 15:34:44.763', 'EN', '2014-08-08 15:34:44.763', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 16, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (56, 'Q7', '2014-08-08 15:34:44.836', 'EN', '2014-08-08 15:34:44.836', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 16, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (66, 'Q8', '2014-08-08 15:34:44.906', 'EN', '2014-08-08 15:34:44.906', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 16, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (68, 'Q9', '2014-08-08 15:34:44.939', 'EN', '2014-08-08 15:34:44.939', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 18, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (78, 'Q10', '2014-08-08 15:34:44.992', 'EN', '2014-08-08 15:34:44.992', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 18, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (88, 'Q11', '2014-08-08 15:34:45.057', 'EN', '2014-08-08 15:34:45.057', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 18, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (90, 'Q12', '2014-08-08 15:34:45.094', 'EN', '2014-08-08 15:34:45.094', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 18, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (129, 'Q1', '2014-08-08 15:34:46.359', 'EN', '2014-08-08 15:34:46.359', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 123, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (131, 'Q2', '2014-08-08 15:34:46.38', 'EN', '2014-08-08 15:34:46.38', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 123, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (141, 'Q3', '2014-08-08 15:34:46.438', 'EN', '2014-08-08 15:34:46.438', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 123, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (143, 'Q4', '2014-08-08 15:34:46.473', 'EN', '2014-08-08 15:34:46.473', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 123, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (153, 'Q5', '2014-08-08 15:34:46.537', 'EN', '2014-08-08 15:34:46.537', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 125, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (155, 'Q6', '2014-08-08 15:34:46.555', 'EN', '2014-08-08 15:34:46.555', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 125, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (165, 'Q7', '2014-08-08 15:34:46.608', 'EN', '2014-08-08 15:34:46.608', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 125, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (175, 'Q8', '2014-08-08 15:34:46.657', 'EN', '2014-08-08 15:34:46.657', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 125, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (177, 'Q9', '2014-08-08 15:34:46.687', 'EN', '2014-08-08 15:34:46.687', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 127, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (187, 'Q10', '2014-08-08 15:34:46.732', 'EN', '2014-08-08 15:34:46.732', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 127, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (197, 'Q11', '2014-08-08 15:34:46.774', 'EN', '2014-08-08 15:34:46.774', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 127, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (199, 'Q12', '2014-08-08 15:34:46.798', 'EN', '2014-08-08 15:34:46.798', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 127, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (238, 'Q1', '2014-08-08 15:34:47.931', 'EN', '2014-08-08 15:34:47.931', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 232, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (240, 'Q2', '2014-08-08 15:34:47.946', 'EN', '2014-08-08 15:34:47.946', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 232, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (250, 'Q3', '2014-08-08 15:34:47.997', 'EN', '2014-08-08 15:34:47.997', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 232, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (252, 'Q4', '2014-08-08 15:34:48.021', 'EN', '2014-08-08 15:34:48.021', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 232, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (262, 'Q5', '2014-08-08 15:34:48.071', 'EN', '2014-08-08 15:34:48.071', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 234, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (264, 'Q6', '2014-08-08 15:34:48.087', 'EN', '2014-08-08 15:34:48.087', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 234, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (274, 'Q7', '2014-08-08 15:34:48.129', 'EN', '2014-08-08 15:34:48.129', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 234, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (284, 'Q8', '2014-08-08 15:34:48.174', 'EN', '2014-08-08 15:34:48.174', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 234, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (286, 'Q9', '2014-08-08 15:34:48.201', 'EN', '2014-08-08 15:34:48.201', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 236, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (296, 'Q10', '2014-08-08 15:34:48.244', 'EN', '2014-08-08 15:34:48.244', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 236, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (306, 'Q11', '2014-08-08 15:34:48.287', 'EN', '2014-08-08 15:34:48.287', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 236, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (308, 'Q12', '2014-08-08 15:34:48.311', 'EN', '2014-08-08 15:34:48.311', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 236, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (347, 'Q1', '2014-08-08 15:34:48.942', 'EN', '2014-08-08 15:34:48.942', false, true, 'S', NULL, 'What is the capital of Malta?', 1, 1, NULL, 341, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (349, 'Q2', '2014-08-08 15:34:48.954', 'EN', '2014-08-08 15:34:48.954', false, true, 'L', NULL, 'Which the country has as capital Copenhague?', 1, 1, NULL, 341, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (359, 'Q3', '2014-08-08 15:34:48.988', 'EN', '2014-08-08 15:34:48.988', false, true, 'N', NULL, 'How many European capitals were founded by Romans?', 1, 1, NULL, 341, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (361, 'Q4', '2014-08-08 15:34:49.006', 'EN', '2014-08-08 15:34:49.006', false, false, 'M', NULL, 'Which ones of these European capital are near by a river? Choose all that apply.', 1, 1, NULL, 341, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (371, 'Q5', '2014-08-08 15:34:49.043', 'EN', '2014-08-08 15:34:49.043', false, true, 'S', NULL, 'What does EU stand for??', 1, 1, NULL, 343, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (373, 'Q6', '2014-08-08 15:34:49.055', 'EN', '2014-08-08 15:34:49.055', false, true, 'L', NULL, 'Where was the treaty signed that created the European economic community - forerunner of the EU?', 1, 1, NULL, 343, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (383, 'Q7', '2014-08-08 15:34:49.088', 'EN', '2014-08-08 15:34:49.088', false, false, 'M', NULL, 'Which ones of these European countries belongs to Euro Zone? Choose all that apply.', 1, 1, NULL, 343, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (393, 'Q8', '2014-08-08 15:34:49.126', 'EN', '2014-08-08 15:34:49.126', false, true, 'N', NULL, 'How many finnish marc do you need to get an euro?', 1, 1, NULL, 343, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (395, 'Q9', '2014-08-08 15:34:49.144', 'EN', '2014-08-08 15:34:49.144', false, true, 'L', NULL, 'Where was Christopher columbus was born?', 1, 1, NULL, 345, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (405, 'Q10', '2014-08-08 15:34:49.177', 'EN', '2014-08-08 15:34:49.177', false, true, 'L', NULL, 'What was the large Eurpean Empire in century 16th ?', 1, 1, NULL, 345, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (415, 'Q11', '2014-08-08 15:34:49.213', 'EN', '2014-08-08 15:34:49.213', false, true, 'S', NULL, 'Which nationality has the first european that to get Congo?', 1, 1, NULL, 345, NULL, 2);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (417, 'Q12', '2014-08-08 15:34:49.234', 'EN', '2014-08-08 15:34:49.234', false, true, 'L', NULL, 'Which of the men caused more casualities in Europe?', 1, 1, NULL, 345, NULL, 3);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (450, 'Q1', '2014-08-08 15:34:49.545', 'EN', '2014-08-08 15:34:49.545', false, true, 'F', NULL, '<b>Food Quality</b>', 1, 1, NULL, 449, NULL, 0);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (457, 'Q1.1', '2014-08-08 15:34:49.549', 'EN', '2014-08-08 15:34:49.549', false, false, 'L', NULL, 'The food is served hot and fresh', 1, 1, 450, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (458, 'Q1.2', '2014-08-08 15:34:49.549', 'EN', '2014-08-08 15:34:49.549', false, false, 'L', NULL, 'The menu has a good variety of items', 1, 1, 450, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (459, 'Q1.3', '2014-08-08 15:34:49.549', 'EN', '2014-08-08 15:34:49.549', false, false, 'L', NULL, 'The quality of food is excellent', 1, 1, 450, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (460, 'Q1.4', '2014-08-08 15:34:49.55', 'EN', '2014-08-08 15:34:49.55', false, false, 'L', NULL, 'The food is tasty and flavorful', 1, 1, 450, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (461, 'Q2', '2014-08-08 15:34:49.581', 'EN', '2014-08-08 15:34:49.581', false, true, 'F', NULL, '<b>Resturant</b>', 1, 1, NULL, 449, NULL, 1);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (468, 'Q2.1', '2014-08-08 15:34:49.584', 'EN', '2014-08-08 15:34:49.584', false, false, 'L', NULL, 'My food order was correct and complete', 1, 1, 461, NULL, 0, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (469, 'Q2.2', '2014-08-08 15:34:49.584', 'EN', '2014-08-08 15:34:49.584', false, false, 'L', NULL, 'Employees are patient when taking my order', 1, 1, 461, NULL, 1, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (470, 'Q2.3', '2014-08-08 15:34:49.584', 'EN', '2014-08-08 15:34:49.584', false, false, 'L', NULL, 'I was served promptly', 1, 1, 461, NULL, 2, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (471, 'Q2.4', '2014-08-08 15:34:49.585', 'EN', '2014-08-08 15:34:49.585', false, false, 'L', NULL, 'Availability of sauces, utensils, napkins, etc. was good', 1, 1, 461, NULL, 3, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (472, 'Q2.5', '2014-08-08 15:34:49.585', 'EN', '2014-08-08 15:34:49.585', false, false, 'L', NULL, 'The menu board was easy to read', 1, 1, 461, NULL, 4, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (473, 'Q2.6', '2014-08-08 15:34:49.585', 'EN', '2014-08-08 15:34:49.585', false, false, 'L', NULL, 'The drive-thru sound system was cleara', 1, 1, 461, NULL, 5, NULL);
INSERT INTO question (id, code, created_date, language, last_modified_date, other_allowed, required, type, help, title, createdby_id, lastmodifiedby_id, parent_id, questiongroup_id, order_in_subquestions, order_in_questiongroup) VALUES (474, 'Q3', '2014-08-08 15:34:49.628', 'EN', '2014-08-08 15:34:49.628', false, true, 'L', NULL, 'Indicate total household income', 1, 1, NULL, 449, NULL, 2);


--
-- TOC entry 2297 (class 0 OID 62124)
-- Dependencies: 177
-- Data for Name: question_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (14, '2014-08-08 15:34:44.438', 'EN', '2014-08-08 15:34:44.438', false, NULL, 'European Capitals', 1, 1, 12, 0);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (16, '2014-08-08 15:34:44.469', 'EN', '2014-08-08 15:34:44.469', false, NULL, 'European Union', 1, 1, 12, 1);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (18, '2014-08-08 15:34:44.493', 'EN', '2014-08-08 15:34:44.493', false, NULL, 'European History', 1, 1, 12, 2);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (123, '2014-08-08 15:34:46.272', 'EN', '2014-08-08 15:34:46.272', false, NULL, 'European Capitals', 1, 1, 121, 0);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (125, '2014-08-08 15:34:46.31', 'EN', '2014-08-08 15:34:46.31', false, NULL, 'European Union', 1, 1, 121, 1);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (127, '2014-08-08 15:34:46.337', 'EN', '2014-08-08 15:34:46.337', false, NULL, 'European History', 1, 1, 121, 2);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (232, '2014-08-08 15:34:47.878', 'EN', '2014-08-08 15:34:47.878', false, NULL, 'European Capitals', 1, 1, 230, 0);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (234, '2014-08-08 15:34:47.895', 'EN', '2014-08-08 15:34:47.895', false, NULL, 'European Union', 1, 1, 230, 1);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (236, '2014-08-08 15:34:47.913', 'EN', '2014-08-08 15:34:47.913', false, NULL, 'European History', 1, 1, 230, 2);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (343, '2014-08-08 15:34:48.917', 'EN', '2014-08-08 15:34:48.917', false, NULL, 'European Union', 1, 1, 339, 1);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (345, '2014-08-08 15:34:48.93', 'EN', '2014-08-08 15:34:48.93', false, NULL, 'European History', 1, 1, 339, 2);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (341, '2014-08-08 15:34:48.904', 'EN', '2014-08-08 15:34:48.904', true, NULL, 'European Capitals', 1, 1, 339, 0);
INSERT INTO question_group (id, created_date, language, last_modified_date, randomization_enabled, description, title, createdby_id, lastmodifiedby_id, questionnairdefinition_id, order_in_questionnair) VALUES (449, '2014-08-08 15:34:49.531', 'EN', '2014-08-08 15:34:49.531', false, NULL, 'Fast Food QuestionnairDefinition - QuestionGroup', 1, 1, 448, 0);


--
-- TOC entry 2304 (class 0 OID 62177)
-- Dependencies: 184
-- Data for Name: question_group_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (15, 'ES', NULL, 'Capitales Europeas', 14);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (17, 'ES', NULL, 'Unión Europea', 16);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (19, 'ES', NULL, 'Sociedad', 18);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (124, 'ES', NULL, 'Capitales Europeas', 123);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (126, 'ES', NULL, 'Unión Europea', 125);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (128, 'ES', NULL, 'Sociedad', 127);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (233, 'ES', NULL, 'Capitales Europeas', 232);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (235, 'ES', NULL, 'Unión Europea', 234);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (237, 'ES', NULL, 'Sociedad', 236);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (342, 'ES', NULL, 'Capitales Europeas', 341);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (344, 'ES', NULL, 'Unión Europea', 343);
INSERT INTO question_group_translation (id, language, description, title, questiongroup_id) VALUES (346, 'ES', NULL, 'Sociedad', 345);


--
-- TOC entry 2300 (class 0 OID 62145)
-- Dependencies: 180
-- Data for Name: question_option; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (23, 'O1', '2014-08-08 15:34:44.56', 'EN', '2014-08-08 15:34:44.56', 'Norway', 1, 1, 22, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (24, 'O2', '2014-08-08 15:34:44.561', 'EN', '2014-08-08 15:34:44.561', 'Sweden', 1, 1, 22, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (25, 'O3', '2014-08-08 15:34:44.561', 'EN', '2014-08-08 15:34:44.561', 'Denmark', 1, 1, 22, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (26, 'O4', '2014-08-08 15:34:44.562', 'EN', '2014-08-08 15:34:44.562', 'Iceland', 1, 1, 22, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (35, 'O1', '2014-08-08 15:34:44.673', 'EN', '2014-08-08 15:34:44.673', 'Vatican City', 1, 1, 34, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (36, 'O2', '2014-08-08 15:34:44.673', 'EN', '2014-08-08 15:34:44.673', 'Roma', 1, 1, 34, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (37, 'O3', '2014-08-08 15:34:44.674', 'EN', '2014-08-08 15:34:44.674', 'Helsinki', 1, 1, 34, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (38, 'O4', '2014-08-08 15:34:44.675', 'EN', '2014-08-08 15:34:44.675', 'Viena', 1, 1, 34, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (47, 'O1', '2014-08-08 15:34:44.766', 'EN', '2014-08-08 15:34:44.766', 'Westphalia', 1, 1, 46, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (48, 'O2', '2014-08-08 15:34:44.768', 'EN', '2014-08-08 15:34:44.768', 'Rome', 1, 1, 46, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (49, 'O3', '2014-08-08 15:34:44.769', 'EN', '2014-08-08 15:34:44.769', 'Brussels', 1, 1, 46, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (50, 'O4', '2014-08-08 15:34:44.77', 'EN', '2014-08-08 15:34:44.77', 'Versailles', 1, 1, 46, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (57, 'O1', '2014-08-08 15:34:44.837', 'EN', '2014-08-08 15:34:44.837', 'Norway', 1, 1, 56, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (58, 'O2', '2014-08-08 15:34:44.838', 'EN', '2014-08-08 15:34:44.838', 'Poland', 1, 1, 56, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (59, 'O3', '2014-08-08 15:34:44.839', 'EN', '2014-08-08 15:34:44.839', 'Macedonia', 1, 1, 56, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (60, 'O4', '2014-08-08 15:34:44.84', 'EN', '2014-08-08 15:34:44.84', 'Chipre', 1, 1, 56, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (69, 'O1', '2014-08-08 15:34:44.94', 'EN', '2014-08-08 15:34:44.94', 'Barcelona', 1, 1, 68, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (70, 'O2', '2014-08-08 15:34:44.941', 'EN', '2014-08-08 15:34:44.941', 'Lisboa', 1, 1, 68, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (71, 'O3', '2014-08-08 15:34:44.942', 'EN', '2014-08-08 15:34:44.942', 'Genoa', 1, 1, 68, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (72, 'O4', '2014-08-08 15:34:44.943', 'EN', '2014-08-08 15:34:44.943', 'Roma', 1, 1, 68, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (79, 'O1', '2014-08-08 15:34:44.993', 'EN', '2014-08-08 15:34:44.993', 'Portuguese Empire', 1, 1, 78, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (80, 'O2', '2014-08-08 15:34:44.994', 'EN', '2014-08-08 15:34:44.994', 'British Empire', 1, 1, 78, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (81, 'O3', '2014-08-08 15:34:44.995', 'EN', '2014-08-08 15:34:44.995', 'Spanish Empire', 1, 1, 78, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (82, 'O4', '2014-08-08 15:34:44.996', 'EN', '2014-08-08 15:34:44.996', 'Dutch Empire', 1, 1, 78, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (91, 'O1', '2014-08-08 15:34:45.095', 'EN', '2014-08-08 15:34:45.095', 'Adolph Hitler', 1, 1, 90, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (92, 'O2', '2014-08-08 15:34:45.096', 'EN', '2014-08-08 15:34:45.096', 'Napoleon', 1, 1, 90, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (93, 'O3', '2014-08-08 15:34:45.097', 'EN', '2014-08-08 15:34:45.097', 'Philip 2th King of Spain', 1, 1, 90, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (94, 'O4', '2014-08-08 15:34:45.098', 'EN', '2014-08-08 15:34:45.098', 'Julius Caesar', 1, 1, 90, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (132, 'O1', '2014-08-08 15:34:46.381', 'EN', '2014-08-08 15:34:46.381', 'Norway', 1, 1, 131, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (133, 'O2', '2014-08-08 15:34:46.383', 'EN', '2014-08-08 15:34:46.383', 'Sweden', 1, 1, 131, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (134, 'O3', '2014-08-08 15:34:46.384', 'EN', '2014-08-08 15:34:46.384', 'Denmark', 1, 1, 131, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (135, 'O4', '2014-08-08 15:34:46.385', 'EN', '2014-08-08 15:34:46.385', 'Iceland', 1, 1, 131, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (144, 'O1', '2014-08-08 15:34:46.474', 'EN', '2014-08-08 15:34:46.474', 'Vatican City', 1, 1, 143, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (145, 'O2', '2014-08-08 15:34:46.475', 'EN', '2014-08-08 15:34:46.475', 'Roma', 1, 1, 143, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (146, 'O3', '2014-08-08 15:34:46.476', 'EN', '2014-08-08 15:34:46.476', 'Helsinki', 1, 1, 143, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (147, 'O4', '2014-08-08 15:34:46.477', 'EN', '2014-08-08 15:34:46.477', 'Viena', 1, 1, 143, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (156, 'O1', '2014-08-08 15:34:46.556', 'EN', '2014-08-08 15:34:46.556', 'Westphalia', 1, 1, 155, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (157, 'O2', '2014-08-08 15:34:46.557', 'EN', '2014-08-08 15:34:46.557', 'Rome', 1, 1, 155, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (158, 'O3', '2014-08-08 15:34:46.557', 'EN', '2014-08-08 15:34:46.557', 'Brussels', 1, 1, 155, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (159, 'O4', '2014-08-08 15:34:46.558', 'EN', '2014-08-08 15:34:46.558', 'Versailles', 1, 1, 155, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (166, 'O1', '2014-08-08 15:34:46.608', 'EN', '2014-08-08 15:34:46.608', 'Norway', 1, 1, 165, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (167, 'O2', '2014-08-08 15:34:46.609', 'EN', '2014-08-08 15:34:46.609', 'Poland', 1, 1, 165, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (168, 'O3', '2014-08-08 15:34:46.609', 'EN', '2014-08-08 15:34:46.609', 'Macedonia', 1, 1, 165, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (169, 'O4', '2014-08-08 15:34:46.61', 'EN', '2014-08-08 15:34:46.61', 'Chipre', 1, 1, 165, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (178, 'O1', '2014-08-08 15:34:46.687', 'EN', '2014-08-08 15:34:46.687', 'Barcelona', 1, 1, 177, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (179, 'O2', '2014-08-08 15:34:46.688', 'EN', '2014-08-08 15:34:46.688', 'Lisboa', 1, 1, 177, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (180, 'O3', '2014-08-08 15:34:46.689', 'EN', '2014-08-08 15:34:46.689', 'Genoa', 1, 1, 177, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (181, 'O4', '2014-08-08 15:34:46.689', 'EN', '2014-08-08 15:34:46.689', 'Roma', 1, 1, 177, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (188, 'O1', '2014-08-08 15:34:46.733', 'EN', '2014-08-08 15:34:46.733', 'Portuguese Empire', 1, 1, 187, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (189, 'O2', '2014-08-08 15:34:46.733', 'EN', '2014-08-08 15:34:46.733', 'British Empire', 1, 1, 187, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (190, 'O3', '2014-08-08 15:34:46.733', 'EN', '2014-08-08 15:34:46.733', 'Spanish Empire', 1, 1, 187, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (191, 'O4', '2014-08-08 15:34:46.734', 'EN', '2014-08-08 15:34:46.734', 'Dutch Empire', 1, 1, 187, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (200, 'O1', '2014-08-08 15:34:46.799', 'EN', '2014-08-08 15:34:46.799', 'Adolph Hitler', 1, 1, 199, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (201, 'O2', '2014-08-08 15:34:46.801', 'EN', '2014-08-08 15:34:46.801', 'Napoleon', 1, 1, 199, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (202, 'O3', '2014-08-08 15:34:46.802', 'EN', '2014-08-08 15:34:46.802', 'Philip 2th King of Spain', 1, 1, 199, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (203, 'O4', '2014-08-08 15:34:46.802', 'EN', '2014-08-08 15:34:46.802', 'Julius Caesar', 1, 1, 199, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (241, 'O1', '2014-08-08 15:34:47.947', 'EN', '2014-08-08 15:34:47.947', 'Norway', 1, 1, 240, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (242, 'O2', '2014-08-08 15:34:47.947', 'EN', '2014-08-08 15:34:47.947', 'Sweden', 1, 1, 240, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (243, 'O3', '2014-08-08 15:34:47.948', 'EN', '2014-08-08 15:34:47.948', 'Denmark', 1, 1, 240, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (244, 'O4', '2014-08-08 15:34:47.948', 'EN', '2014-08-08 15:34:47.948', 'Iceland', 1, 1, 240, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (253, 'O1', '2014-08-08 15:34:48.022', 'EN', '2014-08-08 15:34:48.022', 'Vatican City', 1, 1, 252, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (254, 'O2', '2014-08-08 15:34:48.022', 'EN', '2014-08-08 15:34:48.022', 'Roma', 1, 1, 252, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (255, 'O3', '2014-08-08 15:34:48.022', 'EN', '2014-08-08 15:34:48.022', 'Helsinki', 1, 1, 252, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (256, 'O4', '2014-08-08 15:34:48.023', 'EN', '2014-08-08 15:34:48.023', 'Viena', 1, 1, 252, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (265, 'O1', '2014-08-08 15:34:48.087', 'EN', '2014-08-08 15:34:48.087', 'Westphalia', 1, 1, 264, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (266, 'O2', '2014-08-08 15:34:48.088', 'EN', '2014-08-08 15:34:48.088', 'Rome', 1, 1, 264, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (267, 'O3', '2014-08-08 15:34:48.088', 'EN', '2014-08-08 15:34:48.088', 'Brussels', 1, 1, 264, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (268, 'O4', '2014-08-08 15:34:48.088', 'EN', '2014-08-08 15:34:48.088', 'Versailles', 1, 1, 264, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (275, 'O1', '2014-08-08 15:34:48.129', 'EN', '2014-08-08 15:34:48.129', 'Norway', 1, 1, 274, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (276, 'O2', '2014-08-08 15:34:48.13', 'EN', '2014-08-08 15:34:48.13', 'Poland', 1, 1, 274, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (277, 'O3', '2014-08-08 15:34:48.13', 'EN', '2014-08-08 15:34:48.13', 'Macedonia', 1, 1, 274, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (278, 'O4', '2014-08-08 15:34:48.13', 'EN', '2014-08-08 15:34:48.13', 'Chipre', 1, 1, 274, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (287, 'O1', '2014-08-08 15:34:48.202', 'EN', '2014-08-08 15:34:48.202', 'Barcelona', 1, 1, 286, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (288, 'O2', '2014-08-08 15:34:48.202', 'EN', '2014-08-08 15:34:48.202', 'Lisboa', 1, 1, 286, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (289, 'O3', '2014-08-08 15:34:48.203', 'EN', '2014-08-08 15:34:48.203', 'Genoa', 1, 1, 286, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (290, 'O4', '2014-08-08 15:34:48.204', 'EN', '2014-08-08 15:34:48.204', 'Roma', 1, 1, 286, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (297, 'O1', '2014-08-08 15:34:48.244', 'EN', '2014-08-08 15:34:48.244', 'Portuguese Empire', 1, 1, 296, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (298, 'O2', '2014-08-08 15:34:48.245', 'EN', '2014-08-08 15:34:48.245', 'British Empire', 1, 1, 296, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (299, 'O3', '2014-08-08 15:34:48.245', 'EN', '2014-08-08 15:34:48.245', 'Spanish Empire', 1, 1, 296, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (300, 'O4', '2014-08-08 15:34:48.246', 'EN', '2014-08-08 15:34:48.246', 'Dutch Empire', 1, 1, 296, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (309, 'O1', '2014-08-08 15:34:48.312', 'EN', '2014-08-08 15:34:48.312', 'Adolph Hitler', 1, 1, 308, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (310, 'O2', '2014-08-08 15:34:48.312', 'EN', '2014-08-08 15:34:48.312', 'Napoleon', 1, 1, 308, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (311, 'O3', '2014-08-08 15:34:48.312', 'EN', '2014-08-08 15:34:48.312', 'Philip 2th King of Spain', 1, 1, 308, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (312, 'O4', '2014-08-08 15:34:48.313', 'EN', '2014-08-08 15:34:48.313', 'Julius Caesar', 1, 1, 308, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (350, 'O1', '2014-08-08 15:34:48.954', 'EN', '2014-08-08 15:34:48.954', 'Norway', 1, 1, 349, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (351, 'O2', '2014-08-08 15:34:48.956', 'EN', '2014-08-08 15:34:48.956', 'Sweden', 1, 1, 349, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (352, 'O3', '2014-08-08 15:34:48.956', 'EN', '2014-08-08 15:34:48.956', 'Denmark', 1, 1, 349, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (353, 'O4', '2014-08-08 15:34:48.957', 'EN', '2014-08-08 15:34:48.957', 'Iceland', 1, 1, 349, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (362, 'O1', '2014-08-08 15:34:49.007', 'EN', '2014-08-08 15:34:49.007', 'Vatican City', 1, 1, 361, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (363, 'O2', '2014-08-08 15:34:49.007', 'EN', '2014-08-08 15:34:49.007', 'Roma', 1, 1, 361, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (364, 'O3', '2014-08-08 15:34:49.007', 'EN', '2014-08-08 15:34:49.007', 'Helsinki', 1, 1, 361, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (365, 'O4', '2014-08-08 15:34:49.008', 'EN', '2014-08-08 15:34:49.008', 'Viena', 1, 1, 361, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (374, 'O1', '2014-08-08 15:34:49.055', 'EN', '2014-08-08 15:34:49.055', 'Westphalia', 1, 1, 373, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (375, 'O2', '2014-08-08 15:34:49.055', 'EN', '2014-08-08 15:34:49.055', 'Rome', 1, 1, 373, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (376, 'O3', '2014-08-08 15:34:49.056', 'EN', '2014-08-08 15:34:49.056', 'Brussels', 1, 1, 373, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (377, 'O4', '2014-08-08 15:34:49.056', 'EN', '2014-08-08 15:34:49.056', 'Versailles', 1, 1, 373, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (384, 'O1', '2014-08-08 15:34:49.088', 'EN', '2014-08-08 15:34:49.088', 'Norway', 1, 1, 383, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (385, 'O2', '2014-08-08 15:34:49.088', 'EN', '2014-08-08 15:34:49.088', 'Poland', 1, 1, 383, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (386, 'O3', '2014-08-08 15:34:49.089', 'EN', '2014-08-08 15:34:49.089', 'Macedonia', 1, 1, 383, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (387, 'O4', '2014-08-08 15:34:49.089', 'EN', '2014-08-08 15:34:49.089', 'Chipre', 1, 1, 383, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (396, 'O1', '2014-08-08 15:34:49.144', 'EN', '2014-08-08 15:34:49.144', 'Barcelona', 1, 1, 395, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (397, 'O2', '2014-08-08 15:34:49.144', 'EN', '2014-08-08 15:34:49.144', 'Lisboa', 1, 1, 395, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (398, 'O3', '2014-08-08 15:34:49.145', 'EN', '2014-08-08 15:34:49.145', 'Genoa', 1, 1, 395, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (399, 'O4', '2014-08-08 15:34:49.145', 'EN', '2014-08-08 15:34:49.145', 'Roma', 1, 1, 395, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (406, 'O1', '2014-08-08 15:34:49.177', 'EN', '2014-08-08 15:34:49.177', 'Portuguese Empire', 1, 1, 405, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (407, 'O2', '2014-08-08 15:34:49.178', 'EN', '2014-08-08 15:34:49.178', 'British Empire', 1, 1, 405, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (408, 'O3', '2014-08-08 15:34:49.178', 'EN', '2014-08-08 15:34:49.178', 'Spanish Empire', 1, 1, 405, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (409, 'O4', '2014-08-08 15:34:49.178', 'EN', '2014-08-08 15:34:49.178', 'Dutch Empire', 1, 1, 405, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (418, 'O1', '2014-08-08 15:34:49.234', 'EN', '2014-08-08 15:34:49.234', 'Adolph Hitler', 1, 1, 417, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (419, 'O2', '2014-08-08 15:34:49.234', 'EN', '2014-08-08 15:34:49.234', 'Napoleon', 1, 1, 417, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (420, 'O3', '2014-08-08 15:34:49.235', 'EN', '2014-08-08 15:34:49.235', 'Philip 2th King of Spain', 1, 1, 417, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (421, 'O4', '2014-08-08 15:34:49.235', 'EN', '2014-08-08 15:34:49.235', 'Julius Caesar', 1, 1, 417, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (451, 'O1', '2014-08-08 15:34:49.547', 'EN', '2014-08-08 15:34:49.547', 'Agree strongly', 1, 1, 450, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (452, 'O2', '2014-08-08 15:34:49.547', 'EN', '2014-08-08 15:34:49.547', 'Agree somewhat', 1, 1, 450, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (453, 'O3', '2014-08-08 15:34:49.547', 'EN', '2014-08-08 15:34:49.547', 'Neither agree nor disagree', 1, 1, 450, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (454, 'O4', '2014-08-08 15:34:49.548', 'EN', '2014-08-08 15:34:49.548', 'Disagree somewhat', 1, 1, 450, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (455, 'O5', '2014-08-08 15:34:49.548', 'EN', '2014-08-08 15:34:49.548', 'Agree strongly', 1, 1, 450, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (456, 'O6', '2014-08-08 15:34:49.548', 'EN', '2014-08-08 15:34:49.548', 'Disagree strongly', 1, 1, 450, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (462, 'O1', '2014-08-08 15:34:49.582', 'EN', '2014-08-08 15:34:49.582', 'Agree strongly', 1, 1, 461, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (463, 'O2', '2014-08-08 15:34:49.582', 'EN', '2014-08-08 15:34:49.582', 'Agree somewhat', 1, 1, 461, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (464, 'O3', '2014-08-08 15:34:49.582', 'EN', '2014-08-08 15:34:49.582', 'Neither agree nor disagree', 1, 1, 461, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (465, 'O4', '2014-08-08 15:34:49.583', 'EN', '2014-08-08 15:34:49.583', 'Disagree somewhat', 1, 1, 461, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (466, 'O5', '2014-08-08 15:34:49.583', 'EN', '2014-08-08 15:34:49.583', 'Agree strongly', 1, 1, 461, 4);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (467, 'O6', '2014-08-08 15:34:49.583', 'EN', '2014-08-08 15:34:49.583', 'Disagree strongly', 1, 1, 461, 5);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (475, 'O1', '2014-08-08 15:34:49.629', 'EN', '2014-08-08 15:34:49.629', 'under 25,000€', 1, 1, 474, 0);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (476, 'O2', '2014-08-08 15:34:49.629', 'EN', '2014-08-08 15:34:49.629', '25,000 - 29,999€', 1, 1, 474, 1);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (477, 'O3', '2014-08-08 15:34:49.629', 'EN', '2014-08-08 15:34:49.629', '30,000 - 34,999€', 1, 1, 474, 2);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (478, 'O4', '2014-08-08 15:34:49.63', 'EN', '2014-08-08 15:34:49.63', '35,000 - 39,999€', 1, 1, 474, 3);
INSERT INTO question_option (id, code, created_date, language, last_modified_date, title, createdby_id, lastmodifiedby_id, question_id, order_in_question) VALUES (479, 'O5', '2014-08-08 15:34:49.63', 'EN', '2014-08-08 15:34:49.63', 'Over 85,000€', 1, 1, 474, 4);


--
-- TOC entry 2306 (class 0 OID 62193)
-- Dependencies: 186
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
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (52, 'ES', 'Westphalia', 47);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (53, 'ES', 'Roma', 48);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (54, 'ES', 'Bruselas', 49);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (55, 'ES', 'Islandia', 50);
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
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (137, 'ES', 'Noruega', 132);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (138, 'ES', 'Suecia', 133);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (139, 'ES', 'Dinamarca', 134);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (140, 'ES', 'Islandia', 135);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (149, 'ES', 'Ciudad del Vaticano', 144);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (150, 'ES', 'Roma', 145);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (151, 'ES', 'Helsinki', 146);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (152, 'ES', 'Viena', 147);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (161, 'ES', 'Westphalia', 156);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (162, 'ES', 'Roma', 157);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (163, 'ES', 'Bruselas', 158);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (164, 'ES', 'Islandia', 159);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (171, 'ES', 'Noruega', 166);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (172, 'ES', 'Polonia', 167);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (173, 'ES', 'Macedonia', 168);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (174, 'ES', 'Chipre', 169);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (183, 'ES', 'Barcelona', 178);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (184, 'ES', 'Lisboa', 179);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (185, 'ES', 'Genova', 180);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (186, 'ES', 'Roma', 181);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (193, 'ES', 'Imperio Portugues', 188);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (194, 'ES', 'Imperio Británico', 189);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (195, 'ES', 'Imperio Español', 190);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (196, 'ES', 'Imperio Holandés', 191);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (205, 'ES', 'Adolfo Hitler', 200);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (206, 'ES', 'Napoleón', 201);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (207, 'ES', 'Felipe II', 202);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (208, 'ES', 'Julio Cesar', 203);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (246, 'ES', 'Noruega', 241);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (247, 'ES', 'Suecia', 242);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (248, 'ES', 'Dinamarca', 243);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (249, 'ES', 'Islandia', 244);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (258, 'ES', 'Ciudad del Vaticano', 253);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (259, 'ES', 'Roma', 254);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (260, 'ES', 'Helsinki', 255);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (261, 'ES', 'Viena', 256);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (270, 'ES', 'Westphalia', 265);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (271, 'ES', 'Roma', 266);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (272, 'ES', 'Bruselas', 267);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (273, 'ES', 'Islandia', 268);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (280, 'ES', 'Noruega', 275);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (281, 'ES', 'Polonia', 276);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (282, 'ES', 'Macedonia', 277);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (283, 'ES', 'Chipre', 278);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (292, 'ES', 'Barcelona', 287);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (293, 'ES', 'Lisboa', 288);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (294, 'ES', 'Genova', 289);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (295, 'ES', 'Roma', 290);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (302, 'ES', 'Imperio Portugues', 297);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (303, 'ES', 'Imperio Británico', 298);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (304, 'ES', 'Imperio Español', 299);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (305, 'ES', 'Imperio Holandés', 300);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (314, 'ES', 'Adolfo Hitler', 309);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (315, 'ES', 'Napoleón', 310);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (316, 'ES', 'Felipe II', 311);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (317, 'ES', 'Julio Cesar', 312);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (355, 'ES', 'Noruega', 350);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (356, 'ES', 'Suecia', 351);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (357, 'ES', 'Dinamarca', 352);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (358, 'ES', 'Islandia', 353);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (367, 'ES', 'Ciudad del Vaticano', 362);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (368, 'ES', 'Roma', 363);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (369, 'ES', 'Helsinki', 364);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (370, 'ES', 'Viena', 365);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (379, 'ES', 'Westphalia', 374);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (380, 'ES', 'Roma', 375);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (381, 'ES', 'Bruselas', 376);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (382, 'ES', 'Islandia', 377);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (389, 'ES', 'Noruega', 384);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (390, 'ES', 'Polonia', 385);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (391, 'ES', 'Macedonia', 386);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (392, 'ES', 'Chipre', 387);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (401, 'ES', 'Barcelona', 396);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (402, 'ES', 'Lisboa', 397);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (403, 'ES', 'Genova', 398);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (404, 'ES', 'Roma', 399);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (411, 'ES', 'Imperio Portugues', 406);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (412, 'ES', 'Imperio Británico', 407);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (413, 'ES', 'Imperio Español', 408);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (414, 'ES', 'Imperio Holandés', 409);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (423, 'ES', 'Adolfo Hitler', 418);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (424, 'ES', 'Napoleón', 419);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (425, 'ES', 'Felipe II', 420);
INSERT INTO question_option_translation (id, language, title, questionoption_id) VALUES (426, 'ES', 'Julio Cesar', 421);


--
-- TOC entry 2307 (class 0 OID 62201)
-- Dependencies: 187
-- Data for Name: question_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO question_translation (id, language, help, title, question_id) VALUES (21, 'ES', NULL, '¿Cuál es la capital de Malta?', 20);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (27, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 22);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (33, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 32);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (39, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 34);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (45, 'ES', NULL, '¿Que significa UE?', 44);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (51, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 46);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (61, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 56);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (67, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 66);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (73, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 68);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (83, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 78);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (89, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 88);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (95, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 90);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (130, 'ES', NULL, '¿Cuál es la capital de Malta?', 129);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (136, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 131);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (142, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 141);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (148, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 143);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (154, 'ES', NULL, '¿Que significa UE?', 153);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (160, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 155);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (170, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 165);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (176, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 175);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (182, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 177);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (192, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 187);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (198, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 197);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (204, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 199);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (239, 'ES', NULL, '¿Cuál es la capital de Malta?', 238);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (245, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 240);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (251, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 250);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (257, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 252);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (263, 'ES', NULL, '¿Que significa UE?', 262);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (269, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 264);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (279, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 274);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (285, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 284);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (291, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 286);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (301, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 296);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (307, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 306);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (313, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 308);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (348, 'ES', NULL, '¿Cuál es la capital de Malta?', 347);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (354, 'ES', NULL, '¿Qué pais tiene como capital Copenague?', 349);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (360, 'ES', NULL, '¿Cuantas capitales europeas fueron fundadas por los romanos?', 359);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (366, 'ES', NULL, '¿Cuantas de estas capitales Europeas estan al pie de un río?', 361);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (372, 'ES', NULL, '¿Que significa UE?', 371);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (378, 'ES', NULL, '¿Dónde fue firmado el trado de Comunidad Económica Europea, precedesor de Unión Europea?', 373);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (388, 'ES', NULL, '¿Cuál de estos países europeos pertenecen a la zona euro?', 383);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (394, 'ES', NULL, '¿Cuantos marcos finlandeses necesitas para tener un euro?', 393);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (400, 'ES', NULL, '¿Dónde nació Cristobal Colón?', 395);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (410, 'ES', NULL, '¿Cuál fue el imperio más grande en el siglo XVI?', 405);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (416, 'ES', NULL, '¿Qué nacionalidad tenía el primer Europeo que llegó a Congo?', 415);
INSERT INTO question_translation (id, language, help, title, question_id) VALUES (422, 'ES', NULL, '¿Cual de estos hombres causó más bajas en Europa?', 417);


--
-- TOC entry 2298 (class 0 OID 62132)
-- Dependencies: 178
-- Data for Name: questionnair; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (103, 1, '2014-08-08 15:34:45.825', '2014-08-08 15:34:45.825', 'C', NULL, 1, 1, 12, 102, 6);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (107, 2, '2014-08-08 15:34:45.894', '2014-08-08 15:34:45.894', 'C', NULL, 1, 1, 12, 102, 4);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (111, 3, '2014-08-08 15:34:45.921', '2014-08-08 15:34:45.921', 'C', NULL, 1, 1, 12, 102, 10);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (115, 4, '2014-08-08 15:34:45.946', '2014-08-08 15:34:45.946', 'C', NULL, 1, 1, 12, 102, 8);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (212, 1, '2014-08-08 15:34:47.771', '2014-08-08 15:34:47.771', 'C', NULL, 1, 1, 121, 211, 6);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (216, 2, '2014-08-08 15:34:47.792', '2014-08-08 15:34:47.792', 'C', NULL, 1, 1, 121, 211, 4);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (220, 3, '2014-08-08 15:34:47.812', '2014-08-08 15:34:47.812', 'C', NULL, 1, 1, 121, 211, 10);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (224, 4, '2014-08-08 15:34:47.829', '2014-08-08 15:34:47.829', 'C', NULL, 1, 1, 121, 211, 8);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (321, 1, '2014-08-08 15:34:48.825', '2014-08-08 15:34:48.825', 'C', NULL, 1, 1, 230, 320, 6);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (325, 2, '2014-08-08 15:34:48.845', '2014-08-08 15:34:48.845', 'C', NULL, 1, 1, 230, 320, 4);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (329, 3, '2014-08-08 15:34:48.857', '2014-08-08 15:34:48.857', 'C', NULL, 1, 1, 230, 320, 10);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (333, 4, '2014-08-08 15:34:48.869', '2014-08-08 15:34:48.869', 'C', NULL, 1, 1, 230, 320, 8);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (430, 1, '2014-08-08 15:34:49.454', '2014-08-08 15:34:49.454', 'C', NULL, 1, 1, 339, 429, 6);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (434, 2, '2014-08-08 15:34:49.471', '2014-08-08 15:34:49.471', 'C', NULL, 1, 1, 339, 429, 4);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (438, 3, '2014-08-08 15:34:49.486', '2014-08-08 15:34:49.486', 'C', NULL, 1, 1, 339, 429, 10);
INSERT INTO questionnair (id, answers_id, created_date, last_modified_date, status, submit_date, createdby_id, lastmodifiedby_id, questionnairdefinition_id, research_id, respondent_id) VALUES (442, 4, '2014-08-08 15:34:49.5', '2014-08-08 15:34:49.5', 'C', NULL, 1, 1, 339, 429, 8);


--
-- TOC entry 2316 (class 0 OID 62534)
-- Dependencies: 196
-- Data for Name: questionnair_answers_12; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_12 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2317 (class 0 OID 62542)
-- Dependencies: 197
-- Data for Name: questionnair_answers_121; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_answers_121 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_121 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_121 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_121 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2318 (class 0 OID 62550)
-- Dependencies: 198
-- Data for Name: questionnair_answers_230; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_answers_230 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_230 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_230 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_230 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2319 (class 0 OID 62558)
-- Dependencies: 199
-- Data for Name: questionnair_answers_339; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_answers_339 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_339 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_339 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO questionnair_answers_339 (id, q1, q10, q11, q12, q2, q3, q4_o1, q4_o2, q4_o3, q4_o4, q5, q6, q7_o1, q7_o2, q7_o3, q7_o4, q8, q9) VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2320 (class 0 OID 62566)
-- Dependencies: 200
-- Data for Name: questionnair_answers_448; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2299 (class 0 OID 62137)
-- Dependencies: 179
-- Data for Name: questionnair_definition; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, progress_visible, question_group_info_visible, questions_per_page, randomization_strategy, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (12, '2014-08-08 15:34:44.396', 'EN', '2014-08-08 15:34:44.396', true, true, NULL, 'N', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnair.', 1, 1);
INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, progress_visible, question_group_info_visible, questions_per_page, randomization_strategy, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (121, '2014-08-08 15:34:46.254', 'EN', '2014-08-08 15:34:46.254', true, true, NULL, 'Q', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnair.', 1, 1);
INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, progress_visible, question_group_info_visible, questions_per_page, randomization_strategy, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (230, '2014-08-08 15:34:47.861', 'EN', '2014-08-08 15:34:47.861', true, true, NULL, 'G', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnair.', 1, 1);
INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, progress_visible, question_group_info_visible, questions_per_page, randomization_strategy, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (339, '2014-08-08 15:34:48.893', 'EN', '2014-08-08 15:34:48.893', true, true, NULL, 'N', 'C', true, 'How much do you know about Europe? Answer to this questions and let''s find out!', NULL, 'European general knowledge quiz', 'Thank you for taking the time to participate in this questionnair.', 1, 1);
INSERT INTO questionnair_definition (id, created_date, language, last_modified_date, progress_visible, question_group_info_visible, questions_per_page, randomization_strategy, status, welcome_visible, description, end_text, title, welcome_text, createdby_id, lastmodifiedby_id) VALUES (448, '2014-08-08 15:34:49.523', 'EN', '2014-08-08 15:34:49.523', true, true, NULL, 'N', 'C', true, 'We at BIG DEES take pride in providing you with the highest standards of QUALITY, SERVICE, CLEANLINESS and VALUE in the restaurant industry.', NULL, 'Food Quality QuestionnairDefinition', 'Your opinion is extremely important in evaluating our business. Thank you for taking a moment to questionOption the following questions:', 1, 1);


--
-- TOC entry 2305 (class 0 OID 62185)
-- Dependencies: 185
-- Data for Name: questionnair_definition_translation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO questionnair_definition_translation (id, language, description, end_text, title, welcome_text, questionnairdefinition_id) VALUES (13, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 12);
INSERT INTO questionnair_definition_translation (id, language, description, end_text, title, welcome_text, questionnairdefinition_id) VALUES (122, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 121);
INSERT INTO questionnair_definition_translation (id, language, description, end_text, title, welcome_text, questionnairdefinition_id) VALUES (231, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 230);
INSERT INTO questionnair_definition_translation (id, language, description, end_text, title, welcome_text, questionnairdefinition_id) VALUES (340, 'ES', '¿Cuánto sabes sobre Europa? Contesta a estas preguntas y averígualo!', NULL, 'Test de conocimiento general sobre Europa', 'Gracias por participar en este cuestionario', 339);


--
-- TOC entry 2301 (class 0 OID 62153)
-- Dependencies: 181
-- Data for Name: research; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (102, '2014-08-08 15:34:45.808', '2014-08-08 15:34:45.795', '2014-08-08 15:34:45.808', 'New QuizEuropean general knowledge quiz started', '2014-08-08 15:34:45.795', 'P', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (119, '2014-08-08 15:34:45.986', '2014-08-08 15:34:45.976', '2014-08-08 15:34:45.986', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-08-08 15:34:45.976', 'O', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (211, '2014-08-08 15:34:47.763', '2014-08-08 15:34:47.753', '2014-08-08 15:34:47.763', 'New QuizEuropean general knowledge quiz started', '2014-08-08 15:34:47.753', 'P', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (228, '2014-08-08 15:34:47.854', '2014-08-08 15:34:47.844', '2014-08-08 15:34:47.854', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-08-08 15:34:47.844', 'O', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (320, '2014-08-08 15:34:48.818', '2014-08-08 15:34:48.811', '2014-08-08 15:34:48.818', 'New QuizEuropean general knowledge quiz started', '2014-08-08 15:34:48.811', 'P', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (337, '2014-08-08 15:34:48.887', '2014-08-08 15:34:48.881', '2014-08-08 15:34:48.887', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-08-08 15:34:48.881', 'O', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (429, '2014-08-08 15:34:49.448', '2014-08-08 15:34:49.445', '2014-08-08 15:34:49.448', 'New QuizEuropean general knowledge quiz started', '2014-08-08 15:34:49.445', 'P', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (446, '2014-08-08 15:34:49.515', '2014-08-08 15:34:49.512', '2014-08-08 15:34:49.515', 'Anonymous New QuizEuropean general knowledge quiz started', '2014-08-08 15:34:49.512', 'O', 1, 1);
INSERT INTO research (id, created_date, expiration_date, last_modified_date, name, start_date, type, createdby_id, lastmodifiedby_id) VALUES (482, '2014-08-08 15:34:49.851', '2014-08-08 15:34:49.849', '2014-08-08 15:34:49.851', 'New customer satisfation survey Food Quality QuestionnairDefinition started', '2014-08-08 15:34:49.849', 'O', 1, 1);


--
-- TOC entry 2310 (class 0 OID 62222)
-- Dependencies: 190
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO role (id, description, name) VALUES (2, 'Specific role for support support ', 'User Role');
INSERT INTO role (id, description, name) VALUES (5, 'Specific role for Tyrion Lannister ', 'User Role');
INSERT INTO role (id, description, name) VALUES (7, 'Specific role for Jon Snow ', 'User Role');
INSERT INTO role (id, description, name) VALUES (9, 'Specific role for Arya Stark ', 'User Role');
INSERT INTO role (id, description, name) VALUES (11, 'Specific role for Catelyn Stark ', 'User Role');


--
-- TOC entry 2315 (class 0 OID 62529)
-- Dependencies: 195
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnair_answers_12_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnair_answers_121_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnair_answers_230_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnair_answers_339_seq', 50);
INSERT INTO sequence (seq_name, seq_count) VALUES ('SEQ_GEN', 500);
INSERT INTO sequence (seq_name, seq_count) VALUES ('questionnair_answers_448_seq', 0);


--
-- TOC entry 2313 (class 0 OID 62249)
-- Dependencies: 193
-- Data for Name: user_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_group (group_id, user_id) VALUES (3, 6);
INSERT INTO user_group (group_id, user_id) VALUES (3, 4);
INSERT INTO user_group (group_id, user_id) VALUES (3, 10);
INSERT INTO user_group (group_id, user_id) VALUES (3, 8);


--
-- TOC entry 2314 (class 0 OID 62254)
-- Dependencies: 194
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_role (role_id, user_id) VALUES (2, 1);
INSERT INTO user_role (role_id, user_id) VALUES (5, 4);
INSERT INTO user_role (role_id, user_id) VALUES (7, 6);
INSERT INTO user_role (role_id, user_id) VALUES (9, 8);
INSERT INTO user_role (role_id, user_id) VALUES (11, 10);


--
-- TOC entry 2311 (class 0 OID 62230)
-- Dependencies: 191
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, defaultrole_id, lastmodifiedby_id) VALUES (1, '3W5YJPF7RX9T9RV', NULL, '2014-08-08 15:34:44.227', 'support@gazpacho.net', NULL, 'support', '2014-08-08 15:34:44.227', NULL, NULL, 'TRDVK3Y7993GCG5ZS3B2D5DNPYBQYPCD', 'support', 'support', 1, 2, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, defaultrole_id, lastmodifiedby_id) VALUES (4, '25BN7J2U8JYF6AE', NULL, '2014-08-08 15:34:44.345', 'tyrion.lannister@kingslanding.net', 'M', 'Tyrion', '2014-08-08 15:34:44.345', NULL, NULL, 'A4PAZZBS9A678SFXJ8K7Z89MTGC6LPJC', 'Lannister', NULL, 1, 5, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, defaultrole_id, lastmodifiedby_id) VALUES (6, 'CZ3GXSVK8SSKLKD', NULL, '2014-08-08 15:34:44.356', 'jon.snow@nightswatch.net', 'M', 'Jon', '2014-08-08 15:34:44.356', NULL, 'ES', 'JV59DBFAAKK8367BM6P7JYPNB7HFS3KE', 'Snow', NULL, 1, 7, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, defaultrole_id, lastmodifiedby_id) VALUES (8, 'NG2UZMUSV76MGUE', NULL, '2014-08-08 15:34:44.368', 'arya.stark@winterfell.net', 'F', 'Arya', '2014-08-08 15:34:44.368', NULL, 'EN', 'JTHUVBAMCYM8JND92HNFU6396LV9PYTH', 'Stark', NULL, 1, 9, 1);
INSERT INTO users (id, api_key, attributes, created_date, email, gender, given_names, last_modified_date, password, preferred_language, secret, surname, username, createdby_id, defaultrole_id, lastmodifiedby_id) VALUES (10, 'KTYJZX5MWLM87ZA', NULL, '2014-08-08 15:34:44.379', 'catelyn.stark@winterfell.net', 'F', 'Catelyn', '2014-08-08 15:34:44.379', NULL, 'FI', '4G6C779E8N6B3W6TL6U93XVNG7Q4VGNY', 'Stark', NULL, 1, 11, 1);


-- Completed on 2014-08-08 15:38:20

--
-- PostgreSQL database dump complete
--

