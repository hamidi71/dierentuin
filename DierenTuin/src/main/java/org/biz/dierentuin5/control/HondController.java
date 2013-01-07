package org.biz.dierentuin5.control;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.biz.dierentuin5.dao.HondDAO;
import org.biz.dierentuin5.model.Hond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hond")
public class HondController  {
	protected static Logger logger = Logger.getLogger("HondController");
	
	@Autowired
	protected HondDAO hondDao;

	 
	//stuur addhond.jsp form naar browser 
	@RequestMapping(value = "/addhond.html", method = RequestMethod.GET)
        public String addHond() {		
 
		logger.info("addHond");
 
    	// Wordt gekoppeld aan /jsp/addhond.jsp
    	return "addhond";
	}	
		
	//verwerk input van addhond.jsp
	@RequestMapping(value = "/addhondpost.html", method = RequestMethod.POST)
	public String addHondPost(@RequestParam(value="fldNaam", required=true) String fldNaam, Map<String, Object> model) {
 
		logger.info("addHondPost");	
		
		Hond hond = new Hond();
		hond.setNaam(fldNaam);
		hondDao.save(hond);
		
		model.put("fldNaam", fldNaam);
		
		List<Hond> honden = hondDao.getAll();
		model.put("honden", honden);
 
	    // Wordt gekoppeld aan /jsp/honden.jsp
	    return "honden";
	}	

	//stuur honden.jsp form naar browser 
	@RequestMapping(value = "/honden.html", method = RequestMethod.GET)
	public String Honden(Map<String, Object> model) {
 
		logger.info("Honden");	
		
		List<Hond> honden = hondDao.getAll();
		model.put("honden", honden);
 
	    // Wordt gekoppeld aan /jsp/honden.jsp
	    return "honden";
	}	
 
}
