package com.rocship.aligenerator.config.dataconfig;/**
 * Description: <br/>
 * date: 2021/1/5 17:59<br/>
 *
 * @version
 */

import java.util.List;
import java.util.Map;

/**
 * ClassName: AbstractDao <br/>
 * Description: <br/>
 * date: 2021/1/5 17:59<br/>
 * @author 15438<br />
 */
public interface AbstractDao {

    List<Map<String, Object>> checkoutList(Map<String, Object> map);

    Map<String, String> checkoutTable(String tableName);

    List<Map<String, String>> checkoutColumns(String tableName);

}
