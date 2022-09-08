package com.info.service;

import java.util.List;
import java.util.Optional;

import com.info.model.Cmd;

public interface CmdService {

	public void addCmd(Cmd cmd);
	
	public void delCmd(Cmd cmd);

	public List<Cmd> listCmd();
	
	public Optional<Cmd> getCmdById(long cmdId);
	
	public List<Cmd> findByUser(long userId);
	
	public void updateCmd(Cmd cmd);
	
	public void deleteCmd(long cmdId);

}