/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.s2graph.core.index

import org.apache.s2graph.core.Integrate.IntegrateCommon
import org.apache.s2graph.core.{Query, QueryParam, S2Vertex, Step}
import org.apache.tinkerpop.gremlin.process.traversal.step.util.HasContainer
import org.apache.tinkerpop.gremlin.process.traversal.{Order, P}
import org.apache.s2graph.core.mysqls._
import org.apache.s2graph.core.types.{InnerVal, InnerValLikeWithTs}
import org.apache.tinkerpop.gremlin.process.traversal.util.TraversalHelper
import org.apache.tinkerpop.gremlin.structure.T

import scala.collection.JavaConversions._

class IndexProviderTest extends IntegrateCommon {
  val indexProvider = IndexProvider(config)
  val numOfTry = 1

  lazy val gIndex = management.buildGlobalIndex(GlobalIndex.EdgeType, "test1", Seq("_timestamp", "weight", "time"))

//  test("test vertex write/query") {
//    gIndex
//    import TestUtil._
////    Management.addVertexProp(testServiceName, testColumnName, "time", "long")
//
//    val testService = Service.findByName(TestUtil.testServiceName).get
//    val testColumn = ServiceColumn.find(testService.id.get, TestUtil.testColumnName).get
//    val vertexId = graph.newVertexId(testServiceName)(testColumnName)(1L)
//
//    val propsWithTs = Map(
////      testColumn.metasInvMap("time") -> InnerVal.withLong(1L, "v4")
//      ColumnMeta.timestamp -> InnerVal.withLong(1L, "v4")
//    )
//    val otherPropsWithTs = Map(
////      testColumn.metasInvMap("time") -> InnerVal.withLong(2L, "v4")
//      ColumnMeta.timestamp -> InnerVal.withLong(2L, "v4")
//    )
//    val vertex = graph.newVertex(vertexId)
//    S2Vertex.fillPropsWithTs(vertex, propsWithTs)
//
//    val otherVertex = graph.newVertex(vertexId)
//    S2Vertex.fillPropsWithTs(otherVertex, otherPropsWithTs)
//
//    val numOfOthers = 10
//    val vertices = Seq(vertex) ++ (0 until numOfOthers).map(_ => otherVertex)
//
//    println(s"[# of vertices]: ${vertices.size}")
//    vertices.foreach(v => println(s"[Vertex]: $v"))
//    indexProvider.mutateVertices(vertices)
//
//    (0 until numOfTry).foreach { ith =>
//      val hasContainer = new HasContainer("_timestamp", P.eq(Long.box(1)))
//
//      var ids = indexProvider.fetchVertexIds(Seq(hasContainer))
//      ids.head shouldBe vertex.id
//
//      ids.foreach { id =>
//        println(s"[Id]: $id")
//      }
//    }
//  }
//
//  test("test edge write/query ") {
//    import TestUtil._
//    val testLabelName = TestUtil.testLabelName
//    val testLabel = Label.findByName(testLabelName).getOrElse(throw new IllegalArgumentException)
//    val vertexId = graph.newVertexId(testServiceName)(testColumnName)(1L)
//    val otherVertexId = graph.newVertexId(testServiceName)(testColumnName)(2L)
//    val vertex = graph.newVertex(vertexId)
//    val otherVertex = graph.newVertex(otherVertexId)
//
//    val propsWithTs = Map(
//      LabelMeta.timestamp -> InnerValLikeWithTs.withLong(1L, 1L, "v4"),
//      testLabel.metaPropsInvMap("time") -> InnerValLikeWithTs.withLong(10L, 1L, "v4")
//    )
//    val otherPropsWithTs = Map(
//      LabelMeta.timestamp -> InnerValLikeWithTs.withLong(2L, 2L, "v4"),
//      testLabel.metaPropsInvMap("time") -> InnerValLikeWithTs.withLong(20L, 2L, "v4")
//    )
//    val edge = graph.newEdge(vertex, vertex, testLabel, 0, propsWithTs = propsWithTs)
//    val otherEdge = graph.newEdge(otherVertex, otherVertex, testLabel, 0, propsWithTs = otherPropsWithTs)
//    val numOfOthers = 10
//    val edges = Seq(edge) ++ (0 until numOfOthers).map(_ => otherEdge)
//
//    println(s"[# of edges]: ${edges.size}")
//    edges.foreach(e => println(s"[Edge]: $e"))
//    indexProvider.mutateEdges(edges)
//
//    // match
//    (0 until numOfTry).foreach { _ =>
//      val hasContainers = Seq(new HasContainer("time", P.eq(Int.box(10))),
//        new HasContainer("_timestamp", P.eq(Int.box(1))))
//      val ids = indexProvider.fetchEdgeIds(hasContainers)
//      ids.head shouldBe edge.edgeId
//
//      ids.foreach { id =>
//        println(s"[Id]: $id")
//      }
//    }
//
//    // match and not
//    (0 until numOfTry).foreach { _ =>
//      val hasContainers = Seq(new HasContainer("time", P.eq(Int.box(20))),
//        new HasContainer("_timestamp", P.neq(Int.box(1))))
//      val ids = indexProvider.fetchEdgeIds(hasContainers)
//      //    ids.size shouldBe 0
//      // distinct make ids size to 1
////      ids.size shouldBe numOfOthers
//
//      ids.foreach { id =>
//        id shouldBe otherEdge.edgeId
//        println(s"[Id]: $id")
//      }
//    }
//
//    // range
//    (0 until numOfTry).foreach { _ =>
//      val hasContainers = Seq(new HasContainer("time",
//        P.inside(Int.box(0), Int.box(11))))
//      val ids = indexProvider.fetchEdgeIds(hasContainers)
//      //    ids.size shouldBe 0
//      ids.size shouldBe 1
//
//      ids.foreach { id =>
//        id shouldBe edge.edgeId
//        println(s"[Id]: $id")
//      }
//    }
//  }

  test("buildQuerySingleString") {
    // (weight: 34) AND (weight: [0.5 TO *] AND price: 30)

    var hasContainer = new HasContainer("weight", P.eq(Double.box(0.5)))

    var queryString = IndexProvider.buildQuerySingleString(hasContainer)

    println(s"[[QueryString]]: ${queryString}")

    hasContainer = new HasContainer("weight", P.gte(Double.box(0.5)))
    queryString = IndexProvider.buildQuerySingleString(hasContainer)

    println(s"[[QueryString]]: ${queryString}")

    hasContainer = new HasContainer("weight", P.within(Double.box(0.5), Double.box(0.7)))
    queryString = IndexProvider.buildQuerySingleString(hasContainer)

    println(s"[[QueryString]]: ${queryString}")

    hasContainer = new HasContainer("weight", P.without(Double.box(0.5), Double.box(0.7)))
    queryString = IndexProvider.buildQuerySingleString(hasContainer)

    println(s"[[QueryString]]: ${queryString}")
  }

  test("buildQueryString") {
    // (weight: 34) AND (weight: [1 TO 100])

    var hasContainers = Seq(
      new HasContainer("weight", P.eq(Int.box(34))),
      new HasContainer("weight", P.between(Int.box(1), Int.box(100)))
    )

    var queryString = IndexProvider.buildQueryString(hasContainers)
    println(s"[[QueryString]: ${queryString}")

    hasContainers = Seq(
      new HasContainer("weight", P.eq(Int.box(34))),
      new HasContainer("weight", P.outside(Int.box(1), Int.box(100)))
    )

    queryString = IndexProvider.buildQueryString(hasContainers)
    println(s"[[QueryString]: ${queryString}")
  }

  test("complex.") {
    //val predicate = P.lte(10).and(P.between(11, 20)) // .and(P.lt(29).or(P.eq(35)))
    val predicate = P.eq(30).and(P.between(11, 20)) // .and(P.lt(29).or(P.eq(35)))

      /*

      (x = 30 and x >= 11 and x < 20)

      //
      ((x <= 10 and (x >= 11 and x < 20)) and (x < 29 or x = 35))

      (and
        (lte 10)
        (and
          (between 11, 20))
          (or
            (lt 29)
            (eq 35))
          )
        )
      )

      (x:[* TO 10] OR x:10) AND ((x:[11 TO *] AND x:[* TO 20]) AND (x:[* TO 29] OR x:35))
      ((x:[* TO 10] OR x:10) AND x:[11 TO *] AND x:[* TO 20] AND (x:[* TO 29] OR x:35))
       */

    val hasContainers = Seq(new HasContainer("x", predicate))
    val queryString = IndexProvider.buildQueryString(hasContainers)
    println(s"[[QueryString]: ${queryString}")
  }

  test("has label") {
    //    has("song", "name", "OH BOY").out("followedBy").out("followedBy").order.by("performances").by("songType", Order.decr)
    val hasContainers = Seq(new HasContainer(T.label.getAccessor, P.eq("song")),
                            new HasContainer("name", P.eq("OH BOY")))
    val queryString = IndexProvider.buildQueryString(hasContainers)
    println(s"[[QueryString]: ${queryString}")

  }
}
