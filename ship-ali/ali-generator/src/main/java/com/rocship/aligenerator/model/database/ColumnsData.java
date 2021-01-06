package com.rocship.aligenerator.model.database;/**
 * Description: <br/>
 * date: 2021/1/5 17:08<br/>
 *
 * @version
 */

import lombok.Data;

/**
 * ClassName: ColumnsData <br/>
 * Description: <br/>
 * date: 2021/1/5 17:08<br/>
 * @author 15438<br />
 */
@Data
public class ColumnsData {

    private String tableCatalog;
    private String tableSchema;
    private String tableName;
    private String columnName;
    private String ordinalPosition;
    private String columnDefault;
    private String isNulllable;
    private String dataType;
    private String characterMaximumLength;
    private String characterOctetLength;
    private String numericPrecision;
    private String numericScale;
    private String datetimePrecision;
    private String characterSetName;
    private String collationName;
    private String columnType;
    private String columnKey;
    private String extra;
    private String privileges;
    private String columnComment;
    private String generationExpression;
    private String srsId;


    private String bigAttributeName;
    private String letterAttributeName;
    private String attributeType;

}
