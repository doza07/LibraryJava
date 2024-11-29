package com.doza.servlet;

import com.doza.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/library")
public class LibraryServlet extends HttpServlet {

    private final BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");


        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Library</h1>");
            writer.write("<ul>");
            bookService.findAllBooks().forEach(bookDto -> {
                    writer.write("""
                            <li>
                            <a href="/book?bookId=%d">%s</a>
                            </li>
                            """.formatted(bookDto.getId(), bookDto.getDescription()));
            });
            writer.write("</ul>");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
