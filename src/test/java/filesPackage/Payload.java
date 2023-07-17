package filesPackage;

public class Payload {
	
	public static String AddPlace() {
		
		return "{\n"
				+ "    \"location\": {\n"
				+ "        \"lat\": 18.62288908358962,\n"
				+ "        \"lng\": 73.91304028195202\n"
				+ "    },\n"
				+ "    \"accuracy\": 50,\n"
				+ "    \"name\": \"Arko Biswas Home\",\n"
				+ "    \"phone_number\": \"(+91) 7871238573\",\n"
				+ "    \"address\": \"F2-1103 Kingsbury\",\n"
				+ "    \"types\": [\n"
				+ "        \"Home\",\n"
				+ "        \"Apartment\"\n"
				+ "    ],\n"
				+ "    \"website\": \"http://google.com\",\n"
				+ "    \"language\": \"French-IN\"\n"
				+ "}";
		
	}
	
	public static String JSON_Parsing_with_Array_Payload() {
		
		return "{\n"
				+ "  \"dashboard\": {\n"
				+ "    \"purchaseAmount\": 910,\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\n"
				+ "  },\n"
				+ "  \"courses\": [\n"
				+ "    {\n"
				+ "      \"title\": \"Selenium Python\",\n"
				+ "      \"price\": 50,\n"
				+ "      \"copies\": 6\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"title\": \"Cypress\",\n"
				+ "      \"price\": 40,\n"
				+ "      \"copies\": 4\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"title\": \"RPA\",\n"
				+ "      \"price\": 45,\n"
				+ "      \"copies\": 10\n"
				+ "    }\n"
				+ "  ]\n"
				+ "}";
		
	}

}
