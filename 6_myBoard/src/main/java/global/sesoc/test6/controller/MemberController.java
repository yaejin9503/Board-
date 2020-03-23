package global.sesoc.test6.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.test6.dao.MemberRepository;
import global.sesoc.test6.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	MemberRepository resc; 
	
	//회원가입 화면 요청
	@RequestMapping(value = "/signup" , method = RequestMethod.GET)
	public String signup(){
		return "member/signup";
	}

	//회원가입 처리를 요청 
	@RequestMapping(value = "/signup" , method = RequestMethod.POST)
	public String signupProcess(Member m){
		System.out.println(m);
		resc.insert(m); 
		return "index";
	}

	//로그인 화면요청 
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public String login(){ 
		
		return "member/login"; 
	}
	
	//로그인 처리 요청 --> 비밀번호를 넘겨줘야하기 때문에  
	@RequestMapping(value ="/login" , method = RequestMethod.POST)
	public String signinProcess(Member m, HttpSession session, Model model){ //클라이언트에서 받은 id, pwd랑 같아야함  
		Member member = resc.selectone(m);
		
		//HttpSession에 아이디를 저장해야함
		//HttpSession 한 사람에게 할당된 메모리 공간이라고 생각하면됨.
		//브라우저 하나에 할당된 공간 
		if(member!=null){
			session.setAttribute("loginId", member.getUserid());
			session.setAttribute("loginName", member.getUsername());
			return "index";
		}
		model.addAttribute("message", "아이디와 비밀번호가 틀립니다.");
		return "member/login"; 
	}

	//로그아웃 
	@RequestMapping(value ="/logout" , method = RequestMethod.GET)
	public String logout(Member m, HttpSession session){
		//session.removeAttribute("loginId");
		//session.removeAttribute("loginName");
		session.invalidate();
		return "index"; 
	}
	@RequestMapping(value = "/dropout" , method = RequestMethod.GET)
	public String dropMember(){
		return "member/delete";
	}
	
	@RequestMapping(value ="/dropout", method = RequestMethod.POST)
	public String dropMember1(Member m, Model model, HttpSession session){
		int member = resc.delete(m); 
		if(member==0){
			model.addAttribute("message","비밀번호 잘못임력");
			return "member/delete";
		}
		session.invalidate();
		return "index"; 
	}
	
	//페이지 이동 
	@RequestMapping(value = "/modify" , method = RequestMethod.GET)
	public String modify(){
		return "member/modifypwd";
	}
	
	//비밀번호 확인창 
	@RequestMapping(value = "/modifydelete" , method = RequestMethod.GET)
	public String modifydelte(Model model, Member m){
		Member member = resc.selectone(m);
		if(member==null){
			model.addAttribute("message","비밀번호 잘못임력");
			return "member/modifypwd";
		}
		return "member/modify";
	}
	
	@RequestMapping(value = "/modify" , method = RequestMethod.POST)
	public String modify2(Member m, Model model, HttpSession session ){
		int member = resc.update(m); 
		if(member==0){
			model.addAttribute("message","수정에 실패했습니다.");
			return "member/modify";
		}
		return "index"; 
	}
	
}
