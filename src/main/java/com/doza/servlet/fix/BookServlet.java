package com.doza.servlet.fix;

import com.doza.dto.BookDto;
import com.doza.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/book")
public class BookServlet extends HttpServlet {

    private final BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long bookId = Long.valueOf(req.getParameter("bookId"));

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");


        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Book</h1>");
            writer.write("<ul>");
            Optional<BookDto> bookDto = bookService.findBookById(bookId);
            writer.write("""
                    <div>
                    <h2>Book info:</h2>
                    <p>Id: %d</p>
                    <p>Description: %s</p>
                    </div>
                    """.formatted(bookDto.get().getId(), bookDto.get().getDescription()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
