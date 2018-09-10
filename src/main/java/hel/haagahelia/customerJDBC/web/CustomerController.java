package hel.haagahelia.customerJDBC.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hel.haagahelia.customerJDBC.domain.Customer;
import hel.haagahelia.customerJDBC.domain.CustomerRepository;

@Controller
public class CustomerController {
	@Autowired
    private CustomerRepository customerRepo;

	@RequestMapping(value="/customers")
    public String studentList(Model model) {	
        // Fetch all customers
//        List<Map<String, Object>> customers = jdbcTemplate.queryForList("select first_name, last_name from customer");
		List<Customer> customers = customerRepo.findAll();
        
        // Add customers to model and return to view
        model.addAttribute("customers", customers);
        return "customers";
    }
}
