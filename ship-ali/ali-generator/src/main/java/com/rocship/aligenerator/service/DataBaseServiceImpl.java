package com.rocship.aligenerator.service;/**
 * Description: <br/>
 * date: 2021/1/6 10:41<br/>
 *
 * @version
 */

import com.alibaba.druid.sql.PagerUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rocship.aligenerator.config.dataconfig.AbstractDao;
import com.rocship.aligenerator.model.database.ColumnsData;
import com.rocship.aligenerator.model.database.TablesData;
import com.rocship.aligenerator.utills.GeneratorUtils;
import com.rocship.aligenerator.utills.PageUtils;
import com.rocship.aligenerator.utills.QueryParamsWrapper;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * ClassName: DataBaseServiceImpl <br/>
 * Description: <br/>
 * date: 2021/1/6 10:41<br/>
 * @author 15438<br />
 */
@Service
public class DataBaseServiceImpl {

    @Resource
    private AbstractDao abstractDao;

    /**
     * 检出列表
     * @param queryParamsWrapper
     * @return
     */
    PageUtils checkoutList(QueryParamsWrapper queryParamsWrapper){
        Page<Object> page = PageHelper.startPage(queryParamsWrapper.getPage(), queryParamsWrapper.getLimit());
        List<TablesData> tablesData = abstractDao.checkoutList(queryParamsWrapper);
        return new PageUtils(tablesData,page.getTotal(),queryParamsWrapper.getLimit(),queryParamsWrapper.getPage());
    }

    /**
     * 检出表
     * @param tableName
     * @return
     */
    TablesData checkoutTable(String tableName){
        return abstractDao.checkoutTable(tableName);
    }

    /**
     * 建出表列
     * @param tableName
     * @return
     */
    List<ColumnsData> checkoutColumns(String tableName){
        return abstractDao.checkoutColumns(tableName);
    }

    public byte[] generatorCode(String[] tablesName){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);

        for (String tableName : tablesName) {
            TablesData tablesData = checkoutTable(tableName);
            List<ColumnsData> columnsData = checkoutColumns(tableName);
            GeneratorUtils.genetatorCode(zipOutputStream,tablesData,columnsData);
        }
        IOUtils.closeQuietly(zipOutputStream);
        return byteArrayOutputStream.toByteArray();
    }


}
