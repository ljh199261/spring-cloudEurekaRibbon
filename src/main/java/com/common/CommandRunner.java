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
package com.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2017-2018, springboot学习小组有限公司
 * FileName: ResultResponse.java
 * Author:   麦兜
 * Date:     2018-07-01 13:53
 * Description: 统一响应结果
 */
@Component
public class CommandRunner implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(CommandRunner.class);
    @Value("${spring.web.loginurl}")
    private String loginUrl;

    @Value("${spring.web.googleexcute}")
    private String googleExcutePath;

    @Value("${spring.auto.openurl}")
    private boolean isOpen;

    @Override
    public void run(String... args) throws Exception {
        if(isOpen){
            String cmd = googleExcutePath +" "+ loginUrl;
            Runtime run = Runtime.getRuntime();
            try{
                run.exec(cmd);
                logger.debug("启动浏览器打开项目成功");
            }catch (Exception e){
                e.printStackTrace();
                logger.error(e.getMessage());
            }
        }

    }
}