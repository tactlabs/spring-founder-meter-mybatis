package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tact.base.mybatis.domain.FounderMeter;
import org.tact.base.mybatis.mapper.FounderMeterMapper;

@RestController
@RequestMapping(value = "/founder-meter")
public class FounderMeterController {
	
	@Autowired
    private FounderMeterMapper ffMapper;
	
	/**
	 * 
	 * @return
	 * 
	 * possible urls:
	 * 		/founder-meter
	 * 		http://localhost:1878/founder-meter
	 */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public <T> T listUsers() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        map.put("five", "six");
        map.put("seven", "eight");
        
        return (T) map;
    }
    
    /**
     * 
     * @param liLink
     * @return
     * 
     * possible urls:
     * 		/by/li-link
	 * 		/founder-meter/by/li-link
	 * 		http://localhost:1878/founder-meter/by/li-link
	 * 
     */
    @GetMapping(value = "/by/li-link")
    public <T> T getFFounderByLinkedInLink(
    		@RequestParam(value = "li_link")String liLink) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        FounderMeter fFounder = ffMapper.findByLinkedInLink(liLink);
        
        map.put("li_link", liLink);
        map.put("city", fFounder);
        
        return (T) map;
    }
    
    /**
     * 
     * @return
     * 
     * possible urls:
     * 		/get/all
	 * 		/founder-meter/get/all
	 * 		http://localhost:1878/founder-meter/get/all
     */
    @GetMapping(value = "/get/all")
    public <T> T getAllFounders(
    		) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        List<FounderMeter> fFounderList = ffMapper.getAllFounders();
        
        map.put("founders", fFounderList);        
        
        return (T) map;
    }
    
    /**
     * 
     * @param name
     * @param liLink
     * @param authMeter
     * @param adminComment
     * @return
     * 
     * possible urls:
     * 		/add
	 * 		/founder-meter/add
	 * 		http://localhost:1878/founder-meter/add
     * 
     */
    @PostMapping(value = "/add")
    public <T> T addFounder(
		@RequestParam(value = "name", required=false) String name,
		@RequestParam(value = "li_link") String liLink,
		@RequestParam(value = "auth_meter") Integer authMeter,
		@RequestParam(value = "admin_comment") String adminComment
    	) {
        
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
    	
    	Map<String, Object> paramMap = new LinkedHashMap<String, Object>();
    	paramMap.put("NAME", name);
    	paramMap.put("LINKEDIN_LINK", liLink);
    	paramMap.put("AUTH_METER", authMeter);
    	paramMap.put("ADMIN_COMMENT", adminComment);
        
        ffMapper.addFounder(paramMap);
        
        map.put("apiresult", 0);
        map.put("apimessage", "ok");
        
        return (T) map;
    }
    
    /**
     * 
     * @param it
     * @param name
     * @param liLink
     * @param authMeter
     * @param adminComment
     * @return
     * 
     * possible urls:
     * 		/update
	 * 		/founder-meter/update
	 * 		http://localhost:1878/founder-meter/update
     */
    @PostMapping(value = "/update")
    public <T> T updateFounder(
    	@RequestParam(value = "id") Long id,
		@RequestParam(value = "name", required=false) String name,
		@RequestParam(value = "li_link", required=false) String liLink,
		@RequestParam(value = "auth_meter", required=false) Integer authMeter,
		@RequestParam(value = "admin_comment", required=false) String adminComment
    	) {
        
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
    	
    	Map<String, Object> paramMap = new LinkedHashMap<String, Object>();
    	paramMap.put("ID", id);
    	paramMap.put("NAME", name);
    	paramMap.put("LINKEDIN_LINK", liLink);
    	paramMap.put("AUTH_METER", authMeter);
    	paramMap.put("ADMIN_COMMENT", adminComment);
        
        ffMapper.updateFounderById(paramMap);
        
        map.put("apiresult", 0);
        map.put("apimessage", "ok");
        
        return (T) map;
    }
}
