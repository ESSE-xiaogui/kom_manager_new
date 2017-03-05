package com.transsion.store.controller;

import com.rest.service.codec.response.StandardResult;
import com.rest.service.controller.AbstractController;
import com.transsion.store.support.FastdfsClientSingleton;
import org.apache.commons.io.IOUtils;
import org.apache.james.mime4j.field.FieldName;
import org.apache.james.mime4j.message.BodyPart;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.stereotype.Controller;
import sun.misc.BASE64Encoder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@Path("/fastdfs")
public class UploadController extends AbstractController{
	private static final String SERVER_UPLOAD_LOCATION_FOLDER = "tmp";

    @POST
    @Path("/upload")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.APPLICATION_JSON})
    public Object uploadFile(MultipartFormDataInput input) {
        List<Files> filesList = new ArrayList<Files>();
        try {

            String fileName;
            Map<String, List<InputPart>> formParts = input.getFormDataMap();
            List<InputPart> inPart = formParts.get("file");

            for (InputPart inputPart : inPart) {

                fileName = "";
                Field bodyPartField = inputPart.getClass().getDeclaredField("bodyPart");
                bodyPartField.setAccessible(true);
                BodyPart bodyPart = (BodyPart) bodyPartField.get(inputPart);

                // Retrieve headers, read the Content-Disposition header to obtain the original name of the file
                for (org.apache.james.mime4j.parser.Field field : bodyPart.getHeader()) {
                    if(!FieldName.CONTENT_DISPOSITION.equals(field.getName()))
                        continue;

                    fileName = parseFileName(field.getRaw().toString());
                    logger.debug("The Content-Disposition:[{}], filename:[{}]", field.getRaw(), fileName);

                    break;
                }

                File tmp = new File(SERVER_UPLOAD_LOCATION_FOLDER);

                if(!tmp.exists()){
                    tmp.mkdirs();
                }

                tmp = new File(SERVER_UPLOAD_LOCATION_FOLDER, fileName);

                // Handle the body of that part with an InputStream
                InputStream istream = inputPart.getBody(InputStream.class,null);

                BASE64Encoder encode = new BASE64Encoder();
                Files files = new Files();
                String fileId = uploadFile(istream, tmp);

                files.setFileId(fileId);
                files.setName(fileName);
                files.setFileSuffix(fileName.substring(fileName.lastIndexOf(".")));
                files.setSize(tmp.length());
                files.setUrl(FastdfsClientSingleton.getSingleton().getDownloadServer() + fileId);
                files.setThumbnailUrl(files.getUrl());
                files.setFileIdEncode(encode.encode(fileId.getBytes()));

                tmp.delete();
                filesList.add(files);
            }
        }catch (IOException e) {
            e.printStackTrace();
            return new StandardResult(500,e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new StandardResult(500,e.getMessage());
        }
        return new FileResult(filesList.toArray(new Files[filesList.size()]));
    }
    private String parseFileName(String headers) {

        String[] contentDispositionHeader = headers.split(";");

        for (String name : contentDispositionHeader) {

            if ((name.trim().startsWith("filename"))) {

                String[] tmp = name.split("=");

                String fileName = tmp[1].trim().replaceAll("\"","");

                return fileName;
            }
        }
        return "randomName";
    }
	private static void saveFile(InputStream uploadedInputStream, File serverLocation) {

		try {
			OutputStream outpuStream = null;
			int read = 0;
			byte[] bytes = new byte[8 * 1024];

			outpuStream = new FileOutputStream(serverLocation);
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				outpuStream.write(bytes, 0, read);
			}
			outpuStream.flush();
			outpuStream.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private static String uploadFile(InputStream uploadedInputStream, File uploadFile) throws Exception {
		saveFile(uploadedInputStream, uploadFile);
		String fileId = FastdfsClientSingleton.getSingleton().getFastdfsClient().upload(uploadFile);
		return fileId;
	}

	private final class FileResult {
        private Files[] files;

        public FileResult(Files... files) {
            this.files = files;
        }

        public Files[] getFiles() {
            return files;
        }

        public void setFiles(Files... files) {
            this.files = files;
        }
    }
	private final class Files {
        private String fileId;
        private String url;
        private String name;
        private String fileSuffix;
        private String thumbnailUrl;
        private long size;
        private String fileIdEncode;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFileSuffix() {
            return fileSuffix;
        }

        public void setFileSuffix(String fileSuffix) {
            this.fileSuffix = fileSuffix;
        }

        public String getThumbnailUrl() {
            return thumbnailUrl;
        }

        public void setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
        }

        public String getFileIdEncode() {
            return fileIdEncode;
        }

        public void setFileIdEncode(String fileIdEncode) {
            this.fileIdEncode = fileIdEncode;
        }
    }
	
    class BigFileOutputStream implements javax.ws.rs.core.StreamingOutput {
        private InputStream inputStream;
        public BigFileOutputStream(){}
        public BigFileOutputStream(InputStream inputStream)
        {
            this.inputStream = inputStream;
        }

        @Override
        public void write(OutputStream output) throws IOException,
                WebApplicationException {
            // TODO Auto-generated method stub
            IOUtils.copy(inputStream, output);
        }

        public InputStream getInputStream() {
            return inputStream;
        }
        public void setInputStream(InputStream inputStream) {
            this.inputStream = inputStream;
        }
    }
}

