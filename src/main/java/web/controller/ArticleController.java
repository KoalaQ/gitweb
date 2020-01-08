package web.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import db.kl.dao.ArticlesMapper;
import db.kl.dto.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import web.beans.ComResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticlesMapper articlesMapper;

    @RequestMapping("/queryarticle")
    public void queryarticle(HttpServletRequest req, HttpServletResponse resp){
        ComResult comResult=new ComResult();
        comResult.setRetcode(ComResult.RETCODEOK);

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
}