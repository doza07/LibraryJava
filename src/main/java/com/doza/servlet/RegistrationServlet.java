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

@WebServlet(UrlPath.REGISTRATION_PAGE)
public class RegistrationServlet extends HttpServlet {

    private final PersonService personService = PersonService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("registration")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonDto personDto = new PersonDto(
                req.getParameter("email"),
                req.getParameter("password")
        );

        try {
            personService.createPerson(personDto);
            resp.sendRedirect(UrlPath.LOGIN_PAGE);
        } catch (ValidationException exception) {
            req.setAttribute("error", exception.getErrorList());
            doGet(req, resp);
        }
    }
}
