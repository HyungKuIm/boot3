package com.oraclejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class CustomerController {

	private static final int PAGE_SIZE = 10;
	
	@Autowired
	private CustomerRepository customerRepository;
    @Autowired
	private PasswordEncoder passwordEncoder;
		
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ModelAndView customers(@RequestParam(required = false, value = "page") Integer pageNumber) {
		pageNumber = (pageNumber == null) ?  1 : pageNumber; 
 		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customers");
		
		//Page<Customer> customers = CustomerRepository.findAll(PageRequest.of(pageNumber -1 , PAGE_SIZE, Sort.by("customer_code")));
		Page<Customer> customers = customerRepository.findAll(PageRequest.of(pageNumber -1 , PAGE_SIZE, Sort.by("customerCode")));
		
		int current = customers.getNumber() + 1; 
		int begin = 1;
		int end = customers.getTotalPages();
		
		mav.addObject("customerList", customers);
		mav.addObject("beginIndex", begin);
		mav.addObject("endIndex", end);
		mav.addObject("currentIndex", current);
		
		return mav;
	}
	
	@RequestMapping(value="/customers/create", method = RequestMethod.GET)
	public String create(Model model) {
		return "customerCreate";
	}
	
	@RequestMapping(value="/customers/create", method = RequestMethod.POST)
	public String create(Customer customer, Model model) {
		
		String pass = customer.getCustomerPass();
		
		customer.setCustomerPass(passwordEncoder.encode(pass));
		
		customerRepository.save(customer);
		
		return "redirect:/customers/";
	}
	
	@RequestMapping(value = "customers/update/{customerCode}", method = RequestMethod.GET)
	public String update(@PathVariable Integer customerCode, Model model) {
		Customer customer = customerRepository.findById(customerCode).get();
		model.addAttribute("customer", customer);
		return "customerUpdate";
	}
	
	
	@RequestMapping(params = "update", value = "customers/update/{customerCode}", method = RequestMethod.POST)
	public String update(Customer customer, Model model) {
		
		Customer customers = customerRepository.findById(customer.getCustomerCode()).get();
		customers.setCustomerName(customer.getCustomerName());
//		System.out.println(customer.getCustomerName());
		String oldPassword = customers.getCustomerPass();
		String newPassword = customer.getCustomerPass();

		if (!newPassword.equals(oldPassword)) {
			//비번을 변경한 것이므로 암호화를 한다.
			customer.setCustomerPass(passwordEncoder.encode(newPassword));
		}


		customers.setCustomerPass(customer.getCustomerPass());
		customers.setCustomerBirth(customer.getCustomerBirth());
		customers.setCustomerJob(customer.getCustomerJob());
		customers.setCustomerMail(customer.getCustomerMail());
		customers.setCustomerTel(customer.getCustomerTel());
		customers.setCustomerPost(customer.getCustomerPost());
		customers.setCustomerAdd(customer.getCustomerAdd());
		
		customerRepository.save(customers);
		
		return "redirect:/customers/";
	}
	
	@RequestMapping(params = "delete", value = "customers/update/{customerCode}", method = RequestMethod.POST)
	public String delete(@PathVariable Integer customerCode, Model model) {
		Customer cust = customerRepository.findById(customerCode).get();
		customerRepository.delete(cust);
		return "redirect:/customers/";
	}
}
















