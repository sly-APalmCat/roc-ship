package com.rocship.aligenerator.config.dataconfig;/**
 * Description: <br/>
 * date: 2021/1/5 17:59<br/>
 *
 * @version
 */

import com.rocship.aligenerator.model.database.ColumnsData;
import com.rocship.aligenerator.model.database.TablesData;

import java.util.List;
import java.util.Map;

/**
 * ClassName: AbstractDao <br/>
 * Description: <br/>
 * date: 2021/1/5 17:59<br/>
 * @author 15438<br />
 */
public interface AbstractDao {

    /**
     * 检出列表
     * @param map
     * @return
     */
    List<TablesData> checkoutList(Map<String, Object> map);

    /**
     * 检出表
     * @param tableName
     * @return
     */
    TablesData checkoutTable(String tableName);

    /**
     * 建出表列
     * @param tableName
     * @return
     */
    List<ColumnsData> checkoutColumns(String tableName);

}
