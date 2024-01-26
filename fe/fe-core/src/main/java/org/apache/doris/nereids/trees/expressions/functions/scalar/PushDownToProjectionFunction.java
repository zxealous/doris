// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.nereids.trees.expressions.functions.scalar;

import org.apache.doris.nereids.trees.expressions.Expression;

/**
 * Function that could be rewritten and pushed down to projection
 */
public interface PushDownToProjectionFunction {
    // check if specified function could be pushed down to project
    static boolean validToPushDown(Expression pushDownExpr) {
        // Currently only Variant type could be pushed down
        return pushDownExpr instanceof PushDownToProjectionFunction && pushDownExpr.getDataType().isVariantType();
    }
}