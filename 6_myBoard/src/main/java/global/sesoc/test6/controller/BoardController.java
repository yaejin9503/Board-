package global.sesoc.test6.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import global.sesoc.test6.dao.BoardRepository;
import global.sesoc.test6.util.FileService;
import global.sesoc.test6.util.PageNavigator;
import global.sesoc.test6.vo.Board;

@Controller
public class BoardController {
	
	@Autowired
	BoardRepository repo; 
	
	final String uploadPath="/uploadfile"; //업로드 path는 수정이 될 게 아니라서 final로 지정해 줘도 됨 

	//검색, 첫화면
   @RequestMapping(value="/boardList",method=RequestMethod.GET)
   public String boardList(
		   @RequestParam (value = "searchItem", defaultValue = "title" )String searchItem, 
		   @RequestParam (value = "searchWord", defaultValue = "" )String searchWord, 
		   @RequestParam (value = "currentPage", defaultValue = "1" )int currentPage, Model model,
		   HttpSession session){
	   
	   String loginId = (String)session.getAttribute("loginId");
	 
	   //게시글 전체 개수 조회 
	   int totalRecordCount = repo.getBoardCount(searchItem, searchWord);
	   PageNavigator navi = new PageNavigator(currentPage, totalRecordCount);
	   List<Board> list = repo.selectAll(searchItem, searchWord,navi.getStartRecord(),navi.getCountPerPage());
	   
	   //결정
	   int countPerpage = 10; 
	    
	   model.addAttribute("searchItem",searchItem);
	   model.addAttribute("searchWord",searchWord);
	   model.addAttribute("navi",navi);
	   model.addAttribute("loginId",loginId);
	   model.addAttribute("list",list);
	   
      return "board/boardList";
   }
   
   @RequestMapping(value="/boardWrite",method=RequestMethod.GET)
   public String boardWrite(Model model){  //boardWrite 화면요청
	  Date today = new Date();
	  model.addAttribute("today",today); //서버에서 클라이언트 쪽으로 단방향으로 데이터를 전송
      return "board/boardWrite";
      
   }
   
   @RequestMapping(value="/boardwrite",method=RequestMethod.POST)
   public String boardWriteAll(Board board,Model model,MultipartFile upload ,HttpSession session){ 
	  String id = (String)session.getAttribute("loginId");
	  board.setUserid(id);
	  
	  String originalfile = upload.getOriginalFilename();
	  String savedfile = FileService.saveFile(upload, uploadPath);

	  board.setOriginalfile(originalfile);
	  board.setSavedfile(savedfile);
	
	  int result = repo.insert(board); 
	  	if(result==0){
	  		model.addAttribute("message","등록실패");
	  		return "board/boardWrite";
	 }
     return "redirect:/boardList";
   }
   
   @RequestMapping(value="/boardDetail",method=RequestMethod.GET)
   public String boardDetail(int boardseq, Model model){
	   int result = repo.updateViewcount(boardseq);
	   if(result==0){
		   return "board/boardList";
	   }
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
  
   //파일 다운로드
   @RequestMapping(value ="/download", method=RequestMethod.GET)
   public String download(int boardseq,HttpServletResponse response){
	   Board board = repo.selectOne(boardseq); 
	   String savedfile = board.getSavedfile();
	   String originalfile = board.getOriginalfile();
	  
	   response.setHeader("Content-Disposition", "attachment;filename="+ originalfile);
	   
	   String fullPath = uploadPath + "/" + savedfile;
	   
	   FileInputStream filein = null;
	   ServletOutputStream  fileout = null; 
	   
	   try {
		filein = new FileInputStream(fullPath);
		fileout = response.getOutputStream();
		
		FileCopyUtils.copy(filein, fileout);
		
		filein.close();
		fileout.close();
		
	   }catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	   return null; 
   }
}