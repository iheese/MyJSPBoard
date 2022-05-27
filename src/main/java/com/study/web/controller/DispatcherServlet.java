package com.study.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.biz.board.BoardDAO;
import com.study.biz.board.BoardVO;
import com.study.biz.user.UserDAO;
import com.study.biz.user.UserVO;

//모든 요청을 받는 디스패처 서블릿
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		System.out.println("===> DispatcherServlet 생성");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자 요청 path 정보를 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("요청 path : " + path);

		// 추출한 path 정보에 따라서 요청을 분기처리
		// 로그인 기능
		if (path.equals("/login.do")) {
			System.out.println("로그인 처리되었습니다.");

			String id = request.getParameter("id");
			String password = request.getParameter("password");

			UserVO vo = new UserVO();
			vo.setId(id);

			UserDAO dao = new UserDAO();
			UserVO user = dao.getUser(vo);

			if (user != null) {
				if (user.getPassword().equals(password)) {
					HttpSession session = request.getSession();
					session.setAttribute("user", user);

					RequestDispatcher dispatcher =
							request.getRequestDispatcher("/getBoardList.do");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher =
							request.getRequestDispatcher("/loginView.do");
					dispatcher.forward(request, response);
				}
			} else {
				response.sendRedirect("/index.jsp");
			}
			
			// 로그아웃 기능
		} else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 처리되었습니다.");
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/");
			
			// 회원 등록 기능
		} else if (path.equals("/insertUser.do")) {
			System.out.println("회원 등록이 처리되었습니다.");
			
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String role = request.getParameter("role");

			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			vo.setName(name);
			vo.setRole(role);

			UserDAO dao = new UserDAO();
			dao.insertUser(vo);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/");
			dispatcher.forward(request, response);
			
			// 게시판 글 입력 기능
		} else if (path.equals("/insertBoard.do")) {
			HttpSession session = request.getSession();
			UserVO user = (UserVO) session.getAttribute("user");
			if(user==null) {
				response.sendRedirect("/index.jsp");
			}else{
				System.out.println("글 등록 처리되었습니다.");
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");

				BoardVO vo = new BoardVO();
				vo.setTitle(title);
				vo.setWriter(writer);
				vo.setContent(content);

				BoardDAO dao = new BoardDAO();
				dao.insertBoard(vo);

				RequestDispatcher dispatcher = request.getRequestDispatcher("getBoardList.do");
				dispatcher.forward(request, response);
			}
			
			// 글 수정 기능
		} else if (path.equals("/updateBoard.do")) {
			HttpSession session = request.getSession();
			UserVO user = (UserVO) session.getAttribute("user");
			if(user==null) {
				response.sendRedirect("/index.jsp");
			}else{
			System.out.println("글 수정 처리되었습니다.");

			String title = request.getParameter("title");
			String seq = request.getParameter("seq");
			String content = request.getParameter("content");

			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setSeq(Integer.parseInt(seq));
			vo.setContent(content);

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);

			RequestDispatcher dispatcher = request.getRequestDispatcher("getBoardList.do");
			dispatcher.forward(request, response);
			}
			
			//글 삭제 기능
		} else if (path.equals("/deleteBoard.do")) {
			HttpSession session = request.getSession();
			UserVO user = (UserVO) session.getAttribute("user");
			if(user==null) {
				response.sendRedirect("/index.jsp");
			}else{
			System.out.println("글 삭제 처리되었습니다.");

			String seq = request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);

			RequestDispatcher dispatcher = request.getRequestDispatcher("getBoardList.do");
			dispatcher.forward(request, response);
			}
			
			// 글 상세 조회 기능
		} else if (path.equals("/getBoard.do")) {
			HttpSession session = request.getSession();
			UserVO user = (UserVO) session.getAttribute("user");
			if(user==null) {
				response.sendRedirect("/index.jsp");
			}else{
			System.out.println("글 상세 조회 처리되었습니다.");

			String seq = request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO dao = new BoardDAO();
			BoardVO board = dao.getBoard(vo);
			dao.upCountBoard(board);
			
			request.setAttribute("board", board);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/getBoard.jsp");
			dispatcher.forward(request, response);
			
			}
			
			// 글 목록 조회 기능
		} else if (path.equals("/getBoardList.do")) {
			HttpSession session = request.getSession();
			UserVO user = (UserVO) session.getAttribute("user");
			if(user==null) {
				response.sendRedirect("/index.jsp");
			}else{		
			System.out.println("글 목록 검색 및 목록 출력 처리되었습니다.");

			String select = request.getParameter("select");
			String searchContent = request.getParameter("searchContent");

			if (select == null)
				select = "title";
			if (searchContent == null)
				searchContent = "";

			request.setAttribute("select", select);
			request.setAttribute("searchContent", searchContent);
			session.setAttribute("select", select);
			session.setAttribute("searchContent", searchContent);
			
			BoardVO vo = new BoardVO();
			vo.setSelect(select);
			vo.setSearchContent(searchContent);

			BoardDAO dao = new BoardDAO();
			List<BoardVO> boardList = dao.getBoardList(vo);
			
			request.setAttribute("boardList", boardList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/getBoardList.jsp");
			dispatcher.forward(request, response);
			}
			
		} else if (path.equals("/insertUserView.do")) {
			System.out.println("회원가입 화면 이동 처리되었습니다.");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/WEB-INF/board/insertUser.jsp");
				dispatcher.forward(request, response);

		} else if (path.equals("/loginView.do")) {
			System.out.println("로그인 화면 이동 처리되었습니다.");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/WEB-INF/board/login.jsp");
				dispatcher.forward(request, response);

		} else if (path.equals("/insertBoardView.do")) {
			System.out.println("글 등록 화면 이동 처리되었습니다.");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/WEB-INF/board/insertBoard.jsp");
				dispatcher.forward(request, response);
			
			// 잘못된 접근 처리 기능
		} else {
			System.out.println("요청 URL이 잘못되었습니다.");
			response.sendRedirect("/index.jsp");
		}

	}

}
