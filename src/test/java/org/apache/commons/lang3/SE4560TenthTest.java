/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SE4560TenthTest {
    // Boundary value test on StringUtil's join() method
    @Test
    void JoinNullTest() {
        String array[] = {null};
        assertEquals("", StringUtils.join(array, "", 0, 0));
    }
    @Test
    void JoinEmptyTest() {
        String array[] = {};
        assertEquals("", StringUtils.join(array, "", 0, 0));
    }
    @Test
    void JoinNormalTest() {
        String array[] = {"a", "b", "c"};
        assertEquals("a,b,c", StringUtils.join(array, ",", 0, 3));
    }
    @Test
    void JoinNumTest() {
        Integer array[] = {1, 2, 3};
        assertEquals("1,2,3", StringUtils.join(array, ",", 0, 3));
    }
    @Test
    void JoinHighIndexTest() {
        String array[] = {"a", "b", "c"};
        assertEquals("a,b,c", StringUtils.join(array, ",", 0, 5));
    }
    @Test
    void JoinLowIndexTest() {
        String array[] = {"a", "b", "c"};
        assertEquals("a", StringUtils.join(array, ",", 0, 1));
    }
    @Test
    void JoinOutOfBoundsTest() {
        String array[] = {"a", "b", "c"};
        assertThrows(IllegalArgumentException.class, () -> {StringUtils.join(array, ",", -1, 3);});
    }
    @Test
    void JoinNoIndexTest() {
        String array[] = {"a", "b", "c"};
        assertEquals("a,b,c", StringUtils.join(array, ","));
    }
}
