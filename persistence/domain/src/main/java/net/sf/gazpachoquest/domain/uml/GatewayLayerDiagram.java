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
 * @match class (net.sf.gazpachoquest.domain.uml).*(RDBMS|Facade|Service|Repository|DTO2DO|DO2DTO|RestResource|Security)(<.*)?
 * @opt !hide
 * 
 */
public class GatewayLayerDiagram {

}

/**
 * Rest Resource
 * @stereotype endpoint
 * @opt shape package
 * @navassoc - - - Security
 * @navassoc - - - Facade
 */
class RestResource{

}

/**
 * @stereotype interceptor
 * @opt shape package
 * @navassoc - - - RestResource
 * @note Hmac and Shiro
 */
class Security{

}

/**
 * @opt shape package
 * @navassoc - - - Service
 * @navassoc - - - DTO2DO 
 * @navassoc - - - DO2DTO
 */
class Facade {

}

/**
 * DTO to DO
 * @opt commentname
 * @stereotype mapper
 * @navassoc - - - Facade
 */
class DTO2DO {
    
}

/**
 * DO to DTO
 * @opt commentname
 * @stereotype mapper
 * @navassoc - - - Facade
 */
class DO2DTO{
    
}

/**
 * @opt shape package
 * @navassoc - - - Repository
 */
class Service {

}

/**
 * @opt shape package
 * @stereotype dao
 * @navassoc - - - RDBMS
 */
class Repository {

}
