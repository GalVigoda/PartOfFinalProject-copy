package smartspace.data;

import java.util.Date;
import java.util.Map;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

//import javax.persistence.Transient;

import smartspace.dao.rdb.MapToJsonConverter;


//@Entity
//@Table(name="ELEMENT")
@Document(collection="ELEMENTS")
public class ElementEntity implements SmartSpaceEntity<String> {

	private String elementSmartspace;
	private String elementId;
	private Location location;
	private String name;
	private String type;
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.sss'Z'")
	private Date creationTimestamp;
	private boolean expired;
	private String creatorSmartspace;
	private String creatorEmail;
	private Map<String, Object> moreAttributes;
	private String key;
	
	
	public ElementEntity() {
		
	}
	
	public ElementEntity(String name, String type, Location location, Date creationTimestamp,
			String creatorEmail, String creatorSmartspace, boolean expired, Map<String, Object> moreAttributes){
		super();
		this.name = name;
		this.type = type;
		this.location = location;
		this.creationTimestamp = creationTimestamp;
		this.creatorEmail = creatorEmail;
		this.creatorSmartspace = creatorSmartspace;
		this.expired = expired;
		this.moreAttributes = moreAttributes;
	}

	public String getElementSmartspace() {
		return elementSmartspace;
	}
	public void setElementSmartspace(String elementSmartspace) {
		this.elementSmartspace = elementSmartspace;
	}
	@JsonIgnore
	public String getElementId() {
		return elementId;
	}
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}
	
	@Embedded
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreationTimestamp() {
		return creationTimestamp;
	}
	public void setCreationTimestamp(java.util.Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public String getCreatorSmartspace() {
		return creatorSmartspace;
	}
	public void setCreatorSmartspace(String creatorSmartspace) {
		this.creatorSmartspace = creatorSmartspace;
	}

	public String getCreatorEmail() {
		return creatorEmail;
	}
	public void setCreatorEmail(String creatorEmail) {
		this.creatorEmail = creatorEmail;
	}
	
	@Lob
	@Convert(converter=MapToJsonConverter.class)
	public Map<String, Object> getMoreAttributes() {
		return moreAttributes;
	}
	
	public void setMoreAttributes(Map<String, Object> moreAttributes) {
		this.moreAttributes = moreAttributes;
	}

	@Override
	//@Id
	//@Column(name="ID")
	@org.springframework.data.annotation.Id
	public String getKey() {
		return this.key;
		//return this.elementId + "#" + this.elementSmartspace;
		}

	@Override
	public void setKey(String key) {
		String[] tmpArr = key.split("#");
		this.elementId = tmpArr[0];
		this.elementSmartspace = tmpArr[1];
		this.key = key;
	}

	@Override
	public String toString() {
		return "ElementEntity [elementSmartspace=" + elementSmartspace + ", elementId=" + elementId + ", location="
				+ location + ", name=" + name + ", type=" + type + ", creationTimestamp=" + creationTimestamp
				+ ", expired=" + expired + ", creatorSmartspace=" + creatorSmartspace + ", creatorEmail=" + creatorEmail
				+ ", moreAttributes=" + moreAttributes + "]";
	}

}