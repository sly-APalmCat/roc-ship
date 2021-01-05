package com.rocship.aligenerator.model.database;/**
 * Description: <br/>
 * date: 2021/1/5 17:09<br/>
 *
 * @version
 */

import lombok.Data;

/**
 * ClassName: TablesData <br/>
 * Description: <br/>
 * date: 2021/1/5 17:09<br/>
 * @author 15438<br />
 */
@Data
public class TablesData {

    private String tableCatalog;
    private String tableSchema;
    private String tableName;
    private String tableType;
    private String engine;
    private String version;
    private String rowFormat;
    private String tableRows;
    private String avgRowLength;
    private String dataLength;
    private String maxDataLength;
    private String indexLength;
    private String dataFree;
    private String autoIncrement;
    private String createTime;
    private String updateTime;
    private String checkTime;
    private String tableCollation;
    private String checksum;
    private String createOptions;
    private String tableComment;

}
