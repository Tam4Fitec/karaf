package com.leguide.backoffice.karaf.business.models.json.deserializer.contact;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.GsonBuilder;
import com.leguide.backoffice.karaf.business.models.pojo.contact.Contact;
import com.leguide.backoffice.karaf.business.models.pojo.contact.ContactFunction;
import com.leguide.backoffice.karaf.business.models.pojo.contact.ContactService;
import com.leguide.backoffice.karaf.business.models.pojo.contact.ContactCivility;
import com.leguide.backoffice.karaf.business.models.pojo.contact.enums.ContactFunctionEnum;
import com.leguide.backoffice.karaf.business.models.pojo.contact.enums.ContactServiceEnum;
import com.leguide.backoffice.karaf.business.models.pojo.contact.enums.ContactCivilityEnum;

public class ContactDeserializerTest {

	@Test
	public void testDeserialize() {
		String jsonContact = "{\"contactId\":2,\"civility\":\"MISS\",\"firstName\":\"Jane\",\"lastName\":\"Smith\",\"service\":\"SALES_MANAGEMENT\",\"function\":\"SALES\",\"email\":\"jane.smith@amazon.com\",\"phone\":\"215\"}";	

		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(ContactCivility.class, new ContactCivilityGsonDeserializer());
		builder.registerTypeAdapter(ContactService.class, new ContactServiceGsonDeserializer());
		builder.registerTypeAdapter(ContactFunction.class, new ContactFunctionGsonDeserializer());
		
		Contact contact = builder.create().fromJson(jsonContact, Contact.class);
		
		assertEquals(2, contact.getContactId().intValue());
		assertEquals(ContactCivilityEnum.MISS, contact.getCivility());
		assertEquals(ContactServiceEnum.SALES_MANAGEMENT, contact.getService());
		assertEquals(ContactFunctionEnum.SALES, contact.getFunction());
		assertEquals("Jane", contact.getFirstName());
		assertEquals("Smith", contact.getLastName());
		assertEquals("jane.smith@amazon.com", contact.getEmail());
		assertEquals("215", contact.getPhone());
	}

}
