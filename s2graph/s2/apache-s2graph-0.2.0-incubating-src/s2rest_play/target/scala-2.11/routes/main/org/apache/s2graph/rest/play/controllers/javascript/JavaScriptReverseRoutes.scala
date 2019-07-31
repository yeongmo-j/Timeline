
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yeongmo/Documents/Programming/timeline/s2graph/s2/apache-s2graph-0.2.0-incubating-src/s2rest_play/conf/routes
// @DATE:Tue Jul 23 20:57:14 KST 2019

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:27
package org.apache.s2graph.rest.play.controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:79
  class ReverseAdminController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:91
    def addServiceColumnProps: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.addServiceColumnProps",
      """
        function(serviceName0,columnName1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/addServiceColumnProps/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("serviceName", encodeURIComponent(serviceName0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("columnName", encodeURIComponent(columnName1))})
        }
      """
    )
  
    // @LINE:82
    def createLabel: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.createLabel",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/createLabel"})
        }
      """
    )
  
    // @LINE:81
    def getLabels: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.getLabels",
      """
        function(serviceName0) {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/getLabels/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("serviceName", encodeURIComponent(serviceName0))})
          }
        
        }
      """
    )
  
    // @LINE:89
    def deleteServiceColumn: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.deleteServiceColumn",
      """
        function(serviceName0,columnName1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/deleteServiceColumn/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("serviceName", encodeURIComponent(serviceName0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("columnName", encodeURIComponent(columnName1))})
        }
      """
    )
  
    // @LINE:93
    def createHTable: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.createHTable",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/createHTable"})
        }
      """
    )
  
    // @LINE:90
    def addServiceColumnProp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.addServiceColumnProp",
      """
        function(serviceName0,columnName1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/addServiceColumnProp/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("serviceName", encodeURIComponent(serviceName0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("columnName", encodeURIComponent(columnName1))})
        }
      """
    )
  
    // @LINE:98
    def copyLabel: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.copyLabel",
      """
        function(oldLabelName0,newLabelName1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/copyLabel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("oldLabelName", encodeURIComponent(oldLabelName0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("newLabelName", encodeURIComponent(newLabelName1))})
        }
      """
    )
  
    // @LINE:102
    def loadCache: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.loadCache",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/loadCache"})
        }
      """
    )
  
    // @LINE:87
    def addProp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.addProp",
      """
        function(labelName0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/addProp/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("labelName", encodeURIComponent(labelName0))})
        }
      """
    )
  
    // @LINE:79
    def createService: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.createService",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/createService"})
        }
      """
    )
  
    // @LINE:83
    def addIndex: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.addIndex",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/addIndex"})
        }
      """
    )
  
    // @LINE:92
    def getServiceColumn: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.getServiceColumn",
      """
        function(serviceName0,columnName1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/getServiceColumn/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("serviceName", encodeURIComponent(serviceName0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("columnName", encodeURIComponent(columnName1))})
        }
      """
    )
  
    // @LINE:88
    def createServiceColumn: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.createServiceColumn",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/createServiceColumn"})
        }
      """
    )
  
    // @LINE:100
    def swapLabels: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.swapLabels",
      """
        function(leftLabelName0,rightLabelName1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/swapLabels/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("leftLabelName", encodeURIComponent(leftLabelName0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("rightLabelName", encodeURIComponent(rightLabelName1))})
        }
      """
    )
  
    // @LINE:101
    def updateHTable: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.updateHTable",
      """
        function(labelName0,newHTableName1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/updateHTable/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("labelName", encodeURIComponent(labelName0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("newHTableName", encodeURIComponent(newHTableName1))})
        }
      """
    )
  
    // @LINE:80
    def getService: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.getService",
      """
        function(serviceName0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/getService/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("serviceName", encodeURIComponent(serviceName0))})
        }
      """
    )
  
    // @LINE:85
    def deleteLabel: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.deleteLabel",
      """
        function(labelName0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/deleteLabelReally/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("labelName", encodeURIComponent(labelName0))})
        }
      """
    )
  
    // @LINE:84
    def getLabel: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.getLabel",
      """
        function(labelName0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/getLabel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("labelName", encodeURIComponent(labelName0))})
        }
      """
    )
  
    // @LINE:99
    def renameLabel: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.AdminController.renameLabel",
      """
        function(oldLabelName0,newLabelName1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/renameLabel/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("oldLabelName", encodeURIComponent(oldLabelName0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("newLabelName", encodeURIComponent(newLabelName1))})
        }
      """
    )
  
  }

  // @LINE:106
  class ReverseCounterController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:117
    def getExactCountAsyncMulti: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.CounterController.getExactCountAsyncMulti",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "counter/v1/mget"})
        }
      """
    )
  
    // @LINE:114
    def deleteRankingCount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.CounterController.deleteRankingCount",
      """
        function(service0,action1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "counter/v1/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("service", encodeURIComponent(service0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("action", encodeURIComponent(action1)) + "/ranking"})
        }
      """
    )
  
    // @LINE:116
    def incrementCount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.CounterController.incrementCount",
      """
        function(service0,action1,item2) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "counter/v1/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("service", encodeURIComponent(service0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("action", encodeURIComponent(action1)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("item", encodeURIComponent(item2))})
        }
      """
    )
  
    // @LINE:110
    def deleteAction: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.CounterController.deleteAction",
      """
        function(service0,action1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "counter/v1/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("service", encodeURIComponent(service0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("action", encodeURIComponent(action1))})
        }
      """
    )
  
    // @LINE:108
    def updateAction: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.CounterController.updateAction",
      """
        function(service0,action1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "counter/v1/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("service", encodeURIComponent(service0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("action", encodeURIComponent(action1))})
        }
      """
    )
  
    // @LINE:107
    def getAction: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.CounterController.getAction",
      """
        function(service0,action1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "counter/v1/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("service", encodeURIComponent(service0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("action", encodeURIComponent(action1))})
        }
      """
    )
  
    // @LINE:115
    def getExactCountAsync: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.CounterController.getExactCountAsync",
      """
        function(service0,action1,item2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "counter/v1/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("service", encodeURIComponent(service0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("action", encodeURIComponent(action1)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("item", encodeURIComponent(item2))})
        }
      """
    )
  
    // @LINE:106
    def createAction: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.CounterController.createAction",
      """
        function(service0,action1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "counter/v1/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("service", encodeURIComponent(service0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("action", encodeURIComponent(action1))})
        }
      """
    )
  
    // @LINE:113
    def getRankingCountAsync: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.CounterController.getRankingCountAsync",
      """
        function(service0,action1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "counter/v1/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("service", encodeURIComponent(service0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("action", encodeURIComponent(action1)) + "/ranking"})
        }
      """
    )
  
    // @LINE:109
    def prepareAction: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.CounterController.prepareAction",
      """
        function(service0,action1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "counter/v1/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("service", encodeURIComponent(service0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("action", encodeURIComponent(action1)) + "/prepare"})
        }
      """
    )
  
  }

  // @LINE:120
  class ReverseExperimentController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:121
    def experiments: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.ExperimentController.experiments",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/experiments"})
        }
      """
    )
  
    // @LINE:120
    def experiment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.ExperimentController.experiment",
      """
        function(accessToken0,experimentName1,uuid2) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/experiment/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("accessToken", encodeURIComponent(accessToken0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("experimentName", encodeURIComponent(experimentName1)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("uuid", encodeURIComponent(uuid2))})
        }
      """
    )
  
  }

  // @LINE:30
  class ReverseApplicationController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def healthCheck: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.ApplicationController.healthCheck",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "health_check.html"})
        }
      """
    )
  
    // @LINE:31
    def updateHealthCheck: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.ApplicationController.updateHealthCheck",
      """
        function(isHealthy0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "health_check/" + (""" + implicitly[PathBindable[Boolean]].javascriptUnbind + """)("isHealthy", isHealthy0)})
        }
      """
    )
  
  }

  // @LINE:27
  class ReversePublishController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def publishOnly: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.PublishController.publishOnly",
      """
        function(topic0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "publishOnly/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("topic", encodeURIComponent(topic0))})
        }
      """
    )
  
  }

  // @LINE:34
  class ReverseEdgeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:46
    def mutateBulk: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.EdgeController.mutateBulk",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/edges/bulk"})
        }
      """
    )
  
    // @LINE:36
    def insertsBulk: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.EdgeController.insertsBulk",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/edges/insertBulk"})
        }
      """
    )
  
    // @LINE:38
    def deletesWithWait: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.EdgeController.deletesWithWait",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/edges/deleteWithWait"})
        }
      """
    )
  
    // @LINE:43
    def increments: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.EdgeController.increments",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/edges/increment"})
        }
      """
    )
  
    // @LINE:35
    def insertsWithWait: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.EdgeController.insertsWithWait",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/edges/insertWithWait"})
        }
      """
    )
  
    // @LINE:37
    def deletes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.EdgeController.deletes",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/edges/delete"})
        }
      """
    )
  
    // @LINE:41
    def updates: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.EdgeController.updates",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/edges/update"})
        }
      """
    )
  
    // @LINE:34
    def inserts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.EdgeController.inserts",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/edges/insert"})
        }
      """
    )
  
    // @LINE:39
    def deleteAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.EdgeController.deleteAll",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/edges/deleteAll"})
        }
      """
    )
  
    // @LINE:40
    def deleteAllWithOutWait: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.EdgeController.deleteAllWithOutWait",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/edges/deleteAllWithOutWait"})
        }
      """
    )
  
    // @LINE:42
    def updatesWithWait: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.EdgeController.updatesWithWait",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/edges/updateWithWait"})
        }
      """
    )
  
    // @LINE:44
    def incrementsWithWait: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.EdgeController.incrementsWithWait",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/edges/incrementWithWait"})
        }
      """
    )
  
    // @LINE:45
    def incrementCounts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.EdgeController.incrementCounts",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/edges/incrementCount"})
        }
      """
    )
  
    // @LINE:47
    def mutateBulkWithWait: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.EdgeController.mutateBulkWithWait",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/edges/bulkWithWait"})
        }
      """
    )
  
  }

  // @LINE:61
  class ReverseQueryController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:68
    def getEdgesGrouped: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.QueryController.getEdgesGrouped",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/getEdgesGrouped"})
        }
      """
    )
  
    // @LINE:75
    def getVertices: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.QueryController.getVertices",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/getVertices"})
        }
      """
    )
  
    // @LINE:71
    def getEdge: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.QueryController.getEdge",
      """
        function(srcId0,tgtId1,labelName2,direction3) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/getEdge/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("srcId", encodeURIComponent(srcId0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tgtId", encodeURIComponent(tgtId1)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("labelName", encodeURIComponent(labelName2)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("direction", encodeURIComponent(direction3))})
        }
      """
    )
  
    // @LINE:69
    def getEdgesGroupedExcluded: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.QueryController.getEdgesGroupedExcluded",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/getEdgesGroupedExcluded"})
        }
      """
    )
  
    // @LINE:61
    def getEdges: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.QueryController.getEdges",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/getEdges"})
        }
      """
    )
  
    // @LINE:62
    def getEdgesWithGrouping: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.QueryController.getEdgesWithGrouping",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/getEdges/grouped"})
        }
      """
    )
  
    // @LINE:70
    def getEdgesGroupedExcludedFormatted: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.QueryController.getEdgesGroupedExcludedFormatted",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/getEdgesGroupedExcludedFormatted"})
        }
      """
    )
  
    // @LINE:65
    def checkEdges: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.QueryController.checkEdges",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/checkEdges"})
        }
      """
    )
  
    // @LINE:64
    def getEdgesExcludedWithGrouping: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.QueryController.getEdgesExcludedWithGrouping",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/getEdgesExcluded/grouped"})
        }
      """
    )
  
    // @LINE:63
    def getEdgesExcluded: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.QueryController.getEdgesExcluded",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/getEdgesExcluded"})
        }
      """
    )
  
  }

  // @LINE:50
  class ReverseVertexController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:56
    def deletesAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.VertexController.deletesAll",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/vertices/deleteAll"})
        }
      """
    )
  
    // @LINE:54
    def deletesWithWait: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.VertexController.deletesWithWait",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/vertices/deleteWithWait"})
        }
      """
    )
  
    // @LINE:57
    def deletesAllSimple: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.VertexController.deletesAllSimple",
      """
        function(serviceName0,columnName1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/vertices/deleteAll/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("serviceName", encodeURIComponent(serviceName0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("columnName", encodeURIComponent(columnName1))})
        }
      """
    )
  
    // @LINE:52
    def insertsSimple: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.VertexController.insertsSimple",
      """
        function(serviceName0,columnName1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/vertices/insert/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("serviceName", encodeURIComponent(serviceName0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("columnName", encodeURIComponent(columnName1))})
        }
      """
    )
  
    // @LINE:51
    def insertsWithWait: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.VertexController.insertsWithWait",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/vertices/insertWithWait"})
        }
      """
    )
  
    // @LINE:53
    def deletes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.VertexController.deletes",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/vertices/delete"})
        }
      """
    )
  
    // @LINE:50
    def inserts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.VertexController.inserts",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/vertices/insert"})
        }
      """
    )
  
    // @LINE:55
    def deletesSimple: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "org.apache.s2graph.rest.play.controllers.VertexController.deletesSimple",
      """
        function(serviceName0,columnName1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "graphs/vertices/delete/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("serviceName", encodeURIComponent(serviceName0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("columnName", encodeURIComponent(columnName1))})
        }
      """
    )
  
  }


}
