package com.care.root.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.dto.FileDTO;
import com.care.root.dto.getParamDTO;
import com.care.root.mybatis.FileMapper;
@Service
public class FileServiceImpl implements FileService {
	@Autowired FileMapper mapper;
	
	public void fileProcess(String id, String name, MultipartFile file) {
		FileDTO dto = new FileDTO();
		dto.setId(id);
		dto.setName(name);
		
		if(file.getSize()!=0) {// !file.isEmpty라고 해도 된다.  //파일이있다면
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			String sysFileName=fo.format(new Date());
			sysFileName += file.getOriginalFilename();
			System.out.println("sysFileNmae : "+sysFileName);  //20230913103116-attendBoard05.png
			File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
			try {
				file.transferTo(saveFile);
				dto.setImgName(sysFileName);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {//파일이 존재하지 않는다면
			dto.setImgName("nan");
		}
		try {
			mapper.saveData(dto);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<FileDTO> getData(){
		List<FileDTO> list = null;
		try {
			list = mapper.getData();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void delete(String file, String id) {
		try {
			int result = mapper.delete(id);	
			if((result == 1)) {
				File d = new File(IMAGE_REPO+"/"+file);
				if(d.exists()) {
					d.delete();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public FileDTO getOneData(String id) {		
		return mapper.getOneData(id);
	}

	public void updateFile(getParamDTO param) {		
		FileDTO dto = mapper.getOneData(param.getId());
		if(param.getFile().getSize() != 0) {
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			String sysFileName=fo.format(new Date());
			sysFileName += param.getFile().getOriginalFilename();
			System.out.println("sysFileNmae : "+sysFileName);  //20230913103116-attendBoard05.png
			File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
			try {
				File d = new File(IMAGE_REPO+"/"+dto.getImgName());
				d.delete();
				param.getFile().transferTo(saveFile);
				dto.setImgName(sysFileName);
				dto.setName(param.getName());
			}catch(Exception e) {
				e.printStackTrace();
			}
			mapper.update(dto);
		}else {
			dto.setName(param.getName());
			mapper.nameUpadate(dto);
		}
	}
}
