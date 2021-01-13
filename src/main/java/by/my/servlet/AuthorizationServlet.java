package by.my.servlet;

import by.my.model.User;
import by.my.storage.InMemoryStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/authorization")
public class AuthorizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InMemoryStorage inMemoryStorage = new InMemoryStorage();
        User user = (User)req.getSession().getAttribute("user");
        if(user == null){
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            user = inMemoryStorage.getUserByLogin(login);
            if(user != null && user.getPassword().equals(password)){
                req.getSession().setAttribute("user",user);
                resp.sendRedirect("/");
            }else{
                req.setAttribute("wrongResult", "Incorrect login or password!");
                req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req,resp);
            }
        }else{
            req.setAttribute("alreadyLogIn",user.getName()+" you are already logged in!");
            req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req,resp);
        }
    }
}
