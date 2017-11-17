package co.jp.pcm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.pcm.dao.MenuDao;
import co.jp.pcm.dao.PowerDao;
import co.jp.pcm.entity.Menu;
import co.jp.pcm.entity.Power;
import co.jp.pcm.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Autowired
	private MenuDao menuDao;

	@Autowired
	private PowerDao powerDao;

	@Override
	public List<Menu> getMenuByuserType(Integer uType) {
		logger.info("servece=================");
		List<Power> powers = powerDao.getPowerByuserType(uType);
		if (powers == null || powers.size() == 0)
			return null;
		
//		Integer[] ids = new Integer[powers.size()];
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < powers.size(); i++) {
//			ids[i] = powers.get(i).getMenuId();
			list.add(powers.get(i).getMenuId());
		}
		
		List<Menu> firstMenu = menuDao.getFirstMenus(list);// first
		for (int i = 0; i < firstMenu.size(); i++) {
			List<Menu> chilMenu = menuDao.getMenuByParentId(firstMenu.get(i)
					.getId());
			firstMenu.get(i).setMenus(chilMenu);
		}
		return firstMenu;
	}

	
}