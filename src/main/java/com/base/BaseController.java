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


import com.utils.ErrorCodeUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2017-2018, springboot学习小组有限公司
 * FileName: ResultResponse.java
 * Author:   麦兜
 * Date:     2018-07-01 13:50
 * Description: 基础抽象控制层
 */
public abstract class BaseController {

    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     *  全局异常
     * @param bindingResult 参数
     * @return 返回结果
     */
    public List<String> getGlobalErrors(BindingResult bindingResult) {
        List<String> globalErrors = new ArrayList<String>();
        for (ObjectError oe : bindingResult.getGlobalErrors()) {
            globalErrors.add(oe.getDefaultMessage());
        }
        return globalErrors;
    }

    public Map<String, List<String>> getFieldErros(BindingResult bindingResult) {
        Map<String, List<String>> fieldErrors = new HashMap<String, List<String>>();
        for (FieldError fe : bindingResult.getFieldErrors()) {
            String f1 = fe.getField();

            if (fieldErrors.get(f1) != null) {
                fieldErrors.get(f1).add(fe.getDefaultMessage());
            } else {
                List<String> list = new LinkedList<String>();
                list.add(fe.getDefaultMessage());
                fieldErrors.put(f1, list);
            }
        }
        return fieldErrors;
    }


    protected ResultResponse getResultResponse(String code, Serializable content) {
        ResultResponse result = null;

        if (StringUtils.isNotBlank(code)) {
            result = new ResultResponse(code, ErrorCodeUtil.get(code), content);
            logger.info("\n【返回结果】" + result.toString());
        }

        return result;
    }

    protected ResultResponse getResultResponse(String code) {
        ResultResponse result = null;
        if (StringUtils.isNotBlank(code)) {
            result = new ResultResponse(code, ErrorCodeUtil.get(code));
            logger.info("\n【返回结果】" + result.toString());
        }

        return result;
    }

}
