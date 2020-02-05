package db.kl.dto;

import cn.hutool.core.bean.BeanUtil;
import db.BaseDto;

import java.util.Map;

public class ArticlesHis extends BaseDto {
    private Integer articledirid;
    private String title;
    private String articletype;
    private String content;
    private String abstractcontent;
    private String source;
    private String editlog;


    public static ArticlesHis createHis(Articles articles) {
        Map<String,Object> articlesMap = BeanUtil.beanToMap(articles);
        ArticlesHis articlesHis =  BeanUtil.mapToBean(articlesMap,ArticlesHis.class,false);
        return articlesHis;
    }

    public Integer getArticledirid() {
        return articledirid;
    }

    public void setArticledirid(Integer articledirid) {
        this.articledirid = articledirid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticletype() {
        return articletype;
    }

    public void setArticletype(String articletype) {
        this.articletype = articletype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAbstractcontent() {
        return abstractcontent;
    }

    public void setAbstractcontent(String abstractcontent) {
        this.abstractcontent = abstractcontent;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getEditlog() {
        return editlog;
    }

    public void setEditlog(String editlog) {
        this.editlog = editlog;
    }
}
