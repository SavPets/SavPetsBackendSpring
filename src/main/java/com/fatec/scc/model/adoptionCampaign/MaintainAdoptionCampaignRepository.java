package com.fatec.scc.model.adoptionCampaign;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintainAdoptionCampaignRepository extends JpaRepository<AdoptionCampaign, Long>{

}
