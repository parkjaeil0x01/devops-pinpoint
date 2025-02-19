/*
 * Copyright 2023 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.navercorp.pinpoint.collector.realtime.service;

import com.navercorp.pinpoint.collector.cluster.ClusterPoint;
import com.navercorp.pinpoint.common.server.cluster.ClusterKey;
import com.navercorp.pinpoint.rpc.packet.stream.StreamResponsePacket;
import com.navercorp.pinpoint.rpc.stream.ClientStreamChannel;
import org.apache.thrift.TBase;

import java.util.function.Consumer;

/**
 * @author youngjin.kim2
 */
public interface AgentCommandService {

    ClusterPoint<?> findClusterPoint(ClusterKey clusterKey);

    ClientStreamChannel request(
            ClusterPoint<?> clusterPoint,
            TBase<?, ?> command,
            Consumer<StreamResponsePacket> callback
    ) throws Exception;

}
