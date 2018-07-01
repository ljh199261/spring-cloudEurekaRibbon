/**
 * Copyright 2018 springboot
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.config;

import com.base.ResultResponse;
import com.resource.BookRest;
import com.resource.TeacherRest;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import javax.ws.rs.ApplicationPath;
import java.util.Map;

/**
 * Copyright (C), 2017-2018, springboot学习小组有限公司
 * FileName: JerseyResourceConfig.java
 * Author:   麦兜
 * Date:     2018-07-01 23:37
 * Description:     
 */
@ApplicationPath("rest")
public class JerseyResourceConfig extends ResourceConfig {
    public JerseyResourceConfig() {
        register(RequestContextFilter.class);
        register(BookRest.class);
        register(TeacherRest.class);
        register(Map.class);
        register(ResultResponse.class);
        // 配置那个包下面的会被Jersey扫描
        packages("com.resource");
    }
}