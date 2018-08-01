import freemarker.cache.TemplateLoader;
import freemarker.core.Environment;
import freemarker.ext.beans.DateModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
*author huangh
*date 2018/7/22 16:33
*description freemarker demo
 *
*/
public class demo {
    public static void main(String[] args) throws IOException, TemplateException {
        //指定版本
        Configuration configuration = new Configuration(Configuration.getVersion());
        //指定加载文件test.ftl所在目录 不包括具体文件
        configuration.setDirectoryForTemplateLoading(new File("C:\\Users\\hh\\workspace\\freeMarkerDemo\\src\\main\\resources"));
        //创建一个模板对象
        Template template= configuration.getTemplate("test.ftl","utf-8");
        //创建输出流
        Writer fileWriter = new FileWriter("D:\\test.html");
        Map map = new HashMap();
        //定义最基本的字符串
        map.put("message","hello");
        map.put("name","hhao");
        map.put("flag",false);
        //定义 list
        List goodsList=new ArrayList();
        Map goods1=new HashMap();
        goods1.put("name", "苹果");
        goods1.put("price", 5.8);
        Map goods2=new HashMap();
        goods2.put("name", "香蕉");
        goods2.put("price", 2.5);
        Map goods3=new HashMap();
        goods3.put("name", "橘子");
        goods3.put("price", 3.2);
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        map.put("goodsList", goodsList);
        //定义时间
        map.put("today",new Date());
        //定义数字
        map.put("point",454613496);
//        map.put("any",45);


        //创建
        template.process(map, fileWriter);
        fileWriter.close();

    }


}
