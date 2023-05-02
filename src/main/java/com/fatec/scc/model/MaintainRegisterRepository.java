package com.fatec.scc.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintainRegisterRepository extends JpaRepository<Register, Long> {
	Register findByEmail(String email);

	boolean existsByEmail(String email);
}
