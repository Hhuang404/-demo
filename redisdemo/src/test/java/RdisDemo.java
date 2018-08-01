import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.reflect.generics.tree.VoidDescriptor;

import java.util.List;
import java.util.Set;

/**
*author huangh
*date 2018/7/11 20:35
*description redis入门程序
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class RdisDemo {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue() {
        redisTemplate.boundValueOps("name").set("hh");
    }

    @Test
    public void getValue() {
        System.out.println(redisTemplate.boundValueOps("name").get());
    }

    @Test
    public void deleteValue() {
        redisTemplate.delete("name");
    }

    @Test
    public void setValueSet(){
       redisTemplate.boundSetOps("set").add("ad");
        Set list = redisTemplate.boundSetOps("set").members();
        System.out.println(list);
    }

    @Test
    public void setValueList(){
        redisTemplate.boundListOps("list1").rightPush("asd");
        redisTemplate.boundListOps("list1").rightPush("asd1");
        redisTemplate.boundListOps("list1").rightPush("asd2");
        redisTemplate.boundListOps("list1").rightPush("asd3");
        List list = redisTemplate.boundListOps("list").range(0, 10);
        System.out.println(list);
    }
    @Test
    public void setValueMap(){
        redisTemplate.boundHashOps("map").put("h1","aa");
        redisTemplate.boundHashOps("map").put("h2","aa3");
        redisTemplate.boundHashOps("map").put("h3","aa2");
        redisTemplate.boundHashOps("map").put("h4","aa1");
        Set map = redisTemplate.boundHashOps("map").keys();
        List map1 = redisTemplate.boundHashOps("map").values();
        System.out.println(map1);
    }











}