package com.cargood.cargoodController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cargood.cargoodService.CargoodService;
import com.cargood.cargoodVO.CargoodVO;

@Controller
public class HelloController {
	
	private HttpSession session;
	
	@Autowired
	private CargoodService cargoodService;
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/Hello.jsp";
	}
	
	@RequestMapping("/main")
	public String main(Model model,HttpServletRequest request) {
		
		session = request.getSession();
		//isNew를 사용하기에 로그아웃을할떄 세션말기 시켜야한다 - session.invalidate();
		if( session.isNew() ) {
			session.setAttribute("loginId","nothing");
		}
		
		
		List<CargoodVO> carMainList = cargoodService.mainNewcarListService();
		
		int titleCount = 1;
		int imgCount = 1;
		StringBuilder titleSb = new StringBuilder("mainTitle");
		StringBuilder imgSb = new StringBuilder("mainImg");
		for(CargoodVO tmp : carMainList) {
			titleSb.append(titleCount);
			imgSb.append(imgCount);
			request.setAttribute(titleSb.toString(),tmp.getCARTITLE());
			request.setAttribute(imgSb.toString(),tmp.getCARIMG1());
			++titleCount;
			++imgCount;
			titleSb.deleteCharAt(titleSb.length()-1);
			imgSb.deleteCharAt(imgSb.length()-1);
		}//for
		
		
		
		return "/WEB-INF/views/main.jsp";
	}//main
	
	
	
	@RequestMapping("/login")
	public String mainLogin(Model model,HttpServletRequest request) {
		return "/WEB-INF/views/login.jsp";
	}
	
	
	@RequestMapping("/loginCon")
	public String loginControll(Model model,HttpServletRequest request) {
		CargoodVO loginVO = new CargoodVO();
		String setId = (String)request.getAttribute("sendId");
		loginVO.setID(setId);
		loginVO.setPW((String)request.getAttribute("sendPw"));
		
		
		if(cargoodService.checkIdPwService(loginVO)==1) {
			request.setAttribute("loginSucMsg","로그인에 성공하였습니다.");
			request.setAttribute("loginSucUrl","/cargood/main");
			session = request.getSession();
			session.setAttribute("loginId",setId);
			return "/WEB-INF/views/loginSuc.jsp";
		}else{
			request.setAttribute("loginFailMsg","아이디 또는 비밀번호가 다릅니다.");
			request.setAttribute("loginFailUrl","/cargood/main");
			return "/WEB-INF/views/loginFail.jsp";
		}
		
	}//loginControll
	
	@RequestMapping("/allCarList")
	public String allCarListService(Model model,HttpServletRequest request) {
		// 쿼리스트링으로 ?selNum 사용할것.
		session = request.getSession();
		
		List<CargoodVO> allCarList = cargoodService.selAllNewCarListService();
		String pagingCount;
		if(allCarList.size()/3==0) {
			pagingCount = Integer.toString(allCarList.size()/3);
			request.setAttribute("pagingCount",pagingCount);
		}else {
			pagingCount = Integer.toString( (allCarList.size()/3)+1 );
			request.setAttribute("pagingCount",pagingCount);
		}
		
		StringBuilder titleSb = new StringBuilder("carTitle");
		StringBuilder imgSb = new StringBuilder("carImg");
		int titleCount = 1;
		int imgCount = 1;
		CargoodVO tmp;
		
		int selPageNum = Integer.parseInt(request.getParameter("selNum"));
		int integerPagingCount = Integer.parseInt(pagingCount);
		if(selPageNum==integerPagingCount) {
			//마지막 페이지를 선택하였을때.
			for(int i = selPageNum - 1 ; i < i + (allCarList.size() - (selPageNum*3-3)) ; i++ ) {
				tmp = allCarList.get(i);
				titleSb.append(titleCount);
				request.setAttribute(titleSb.toString(),tmp.getCARTITLE());
				++titleCount;
				
				imgSb.append(imgCount);
				request.setAttribute(imgSb.toString(),tmp.getCARIMG1());
				++imgCount;
			}
		}else {

			for(int i=selPageNum-1;i<i+3;i++) {
				tmp = allCarList.get(i);
				titleSb.append(titleCount);
				request.setAttribute(titleSb.toString(),tmp.getCARTITLE());
				++titleCount;
				
				imgSb.append(imgCount);
				request.setAttribute(imgSb.toString(),tmp.getCARIMG1());
				++imgCount;
			}
		}
		
		return "/WEB-INF/views/allCarView.jsp";
	}//allCarListService
	
	
	
	@RequestMapping("/selOneCarList")
	public String selOneCarService(Model model,HttpServletRequest request) {
		CargoodVO selOneVO = cargoodService.selOneCarList((String)request.getAttribute("selTitle"));
		session = request.getSession();
		request.setAttribute("selOneTitle",selOneVO.getCARTITLE());
		if(selOneVO.getCARIMG1()!=null) {
			request.setAttribute("selOneImg1",selOneVO.getCARIMG1());
			request.setAttribute("imgCount","1");
		}else if(selOneVO.getCARIMG2()!=null) {
			request.setAttribute("selOneImg2",selOneVO.getCARIMG2());
			request.setAttribute("imgCount","2");
		}else if(selOneVO.getCARIMG3()!=null) {
			request.setAttribute("selOneImg3",selOneVO.getCARIMG3());
			request.setAttribute("imgCount","3");
		}
		
		return "/WEB-INF/views/selOne.jsp";
	}//selOneCarService
	
	
	
}
