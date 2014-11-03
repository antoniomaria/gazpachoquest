# GazpachoQuest a Questionnaire Tool

This is an application that is meant to be a answers collector tool for general purposes.
It provides a easy way to generate all kind of questionnaires with different question types.


## Contributing
Contributions are welcome, in any form including code contributions, bug reports, feature suggestions, documentation, testing, and general feedback. Issues can be submitted on the [Github page][1]. For further information, contact to: <mailto:antoniomariasanchez@gmail.com>

=======
### Activating the demo
The application is hosted in [cloudbees](http://www.cloudbees.com/) using a open source developer license, thus only is running if there are active users. Likely the application is hibernating, and need to be activated. So be patient, and reload the page again if you get a time-out error. 

* [Active the backend here](http://gazpachoquest.rest.antoniomaria.eu.cloudbees.net/).
* [Enter the questionnaire login.](http://gazpachoquest.questionnaires.ui.antoniomaria.eu.cloudbees.net/)

### Backend REST-API

This module exposes all the features that GazpachoQuest provides. They are related to data collections through questionnares as well as adminitrator functions such as export/import questionnaires or add new users.

The credential for administrator account in form of apiKey:secret is:

    FM7XG6W2C4CET8H:2J882Y9GJNNE4VWKK2R9NX7R4R2DYWTQ

To get respondents credential first is required to validate the invitation key in [Authentication Resource](http://gazpachoquest.rest.antoniomaria.eu.cloudbees.net/#!/auth/authenticate_get_0) 

### Questonnaires UI

This module holds all the actives questionnaires/surveys ready to be fill out for respondents. They can be anonymous or tracked depending on the questionnaire settings.

** Anonymous questionnaires invitation keys **

|                          |  No Randomization      |  Sections Randomization   |  Questions Randomization  |
|--------------------------|:----------------------:|:-------------------------:|:-------------------------:|
| **Section By Section**   |  PXLLBCJDX6            |  QT2SXREWAH               |  REGRW5X27C               |
| **Question by Question** |                        |                           |                           |
| **All in one page**      |  ZZC3XNHYVL            |                           |                           |


**Personal questionnaires invitation keys**

|                          |  No Randomization      |  Sections Randomization   |  Questions Randomization  |
|--------------------------|:----------------------:|:-------------------------:|:-------------------------:|
| **Section By Section**   |  2CNBSHKPBQ, DCLHXDRMLS|  D7QZ2CXZJW, ULQ6XWK8QR   |  SS5G7MV7NY,FSMSLM2A44    |
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

[1]: https://github.com/antoniomaria/gazpachoquest/issues