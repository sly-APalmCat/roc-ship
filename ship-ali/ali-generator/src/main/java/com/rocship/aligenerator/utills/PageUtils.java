package com.rocship.aligenerator.utills;/**
 * Description: <br/>
 * date: 2021/1/6 10:59<br/>
 *
 * @version
 */

import com.rocship.aligenerator.model.database.TablesData;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: PageUtils <br/>
 * Description: <br/>
 * date: 2021/1/6 10:59<br/>
 *
 * @author 15438<br       />
 */
@Data
public class PageUtils implements Serializable {

    private List<?> list;
    private long totalCount;
    private int pageSize;
    private int totalPage;
    private int currPage;


    /**
     * @param tablesData 列表数据
     * @param total  总记录数
     * @param limit  每页记录数
     * @param page   当前页数
     */
    public PageUtils(List<TablesData> tablesData, long total, int limit, int page) {
        this.list = tablesData;
        this.totalCount = total;
        this.pageSize = limit;
        this.totalPage = (int)Math.ceil((double) total/pageSize);
        this.currPage = page;
    }
}
