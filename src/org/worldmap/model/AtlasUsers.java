package org.worldmap.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author uramanan 
 * Separate Class created for only list because of Marshaller and UnMarshaller.
 */
@XmlRootElement(name = "atlasusers")
@XmlAccessorType(XmlAccessType.FIELD)
public class AtlasUsers {

	@XmlElement(name = "user")
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
