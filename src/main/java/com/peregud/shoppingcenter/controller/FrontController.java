package com.peregud.shoppingcenter.controller;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.command.impl.CommandImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

@WebServlet("/controller")
public class FrontController extends HttpServlet {

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServletContext context = getServletContext();
        context.getAttribute(PARAM_CONTENT);
        String name = request.getParameter(PARAM_COMMAND);
        Command command = CommandImpl.getCommand(name);
        command.execute(request, response);
    }
}
