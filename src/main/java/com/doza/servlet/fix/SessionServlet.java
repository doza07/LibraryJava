package com.doza.servlet.fix;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {

    public static final String PERSON = "person";

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        var person = (PersonDto) session.getAttribute(PERSON);
//        if (person == null) {
//            person = new PersonDto(25L, "test@gmail.com");
//            session.setAttribute(PERSON, person);
//        }
//    }
}
