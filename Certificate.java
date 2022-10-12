package maps2;
import java.lang.Comparable;
public class Certificate implements Comparable<Certificate> {
	private int certNo;
	private String cerName;
	private String cerDomain;
	

	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Certificate(int certNo, String cerName, String cerDomain) {
		super();
		this.certNo = certNo;
		this.cerName = cerName;
		this.cerDomain = cerDomain;
	}


	public int getCertNo() {
		return certNo;
	}


	public void setCertNo(int certNo) {
		this.certNo = certNo;
	}


	public String getCerName() {
		return cerName;
	}


	public void setCerName(String cerName) {
		this.cerName = cerName;
	}


	public String getCerDomain() {
		return cerDomain;
	}


	public void setCerDomain(String cerDomain) {
		this.cerDomain = cerDomain;
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cerName == null) ? 0 : cerName.hashCode());
		result = prime * result + certNo;
		result = prime * result + ((cerDomain == null) ? 0 : cerDomain.hashCode());
		return result;
		
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Certificate other = (Certificate) obj;
		if (cerName== null) {
			if (other.cerName != null)
				return false;
		} else if (!cerName.equals(other.cerName))
			return false;
		if (certNo!= other.certNo)
			return false;
		if (cerDomain == null) {
			if (other.cerDomain != null)
				return false;
		} else if (!cerDomain.equals(other.cerDomain))
			return false;
		return true;
	
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "certificateName=" +cerName+" certificate domain=" +cerDomain + "marksObtain=" + certNo;
					}


	@Override
	public int compareTo(Certificate o) {
		// TODO Auto-generated method stub
		return this.certNo - o.getCertNo();
	}

}
