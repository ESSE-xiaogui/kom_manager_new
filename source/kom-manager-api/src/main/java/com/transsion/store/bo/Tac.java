package com.transsion.store.bo;

public class Tac implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String imei;
	
    private String tac;

    private String brandCode;

    private String modelCode;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getTac() {
		return tac;
	}

	public void setTac(String tac) {
		this.tac = tac;
	}

	public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	@Override
	public String toString() {
		return "Tac [id=" + id + ", imei=" + imei + ", tac=" + tac + ", brandCode=" + brandCode + ", modelCode="
						+ modelCode + "]";
	}


}
