package com.transsion.store.dto;

public class TacDto implements java.io.Serializable{
	
	private String id;
	
	private String imei;
	
    private String tac;

    private String brandCode;

    private String modelMatCode;

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

    public String getModelMatCode() {
        return modelMatCode;
    }

    public void setModelMatCode(String modelMatCode) {
        this.modelMatCode = modelMatCode;
    }

    @Override
    public String toString() {
        return "TacDto{" +
                "id='" + id + '\'' +
                ", imei='" + imei + '\'' +
                ", tac='" + tac + '\'' +
                ", brandCode='" + brandCode + '\'' +
                ", modelMatCode='" + modelMatCode + '\'' +
                '}';
    }
}
