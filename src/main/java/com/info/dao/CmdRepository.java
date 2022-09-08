package com.info.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.model.Cmd;

@Repository
public interface CmdRepository extends JpaRepository<Cmd, Long>{
	
	
	public List<Cmd> findByUser_UserId(long UserId);
	
	
}