package co.jp.pcm.entity;

import java.util.List;

public class Menu {

	// Fields
	private Integer id;
	
	private String menuName;//菜单名字
	
	private String menuUrl;//功能路径
	
	private Integer parentId;//父id
	
	private Integer haveChild;//是否有孩子
	
	private Integer isHidden;//是否课件
	
	private Integer orderNum;//排序
	
	private String menuImg;//菜单图片
	
	private List<Menu> menus;

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** full constructor */
	public Menu(String menuName, String menuUrl, Integer parentId,
			Integer haveChild, Integer isHidden, Integer orderNum) {
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.parentId = parentId;
		this.haveChild = haveChild;
		this.isHidden = isHidden;
		this.orderNum = orderNum;
	}

	// Property accessors

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getHaveChild() {
		return haveChild;
	}

	public void setHaveChild(Integer haveChild) {
		this.haveChild = haveChild;
	}

	public Integer getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(Integer isHidden) {
		this.isHidden = isHidden;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getMenuImg() {
		return menuImg;
	}

	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}