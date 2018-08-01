import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.hh.pojo.entity;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.annotation.SystemProfileValueSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;


/**
*author huangh
*date 2018/7/12 16:58
*description Spring Data Solr Demo
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-solr.xml")
public class SolrDemo {
    @Autowired
    private SolrTemplate solrTemplate;
    /**
    *author huangh
    *date 2018/7/12 17:00
    *description add function
    */
    @Test
    public void addBean(){
        //增加与修改，会更具solr是否有相同的主键，如果有就是修改 如果没有就是添加
        entity entity = new entity();
        entity.setId(1L); //唯一的主键必须添加
        entity.setTitle("华为手机111");
        entity.setPrice(new BigDecimal(3000.5));
        solrTemplate.saveBean(entity);
        solrTemplate.commit();
    }
    /**
    *author huangh
    *date 2018/7/12 18:02
    *description 根据主键id查询
    */
    @Test
    public void findById(){
        entity byId = solrTemplate.getById(1L, entity.class);
        System.out.println(byId);
    }
    /**
    *author huangh
    *date 2018/7/12 18:05
    *description 根据主键删除
    */
    @Test
    public void deleteById(){
        solrTemplate.deleteById("1");
        solrTemplate.commit();
    }

    @Test
    public void  findByQuery(){
        Query query = new SimpleQuery("*:*");
        query.setOffset(0);
        query.setRows(101);
        ScoredPage<entity> entities = solrTemplate.queryForPage(query, entity.class);
        for (entity entity : entities.getContent()) {
            System.out.println(entity.getId());
        }
        System.out.println("总页数"+entities.getTotalPages());
        System.out.println("每页显示的数据"+entities.getSize());
    }


}
