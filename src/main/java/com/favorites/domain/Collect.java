package com.favorites.domain;

import com.favorites.domain.enums.CollectType;
import com.favorites.domain.enums.IsDelete;

import javax.persistence.*;
import java.io.Serializable;

/*
*	收藏项目实体类
 */

@Entity
public class Collect  implements Serializable {

	private static final long serialVersionUID = 1L;
	//主键
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	//收藏用户的id
	@Column(nullable = false)
	private Long userId;
	//收藏url的id
	@Column(nullable = false)
	private Long favoritesId;
/*	//收藏的url
	@Column(nullable = false, columnDefinition = "varchar(600)")
	private String url;
	//收藏url的主题
	@Column(nullable = false)
	private String title;
	//url的logo
	@Column(nullable = true,columnDefinition = "varchar(300)")
	private String logoUrl;*/
	//对url的备注
	@Column(nullable = true, length = 65535, columnDefinition = "Text")
	private String description;
	//编码方式
	@Column(nullable = true)
	private String charset;
	//收藏的访问权限（PUBLIC, PRIVATE）
	@Enumerated(EnumType.STRING) 
	@Column(nullable = true)
	private CollectType type;
	//
	@Column(nullable = true)
	private String remark;
	//是否删除（YES,NO）
	@Column(nullable = false)
	@Enumerated(EnumType.STRING) 
	private IsDelete isDelete;
	//创建时间
	@Column(nullable = false)
	private Long createTime;
	//最近修改时间
	@Column(nullable = false)
	private Long lastModifyTime;
	//
	@Column(nullable = true)
	private String category;
	@Transient
	private String collectTime;
	@Transient
	private String newFavorites;

	public Collect() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFavoritesId() {
		return favoritesId;
	}

	public void setFavoritesId(Long favoritesId) {
		this.favoritesId = favoritesId;
	}

	/*public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
*/
	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public CollectType getType() {
		return type;
	}

	public void setType(CollectType type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public IsDelete getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(IsDelete isDelete) {
		this.isDelete = isDelete;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Long lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}

	public String getNewFavorites() {
		return newFavorites;
	}

	public void setNewFavorites(String newFavorites) {
		this.newFavorites = newFavorites;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}