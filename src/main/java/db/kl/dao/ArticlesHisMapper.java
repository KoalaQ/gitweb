package db.kl.dao;

import db.kl.dto.ArticlesHis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ArticlesHisMapper {
    public List<ArticlesHis> getArticleId(@Param("urid")Integer urid);

    /**
     * 获取所有文章，用于前台列表展示
     * @return
     */
    public List<Map<String,Object>> getAllArticlesInfo();
    public List<ArticlesHis> getAllArticles();
    public int insertArticle(ArticlesHis articles);
    public int updateArticle(ArticlesHis articles);
}
