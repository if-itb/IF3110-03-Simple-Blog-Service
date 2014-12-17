package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
 
@ManagedBean(name = "inputBean")
@SessionScoped
public class InputBean implements Serializable {
 
	private Part part;
	private String statusMessage;
 
	public String uploadFile() throws IOException {
 
		// Extract file name from content-disposition header of file part
		String fileName = getFileName(part);
		System.out.println("***** fileName: " + fileName);
 
		String basePath = "D:" + File.separator + "temp" + File.separator;
		File outputFilePath = new File(basePath + fileName);
 
		// Copy uploaded file to destination path
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = part.getInputStream();
			outputStream = new FileOutputStream(outputFilePath);
 
			int read = 0;
			final byte[] bytes = new byte[1024];
			//Copy each byte from inputStream to outputStream
                        while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			statusMessage = "Image upload success !!";
		} catch (IOException e) {
			e.printStackTrace();
			statusMessage = "Image upload fail !!";
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return null;    // return to same page
	}
 
	public Part getPart() {
		return part;
	}
 
	public void setPart(Part part) {
		this.part = part;
	}
 
	public String getStatusMessage() {
		return statusMessage;
	}
 
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
 
	// Rename file name into post_id+format
	private String getFileName(Part part) {
		String format="";
                if("image/png".equals(part.getContentType())){
                    format=".png";
                }
                else if("image/jpg".equals(part.getContentType())){
                    format=".jpg";
                }
                else if("image/jpeg".equals(part.getContentType())){
                    format=".jpeg";
                }
                format = "test"+format;
		return format;
	}
}