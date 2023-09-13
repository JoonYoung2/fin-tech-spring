package com.care.root.mybatis;

import java.util.List;

import com.care.root.dto.FileDTO;

public interface FileMapper {

	void saveData(FileDTO dto);

	public List<FileDTO> getData();

	int delete(String id);

	public FileDTO getOneData(String id);

	void update(FileDTO dto);

	void nameUpadate(FileDTO dto);

}
