package org.kitscode.model;

import org.kitscode.base.BaseModel;
import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

/**
 * @author kevin
 * @date 2018/2/26
 */
@Table("book_info")
public class BookInfo extends BaseModel {
	@Column
	private String name;
	@Column
	private String area;
	@Column
	private String author;
	@Column
	private String press;
	@Column
	private String original_name;
	@Column
	private String translator;
	@Column
	private String publish_time;
	@Column
	private int pages;
	@Column
	private float price;
	@Column
	private String isbn;
	@Column
	private float score;
	@Column
	private int comment_count;
	@Column
	@ColDefine(customType="TEXT", type=ColType.VARCHAR)
	private String description;
	@Column
	@ColDefine(customType="TEXT", type=ColType.VARCHAR)
	private String author_profile;
	@Column
	private String tags;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getOriginal_name() {
		return original_name;
	}
	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(String publish_time) {
		this.publish_time = publish_time;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor_profile() {
		return author_profile;
	}
	public void setAuthor_profile(String author_profile) {
		this.author_profile = author_profile;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	
}
