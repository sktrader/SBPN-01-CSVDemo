package com.example.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.File;
import com.example.repository.FileRepository;
import com.example.service.FileService;

@Service
public class FileServiceImpl implements FileService{
	@Autowired
	private FileRepository fileRepository;

	@Override
	public boolean hasCsvFormat(MultipartFile file) {
		
		String type="text/csv";
		if(!type.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	@Override
	public void processAndSaveData(MultipartFile file) {
		try {
			List<File> files=csvToFiles(file.getInputStream());
			fileRepository.saveAll(files);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private List<File> csvToFiles(InputStream inputStream) {
		try(BufferedReader fileReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
				CSVParser csvParser=new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){
			List<CSVRecord> records = csvParser.getRecords();
			List<File> files=new ArrayList<>();
			for(CSVRecord csvRecord :records) {
				File file=new File(csvRecord.get("instrument"),csvRecord.get("exchange"),csvRecord.get("type"),csvRecord.get("product"),csvRecord.get("time"),Integer.parseInt(csvRecord.get("qty")),Double.parseDouble(csvRecord.get("price")),Double.parseDouble(csvRecord.get("trade Value")),csvRecord.get("order Number"));
				files.add(file);
			}
			return files;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
