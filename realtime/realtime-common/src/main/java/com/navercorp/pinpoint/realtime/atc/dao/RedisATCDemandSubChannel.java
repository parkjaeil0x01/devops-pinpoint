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
package com.navercorp.pinpoint.realtime.atc.dao;

import com.navercorp.pinpoint.pubsub.RedisSubChannel;
import com.navercorp.pinpoint.realtime.atc.dto.ATCDemand;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author youngjin.kim2
 */
public class RedisATCDemandSubChannel extends RedisSubChannel<ATCDemand> {

    public RedisATCDemandSubChannel(RedisMessageListenerContainer container) {
        super(container, RedisATCDemandPubChannel.getSerdeContext());
    }

    @Override
    protected String getChannelBase() {
        return "demand:atc";
    }

}
