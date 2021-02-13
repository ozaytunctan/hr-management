package com.tr.hr.startup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tr.hr.entity.Department;
import com.tr.hr.entity.Employee;
import com.tr.hr.entity.EmployeeDepartmentHistory;
import com.tr.hr.entity.Phone;
import com.tr.hr.entity.Position;
import com.tr.hr.enums.PhoneTitle;
import com.tr.hr.repository.DepartmentRespository;
import com.tr.hr.repository.EmployeeDepartmentHistoryRepository;
import com.tr.hr.repository.PositionRepository;

@Component
public class Startup implements CommandLineRunner {

	@Autowired
	private PositionRepository positionRepository;

	@Autowired
	private DepartmentRespository departmentRespository;

	@Autowired
	private EmployeeDepartmentHistoryRepository employeeDepartmentHistoryRepository;

	@Override
	public void run(String... args) throws Exception {
		saveEmployeeDepartmentHistory();
	}

	private void saveEmployeeDepartmentHistory() {

		List<EmployeeDepartmentHistory> employeeDepartmentHistories = new ArrayList<>();

		Position positionYZ = new Position();
		positionYZ.setCode("YZ-0");
		positionYZ.setName("Java Yazılım Mühendisi");
		positionYZ = positionRepository.saveAndFlush(positionYZ);

		Department departmentIK = new Department("IK", "INSAN KAYNAKLARI");
		departmentIK = departmentRespository.saveAndFlush(departmentIK);

		for (int i = 0; i <= 9; i++) {

			Phone phone = new Phone();
			phone.setTitle(PhoneTitle.MOBILE);
			phone.ceatePhone("90", "538", "011046" + i);

			Employee employee = new Employee();
			employee.setFirstName(i + ".test-name");
			employee.setLastName(i + ".test-lastname");
			employee.addPhone(phone);
			if (i == 1) {
				Phone phone2 = new Phone();
				phone2.setTitle(PhoneTitle.HOME);
				phone2.ceatePhone("90", "222", "8110401");
				employee.addPhone(phone2);
			}

			EmployeeDepartmentHistory employeeDepartmentHistory = new EmployeeDepartmentHistory();

			employeeDepartmentHistory.setEmployee(employee);
			employeeDepartmentHistory.setPosition(positionYZ);
			employeeDepartmentHistory.setDepartment(departmentIK);

			if (i == 3) {
//				employeeDepartmentHistory.setPosition(this.positionRepository.saveAndFlush(new Position("IK-0", "Insan Kaynakları Yrdmcs")));
//				employeeDepartmentHistory.setDepartment(this.departmentRespository.saveAndFlush(new Department("YZLM", "YAZILIM")));
				employeeDepartmentHistory.setPosition(new Position("IK-0", "Insan Kaynakları Yrdmcs"));
				employeeDepartmentHistory.setDepartment(new Department("YZLM", "YAZILIM"));
			}

			if (i == 5) {
				employeeDepartmentHistory.setPosition(new Position("IK-1", "Insan Kaynakları Müdürü"));
				employeeDepartmentHistory.setDepartment(new Department(departmentIK.getId()));
			}
			
			if (i == 8) {
				employeeDepartmentHistory.setPosition(new Position(positionYZ.getId()));
				employeeDepartmentHistory.setDepartment(new Department(departmentIK.getId()));
			}

			employeeDepartmentHistories.add(employeeDepartmentHistory);
			
		}

		this.employeeDepartmentHistoryRepository.saveAll(employeeDepartmentHistories);

	}

}
