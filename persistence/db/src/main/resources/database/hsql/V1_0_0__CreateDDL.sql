CREATE TABLE invitation(id INTEGER NOT NULL, type VARCHAR(20), status VARCHAR(255) NOT NULL, token VARCHAR(255) NOT NULL, research_id integer, respondent_id integer, PRIMARY KEY (id));
CREATE TABLE browsed_element (id INTEGER NOT NULL, type VARCHAR(31), created_date timestamp, last BOOLEAN, last_modified_date timestamp, CREATEDBY_ID INTEGER, LASTMODIFIEDBY_ID INTEGER, QUESTIONNAIR_ID INTEGER, QUESTION_ID INTEGER, QUESTIONGROUP_ID INTEGER, PRIMARY KEY (id));
CREATE TABLE label (id INTEGER NOT NULL, created_date timestamp, language VARCHAR(255) NOT NULL, last_modified_date timestamp, TITLE VARCHAR(255) NOT NULL, CREATEDBY_ID INTEGER, LABELSET_ID INTEGER, LASTMODIFIEDBY_ID INTEGER, sort_order INTEGER, PRIMARY KEY (id));
CREATE TABLE label_set (id INTEGER NOT NULL, language VARCHAR(255) NOT NULL, name VARCHAR(255), PRIMARY KEY (id));
CREATE TABLE mail_message (id INTEGER NOT NULL, body VARCHAR(1000), delivery_attempts INTEGER, from_address VARCHAR(255), reply_to VARCHAR(255), sent_date timestamp, subject VARCHAR(255), to_address VARCHAR(255), PRIMARY KEY (id));
CREATE TABLE mail_message_template (id INTEGER NOT NULL, created_date timestamp, from_address VARCHAR(255), language VARCHAR(255) NOT NULL, last_modified_date timestamp, reply_to VARCHAR(255), type VARCHAR(255) NOT NULL, BODY VARCHAR(1000) NOT NULL, SUBJECT VARCHAR(255) NOT NULL, CREATEDBY_ID INTEGER, LASTMODIFIEDBY_ID INTEGER, QUESTIONNAIRDEFINITION_ID INTEGER, PRIMARY KEY (id));
CREATE TABLE question (id INTEGER NOT NULL, code VARCHAR(255) NOT NULL, created_date timestamp, language VARCHAR(255) NOT NULL, last_modified_date timestamp, required BOOLEAN, type VARCHAR(255) NOT NULL, TITLE VARCHAR(255) NOT NULL, CREATEDBY_ID INTEGER, LASTMODIFIEDBY_ID INTEGER, PARENT_ID INTEGER, QUESTIONGROUP_ID INTEGER, order_in_subquestions INTEGER, order_in_questiongroup INTEGER, PRIMARY KEY (id));
CREATE TABLE question_group (id INTEGER NOT NULL, created_date timestamp, language VARCHAR(255) NOT NULL, last_modified_date timestamp, TITLE VARCHAR(255) NOT NULL, CREATEDBY_ID INTEGER, LASTMODIFIEDBY_ID INTEGER, QUESTIONNAIRDEFINITION_ID INTEGER, order_in_questionnair INTEGER, PRIMARY KEY (id));
CREATE TABLE questionnair (id INTEGER NOT NULL, answers_id INTEGER, created_date timestamp, last_modified_date timestamp, status VARCHAR(255) NOT NULL, submit_date timestamp, CREATEDBY_ID INTEGER, LASTMODIFIEDBY_ID INTEGER, QUESTIONNAIRDEFINITION_ID INTEGER, RESEARCH_ID INTEGER, RESPONDENT_ID INTEGER, PRIMARY KEY (id));
CREATE TABLE questionnair_definition (id INTEGER NOT NULL, created_date timestamp, language VARCHAR(255) NOT NULL, last_modified_date timestamp, status VARCHAR(255), DESCRIPTION VARCHAR(1000) NOT NULL, TITLE VARCHAR(255) NOT NULL, WELCOMETEXT VARCHAR(1000), CREATEDBY_ID INTEGER, LASTMODIFIEDBY_ID INTEGER, PRIMARY KEY (id));
CREATE TABLE question_option (id INTEGER NOT NULL, code VARCHAR(255) NOT NULL, created_date timestamp, language VARCHAR(255) NOT NULL, last_modified_date timestamp, TITLE VARCHAR(255) NOT NULL, CREATEDBY_ID INTEGER, LASTMODIFIEDBY_ID INTEGER, QUESTION_ID INTEGER, order_in_question INTEGER, PRIMARY KEY (id));
CREATE TABLE research (id INTEGER NOT NULL, created_date timestamp, expiration_date timestamp, last_modified_date timestamp, name VARCHAR(255), start_date timestamp, type VARCHAR(255), CREATEDBY_ID INTEGER, LASTMODIFIEDBY_ID INTEGER, PRIMARY KEY (id));
CREATE TABLE users (id INTEGER NOT NULL, password VARCHAR(255), defaultrole_id INTEGER, api_key VARCHAR(255) NOT NULL UNIQUE, secret VARCHAR(255) NOT NULL, created_date timestamp, email VARCHAR(255) NOT NULL, gender VARCHAR(255), given_names VARCHAR(255) NOT NULL, last_modified_date timestamp, prefered_language VARCHAR(255), surname VARCHAR(255) NOT NULL, username VARCHAR(255), CREATEDBY_ID INTEGER, LASTMODIFIEDBY_ID INTEGER, PRIMARY KEY (id));
CREATE TABLE role (id INTEGER NOT NULL, description VARCHAR(255), name VARCHAR(255), PRIMARY KEY (id));
CREATE TABLE permission (id INTEGER NOT NULL, entity_id INTEGER, mask INTEGER, scope VARCHAR(255), ROLE_ID INTEGER, PRIMARY KEY (id));
CREATE TABLE groups (id INTEGER NOT NULL, created_date timestamp, description VARCHAR(255), last_modified_date timestamp, name VARCHAR(255) NOT NULL, CREATEDBY_ID INTEGER, LASTMODIFIEDBY_ID INTEGER, PRIMARY KEY (id));
CREATE TABLE label_translation (id INTEGER NOT NULL, language VARCHAR(255) NOT NULL, TITLE VARCHAR(255) NOT NULL, LABEL_ID INTEGER, PRIMARY KEY (id));
CREATE TABLE mail_message_template_translation (id INTEGER NOT NULL, created_date timestamp, language VARCHAR(255) NOT NULL, last_modified_date timestamp, BODY VARCHAR(1000) NOT NULL, SUBJECT VARCHAR(255) NOT NULL, CREATEDBY_ID INTEGER, LASTMODIFIEDBY_ID INTEGER, MAILMESSAGETEMPLATE_ID INTEGER, PRIMARY KEY (id));
CREATE TABLE question_group_translation (id INTEGER NOT NULL, language VARCHAR(255) NOT NULL, TITLE VARCHAR(255) NOT NULL, QUESTIONGROUP_ID INTEGER, questionnairdefinition_id integer, PRIMARY KEY (id));
CREATE TABLE questionnair_definition_translation (id INTEGER NOT NULL, language VARCHAR(255) NOT NULL, DESCRIPTION VARCHAR(1000) NOT NULL, TITLE VARCHAR(255) NOT NULL, WELCOMETEXT VARCHAR(1000), QUESTIONNAIRDEFINITION_ID INTEGER, PRIMARY KEY (id));
CREATE TABLE question_option_translation (id INTEGER NOT NULL, language VARCHAR(255) NOT NULL, TITLE VARCHAR(255) NOT NULL, QUESTIONOPTION_ID INTEGER, PRIMARY KEY (id));
CREATE TABLE question_translation (id INTEGER NOT NULL, language VARCHAR(255) NOT NULL, TITLE VARCHAR(255) NOT NULL, QUESTION_ID INTEGER, PRIMARY KEY (id));
CREATE TABLE user_group (user_id INTEGER NOT NULL, group_id INTEGER NOT NULL, PRIMARY KEY (user_id, group_id));
CREATE TABLE user_role (user_id INTEGER NOT NULL, role_id INTEGER NOT NULL, PRIMARY KEY (user_id, role_id));
CREATE TABLE group_role (role_id INTEGER NOT NULL, group_id INTEGER NOT NULL, PRIMARY KEY (role_id, group_id));


ALTER TABLE invitation ADD CONSTRAINT FK_invitation_RESPONDENT_ID FOREIGN KEY (RESPONDENT_ID) REFERENCES users (id);
ALTER TABLE invitation ADD CONSTRAINT FK_invitation_QUESTIONNAIRDEFINITION_ID FOREIGN KEY (questionnairdefinition_id) REFERENCES questionnair_definition (id);

ALTER TABLE browsed_element ADD CONSTRAINT FK_browsed_element_LASTMODIFIEDBY_ID FOREIGN KEY (LASTMODIFIEDBY_ID) REFERENCES users (id);
ALTER TABLE browsed_element ADD CONSTRAINT FK_browsed_element_CREATEDBY_ID FOREIGN KEY (CREATEDBY_ID) REFERENCES users (id);
ALTER TABLE browsed_element ADD CONSTRAINT FK_browsed_element_QUESTION_ID FOREIGN KEY (QUESTION_ID) REFERENCES question (id);
ALTER TABLE browsed_element ADD CONSTRAINT FK_browsed_element_QUESTIONGROUP_ID FOREIGN KEY (QUESTIONGROUP_ID) REFERENCES question_group (id);
ALTER TABLE browsed_element ADD CONSTRAINT FK_browsed_element_QUESTIONNAIR_ID FOREIGN KEY (QUESTIONNAIR_ID) REFERENCES questionnair (id);
ALTER TABLE label ADD CONSTRAINT FK_label_LASTMODIFIEDBY_ID FOREIGN KEY (LASTMODIFIEDBY_ID) REFERENCES users (id);
ALTER TABLE label ADD CONSTRAINT FK_label_LABELSET_ID FOREIGN KEY (LABELSET_ID) REFERENCES label_set (id);
ALTER TABLE label ADD CONSTRAINT FK_label_CREATEDBY_ID FOREIGN KEY (CREATEDBY_ID) REFERENCES users (id);
ALTER TABLE mail_message_template ADD CONSTRAINT FK_mail_message_template_LASTMODIFIEDBY_ID FOREIGN KEY (LASTMODIFIEDBY_ID) REFERENCES users (id);
ALTER TABLE mail_message_template ADD CONSTRAINT FK_mail_message_template_CREATEDBY_ID FOREIGN KEY (CREATEDBY_ID) REFERENCES users (id);
ALTER TABLE mail_message_template ADD CONSTRAINT FK_mail_message_template_QUESTIONNAIRDEFINITION_ID FOREIGN KEY (QUESTIONNAIRDEFINITION_ID) REFERENCES questionnair_definition (id);
ALTER TABLE question ADD CONSTRAINT FK_question_PARENT_ID FOREIGN KEY (PARENT_ID) REFERENCES question (id);
ALTER TABLE question ADD CONSTRAINT FK_question_LASTMODIFIEDBY_ID FOREIGN KEY (LASTMODIFIEDBY_ID) REFERENCES users (id);
ALTER TABLE question ADD CONSTRAINT FK_question_QUESTIONGROUP_ID FOREIGN KEY (QUESTIONGROUP_ID) REFERENCES question_group (id);
ALTER TABLE question ADD CONSTRAINT FK_question_CREATEDBY_ID FOREIGN KEY (CREATEDBY_ID) REFERENCES users (id);
ALTER TABLE question_group ADD CONSTRAINT FK_question_group_LASTMODIFIEDBY_ID FOREIGN KEY (LASTMODIFIEDBY_ID) REFERENCES users (id);
ALTER TABLE question_group ADD CONSTRAINT FK_question_group_QUESTIONNAIRDEFINITION_ID FOREIGN KEY (QUESTIONNAIRDEFINITION_ID) REFERENCES questionnair_definition (id);
ALTER TABLE question_group ADD CONSTRAINT FK_question_group_CREATEDBY_ID FOREIGN KEY (CREATEDBY_ID) REFERENCES users (id);
ALTER TABLE questionnair ADD CONSTRAINT FK_questionnair_RESPONDENT_ID FOREIGN KEY (RESPONDENT_ID) REFERENCES users (id);
ALTER TABLE questionnair ADD CONSTRAINT FK_questionnair_LASTMODIFIEDBY_ID FOREIGN KEY (LASTMODIFIEDBY_ID) REFERENCES users (id);
ALTER TABLE questionnair ADD CONSTRAINT FK_questionnair_RESEARCH_ID FOREIGN KEY (RESEARCH_ID) REFERENCES research (id);
ALTER TABLE questionnair ADD CONSTRAINT FK_questionnair_QUESTIONNAIRDEFINITION_ID FOREIGN KEY (QUESTIONNAIRDEFINITION_ID) REFERENCES questionnair_definition (id);
ALTER TABLE questionnair ADD CONSTRAINT FK_questionnair_CREATEDBY_ID FOREIGN KEY (CREATEDBY_ID) REFERENCES users (id);
ALTER TABLE questionnair_definition ADD CONSTRAINT FK_questionnair_definition_LASTMODIFIEDBY_ID FOREIGN KEY (LASTMODIFIEDBY_ID) REFERENCES users (id);
ALTER TABLE questionnair_definition ADD CONSTRAINT FK_questionnair_definition_CREATEDBY_ID FOREIGN KEY (CREATEDBY_ID) REFERENCES users (id);
ALTER TABLE question_option ADD CONSTRAINT FK_question_option_CREATEDBY_ID FOREIGN KEY (CREATEDBY_ID) REFERENCES users (id);
ALTER TABLE question_option ADD CONSTRAINT FK_question_option_QUESTION_ID FOREIGN KEY (QUESTION_ID) REFERENCES question (id);
ALTER TABLE question_option ADD CONSTRAINT FK_question_option_LASTMODIFIEDBY_ID FOREIGN KEY (LASTMODIFIEDBY_ID) REFERENCES users (id);
ALTER TABLE research ADD CONSTRAINT FK_research_LASTMODIFIEDBY_ID FOREIGN KEY (LASTMODIFIEDBY_ID) REFERENCES users (id);
ALTER TABLE research ADD CONSTRAINT FK_research_CREATEDBY_ID FOREIGN KEY (CREATEDBY_ID) REFERENCES users (id);
ALTER TABLE users ADD CONSTRAINT FK_users_CREATEDBY_ID FOREIGN KEY (CREATEDBY_ID) REFERENCES users (id);
ALTER TABLE users ADD CONSTRAINT FK_users_LASTMODIFIEDBY_ID FOREIGN KEY (LASTMODIFIEDBY_ID) REFERENCES users (id);
ALTER TABLE users ADD CONSTRAINT FK_users_DEFAULTROLE_ID FOREIGN KEY (DEFAULTROLE_ID) REFERENCES role (id);
ALTER TABLE permission ADD CONSTRAINT FK_permission_ROLE_ID FOREIGN KEY (ROLE_ID) REFERENCES role (id);
ALTER TABLE groups ADD CONSTRAINT FK_groups_CREATEDBY_ID FOREIGN KEY (CREATEDBY_ID) REFERENCES users (id);
ALTER TABLE groups ADD CONSTRAINT FK_groups_LASTMODIFIEDBY_ID FOREIGN KEY (LASTMODIFIEDBY_ID) REFERENCES users (id);
ALTER TABLE label_translation ADD CONSTRAINT FK_label_translation_LABEL_ID FOREIGN KEY (LABEL_ID) REFERENCES label (id);
ALTER TABLE mail_message_template_translation ADD CONSTRAINT FK_mail_message_template_translation_LASTMODIFIEDBY_ID FOREIGN KEY (LASTMODIFIEDBY_ID) REFERENCES users (id);
ALTER TABLE mail_message_template_translation ADD CONSTRAINT FK_mail_message_template_translation_CREATEDBY_ID FOREIGN KEY (CREATEDBY_ID) REFERENCES users (id);
ALTER TABLE mail_message_template_translation ADD CONSTRAINT FK_mail_message_template_translation_MAILMESSAGETEMPLATE_ID FOREIGN KEY (MAILMESSAGETEMPLATE_ID) REFERENCES mail_message_template (id);
ALTER TABLE question_group_translation ADD CONSTRAINT FK_question_group_translation_QUESTIONGROUP_ID FOREIGN KEY (QUESTIONGROUP_ID) REFERENCES question_group (id);
ALTER TABLE questionnair_definition_translation ADD CONSTRAINT questionnair_definition_translation_QUESTIONNAIRDEFINITION_ID FOREIGN KEY (QUESTIONNAIRDEFINITION_ID) REFERENCES questionnair_definition (id);
ALTER TABLE question_option_translation ADD CONSTRAINT FK_question_option_translation_QUESTIONOPTION_ID FOREIGN KEY (QUESTIONOPTION_ID) REFERENCES question_option (id);
ALTER TABLE question_translation ADD CONSTRAINT FK_question_translation_QUESTION_ID FOREIGN KEY (QUESTION_ID) REFERENCES question (id);
ALTER TABLE user_group ADD CONSTRAINT FK_user_group_group_id FOREIGN KEY (group_id) REFERENCES groups (id);
ALTER TABLE user_group ADD CONSTRAINT FK_user_group_user_id FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE user_role ADD CONSTRAINT FK_user_role_role_id FOREIGN KEY (role_id) REFERENCES role (id);
ALTER TABLE user_role ADD CONSTRAINT FK_user_role_user_id FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE group_role ADD CONSTRAINT FK_group_role_group_id FOREIGN KEY (group_id) REFERENCES groups (id);
ALTER TABLE group_role ADD CONSTRAINT FK_group_role_role_id FOREIGN KEY (role_id) REFERENCES role (id);

CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME));

-- Dynamic tables
-- CREATE TABLE questionnair_answers_7(id INTEGER NOT NULL, q1 VARCHAR(255), q2 VARCHAR(255), q3 integer, q4 text, q5 VARCHAR(255), q6 VARCHAR(255), q7_1 VARCHAR(255), q7_2 VARCHAR(255), q7_3 VARCHAR(255), q7_4 VARCHAR(255), q8_o1 BOOLEAN, q8_o2 BOOLEAN, q8_o3 BOOLEAN, q8_o4 BOOLEAN, PRIMARY KEY (id));

-- CREATE TABLE questionnair_answers_80 (id INTEGER NOT NULL, q1_1 VARCHAR(255), q1_2 VARCHAR(255), q1_3 VARCHAR(255), q1_4 VARCHAR(255), q2_1 VARCHAR(255), q2_2 VARCHAR(255), q2_3 VARCHAR(255), q2_4 VARCHAR(255), q2_5 VARCHAR(255), q2_6 VARCHAR(255), q3 VARCHAR(255), PRIMARY KEY (id));

-- Dynamic tables

CREATE TABLE questionnair_answers_121 (id INTEGER NOT NULL, q1_1 VARCHAR(255), q1_2 VARCHAR(255), q1_3 VARCHAR(255),  q1_4 VARCHAR(255), q2_1 VARCHAR(255),q2_2 VARCHAR(255), q2_3 VARCHAR(255), q2_4 VARCHAR(255), q2_5 VARCHAR(255), q2_6 VARCHAR(255), q3 VARCHAR(255), PRIMARY KEY (id));

CREATE TABLE questionnair_answers_12 ( id INTEGER NOT NULL, q1 VARCHAR(255), q10 VARCHAR(255), q11 VARCHAR(255), q12 VARCHAR(255), q2 VARCHAR(255), q3 INTEGER, q4_o1 BOOLEAN, q4_o2 BOOLEAN, q4_o3 BOOLEAN,q4_o4 BOOLEAN, q5 VARCHAR(255), q6 VARCHAR(255), q7_o1 BOOLEAN,q7_o2 BOOLEAN,q7_o3 BOOLEAN,  q7_o4 BOOLEAN,q8 INTEGER, q9 VARCHAR(255), PRIMARY KEY (id));
