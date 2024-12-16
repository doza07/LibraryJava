package com.doza.servlet.fix;

import com.doza.service.BookService;
import com.doza.util.JspHelper;
import com.doza.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/l")
public class LibraryServlet extends HttpServlet {

    private final BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bookList", bookService.findAllBooks());

        req.getRequestDispatcher(JspHelper.getPath("library"))
                .forward(req, resp);
    }
}