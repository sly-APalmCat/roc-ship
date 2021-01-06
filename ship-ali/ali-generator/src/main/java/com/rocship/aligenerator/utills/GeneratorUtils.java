package com.rocship.aligenerator.utills;/**
 * Description: <br/>
 * date: 2021/1/6 11:20<br/>
 *
 * @version
 */

import com.rocship.aligenerator.model.database.ColumnsData;
import com.rocship.aligenerator.model.database.TablesData;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.logging.log4j.util.Strings;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.io.VelocityWriter;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * ClassName: GeneratorUtils <br/>
 * Description: <br/>
 * date: 2021/1/6 11:20<br/>
 * @author 15438<br />
 */
public class GeneratorUtils {

    public static List<String> getFileTemplate(){
        List<String> templates = new ArrayList<String>();
        templates.add("template/Entity.java.vm");
        templates.add("template/Dao.java.vm");
        templates.add("template/Dao.xml.vm");
        templates.add("template/Service.java.vm");
        templates.add("template/ServiceImpl.java.vm");
        templates.add("template/Controller.java.vm");
        templates.add("template/list.html.vm");
        templates.add("template/list.js.vm");
        templates.add("template/menu.sql.vm");
        return templates;
    }


    public static void genetatorCode(ZipOutputStream zipOutputStream, TablesData tablesData, List<ColumnsData> columnsData) {

      Configuration config = getConfig();
      boolean hasBigDecimal = false;
      String bigClassName = tablesDataToJava(tablesData.getTableName(),config.getString("tablePrefix"));
        tablesData.setBigClassName(bigClassName);
        tablesData.setLetterClassname(StringUtils.uncapitalize(bigClassName));
        for (ColumnsData columnsDatum : columnsData) {
           String bigAttrName = columnToJava(columnsDatum.getColumnName());
           columnsDatum.setBigAttributeName(bigAttrName);
           columnsDatum.setLetterAttributeName(StringUtils.uncapitalize(bigAttrName));
            String attrType = config.getString(columnsDatum.getColumnType());
            columnsDatum.setAttributeType(attrType);
            if(!hasBigDecimal && attrType.equals("BigDecimal")){
                hasBigDecimal = true;
            }
            if("PRI".equalsIgnoreCase(columnsDatum.getColumnKey()) && ObjectUtils.NULL.equals(tablesData.getPK())){
                tablesData.setPK(columnsDatum);
            }
        }
        if(Objects.isNull(tablesData.getPK())){
            tablesData.setPK(columnsData.get(0));
        }
        Properties properties = new Properties();
        properties.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(properties);

        String mainPath = config.getString("mainPath");
        mainPath = StringUtils.isBlank(mainPath)? "com.free.fly" : mainPath;

        Map<String, Object> map = new HashMap<>();
        map.put("tableName",tablesData.getTableName());
        map.put("comments",tablesData.getTableComment());
        map.put("pk",tablesData.getPK());
        map.put("bigClassName",tablesData.getBigClassName());
        map.put("letterClassName",tablesData.getLetterClassname());
        map.put("pathName",tablesData.getLetterClassname().toLowerCase());
        map.put("columns",columnsData);
        map.put("hasBigDecimal",hasBigDecimal);
        map.put("mainPath",mainPath);
        map.put("package",config.getString("package"));
        map.put("moduleName",config.getString("moduleName"));
        map.put("author",config.getString("author"));
        map.put("email",config.getString("email"));
        map.put("datetime",DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        VelocityContext velocityContext = new VelocityContext(map);

        List<String> fileTemplate = getFileTemplate();
        for (String temp : fileTemplate) {
            Template template = Velocity.getTemplate(temp, "UTF-8");
            StringWriter writer = new StringWriter();
            template.merge(velocityContext,writer);

            String zipEntryName = getFileName(temp,tablesData.getBigClassName(),config.getString("package"),config.getString("moduleName"));
            ZipEntry zipEntry = new ZipEntry(zipEntryName);
            try {
                zipOutputStream.putNextEntry(zipEntry);
                IOUtils.write(writer.toString(),zipOutputStream,"UTF-8");
                IOUtils.closeQuietly(writer);
                zipOutputStream.closeEntry();
            } catch (IOException e) {
                System.out.println("渲染模板失败：表名"+tablesData.getTableName()+e);
                e.printStackTrace();
            }
        }

    }

    private static Configuration getConfig() {

        try {
            PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration("tempVarParams.properties");
            return propertiesConfiguration;
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String columnToJava(String columnName){
        return WordUtils.capitalizeFully(columnName,new char[]{'_'}).replace("_",StringUtils.EMPTY);
    }

    public static String tablesDataToJava(String tableName,String tableNamePrefix){
        if(StringUtils.isNotBlank(tableNamePrefix)){
            tableName = tableNamePrefix.replace(tableNamePrefix, Strings.EMPTY);
        }
        return columnToJava(tableName);
    }


    /**
     * 获取文件名
     */
    public static String getFileName(String template, String className, String packageName, String moduleName) {
        String packagePath = "main" + File.separator + "java" + File.separator;
        if (StringUtils.isNotBlank(packageName)) {
            packagePath += packageName.replace(".", File.separator) + File.separator + moduleName + File.separator;
        }

        if (template.contains("Entity.java.vm" )) {
            return packagePath + "entity" + File.separator + className + "Entity.java";
        }

        if (template.contains("Dao.java.vm" )) {
            return packagePath + "dao" + File.separator + className + "Dao.java";
        }

        if (template.contains("Service.java.vm" )) {
            return packagePath + "service" + File.separator + className + "Service.java";
        }

        if (template.contains("ServiceImpl.java.vm" )) {
            return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }

        if (template.contains("Controller.java.vm" )) {
            return packagePath + "controller" + File.separator + className + "Controller.java";
        }

        if (template.contains("Dao.xml.vm" )) {
            return "main" + File.separator + "resources" + File.separator + "mapper" + File.separator + moduleName + File.separator + className + "Dao.xml";
        }

        if (template.contains("list.html.vm" )) {
            return "main" + File.separator + "resources" + File.separator + "templates" + File.separator
                    + "modules" + File.separator + moduleName + File.separator + className.toLowerCase() + ".html";
        }

        if (template.contains("list.js.vm" )) {
            return "main" + File.separator + "resources" + File.separator + "statics" + File.separator + "js" + File.separator
                    + "modules" + File.separator + moduleName + File.separator + className.toLowerCase() + ".js";
        }

        if (template.contains("menu.sql.vm" )) {
            return className.toLowerCase() + "_menu.sql";
        }

        return null;
    }
}
