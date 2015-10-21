package DTO;

public class SingleCodeDTO {
	private String pinKode;
	private String systemNummer;
	
	public SingleCodeDTO(String pinKode, String systemNummer){
		this.pinKode=pinKode;
		this.systemNummer=systemNummer;
	}

	public String getPinKode() {
		return pinKode;
	}

	public void setPinKode(String pinKode) {
		this.pinKode = pinKode;
	}

	public String getSystemNummer() {
		return systemNummer;
	}

	public void setSystemNummer(String systemNummer) {
		this.systemNummer = systemNummer;
	}

}
