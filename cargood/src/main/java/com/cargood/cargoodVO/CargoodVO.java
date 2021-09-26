package com.cargood.cargoodVO;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("CargoodVO")
public class CargoodVO {
	private int CARSEQ;
	private int CARCNT;
	private String NAME;
	private String ID;
	private String PW;
	private String MEMSEQ;
	private Timestamp CARDATE;
	private String CARIMG1;
	private String CARIMG2;
	private String CARIMG3;
	private String CARTITLE;
	private String CARWRITER;
	private String CARCONTENT;
	
	public int getCARSEQ() {
		return CARSEQ;
	}
	public void setCARSEQ(int cARSEQ) {
		CARSEQ = cARSEQ;
	}
	public int getCARCNT() {
		return CARCNT;
	}
	public void setCARCNT(int cARCNT) {
		CARCNT = cARCNT;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getMEMSEQ() {
		return MEMSEQ;
	}
	public void setMEMSEQ(String mEMSEQ) {
		MEMSEQ = mEMSEQ;
	}
	public Timestamp getCARDATE() {
		return CARDATE;
	}
	public void setCARDATE(Timestamp cARDATE) {
		CARDATE = cARDATE;
	}
	public String getCARIMG1() {
		return CARIMG1;
	}
	public void setCARIMG1(String cARIMG1) {
		CARIMG1 = cARIMG1;
	}
	public String getCARIMG2() {
		return CARIMG2;
	}
	public void setCARIMG2(String cARIMG2) {
		CARIMG2 = cARIMG2;
	}
	public String getCARIMG3() {
		return CARIMG3;
	}
	public void setCARIMG3(String cARIMG3) {
		CARIMG3 = cARIMG3;
	}
	public String getCARTITLE() {
		return CARTITLE;
	}
	public void setCARTITLE(String cARTITLE) {
		CARTITLE = cARTITLE;
	}
	public String getCARWRITER() {
		return CARWRITER;
	}
	public void setCARWRITER(String cARWRITER) {
		CARWRITER = cARWRITER;
	}
	public String getCARCONTENT() {
		return CARCONTENT;
	}
	public void setCARCONTENT(String cARCONTENT) {
		CARCONTENT = cARCONTENT;
	}
	
}
