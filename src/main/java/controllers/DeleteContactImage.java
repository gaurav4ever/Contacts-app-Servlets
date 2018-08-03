package controllers;

import database.DBOperations;
import model.ResponseModel;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utils.FileUpload;
import utils.GsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteContactImage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("contactId"));
        boolean isFileDeleted = FileUpload.deleteImage(DBOperations.getContactImage(id));

        String res = GsonUtil.getJson(new ResponseModel(200, "Image deletion failed"));
        if (isFileDeleted) {
            DBOperations.clearContactImg(id);
            res = GsonUtil.getJson(new ResponseModel(200, "Image Deleted"));
        }

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        out.print(res);
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/deleteContact.jsp");
    }
}
