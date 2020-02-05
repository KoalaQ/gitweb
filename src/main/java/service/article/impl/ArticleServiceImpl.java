package service.article.impl;

import cn.hutool.core.util.StrUtil;
import db.kl.dao.ArticlesHisMapper;
import db.kl.dao.ArticlesMapper;
import db.kl.dto.Articles;
import db.kl.dto.ArticlesHis;
import db.sys.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.article.ArticleService;

import java.util.Date;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticlesMapper articlesMapper;
    @Autowired
    ArticlesHisMapper articlesHisMapper;
    public void edit(Articles articles,Users users) throws Exception {
        if(StrUtil.isBlank(articles.getEditlog())){
            throw new Exception("更新日志必填！");
        }
        if(StrUtil.isBlank(articles.getContent())){
            throw new Exception("文字内容必填！");
        }
        if(StrUtil.isBlank(articles.getAbstractcontent())){
            throw new Exception("摘要必填！");
        }
        if(StrUtil.isBlank(articles.getTitle())){
            throw new Exception("标题必填！");
        }
        Articles articlesdb=articlesMapper.getArticleId(articles.getUrid());
        if (articlesdb == null) {
            throw new Exception("查找文章异常必填！");
        }

        //历史记录
        ArticlesHis articlesHis = ArticlesHis.createHis(articlesdb);

        articlesdb.setLastmodifiedby(users.getId());
        articlesdb.setLastmodifiedon(new Date());
        articlesdb.setTitle(articles.getTitle());
        articlesdb.setEditlog(articles.getEditlog());
        articlesdb.setContent(articles.getContent());

        int num=articlesMapper.updateArticle(articlesdb);
        if(num!=1){
            throw new Exception("更新失败！");
        }
        num=articlesHisMapper.insertArticle(articlesHis);
        if(num!=1){
            throw new Exception("创建历史失败！");
        }
    }


}
