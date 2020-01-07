package db.kl.dao;


import db.kl.dto.Articles;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class ArticlesMapperTest {
    ArticlesMapper articlesMapper=null;
    @Before
    public void init(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
         articlesMapper = (ArticlesMapper)context.getBean("articlesMapper");
    }

    @Test
    public void getArticleId(){

        Articles articles = articlesMapper.getArticleId(4);
        System.out.println(articles);
    }
    @Test
    public void insertArticle(){
        Articles articles=new Articles();
        articles.setTitle("测试插入文章1");
        articles.setArticledirid(1);
        articles.setArticletype("3");
        articles.setContent("MyBatis 是一款优秀的持久层框架，它支持定制化 SQL、存储过程以及高级映射。MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。MyBatis 可以使用简单的 XML 或注解来配置和映射原生类型、接口和 Java 的 POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。");
        articles.setSource("1");
        articles.setCreatedby("1");
        articles.setCreatedon(new Date());
        articles.setLastmodifiedby("1");
        articles.setLastmodifiedon(new Date());
        articlesMapper.insertArticle(articles);




    }
}
