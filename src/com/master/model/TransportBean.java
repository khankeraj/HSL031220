package com.master.model;

import java.util.ArrayList;
import java.util.List;

public class TransportBean {
	
	
	private String id;
	private String close_id;
	
	private String level_id;
	
	private String datetime;
	
	private String name;
	private String model;
	private String size;
	private String no_of_bag;
	private String no_of_box;
	private String reg_no;
	private String rc;
	private String point;
	private String invoiceno;
	private String pending_days;
	
	private String order11;
	
	private String path3;
	
	private String halt_charge;
	
	private String p3;
	
	private String scheme_name;
	private String scheme_qty;
	
	private String total_qty;
	
	private String p2;
	
	private String batch2;
	
	private String path1;
	
	private String mr_id;
	
	private String materialfrom;
	private String materialto;
	private String batch1;
	private String quantity;
	
	private String invcheck[];
	
	private String remain_qty[];
	private String bag_name1[];
	private String bag_qty[];
	
	private String qty1tt[];
		
	private String branch;
	private String amount;
	private String ifsc;
	private String lr;
	
	private String receive11;
	
	private String loader_name;
	private String stk_id;
	private String despatch_id;
	private String vs_id;
	private String dest_id;
	
	private String order_id;
	private String driver_name;
	
	private String os;
	private String total;
	
	private String times;
	
	private String tps;
	
	private String scrap_id;
	
	private String dl;
	private String stock_qty;
	private String p1;
	
	private String req_id;
	
	private String path;
	
	private String dcno[];
	private String vsno[];
	
	private String ee[];
	private String ff[];
	
	private String dpno[];
	
	private String driver_code;
	
	private String vehicle_id;
	
	private String route;
	
	private String city;
	
	private String state;
	private String mobile_no;
	
	private String address;
	
	private String company_name;
	private String bank_name;
	
	private String ifsc_code;
	private String account_no;
	
	private String gstn;
	private String uin;
	private String pan;
	private String email;
	
	
	private String bag_name;
	private String type;
	private String unit1[];
	private String qty1[];
	private String batch[];
	private String p_name[];
	
	
	
	private String aa[];
	private String bb[];
	private String cc[];
	private String dd[];
	
	private String aa1;
	private String bb1;
	private String cc1;
	private String dd1;
	
	private String total_qty1[];
	
	private String inw_id;
	
	private String date;
	private String time;
	private String username;
	private String remark;
	
	
	private String date1;

	private String remark1;
	
	
	private String unit11;
	private String qty11;
	private String batch11;
	private String p_name11;
	
	private String remain11;
	
	private String whwithbatch;
	private String whwithoutbatch;
	private String dpwithbatch;
	private String dpwithoutbatch;
	private String totwithbatch;
	private String totwithoutbatch;
	
	
	private String from_date;
	private String to_date;
	
	
	private String voucher_no;
	private String paymod;
	private String net_amount;
	private String bankname;
	private String cheque_no;
	private String cheque_amt;
	
	
	private List<String> ppname=new ArrayList<String>();
	private List<String> ppunit=new ArrayList<String>();
	private List<String> ppqty=new ArrayList<String>();
	private List<String> ppremain=new ArrayList<String>();
	
	
	private String unit5[];
	private String qty5[];
	private String batch5[];
	private String p_name5[];
	
	
	
	
	
	List<String> dcnot=new ArrayList<String>();
	List<String> hsncode=new ArrayList<String>();

	List<String> rate=new ArrayList<String>();

	List<String> myrate=new ArrayList<String>();
	List<String> gstamt1=new ArrayList<String>();
	List<String> gstamt2=new ArrayList<String>();
	List<String> netamt=new ArrayList<String>();
	List<String> myamt=new ArrayList<String>();
	List<String> vat=new ArrayList<String>();
	List<String> taxqamount=new ArrayList<String>();
	
	List<String> descriptiont=new ArrayList<String>();
	List<String> quantityt=new ArrayList<String>();
	
	
		
	List<String> bank22=new ArrayList<String>();
	List<String> account22=new ArrayList<String>();
	
	List<String> ifsc22=new ArrayList<String>();
	List<String> branch22=new ArrayList<String>();
	
	
	
	private String bank33[];
	private String account33[];
	private String ifsc33[];
	private String branch33[];
	
	public List<String> getDescriptiont() {
		return descriptiont;
	}

	public void setDescriptiont(List<String> descriptiont) {
		this.descriptiont = descriptiont;
	}

	public List<String> getQuantityt() {
		return quantityt;
	}

	public void setQuantityt(List<String> quantityt) {
		this.quantityt = quantityt;
	}

	private int sparesize;
	
	private int gridsize;
	
	private String cheque_date;
	private String transcation_id;
	
	private String paid_amt;
	
	
	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getRemark1() {
		return remark1;
	}

	public String[] getEe() {
		return ee;
	}

	public void setEe(String[] ee) {
		this.ee = ee;
	}

	public String[] getFf() {
		return ff;
	}

	public void setFf(String[] ff) {
		this.ff = ff;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getMaterialfrom() {
		return materialfrom;
	}

	public void setMaterialfrom(String materialfrom) {
		this.materialfrom = materialfrom;
	}

	public String getMaterialto() {
		return materialto;
	}

	public void setMaterialto(String materialto) {
		this.materialto = materialto;
	}

	public List<String> getPpname() {
		return ppname;
	}

	public void setPpname(List<String> ppname) {
		this.ppname = ppname;
	}

	public List<String> getPpunit() {
		return ppunit;
	}

	public void setPpunit(List<String> ppunit) {
		this.ppunit = ppunit;
	}

	public List<String> getPpqty() {
		return ppqty;
	}

	public void setPpqty(List<String> ppqty) {
		this.ppqty = ppqty;
	}

	public List<String> getPpremain() {
		return ppremain;
	}

	public void setPpremain(List<String> ppremain) {
		this.ppremain = ppremain;
	}

	public String getBatch1() {
		return batch1;
	}

	public void setBatch1(String batch1) {
		this.batch1 = batch1;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getVoucher_no() {
		return voucher_no;
	}

	public void setVoucher_no(String voucher_no) {
		this.voucher_no = voucher_no;
	}

	public String getPaymod() {
		return paymod;
	}

	public void setPaymod(String paymod) {
		this.paymod = paymod;
	}

	public String getNet_amount() {
		return net_amount;
	}

	public void setNet_amount(String net_amount) {
		this.net_amount = net_amount;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getCheque_no() {
		return cheque_no;
	}

	public void setCheque_no(String cheque_no) {
		this.cheque_no = cheque_no;
	}

	public String getCheque_amt() {
		return cheque_amt;
	}

	public void setCheque_amt(String cheque_amt) {
		this.cheque_amt = cheque_amt;
	}

	public String getCheque_date() {
		return cheque_date;
	}

	public void setCheque_date(String cheque_date) {
		this.cheque_date = cheque_date;
	}

	public String getTranscation_id() {
		return transcation_id;
	}

	public void setTranscation_id(String transcation_id) {
		this.transcation_id = transcation_id;
	}

	private String stockradio;
	
	//private String reg_no;
	
	
	private String transport_code;

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getWhwithbatch() {
		return whwithbatch;
	}

	public String[] getAa() {
		return aa;
	}

	public void setAa(String[] aa) {
		this.aa = aa;
	}

	public String[] getBb() {
		return bb;
	}

	public void setBb(String[] bb) {
		this.bb = bb;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String[] getDd() {
		return dd;
	}

	public void setDd(String[] dd) {
		this.dd = dd;
	}

	public void setWhwithbatch(String whwithbatch) {
		this.whwithbatch = whwithbatch;
	}

	public String getWhwithoutbatch() {
		return whwithoutbatch;
	}

	public void setWhwithoutbatch(String whwithoutbatch) {
		this.whwithoutbatch = whwithoutbatch;
	}

	public String getDpwithbatch() {
		return dpwithbatch;
	}

	public void setDpwithbatch(String dpwithbatch) {
		this.dpwithbatch = dpwithbatch;
	}

	public String getDpwithoutbatch() {
		return dpwithoutbatch;
	}

	public void setDpwithoutbatch(String dpwithoutbatch) {
		this.dpwithoutbatch = dpwithoutbatch;
	}

	public String getTotwithbatch() {
		return totwithbatch;
	}

	public void setTotwithbatch(String totwithbatch) {
		this.totwithbatch = totwithbatch;
	}

	public String getTotwithoutbatch() {
		return totwithoutbatch;
	}

	public void setTotwithoutbatch(String totwithoutbatch) {
		this.totwithoutbatch = totwithoutbatch;
	}

	public String getUnit11() {
		return unit11;
	}

	public void setUnit11(String unit11) {
		this.unit11 = unit11;
	}

	public String getQty11() {
		return qty11;
	}

	public void setQty11(String qty11) {
		this.qty11 = qty11;
	}

	public String getBatch11() {
		return batch11;
	}

	public void setBatch11(String batch11) {
		this.batch11 = batch11;
	}

	public String getP_name11() {
		return p_name11;
	}

	public void setP_name11(String p_name11) {
		this.p_name11 = p_name11;
	}

	public String getBag_name() {
		return bag_name;
	}

	public void setBag_name(String bag_name) {
		this.bag_name = bag_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getUnit1() {
		return unit1;
	}

	public void setUnit1(String[] unit1) {
		this.unit1 = unit1;
	}

	public String[] getQty1() {
		return qty1;
	}

	public void setQty1(String[] qty1) {
		this.qty1 = qty1;
	}

	public String[] getBatch() {
		return batch;
	}

	public void setBatch(String[] batch) {
		this.batch = batch;
	}

	public String[] getP_name() {
		return p_name;
	}

	public void setP_name(String[] p_name) {
		this.p_name = p_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public String getGstn() {
		return gstn;
	}

	public void setGstn(String gstn) {
		this.gstn = gstn;
	}

	public String getUin() {
		return uin;
	}

	public void setUin(String uin) {
		this.uin = uin;
	}

	public String[] getUnit5() {
		return unit5;
	}

	public void setUnit5(String[] unit5) {
		this.unit5 = unit5;
	}

	public String[] getQty5() {
		return qty5;
	}

	public void setQty5(String[] qty5) {
		this.qty5 = qty5;
	}

	public String[] getBatch5() {
		return batch5;
	}

	public void setBatch5(String[] batch5) {
		this.batch5 = batch5;
	}

	public String[] getP_name5() {
		return p_name5;
	}

	public void setP_name5(String[] p_name5) {
		this.p_name5 = p_name5;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getNo_of_bag() {
		return no_of_bag;
	}

	public void setNo_of_bag(String no_of_bag) {
		this.no_of_bag = no_of_bag;
	}

	public String getNo_of_box() {
		return no_of_box;
	}

	public void setNo_of_box(String no_of_box) {
		this.no_of_box = no_of_box;
	}

	public String getReg_no() {
		return reg_no;
	}

	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}

	public String getRc() {
		return rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}

	public String getDl() {
		return dl;
	}

	public void setDl(String dl) {
		this.dl = dl;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getDriver_code() {
		return driver_code;
	}

	public void setDriver_code(String driver_code) {
		this.driver_code = driver_code;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public String getTransport_code() {
		return transport_code;
	}

	public void setTransport_code(String transport_code) {
		this.transport_code = transport_code;
	}

	public String getInw_id() {
		return inw_id;
	}

	public void setInw_id(String inw_id) {
		this.inw_id = inw_id;
	}

	public String getReq_id() {
		return req_id;
	}

	public void setReq_id(String req_id) {
		this.req_id = req_id;
	}

	public String getStock_qty() {
		return stock_qty;
	}

	public void setStock_qty(String stock_qty) {
		this.stock_qty = stock_qty;
	}

	public String getStk_id() {
		return stk_id;
	}

	public void setStk_id(String stk_id) {
		this.stk_id = stk_id;
	}

	public String getStockradio() {
		return stockradio;
	}

	public void setStockradio(String stockradio) {
		this.stockradio = stockradio;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getTps() {
		return tps;
	}

	public void setTps(String tps) {
		this.tps = tps;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getDest_id() {
		return dest_id;
	}

	public void setDest_id(String dest_id) {
		this.dest_id = dest_id;
	}

	public String getVs_id() {
		return vs_id;
	}

	public void setVs_id(String vs_id) {
		this.vs_id = vs_id;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getLr() {
		return lr;
	}

	public void setLr(String lr) {
		this.lr = lr;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getDespatch_id() {
		return despatch_id;
	}

	public void setDespatch_id(String despatch_id) {
		this.despatch_id = despatch_id;
	}

	public String getLoader_name() {
		return loader_name;
	}

	public void setLoader_name(String loader_name) {
		this.loader_name = loader_name;
	}

	public String getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}

	public String[] getTotal_qty1() {
		return total_qty1;
	}

	public void setTotal_qty1(String total_qty1[]) {
		this.total_qty1 = total_qty1;
	}

	public String getPaid_amt() {
		return paid_amt;
	}

	public void setPaid_amt(String paid_amt) {
		this.paid_amt = paid_amt;
	}

	public String getPending_days() {
		return pending_days;
	}

	public void setPending_days(String pending_days) {
		this.pending_days = pending_days;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getRemain11() {
		return remain11;
	}

	public void setRemain11(String remain11) {
		this.remain11 = remain11;
	}

	public String getReceive11() {
		return receive11;
	}

	public void setReceive11(String receive11) {
		this.receive11 = receive11;
	}

	public String getOrder11() {
		return order11;
	}

	public void setOrder11(String order11) {
		this.order11 = order11;
	}

	public String getScrap_id() {
		return scrap_id;
	}

	public void setScrap_id(String scrap_id) {
		this.scrap_id = scrap_id;
	}

	public String[] getInvcheck() {
		return invcheck;
	}

	public void setInvcheck(String invcheck[]) {
		this.invcheck = invcheck;
	}

	public String[] getRemain_qty() {
		return remain_qty;
	}

	public void setRemain_qty(String[] remain_qty) {
		this.remain_qty = remain_qty;
	}

	public String[] getBag_name1() {
		return bag_name1;
	}

	public void setBag_name1(String[] bag_name1) {
		this.bag_name1 = bag_name1;
	}

	public String[] getBag_qty() {
		return bag_qty;
	}

	public void setBag_qty(String[] bag_qty) {
		this.bag_qty = bag_qty;
	}

	public String getMr_id() {
		return mr_id;
	}

	public void setMr_id(String mr_id) {
		this.mr_id = mr_id;
	}

	public String getBatch2() {
		return batch2;
	}

	public void setBatch2(String batch2) {
		this.batch2 = batch2;
	}

	public String getClose_id() {
		return close_id;
	}

	public void setClose_id(String close_id) {
		this.close_id = close_id;
	}

	public int getSparesize() {
		return sparesize;
	}

	public void setSparesize(int sparesize) {
		this.sparesize = sparesize;
	}

	public String[] getDcno() {
		return dcno;
	}

	public void setDcno(String dcno[]) {
		this.dcno = dcno;
	}

	public List<String> getDcnot() {
		return dcnot;
	}

	public void setDcnot(List<String> dcnot) {
		this.dcnot = dcnot;
	}

	public List<String> getHsncode() {
		return hsncode;
	}

	public void setHsncode(List<String> hsncode) {
		this.hsncode = hsncode;
	}

	public List<String> getRate() {
		return rate;
	}

	public void setRate(List<String> rate) {
		this.rate = rate;
	}

	public List<String> getMyrate() {
		return myrate;
	}

	public void setMyrate(List<String> myrate) {
		this.myrate = myrate;
	}

	public List<String> getGstamt1() {
		return gstamt1;
	}

	public void setGstamt1(List<String> gstamt1) {
		this.gstamt1 = gstamt1;
	}

	public List<String> getGstamt2() {
		return gstamt2;
	}

	public void setGstamt2(List<String> gstamt2) {
		this.gstamt2 = gstamt2;
	}

	public List<String> getNetamt() {
		return netamt;
	}

	public void setNetamt(List<String> netamt) {
		this.netamt = netamt;
	}

	public List<String> getMyamt() {
		return myamt;
	}

	public void setMyamt(List<String> myamt) {
		this.myamt = myamt;
	}

	public List<String> getVat() {
		return vat;
	}

	public void setVat(List<String> vat) {
		this.vat = vat;
	}

	public List<String> getTaxqamount() {
		return taxqamount;
	}

	public void setTaxqamount(List<String> taxqamount) {
		this.taxqamount = taxqamount;
	}

	public int getGridsize() {
		return gridsize;
	}

	public void setGridsize(int gridsize) {
		this.gridsize = gridsize;
	}

	public String getPath1() {
		return path1;
	}

	public void setPath1(String path1) {
		this.path1 = path1;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

	public String[] getVsno() {
		return vsno;
	}

	public void setVsno(String vsno[]) {
		this.vsno = vsno;
	}

	public String[] getDpno() {
		return dpno;
	}

	public void setDpno(String dpno[]) {
		this.dpno = dpno;
	}

	public String getScheme_qty() {
		return scheme_qty;
	}

	public void setScheme_qty(String scheme_qty) {
		this.scheme_qty = scheme_qty;
	}

	public String getScheme_name() {
		return scheme_name;
	}

	public void setScheme_name(String scheme_name) {
		this.scheme_name = scheme_name;
	}

	public String getTotal_qty() {
		return total_qty;
	}

	public void setTotal_qty(String total_qty) {
		this.total_qty = total_qty;
	}

	public String getAa1() {
		return aa1;
	}

	public void setAa1(String aa1) {
		this.aa1 = aa1;
	}

	public String getBb1() {
		return bb1;
	}

	public void setBb1(String bb1) {
		this.bb1 = bb1;
	}

	public String getCc1() {
		return cc1;
	}

	public void setCc1(String cc1) {
		this.cc1 = cc1;
	}

	public String getDd1() {
		return dd1;
	}

	public void setDd1(String dd1) {
		this.dd1 = dd1;
	}

	public String getLevel_id() {
		return level_id;
	}

	public void setLevel_id(String level_id) {
		this.level_id = level_id;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public String getPath3() {
		return path3;
	}

	public void setPath3(String path3) {
		this.path3 = path3;
	}

	public String getP3() {
		return p3;
	}

	public void setP3(String p3) {
		this.p3 = p3;
	}

	public List<String> getBank22() {
		return bank22;
	}

	public void setBank22(List<String> bank22) {
		this.bank22 = bank22;
	}

	public List<String> getAccount22() {
		return account22;
	}

	public void setAccount22(List<String> account22) {
		this.account22 = account22;
	}

	public List<String> getIfsc22() {
		return ifsc22;
	}

	public void setIfsc22(List<String> ifsc22) {
		this.ifsc22 = ifsc22;
	}

	public List<String> getBranch22() {
		return branch22;
	}

	public void setBranch22(List<String> branch22) {
		this.branch22 = branch22;
	}

	public String[] getBank33() {
		return bank33;
	}

	public void setBank33(String[] bank33) {
		this.bank33 = bank33;
	}

	public String[] getAccount33() {
		return account33;
	}

	public void setAccount33(String[] account33) {
		this.account33 = account33;
	}

	public String[] getIfsc33() {
		return ifsc33;
	}

	public void setIfsc33(String[] ifsc33) {
		this.ifsc33 = ifsc33;
	}

	public String[] getBranch33() {
		return branch33;
	}

	public void setBranch33(String[] branch33) {
		this.branch33 = branch33;
	}

	public String[] getQty1tt() {
		return qty1tt;
	}

	public void setQty1tt(String qty1tt[]) {
		this.qty1tt = qty1tt;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getHalt_charge() {
		return halt_charge;
	}

	public void setHalt_charge(String halt_charge) {
		this.halt_charge = halt_charge;
	}
	
	
	
	
	
	
}
