package by.my.servlet;

import by.my.model.User;
import by.my.storage.InMemoryStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/info")
public class InfoAboutUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InMemoryStorage inMemoryStorage = new InMemoryStorage();
        String str = "";
        for (User user : inMemoryStorage.getUserList()) {
            str+=user.toString()+"<br>";
        }
        req.setAttribute("list",str);
        req.getServletContext().getRequestDispatcher("/pages/info.jsp").forward(req,resp);
    }
}
