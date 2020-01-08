package db.kl.dao;

import db.kl.dto.Articles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticlesMapper {
    public Articles getArticleId(@Param("urid")Integer urid);
    public List<Articles> getAllArticles();
    public void insertArticle(Articles articles);
    public void updateArticle(Articles articles);

}
