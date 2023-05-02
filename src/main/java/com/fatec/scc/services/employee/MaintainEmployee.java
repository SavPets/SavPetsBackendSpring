package com.fatec.scc.services.employee;

import java.util.Optional;

import com.fatec.scc.model.employee.Employee;

public interface MaintainEmployee {

	Optional<Employee> searchByCpf(String cpf);

	Optional<Employee> searchById(Long id);

	Optional<Employee> save(Employee employee);

	void delete(Long id);

	Optional<Employee> updates(Long id, Employee employee);

	Object searchAll();

}
