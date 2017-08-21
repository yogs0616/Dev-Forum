package netcracker.developer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import netcracker.developer.imp.WarningMsg;
import netcracker.developer.service.ForumService;
import netcracker.developer.service.LoginService;
import netcracker.developer.service.QuestionService;
import netcracker.developer.viewBean.ForumBean;
import netcracker.developer.viewBean.LoginBean;
import netcracker.developer.viewBean.QuestionBean;
import netcracker.developer.viewBean.RegBean;
import org.apache.log4j.PropertyConfigurator;
@Controller
public class LoginController {
	
	
	private Logger logger=Logger.getLogger(LoginController.class);
	
	
	@Autowired	
	 private ForumService forumService;
	@Autowired
	private QuestionService	questionService;
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean,RegBean regBean) {
		ModelAndView model=null;
		PropertyConfigurator.configure("log4j.properties");
		HttpSession session= request.getSession(false);
		if(session!=null){
			
			String sessionId=(String)session.getAttribute("sessionId");
			if(session.getId()!=sessionId){
			
				model = new ModelAndView("login");
				logger.info("For New Session Login model created");
				model.addObject("loginBean", loginBean);
			   
			}else{
				QuestionBean questionBean = null;
				String user=(String) session.getAttribute("role");
				if(user.equals("admin")){
					//List of Question is created and stored in queList
					List<QuestionBean> queList=new ArrayList<QuestionBean>();
					//List of Forum  is created and  ForumList have been fetched from the database and stored in forumBean .
					List<ForumBean> forumBean = forumService.getForumList();
					
					//questions are retrieved from the database using viewQuestion method and storing in queList
					queList=questionService.viewQuestion(questionBean, loginBean);
					logger.info("Question has been Retrievd from database");
					//New AdminWelcome model is created
					 model=new ModelAndView("adminWelcome");
					 logger.info("Admin model created");
					//List of questions have been added to that model
					model.addObject("queList",queList);
					//List of forumNames have been added to that model
					model.addObject("forumBean",forumBean);
					logger.info("Questions and forum list have been added to admin model");
				}else if(user.equals("member")){
					//List of Question is created and stored in queList	
					List<QuestionBean> queList=new ArrayList<QuestionBean>();
					//questions are retrieved from the database using viewQuestion method and storing in queList
					queList=questionService.viewQuestion(questionBean, loginBean);
					logger.info("Question has been Retrievd from database");
					//New AdminWelcome model is created
					model=new ModelAndView("memberWelcome");
					 logger.info("member  model created");
					//List of questions have been added to that model
					model.addObject("queList",queList);
					logger.info("Questions and forum list have been added to member  model");
					logger.info("member model returned");
					//return newly created model.
					return model;	
					
				}
		}
		}
		else{
			 model = new ModelAndView("login");
			logger.debug("Login model created");
			logger.info("Login model created");
		    model.addObject("loginBean", loginBean);
		    
		}
		return model;
			
			
		}
	

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String executeLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginBean") LoginBean loginBean, BindingResult bindingresult) {
		
		//ModelAndView model = null;
		
		
		if(!bindingresult.hasErrors()){
           
		}
                
		try {
			boolean isValidUser = loginService.isValidUser(loginBean.getUsername(), loginBean.getPassword());
			if (isValidUser) {
				
				
				boolean isActive=loginService.isActive(loginBean.getUsername());
				
				
				if(isActive){
					
					
				boolean isAdmin=loginService.isAdmin(loginBean.getUsername());
				HttpSession session= request.getSession(true);
				session.setMaxInactiveInterval(300);
				session.setAttribute("sessionId", session.getId());
				session.setAttribute("loggedInUser",loginBean.getUsername());
				
				List<ForumBean> forumBean = forumService.getForumList();
				session.setAttribute("forumBean",forumBean);
				 
				if(isAdmin){
					System.out.println("Admin Login Successful");
					session.setAttribute("role","admin");
					return "redirect:/admin";
				}
				else{
					System.out.println("Member Login Successful");
					session.setAttribute("role","member");
					return "redirect:/member";
				
				}
			}
				else {
				
					String msg="Deactivated Account";
					WarningMsg.showDialog(msg);
					return "redirect:/login";
					
				}
			}
				else {
				
					String msg="Invalid credentials!!";
					WarningMsg.showDialog(msg);
					return "redirect:/login";
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return "redirct:/login";
	
	}
	
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	HttpSession session=request.getSession(false);
		if(session!=null){
	session.getAttribute("loggedInUser");
	session.removeAttribute("role");
	session.removeAttribute("froumBean");
	session.invalidate();
		}
	 return "redirect:/login";
}
	

}

