package controllers;

import database.DBOperations;
import model.ContactModel;
import utils.GsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AllContacts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ContactModel> contactModels = DBOperations.getAllContact();
        String res = GsonUtil.getJson(contactModels);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        out.print(res);
        out.flush();
    }
}
