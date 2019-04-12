import com.alibaba.fastjson.JSON;

public class ExTest {

	public static void main(String[] args) {
	
		try {
			Integer.valueOf("a");
		} catch (Exception e) {
			
			
			StackTraceElement[] stackTrace = e.getStackTrace();
			
			int length = stackTrace.length;
			
			if (length > 1) {
				StackTraceElement stackTraceElement = stackTrace[length - 1];
				System.out.println(stackTraceElement.getClassName());
				System.out.println(stackTraceElement.getMethodName());
				System.out.println(stackTraceElement.getLineNumber());
				System.out.println(stackTraceElement);
			}
			
//			for (int i = 0; i < length; i++) {
//				System.out.println(JSON.toJSONString(stackTrace[i]));
//				System.out.println();
//			}
			
			
			
		}

	}

}
