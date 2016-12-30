package com.transsion.store.controller;

import com.rest.service.codec.response.StandardResult;
import net.mikesu.fastdfs.FastdfsClient;
import net.mikesu.fastdfs.FastdfsClientFactory;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.stereotype.Controller;
import sun.misc.BASE64Encoder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.*;
import java.util.List;
import java.util.Map;

@Controller
@Path("/fastdfs")
public class UploadController {
	private static FastdfsClient fastdfsClient = FastdfsClientFactory.getFastdfsClient();
    private static final String configFile = "FastdfsClient.properties";
	private static final String SERVER_UPLOAD_LOCATION_FOLDER = "";

    @POST
    @Path("/upload")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.APPLICATION_JSON})
    public Object uploadFile(MultipartFormDataInput input) {
        String fileName = "";
        Map<String, List<InputPart>> formParts = input.getFormDataMap();
        List<InputPart> inPart = formParts.get("files");
        for (InputPart inputPart : inPart) {

            try {
                // Retrieve headers, read the Content-Disposition header to obtain the original name of the file
                MultivaluedMap<String, String> headers = inputPart.getHeaders();
                fileName = parseFileName(headers);

                // Handle the body of that part with an InputStream
                InputStream istream = inputPart.getBody(InputStream.class,null);

                fileName = SERVER_UPLOAD_LOCATION_FOLDER + fileName;
                BASE64Encoder encode = new BASE64Encoder();
                Files files = new Files();

                String fileId = uploadFile(istream,fileName, files);

                files.setFileId(fileId);
                files.setName(fileId);
                files.setUrl(PropertiesConfigurationHelper.getInstance().getDownloadServer() + fileId);
                files.setThumbnailUrl(files.getUrl());
                files.setFileIdEncode(encode.encode(fileId.getBytes()));

                return new FileResult(files);
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
	private static void saveFile(InputStream uploadedInputStream, File serverLocation, Files files) {

		try {
			OutputStream outpuStream = null;
			int read = 0;
			byte[] bytes = new byte[8 * 1024];

			outpuStream = new FileOutputStream(serverLocation);
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				outpuStream.write(bytes, 0, read);
			}
			files.setSize(serverLocation.length());
			outpuStream.flush();
			outpuStream.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private static String uploadFile(InputStream uploadedInputStream, String serverLocation, Files files) throws Exception {
		File uploadFile = new File(serverLocation);
		saveFile(uploadedInputStream, uploadFile, files);
		String fileId = fastdfsClient.upload(uploadFile);
		uploadFile.delete();
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
	
    private final static class PropertiesConfigurationHelper {
        private String downloadServer;

        private static PropertiesConfigurationHelper getInstance(){
            return new PropertiesConfigurationHelper();
        }
        private PropertiesConfigurationHelper(){
            try {
                PropertiesConfiguration config = new PropertiesConfiguration(configFile);

                this.downloadServer = config.getString("download_server");
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        }

        public String getDownloadServer() {
            return downloadServer;
        }

        public void setDownloadServer(String downloadServer) {
            this.downloadServer = downloadServer;
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

