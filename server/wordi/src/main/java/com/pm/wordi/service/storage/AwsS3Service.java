package com.pm.wordi.service.storage;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.pm.wordi.commons.properties.AwsProperties;
import com.pm.wordi.commons.utils.file.FileNameUtils;
import com.pm.wordi.exception.file.FileRoadFailedException;
import lombok.RequiredArgsConstructor;
import org.apache.tika.Tika;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class AwsS3Service implements StorageService{

    private final AwsProperties awsProperties;

    private AmazonS3 s3Client;

    /**
     * bean이 초기화 될 때 한 번 AmazonS3Client 객체를 빌드한다.
     * getInputStream() 메서드는 BLOB 객체를 리턴하며 파일에 대한 정보(파일명/수정일/크기/타입 등등)가 저장되어 있다.
     * Tika 객체를 생성하여서 detect 메소드를 활용하면 File의 MIME Type을 String 문자열로 리턴 받을 수 있다.
     */

    @PostConstruct
    private void setS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(awsProperties.getAccessKey(),
                awsProperties.getSecretKey());

        s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(awsProperties.getRegionStatic())
                .build();
    }


    public String uploadBucket(MultipartFile file) {
        return upload(file, awsProperties.getBucket());
    }

    public String upload(MultipartFile file, String bucket) {
        String fileName = file.getOriginalFilename();
        String convertedFileName = FileNameUtils.fileNameConvert(fileName);

        try {
            String mimeType = new Tika().detect(file.getInputStream());
            ObjectMetadata metadata = new ObjectMetadata();

            FileNameUtils.checkMimeType(mimeType);
            metadata.setContentType(mimeType);
            s3Client.putObject(
                    new PutObjectRequest(bucket, convertedFileName, file.getInputStream(), metadata)
                            .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException exception) {
            throw new FileRoadFailedException("파일 저장에 실패하였습니다.");
        }

        return s3Client.getUrl(bucket, convertedFileName).toString();
    }
}
