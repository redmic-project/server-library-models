package es.redmic.models.es.atlas;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.opengis.metadata.citation.Address;
import org.opengis.metadata.citation.ResponsibleParty;
import org.opengis.metadata.citation.Telephone;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Contact {

	private String name;
	private String email;
	private String phone;
	private String fax;
	private String address;
	private String organization;
	private String contactPosition;

	public Contact() {
	}

	public Contact(ResponsibleParty contactInfo) {

		setName(contactInfo.getIndividualName());

		if (contactInfo.getOrganisationName() != null)
			setOrganization(contactInfo.getOrganisationName().toString());

		if (contactInfo.getContactInfo() != null) {
			setPhone(contactInfo.getContactInfo().getPhone());
			setFax(contactInfo.getContactInfo().getPhone());
			setEmail(contactInfo.getContactInfo().getAddress());
			setAddress(contactInfo.getContactInfo().getAddress());
		}

		if (contactInfo.getPositionName() != null)
			setContactPosition(contactInfo.getPositionName().toString());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	@JsonSetter("email")
	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmail(Address address) {
		if (address != null && !address.getElectronicMailAddresses().isEmpty())
			this.email = address.getElectronicMailAddresses().toArray()[0].toString();
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getAddress() {
		return address;
	}

	@JsonSetter("address")
	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddress(Address address) {
		if (address != null) {
			String addressAux = null;
			if (!address.getDeliveryPoints().isEmpty())
				addressAux = address.getDeliveryPoints().toArray()[0].toString() + " ";

			if (address.getCity() != null)
				addressAux += address.getCity() + " ";

			if (address.getPostalCode() != null)
				addressAux += address.getPostalCode() + " ";

			if (address.getCountry() != null)
				addressAux += address.getCountry() + " ";

			if (addressAux != null)
				this.address = addressAux;
		}
	}

	public String getPhone() {
		return phone;
	}

	@JsonSetter("phone")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPhone(Telephone phone) {
		if (phone != null && !phone.getVoices().isEmpty())
			this.phone = phone.getVoices().toArray()[0].toString();
	}

	public String getFax() {
		return fax;
	}

	@JsonSetter("fax")
	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setFax(Telephone fax) {
		if (phone != null && !fax.getFacsimiles().isEmpty())
			this.fax = fax.getFacsimiles().toArray()[0].toString();
	}

	public String getContactPosition() {
		return contactPosition;
	}

	public void setContactPosition(String contactPosition) {
		this.contactPosition = contactPosition;
	}

	public String toString() {

		return "Name: " + getName() + "\nEmail: " + getEmail() + "\nOrganization: " + getOrganization() + "\nPhone: "
				+ getPhone() + "\nFax: " + getFax() + "\nAddress: " + getAddress() + "\nContact position: "
				+ getContactPosition();
	}
}
