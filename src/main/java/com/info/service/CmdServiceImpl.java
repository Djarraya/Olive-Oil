package com.info.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.dao.CmdRepository;
import com.info.model.Cmd;
import com.info.model.Product;

@Service
@Transactional
public class CmdServiceImpl implements CmdService{
	
	@Autowired
	private CmdRepository cmdRepository;

	@Override
	public void addCmd(Cmd cmd) {
		cmdRepository.save(cmd);
	}
	
	@Override
	public void delCmd(Cmd cmd) {
		cmdRepository.delete(cmd);
	}

	@Override
	public List<Cmd> listCmd() {
		return cmdRepository.findAll();
	}

	@Override
	public Optional<Cmd> getCmdById(long cmdId) {
		return cmdRepository.findById(cmdId);
	}

	
	
	@Override
	public List<Cmd> findByUser(long userId) {
		return cmdRepository.findByUser_UserId(userId);
	}
	
	@Override
	public void deleteCmd(long cmdId) {
		cmdRepository.deleteById(cmdId);
	}
	
	@Override
	public void updateCmd(Cmd cmd) {
		List<Product> productlist = cmd.getProductList();
		cmd.setProductList(productlist);
		cmdRepository.save(cmd);
	}

}