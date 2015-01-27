package net.sf.gazpachoquest.dto.uml;

/**
 * @opt collpackages java.util.*
 * @opt useimports
 * 
 * @match class java.*|org.xml.*
 * @opt hide 
 * 
 * @opt postfixpackage
 * @opt !constructors
 * @opt nodefontpackagesize 8
 * @hidden
 */
public class UMLOptions {

        // Explication des annotations :
        // @opt inferrel et collpackages      : permet le lien entre ClasseAbstraite et Element
        // @opt inferdep et inferdepinpackage : permet les liens entre ClasseAbstraite-Classe et Dependance
        // @opt useimports                    : permet le lien entre Interface et Interface2

}
