package com.care.root.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.care.root.dto.FileDTO;
import com.care.root.dto.getParamDTO;

public interface FileService {
	
	public String IMAGE_REPO = "D:\\fin_tech_spring\\spring_file_upload\\image_repo";
	public void fileProcess(String id, String name, MultipartFile file);
	public List<FileDTO> getData();
	public void delete(String file, String id);
	public FileDTO getOneData(String id);
	public void updateFile(getParamDTO dto);

}
