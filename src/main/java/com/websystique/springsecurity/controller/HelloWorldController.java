package com.websystique.springsecurity.controller;
 
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springsecurity.drools.CheckDiabetesRisk;
import com.websystique.springsecurity.drools.CheckHypertensionRisk;
import com.websystique.springsecurity.model.DiabeticResults;
import com.websystique.springsecurity.model.PressureResults;
import com.websystique.springsecurity.model.User;
import com.websystique.springsecurity.model.UserProfile;
import com.websystique.springsecurity.service.UserProfileService;
import com.websystique.springsecurity.service.UserService;
 
@Controller
public class HelloWorldController {
 
    @Autowired
    UserProfileService userProfileService;
     
    @Autowired
    UserService userService;
     
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(ModelMap model) {
    	List<User> users = userService.findAllUsers();
    	int index = 0;
    	for(User user: users){
    		System.out.println(users.get(index));
    		index++;
    	}
        model.addAttribute("users", users);
        
    	List<DiabeticResults> diabeticResults = userService.findAllDiabeticResults();
    	index = 0;
    	for(DiabeticResults result: diabeticResults){
    		System.out.println(index+ " " + diabeticResults.get(index).getPesel()
    				+ " " + diabeticResults.get(index).getResult());
    		index++;
    	}
        model.addAttribute("diabeticResults", diabeticResults);
        
    	List<PressureResults> pressureResults = userService.findAllPressureResults();
    	index = 0;
    	for(PressureResults result: pressureResults){
    		System.out.println(index+ " " +pressureResults.get(index).getPesel()
    				+ " " +pressureResults.get(index).getSystolic() 
    				+ " " +pressureResults.get(index).getDiastolic());
    		index++;
    	}
        model.addAttribute("pressureResults", pressureResults);
        
        return "welcome";
    }
    
    @RequestMapping(value = "/diabetic", method = RequestMethod.GET)
    public String diabeticPage(ModelMap model) {

    	int index = 0;
    	List<DiabeticResults> diabeticResults = userService.findAllDiabeticResults();
    	index = 0;
    	for(DiabeticResults result: diabeticResults){
    		System.out.println(diabeticResults.get(index));
    		index++;
    	}
        model.addAttribute("diabeticResults", diabeticResults);
        CheckDiabetesRisk risk = new CheckDiabetesRisk(diabeticResults, "90032518908");
        risk.callDrools();
        return "diabetic";
    }
    
    @RequestMapping(value = "/pressure", method = RequestMethod.GET)
    public String pressurePage(ModelMap model) {

    	List<PressureResults> pressureResults = userService.findAllPressureResults();
    	int index = 0;
    	for(PressureResults result: pressureResults){
    		System.out.println(index+ " " +pressureResults.get(index).getPesel()
    				+ " " +pressureResults.get(index).getSystolic() 
    				+ " " +pressureResults.get(index).getDiastolic());
    		index++;
    	}
        model.addAttribute("pressureResults", pressureResults);
        CheckHypertensionRisk risk = new CheckHypertensionRisk(pressureResults, "");
        return "pressure";
    }
 
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }
 
    @RequestMapping(value = "/dba", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dba";
    }
 
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }
 
    @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
 
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
 
     
    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newuser";
    }
 
    /*
     * This method will be called on form submission, handling POST request It
     * also validates the user input
     */
    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String saveRegistration(@Valid User user,
            BindingResult result, ModelMap model) {
 
        if (result.hasErrors()) {
            System.out.println("There are errors");
            return "newuser";
        }
        userService.save(user);
         
        System.out.println("First Name : "+user.getFirstName());
        System.out.println("Last Name : "+user.getLastName());
        System.out.println("SSO ID : "+user.getSsoId());
        System.out.println("Password : "+user.getPassword());
        System.out.println("Email : "+user.getEmail());
        System.out.println("Checking UsrProfiles....");
        if(user.getUserProfiles()!=null){
            for(UserProfile profile : user.getUserProfiles()){
                System.out.println("Profile : "+ profile.getType());
            }
        }
         
        model.addAttribute("success", "User " + user.getFirstName() + " has been registered successfully");
        return "registrationsuccess";
    }
  
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
     
     
     
    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }
    
    @RequestMapping("/diabetic")
    public String someAction(@ModelAttribute("DiabeticResults") DiabeticResults results, ModelMap model) {

           System.out.println("chosed pesel" + results.getPesel());


           return "diabetic";
       }
}