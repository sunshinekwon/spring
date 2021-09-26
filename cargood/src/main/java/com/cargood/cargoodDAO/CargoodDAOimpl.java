package com.cargood.cargoodDAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cargood.cargoodVO.CargoodVO;

@Repository
public class CargoodDAOimpl implements CargoodDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<CargoodVO> mainNewcarList() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("mainNewcarList");
	}


	@Override
	public List<CargoodVO> selAllNewCarList() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("selAllNewCarList");
	}

	@Override
	public CargoodVO selOneCarList(String title) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("selOneCarList",title);
	}

	@Override
	public void addCnt(String title) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("addCnt",title);
	}

	@Override
	public void putCarContent(CargoodVO vo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("putCarContent",vo);//putTitle , putContent
	}

	@Override
	public int checkId(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("checkId");
	}

	@Override
	public void putMember(CargoodVO vo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("putMember",vo);//putId,putPw,putName
	}

	@Override
	public int checkIdPw(CargoodVO vo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("checkIdPw",vo);//checkId, checkPw
	}

	@Override
	public String loginSucGetName(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("loginSucGetName",id);
	}

	@Override
	public void delCarContent(int seq) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("delCarContent",seq);
	}


	@Override
	public List<CargoodVO> pagingCarList(String pageNum) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("pagingGetCarList",pageNum);
	}


	@Override
	public int pagingGetNum() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("pagingGetNum");
	}



}
