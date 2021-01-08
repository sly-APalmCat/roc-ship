package com.rocship.aligenerator.controller;/**
 * Description: <br/>
 * date: 2021/1/7 15:13<br/>
 *
 * @version
 */

import com.alicommon.lettercheck.file.utils.response.Res;
import com.rocship.aligenerator.service.DataBaseServiceImpl;
import com.rocship.aligenerator.utills.PageUtils;
import com.rocship.aligenerator.utills.QueryParamsWrapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * ClassName: DataBaseController <br/>
 * Description: <br/>
 * date: 2021/1/7 15:13<br/>
 * @author 15438<br />
 */
@Controller
@RequestMapping("/sys/generator")
public class DataBaseController {

    @Autowired
    private DataBaseServiceImpl dataBaseService;


    /**
     * @param params
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Res getList(@RequestParam Map<String,Object> params){
        PageUtils pageUtils = dataBaseService.checkoutList(new QueryParamsWrapper(params));
        return Res.ok().put("page",pageUtils);
    }

    @RequestMapping("code")
    public void generatorCode(String tables, HttpServletResponse response) throws IOException {
        byte[] bytes = dataBaseService.generatorCode(tables.split(","));

        response.reset();
        response.setHeader("Content-Disposition","attachment;filename=\"code.zip\"");
        response.setContentLengthLong(bytes.length);
        response.setContentType("application/octet-stream;charset=UTF-8");
        IOUtils.write(bytes,response.getOutputStream());
    }

}
