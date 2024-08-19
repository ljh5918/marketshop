package com.marketshop.marketshop.service;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

// 파일을 처리하는 클래스
@Service
@Transactional
@Log
public class FileService {

    public String uploadFile(String uploadPath, String originalFileName, byte[] fileDate) throws Exception {
        UUID uuid = UUID.randomUUID();      // UUID 는 서로 다른 개체들을 구별하기 위해 이름을 부여할 때 사용
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String savedFileName = uuid.toString() + extension;     // UUID 로 받은 값과 원래 파일의 이름의 확장자를 조합해서 저장될 파일 이름을 만듬
        String fileUploadFullUrl = uploadPath + "/" + savedFileName;
        FileOutputStream fos = new FileOutputStream(fileUploadFullUrl);     // byte 단위의 출력을 보내는 클래스
        fos.write(fileDate);
        fos.close();
        return savedFileName;
    }

    public void deleteFile(String filePath) throws Exception {
        File deleteFile = new File(filePath);

        if (deleteFile.exists()) {
            deleteFile.delete();
            log.info("파일을 삭제하였습니다.");
        } else {
            log.info("파일이 존재하지 않습니다.");
        }
    }
}
