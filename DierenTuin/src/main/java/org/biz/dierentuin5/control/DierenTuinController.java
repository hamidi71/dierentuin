package org.biz.dierentuin5.control;

import org.apache.log4j.Logger;
import org.biz.dierentuin5.dao.DierentuinDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tuin")
public class DierenTuinController  {
	protected static Logger logger = Logger.getLogger("DierenTuinController");
	
	@Autowired
	protected DierentuinDAO dierentuinDao;
	
	//vul dierentuin database en stuur tuingevuld.jsp naar browser 
	@RequestMapping(value = "/vuldierentuin.html", method = RequestMethod.GET)
        public String vulDierenTuin() {		
 
		logger.info("vulDierenTuin");
		
		dierentuinDao.vulDierentuin();
 
    	// Wordt gekoppeld aan /jsp/tuingevuld.jsp
    	return "tuingevuld";
	}	
}
