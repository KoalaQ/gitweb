package db.kl.dao;

import db.kl.dto.Articles;
import org.apache.ibatis.annotations.Param;

public interface ArticlesMapper {
    public Articles getArticleId(@Param("urid")Integer urid);
    public void insertArticle(Articles articles);
}
