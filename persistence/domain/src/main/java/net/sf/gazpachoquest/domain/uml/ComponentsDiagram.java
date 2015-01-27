package net.sf.gazpachoquest.domain.uml;

/**
 * @view
 * 
 * @opt attributes
 * @opt !constructors
 * @opt horizontal
 * @opt nodefontpackagesize 8
 * 
 * @opt hide
 * 
 * @match class (net.sf.gazpachoquest.domain.uml).*(RDBMS|GazpachoQuest|QuestionnairesUI|DashboardUI|InSightUI|AssessmentsUI)(<.*)?
 * @opt !hide
 * 
 */
public class ComponentsDiagram {

}

/**
 * @stereotype database
 * @opt shape component
 */
class RDBMS {

}

/**
 * @stereotype ui
 * @opt shape component
 * @navassoc - - - GazpachoQuest
 */
class DashboardUI {

}

/**
 * @stereotype ui
 * @opt shape component
 * @navassoc - - - GazpachoQuest
 */
class AssessmentsUI {

}

/**
 * @stereotype ui
 * @opt shape component
 * @navassoc - - - GazpachoQuest
 */
class InSightUI {

}

/**
 * @stereotype ui
 * @opt shape component
 * @navassoc - - - GazpachoQuest
 */
class QuestionnairesUI {

}

/**
 * @stereotype gateway
 * @opt shape component
 * @navassoc - - - RDBMS
 */
class GazpachoQuest {

}
