package by.my.servlet;

import by.my.model.User;
import by.my.storage.InMemoryStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    private InMemoryStorage inMemoryStorage = new InMemoryStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.\\S+$)(.{3,})$");
        Matcher matcher = pattern.matcher(name);
        if(matcher.matches()){
            if(login.matches("\\w{4,}")){
                if(password.matches("\\S{4,}")){
                    User user = new User(name,login,password);
                    boolean save = inMemoryStorage.saveUser(user);
                    if(save){
                        resp.sendRedirect("/");
                    }else{
                        req.setAttribute("wrongRes", "This user already exists!");
                        req.getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req,resp);
                    }
                }else {
                    req.setAttribute("wrongPassword", "Incorrect password!");
                    req.getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req,resp);
                }
            }else {
                req.setAttribute("wrongLogin", "Incorrect login!");
                req.getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req,resp);
            }
        }else {
            req.setAttribute("wrongName", "Incorrect name!");
            req.getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req,resp);
        }

    }
}
