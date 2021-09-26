package com.cargood.cargoodService;

import java.util.List;

import com.cargood.cargoodVO.CargoodVO;

public interface CargoodService {
	public abstract List<CargoodVO> mainNewcarListService();
	public abstract List<CargoodVO> selAllNewCarListService();
	public abstract CargoodVO selOneCarList(String title);//+addCnt
	public abstract void putCarContentService(CargoodVO vo);
	public abstract void delCarContentService(int seq);
	public abstract int checkIdService(String id);
	public abstract int checkIdPwService(CargoodVO vo);
	public abstract void putMemberService(CargoodVO vo);
	public abstract CargoodVO loginSucGetNameService(String id);
	public abstract List<CargoodVO> pagingGetCarList(String pageNum);
	public abstract int pagingGetNum();
}
