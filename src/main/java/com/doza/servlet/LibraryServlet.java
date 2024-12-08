package com.doza.servlet;

import com.doza.dto.BookDto;
import com.doza.service.BookService;
import com.doza.util.JspHelper;
import com.doza.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(UrlPath.LIBRARY)
public class LibraryServlet extends HttpServlet {

    private final BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookDto> allBooks = bookService.findAllBooks();
        req.setAttribute("bookList", allBooks);
        req.getRequestDispatcher(JspHelper.getPath("library")).forward(req, resp);
    }
}