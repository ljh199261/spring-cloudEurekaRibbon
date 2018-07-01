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
package com.enums;

/**
 * Copyright (C), 2017-2018, springboot学习小组有限公司
 * FileName: ResultResponse.java
 * Author:   麦兜
 * Date:     2018-07-01 13:50
 * Description: 统一响应结果
 */
public enum ResultCodeEnum {
    SUCCESS("200", "操作成功"),
    FAIL("-1", "操作失败"),
    FORBIDDEN("403", "禁止访问"),
    UN_KNOW_EXCEPTION("500", "未知异常");

    public String code;

    public String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
