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

public class SE4560EighthTest {
    // Boundary value tests on RegExUtil's removeAll() methods
    @Test
    void removeAllNullTest() {
        assertEquals(null, RegExUtils.removeAll(null, "[a-z]"));
    }
    @Test
    void removeAllNormalTest() {
        assertEquals("abc", RegExUtils.removeAll("ABCabc", "[A-Z]"));
    }
    @Test
    void removeAllEmptyTest() {
        assertEquals("", RegExUtils.removeAll("ABCabc", ".*"));
    }
    @Test
    void removeAllSpecialCharTest() {
        assertEquals("abc", RegExUtils.removeAll("a?bc", "\\?"));
    }
    @Test
    void removeAllAnchorTest() {
        assertEquals("BCabc", RegExUtils.removeAll("ABCabc", "^."));
    }
    @Test
    void removeAllOrTest() {
        assertEquals("Cc", RegExUtils.removeAll("ABCabc", "(ab)|(AB)"));
    }
    @Test
    void removeAllRepeatingTest() {
        assertEquals("ABCabc", RegExUtils.removeAll("ABCaaaabc", "a{3}"));
    }
}
