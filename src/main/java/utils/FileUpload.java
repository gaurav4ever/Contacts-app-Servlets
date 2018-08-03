package utils;

import model.ContactModelWrapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import static common.Constants.IMG_NAME;
import static common.Constants.IMG_PATH;

public class FileUpload {

    private List<Object> objects;

    public static HashMap<String, String> uploadImage(HttpServletRequest request, String uploadFolder) {
        DiskFileItemFactory factory = new DiskFileItemFactory();

        String filePath = "";
        ContactModelWrapper contactModelWrapper = null;
        HashMap<String, String> fields = new HashMap<>();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        fileUpload.setFileSizeMax(1024 * 1024 * 2);

        try {
            List list = fileUpload.parseRequest(request);
            for (Object aList : list) {
                FileItem fileItem = (FileItem) aList;
                /**
                 * check if item is from field or not.
                 * if not then it is some kind of file
                 */
                if (!fileItem.isFormField()) {
                    String fileName = new File(fileItem.getName()).getName();
                    filePath = uploadFolder + File.separator + fileName;
                    File uploadFile = new File(filePath);
                    // save the file
                    fileItem.write(uploadFile);
                    fields.put(IMG_NAME, fileName);
                    fields.put(IMG_PATH, filePath);
                } else {
                    fields.put(fileItem.getFieldName(), fileItem.getString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fields;
    }

    public static boolean deleteImage(String imagePath) {
        File file = new File(imagePath);
        return file.delete();
    }
}
