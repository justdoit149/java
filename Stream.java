import java.util.*;
import java.util.stream.Collectors;

public class Stream {

	// 使用命令式范式实现
	public static String getNamesStringImperatively(List<String> nameList) {
        List<String> newList = new ArrayList<>();//建一个新的，长度大于1才往里放
        for (String str : nameList) {
            if (str.length() > 1) {
                String newStr = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
                //对临时字符串str进行大小写变换。
                //如果忘记了这些函数，可以先变成字符数组操作，然后变回字符串。
                //newStr.toCharArray().(操作).toString()
                newList.add(newStr);
            }
        }
        return String.join(",", newList);//将Arraylist/List连成字符串
	}

	// 使用函数式范式实现
	public static String getNamesStringFunctionally(List<String> nameList) {
		List<String> newList = nameList.stream()
                .filter(str -> str.length() > 1)
                .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase())
                .collect(Collectors.toList());
        return String.join(",", newList);
	}
}
