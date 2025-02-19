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
package com.navercorp.pinpoint.web.realtime.atc.config;

import com.navercorp.pinpoint.web.realtime.atc.service.DemandPublishService;
import com.navercorp.pinpoint.web.realtime.atc.service.SupplyFlushService;
import com.navercorp.pinpoint.web.realtime.atc.service.SupplySubscribeService;
import com.navercorp.pinpoint.web.realtime.atc.task.DemandPublishTask;
import com.navercorp.pinpoint.web.realtime.atc.task.PeriodicTimerTask;
import com.navercorp.pinpoint.web.realtime.atc.task.SupplyFlushTask;
import com.navercorp.pinpoint.web.realtime.atc.task.SupplySubscribeTask;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author youngjin.kim2
 */
@Configuration
@Import({ ATCWebServiceConfig.class })
public class ATCWebBackgroundTaskConfig {

    @Value("${pinpoint.web.realtime.atc.supply.flush.periodMs:1000}")
    long flushPeriodMs;

    @Value("${pinpoint.web.realtime.atc.demand.periodMs:10000}")
    long demandPeriodMs;

    @Bean
    PeriodicTimerTask supplySubscribeTask(SupplySubscribeService service) {
        return new SupplySubscribeTask(service);
    }

    @Bean
    PeriodicTimerTask supplyFlushTask(SupplyFlushService service) {
        return new SupplyFlushTask(flushPeriodMs, service);
    }

    @Bean
    PeriodicTimerTask demandPublishTask(DemandPublishService service) {
        return new DemandPublishTask(demandPeriodMs, service);
    }

}
