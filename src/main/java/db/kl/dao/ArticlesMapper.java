package db.kl.dao;

import db.kl.dto.Articles;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ArticlesMapper {
    public Articles getArticleId(@Param("urid")Integer urid);

    /**
     * 获取所有文章，用于前台列表展示
     * @return
     */
    public List<Map<String,Object>> getAllArticlesInfo();
    public List<Articles> getAllArticles();
    public int insertArticle(Articles articles);
    public int updateArticle(Articles articles);

}
