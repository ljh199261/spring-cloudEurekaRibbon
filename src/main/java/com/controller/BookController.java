package com.controller;


import com.base.BaseController;
import com.base.ResultResponse;
import com.entity.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * 官方文档：http://swagger.io/docs/specification/api-host-and-base-path/
 */
@RestController
@RequestMapping(value = "/books", produces = "application/json; charset=utf-8")
@ApiResponses({ @ApiResponse(code = 500, message = "接口异常"), })
@Api(value = "测试图书",description="测试图书")
public class BookController extends BaseController{
    Map<Long, Book> books = Collections.synchronizedMap(new HashMap<Long, Book>());

    @ApiOperation(value="获取图书列表", notes="获取图书列表")
    @GetMapping(value={"getBook"})
    public ResultResponse getBook() {
        List<Book> book = new ArrayList<>(books.values());

        return getResultResponse("200",(Serializable) book);
    }

    @ApiOperation(value="创建图书", notes="创建图书")
    @ApiImplicitParam(name = "book", value = "图书详细实体", required = true, dataType = "Book")
    @PostMapping(value="postBook")
    public ResultResponse postBook(@RequestBody Book book) {
        books.put(book.getId(), book);

        return getResultResponse("111");
    }
    @ApiOperation(value="获图书细信息", notes="根据url的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long",paramType = "path")
    @GetMapping(value="/{id}")
    public ResultResponse getBook(@PathVariable Long id) {

        return getResultResponse("200",(Serializable) books.get(id));
    }

    @ApiOperation(value="更新信息", notes="根据url的id来指定更新图书信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "图书ID", required = true, dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "book", value = "图书实体book", required = true, dataType = "Book")
    })
    @PutMapping(value="/{id}")
    public ResultResponse putUser(@PathVariable Long id, @RequestBody Book book) {
        Book book1 = books.get(id);
        book1.setName(book.getName());
        book1.setPrice(book.getPrice());
        books.put(id, book1);

        return getResultResponse("111");
    }
    @ApiOperation(value="删除图书", notes="根据url的id来指定删除图书")
    @ApiImplicitParam(name = "id", value = "图书ID", required = true, dataType = "Long",paramType = "path")
    @DeleteMapping(value="/{id}")
    public ResultResponse deleteUser(@PathVariable Long id) {
        books.remove(id);
        return getResultResponse("333");
    }

    @ApiIgnore//使用该注解忽略这个API
    @GetMapping(value = "/jsonTest")
    public String  jsonTest() {
        return " hi you!";
    }

}
