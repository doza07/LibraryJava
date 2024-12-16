package com.doza.servlet;

import com.doza.dto.PersonDto;
import com.doza.exeption.ValidationException;
import com.doza.service.PersonService;
import com.doza.util.JspHelper;
import com.doza.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(UrlPath.LOGIN_PAGE)
public class LoginServlet extends HttpServlet {

    private final PersonService personService = PersonService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("login")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        personService.login(req.getParameter("email"), req.getParameter("password"))
                .ifPresentOrElse(
                        person -> onLoginSuccess(person, req, resp),
                        () -> onLoginFail(req, resp)
                );
    }


    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.sendRedirect(UrlPath.LOGIN_PAGE + "?error&email=" + req.getParameter("email"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void onLoginSuccess(PersonDto person, HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute("person", person);
        try {
            resp.sendRedirect(UrlPath.HOME_PAGE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
