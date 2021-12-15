package fr.doranco.tpjsf2.control;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import fr.doranco.tpjsf2.entity.Article;

public class ArticleImpl implements IArticleImpl{

	private final static String CHARSET = ";charset=UTF-8";
	@Override
	public List<Article> getArticles() throws SQLException {
		
		ClientConfig clientConfig = new ClientConfig().register(LoggingFeature.class);
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget target = client.target("http://localhost:8080/ecommerce/ws/rest").path("articles")
				.path("liste");
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON + CHARSET);
		Response response = builder.get();
		if (response.getStatus() == 200) {
			List<Article> articles = response.readEntity(new GenericType<List<Article>>() {
			});
			System.out.println("code status : " + response.getStatus() + " (OK Omar, on the good way)");
			System.out.println(articles);
			return articles;
		} else {
			System.out.println("Failed with HTTP Error code : " + response.getStatus());
			System.out.println("Error : " + response.readEntity(String.class));
		}
		return null;
	}

	@Override
	public Response addArticle(Article article) throws SQLException {
		ClientConfig clientConfig = new ClientConfig().register(LoggingFeature.class);
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget target = client.target("http://localhost:8080/ecommerce/ws/rest").path("articles")
				.path("add");
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON + CHARSET);
		Response response = builder.post(Entity.entity(article, MediaType.APPLICATION_JSON + CHARSET));
		if (response.getStatus() == 200) {
			System.out.println("code status : " + response.getStatus() + " (OK Omar, user ajoute avec succes)");
			return Response.ok().entity("Article ajouté avec succès").build();
		} else {
			System.out.println("Failed with HTTP Error code : " + response.getStatus());
			System.out.println("Error : " + response.readEntity(String.class));
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erreur technique !").build();
		}
	}

	@Override
	public void removeArticle(Integer id) throws SQLException {
		ClientConfig clientConfig = new ClientConfig().register(LoggingFeature.class);
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget target = client.target("http://localhost:8080/ecommerce/ws/rest").path("articles")
				.path("delete").path(id.toString());
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON_TYPE + CHARSET);
		Response response = builder.delete(Response.class);
	    System.out.println(response);  
		
	}

	@Override
	public void updateArticle(Article article) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Article getArticle(Integer id) throws SQLException {
		ClientConfig clientConfig = new ClientConfig().register(LoggingFeature.class);
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget target = client.target("http://localhost:8080/ecommerce/ws/rest").path("articles")
				.path("article").path(id.toString());
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON_TYPE + CHARSET);
		Response response = builder.get();
		if (response.getStatus() == 200) {
			Article article = response.readEntity(Article.class);
			return article;  
		}else {
			return null;
		}
	}

}
