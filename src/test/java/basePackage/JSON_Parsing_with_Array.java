package basePackage;

import java.util.Scanner;

import filesPackage.Payload;
import io.restassured.path.json.JsonPath;

public class JSON_Parsing_with_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		JsonPath JP_obj = new JsonPath(Payload.JSON_Parsing_with_Array_Payload());
		
		int courseCount = JP_obj.getInt("courses.size()");
		
		// print number of courses
		System.out.println("====> Printing number of courses: ");
		System.out.println(">>> Courses Count: "+courseCount);
		
		// print purchase amount
		System.out.println("====> Printing purchase amount: ");
		int purchaseAmount = JP_obj.getInt("dashboard.purchaseAmount");
		System.out.println(">>> Purchase Amount: "+ purchaseAmount);
		
		// print title of the first course:
		System.out.println("====> Printing title of the first course(s): ");
		String title = JP_obj.getString("courses[0].title");
		System.out.println(">>> First course: "+ title);
		
//		System.out.println(">>> Which course title do you wanna check? ");
//		Scanner input = new Scanner(System.in);
//		int in = input.nextInt();
//		switch(in) {
//		
//		case 1: title = JP_obj.getString("courses[0].title");
//		System.out.println(">>> First course: "+ title);
//		break;
//		
//		case 2: title = JP_obj.getString("courses[1].title");
//		System.out.println(">>> Second course: "+ title);
//		break;
//		
//		case 3: title = JP_obj.getString("courses[2].title");
//		System.out.println(">>> Third course: "+ title);
//		break;
//		
//		}
		
		//get all details of the array:
		
		System.out.println("====> Printing details of course(s): ");
		for(int i = 0; i < courseCount; i++) {
			
			System.out.println(">>> Title: "+JP_obj.get("courses["+i+"].title"));
			System.out.println(">>> Price: "+JP_obj.get("courses["+i+"].price"));
			System.out.println(">>> Copies: "+JP_obj.get("courses["+i+"].copies"));
			System.out.println("------------------------------");
			
		}

	}

}
