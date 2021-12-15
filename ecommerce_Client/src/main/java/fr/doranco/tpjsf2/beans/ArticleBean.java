package fr.doranco.tpjsf2.beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.tpjsf2.control.ArticleImpl;
import fr.doranco.tpjsf2.control.IArticleImpl;
import fr.doranco.tpjsf2.entity.Article;

@ManagedBean(name = "articlebean")
@SessionScoped
public class ArticleBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String idArticle;

	@ManagedProperty(name = "nom", value = "")
	public String nom;

	@ManagedProperty(name = "description", value = "")
	public String description;

	@ManagedProperty(name = "prix", value = "")
	public Double prix;

	@ManagedProperty(name = "remise", value = "")
	public Double remise;
	
	@ManagedProperty(name = "stock", value = "")
	public Integer stock;

	@ManagedProperty(name = "isVendable", value = "")
	public Boolean isVendable;
	
	@ManagedProperty(name = "photos", value = "")
	public String photos;
	
	@ManagedProperty(name = "videos", value = "")
	public String videos;
	
	
	private static final IArticleImpl articleImpl = new ArticleImpl();
	private static List<Article> articles = getAllArticles();
	private Article article = new Article();
	
	public ArticleBean() {}
	
	public Article getArticle() {
		return article;
	}
	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		ArticleBean.articles = articles;
	}


	public String getPhoto(Article article) {
		
		List<String> cheminsPhotos = article.getPhotos();
		if (cheminsPhotos != null && !cheminsPhotos.isEmpty()) {
			return cheminsPhotos.get(0);
		}
		return "";
	}
	
//	public String getListPhotos(Article article) {
//		List<String> cheminsPhotos = article.getPhotos();
//		if (cheminsPhotos != null && !cheminsPhotos.isEmpty()) {
//			for(Integer i = 0; i < cheminsPhotos.size();) {
//				return cheminsPhotos.get(i).split(",").toString();
//			}	 
//		}
//		return "";
//	}
	
	public String getOneArticle(Article article) {
		try {
			article = articleImpl.getArticle(article.getId());
			this.article = article;
			return "detailArticle";
//			article = myArticle;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
//	test
//	public String detail(Article article) {
//		this.article = article;
//		return "detailArticle";
//	}
	
	public static List<Article> getAllArticles() {
		try {
			List<Article> articles = articleImpl.getArticles();
			return articles;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String addArticle() {
		List<String> listPhotos = new ArrayList<String>();
		listPhotos.add(photos);
		List<String> listVideos = new ArrayList<String>();
		listVideos.add(videos);
		Article article = new Article(nom, description, prix, remise, stock, isVendable, listPhotos, listVideos);
		try {
			articleImpl.addArticle(article);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String deleteArticle(Article article) {
		try {
			articleImpl.removeArticle(article.getId());
			articles = getAllArticles();
			return "deleteArticle";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Double getRemise() {
		return remise;
	}

	public void setRemise(Double remise) {
		this.remise = remise;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Boolean getIsVendable() {
		return isVendable;
	}

	public void setIsVendable(Boolean isVendable) {
		this.isVendable = isVendable;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getVideos() {
		return videos;
	}

	public void setVideos(String videos) {
		this.videos = videos;
	}	
	
	
}
