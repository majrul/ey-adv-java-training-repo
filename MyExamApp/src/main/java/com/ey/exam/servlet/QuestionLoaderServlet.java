package com.ey.exam.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ey.exam.core.Question;
import com.ey.exam.core.QuestionBankLoader;

/**
 * Servlet implementation class QuestionLoaderServlet
 */
@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {

	int qNo = 0; //TODO: use session to store/retrieve the qNo

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionBankLoader qbLoader = new QuestionBankLoader();
		List<Question> questions = qbLoader.loadQuestionsOnHTML();

		HttpSession session = request.getSession();
		
		if(qNo < questions.size()) {		
			Question question = questions.get(qNo++);
			
			session.setAttribute("question", question);
			
			response.sendRedirect("showQuestion.jsp");
		}
		else
			response.sendRedirect("showResult.jsp");
	}

}
