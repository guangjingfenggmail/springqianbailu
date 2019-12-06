package com.open.springqianbailu.controller;


import com.google.gson.Gson;
import com.open.springqianbailu.Result;
import com.open.springqianbailu.model.app.AppLogs;
import com.open.springqianbailu.service.app.AppLogsSevice;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping(value = "/applogs")
public class AppLogsController extends AbsController {
    @Resource
    private AppLogsSevice appLogsSevice;

    @ApiOperation(value = "getApplogs", notes = "获取所有logs")
    @RequestMapping(value = "/getApplogs", method = RequestMethod.GET)
    @ResponseBody
    public Result getApplogs() {
        List<AppLogs> list = appLogsSevice.selectAll();
        Gson gson = new Gson();
        logger.info(TAG + gson.toJson(list));
        return Result.success(list);
    }


    @ApiOperation(value = "addAppLogs", notes = "新增logs" +
            "{\n" +
            "    \"appVersion\":\"1.0\",\n" +
            "    \"className\":\"IllegalStateException\",\n" +
            "    \"classSimpleName\":\"IllegalStateException\",\n" +
            "    \"createdAtTimemillis\":1575599441667,\n" +
            "    \"dbVersion\":16,\n" +
            "    \"groupDescription\":\"IllegalStateException\",\n" +
            "    \"groupHash\":\"da39a3ee5e6b4bd3255bfef95601890afd879\",\n" +
            "    \"heapAnalysisId\":3,\n" +
            "    \"id\":3,\n" +
            "    \"isLibraryLeak\":2,\n" +
            "    \"leakTrace\":\"java.lang.IllegalStateException: Could not find \",\n" +
            "    \"retainedHeapByteSize\":0,\n" +
            "    \"state\":0\n" +
            "}")
    @ApiImplicitParam(name = "appLogs", value = "appLogs", required = true, dataType = "AppLogs", paramType = "body")
    @RequestMapping(value = "/addAppLogs", method = RequestMethod.POST)
    @ResponseBody
    public Result addAppLogs(@RequestBody AppLogs appLogs) {
        int result = this.appLogsSevice.insert(appLogs);
        return Result.success(result);
    }

}
