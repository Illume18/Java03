package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.Mem.MemDao;
import spring.Mem.MemDto;

@Service
public class InsertService {
	
	MemDao dao;  
	
	@Autowired
	public void setDao(MemDao dao) {
		this.dao = dao;
	}


	public int insertMem(MemDto dto) {
		return dao.insert(dto);
	}
	
	
	/*
	public void insertMem(MemDto dto) {
		System.out.println("신규 회원 등록:" + dto);
		//커맨드 객체 받아와서 출력시킬것

		dao.insert(dto);*/
	}

