package com.springcool.file.api.feign;

import com.springcool.file.api.feign.factory.RemoteFileFallbackFactory;
import com.springcool.common.core.constant.basic.ServiceConstants;
import com.springcool.common.core.domain.R;
import com.springcool.file.api.domain.SysFile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务
 *
 * @author xueyi
 */
@FeignClient(contextId = "remoteFileService", value = ServiceConstants.FILE_SERVICE, fallbackFactory = RemoteFileFallbackFactory.class)
public interface RemoteFileService {

    /**
     * 上传文件
     *
     * @param file 文件信息
     * @return 结果
     */
    @PostMapping(value = "/inner/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    R<SysFile> upload(@RequestPart(value = "file") MultipartFile file);

    /**
     * 删除文件
     *
     * @param url 文件地址
     * @return 结果
     */
    @DeleteMapping(value = "/inner/delete/{url}")
    R<Boolean> delete(@PathVariable("url") String url);
}
