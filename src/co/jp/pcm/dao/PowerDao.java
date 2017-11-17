package co.jp.pcm.dao;

import java.util.List;

import co.jp.pcm.entity.Power;

public interface PowerDao {

	public List<Power> getPowerByuserType(Integer userType);
	
//	{
//		System.out.println("dao=================");
//	   String hql="from  Power p where p.userType="+type;
//		return find(hql);
//	}
}