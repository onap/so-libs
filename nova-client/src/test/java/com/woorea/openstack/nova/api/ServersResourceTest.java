/*-
 * ============LICENSE_START=======================================================
 * ONAP - SO
 * ================================================================================
 * Copyright (C) 2018 Huawei Intellectual Property. All rights reserved.
 * ================================================================================ 
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

package com.woorea.openstack.nova.api;

import com.woorea.openstack.base.client.OpenStackClientMockUtils;
import com.woorea.openstack.nova.Nova;
import com.woorea.openstack.nova.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Collections;

public class ServersResourceTest {

    private static final String NOVA_ENDPOINT = "nova_endpoint";
    private static final String I_PV_4 = "127.0.0.1";
    private static final String SERVER_AVAILABILITY_ZONE = "server_availability_zone";
    private static final String SERVER_USER_DATA = "server_user_data";
    private static final String SERVER_NAME = "server_name";
    private static final String SERVER_KEY = "server_key";
    private static final String SERVER_IMAGE = "server_image";
    private static final String SERVER_FLAVOR = "m1.medium";
    public static final String REBOOT_TYPE = "reboot_type";
    public static final String DISK_CONFIG = "disk_config";
    public static final String CONSOLE_TYPE = "console_type";
    private ServersResource serversResource = null;

    @Before
    public void setUp() {
        Nova client = new Nova(NOVA_ENDPOINT, OpenStackClientMockUtils.getInstance().getConnector());
        serversResource = client.servers();
    }

    @Test
    public void list() {
        final Servers expectedServers = Mockito.mock(Servers.class);
        OpenStackClientMockUtils.getInstance().mockRequestResponse(Servers.class, expectedServers);
        final ServersResource.List list = serversResource.list(true);
        final Servers actualServers = list.execute();
        Assert.assertEquals(expectedServers, actualServers);
    }

    @Test
    public void boot() {
        final Server expectedServer = Mockito.mock(Server.class);
        OpenStackClientMockUtils.getInstance().mockRequestResponse(Server.class, expectedServer);
        ServerForCreate createServer = createServerForCreate();
        final ServersResource.Boot boot = serversResource.boot(createServer);
        final Server actualServer = boot.execute();
        Assert.assertEquals(expectedServer, actualServer);
    }

    @Test
    public void show() {
        final Server expectedServer = Mockito.mock(Server.class);
        OpenStackClientMockUtils.getInstance().mockRequestResponse(Server.class, expectedServer);
        final ServersResource.Show show = serversResource.show(SERVER_KEY);
        final Server actualServer = show.execute();
        Assert.assertEquals(expectedServer, actualServer);
    }

    @Test
    public void showMetadata() {
        final Metadata expectedServer = Mockito.mock(Metadata.class);
        OpenStackClientMockUtils.getInstance().mockRequestResponse(Metadata.class, expectedServer);
        final ServersResource.ShowMetadata show = serversResource.showMetadata(SERVER_KEY);
        final Metadata actualServer = show.execute();
        Assert.assertEquals(expectedServer, actualServer);
    }

    @Test
    public void createOrUpdateMetadata() {
        final Metadata expectedServer = Mockito.mock(Metadata.class);
        OpenStackClientMockUtils.getInstance().mockRequestResponse(Metadata.class, expectedServer);
        Metadata metadata = Mockito.mock(Metadata.class);
        final ServersResource.CreateOrUpdateMetadata metadataCreateUpdate =
                serversResource.createOrUpdateMetadata(SERVER_KEY, metadata);
        final Metadata actualServer = metadataCreateUpdate.execute();
        Assert.assertEquals(expectedServer, actualServer);
    }

    @Test
    public void replaceMetadata() {
        final Metadata expectedServer = Mockito.mock(Metadata.class);
        OpenStackClientMockUtils.getInstance().mockRequestResponse(Metadata.class, expectedServer);
        Metadata metadata = Mockito.mock(Metadata.class);
        final ServersResource.ReplaceMetadata metadataCreateUpdate =
                serversResource.replaceMetadata(SERVER_KEY, metadata);
        final Metadata actualServer = metadataCreateUpdate.execute();
        Assert.assertEquals(expectedServer, actualServer);
    }

    @Test
    public void deleteMetadata() {
        final ServersResource.DeleteMetadata metadataCreateUpdate =
                serversResource.deleteMetadata(SERVER_NAME, SERVER_KEY);
        metadataCreateUpdate.execute();
    }

    @Test
    public void delete() {
        final ServersResource.Delete metadataCreateUpdate = serversResource.delete(SERVER_NAME);
        metadataCreateUpdate.execute();
    }

    @Test
    public void update() {
        final Server expectedServer = Mockito.mock(Server.class);
        OpenStackClientMockUtils.getInstance().mockRequestResponse(Server.class, expectedServer);
        final ServersResource.UpdateServer metadataCreateUpdate =
                serversResource.update(SERVER_NAME, SERVER_KEY, I_PV_4, "");
        final Server actualServer = metadataCreateUpdate.execute();
        Assert.assertEquals(expectedServer, actualServer);
    }

    @Test
    public void changePassword() {
        final Server expectedServer = Mockito.mock(Server.class);
        OpenStackClientMockUtils.getInstance().mockRequestResponse(Server.class, expectedServer);
        final ServersResource.ChangePasswordAction metadataCreateUpdate =
                serversResource.changePassword(SERVER_NAME, SERVER_NAME);
        final Server actualServer = metadataCreateUpdate.execute();
        Assert.assertEquals(expectedServer, actualServer);
    }

    @Test
    public void reboot() {
        final ServersResource.RebootAction reboot = serversResource.reboot(SERVER_NAME, REBOOT_TYPE);
        reboot.execute();
    }

    @Test
    public void rebuild() {
        final ServerAction.Rebuild rebuild = new ServerAction.Rebuild();
        final Server expectedServer = Mockito.mock(Server.class);
        OpenStackClientMockUtils.getInstance().mockRequestResponse(Server.class, expectedServer);
        final ServersResource.RebuildAction metadataCreateUpdate = serversResource.rebuild(SERVER_NAME, rebuild);
        final Server actualServer = metadataCreateUpdate.execute();
        Assert.assertEquals(expectedServer, actualServer);
    }

    @Test
    public void resize() {
        final Server expectedServer = Mockito.mock(Server.class);
        OpenStackClientMockUtils.getInstance().mockRequestResponse(Server.class, expectedServer);
        final ServersResource.ResizeAction metadataCreateUpdate =
                serversResource.resize(SERVER_NAME, SERVER_FLAVOR, DISK_CONFIG);
        final Server actualServer = metadataCreateUpdate.execute();
        Assert.assertEquals(expectedServer, actualServer);
    }

    @Test
    public void confirmResize() {
        final Server expectedServer = Mockito.mock(Server.class);
        OpenStackClientMockUtils.getInstance().mockRequestResponse(Server.class, expectedServer);
        final ServersResource.ConfirmResizeAction metadataCreateUpdate = serversResource.confirmResize(SERVER_NAME);
        final Server actualServer = metadataCreateUpdate.execute();
        Assert.assertEquals(expectedServer, actualServer);
    }

    @Test
    public void revertResize() {
        final Server expectedServer = Mockito.mock(Server.class);
        OpenStackClientMockUtils.getInstance().mockRequestResponse(Server.class, expectedServer);
        final ServersResource.RevertResizeAction metadataCreateUpdate = serversResource.revertResize(SERVER_NAME);
        final Server actualServer = metadataCreateUpdate.execute();
        Assert.assertEquals(expectedServer, actualServer);
    }

    @Test
    public void createImage() {
        final ServersResource.CreateImageAction metadataCreateUpdate =
                serversResource.createImage(SERVER_NAME, SERVER_KEY, Collections.<String, String>emptyMap());
        metadataCreateUpdate.execute();
    }

    @Test
    public void start() {
        final ServersResource.StartServer metadataCreateUpdate = serversResource.start(SERVER_NAME);
        metadataCreateUpdate.execute();
    }

    @Test
    public void stop() {
        final ServersResource.StopServer metadataCreateUpdate = serversResource.stop(SERVER_NAME);
        metadataCreateUpdate.execute();
    }

    @Test
    public void getVncConsole() {
        final ServerAction.VncConsole console = new ServerAction.VncConsole();
        OpenStackClientMockUtils.getInstance().mockRequestResponse(ServerAction.VncConsole.class, console);
        final ServersResource.GetVncConsoleServer metadataCreateUpdate =
                serversResource.getVncConsole(SERVER_NAME, CONSOLE_TYPE);
        final ServerAction.VncConsole actualConsole = metadataCreateUpdate.execute();
        Assert.assertEquals(console, actualConsole);
    }

    @Test
    public void getConsoleOutput() {
        final ServerAction.ConsoleOutput console = new ServerAction.ConsoleOutput();
        OpenStackClientMockUtils.getInstance().mockRequestResponse(ServerAction.ConsoleOutput.class, console);
        final ServersResource.GetConsoleOutputServer metadataCreateUpdate =
                serversResource.getConsoleOutput(SERVER_NAME, Integer.MAX_VALUE);
        final ServerAction.ConsoleOutput actualConsole = metadataCreateUpdate.execute();
        Assert.assertEquals(console, actualConsole);
    }

    @Test
    public void pause() {
        final ServersResource.PauseServer metadataCreateUpdate = serversResource.pause(SERVER_NAME);
        metadataCreateUpdate.execute();
    }

    @Test
    public void unpause() {
        final ServersResource.UnpauseServer metadataCreateUpdate = serversResource.unpause(SERVER_NAME);
        metadataCreateUpdate.execute();
    }

    @Test
    public void lock() {
        final ServersResource.LockServer metadataCreateUpdate = serversResource.lock(SERVER_NAME);
        metadataCreateUpdate.execute();
    }

    @Test
    public void unlock() {
        final ServersResource.UnlockServer metadataCreateUpdate = serversResource.unlock(SERVER_NAME);
        metadataCreateUpdate.execute();
    }

    @Test
    public void suspend() {
        final ServersResource.SuspendServer metadataCreateUpdate = serversResource.suspend(SERVER_NAME);
        metadataCreateUpdate.execute();
    }

    @Test
    public void resume() {
        final ServersResource.ResumeServer metadataCreateUpdate = serversResource.resume(SERVER_NAME);
        metadataCreateUpdate.execute();
    }

    @Test
    public void createBackup() {
        ServerAction.CreateBackup backup = new ServerAction.CreateBackup();
        final ServersResource.CreateBackupServer metadataCreateUpdate =
                serversResource.createBackup(SERVER_NAME, backup);
        metadataCreateUpdate.execute();
    }

    @Test
    public void rescue() {
        final ServerAction.CreateBackup console = new ServerAction.CreateBackup();
        final ServersResource.CreateBackupServer metadataCreateUpdate =
                serversResource.createBackup(SERVER_NAME, console);
        metadataCreateUpdate.execute();
    }

    @Test
    public void unrescue() {
        final ServersResource.UnrescueServer metadataCreateUpdate = serversResource.unrescue(SERVER_NAME);
        metadataCreateUpdate.execute();
    }

    @Test
    public void associateFloatingIp() {
        final ServersResource.AssociateFloatingIp metadataCreateUpdate =
                serversResource.associateFloatingIp(SERVER_NAME, I_PV_4);
        metadataCreateUpdate.execute();
    }

    @Test
    public void disassociateFloatingIp() {
        final ServersResource.DisassociateFloatingIp metadataCreateUpdate =
                serversResource.disassociateFloatingIp(SERVER_NAME, I_PV_4);
        metadataCreateUpdate.execute();
    }

    @Test
    public void attachVolume() {
        final ServersResource.AttachVolume metadataCreateUpdate =
                serversResource.attachVolume(SERVER_NAME, "volume_id", "device");
        metadataCreateUpdate.execute();
    }

    @Test
    public void detachVolume() {
        final ServersResource.DetachVolume metadataCreateUpdate =
                serversResource.detachVolume(SERVER_NAME, "volume_id");
        metadataCreateUpdate.execute();
    }

    @Test
    public void listVolumeAttachments() {
        final VolumeAttachments volumeAttachments = new VolumeAttachments();
        OpenStackClientMockUtils.getInstance().mockRequestResponse(VolumeAttachments.class, volumeAttachments);
        final ServersResource.ListVolumeAttachments metadataCreateUpdate =
                serversResource.listVolumeAttachments(SERVER_NAME);
        final VolumeAttachments actualVolumeAttachments = metadataCreateUpdate.execute();
        Assert.assertEquals(volumeAttachments, actualVolumeAttachments);
    }

    @Test
    public void showVolumeAttachment() {
        final VolumeAttachment volumeAttachment = new VolumeAttachment();
        OpenStackClientMockUtils.getInstance().mockRequestResponse(VolumeAttachment.class, volumeAttachment);
        final ServersResource.ShowVolumeAttachment metadataCreateUpdate =
                serversResource.showVolumeAttachment(SERVER_NAME, "volume_id");
        final VolumeAttachment actualVolumeAttachment = metadataCreateUpdate.execute();
        Assert.assertEquals(volumeAttachment, actualVolumeAttachment);
    }

    private ServerForCreate createServerForCreate() {
        final ServerForCreate server = new ServerForCreate();
        server.setAccessIPv4(I_PV_4);
        server.setAvailabilityZone(SERVER_AVAILABILITY_ZONE);
        server.setFlavorRef(SERVER_FLAVOR);
        server.setImageRef(SERVER_IMAGE);
        server.setKeyName(SERVER_KEY);
        server.setName(SERVER_NAME);
        server.setUserData(SERVER_USER_DATA);
        return server;
    }
}
