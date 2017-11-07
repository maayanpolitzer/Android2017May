package server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hackeru on 11/6/2017.
 */
@WebServlet(name = "LoginServer", urlPatterns = "/login")
public class LoginServer extends HttpServlet {

    public LoginServer(){
        System.out.println("wow!!!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int add = Integer.parseInt(request.getParameter("add"));
        int firstNumber = Integer.parseInt(request.getParameter("first"));
        int secondNumber = Integer.parseInt(request.getParameter("second"));
        int result = 0;
        switch (add){
            case 0:
                result = firstNumber + secondNumber;
                break;
            case 1:
                result = firstNumber - secondNumber;
                break;
        }
        response.getWriter().write(String.valueOf(result));
    }
}
