package com.testnashta.testnashta.enumeration;

public enum responseCodes {
		SUCCESS("00", "sukses"),
	    FAILED("01", "gagal"),
	    EXISTS("02", "data sudah ada"),
	    NOTFOUND("03", "data tidak ditemukan"),
		OTHER("99", "error");
		
	    public final String code;
	    public final String desc;
	 
	    private responseCodes(String code, String desc) {
	        this.code = code;
	        this.desc = desc;
	    }

		public String getCode() {
			return code;
		}

		public String getDesc() {
			return desc;
		}
}
