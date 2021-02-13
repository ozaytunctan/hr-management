package com.tr.hr.startup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tr.hr.entity.Employee;
import com.tr.hr.entity.Phone;
import com.tr.hr.entity.Position;
import com.tr.hr.enums.PhoneTitle;
import com.tr.hr.repository.EmployeeRepository;
import com.tr.hr.repository.PositionRepository;

@Component
public class Startup implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
     private PositionRepository positionRepository;
	@Override
	public void run(String... args) throws Exception {
		List<Employee> employees = new ArrayList<>();

		Position position=new Position();
		position.setCode("IK");
		position.setName("Insan Kaynakları");
		position=positionRepository.saveAndFlush(position);
		
		for (int i = 0; i <= 9; i++) {
			Phone phone = new Phone();
			phone.setTitle(PhoneTitle.MOBILE);
			phone.setCountryCode("90");
			phone.setAreaCode("538");
			phone.setNumber("011046" + i);
			phone.ceatePhone("90","538","011046" + i);

			Employee employee = new Employee();
			employee.setFirstName(i + ".test-name");
			employee.setLastName(i + ".test-lastname");
			employee.addPhone(phone);
			employee.setPosition(position);
			
			if (i==5) {
				Phone phone2 = new Phone();
				phone2.setTitle(PhoneTitle.HOME);
				phone2.ceatePhone("90","222","8110401");
				employee.addPhone(phone2);
				employee.setPosition(new Position(position.getId()));
			}
			
			if (i==6) {
				
				employee.setPosition(new Position(0));
			}
			
			
			employees.add(employee);
		}

		this.employeeRepository.saveAll(employees);
	}

}
