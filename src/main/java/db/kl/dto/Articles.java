package db.kl.dto;

import db.BaseDto;

public class Articles extends BaseDto {
    private Integer articledirid;
    private String title;
    private String articletype;
    private String content;
    private String abstractcontent;
    private String source;

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAbstractcontent() {
        return abstractcontent;
    }

    public void setAbstractcontent(String abstractcontent) {
        this.abstractcontent = abstractcontent;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "articledirid=" + articledirid +
                ", title='" + title + '\'' +
                ", articletype='" + articletype + '\'' +
                ", content='" + content + '\'' +
                ", source='" + source + '\'' +
                ", urid=" + urid +
                ", createdby='" + createdby + '\'' +
                ", createdon=" + createdon +
                ", lastmodifiedby='" + lastmodifiedby + '\'' +
                ", lastmodifiedon=" + lastmodifiedon +
                ", rowversion=" + rowversion +
                '}';
    }
}
