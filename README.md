# GazpachoQuest a Questionnaire Tool

This is an application that is meant to be a answers collector tool for general purposes.
It provides a easy way to generate all kind of questionnaires with differents question types.

=======
### Activating the demo
The application is hosted in [cloudbees](http://www.cloudbees.com/) using a open source developer license, thus only is running if there are active users. Likely the application is hibernating, and need to be activated. So be patient, and reload the page again if you get a time-out error. 

* [Active the backend here](http://gazpachoquest.rest.antoniomaria.eu.cloudbees.net/).
* [Enter the questionnaire login.](http://gazpachoquest.questionnaires.ui.antoniomaria.eu.cloudbees.net/)

### Backend REST-API

This module exposes all the features that GazpachoQuest provides. They are related to data collections through questionnares as well as adminitrator functions such as export/import questionnaires or add new users.

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
    mvn tomee:run
        
To see the demo, navigate to
 [http://localhost:8080](http://localhost:8080)