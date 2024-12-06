package com.doza.servlet;

import com.doza.dto.CreatePersonDto;
import com.doza.exeption.ValidationException;
import com.doza.service.PersonService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final PersonService personService = PersonService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreatePersonDto personDto = new CreatePersonDto(
                req.getParameter("email"),
                req.getParameter("password"),
                req.getParameter("firstName"),
                req.getParameter("lastName"),
                LocalDate.parse(req.getParameter("dateOfBirth"), DateTimeFormatter.ofPattern("yyyy-MMM-dd"))
        );

        try {
            personService.createPerson(personDto);
            resp.sendRedirect("/login");
        } catch (ValidationException exception) {
            req.setAttribute("error", exception.getErrorList());
            doGet(req, resp);
        }
    }
}
