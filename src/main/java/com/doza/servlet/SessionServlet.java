package com.doza.servlet;

import com.doza.dto.CreatePersonDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {

    public static final String PERSON = "person";

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        var person = (CreatePersonDto) session.getAttribute(PERSON);
//        if (person == null) {
//            person = new CreatePersonDto(25L, "test@gmail.com");
//            session.setAttribute(PERSON, person);
//        }
//    }
}
