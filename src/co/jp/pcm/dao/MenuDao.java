package co.jp.pcm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.pcm.entity.Menu;

public interface MenuDao{
	
	public List<Menu> getFirstMenus(List<Integer> list);
//	{
//		String str="";
//		for(int i=0;i<id.length;i++){
//			str=str+id[i]+",";
//		}
//		str=str.substring(0, str.length()-1);
//		String hql="from Menu where id in("+str+") and parentId=0 order by orderNum";
//		return this.find(hql);
//	}

	public List<Menu> getMenuByParentId(Integer parentId);


	
//	{
//		String hql="from Menu where parentId="+parentId;
//		return this.find(hql);
//	}

}
