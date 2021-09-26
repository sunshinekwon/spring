package com.cargood.cargoodService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cargood.cargoodDAO.CargoodDAO;
import com.cargood.cargoodVO.CargoodVO;

@Service
public class CargoodServiceImpl implements CargoodService {
	
	@Autowired
	private CargoodDAO cargoodDao;

	@Override
	public List<CargoodVO> mainNewcarListService() {
		// TODO Auto-generated method stub
		return cargoodDao.mainNewcarList();
	}

	@Override
	public List<CargoodVO> selAllNewCarListService() {
		// TODO Auto-generated method stub
		return cargoodDao.selAllNewCarList();
	}

	@Override
	public CargoodVO selOneCarList(String title) {
		// TODO Auto-generated method stub
		cargoodDao.addCnt(title);
		return cargoodDao.selOneCarList(title);
	}

	@Override
	public void putCarContentService(CargoodVO vo) {
		// TODO Auto-generated method stub
		cargoodDao.putCarContent(vo);
	}

	@Override
	public void delCarContentService(int seq) {
		// TODO Auto-generated method stub
		cargoodDao.delCarContent(seq);
	}

	@Override
	public int checkIdService(String id) {
		// TODO Auto-generated method stub
		return cargoodDao.checkId(id);
	}

	@Override
	public int checkIdPwService(CargoodVO vo) {
		// TODO Auto-generated method stub
		return cargoodDao.checkIdPw(vo);
	}

	@Override
	public void putMemberService(CargoodVO vo) {
		// TODO Auto-generated method stub
		cargoodDao.putMember(vo);
	}

	@Override
	public CargoodVO loginSucGetNameService(String id) {
		// TODO Auto-generated method stub
		cargoodDao.loginSucGetName(id);
		return null;
	}

	@Override
	public List<CargoodVO> pagingGetCarList(String pageNum) {
		// TODO Auto-generated method stub
		return cargoodDao.pagingCarList(pageNum);
	}

	@Override
	public int pagingGetNum() {
		// TODO Auto-generated method stub
		return cargoodDao.pagingGetNum();
	}

}
