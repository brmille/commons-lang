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

public class SE4560NinthTest {
    // Boundary value tests on StringUtil's compare() method
    @Test
    void CompareNullTest() {
        assertEquals(0, StringUtils.compare(null, null, true));
        assertEquals(-1, StringUtils.compare(null, " ", true));
        assertEquals(1, StringUtils.compare(null, " ", false));
    }
    @Test
    void CompareNormalTest() {
        assertEquals(3, StringUtils.compare("d", "a", true));
    }
    @Test
    void CompareSpecialCharTest() {
        assertEquals(53, StringUtils.compare("???", "\n", true));
    }
    @Test
    void CompareEqualTest() {
        assertEquals(0, StringUtils.compare("abc", "abc", true));
    }
    @Test
    void CompareUpperTest() {
        assertEquals(32, StringUtils.compare("abc", "ABC", true));
    }
    @Test
    void CompareLengthTest() {
        assertEquals(3, StringUtils.compare("abcabc", "abc", true));
    }
}