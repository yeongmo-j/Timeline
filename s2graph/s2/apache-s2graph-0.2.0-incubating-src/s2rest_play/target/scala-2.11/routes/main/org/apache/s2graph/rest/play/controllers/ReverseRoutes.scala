
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yeongmo/Documents/Programming/timeline/s2graph/s2/apache-s2graph-0.2.0-incubating-src/s2rest_play/conf/routes
// @DATE:Tue Jul 23 20:57:14 KST 2019

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:27
package org.apache.s2graph.rest.play.controllers {

  // @LINE:79
  class ReverseAdminController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:91
    def addServiceColumnProps(serviceName:String, columnName:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/addServiceColumnProps/" + implicitly[PathBindable[String]].unbind("serviceName", dynamicString(serviceName)) + "/" + implicitly[PathBindable[String]].unbind("columnName", dynamicString(columnName)))
    }
  
    // @LINE:82
    def createLabel(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/createLabel")
    }
  
    // @LINE:81
    def getLabels(serviceName:String): Call = {
    
      (serviceName: @unchecked) match {
      
        // @LINE:81
        case (serviceName)  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "graphs/getLabels/" + implicitly[PathBindable[String]].unbind("serviceName", dynamicString(serviceName)))
      
      }
    
    }
  
    // @LINE:89
    def deleteServiceColumn(serviceName:String, columnName:String): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "graphs/deleteServiceColumn/" + implicitly[PathBindable[String]].unbind("serviceName", dynamicString(serviceName)) + "/" + implicitly[PathBindable[String]].unbind("columnName", dynamicString(columnName)))
    }
  
    // @LINE:93
    def createHTable(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/createHTable")
    }
  
    // @LINE:90
    def addServiceColumnProp(serviceName:String, columnName:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/addServiceColumnProp/" + implicitly[PathBindable[String]].unbind("serviceName", dynamicString(serviceName)) + "/" + implicitly[PathBindable[String]].unbind("columnName", dynamicString(columnName)))
    }
  
    // @LINE:98
    def copyLabel(oldLabelName:String, newLabelName:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/copyLabel/" + implicitly[PathBindable[String]].unbind("oldLabelName", dynamicString(oldLabelName)) + "/" + implicitly[PathBindable[String]].unbind("newLabelName", dynamicString(newLabelName)))
    }
  
    // @LINE:102
    def loadCache(): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "graphs/loadCache")
    }
  
    // @LINE:87
    def addProp(labelName:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/addProp/" + implicitly[PathBindable[String]].unbind("labelName", dynamicString(labelName)))
    }
  
    // @LINE:79
    def createService(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/createService")
    }
  
    // @LINE:83
    def addIndex(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/addIndex")
    }
  
    // @LINE:92
    def getServiceColumn(serviceName:String, columnName:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "graphs/getServiceColumn/" + implicitly[PathBindable[String]].unbind("serviceName", dynamicString(serviceName)) + "/" + implicitly[PathBindable[String]].unbind("columnName", dynamicString(columnName)))
    }
  
    // @LINE:88
    def createServiceColumn(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/createServiceColumn")
    }
  
    // @LINE:100
    def swapLabels(leftLabelName:String, rightLabelName:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/swapLabels/" + implicitly[PathBindable[String]].unbind("leftLabelName", dynamicString(leftLabelName)) + "/" + implicitly[PathBindable[String]].unbind("rightLabelName", dynamicString(rightLabelName)))
    }
  
    // @LINE:101
    def updateHTable(labelName:String, newHTableName:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/updateHTable/" + implicitly[PathBindable[String]].unbind("labelName", dynamicString(labelName)) + "/" + implicitly[PathBindable[String]].unbind("newHTableName", dynamicString(newHTableName)))
    }
  
    // @LINE:80
    def getService(serviceName:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "graphs/getService/" + implicitly[PathBindable[String]].unbind("serviceName", dynamicString(serviceName)))
    }
  
    // @LINE:85
    def deleteLabel(labelName:String): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "graphs/deleteLabelReally/" + implicitly[PathBindable[String]].unbind("labelName", dynamicString(labelName)))
    }
  
    // @LINE:84
    def getLabel(labelName:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "graphs/getLabel/" + implicitly[PathBindable[String]].unbind("labelName", dynamicString(labelName)))
    }
  
    // @LINE:99
    def renameLabel(oldLabelName:String, newLabelName:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/renameLabel/" + implicitly[PathBindable[String]].unbind("oldLabelName", dynamicString(oldLabelName)) + "/" + implicitly[PathBindable[String]].unbind("newLabelName", dynamicString(newLabelName)))
    }
  
  }

  // @LINE:106
  class ReverseCounterController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:117
    def getExactCountAsyncMulti(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "counter/v1/mget")
    }
  
    // @LINE:114
    def deleteRankingCount(service:String, action:String): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "counter/v1/" + implicitly[PathBindable[String]].unbind("service", dynamicString(service)) + "/" + implicitly[PathBindable[String]].unbind("action", dynamicString(action)) + "/ranking")
    }
  
    // @LINE:116
    def incrementCount(service:String, action:String, item:String): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "counter/v1/" + implicitly[PathBindable[String]].unbind("service", dynamicString(service)) + "/" + implicitly[PathBindable[String]].unbind("action", dynamicString(action)) + "/" + implicitly[PathBindable[String]].unbind("item", dynamicString(item)))
    }
  
    // @LINE:110
    def deleteAction(service:String, action:String): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "counter/v1/" + implicitly[PathBindable[String]].unbind("service", dynamicString(service)) + "/" + implicitly[PathBindable[String]].unbind("action", dynamicString(action)))
    }
  
    // @LINE:108
    def updateAction(service:String, action:String): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "counter/v1/" + implicitly[PathBindable[String]].unbind("service", dynamicString(service)) + "/" + implicitly[PathBindable[String]].unbind("action", dynamicString(action)))
    }
  
    // @LINE:107
    def getAction(service:String, action:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "counter/v1/" + implicitly[PathBindable[String]].unbind("service", dynamicString(service)) + "/" + implicitly[PathBindable[String]].unbind("action", dynamicString(action)))
    }
  
    // @LINE:115
    def getExactCountAsync(service:String, action:String, item:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "counter/v1/" + implicitly[PathBindable[String]].unbind("service", dynamicString(service)) + "/" + implicitly[PathBindable[String]].unbind("action", dynamicString(action)) + "/" + implicitly[PathBindable[String]].unbind("item", dynamicString(item)))
    }
  
    // @LINE:106
    def createAction(service:String, action:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "counter/v1/" + implicitly[PathBindable[String]].unbind("service", dynamicString(service)) + "/" + implicitly[PathBindable[String]].unbind("action", dynamicString(action)))
    }
  
    // @LINE:113
    def getRankingCountAsync(service:String, action:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "counter/v1/" + implicitly[PathBindable[String]].unbind("service", dynamicString(service)) + "/" + implicitly[PathBindable[String]].unbind("action", dynamicString(action)) + "/ranking")
    }
  
    // @LINE:109
    def prepareAction(service:String, action:String): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "counter/v1/" + implicitly[PathBindable[String]].unbind("service", dynamicString(service)) + "/" + implicitly[PathBindable[String]].unbind("action", dynamicString(action)) + "/prepare")
    }
  
  }

  // @LINE:120
  class ReverseExperimentController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:121
    def experiments(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/experiments")
    }
  
    // @LINE:120
    def experiment(accessToken:String, experimentName:String, uuid:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/experiment/" + implicitly[PathBindable[String]].unbind("accessToken", dynamicString(accessToken)) + "/" + implicitly[PathBindable[String]].unbind("experimentName", dynamicString(experimentName)) + "/" + implicitly[PathBindable[String]].unbind("uuid", dynamicString(uuid)))
    }
  
  }

  // @LINE:30
  class ReverseApplicationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def healthCheck(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "health_check.html")
    }
  
    // @LINE:31
    def updateHealthCheck(isHealthy:Boolean): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "health_check/" + implicitly[PathBindable[Boolean]].unbind("isHealthy", isHealthy))
    }
  
  }

  // @LINE:27
  class ReversePublishController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def publishOnly(topic:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "publishOnly/" + implicitly[PathBindable[String]].unbind("topic", dynamicString(topic)))
    }
  
  }

  // @LINE:34
  class ReverseEdgeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:46
    def mutateBulk(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/edges/bulk")
    }
  
    // @LINE:36
    def insertsBulk(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/edges/insertBulk")
    }
  
    // @LINE:38
    def deletesWithWait(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/edges/deleteWithWait")
    }
  
    // @LINE:43
    def increments(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/edges/increment")
    }
  
    // @LINE:35
    def insertsWithWait(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/edges/insertWithWait")
    }
  
    // @LINE:37
    def deletes(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/edges/delete")
    }
  
    // @LINE:41
    def updates(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/edges/update")
    }
  
    // @LINE:34
    def inserts(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/edges/insert")
    }
  
    // @LINE:39
    def deleteAll(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/edges/deleteAll")
    }
  
    // @LINE:40
    def deleteAllWithOutWait(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/edges/deleteAllWithOutWait")
    }
  
    // @LINE:42
    def updatesWithWait(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/edges/updateWithWait")
    }
  
    // @LINE:44
    def incrementsWithWait(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/edges/incrementWithWait")
    }
  
    // @LINE:45
    def incrementCounts(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/edges/incrementCount")
    }
  
    // @LINE:47
    def mutateBulkWithWait(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/edges/bulkWithWait")
    }
  
  }

  // @LINE:61
  class ReverseQueryController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:68
    def getEdgesGrouped(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/getEdgesGrouped")
    }
  
    // @LINE:75
    def getVertices(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/getVertices")
    }
  
    // @LINE:71
    def getEdge(srcId:String, tgtId:String, labelName:String, direction:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "graphs/getEdge/" + implicitly[PathBindable[String]].unbind("srcId", dynamicString(srcId)) + "/" + implicitly[PathBindable[String]].unbind("tgtId", dynamicString(tgtId)) + "/" + implicitly[PathBindable[String]].unbind("labelName", dynamicString(labelName)) + "/" + implicitly[PathBindable[String]].unbind("direction", dynamicString(direction)))
    }
  
    // @LINE:69
    def getEdgesGroupedExcluded(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/getEdgesGroupedExcluded")
    }
  
    // @LINE:61
    def getEdges(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/getEdges")
    }
  
    // @LINE:62
    def getEdgesWithGrouping(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/getEdges/grouped")
    }
  
    // @LINE:70
    def getEdgesGroupedExcludedFormatted(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/getEdgesGroupedExcludedFormatted")
    }
  
    // @LINE:65
    def checkEdges(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/checkEdges")
    }
  
    // @LINE:64
    def getEdgesExcludedWithGrouping(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/getEdgesExcluded/grouped")
    }
  
    // @LINE:63
    def getEdgesExcluded(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/getEdgesExcluded")
    }
  
  }

  // @LINE:50
  class ReverseVertexController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:56
    def deletesAll(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/vertices/deleteAll")
    }
  
    // @LINE:54
    def deletesWithWait(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/vertices/deleteWithWait")
    }
  
    // @LINE:57
    def deletesAllSimple(serviceName:String, columnName:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/vertices/deleteAll/" + implicitly[PathBindable[String]].unbind("serviceName", dynamicString(serviceName)) + "/" + implicitly[PathBindable[String]].unbind("columnName", dynamicString(columnName)))
    }
  
    // @LINE:52
    def insertsSimple(serviceName:String, columnName:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/vertices/insert/" + implicitly[PathBindable[String]].unbind("serviceName", dynamicString(serviceName)) + "/" + implicitly[PathBindable[String]].unbind("columnName", dynamicString(columnName)))
    }
  
    // @LINE:51
    def insertsWithWait(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/vertices/insertWithWait")
    }
  
    // @LINE:53
    def deletes(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/vertices/delete")
    }
  
    // @LINE:50
    def inserts(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/vertices/insert")
    }
  
    // @LINE:55
    def deletesSimple(serviceName:String, columnName:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "graphs/vertices/delete/" + implicitly[PathBindable[String]].unbind("serviceName", dynamicString(serviceName)) + "/" + implicitly[PathBindable[String]].unbind("columnName", dynamicString(columnName)))
    }
  
  }


}
