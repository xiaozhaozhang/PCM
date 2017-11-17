package co.jp.pcm.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.jp.pcm.entity.Menu;
import co.jp.pcm.entity.Users;
import co.jp.pcm.service.MenuService;
import co.jp.pcm.service.UsersService;
import co.jp.pcm.utils.MD5Utils;

@Controller
@RequestMapping("/user") // url:/模块/资源/{id}/细分 /seckill/list
public class UsersController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Users login(HttpServletRequest request , Users users){
		MD5Utils md5Utils=new MD5Utils();
		System.out.println(users.getUrAccess());
		String psd = md5Utils.getMD5ofStr(users.getUrPsd());
		System.out.println(psd);
		Users login= usersService.login(users.getUrAccess(),psd);
		if(!users.getUrAccess().equals("admin")){
		  int years= Integer.parseInt(users.getUrAccess().substring(0, 4));
		  System.out.println(years);
		  Calendar a=Calendar.getInstance();
		  int curryear=a.get(Calendar.YEAR);
		  if(curryear-years>4||curryear-years==-1){//新老生不能登录
			  login=new Users();
			  login.setUrType(3);//禁止登录状态
			return  login; 
		  }
		}
		if(login==null){
			return null;
		}else{
			setconcurrentUser(login,request);
			request.getSession().setAttribute(request.getSession().getId(), login);//向session设置
			List<Menu> menulist= menuService.getMenuByuserType(login.getUrType());
			request.setAttribute("menulist", menulist);
			return login;
		}
	}
	
	
	/**
	 * 初始化菜单
	 * @param request
	 * @return
	 */
	   @RequestMapping("menus")
	   @ResponseBody
	 public List<Menu> intiMenu(HttpServletRequest request){
		   Users user = getconcurrentUser(request);
		      if(user==null){
		    	  user =new Users();
		    	  user.setUrType(3);
		      }
		    List<Menu> menus= menuService.getMenuByuserType(user.getUrType());
		   return menus;
	 }
	
	
	/**
	 * 跳转到登陆页
	 * @param request
	 * @return
	 */
	@RequestMapping("loginUI")
	public String loginUI(HttpServletRequest request ,Integer loginType){
		if(loginType==0){//管理员和普通用户登录
			return "/user/login";
		}else if(loginType==1){//超管登陆
			return "/user/superLogin";
		}
		return "/user/login";
	}

	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("loginOut")
	public String loginOut(HttpServletRequest request ,HttpServletResponse response){
		request.getSession().removeAttribute(request.getSession().getId());
		removeconcurrentUser(request);
		return "/user/login";
	}
	
//	@RequestMapping("userinfor")
//	public String userInfro(HttpServletRequest request){
//		Users user= getconcurrentUser(request);
//		request.setAttribute("user",usersService.getEntityById(Users.class,user.getId()));
//		return "/user/userinfor";
//	}
//	 /**
//	  * 更新用户
//	  * @param request
//	  * @param user
//	  * @return
//	  */
//	 @RequestMapping("update")
//	 @ResponseBody
//		public String updateUser(HttpServletRequest request,Users user){
//		 System.out.println(user.getId());
//      		 usersService.updateUser(user);
//      		setconcurrentUser(usersService.getEntityById(Users.class,user.getId()), request);
//		 return "success";
//		}
//	 /**
//	  * 跳转到修改密码
//	  * @return
//	  */
//	 @RequestMapping("updatepsdUI")
//	 public String updatePsdUI(){
//		return "/user/updatepsd";
//	 }
//	 /**
//	  * 修改密码
//	  * @param request
//	  * @param oldPsd
//	  * @param newPsd
//	  * @return
//	  */
//	 @RequestMapping("updatepsd")
//	 @ResponseBody
//	 public String updatePsdUI(HttpServletRequest request ,String oldPsd,String newPsd){
//		   MD5Utils md5Utils=new MD5Utils();
//		   oldPsd=   md5Utils.getMD5ofStr(oldPsd);
//		   newPsd=   md5Utils.getMD5ofStr(newPsd);
//		   
//	         Users user=getconcurrentUser(request);
//	         user= usersService.login(user.getUrAccess(), oldPsd);
//	         if(newPsd.length()<7){
//	        	 return "short";
//	         }
//	         if(oldPsd.equals(user.getUrPsd())){
//	        	 user.setUrPsd(newPsd);
//	        	 usersService.updatepsd(user.getId(),newPsd);
//	        	 return "success";
//	         }else{
//	        	 return "error"; 
//	         }
//	}
//	 /**
//	  * 跳转到登录页
//	  * @param request
//	  * @return
//	  */
//	 @RequestMapping("registerUI")
//	 public String registerUI(HttpServletRequest request){
//		 return "user/register";
//	 }
//	 
//	 /**
//	  * 注册用户
//	  * @param request
//	  * @param user
//	  * @return
//	  */
//	 @RequestMapping("register")
////	 @RequestMapping(value="/createId")
//	 public String register(HttpServletRequest request,Users user, String createId){
//		 System.out.println(createId);
//		Users isuser= usersService.getUserByAccess(user.getUrAccess()) ;
//		if(isuser==null){
//			user.setUrAccess(user.getUrBarcode());
//			user.setUrType(1);
//			MD5Utils md5Utils=new MD5Utils();
//			String md5 = md5Utils.getMD5ofStr(user.getUrPsd());
//			user.setUrPsd(md5);
//			usersService.save(user);
//			return "user/login";	
//		 }
//		return null; 
//	 }
//	 
//	 
//	 @RequestMapping("forgetUI")
//	 public String forgetUI(HttpServletRequest request){
//		return "/user/forgotPsd";
//		 
//	 }
//	 /**
//	  * 忘记密码
//	  * @param request
//	  * @param access
//	  * @param iphone
//	  * @param newpsd
//	  * @return
//	  */
//	 
//	 @RequestMapping("forget")
//	 public String forget(HttpServletRequest request,String access,String iphone, String newpsd){
//		Users user= usersService.getUserByAccessAndIphone(access,iphone);
//		MD5Utils md5Utils=new MD5Utils();
//		String md5 = md5Utils.getMD5ofStr(newpsd);
//		usersService.updatepsd(user.getId(),md5);
//		return "/user/login";
//		 
//	 }
//	 
	 
	 
	 
}