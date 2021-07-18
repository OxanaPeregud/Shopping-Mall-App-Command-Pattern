package com.peregud.shoppingcenter.controller;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.command.CommandProvider;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

@WebServlet("/controller")
public class FrontController extends HttpServlet {

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        execute(request, response);
    }

    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter(PARAM_COMMAND);
        Command command = CommandProvider.getCommand(name);
        command.execute(request, response);
    }
}
