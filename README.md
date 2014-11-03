# GazpachoQuest a Questionnaire Tool

GazpachoQuest is general purpose tool for collecting answers through dynamic web form. The main advantage over other alternatives is its loose coupled architecture based on
[Microservices Architecture](http://www.infoq.com/articles/microservices-intro) which ensures concern-separation.
At this moment all the effort has been spent on provide a powerful, REST Gateway which exposes all features, ready to be consumed by others applications as a front-end. 

[![Build Status](https://travis-ci.org/antoniomaria/gazpachoquest.svg?branch=master)](https://travis-ci.org/antoniomaria/gazpachoquest)

## Highligh features

* Multi-lingual questionnaires 
* Conditions for questions depending on earlier answers (Skip Logic / Branching)
* Question and page randomization
* Auto-numbering for questions
* Reordering questions / page logic.
* Question Types
  * Multiple Choice List (Check Boxes) + Other. Vertically or Horizontally arranged.
  * Short /Long Text  Response + Other
  * Multiple Choice one selected at a time (Radio buttons). Vertically or Horizontally (scales) arranged.
  * Matrix or array of questions above listed.
* Smart language selector depending on Browser Preferred Language, or Respondent attributes.
* Anonymous and Not-Anonymous questionnaires
* Role-Permission based Access-Rights management. 
* Import and export questionnaires definitions to XML


## Contributing

Contributions are welcome, in any form including code contributions, bug reports, feature suggestions, documentation, testing, and general feedback. Issues can be submitted on the [Github page][1]. For further information, contact to: <mailto:antoniomariasanchez@gmail.com>

## Third party libraries and components

* [JPA Eclipse link](http://www.eclipse.org/eclipselink/jpa.php)
* [Doze Java Bean mapper](http://dozer.sourceforge.net/)
* [Flyway](http://flywaydb.org/) 
* [Spring Data JPA](http://projects.spring.io/spring-data/)
* [JAX-RS (Apache CXF)](http://cxf.apache.org/)
* [Java Security Shiro](http://shiro.apache.org/)
* [Vaadin (CDI plugin)](https://vaadin.com/home)
* Java Authentication and Authorization Service, (JAAS)  
* SL4J (Logback)
* [JUEL](http://juel.sourceforge.net)
* [DBUnit](http://dbunit.sourceforge.net)
* [Spring-Test DBUnit](http://springtestdbunit.github.io/spring-test-dbunit/)
* [EasyMock](http://easymock.org/)

## Installation and local demo

    git clone https://github.com/antoniomaria/gazpachoquest.git
    cd gazpachoquest
    mvn clean install
    cd launcher
    mvn clean tomee:run
    
To see the demo, navigate to

* [REST Gateway](http://localhost:8080/gazpachoquest-rest-web)
* [Questionnaires UI](http://localhost:8080)

### REST Gateway

This module exposes all the features that GazpachoQuest provides.

The credential for administrator account in form of apiKey:secret is:

    FM7XG6W2C4CET8H:2J882Y9GJNNE4VWKK2R9NX7R4R2DYWTQ

To get respondents credential first is required to validate the invitation key in [Authentication Resource](http://gazpachoquest.rest.antoniomaria.eu.cloudbees.net/#!/auth/authenticate_get_0) 

### Questionnaires UI

This module holds all the active questionnaires/surveys ready to be fill out for respondents. They can be anonymous or tracked depending on the questionnaire settings.

**Anonymous and linear questionnaires invitation keys**

|                          |  No Randomization      |  Sections Randomization   |  Questions Randomization  |
|--------------------------|:----------------------:|:-------------------------:|:-------------------------:|
| **Section By Section**   |  PXLLBCJDX6            |  QT2SXREWAH               |  REGRW5X27C               |
| **Question by Question** |                        |                           |                           |
| **All in one page**      |  ZZC3XNHYVL            |                           |                           |

**Anonymous dynamic questionnaire depending on previous answers (skip-logic enabled)**

|                          |  No Randomization      | 
|--------------------------|:----------------------:|
| **Section By Section**   |  ZRHV75Z6CB            |
| **Question by Question** |                        | 

**Personal questionnaires invitation keys**

|                          |  No Randomization      |  Sections Randomization   |  Questions Randomization  |
|--------------------------|:----------------------:|:-------------------------:|:-------------------------:|
| **Section By Section**   |  2CNBSHKPBQ, DCLHXDRMLS|  D7QZ2CXZJW, ULQ6XWK8QR   |  SS5G7MV7NY,FSMSLM2A44    |
| **Question by Question** |                        |                           |                           |
| **All in one page**      |                        |                           |                           |


[1]: https://github.com/antoniomaria/gazpachoquest/issues
