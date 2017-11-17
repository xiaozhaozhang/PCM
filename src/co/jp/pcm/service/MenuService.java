package co.jp.pcm.service;
import java.util.List;

import co.jp.pcm.entity.Menu;

/**
 * 业务接口：站在"使用者"角度设计接口 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 */
public interface MenuService {

	public List<Menu> getMenuByuserType(Integer uType);
	
//	{
//		 System.out.println("servece=================");
//		 List<Power>powers=	powerDao.getPowerByuserType(uType);
//		 if(powers==null||powers.size()==0)return null;
//		 Integer [] ids=new Integer[powers.size()];
//		  for(int i=0;i<powers.size();i++){
//			  ids[i]=powers.get(i).getMenuId();
//		  }
//		List<Menu> firstMenu=  menuDao.getFirstMenus(ids);//first
//		 for(int i=0;i<firstMenu.size();i++){
//			 List<Menu> chilMenu = menuDao.getMenuByParentId(firstMenu.get(i).getId());
//			 firstMenu.get(i).setMenus(chilMenu);
//		 }
//		 
//			return firstMenu;
//		}

}