# GazpachoQuest a Questionnaire Tool

### General

GazpachoQuest is general purpose tool for collecting answers through dynamic web form. The main advantagde over other alternatives is loose coupled architecture based on
[Microservices Architecture](http://www.infoq.com/articles/microservices-intro) which ensures concern-separation.
At this moment all the effort has been spent on provide a powerful, REST Gateway which exposes all features, ready to be consumed by others applications as a front-end. 

## Java Stack

* JPA Eclipse link
* Spring Data JPA
* JAX-RS (Apache CXF)
* Java Security Shiro
* Vaadin
* Java Authentication and Authorization Service, (JAAS)  
* SL4J (Logback)
* DBUnit
* EasyMock

## Highligh features

* Multi-lingual questionnaires 
* Conditions for questions depending on earlier answers (Skip Logic / Branching)
* Question and page randomization
* Dynamic Questionnaire completion progress bar (or possibility to disable).
* Auto-numbering for questions
* Reordering questions / page logic.
* Question Types
  * Multiple Choice List (Check Boxes) + Other. Vertically or Horizontally arranged.
  * Short /Long Text  Response + Other
  * Multiple Choice one selected at a time (Radio buttons). Vertically or Horizontally (scales) arranged.
  * Matrix or array of questions above listed.
* Possibility to disable back button, resume button, logo, introduction text, skip welcome or thank-you page.
* Smart language selector depending on Browser Preferred Language, or Respondent attributes.
* Immediately answers saving. This gives the benefits of immediately validation, no need to change the page to validate the answers.
* Anonymous and Not-Anonymous questionnaires
* Role-Permission based Access-Rights management. 
* Import and export questionnaires definitions to XML


=======
### Activating the demo
The application is hosted in [cloudbees](http://www.cloudbees.com/) using a open source developer license, thus only is running if there are active users. Likely the application is hibernating, and need to be activated. So be patient, and reload the page again if you get a time-out error. 

* [Active the backend here](http://gazpachoquest.rest.antoniomaria.eu.cloudbees.net/).
* [Enter the questionnaire login.](http://gazpachoquest.questionnaires.ui.antoniomaria.eu.cloudbees.net/)

### Backend REST-API

This module exposes all the features that GazpachoQuest provides. They are related to data collections through questionnares as well as administrator functions such as export/import questionnaires or add new users.

The credential for administrator account in form of apiKey:secret is:

    3Q2JBVEASJY2SC6:XFQRMVGKR8R328TJ78E688J9MB8D6HS4

To get respondents credential first is required to validate the invitation key in [Authentication Resource](http://gazpachoquest.rest.antoniomaria.eu.cloudbees.net/#!/auth/authenticate_get_0) 

### Questonnaires UI

This module holds all the actives questionnaires/surveys ready to be fill out for respondents. They can be anonymous or tracked depending on the questionnaire settings.

** Anonymous questionnaires invitation keys **

|                          |  No Randomization      |  Sections Randomization   |  Questions Randomization  |
|--------------------------|:----------------------:|:-------------------------:|:-------------------------:|
| **Section By Section**   |  7ESWZMSQ8H            |  8FSXJDJ8UJ               |  FFWXDVNCZG               |
| **Question by Question** |                        |                           |                           |
| **All in one page**      | SLJ5Z26HNC             |                           |                           |


**Personal questionnaires invitation keys**

|                          |  No Randomization      |  Sections Randomization   |  Questions Randomization  |
|--------------------------|:----------------------:|:-------------------------:|:-------------------------:|
| **Section By Section**   |  XVKDAB45XG, 3B5GKVKCKK|  QLM7MVK3RG, BQBTBE3SNP   |  NS9M4GG5EU,NS9M4GG5EU    |
| **Question by Question** |                        |                           |                           |
| **All in one page**      |                        |                           |                           |

## Building and running demo

    git clone https://github.com/antoniomaria/gazpachoquest.git
    cd gazpachoquest
    mvn clean install
    cd launcher
    mvn clean tomee:run
        
To see the demo, navigate to

* [Backend REST-API](http://localhost:8080/gazpachoquest-rest-web)
* [Questonnaires UI](http://localhost:8080)