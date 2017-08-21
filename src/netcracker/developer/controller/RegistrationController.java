package netcracker.developer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import netcracker.developer.service.RegService;
import netcracker.developer.viewBean.RegBean;

@Controller
public class RegistrationController {
	@Autowired
	private RegService regService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView displayReg(HttpServletRequest request, HttpServletResponse response, RegBean regBean) {
		ModelAndView model = new ModelAndView("registration");
		model.addObject("regBean", regBean);
		return model;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String executeReg(HttpServletRequest request, HttpServletResponse response,@ModelAttribute() RegBean regBean) {
	
		try {

			boolean isRegSuccesful = regService.isRegSuccesful(regBean);
				if (isRegSuccesful) {
				System.out.println("Registration Successfull");
				return "redirect:/login";
	
			} else {
				
				System.out.println("Registration UnSuccessfull");
				request.setAttribute("mes", "Registration Unsuccessfull");
				return "redirect:/registration"; 			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;


	
	}
}
