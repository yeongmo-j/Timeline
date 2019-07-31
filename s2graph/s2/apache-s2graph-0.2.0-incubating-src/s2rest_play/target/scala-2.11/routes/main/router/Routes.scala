
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yeongmo/Documents/Programming/timeline/s2graph/s2/apache-s2graph-0.2.0-incubating-src/s2rest_play/conf/routes
// @DATE:Tue Jul 23 20:57:14 KST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

object Routes extends Routes

class Routes extends GeneratedRouter {

  import ReverseRouteContext.empty

  override val errorHandler: play.api.http.HttpErrorHandler = play.api.http.LazyHttpErrorHandler

  private var _prefix = "/"

  def withPrefix(prefix: String): Routes = {
    _prefix = prefix
    router.RoutesPrefix.setPrefix(prefix)
    
    this
  }

  def prefix: String = _prefix

  lazy val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation: Seq[(String, String, String)] = List(
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """publishOnly/""" + "$" + """topic<[^/]+>""", """org.apache.s2graph.rest.play.controllers.PublishController.publishOnly(topic:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """health_check.html""", """org.apache.s2graph.rest.play.controllers.ApplicationController.healthCheck()"""),
    ("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """health_check/""" + "$" + """isHealthy<[^/]+>""", """org.apache.s2graph.rest.play.controllers.ApplicationController.updateHealthCheck(isHealthy:Boolean)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/edges/insert""", """org.apache.s2graph.rest.play.controllers.EdgeController.inserts()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/edges/insertWithWait""", """org.apache.s2graph.rest.play.controllers.EdgeController.insertsWithWait()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/edges/insertBulk""", """org.apache.s2graph.rest.play.controllers.EdgeController.insertsBulk()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/edges/delete""", """org.apache.s2graph.rest.play.controllers.EdgeController.deletes()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/edges/deleteWithWait""", """org.apache.s2graph.rest.play.controllers.EdgeController.deletesWithWait()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/edges/deleteAll""", """org.apache.s2graph.rest.play.controllers.EdgeController.deleteAll()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/edges/deleteAllWithOutWait""", """org.apache.s2graph.rest.play.controllers.EdgeController.deleteAllWithOutWait()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/edges/update""", """org.apache.s2graph.rest.play.controllers.EdgeController.updates()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/edges/updateWithWait""", """org.apache.s2graph.rest.play.controllers.EdgeController.updatesWithWait()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/edges/increment""", """org.apache.s2graph.rest.play.controllers.EdgeController.increments()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/edges/incrementWithWait""", """org.apache.s2graph.rest.play.controllers.EdgeController.incrementsWithWait()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/edges/incrementCount""", """org.apache.s2graph.rest.play.controllers.EdgeController.incrementCounts()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/edges/bulk""", """org.apache.s2graph.rest.play.controllers.EdgeController.mutateBulk()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/edges/bulkWithWait""", """org.apache.s2graph.rest.play.controllers.EdgeController.mutateBulkWithWait()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/vertices/insert""", """org.apache.s2graph.rest.play.controllers.VertexController.inserts()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/vertices/insertWithWait""", """org.apache.s2graph.rest.play.controllers.VertexController.insertsWithWait()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/vertices/insert/""" + "$" + """serviceName<[^/]+>/""" + "$" + """columnName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.VertexController.insertsSimple(serviceName:String, columnName:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/vertices/delete""", """org.apache.s2graph.rest.play.controllers.VertexController.deletes()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/vertices/deleteWithWait""", """org.apache.s2graph.rest.play.controllers.VertexController.deletesWithWait()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/vertices/delete/""" + "$" + """serviceName<[^/]+>/""" + "$" + """columnName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.VertexController.deletesSimple(serviceName:String, columnName:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/vertices/deleteAll""", """org.apache.s2graph.rest.play.controllers.VertexController.deletesAll()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/vertices/deleteAll/""" + "$" + """serviceName<[^/]+>/""" + "$" + """columnName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.VertexController.deletesAllSimple(serviceName:String, columnName:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/getEdges""", """org.apache.s2graph.rest.play.controllers.QueryController.getEdges()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/getEdges/grouped""", """org.apache.s2graph.rest.play.controllers.QueryController.getEdgesWithGrouping()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/getEdgesExcluded""", """org.apache.s2graph.rest.play.controllers.QueryController.getEdgesExcluded()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/getEdgesExcluded/grouped""", """org.apache.s2graph.rest.play.controllers.QueryController.getEdgesExcludedWithGrouping()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/checkEdges""", """org.apache.s2graph.rest.play.controllers.QueryController.checkEdges()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/getEdgesGrouped""", """org.apache.s2graph.rest.play.controllers.QueryController.getEdgesGrouped()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/getEdgesGroupedExcluded""", """org.apache.s2graph.rest.play.controllers.QueryController.getEdgesGroupedExcluded()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/getEdgesGroupedExcludedFormatted""", """org.apache.s2graph.rest.play.controllers.QueryController.getEdgesGroupedExcludedFormatted()"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/getEdge/""" + "$" + """srcId<[^/]+>/""" + "$" + """tgtId<[^/]+>/""" + "$" + """labelName<[^/]+>/""" + "$" + """direction<[^/]+>""", """org.apache.s2graph.rest.play.controllers.QueryController.getEdge(srcId:String, tgtId:String, labelName:String, direction:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/getVertices""", """org.apache.s2graph.rest.play.controllers.QueryController.getVertices()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/createService""", """org.apache.s2graph.rest.play.controllers.AdminController.createService()"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/getService/""" + "$" + """serviceName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.AdminController.getService(serviceName:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/getLabels/""" + "$" + """serviceName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.AdminController.getLabels(serviceName:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/createLabel""", """org.apache.s2graph.rest.play.controllers.AdminController.createLabel()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/addIndex""", """org.apache.s2graph.rest.play.controllers.AdminController.addIndex()"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/getLabel/""" + "$" + """labelName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.AdminController.getLabel(labelName:String)"""),
    ("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/deleteLabelReally/""" + "$" + """labelName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.AdminController.deleteLabel(labelName:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/addProp/""" + "$" + """labelName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.AdminController.addProp(labelName:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/createServiceColumn""", """org.apache.s2graph.rest.play.controllers.AdminController.createServiceColumn()"""),
    ("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/deleteServiceColumn/""" + "$" + """serviceName<[^/]+>/""" + "$" + """columnName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.AdminController.deleteServiceColumn(serviceName:String, columnName:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/addServiceColumnProp/""" + "$" + """serviceName<[^/]+>/""" + "$" + """columnName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.AdminController.addServiceColumnProp(serviceName:String, columnName:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/addServiceColumnProps/""" + "$" + """serviceName<[^/]+>/""" + "$" + """columnName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.AdminController.addServiceColumnProps(serviceName:String, columnName:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/getServiceColumn/""" + "$" + """serviceName<[^/]+>/""" + "$" + """columnName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.AdminController.getServiceColumn(serviceName:String, columnName:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/createHTable""", """org.apache.s2graph.rest.play.controllers.AdminController.createHTable()"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/labels/""" + "$" + """serviceName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.AdminController.getLabels(serviceName:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/copyLabel/""" + "$" + """oldLabelName<[^/]+>/""" + "$" + """newLabelName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.AdminController.copyLabel(oldLabelName:String, newLabelName:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/renameLabel/""" + "$" + """oldLabelName<[^/]+>/""" + "$" + """newLabelName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.AdminController.renameLabel(oldLabelName:String, newLabelName:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/swapLabels/""" + "$" + """leftLabelName<[^/]+>/""" + "$" + """rightLabelName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.AdminController.swapLabels(leftLabelName:String, rightLabelName:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/updateHTable/""" + "$" + """labelName<[^/]+>/""" + "$" + """newHTableName<[^/]+>""", """org.apache.s2graph.rest.play.controllers.AdminController.updateHTable(labelName:String, newHTableName:String)"""),
    ("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/loadCache""", """org.apache.s2graph.rest.play.controllers.AdminController.loadCache()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>""", """org.apache.s2graph.rest.play.controllers.CounterController.createAction(service:String, action:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>""", """org.apache.s2graph.rest.play.controllers.CounterController.getAction(service:String, action:String)"""),
    ("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>""", """org.apache.s2graph.rest.play.controllers.CounterController.updateAction(service:String, action:String)"""),
    ("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>/prepare""", """org.apache.s2graph.rest.play.controllers.CounterController.prepareAction(service:String, action:String)"""),
    ("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>""", """org.apache.s2graph.rest.play.controllers.CounterController.deleteAction(service:String, action:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>/ranking""", """org.apache.s2graph.rest.play.controllers.CounterController.getRankingCountAsync(service:String, action:String)"""),
    ("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>/ranking""", """org.apache.s2graph.rest.play.controllers.CounterController.deleteRankingCount(service:String, action:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>/""" + "$" + """item<[^/]+>""", """org.apache.s2graph.rest.play.controllers.CounterController.getExactCountAsync(service:String, action:String, item:String)"""),
    ("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>/""" + "$" + """item<[^/]+>""", """org.apache.s2graph.rest.play.controllers.CounterController.incrementCount(service:String, action:String, item:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """counter/v1/mget""", """org.apache.s2graph.rest.play.controllers.CounterController.getExactCountAsyncMulti()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/experiment/""" + "$" + """accessToken<[^/]+>/""" + "$" + """experimentName<[^/]+>/""" + "$" + """uuid<[^/]+>""", """org.apache.s2graph.rest.play.controllers.ExperimentController.experiment(accessToken:String, experimentName:String, uuid:String)"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graphs/experiments""", """org.apache.s2graph.rest.play.controllers.ExperimentController.experiments()"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """images/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public/images", file:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """javascripts/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public/javascripts", file:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """stylesheets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public/stylesheets", file:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """font-awesome-4.1.0/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public/font-awesome-4.1.0", file:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """swagger/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public/swagger-ui", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:27
  private[this] lazy val org_apache_s2graph_rest_play_controllers_PublishController_publishOnly0_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("publishOnly/"), DynamicPart("topic", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_PublishController_publishOnly0_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.PublishController.publishOnly(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.PublishController",
      "publishOnly",
      Seq(classOf[String]),
      "POST",
      """ publish
POST        /publish/:topic                                               org.apache.s2graph.rest.play.controllers.PublishController.mutateBulk(topic)""",
      this.prefix + """publishOnly/""" + "$" + """topic<[^/]+>"""
    )
  )

  // @LINE:30
  private[this] lazy val org_apache_s2graph_rest_play_controllers_ApplicationController_healthCheck1_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("health_check.html")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_ApplicationController_healthCheck1_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.ApplicationController.healthCheck(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.ApplicationController",
      "healthCheck",
      Nil,
      "GET",
      """### Health Check""",
      this.prefix + """health_check.html"""
    )
  )

  // @LINE:31
  private[this] lazy val org_apache_s2graph_rest_play_controllers_ApplicationController_updateHealthCheck2_route: Route.ParamsExtractor = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("health_check/"), DynamicPart("isHealthy", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_ApplicationController_updateHealthCheck2_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.ApplicationController.updateHealthCheck(fakeValue[Boolean]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.ApplicationController",
      "updateHealthCheck",
      Seq(classOf[Boolean]),
      "PUT",
      """""",
      this.prefix + """health_check/""" + "$" + """isHealthy<[^/]+>"""
    )
  )

  // @LINE:34
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_inserts3_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/edges/insert")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_inserts3_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.EdgeController.inserts(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.EdgeController",
      "inserts",
      Nil,
      "POST",
      """# Edge""",
      this.prefix + """graphs/edges/insert"""
    )
  )

  // @LINE:35
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_insertsWithWait4_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/edges/insertWithWait")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_insertsWithWait4_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.EdgeController.insertsWithWait(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.EdgeController",
      "insertsWithWait",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/edges/insertWithWait"""
    )
  )

  // @LINE:36
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_insertsBulk5_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/edges/insertBulk")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_insertsBulk5_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.EdgeController.insertsBulk(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.EdgeController",
      "insertsBulk",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/edges/insertBulk"""
    )
  )

  // @LINE:37
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_deletes6_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/edges/delete")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_deletes6_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.EdgeController.deletes(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.EdgeController",
      "deletes",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/edges/delete"""
    )
  )

  // @LINE:38
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_deletesWithWait7_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/edges/deleteWithWait")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_deletesWithWait7_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.EdgeController.deletesWithWait(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.EdgeController",
      "deletesWithWait",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/edges/deleteWithWait"""
    )
  )

  // @LINE:39
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_deleteAll8_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/edges/deleteAll")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_deleteAll8_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.EdgeController.deleteAll(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.EdgeController",
      "deleteAll",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/edges/deleteAll"""
    )
  )

  // @LINE:40
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_deleteAllWithOutWait9_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/edges/deleteAllWithOutWait")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_deleteAllWithOutWait9_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.EdgeController.deleteAllWithOutWait(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.EdgeController",
      "deleteAllWithOutWait",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/edges/deleteAllWithOutWait"""
    )
  )

  // @LINE:41
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_updates10_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/edges/update")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_updates10_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.EdgeController.updates(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.EdgeController",
      "updates",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/edges/update"""
    )
  )

  // @LINE:42
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_updatesWithWait11_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/edges/updateWithWait")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_updatesWithWait11_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.EdgeController.updatesWithWait(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.EdgeController",
      "updatesWithWait",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/edges/updateWithWait"""
    )
  )

  // @LINE:43
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_increments12_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/edges/increment")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_increments12_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.EdgeController.increments(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.EdgeController",
      "increments",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/edges/increment"""
    )
  )

  // @LINE:44
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_incrementsWithWait13_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/edges/incrementWithWait")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_incrementsWithWait13_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.EdgeController.incrementsWithWait(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.EdgeController",
      "incrementsWithWait",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/edges/incrementWithWait"""
    )
  )

  // @LINE:45
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_incrementCounts14_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/edges/incrementCount")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_incrementCounts14_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.EdgeController.incrementCounts(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.EdgeController",
      "incrementCounts",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/edges/incrementCount"""
    )
  )

  // @LINE:46
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_mutateBulk15_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/edges/bulk")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_mutateBulk15_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.EdgeController.mutateBulk(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.EdgeController",
      "mutateBulk",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/edges/bulk"""
    )
  )

  // @LINE:47
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_mutateBulkWithWait16_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/edges/bulkWithWait")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_EdgeController_mutateBulkWithWait16_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.EdgeController.mutateBulkWithWait(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.EdgeController",
      "mutateBulkWithWait",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/edges/bulkWithWait"""
    )
  )

  // @LINE:50
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_inserts17_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/vertices/insert")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_inserts17_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.VertexController.inserts(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.VertexController",
      "inserts",
      Nil,
      "POST",
      """# Vertex""",
      this.prefix + """graphs/vertices/insert"""
    )
  )

  // @LINE:51
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_insertsWithWait18_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/vertices/insertWithWait")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_insertsWithWait18_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.VertexController.insertsWithWait(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.VertexController",
      "insertsWithWait",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/vertices/insertWithWait"""
    )
  )

  // @LINE:52
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_insertsSimple19_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/vertices/insert/"), DynamicPart("serviceName", """[^/]+""",true), StaticPart("/"), DynamicPart("columnName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_insertsSimple19_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.VertexController.insertsSimple(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.VertexController",
      "insertsSimple",
      Seq(classOf[String], classOf[String]),
      "POST",
      """""",
      this.prefix + """graphs/vertices/insert/""" + "$" + """serviceName<[^/]+>/""" + "$" + """columnName<[^/]+>"""
    )
  )

  // @LINE:53
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_deletes20_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/vertices/delete")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_deletes20_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.VertexController.deletes(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.VertexController",
      "deletes",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/vertices/delete"""
    )
  )

  // @LINE:54
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_deletesWithWait21_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/vertices/deleteWithWait")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_deletesWithWait21_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.VertexController.deletesWithWait(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.VertexController",
      "deletesWithWait",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/vertices/deleteWithWait"""
    )
  )

  // @LINE:55
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_deletesSimple22_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/vertices/delete/"), DynamicPart("serviceName", """[^/]+""",true), StaticPart("/"), DynamicPart("columnName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_deletesSimple22_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.VertexController.deletesSimple(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.VertexController",
      "deletesSimple",
      Seq(classOf[String], classOf[String]),
      "POST",
      """""",
      this.prefix + """graphs/vertices/delete/""" + "$" + """serviceName<[^/]+>/""" + "$" + """columnName<[^/]+>"""
    )
  )

  // @LINE:56
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_deletesAll23_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/vertices/deleteAll")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_deletesAll23_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.VertexController.deletesAll(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.VertexController",
      "deletesAll",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/vertices/deleteAll"""
    )
  )

  // @LINE:57
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_deletesAllSimple24_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/vertices/deleteAll/"), DynamicPart("serviceName", """[^/]+""",true), StaticPart("/"), DynamicPart("columnName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_VertexController_deletesAllSimple24_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.VertexController.deletesAllSimple(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.VertexController",
      "deletesAllSimple",
      Seq(classOf[String], classOf[String]),
      "POST",
      """""",
      this.prefix + """graphs/vertices/deleteAll/""" + "$" + """serviceName<[^/]+>/""" + "$" + """columnName<[^/]+>"""
    )
  )

  // @LINE:61
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdges25_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/getEdges")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdges25_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.QueryController.getEdges(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.QueryController",
      "getEdges",
      Nil,
      "POST",
      """## SELECT Edges""",
      this.prefix + """graphs/getEdges"""
    )
  )

  // @LINE:62
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdgesWithGrouping26_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/getEdges/grouped")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdgesWithGrouping26_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.QueryController.getEdgesWithGrouping(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.QueryController",
      "getEdgesWithGrouping",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/getEdges/grouped"""
    )
  )

  // @LINE:63
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdgesExcluded27_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/getEdgesExcluded")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdgesExcluded27_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.QueryController.getEdgesExcluded(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.QueryController",
      "getEdgesExcluded",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/getEdgesExcluded"""
    )
  )

  // @LINE:64
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdgesExcludedWithGrouping28_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/getEdgesExcluded/grouped")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdgesExcludedWithGrouping28_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.QueryController.getEdgesExcludedWithGrouping(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.QueryController",
      "getEdgesExcludedWithGrouping",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/getEdgesExcluded/grouped"""
    )
  )

  // @LINE:65
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_checkEdges29_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/checkEdges")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_checkEdges29_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.QueryController.checkEdges(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.QueryController",
      "checkEdges",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/checkEdges"""
    )
  )

  // @LINE:68
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdgesGrouped30_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/getEdgesGrouped")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdgesGrouped30_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.QueryController.getEdgesGrouped(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.QueryController",
      "getEdgesGrouped",
      Nil,
      "POST",
      """## this will be deprecated""",
      this.prefix + """graphs/getEdgesGrouped"""
    )
  )

  // @LINE:69
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdgesGroupedExcluded31_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/getEdgesGroupedExcluded")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdgesGroupedExcluded31_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.QueryController.getEdgesGroupedExcluded(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.QueryController",
      "getEdgesGroupedExcluded",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/getEdgesGroupedExcluded"""
    )
  )

  // @LINE:70
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdgesGroupedExcludedFormatted32_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/getEdgesGroupedExcludedFormatted")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdgesGroupedExcludedFormatted32_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.QueryController.getEdgesGroupedExcludedFormatted(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.QueryController",
      "getEdgesGroupedExcludedFormatted",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/getEdgesGroupedExcludedFormatted"""
    )
  )

  // @LINE:71
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdge33_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/getEdge/"), DynamicPart("srcId", """[^/]+""",true), StaticPart("/"), DynamicPart("tgtId", """[^/]+""",true), StaticPart("/"), DynamicPart("labelName", """[^/]+""",true), StaticPart("/"), DynamicPart("direction", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getEdge33_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.QueryController.getEdge(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.QueryController",
      "getEdge",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """graphs/getEdge/""" + "$" + """srcId<[^/]+>/""" + "$" + """tgtId<[^/]+>/""" + "$" + """labelName<[^/]+>/""" + "$" + """direction<[^/]+>"""
    )
  )

  // @LINE:75
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getVertices34_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/getVertices")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_QueryController_getVertices34_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.QueryController.getVertices(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.QueryController",
      "getVertices",
      Nil,
      "POST",
      """## SELECT Vertices""",
      this.prefix + """graphs/getVertices"""
    )
  )

  // @LINE:79
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_createService35_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/createService")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_createService35_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.createService(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "createService",
      Nil,
      "POST",
      """### ADMIN""",
      this.prefix + """graphs/createService"""
    )
  )

  // @LINE:80
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_getService36_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/getService/"), DynamicPart("serviceName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_getService36_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.getService(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "getService",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """graphs/getService/""" + "$" + """serviceName<[^/]+>"""
    )
  )

  // @LINE:81
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_getLabels37_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/getLabels/"), DynamicPart("serviceName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_getLabels37_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.getLabels(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "getLabels",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """graphs/getLabels/""" + "$" + """serviceName<[^/]+>"""
    )
  )

  // @LINE:82
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_createLabel38_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/createLabel")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_createLabel38_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.createLabel(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "createLabel",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/createLabel"""
    )
  )

  // @LINE:83
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_addIndex39_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/addIndex")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_addIndex39_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.addIndex(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "addIndex",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/addIndex"""
    )
  )

  // @LINE:84
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_getLabel40_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/getLabel/"), DynamicPart("labelName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_getLabel40_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.getLabel(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "getLabel",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """graphs/getLabel/""" + "$" + """labelName<[^/]+>"""
    )
  )

  // @LINE:85
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_deleteLabel41_route: Route.ParamsExtractor = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/deleteLabelReally/"), DynamicPart("labelName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_deleteLabel41_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.deleteLabel(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "deleteLabel",
      Seq(classOf[String]),
      "PUT",
      """""",
      this.prefix + """graphs/deleteLabelReally/""" + "$" + """labelName<[^/]+>"""
    )
  )

  // @LINE:87
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_addProp42_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/addProp/"), DynamicPart("labelName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_addProp42_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.addProp(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "addProp",
      Seq(classOf[String]),
      "POST",
      """""",
      this.prefix + """graphs/addProp/""" + "$" + """labelName<[^/]+>"""
    )
  )

  // @LINE:88
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_createServiceColumn43_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/createServiceColumn")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_createServiceColumn43_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.createServiceColumn(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "createServiceColumn",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/createServiceColumn"""
    )
  )

  // @LINE:89
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_deleteServiceColumn44_route: Route.ParamsExtractor = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/deleteServiceColumn/"), DynamicPart("serviceName", """[^/]+""",true), StaticPart("/"), DynamicPart("columnName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_deleteServiceColumn44_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.deleteServiceColumn(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "deleteServiceColumn",
      Seq(classOf[String], classOf[String]),
      "PUT",
      """""",
      this.prefix + """graphs/deleteServiceColumn/""" + "$" + """serviceName<[^/]+>/""" + "$" + """columnName<[^/]+>"""
    )
  )

  // @LINE:90
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_addServiceColumnProp45_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/addServiceColumnProp/"), DynamicPart("serviceName", """[^/]+""",true), StaticPart("/"), DynamicPart("columnName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_addServiceColumnProp45_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.addServiceColumnProp(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "addServiceColumnProp",
      Seq(classOf[String], classOf[String]),
      "POST",
      """""",
      this.prefix + """graphs/addServiceColumnProp/""" + "$" + """serviceName<[^/]+>/""" + "$" + """columnName<[^/]+>"""
    )
  )

  // @LINE:91
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_addServiceColumnProps46_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/addServiceColumnProps/"), DynamicPart("serviceName", """[^/]+""",true), StaticPart("/"), DynamicPart("columnName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_addServiceColumnProps46_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.addServiceColumnProps(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "addServiceColumnProps",
      Seq(classOf[String], classOf[String]),
      "POST",
      """""",
      this.prefix + """graphs/addServiceColumnProps/""" + "$" + """serviceName<[^/]+>/""" + "$" + """columnName<[^/]+>"""
    )
  )

  // @LINE:92
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_getServiceColumn47_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/getServiceColumn/"), DynamicPart("serviceName", """[^/]+""",true), StaticPart("/"), DynamicPart("columnName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_getServiceColumn47_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.getServiceColumn(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "getServiceColumn",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """graphs/getServiceColumn/""" + "$" + """serviceName<[^/]+>/""" + "$" + """columnName<[^/]+>"""
    )
  )

  // @LINE:93
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_createHTable48_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/createHTable")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_createHTable48_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.createHTable(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "createHTable",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/createHTable"""
    )
  )

  // @LINE:97
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_getLabels49_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/labels/"), DynamicPart("serviceName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_getLabels49_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.getLabels(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "getLabels",
      Seq(classOf[String]),
      "GET",
      """ AdminController API""",
      this.prefix + """admin/labels/""" + "$" + """serviceName<[^/]+>"""
    )
  )

  // @LINE:98
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_copyLabel50_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/copyLabel/"), DynamicPart("oldLabelName", """[^/]+""",true), StaticPart("/"), DynamicPart("newLabelName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_copyLabel50_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.copyLabel(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "copyLabel",
      Seq(classOf[String], classOf[String]),
      "POST",
      """""",
      this.prefix + """graphs/copyLabel/""" + "$" + """oldLabelName<[^/]+>/""" + "$" + """newLabelName<[^/]+>"""
    )
  )

  // @LINE:99
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_renameLabel51_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/renameLabel/"), DynamicPart("oldLabelName", """[^/]+""",true), StaticPart("/"), DynamicPart("newLabelName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_renameLabel51_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.renameLabel(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "renameLabel",
      Seq(classOf[String], classOf[String]),
      "POST",
      """""",
      this.prefix + """graphs/renameLabel/""" + "$" + """oldLabelName<[^/]+>/""" + "$" + """newLabelName<[^/]+>"""
    )
  )

  // @LINE:100
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_swapLabels52_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/swapLabels/"), DynamicPart("leftLabelName", """[^/]+""",true), StaticPart("/"), DynamicPart("rightLabelName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_swapLabels52_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.swapLabels(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "swapLabels",
      Seq(classOf[String], classOf[String]),
      "POST",
      """""",
      this.prefix + """graphs/swapLabels/""" + "$" + """leftLabelName<[^/]+>/""" + "$" + """rightLabelName<[^/]+>"""
    )
  )

  // @LINE:101
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_updateHTable53_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/updateHTable/"), DynamicPart("labelName", """[^/]+""",true), StaticPart("/"), DynamicPart("newHTableName", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_updateHTable53_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.updateHTable(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "updateHTable",
      Seq(classOf[String], classOf[String]),
      "POST",
      """""",
      this.prefix + """graphs/updateHTable/""" + "$" + """labelName<[^/]+>/""" + "$" + """newHTableName<[^/]+>"""
    )
  )

  // @LINE:102
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_loadCache54_route: Route.ParamsExtractor = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/loadCache")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_AdminController_loadCache54_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.AdminController.loadCache(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.AdminController",
      "loadCache",
      Nil,
      "PUT",
      """""",
      this.prefix + """graphs/loadCache"""
    )
  )

  // @LINE:106
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_createAction55_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("counter/v1/"), DynamicPart("service", """[^/]+""",true), StaticPart("/"), DynamicPart("action", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_createAction55_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.CounterController.createAction(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.CounterController",
      "createAction",
      Seq(classOf[String], classOf[String]),
      "POST",
      """ Counter Admin API""",
      this.prefix + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>"""
    )
  )

  // @LINE:107
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_getAction56_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("counter/v1/"), DynamicPart("service", """[^/]+""",true), StaticPart("/"), DynamicPart("action", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_getAction56_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.CounterController.getAction(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.CounterController",
      "getAction",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>"""
    )
  )

  // @LINE:108
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_updateAction57_route: Route.ParamsExtractor = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("counter/v1/"), DynamicPart("service", """[^/]+""",true), StaticPart("/"), DynamicPart("action", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_updateAction57_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.CounterController.updateAction(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.CounterController",
      "updateAction",
      Seq(classOf[String], classOf[String]),
      "PUT",
      """""",
      this.prefix + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>"""
    )
  )

  // @LINE:109
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_prepareAction58_route: Route.ParamsExtractor = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("counter/v1/"), DynamicPart("service", """[^/]+""",true), StaticPart("/"), DynamicPart("action", """[^/]+""",true), StaticPart("/prepare")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_prepareAction58_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.CounterController.prepareAction(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.CounterController",
      "prepareAction",
      Seq(classOf[String], classOf[String]),
      "PUT",
      """""",
      this.prefix + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>/prepare"""
    )
  )

  // @LINE:110
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_deleteAction59_route: Route.ParamsExtractor = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("counter/v1/"), DynamicPart("service", """[^/]+""",true), StaticPart("/"), DynamicPart("action", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_deleteAction59_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.CounterController.deleteAction(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.CounterController",
      "deleteAction",
      Seq(classOf[String], classOf[String]),
      "DELETE",
      """""",
      this.prefix + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>"""
    )
  )

  // @LINE:113
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_getRankingCountAsync60_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("counter/v1/"), DynamicPart("service", """[^/]+""",true), StaticPart("/"), DynamicPart("action", """[^/]+""",true), StaticPart("/ranking")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_getRankingCountAsync60_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.CounterController.getRankingCountAsync(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.CounterController",
      "getRankingCountAsync",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Counter API""",
      this.prefix + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>/ranking"""
    )
  )

  // @LINE:114
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_deleteRankingCount61_route: Route.ParamsExtractor = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("counter/v1/"), DynamicPart("service", """[^/]+""",true), StaticPart("/"), DynamicPart("action", """[^/]+""",true), StaticPart("/ranking")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_deleteRankingCount61_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.CounterController.deleteRankingCount(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.CounterController",
      "deleteRankingCount",
      Seq(classOf[String], classOf[String]),
      "DELETE",
      """""",
      this.prefix + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>/ranking"""
    )
  )

  // @LINE:115
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_getExactCountAsync62_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("counter/v1/"), DynamicPart("service", """[^/]+""",true), StaticPart("/"), DynamicPart("action", """[^/]+""",true), StaticPart("/"), DynamicPart("item", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_getExactCountAsync62_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.CounterController.getExactCountAsync(fakeValue[String], fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.CounterController",
      "getExactCountAsync",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>/""" + "$" + """item<[^/]+>"""
    )
  )

  // @LINE:116
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_incrementCount63_route: Route.ParamsExtractor = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("counter/v1/"), DynamicPart("service", """[^/]+""",true), StaticPart("/"), DynamicPart("action", """[^/]+""",true), StaticPart("/"), DynamicPart("item", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_incrementCount63_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.CounterController.incrementCount(fakeValue[String], fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.CounterController",
      "incrementCount",
      Seq(classOf[String], classOf[String], classOf[String]),
      "PUT",
      """""",
      this.prefix + """counter/v1/""" + "$" + """service<[^/]+>/""" + "$" + """action<[^/]+>/""" + "$" + """item<[^/]+>"""
    )
  )

  // @LINE:117
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_getExactCountAsyncMulti64_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("counter/v1/mget")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_CounterController_getExactCountAsyncMulti64_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.CounterController.getExactCountAsyncMulti(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.CounterController",
      "getExactCountAsyncMulti",
      Nil,
      "POST",
      """""",
      this.prefix + """counter/v1/mget"""
    )
  )

  // @LINE:120
  private[this] lazy val org_apache_s2graph_rest_play_controllers_ExperimentController_experiment65_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/experiment/"), DynamicPart("accessToken", """[^/]+""",true), StaticPart("/"), DynamicPart("experimentName", """[^/]+""",true), StaticPart("/"), DynamicPart("uuid", """[^/]+""",true)))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_ExperimentController_experiment65_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.ExperimentController.experiment(fakeValue[String], fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.ExperimentController",
      "experiment",
      Seq(classOf[String], classOf[String], classOf[String]),
      "POST",
      """ Experiment API""",
      this.prefix + """graphs/experiment/""" + "$" + """accessToken<[^/]+>/""" + "$" + """experimentName<[^/]+>/""" + "$" + """uuid<[^/]+>"""
    )
  )

  // @LINE:121
  private[this] lazy val org_apache_s2graph_rest_play_controllers_ExperimentController_experiments66_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("graphs/experiments")))
  )
  private[this] lazy val org_apache_s2graph_rest_play_controllers_ExperimentController_experiments66_invoker = createInvoker(
    org.apache.s2graph.rest.play.controllers.ExperimentController.experiments(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "org.apache.s2graph.rest.play.controllers.ExperimentController",
      "experiments",
      Nil,
      "POST",
      """""",
      this.prefix + """graphs/experiments"""
    )
  )

  // @LINE:124
  private[this] lazy val controllers_Assets_at67_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("images/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at67_invoker = createInvoker(
    controllers.Assets.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """images/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:125
  private[this] lazy val controllers_Assets_at68_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("javascripts/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at68_invoker = createInvoker(
    controllers.Assets.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """javascripts/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:126
  private[this] lazy val controllers_Assets_at69_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("stylesheets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at69_invoker = createInvoker(
    controllers.Assets.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """stylesheets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:127
  private[this] lazy val controllers_Assets_at70_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("font-awesome-4.1.0/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at70_invoker = createInvoker(
    controllers.Assets.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """font-awesome-4.1.0/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:128
  private[this] lazy val controllers_Assets_at71_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("swagger/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at71_invoker = createInvoker(
    controllers.Assets.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """swagger/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:27
    case org_apache_s2graph_rest_play_controllers_PublishController_publishOnly0_route(params) =>
      call(params.fromPath[String]("topic", None)) { (topic) =>
        org_apache_s2graph_rest_play_controllers_PublishController_publishOnly0_invoker.call(org.apache.s2graph.rest.play.controllers.PublishController.publishOnly(topic))
      }
  
    // @LINE:30
    case org_apache_s2graph_rest_play_controllers_ApplicationController_healthCheck1_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_ApplicationController_healthCheck1_invoker.call(org.apache.s2graph.rest.play.controllers.ApplicationController.healthCheck())
      }
  
    // @LINE:31
    case org_apache_s2graph_rest_play_controllers_ApplicationController_updateHealthCheck2_route(params) =>
      call(params.fromPath[Boolean]("isHealthy", None)) { (isHealthy) =>
        org_apache_s2graph_rest_play_controllers_ApplicationController_updateHealthCheck2_invoker.call(org.apache.s2graph.rest.play.controllers.ApplicationController.updateHealthCheck(isHealthy))
      }
  
    // @LINE:34
    case org_apache_s2graph_rest_play_controllers_EdgeController_inserts3_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_EdgeController_inserts3_invoker.call(org.apache.s2graph.rest.play.controllers.EdgeController.inserts())
      }
  
    // @LINE:35
    case org_apache_s2graph_rest_play_controllers_EdgeController_insertsWithWait4_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_EdgeController_insertsWithWait4_invoker.call(org.apache.s2graph.rest.play.controllers.EdgeController.insertsWithWait())
      }
  
    // @LINE:36
    case org_apache_s2graph_rest_play_controllers_EdgeController_insertsBulk5_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_EdgeController_insertsBulk5_invoker.call(org.apache.s2graph.rest.play.controllers.EdgeController.insertsBulk())
      }
  
    // @LINE:37
    case org_apache_s2graph_rest_play_controllers_EdgeController_deletes6_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_EdgeController_deletes6_invoker.call(org.apache.s2graph.rest.play.controllers.EdgeController.deletes())
      }
  
    // @LINE:38
    case org_apache_s2graph_rest_play_controllers_EdgeController_deletesWithWait7_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_EdgeController_deletesWithWait7_invoker.call(org.apache.s2graph.rest.play.controllers.EdgeController.deletesWithWait())
      }
  
    // @LINE:39
    case org_apache_s2graph_rest_play_controllers_EdgeController_deleteAll8_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_EdgeController_deleteAll8_invoker.call(org.apache.s2graph.rest.play.controllers.EdgeController.deleteAll())
      }
  
    // @LINE:40
    case org_apache_s2graph_rest_play_controllers_EdgeController_deleteAllWithOutWait9_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_EdgeController_deleteAllWithOutWait9_invoker.call(org.apache.s2graph.rest.play.controllers.EdgeController.deleteAllWithOutWait())
      }
  
    // @LINE:41
    case org_apache_s2graph_rest_play_controllers_EdgeController_updates10_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_EdgeController_updates10_invoker.call(org.apache.s2graph.rest.play.controllers.EdgeController.updates())
      }
  
    // @LINE:42
    case org_apache_s2graph_rest_play_controllers_EdgeController_updatesWithWait11_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_EdgeController_updatesWithWait11_invoker.call(org.apache.s2graph.rest.play.controllers.EdgeController.updatesWithWait())
      }
  
    // @LINE:43
    case org_apache_s2graph_rest_play_controllers_EdgeController_increments12_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_EdgeController_increments12_invoker.call(org.apache.s2graph.rest.play.controllers.EdgeController.increments())
      }
  
    // @LINE:44
    case org_apache_s2graph_rest_play_controllers_EdgeController_incrementsWithWait13_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_EdgeController_incrementsWithWait13_invoker.call(org.apache.s2graph.rest.play.controllers.EdgeController.incrementsWithWait())
      }
  
    // @LINE:45
    case org_apache_s2graph_rest_play_controllers_EdgeController_incrementCounts14_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_EdgeController_incrementCounts14_invoker.call(org.apache.s2graph.rest.play.controllers.EdgeController.incrementCounts())
      }
  
    // @LINE:46
    case org_apache_s2graph_rest_play_controllers_EdgeController_mutateBulk15_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_EdgeController_mutateBulk15_invoker.call(org.apache.s2graph.rest.play.controllers.EdgeController.mutateBulk())
      }
  
    // @LINE:47
    case org_apache_s2graph_rest_play_controllers_EdgeController_mutateBulkWithWait16_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_EdgeController_mutateBulkWithWait16_invoker.call(org.apache.s2graph.rest.play.controllers.EdgeController.mutateBulkWithWait())
      }
  
    // @LINE:50
    case org_apache_s2graph_rest_play_controllers_VertexController_inserts17_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_VertexController_inserts17_invoker.call(org.apache.s2graph.rest.play.controllers.VertexController.inserts())
      }
  
    // @LINE:51
    case org_apache_s2graph_rest_play_controllers_VertexController_insertsWithWait18_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_VertexController_insertsWithWait18_invoker.call(org.apache.s2graph.rest.play.controllers.VertexController.insertsWithWait())
      }
  
    // @LINE:52
    case org_apache_s2graph_rest_play_controllers_VertexController_insertsSimple19_route(params) =>
      call(params.fromPath[String]("serviceName", None), params.fromPath[String]("columnName", None)) { (serviceName, columnName) =>
        org_apache_s2graph_rest_play_controllers_VertexController_insertsSimple19_invoker.call(org.apache.s2graph.rest.play.controllers.VertexController.insertsSimple(serviceName, columnName))
      }
  
    // @LINE:53
    case org_apache_s2graph_rest_play_controllers_VertexController_deletes20_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_VertexController_deletes20_invoker.call(org.apache.s2graph.rest.play.controllers.VertexController.deletes())
      }
  
    // @LINE:54
    case org_apache_s2graph_rest_play_controllers_VertexController_deletesWithWait21_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_VertexController_deletesWithWait21_invoker.call(org.apache.s2graph.rest.play.controllers.VertexController.deletesWithWait())
      }
  
    // @LINE:55
    case org_apache_s2graph_rest_play_controllers_VertexController_deletesSimple22_route(params) =>
      call(params.fromPath[String]("serviceName", None), params.fromPath[String]("columnName", None)) { (serviceName, columnName) =>
        org_apache_s2graph_rest_play_controllers_VertexController_deletesSimple22_invoker.call(org.apache.s2graph.rest.play.controllers.VertexController.deletesSimple(serviceName, columnName))
      }
  
    // @LINE:56
    case org_apache_s2graph_rest_play_controllers_VertexController_deletesAll23_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_VertexController_deletesAll23_invoker.call(org.apache.s2graph.rest.play.controllers.VertexController.deletesAll())
      }
  
    // @LINE:57
    case org_apache_s2graph_rest_play_controllers_VertexController_deletesAllSimple24_route(params) =>
      call(params.fromPath[String]("serviceName", None), params.fromPath[String]("columnName", None)) { (serviceName, columnName) =>
        org_apache_s2graph_rest_play_controllers_VertexController_deletesAllSimple24_invoker.call(org.apache.s2graph.rest.play.controllers.VertexController.deletesAllSimple(serviceName, columnName))
      }
  
    // @LINE:61
    case org_apache_s2graph_rest_play_controllers_QueryController_getEdges25_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_QueryController_getEdges25_invoker.call(org.apache.s2graph.rest.play.controllers.QueryController.getEdges())
      }
  
    // @LINE:62
    case org_apache_s2graph_rest_play_controllers_QueryController_getEdgesWithGrouping26_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_QueryController_getEdgesWithGrouping26_invoker.call(org.apache.s2graph.rest.play.controllers.QueryController.getEdgesWithGrouping())
      }
  
    // @LINE:63
    case org_apache_s2graph_rest_play_controllers_QueryController_getEdgesExcluded27_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_QueryController_getEdgesExcluded27_invoker.call(org.apache.s2graph.rest.play.controllers.QueryController.getEdgesExcluded())
      }
  
    // @LINE:64
    case org_apache_s2graph_rest_play_controllers_QueryController_getEdgesExcludedWithGrouping28_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_QueryController_getEdgesExcludedWithGrouping28_invoker.call(org.apache.s2graph.rest.play.controllers.QueryController.getEdgesExcludedWithGrouping())
      }
  
    // @LINE:65
    case org_apache_s2graph_rest_play_controllers_QueryController_checkEdges29_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_QueryController_checkEdges29_invoker.call(org.apache.s2graph.rest.play.controllers.QueryController.checkEdges())
      }
  
    // @LINE:68
    case org_apache_s2graph_rest_play_controllers_QueryController_getEdgesGrouped30_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_QueryController_getEdgesGrouped30_invoker.call(org.apache.s2graph.rest.play.controllers.QueryController.getEdgesGrouped())
      }
  
    // @LINE:69
    case org_apache_s2graph_rest_play_controllers_QueryController_getEdgesGroupedExcluded31_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_QueryController_getEdgesGroupedExcluded31_invoker.call(org.apache.s2graph.rest.play.controllers.QueryController.getEdgesGroupedExcluded())
      }
  
    // @LINE:70
    case org_apache_s2graph_rest_play_controllers_QueryController_getEdgesGroupedExcludedFormatted32_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_QueryController_getEdgesGroupedExcludedFormatted32_invoker.call(org.apache.s2graph.rest.play.controllers.QueryController.getEdgesGroupedExcludedFormatted())
      }
  
    // @LINE:71
    case org_apache_s2graph_rest_play_controllers_QueryController_getEdge33_route(params) =>
      call(params.fromPath[String]("srcId", None), params.fromPath[String]("tgtId", None), params.fromPath[String]("labelName", None), params.fromPath[String]("direction", None)) { (srcId, tgtId, labelName, direction) =>
        org_apache_s2graph_rest_play_controllers_QueryController_getEdge33_invoker.call(org.apache.s2graph.rest.play.controllers.QueryController.getEdge(srcId, tgtId, labelName, direction))
      }
  
    // @LINE:75
    case org_apache_s2graph_rest_play_controllers_QueryController_getVertices34_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_QueryController_getVertices34_invoker.call(org.apache.s2graph.rest.play.controllers.QueryController.getVertices())
      }
  
    // @LINE:79
    case org_apache_s2graph_rest_play_controllers_AdminController_createService35_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_AdminController_createService35_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.createService())
      }
  
    // @LINE:80
    case org_apache_s2graph_rest_play_controllers_AdminController_getService36_route(params) =>
      call(params.fromPath[String]("serviceName", None)) { (serviceName) =>
        org_apache_s2graph_rest_play_controllers_AdminController_getService36_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.getService(serviceName))
      }
  
    // @LINE:81
    case org_apache_s2graph_rest_play_controllers_AdminController_getLabels37_route(params) =>
      call(params.fromPath[String]("serviceName", None)) { (serviceName) =>
        org_apache_s2graph_rest_play_controllers_AdminController_getLabels37_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.getLabels(serviceName))
      }
  
    // @LINE:82
    case org_apache_s2graph_rest_play_controllers_AdminController_createLabel38_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_AdminController_createLabel38_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.createLabel())
      }
  
    // @LINE:83
    case org_apache_s2graph_rest_play_controllers_AdminController_addIndex39_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_AdminController_addIndex39_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.addIndex())
      }
  
    // @LINE:84
    case org_apache_s2graph_rest_play_controllers_AdminController_getLabel40_route(params) =>
      call(params.fromPath[String]("labelName", None)) { (labelName) =>
        org_apache_s2graph_rest_play_controllers_AdminController_getLabel40_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.getLabel(labelName))
      }
  
    // @LINE:85
    case org_apache_s2graph_rest_play_controllers_AdminController_deleteLabel41_route(params) =>
      call(params.fromPath[String]("labelName", None)) { (labelName) =>
        org_apache_s2graph_rest_play_controllers_AdminController_deleteLabel41_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.deleteLabel(labelName))
      }
  
    // @LINE:87
    case org_apache_s2graph_rest_play_controllers_AdminController_addProp42_route(params) =>
      call(params.fromPath[String]("labelName", None)) { (labelName) =>
        org_apache_s2graph_rest_play_controllers_AdminController_addProp42_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.addProp(labelName))
      }
  
    // @LINE:88
    case org_apache_s2graph_rest_play_controllers_AdminController_createServiceColumn43_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_AdminController_createServiceColumn43_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.createServiceColumn())
      }
  
    // @LINE:89
    case org_apache_s2graph_rest_play_controllers_AdminController_deleteServiceColumn44_route(params) =>
      call(params.fromPath[String]("serviceName", None), params.fromPath[String]("columnName", None)) { (serviceName, columnName) =>
        org_apache_s2graph_rest_play_controllers_AdminController_deleteServiceColumn44_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.deleteServiceColumn(serviceName, columnName))
      }
  
    // @LINE:90
    case org_apache_s2graph_rest_play_controllers_AdminController_addServiceColumnProp45_route(params) =>
      call(params.fromPath[String]("serviceName", None), params.fromPath[String]("columnName", None)) { (serviceName, columnName) =>
        org_apache_s2graph_rest_play_controllers_AdminController_addServiceColumnProp45_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.addServiceColumnProp(serviceName, columnName))
      }
  
    // @LINE:91
    case org_apache_s2graph_rest_play_controllers_AdminController_addServiceColumnProps46_route(params) =>
      call(params.fromPath[String]("serviceName", None), params.fromPath[String]("columnName", None)) { (serviceName, columnName) =>
        org_apache_s2graph_rest_play_controllers_AdminController_addServiceColumnProps46_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.addServiceColumnProps(serviceName, columnName))
      }
  
    // @LINE:92
    case org_apache_s2graph_rest_play_controllers_AdminController_getServiceColumn47_route(params) =>
      call(params.fromPath[String]("serviceName", None), params.fromPath[String]("columnName", None)) { (serviceName, columnName) =>
        org_apache_s2graph_rest_play_controllers_AdminController_getServiceColumn47_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.getServiceColumn(serviceName, columnName))
      }
  
    // @LINE:93
    case org_apache_s2graph_rest_play_controllers_AdminController_createHTable48_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_AdminController_createHTable48_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.createHTable())
      }
  
    // @LINE:97
    case org_apache_s2graph_rest_play_controllers_AdminController_getLabels49_route(params) =>
      call(params.fromPath[String]("serviceName", None)) { (serviceName) =>
        org_apache_s2graph_rest_play_controllers_AdminController_getLabels49_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.getLabels(serviceName))
      }
  
    // @LINE:98
    case org_apache_s2graph_rest_play_controllers_AdminController_copyLabel50_route(params) =>
      call(params.fromPath[String]("oldLabelName", None), params.fromPath[String]("newLabelName", None)) { (oldLabelName, newLabelName) =>
        org_apache_s2graph_rest_play_controllers_AdminController_copyLabel50_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.copyLabel(oldLabelName, newLabelName))
      }
  
    // @LINE:99
    case org_apache_s2graph_rest_play_controllers_AdminController_renameLabel51_route(params) =>
      call(params.fromPath[String]("oldLabelName", None), params.fromPath[String]("newLabelName", None)) { (oldLabelName, newLabelName) =>
        org_apache_s2graph_rest_play_controllers_AdminController_renameLabel51_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.renameLabel(oldLabelName, newLabelName))
      }
  
    // @LINE:100
    case org_apache_s2graph_rest_play_controllers_AdminController_swapLabels52_route(params) =>
      call(params.fromPath[String]("leftLabelName", None), params.fromPath[String]("rightLabelName", None)) { (leftLabelName, rightLabelName) =>
        org_apache_s2graph_rest_play_controllers_AdminController_swapLabels52_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.swapLabels(leftLabelName, rightLabelName))
      }
  
    // @LINE:101
    case org_apache_s2graph_rest_play_controllers_AdminController_updateHTable53_route(params) =>
      call(params.fromPath[String]("labelName", None), params.fromPath[String]("newHTableName", None)) { (labelName, newHTableName) =>
        org_apache_s2graph_rest_play_controllers_AdminController_updateHTable53_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.updateHTable(labelName, newHTableName))
      }
  
    // @LINE:102
    case org_apache_s2graph_rest_play_controllers_AdminController_loadCache54_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_AdminController_loadCache54_invoker.call(org.apache.s2graph.rest.play.controllers.AdminController.loadCache())
      }
  
    // @LINE:106
    case org_apache_s2graph_rest_play_controllers_CounterController_createAction55_route(params) =>
      call(params.fromPath[String]("service", None), params.fromPath[String]("action", None)) { (service, action) =>
        org_apache_s2graph_rest_play_controllers_CounterController_createAction55_invoker.call(org.apache.s2graph.rest.play.controllers.CounterController.createAction(service, action))
      }
  
    // @LINE:107
    case org_apache_s2graph_rest_play_controllers_CounterController_getAction56_route(params) =>
      call(params.fromPath[String]("service", None), params.fromPath[String]("action", None)) { (service, action) =>
        org_apache_s2graph_rest_play_controllers_CounterController_getAction56_invoker.call(org.apache.s2graph.rest.play.controllers.CounterController.getAction(service, action))
      }
  
    // @LINE:108
    case org_apache_s2graph_rest_play_controllers_CounterController_updateAction57_route(params) =>
      call(params.fromPath[String]("service", None), params.fromPath[String]("action", None)) { (service, action) =>
        org_apache_s2graph_rest_play_controllers_CounterController_updateAction57_invoker.call(org.apache.s2graph.rest.play.controllers.CounterController.updateAction(service, action))
      }
  
    // @LINE:109
    case org_apache_s2graph_rest_play_controllers_CounterController_prepareAction58_route(params) =>
      call(params.fromPath[String]("service", None), params.fromPath[String]("action", None)) { (service, action) =>
        org_apache_s2graph_rest_play_controllers_CounterController_prepareAction58_invoker.call(org.apache.s2graph.rest.play.controllers.CounterController.prepareAction(service, action))
      }
  
    // @LINE:110
    case org_apache_s2graph_rest_play_controllers_CounterController_deleteAction59_route(params) =>
      call(params.fromPath[String]("service", None), params.fromPath[String]("action", None)) { (service, action) =>
        org_apache_s2graph_rest_play_controllers_CounterController_deleteAction59_invoker.call(org.apache.s2graph.rest.play.controllers.CounterController.deleteAction(service, action))
      }
  
    // @LINE:113
    case org_apache_s2graph_rest_play_controllers_CounterController_getRankingCountAsync60_route(params) =>
      call(params.fromPath[String]("service", None), params.fromPath[String]("action", None)) { (service, action) =>
        org_apache_s2graph_rest_play_controllers_CounterController_getRankingCountAsync60_invoker.call(org.apache.s2graph.rest.play.controllers.CounterController.getRankingCountAsync(service, action))
      }
  
    // @LINE:114
    case org_apache_s2graph_rest_play_controllers_CounterController_deleteRankingCount61_route(params) =>
      call(params.fromPath[String]("service", None), params.fromPath[String]("action", None)) { (service, action) =>
        org_apache_s2graph_rest_play_controllers_CounterController_deleteRankingCount61_invoker.call(org.apache.s2graph.rest.play.controllers.CounterController.deleteRankingCount(service, action))
      }
  
    // @LINE:115
    case org_apache_s2graph_rest_play_controllers_CounterController_getExactCountAsync62_route(params) =>
      call(params.fromPath[String]("service", None), params.fromPath[String]("action", None), params.fromPath[String]("item", None)) { (service, action, item) =>
        org_apache_s2graph_rest_play_controllers_CounterController_getExactCountAsync62_invoker.call(org.apache.s2graph.rest.play.controllers.CounterController.getExactCountAsync(service, action, item))
      }
  
    // @LINE:116
    case org_apache_s2graph_rest_play_controllers_CounterController_incrementCount63_route(params) =>
      call(params.fromPath[String]("service", None), params.fromPath[String]("action", None), params.fromPath[String]("item", None)) { (service, action, item) =>
        org_apache_s2graph_rest_play_controllers_CounterController_incrementCount63_invoker.call(org.apache.s2graph.rest.play.controllers.CounterController.incrementCount(service, action, item))
      }
  
    // @LINE:117
    case org_apache_s2graph_rest_play_controllers_CounterController_getExactCountAsyncMulti64_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_CounterController_getExactCountAsyncMulti64_invoker.call(org.apache.s2graph.rest.play.controllers.CounterController.getExactCountAsyncMulti())
      }
  
    // @LINE:120
    case org_apache_s2graph_rest_play_controllers_ExperimentController_experiment65_route(params) =>
      call(params.fromPath[String]("accessToken", None), params.fromPath[String]("experimentName", None), params.fromPath[String]("uuid", None)) { (accessToken, experimentName, uuid) =>
        org_apache_s2graph_rest_play_controllers_ExperimentController_experiment65_invoker.call(org.apache.s2graph.rest.play.controllers.ExperimentController.experiment(accessToken, experimentName, uuid))
      }
  
    // @LINE:121
    case org_apache_s2graph_rest_play_controllers_ExperimentController_experiments66_route(params) =>
      call { 
        org_apache_s2graph_rest_play_controllers_ExperimentController_experiments66_invoker.call(org.apache.s2graph.rest.play.controllers.ExperimentController.experiments())
      }
  
    // @LINE:124
    case controllers_Assets_at67_route(params) =>
      call(Param[String]("path", Right("/public/images")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at67_invoker.call(controllers.Assets.at(path, file))
      }
  
    // @LINE:125
    case controllers_Assets_at68_route(params) =>
      call(Param[String]("path", Right("/public/javascripts")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at68_invoker.call(controllers.Assets.at(path, file))
      }
  
    // @LINE:126
    case controllers_Assets_at69_route(params) =>
      call(Param[String]("path", Right("/public/stylesheets")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at69_invoker.call(controllers.Assets.at(path, file))
      }
  
    // @LINE:127
    case controllers_Assets_at70_route(params) =>
      call(Param[String]("path", Right("/public/font-awesome-4.1.0")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at70_invoker.call(controllers.Assets.at(path, file))
      }
  
    // @LINE:128
    case controllers_Assets_at71_route(params) =>
      call(Param[String]("path", Right("/public/swagger-ui")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at71_invoker.call(controllers.Assets.at(path, file))
      }
  }
}
