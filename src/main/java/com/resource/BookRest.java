package com.resource;


import com.base.BaseController;
import com.base.ResultResponse;
import com.entity.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 官方文档：http://swagger.io/docs/specification/api-host-and-base-path/
 */
@Path("rest/bookrest")
@Produces({"application/javascript;charset=UTF-8", "application/json;charset=UTF-8", "text/javascript;charset=UTF-8"})
@ApiResponses({ @ApiResponse(code = 500, message = "接口异常"), })
@Api(value = "测试图书",description="测试图书")
public class BookRest {
    Map<Long, Book> books = Collections.synchronizedMap(new HashMap<Long, Book>());

    @ApiOperation(value="获取图书列表", notes="获取图书列表")
    @GET
    @Path("getBook")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getBook() {
        List<Book> book = new ArrayList<>(books.values());
        Map<String, Object> map = new HashMap<>();
        map.put("data", book);

        return map;
    }

}
