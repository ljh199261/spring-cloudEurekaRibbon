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
package com.base;

import com.enums.ResultCodeEnum;
import lombok.Data;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Copyright (C), 2017-2018, springboot学习小组有限公司
 * FileName: ResultResponse.java
 * Author:   麦兜
 * Date:     2018-07-01 13:50
 * Description: 统一响应结果    
 */
@Data
public class ResultResponse {

    /**
     * 序列化
     */
    private static final long serialVersionUID = -6010932515432454307L;

    /**
     * 结果编码（code=200为正常响应，其他为异常响应）
     */
    private String code = "200";

    /**
     * 结果信息(异常响应信息)
     */
    private String desc = "操作成功";

    /**
     * 返回结果
     */
    private Serializable content;

    /**
     * 无参构造
     */
    public ResultResponse() {
    }

    public ResultResponse(String code) {
        this.code = code;
    }

    /**
     * @param code
     * @param desc
     */
    public ResultResponse(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * @param code
     * @param content
     */
    public ResultResponse(String code, Serializable content) {
        this.code = code;
        this.content = content;
    }

    /**
     * @param code
     * @param desc
     * @param content
     */
    public ResultResponse(String code, String desc, Serializable content) {
        this.code = code;
        this.desc = desc;
        this.content = content;
    }

    public static ResultResponse ok() {
        ResultResponse resultResponse = new ResultResponse(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage());
        return resultResponse;
    }

    public static ResultResponse ok(String desc) {
        ResultResponse resultResponse = new ResultResponse(ResultCodeEnum.SUCCESS.getCode(), desc);
        return resultResponse;
    }

    public static ResultResponse ok(Serializable content) {
        ResultResponse resultResponse = new ResultResponse(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), content);
        return resultResponse;
    }

    public static ResultResponse ok(String desc, Serializable content) {
        ResultResponse resultResponse = new ResultResponse(ResultCodeEnum.SUCCESS.getCode(), desc, content);
        return resultResponse;
    }

    public static ResultResponse fail() {
        ResultResponse resultResponse = new ResultResponse(ResultCodeEnum.FAIL.getCode(), ResultCodeEnum.FAIL.getMessage());
        return resultResponse;
    }

    public static ResultResponse fail(String desc) {
        ResultResponse resultResponse = new ResultResponse(ResultCodeEnum.FAIL.getCode(), desc);
        return resultResponse;
    }


    public static ResultResponse fail(String code, String desc) {
        ResultResponse resultResponse = new ResultResponse(code, desc);
        return resultResponse;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}