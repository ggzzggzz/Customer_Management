package kr.co.infracube.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.infracube.dto.AdminDto;
import kr.co.infracube.dto.CustomerDto;
import kr.co.infracube.service.MainService;

@Controller
public class MainController {
	@Autowired
	MainService mainservice;
	
	//로그인
	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping("/processLogin.do")
	public ModelAndView processLogin(AdminDto admin, HttpServletRequest request) throws Exception{
		AdminDto dto = mainservice.processLogin(admin);
		System.out.println(dto);
		if(dto == null)
			return login(request);
		HttpSession session = request.getSession();
		session.setAttribute("sessionId", dto.getEmail());
		session.setAttribute("sessionName", dto.getAName());
		return groupCode(request);
	}
	
	//logout.do
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return login(request);
	}
	
	//비밀번호 재설정
	@RequestMapping("/passwordReset.do")
	public ModelAndView passwordReset() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("apass_reset");
		return mv;
	}
	
	//그룹코드
	@RequestMapping("/groupCode.do")
	public ModelAndView groupCode(HttpServletRequest request) throws Exception{
		//CodeDto dto = new CodeDto();
		//dto = mainservice.getGroupCode(dto);
		ModelAndView mv = new ModelAndView();
		//mv.addObject("groupCode", dto);
		mv.setViewName("code_group");
		HttpSession session = request.getSession();
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		return mv;
	}
	
	//기초코드
	@RequestMapping("/baseCode.do")
	public ModelAndView baseCode(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("code_base");
		HttpSession session = request.getSession();
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		return mv;
	}
	
	//고객
	@RequestMapping("/customer.do")
	public ModelAndView customer(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer");
		HttpSession session = request.getSession();
		List<CustomerDto> list = mainservice.listCustomers(null);
		System.out.println(list);
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		mv.addObject("list", list);
		return mv;
	}
	
	//insertCustomer.do
	@RequestMapping("/insertCustomer.do")
	public ModelAndView insertCustomer(CustomerDto dto, HttpServletRequest request) throws Exception{
		mainservice.insertCustomer(dto);
		System.out.println(dto);
		return customer(request);
	}
	
	//납품
	@RequestMapping("/delivery.do")
	public ModelAndView delivery(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("delivery");
		HttpSession session = request.getSession();
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		return mv;
	}
	@RequestMapping("/deliveryEdit.do")
	public ModelAndView deliveryEdit(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("delivery_edit");
		HttpSession session = request.getSession();
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		return mv;
	}
	@RequestMapping("/deliveryNew.do")
	public ModelAndView deliveryNew(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("delivery_new");
		HttpSession session = request.getSession();
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		return mv;
	}
	
	//관리자
	@RequestMapping("/systemset.do")
	public ModelAndView systemset(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("systemset");
		HttpSession session = request.getSession();
		List<AdminDto> list = mainservice.listAdmins(null);
		System.out.println(list);
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		mv.addObject("list", list);
		return mv;
	}
	
	//insertAdmin.do
	@RequestMapping("/insertAdmin.do")
	public ModelAndView insertAdmin(AdminDto dto, HttpServletRequest request) throws Exception{
		mainservice.insertAdmin(dto);
		System.out.println(dto);
		return systemset(request);
	}
	
	//updateAdmin.do
	@RequestMapping("/updateAdmin.do")
	public ModelAndView updateAdmin(HttpServletRequest request) throws Exception{
		AdminDto admin = new AdminDto();
		HttpSession session = request.getSession();
		admin.setEmail(session.getAttribute("sessionId").toString());
		System.out.println(admin);
		admin = mainservice.infoAdmin(admin);
		System.out.println(admin);
		ModelAndView mv = new ModelAndView();
		mv.addObject("admin", admin);
		return systemset(request);
	}
	@RequestMapping("/processUpdateAdmin.do")
	public ModelAndView processUpdateAdmin(AdminDto dto, HttpServletRequest request) throws Exception{
		mainservice.processUpdateAdmin(dto);
		System.out.println(dto);
		return systemset(request);
	}
}
