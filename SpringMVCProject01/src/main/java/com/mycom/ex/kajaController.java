package com.mycom.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class kajaController {

	@RequestMapping(value = "/moya.do", method = RequestMethod.POST)
	public String kaja(Model model, HttpServletRequest req) {
		
		String name = req.getParameter("name");
		int score;
		
		try {
			
			if(req.getParameter("score").equals("")) {
				return "error500";
			}else {
				score = Integer.parseInt(req.getParameter("score"));
			}
		
		} catch(NumberFormatException e) {
	         model.addAttribute("error", "숫자를 입력하셔야 했습니다");
	         return "error";
	    }
		String grade = null;

		
		switch (score/10) {
		
		case 10:
		case 9: grade ="A"; break;
		case 8: grade ="B"; break;
		case 7: grade ="C"; break;
		case 6: grade ="D"; break;
		default : grade ="F"; break;
						
		}
		
		model.addAttribute("name",name);
		model.addAttribute("score",score);
		model.addAttribute("grade",grade);
		
		
		return "kaja";
		
	}
	
}
