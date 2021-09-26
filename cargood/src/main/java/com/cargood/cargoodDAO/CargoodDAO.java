package com.cargood.cargoodDAO;

import java.util.List;

import com.cargood.cargoodVO.CargoodVO;

public interface CargoodDAO {
	public abstract List<CargoodVO> mainNewcarList();
	public abstract List<CargoodVO> selAllNewCarList();
	public abstract CargoodVO selOneCarList(String title);
	public abstract void addCnt(String title);
	public abstract void putCarContent(CargoodVO vo);
	public abstract void delCarContent(int seq);
	public abstract List<CargoodVO> pagingCarList(String pageNum);
	public abstract int pagingGetNum();
	
	//회원가입관련
	public abstract int checkId(String id);
	public abstract void putMember(CargoodVO vo);
	
	//로그인관련
	public abstract int checkIdPw(CargoodVO vo);
	public abstract String loginSucGetName(String id);
}
