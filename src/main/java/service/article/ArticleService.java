package service.article;

import db.kl.dto.Articles;
import db.sys.dto.Users;

public interface ArticleService {
    public void edit(Articles articles, Users users) throws Exception;
}
