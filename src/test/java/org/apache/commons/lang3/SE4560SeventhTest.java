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

public class SE4560SeventhTest {
    // Class partition tests on StringUtil's abbreviate() methods
    @Test
    void AbbreviateShortTest() {
        assertEquals("abc", StringUtils.abbreviate("abc", 4));
    }
    @Test
    void AbbreviateLongTest() {
        assertEquals("a...", StringUtils.abbreviate("abcdefg", 4));
    }
    @Test
    void AbbreviateNullTest() {
        assertEquals(null, StringUtils.abbreviate(null, 4));
    }
    @Test
    void AbbreviateNormalTest() {
        assertEquals("abc...", StringUtils.abbreviate("abcdefghi", 6));
    }
    @Test
    void AbbreviateInvalidTest() {
        assertThrows(IllegalArgumentException.class, () -> {StringUtils.abbreviate("abc", 1);});
    }
    @Test
    void AbbreviateOffsetTest() {
        assertEquals("...abc...", StringUtils.abbreviate("12345abc12345", 5, 9));
    }
    @Test
    void AbbreviateMarkerTest() {
        assertEquals("-abc-", StringUtils.abbreviate("123abc123","-", 3, 5));
    }
    @Test
    void AbbreviateMarkerInvalidTest() {
        assertThrows(IllegalArgumentException.class, () -> {StringUtils.abbreviate("12345abc12345", ".....", 7, 10);});
    }
}
