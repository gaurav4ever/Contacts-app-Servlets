package controllers;

import common.Constants;
import database.DBOperations;
import model.ContactModel;
import model.ContactModelWrapper;
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
import java.util.HashMap;

import static common.Constants.IMG_SERVER_DIRECTORY;

public class AddContact extends HttpServlet {

    private ContactModel contactModel;
    private HashMap<String, String> contactHashMap;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean isUploadRequest = ServletFileUpload.isMultipartContent(request);

        if (isUploadRequest) {
            contactHashMap = FileUpload.uploadImage(request, Constants.FILE_PATH);
        }
        contactModel = createContactModel(contactHashMap);
        DBOperations.addContact(contactModel);

        String res = GsonUtil.getJson(new ResponseModel(200, "Contact Uploaded"));
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        out.print(res);
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private ContactModel createContactModel(HashMap<String, String> contactHashMap) {
        ContactModel contactModel = new ContactModel();
        contactModel.imgName = contactHashMap.get(Constants.IMG_NAME);
        contactModel.imgPath = contactHashMap.get(Constants.IMG_PATH);
        contactModel.serverImageUrl = IMG_SERVER_DIRECTORY + contactHashMap.get(Constants.IMG_NAME);
        contactModel.name = contactHashMap.get("username");
        contactModel.number = contactHashMap.get("number");
        contactModel.address = contactHashMap.get("address");
        return contactModel;
    }
}
