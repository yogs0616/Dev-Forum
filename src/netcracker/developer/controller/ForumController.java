/**
 * ForumController.java    defined under netcracker.developer.controller package
 *        This java controller class deals with creating forum,deleting forum 
 *       
 *         Only  Administrator can create a forum and delete it.         
 */
//package
package netcracker.developer.controller;
/**
 *   import : different needed packages are imported 
 *   
 * */
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import netcracker.developer.imp.WarningMsg;
import netcracker.developer.service.ForumService;
import netcracker.developer.viewBean.ForumBean;
import netcracker.developer.viewBean.LoginBean;
/**
 * @author kaas0616
 */
@Controller
public class ForumController {
	
	/**
	 *  @Autowired annotation can be used to auto wire bean .
	 *  @Autowired annotation on properties to get rid of the setter methods. 
	 *  When you will pass values of autowired properties using <property> 
	 *  Spring will automatically assign those properties with the passed values or references.
	 *  
	 */
	
	/**
	 * since ForumService is using forumDao property , ForumService is autowired
	 */

	@Autowired
	ForumService forumService;
	

	/*@RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.
	 * */

/**
 *  RequestMapping handles createForum URL  
 *  and calls createForum method.
 * 
 * @param request  on HttpServletRequest used to get HttpSession
 * @param loginBean   used when someone  Entered URL illegally in web browser
 * @param forumBean used to send updated list of forums
 * @return String  redirects user to admin URL
 */
	
	 @RequestMapping("/createForum")
	 public String createForum(HttpServletRequest request,LoginBean loginBean,ForumBean forumBean) {
		 /**
			 *  session object is created here and request.getSession(false) returns current session if it is there and 
			 *  doesn't create a new session 
			 */
		 
	  HttpSession session = request.getSession(false);
	  /**
		 * user type stores role attribute
		 * user gets null value or if he is not admin  indicates session is not created yet and shows it is an invalid access 
		 */
	  
	  String user=(String)session.getAttribute("role");
	  if(user==null&&user!="admin"){
	   return "redirect:/logout";
	   
	  }else{
		  /**
		   * new forum name for creating  is taken from admin by using JOptionPane
		   */
	   String forumName = JOptionPane.showInputDialog("Please input name of forum: ");
	   /**
	    * forumService calls createForum method to insert new forumName in database
	    */
	     forumService.createForum(forumName);
	     System.out.println(forumName);
	        return "redirect:/admin";//return
	    
	  }
	  }//createForum block ends 
	
	 /**
	  *  RequestMapping handles deleteForum URL  
	  *  and calls deleteForum method.
	  * 
	  * @param request  on HttpServletRequest used to get HttpSession
	  * @param loginBean   used when someone  Entered URL illegally in web browser
	  * @param forumBean used to send updated list of forums
	  * @return String  redirects user to admin URL
	  */
		@RequestMapping(value="/deleteForum")
	public String deleteForum(@ModelAttribute LoginBean loginBean,@ModelAttribute ForumBean forumBean1,@RequestParam("forumName") String forumName,HttpServletRequest request ) {
			 /**
			 *  session object is created here and request.getSession(false) returns current session if it is there and 
			 *  doesn't create a new session 
			 */
		 
	  HttpSession session = request.getSession(false);
	  /**
		 * user type stores role attribute
		 * user gets null value or if he is not admin  indicates session is not created yet and shows it is an invalid access 
		 */
	  
	  String user=(String)session.getAttribute("role");
	  ModelAndView model=null;
	  if(user==null&&user!="admin"){
		  String msg="InValid Access Please Log In To Continue";
			WarningMsg.showDialog(msg);
		  return "redirect:/logout";

	  }else{
		  
		  /**
		    * forumService calls deleteForum method to delete  forumName in database
		    */
		
		/**
		 * we need to update the forumList before passing the model with appropriate view
		 * 
		 *  forumBean uses forumService	to get updated forumList
		 */
		//Confirm dialog box is used to ask for confirmation of deletion.
				int option = JOptionPane.showConfirmDialog(null, "Press Ok to delete", "Confirm", JOptionPane.YES_NO_OPTION);
				//If answer is yes then deleting the user
				  if (option == 0) { //The ISSUE is here
				     System.out.print("delete");
				    
				     forumService.deleteForum(forumName);
				     //redirecting to see the new List after deletion.
				     return "redirect:/admin";
				  } else {
				     System.out.print("no");
				     //redirecting to see the new List after deletion.
				     return "redirect:/admin";
				  }

		  
	  }
	  
	
	}

	
	 
}