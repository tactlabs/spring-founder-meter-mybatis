package org.tact.base.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.tact.base.mybatis.domain.FounderMeter;

@Mapper
public interface FounderMeterMapper {
	
	List<FounderMeter> getAllFounders();

	FounderMeter findByLinkedInLink(@Param("LINKEDIN_LINK") String liLink);
	
	void addFounder(Map<String, Object> map);
	
	void updateFounderById(Map<String, Object> map);
}