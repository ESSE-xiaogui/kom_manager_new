package com.transsion.store.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.stereotype.Controller;

import com.rest.service.codec.response.StandardResult;

import net.mikesu.fastdfs.FastdfsClient;
import net.mikesu.fastdfs.FastdfsClientFactory;
import sun.misc.BASE64Encoder;

@Controller
@Path("/fastdfs")
public class UploadController {
	private static FastdfsClient fastdfsClient = FastdfsClientFactory.getFastdfsClient();
	private static final String SERVER_UPLOAD_LOCATION_FOLDER = "";
    @POST
    @Path("/upload")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.APPLICATION_JSON})
    public StandardResult uploadFile(MultipartFormDataInput input) {
        String fileName = "";
        Map<String, List<InputPart>> formParts = input.getFormDataMap();
        List<InputPart> inPart = formParts.get("file");
        for (InputPart inputPart : inPart) {

            try {
                // Retrieve headers, read the Content-Disposition header to obtain the original name of the file
                MultivaluedMap<String, String> headers = inputPart.getHeaders();
                fileName = parseFileName(headers);

                // Handle the body of that part with an InputStream
                InputStream istream = inputPart.getBody(InputStream.class,null);

                fileName = SERVER_UPLOAD_LOCATION_FOLDER + fileName;
                BASE64Encoder encode = new BASE64Encoder();
                String fileId = uploadFile(istream,fileName);
                return new StandardResult(new String[]{fileId,fileName,encode.encode(fileId.getBytes())});
            }catch (IOException e) {
                e.printStackTrace();
                return new StandardResult(500,e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                return new StandardResult(500,e.getMessage());
            }

        }
        return null;
    }
    private String parseFileName(MultivaluedMap<String, String> headers) {

        String[] contentDispositionHeader = headers.getFirst("Content-Disposition").split(";");

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

	private static String uploadFile(InputStream uploadedInputStream, String serverLocation) throws Exception {
		File uploadFile = new File(serverLocation);
		saveFile(uploadedInputStream, uploadFile);
		String fileId = fastdfsClient.upload(uploadFile);
		uploadFile.delete();
		return fileId;
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
