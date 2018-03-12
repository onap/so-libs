/*-
 * ============LICENSE_START=======================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */

package com.woorea.openstack.nova.model;

import com.woorea.openstack.nova.model.ServerAction.ChangePassword;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail; 


public class ServerActionTest {
    private ChangePassword testObj = new ServerAction.ChangePassword();

    @Test
    public void testSetAdminPass(){

        try {

            testObj.setAdminPass("sai");
            assertEquals( testObj.getAdminPass(), "sai");

        } catch (Exception e) {

            fail("Exception in test obj");
        }

    }

    @Test
    public void testChangePasswdConstructor(){

        try {
            ServerAction.ChangePassword test = new ServerAction.ChangePassword("sai");
            assertEquals( test.getAdminPass(), "sai");

        } catch (Exception e) {

            fail("Exception in test obj");
        }

    }

    private ServerAction.Reboot testObj1 = new ServerAction.Reboot();

    @Test
    public void testSetType(){
        testObj1.setType("sai");
        assertEquals("sai", testObj1.getType());
    }

    private ServerAction.Rebuild testRebuild = new ServerAction.Rebuild();
    
    @Test
    public void testRebuild()
    {
        testRebuild.setAccessIPv4("1.1.1.1");
        assertEquals(testRebuild.getAccessIPv4(),"1.1.1.1");
    }
}
