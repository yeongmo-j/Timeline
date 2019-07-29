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

package org.apache.s2graph.core.features

import org.apache.tinkerpop.gremlin.structure.Graph.Features

abstract class S2ElementFeatures extends Features.ElementFeatures {
  override def supportsStringIds(): Boolean = false

  override def supportsCustomIds(): Boolean = true

  override def supportsUuidIds(): Boolean = false

  override def supportsAddProperty(): Boolean = true

  override def supportsRemoveProperty(): Boolean = true

  override def supportsUserSuppliedIds(): Boolean = true

  override def supportsAnyIds(): Boolean = false

  override def supportsNumericIds(): Boolean = false

  override def willAllowId(id: scala.Any): Boolean = true
//  override def willAllowId(id: scala.Any): Boolean = super.willAllowId(id)
}
