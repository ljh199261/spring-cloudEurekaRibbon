package com.resource;

import com.base.BaseController;
import com.base.ResultResponse;
import com.github.pagehelper.PageInfo;
import com.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("rest/teacher")
@Produces({"application/javascript;charset=UTF-8", "application/json;charset=UTF-8", "text/javascript;charset=UTF-8"})
@ApiResponses({ @ApiResponse(code = 500, message = "接口异常"), })
@Api(value = "测试学生信息",description = "测试学生信息")
@Component
public class TeacherRest extends BaseController{


    @Autowired
    private TeacherService teacherService;

    @Path(value = "/selectTeacher")
    @GET
    @ApiOperation(value = "所有学生信息",notes = "所有学生信息")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultResponse selectTeacher(){
        PageInfo pageInfo = teacherService.selectTeacher();

        return getResultResponse("200", pageInfo);
    }
}
