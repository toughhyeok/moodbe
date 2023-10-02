package com.hotamul.music.moodbe.service.music;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.hotamul.music.moodbe.domain.music.Music;
import com.hotamul.music.moodbe.domain.music.MusicRepository;
import com.hotamul.music.moodbe.web.dto.MusicRegisterDto;
import com.hotamul.music.moodbe.web.dto.MusicResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MusicService {
    private final MusicRepository musicRepository;
    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public MusicResponseDto findLatest() {
        return new MusicResponseDto(musicRepository.findLatest());
    }

    public List<MusicResponseDto> findAll() {
        return musicRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream().map(MusicResponseDto::new).collect(Collectors.toList());
    }

    public MusicResponseDto register(MusicRegisterDto musicRegisterDto) throws IOException {
        musicRegisterDto.setImagePath(uploadFileToS3(musicRegisterDto.getFile()));
        Music music = musicRegisterDto.toEntity();
        musicRepository.save(music);
        return new MusicResponseDto(music);
    }

    private String uploadFileToS3(MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(multipartFile.getSize());
        metadata.setContentType(multipartFile.getContentType());
        amazonS3.putObject(bucket, fileName, multipartFile.getInputStream(), metadata);
        return amazonS3.getUrl(bucket, fileName).toString();
    }
}
