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
package com.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (C), 2017-2018, springboot学习小组有限公司
 * FileName: ResultResponse.java
 * Author:   麦兜
 * Date:     2018-07-01 13:50
 * Description: 返回code收集器
 */
@Slf4j
public class ErrorCodeUtil {


    /**
     * 错误信息配置文件
     */
    private final static String ERROR_CODE_PROP = "error.properties";

    /**
     * 配置
     */
    private static PropertiesConfiguration properties = null;

    private static void loadProperties() {
        properties = new PropertiesConfiguration();
        properties.setEncoding("utf-8");
        properties.setFileName(ERROR_CODE_PROP);
        try {
            properties.load();
        } catch (Exception e) {
            log.error("------ 加载错误码配置文件出现异常 ------", e);
            try {
                properties.load();
            } catch (Exception e1) {
                log.error("------ 第二次尝试加载错误码配置文件出现异常 ------", e1);
            }
        }
    }

    public static String get(String key) {
        // 判断配置文件是否加载过
        if (properties == null) {
            // 加载配置文件
            loadProperties();
        }
        // 获取
        String value = null;
        if (properties.containsKey(key)) {
            value = properties.getString(key);
        } else {
            log.error("------ 没有找到错误码对应的信息，key:" + key + " ------");
        }

        return value;
    }

    public static String getArgs(String key, Object[] args) {
        // 判断配置文件是否加载过
        if (properties == null) {
            // 加载配置文件
            loadProperties();
        }
        // 获取
        String value = null;
        if (properties.containsKey(key)) {
            value = properties.getString(key);
            // 填入参数
            String.format(value, args);
        } else {
            log.error("------ 没有找到错误码对应的信息，key:" + key + " ------");
        }

        return value;
    }
}
