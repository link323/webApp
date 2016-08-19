package com.websystique.springsecurity.controller;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.medapp.calculations.BMITask;
import com.medapp.calculations.CholesterolTasks;
import com.websystique.springsecurity.drools.CheckDiabetesRisk;
import com.websystique.springsecurity.drools.CheckHypertensionRisk;
import com.websystique.springsecurity.model.BMI;
import com.websystique.springsecurity.model.Cholesterol;
import com.websystique.springsecurity.model.DiabeticResults;
import com.websystique.springsecurity.model.Pacients;
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
        model.addAttribute("users", users);
        
    	List<DiabeticResults> diabeticResults = userService.findAllDiabeticResults();
        model.addAttribute("diabeticResults", diabeticResults);
        
    	List<PressureResults> pressureResults = userService.findAllPressureResults();
        model.addAttribute("pressureResults", pressureResults);
//        for(){
//        	
//        }
        return "welcome";
    }
    
    @RequestMapping(value = "/diabetic", method = RequestMethod.GET)
    public String diabeticPage(ModelMap model) {
    	
    	List<DiabeticResults> diabeticResults = userService.findAllDiabeticResults();
        model.addAttribute("diabeticResults", diabeticResults);
//
//        List<Pacients> pacientsList = new ArrayList<>();
//        model.addAttribute("pacients", pacientsList);
//        
        Pacients chosenPacient = new Pacients();
        model.addAttribute("chosenPacient", chosenPacient);
        return "diabetic";
    }
    
    @RequestMapping(value = "/diabetic", method = RequestMethod.POST)
    public String diabeticPage(@ModelAttribute("chosenPacient") Pacients chosenPacient,
            ModelMap model) {
    	
      List<Pacients> allPacientsList = userService.findAllPacients();
      List<Pacients> pacientsList = new ArrayList<>();
      List<DiabeticResults> diabeticResults = userService.findAllDiabeticResults();
      List<DiabeticResults> onePacientDiabeticResults = new ArrayList<>();
      for(DiabeticResults result : diabeticResults){
    	  if(result.getPesel().equals(chosenPacient.getPesel())){
    		  onePacientDiabeticResults.add(result);
    	  }
      }
      model.addAttribute("diabeticResults", onePacientDiabeticResults);
      return "diabetic";
    }
    
    @RequestMapping(value = "/pressure", method = RequestMethod.GET)
    public String pressurePage(ModelMap model) {

    	List<PressureResults> pressureResults = userService.findAllPressureResults();
        model.addAttribute("pressureResults", pressureResults);
        
        Pacients chosenPacient = new Pacients();
        model.addAttribute("chosenPacient", chosenPacient);
//        List<Pacients> pacientsList = userService.findAllPacients();
//        for(Pacients pacient : pacientsList){
//        	System.out.println(pacient.getName() + " " + pacient.getSurname() + " " + pacient.getPesel());
//        }
//        model.addAttribute("pacients", pacientsList);
//        CheckHypertensionRisk risk = new CheckHypertensionRisk(pressureResults, "");
//        risk.callDrools();
        return "pressure";
    }
 
    @RequestMapping(value = "/pressure", method = RequestMethod.POST)
    public String pressurePage(@ModelAttribute("chosenPacient") Pacients chosenPacient,
            ModelMap model) {
    	
      List<Pacients> allPacientsList = userService.findAllPacients();
      List<PressureResults> pressureResults = userService.findAllPressureResults();
      List<PressureResults> onePacientPressureResults = new ArrayList<>();
      for(PressureResults result : pressureResults){
    	  if(result.getPesel().equals(chosenPacient.getPesel())){
    		  onePacientPressureResults.add(result);
    	  }
      }
      model.addAttribute("pressureResults", onePacientPressureResults);
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
    
    @RequestMapping(value = "/calculators", method = RequestMethod.GET)
    public String newCalculation(ModelMap model) {
        return "calculators";
    }
    
    @RequestMapping(value = "/bmiform", method = RequestMethod.GET)
    public String bmiForm(ModelMap model) {
        BMI bmi = new BMI();
        model.addAttribute("bmi", bmi);

        return "bmiform";
    }
    
    @RequestMapping(value = "/bmiform", method = RequestMethod.POST)
    public String bmiForm(@ModelAttribute("bmi") BMI bmi,
            ModelMap model) {
        
        String countedBmi = new BMITask(bmi).count(); 
        model.addAttribute("result", countedBmi);
        System.out.println(countedBmi);
        
        return "bmiform";
    }
  
    @RequestMapping(value = "/cholesterolform", method = RequestMethod.GET)
    public String cholesterolForm(ModelMap model) {

    	Cholesterol cholesterol = new Cholesterol();
        model.addAttribute("cholesterol", cholesterol);
        return "cholesterolform";
    }
    
    @RequestMapping(value = "/cholesterolform", method = RequestMethod.POST)
    public String cholesterolForm(@ModelAttribute("cholesterol") Cholesterol cholesterol,
            ModelMap model) {
        
        CholesterolTasks task = new CholesterolTasks(cholesterol);
        String checkedTotalCholesterol = task.checkTotal();
        String checkedHDLCholesterolMan = task.checkHDLMan();
//        String checkedHDLCholesterolWoman = new CholesterolTasks(cholesterol).checkHDLWoman();
        String checkedLDLCholesterol = task.checkLDL();
        model.addAttribute("total", checkedTotalCholesterol);
        model.addAttribute("hdl", checkedHDLCholesterolMan);
        model.addAttribute("ldl", checkedLDLCholesterol);
        return "cholesterolform";
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