# GazpachoQuest a Questionnair Tool

This is an application that is meant to be a answers collector tool for general purposes.
It provides a easy way to generate all kind of questionnaires with differents question types.

## Online demo

* [Active the backend here](http://gazpachoquest.rest.antoniomaria.eu.cloudbees.net/). This active cloudbees instance be patient may takes a while.
* [Enter the questionnaire login.](http://gazpachoquest.questionnaires.ui.antoniomaria.eu.cloudbees.net/) This also may takes a while.

## Authentication Flow

1. [Invitation Validation](http://gazpachoquest.rest.antoniomaria.eu.cloudbees.net/#!/auth/authenticate_get_0) 
   Try these invitations code.
   Anonymous questionnairs: 6O6PDUQLKN, P0C6Q2NN3H
   Personal questionnairs: YAS5ICHRBE, UCVZ45JZ3T, 76HHP9M9FQ, R7CHFY0YHQ

2. Then use apiKey and secret to fetch your [granted questionnair](http://gazpachoquest.rest.antoniomaria.eu.cloudbees.net/#!/questionnairs).

## Building and running demo

    git clone https://github.com/antoniomaria/gazpachoquest.git
    cd gazpachoquest
    mvn clean install
    cd launcher
    mvn tomee:run
        
To see the demo, navigate to
 [http://localhost:8080](http://localhost:8080)