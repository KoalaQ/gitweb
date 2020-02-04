package web.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import db.kl.dao.ArticlesMapper;
import db.kl.dto.Articles;
import db.sys.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.article.ArticleService;
import web.beans.ComResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticlesMapper articlesMapper;
    @Autowired
    ArticleService articleService;

    @RequestMapping("/queryarticle")
    public void queryarticle(HttpServletRequest req, HttpServletResponse resp){
        ComResult comResult=new ComResult();
        comResult.setRetcode(ComResult.RETCODEOK);
        comResult.setRetstatus(ComResult.STATUSOK);

        String articleid = req.getParameter("articleid");
        if(StrUtil.isNotBlank(articleid)){
            try {
                Articles articles = articlesMapper.getArticleId(Integer.parseInt(articleid));
                comResult.setRetdata(JSON.toJSONString(articles));
            } catch (Exception e) {
                e.printStackTrace();
                comResult.setRetstatus(ComResult.STATUSFAIL);
                comResult.setRetdata(e.getMessage());
            }

        }else{
            comResult.setRetstatus(ComResult.STATUSFAIL);
            comResult.setRetdata("未找到文章！");
        }
        String msg= JSON.toJSONString(comResult);
        try {
            resp.setHeader("content-type","text/html;charset=utf-8");
            //resp.setCharacterEncoding("UTF-8");
            resp.getWriter().print(msg);
            resp.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/queryarticlelist")
    public void queryarticleList(HttpServletResponse resp){
        ComResult comResult=new ComResult();
        comResult.setRetcode(ComResult.RETCODEOK);
        comResult.setRetstatus(ComResult.STATUSOK);
        //暂时先查询所有文章
        List<Map<String,Object>> mapList=articlesMapper.getAllArticlesInfo();
        if(mapList!=null && mapList.size()>0){
            comResult.setRetdata(JSON.toJSONString(mapList));
            comResult.setRetdatasize(mapList.size()+"");
        }else{
            comResult.setRetdata("");
            comResult.setRetdatasize("0");
        }
        String msg= JSON.toJSONString(comResult);
        try {
            resp.setHeader("content-type","text/html;charset=utf-8");
            //resp.setCharacterEncoding("UTF-8");
            resp.getWriter().print(msg);
            resp.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("/editarticle")
    public void editArticle(HttpServletRequest req, HttpServletResponse resp){
        ComResult comResult=new ComResult();
        comResult.setRetcode(ComResult.RETCODEOK);
        comResult.setRetstatus(ComResult.STATUSOK);

        String articleid = req.getParameter("urid");
        String title = req.getParameter("title");
        String abstractcontent = req.getParameter("abstractcontent");
        String editlog = req.getParameter("editlog");
        String content = req.getParameter("content");

        Articles articles=new Articles();
        articles.setUrid(Integer.parseInt(articleid));
        articles.setTitle(title);
        articles.setAbstractcontent(abstractcontent);
        articles.setEditlog(editlog);
        articles.setContent(content);
        Users users =  (Users)req.getSession().getAttribute("userinfo");
        try {
            articleService.edit(articles,users);
        } catch (Exception e) {
            comResult.setRetstatus(ComResult.STATUSFAIL);
            comResult.setRetdata(e.getMessage());
            e.printStackTrace();
        }
        String msg= JSON.toJSONString(comResult);
        try {
            resp.setHeader("content-type","text/html;charset=utf-8");
            //resp.setCharacterEncoding("UTF-8");
            resp.getWriter().print(msg);
            resp.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
