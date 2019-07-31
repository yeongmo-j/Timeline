
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yeongmo/Documents/Programming/timeline/s2graph/s2/apache-s2graph-0.2.0-incubating-src/s2rest_play/conf/routes
// @DATE:Tue Jul 23 20:57:14 KST 2019

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:124
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:124
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:124
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(path0,file1) {
        
          if (path0 == """ + implicitly[JavascriptLiteral[String]].to("/public/images") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "images/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
          }
        
          if (path0 == """ + implicitly[JavascriptLiteral[String]].to("/public/javascripts") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "javascripts/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
          }
        
          if (path0 == """ + implicitly[JavascriptLiteral[String]].to("/public/stylesheets") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "stylesheets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
          }
        
          if (path0 == """ + implicitly[JavascriptLiteral[String]].to("/public/font-awesome-4.1.0") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "font-awesome-4.1.0/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
          }
        
          if (path0 == """ + implicitly[JavascriptLiteral[String]].to("/public/swagger-ui") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "swagger/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
          }
        
        }
      """
    )
  
  }


}
