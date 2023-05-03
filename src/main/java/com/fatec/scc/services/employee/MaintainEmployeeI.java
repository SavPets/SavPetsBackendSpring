package com.fatec.scc.services.employee;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.scc.model.departament.Departament;
import com.fatec.scc.model.departament.MaintainDepartamentRepository;
import com.fatec.scc.model.employee.Employee;
import com.fatec.scc.model.employee.MaintainEmployeeRepository;
import com.fatec.scc.model.occupation.MaintainOccupationRepository;
import com.fatec.scc.model.occupation.Occupation;

@Service
public class MaintainEmployeeI implements MaintainEmployee {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	MaintainEmployeeRepository repository;
	@Autowired
	MaintainDepartamentRepository repositoryD;
	@Autowired
	MaintainOccupationRepository repositoryO;

	public List<Employee> searchAll() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repository.findAll();
	}

	@Override
	public Optional<Employee> searchByCpf(String cpf) {
		logger.info(">>>>>> servico consultaPorCpf chamado");
		return repository.findByCpf(cpf);
	}

	@Override
	public Optional<Employee> searchById(Long id) {
		logger.info(">>>>>> servico consultaPorId chamado");
		return repository.findById(id);
	}

	@Override
	public Optional<Employee> save(Employee employee) {
		logger.info(">>>>>> servico save chamado ");
		employee.setPassword("123");
		employee.setRepeatPassword("123");
		return Optional.ofNullable(repository.save(employee));
	}

	@Override
	public void delete(Long id) {
		logger.info(">>>>>> servico delete por id chamado");
		repository.deleteById(id);
	}

	@Override
	public Optional<Employee> updates(Long id, Employee employee) {
		logger.info(">>>>>> 1.servico atualiza informações de funcionario chamado");
		Employee modifiedEmployee = new Employee(employee.getName(), employee.getSurname(), employee.getEmail(), employee.getPassword(), employee.getRepeatPassword(), employee.getCpf(), employee.getCep(), employee.getAddress(), employee.getComplement(), employee.getAccountNumber(), employee.getDepartament(), employee.getOccupation());
		Employee modifiedEmployee2 = this.repository.findById(id).get();

		modifiedEmployee.setId(id);
		
		
		if (employee.getCpf() == null) {
			employee.setCpf(modifiedEmployee2.getCpf());
		}


		modifiedEmployee.setCpf(employee.getCpf());
		return Optional.ofNullable(repository.save(modifiedEmployee));
	}
	
	@Override
	public List<Departament> searchAllDepartaments() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repositoryD.findAll();
	}
	
	@Override
	public List<Occupation> searchAllOccupations() {
		logger.info(">>>>>> servico consultaTodos chamado");
		return repositoryO.findAll();
	}
}