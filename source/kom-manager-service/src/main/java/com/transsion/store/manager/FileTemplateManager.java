package com.transsion.store.manager;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.FileTemplate;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.FileTemplateDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.service.FileTemplateService;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.support.FastdfsClientSingleton;
import com.transsion.store.utils.CacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuzh on 17-2-16.
 */

@Service("fileTemplateManager")
public class FileTemplateManager {

    private Logger logger = LoggerFactory.getLogger(FileTemplateManager.class);

    @Autowired
    private FileTemplateService fileTemplateService;

    @Autowired
    private SystemDateService systemDateService;

    public void save(String token, FileTemplate fileTemplate) throws ServiceException {
        if(UtilHelper.isEmpty(token)){
            throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
        }

        UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);

        if(UtilHelper.isEmpty(userContext)){
            throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
        }
        if(UtilHelper.isEmpty(fileTemplate.getTemplateName())) {
            fileTemplate.setTemplateName(FileTemplate.BizType.valueOf(fileTemplate.getBizType()).getValue());
        }
        FileTemplate tmp = new FileTemplate();

        tmp.setBizType(fileTemplate.getBizType());

        List<FileTemplate> list = fileTemplateService.listByProperty(tmp);

        if(!UtilHelper.isEmpty(list)) {
            tmp = list.get(0);

            tmp.setUpdatedBy(userContext.getUserCode());
            tmp.setUpdatedTime(systemDateService.getCurrentDate());
            tmp.setFileId(fileTemplate.getFileId());
            tmp.setFileSuffix(fileTemplate.getFileSuffix());
            tmp.setTemplateName(fileTemplate.getTemplateName());
            tmp.setRemark(fileTemplate.getRemark());
            fileTemplateService.update(tmp);
        }else {
            fileTemplate.setCreateBy(userContext.getUserCode());
            fileTemplate.setUpdatedBy(userContext.getUserCode());
            fileTemplate.setCreateTime(systemDateService.getCurrentDate());
            fileTemplate.setUpdatedTime(systemDateService.getCurrentDate());

            fileTemplateService.save(fileTemplate);
        }

    }

    /**
     * 根据业务类型取得文件模板内容
     * @param bizType
     * @return
     * @throws ServiceException
     */
    public FileTemplateDto getFileTemplateDto(String bizType) throws ServiceException {
        FileTemplate fileTemplate = new FileTemplate();

        if(UtilHelper.isEmpty(bizType)) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
        }

        fileTemplate.setBizType(bizType.toUpperCase());

        List<FileTemplate> list = fileTemplateService.listByProperty(fileTemplate);

        if(!UtilHelper.isEmpty(list)) {
            fileTemplate = list.get(0);

            FileTemplateDto fileTemplateDto = new FileTemplateDto();

            fileTemplateDto.setTemplateName(fileTemplate.getTemplateName());
            fileTemplateDto.setFileId(fileTemplate.getFileId());
            fileTemplateDto.setFileSuffix(fileTemplate.getFileSuffix());

            try {
                logger.debug("FileId = [{}]", fileTemplate.getFileId());
                fileTemplateDto.setInputStream(FastdfsClientSingleton.getSingleton().getFastdfsClient().download(fileTemplate.getFileId()));
            } catch (Exception e) {
                throw new ServiceException(e.getMessage(), e);
            }

            return fileTemplateDto;
        }

        throw new ServiceException(ExceptionDef.ERROR_TASK_TEMPLATE_EXIST.getName());

    }
}
