package com.open.springqianbailu;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value = "/account")
//@RequestMapping("/account")
public class UserDbController {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ApiOperation(value = "login", notes = "根据userName和pwd来获取用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户userName", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "pwd", value = "用户pwd", required = true, dataType = "String", paramType = "path")
    })
    @RequestMapping(value = "/login/{userName}/{pwd}", method = RequestMethod.GET)
//    @RequestMapping("/login/{userName}/{pwd}")
    public Result getLogin(@PathVariable String userName, @PathVariable String pwd) {
        String sql = "select * from user where name='" + userName + "' and pwd='" + pwd + "'";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            if (entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(key + ":" + value);
                }
            }
        }
        return Result.success(list.get(0));
    }

    @ApiOperation(value = "getUser", notes = "用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Result getUser(@PathVariable String id) {
        String sql = "select * from user where id=" + id;
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            if (entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(key + ":" + value);
                }
            }
        }
        if (list == null || list.size() == 0)
            return Result.error(400, "没有注册");
        return Result.success(list);
    }


    @ApiOperation(value = "getUsers", notes = "获取All用户详细信息")
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
//    @RequestMapping("/getUsers")
    public Result getAllUsers() {
        String sql = "select * from user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            if (entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(key + ":" + value);
                }
            }
        }
        return Result.success(list);
    }


}
