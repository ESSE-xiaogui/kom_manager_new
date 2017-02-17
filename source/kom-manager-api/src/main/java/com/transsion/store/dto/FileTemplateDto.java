package com.transsion.store.dto;

import java.io.InputStream;

/**
 * Created by liuzh on 17-2-16.
 */
public class FileTemplateDto {

    private static final long serialVersionUID = 1L;

    /**
     *	模板名称
     */
    private String templateName;

    /**
     *	文件名称（ID)
     */
    private String fileId;

    /**
     *	文件后缀
     */
    private String fileSuffix;

    private InputStream inputStream;

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
