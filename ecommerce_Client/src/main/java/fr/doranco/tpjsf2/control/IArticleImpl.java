package fr.doranco.tpjsf2.control;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;

import fr.doranco.tpjsf2.entity.Article;

public interface IArticleImpl {
	
	List<Article> getArticles() throws SQLException;
	Article getArticle(Integer id) throws SQLException;
	Response addArticle(Article article) throws SQLException;
	void removeArticle(Integer id)  throws SQLException;
	void updateArticle(Article article)  throws SQLException;

}
