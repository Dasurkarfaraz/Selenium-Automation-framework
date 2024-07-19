package com.starquick.Listners;

import com.starquick.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import com.starquick.constants.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * Method listner which help to set the Invocation count 
 * 
 * @author Faraz Dasurkar
 * @Version 1.0
 *@Since 2024
 */
public class MethodsListner implements IMethodInterceptor {
	
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<Map<String, String>> list = null;
		list = ExcelUtils.getTestDetails(FrameworkConstranst.getRunerdatasheet());
		System.out.println(list);
		System.out.println(methods.get(0).getMethod().getMethodName().equalsIgnoreCase(list.get(0).get("testname")));
		System.out.println(list.get(0).get("execute").equalsIgnoreCase("yes"));
	//	System.out.println(list.get(1).get("execute").equalsIgnoreCase("yes"));
		List<IMethodInstance> result = new ArrayList<>();
		for (int i = 0; i < methods.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				System.out.println(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname")));
				
				System.out.println(list.get(j).get("execute").equalsIgnoreCase("yes"));
				if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname")) && list.get(j).get("execute").equalsIgnoreCase("yes")) {
						methods.get(i).getMethod().setDescription(list.get(j).get("	"));
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("priority")));
						result.add(methods.get(i));
					}
				}
			}
		
System.out.println(result.toString());
		return result;
	}
}
