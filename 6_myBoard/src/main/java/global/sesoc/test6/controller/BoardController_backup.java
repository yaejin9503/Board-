package global.sesoc.test6.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import global.sesoc.test6.dao.BoardRepository;
import global.sesoc.test6.vo.Board;

/*backup용*/
public class BoardController_backup {
	
	@Autowired
	BoardRepository repo; 

	//검색, 첫화면
   @RequestMapping(value="/boardList",method=RequestMethod.GET)
   public String boardList(
		   @RequestParam (value = "searchItem", defaultValue = "title" )String searchItem, 
		   @RequestParam (value = "searchWord", defaultValue = "" )String searchWord, 
		   @RequestParam (value = "currentPage", defaultValue = "1" )int currentPage, Model model,
		   HttpSession session){
	   
	   String loginId = (String)session.getAttribute("loginId");
	   int countPerPage = 10; 
	   //System.out.println(currentPage);
	   int srow = 1+(currentPage-1) * countPerPage;
	   int erow = currentPage * countPerPage;
	   int total = repo.getBoardCount(searchItem,searchWord,srow,erow);
	   int totalPage = 0; 
	   
	   if(total%10!=0){
		   totalPage = (total/countPerPage)+1;
	   }else {
		   totalPage = (total/countPerPage); 
	   }
	   
	   ArrayList<Board> slist = repo.selectAll_backup(searchItem,searchWord,srow,erow);
	   model.addAttribute("totalPage",totalPage);
	   model.addAttribute("searchItem",searchItem);
	   model.addAttribute("searchWord",searchWord);
	   model.addAttribute("currentPage",currentPage);
	   model.addAttribute("countPerPage",countPerPage);
	   model.addAttribute("loginId",loginId);
	   model.addAttribute("list",slist);
	   
      return "board/boardList";
   }
   
   @RequestMapping(value="/boardWrite",method=RequestMethod.GET)
   public String boardWrite(Model model){  //boardWrite 화면요청
	  Date today = new Date();
	  model.addAttribute("today",today); //서버에서 클라이언트 쪽으로 단방향으로 데이터를 전송
      return "board/boardWrite";
      
   }
   
   @RequestMapping(value="/boardwrite",method=RequestMethod.POST)
   public String boardWriteAll(Board board,Model model,HttpSession session){ 
	  String id = (String)session.getAttribute("loginId");
	  board.setUserid(id);
	  int result = repo.insert(board); 
	  if(result==0){
		  model.addAttribute("message","등록실패");
		  return "board/boardWrite";
	  }
      return "redirect:/boardList";
      
   }
   
   @RequestMapping(value="/boardDetail",method=RequestMethod.GET)
   public String boardDetail(int boardseq, Model model){
	   
	   Board board = repo.selectOne(boardseq);
	   model.addAttribute("board",board);
	   return "board/boardDetail"; 
   }
   
   @RequestMapping(value="/boardDelete",method=RequestMethod.POST)
   public String delete(int boardseq){
	   int result = repo.deleteBoard(boardseq);
	   if(result==0){
		   return "board/boardDetail";
	   }
	   return "redirect:/boardList";
   }
   
   @RequestMapping(value="/boardUpdate",method=RequestMethod.GET)
   public String update(Board board, Model model){
	   Date today = new Date();
	   model.addAttribute("today",today);
	   model.addAttribute("boardseq", board.getBoardseq());
	   return "board/boardWrite"; 
   }
   
   @RequestMapping(value="/boardUpdate",method=RequestMethod.POST)
   public String updateBoard(HttpSession session, Board board,Model model, RedirectAttributes redirectAttribute){
		  int result = repo.updateBoard(board); 
		  redirectAttribute.addAttribute("boardseq",board.getBoardseq());
		  if(result==0){
			  model.addAttribute("message","수정실패");
			  return "board/boardWrite";
		  }
	      return "redirect:boardDetail";
   }
}