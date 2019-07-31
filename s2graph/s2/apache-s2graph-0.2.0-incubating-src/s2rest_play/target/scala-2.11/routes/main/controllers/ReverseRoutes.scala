
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yeongmo/Documents/Programming/timeline/s2graph/s2/apache-s2graph-0.2.0-incubating-src/s2rest_play/conf/routes
// @DATE:Tue Jul 23 20:57:14 KST 2019

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:124
package controllers {

  // @LINE:124
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:124
    def at(path:String, file:String): Call = {
    
      (path: @unchecked, file: @unchecked) match {
      
        // @LINE:124
        case (path, file) if path == "/public/images" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public/images")))
          Call("GET", _prefix + { _defaultPrefix } + "images/" + implicitly[PathBindable[String]].unbind("file", file))
      
        // @LINE:125
        case (path, file) if path == "/public/javascripts" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public/javascripts")))
          Call("GET", _prefix + { _defaultPrefix } + "javascripts/" + implicitly[PathBindable[String]].unbind("file", file))
      
        // @LINE:126
        case (path, file) if path == "/public/stylesheets" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public/stylesheets")))
          Call("GET", _prefix + { _defaultPrefix } + "stylesheets/" + implicitly[PathBindable[String]].unbind("file", file))
      
        // @LINE:127
        case (path, file) if path == "/public/font-awesome-4.1.0" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public/font-awesome-4.1.0")))
          Call("GET", _prefix + { _defaultPrefix } + "font-awesome-4.1.0/" + implicitly[PathBindable[String]].unbind("file", file))
      
        // @LINE:128
        case (path, file) if path == "/public/swagger-ui" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public/swagger-ui")))
          Call("GET", _prefix + { _defaultPrefix } + "swagger/" + implicitly[PathBindable[String]].unbind("file", file))
      
      }
    
    }
  
  }


}
