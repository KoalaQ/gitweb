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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticlesMapper articlesMapper;

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

}
