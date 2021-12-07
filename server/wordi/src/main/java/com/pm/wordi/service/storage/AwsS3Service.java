package com.pm.wordi.service.storage;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
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

        return convertedFileName;
    }
}
