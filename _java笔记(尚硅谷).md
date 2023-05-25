## Java面向对象

* 分析问题时，以要分析的事物为中心的分析方式。
* 类与对象，属性与方法。
* 面向对象中三个重要特征：继承、封装、多态
* 方法。方法的可变参数（同一种类型，个数不定），可以——类型… 参数名。
* 静态。把和对象无关，只和类有关的成为静态（静态属性，静态方法），不需要new，可以直接使用。成员属性和方法可以访问静态属性和方法，但是静态属性和方法不能访问成员属性和方法（因为这样就与具体的对象有关了）。如果在类里有一个static{……}静态代码块，则只要是这个类的信息加载完成就会自动执行静态代码块（如new一个对象、调用这个类里的某个方法等都会执行一遍static代码块里的内容）（应用：在static代码块里写入类的初始化代码，每new一个对象、对对象进行操作都会对其进行初始化）
* 包。package包用来容纳类（实际上就是一个文件夹里装了很多个java文件）。Java每new sth()一个对象后面加括号，是因为这是构造方法，如果类里面有与这个类重名的方法则会默认这个方法为构造方法，否则使用系统默认的构造方法。
* 继承。类存在父子关系，子类可以直接从父类中获取属性和方法（一个类只能有一个父类，一个父类可以有多个子类，像一个树）。语法：在定义类的时候，class 子类 extends 父类{（子类自身的属性和方法）}即可自动将父类的属性和方法继承给子类。特别地，如果父类和子类中有重名的属性或方法的时候，可以用this和super区分。this.name是当前的（子类中），super.name是上一级（父类）中的。（如果不区分的话，默认是this）。创建子类对象会默认创建父类对象（且每创建一个子类就在创建之前先创建一次父类对象）。java里任何一个类都有父类（java.lang.Object的Object类，Java里所有类都应该继承它）
* 多态。一个对象在不同场景下表现出的不同状态和形态，这约束了对象功能的使用场景。（如：以父类声明的子类对象，只能使用父类中的方法而不能用子类中的方法。如 Person p = new Boy()，其中Person是父类而Boy是子类，这样是允许的，此时p被当做Person类使用，不能使用Boy类里的属性和方法）
* 方法重载。一个类里不能声明相同的属性和方法（返回类型不同视为相同方法，参数列表（个数、名、顺序）和方法名不同蔡才视为不同方法）。因此若想要在一个类里使用同名方法，则可以通过不同参数列表来区分，这称作方法的重载。
* 方法重写。父类与子类拥有某个相同的方法（这里的相同包括返回类型），一般而言是父类的方法是通用方法，但对某个特殊的子类，调用父类的这个方法可能不适用，应该调用子类自己的特殊方法（一般与特殊的关系），此时称为方法重写，调用子类对象的方法则就按照子类的这个方法执行（如果加super则是调其父类的方法）。
* 递归。无新内容。
* 访问权限。类、属性、方法等。1.public为公共的。每一个文件中public的类只能有一个且必须和文件名相同。main方法为java虚拟机调用来执行，所以也要public。2.private为私有的，同一个类中可以用（最小）。3.protected受保护的权限，其子类可以使用（范围比默认大，相当于子类public其它default）。4.（default）如果不设置则是默认权限，是包权限，同一个包内的可以访问（但构造方法默认是public）。外部类（不嵌套在别的类里面）只能public和default；内部类（嵌套在别的类里）可以当成其外部类的一个属性来用（因此需要创建外部类对象才能使用其内部类），4种权限均可。拓：单例模式。
* final。修饰的变量不能被修改，修饰方法则方法不能被子类重写（不能修饰构造方法，因为本身构造方法就不能被子类重写，加上没意义），修饰类则其没有子类，修饰方法参数则参数无法修改。
* 抽象。加一个abstract，不能用final修饰。抽象类（不确定、不完整的类。）、抽象方法（只有声明，没有实现。）。含有抽象方法的类肯定不明确了，所以肯定是抽象类。抽象类无法直接构建对象（实例化），但可以通过子类继承来创建对象（若含有抽象方法，则子类需要对这个方法进行方法重写将其补充完整）
* 接口。所谓的接口，可以简单理解为一种规则。基本语法：interface 接口名 {规则属性，规则的行为}。接口其实是抽象的，但其规则属性必须是静态、确定的且不可修改，属性和行为都是公共的，行为是抽象的。接口和类相似，可以继承其它接口。类需要遵循接口制定的规则，这个“遵循”在Java中称为实现，即类需要实现接口，并且可以实现多个接口。【这里没太明白，以后再复习理解吧】
* 枚举。枚举（enum）是一种特殊的类，包含一系列常量对象。
* 匿名类。就是没有名字的类（因为有的时候我们更关心类的属性和方法，而类的名词并不重要）
* bean规范。bean类的设计规范：类要求必须含有无参、公共的构造方法；属性必须私有化，提供公共的set、get方法设置、获取值。

## Java常用类和对象

### Object对象

* 属于java.lang.Object，默认导入的包。
* 所有类默认都以它为父类（间接的话总能连到它，是树的根。也就是以下这些方法对所有对象均可用）。常用方法如下（这些方法也是可以重写的）。
* .toString()转换成字符串对象，返回String。
* .hashCode()返回int，获取对象的内存地址。
* .equals(对象)返回boolean，判断两个对象是否相等，默认比较的是内存地址。
* .getClass()获取对象的类型信息，使用方法为 `Class<?> classType = a.getClass();`

### 数组对象

* 可以是基础数据类型也可以是引用数据类型。`String[] names = new String[1005];`或者可以直接大括号初始化。
* 属性.length获取当前数组的容量。二维数组 `String[][] names = new String[1005][10];`或者嵌套大括号初始化。属性nums.length获取行数，nums[0].length获取列数（因为二维数组相当于每一个元素是一个数组）

### 字符串

* java.lang.String提供了String类。构建，可以直接 `String str = "sskkk";`还可以把现成的字符数组变成字符串 `String str = new str(ch);//ch是一个字符数组`。
* 拼接：可以用“+”，且+的左右边会被自动转化为字符串（因此把数字123转换为字符串可以str = 123 + ""，但1 + 2 + “ABC”实际上得到3ABC，因为先计算了前面的加法）；也可以s1.concat(s2)来把s2拼接到s1后面。
* 比较：是否相等，可以用Object的a.equals(b)；s1.equalsIgnoreCase(s2)忽略大小写判等；a.compareTo(b)返回int，比较两者大小，返回正数则a大，负数则b大，0则相等（从前往后比ascii）；a.compareToIgnoreCase(b)是忽略大小写的比较大小（好像不太常用）。
* 截取：s.substring(int l, int r)左闭右开，r可以省略（此时是截取到最后），返回一个字符串。分隔：s.split(",")用逗号作为分割符，返回的是一个字符串数组。
* 替换：s.trim()去掉原来字符串的首尾所有空格，返回字符串。s.replace(s1,s2)把原来的字符串里的s1替换为s2，返回字符串。s.replaceAll(s1,s2)这里字符串1里面的"|"为“或”，表示可以把s1里出现的这些种情况都替换为s2，返回字符串（这里s1相当于一个替换规则）。
* 大小写转换： s.toLowerCase()将原字符串里的大写字母换成小写；s.toUpperCase()小写替换为大写。若是一些特殊转换（比如首字母大写），可以先substring截取，然后再分段大写或小写转换，然后再用“+”拼接起来。
* 查找：s.toCharArray()返回char数组，将原来的字符串转换为字符数组，这样方便对其进行修改和查找，改完了再.toString()转回字符串。s.getBytes("UTF-8")按照UTF-8来返回一个字节数组。s.charAt(int index)类似数组下标去查找，只查不改的话可以用这个。s.indexOf(s1)在s里面查找子串s1的位置，返回其第一次遇到的s1的起始位置的值（int index）（如果从后往前找的话可以用s.lastIndexOf(s1)），如果没有则返回-1。s.contains(s1)是查找是否有s1子串，返回boolean，有则true没有false。s.startsWith(s1)是否是s1开头，s.endsWith(s1)是否s1结尾，均是返回boolean类型。s.isEmpty()字符串是否为空。
* StringBuilder类，用于构建、修改字符串（与StringBuffer类似但有速度优势，因此更常用）。由于常规的拼接需要创建新字符串，故循环多次拼接的话效率很低。可以new一个StringBuilder对象s，然后s.append(s1)拼接，最后s.toString()，这样的效率快很多。s.length()方法获取长度，s.reverse()方法翻转，s.insert(int index, s2)向s的index位置插入字符串s2

### 其它

* 包装类。8种基本数据类型,byte,short,int,long,float,double,char,boolean。这8种不继承Object类，不能new创建对象；而其它的引用数据类型都要继承Object类，能够new创建对象。因此这8种用起来不太方便（难以使用Object的方法等），因此这8种各自对应一种引用数据类型来使用（java.lang里，不需要额外引入）：Byte，Short，Integer，Long，Float，Double，Character，Boolean。这8种成为包装类，可以像对应的基本类型一样使用，也可以使用其它方法。转换：`Integet i1 = Integer.valueOf(i);`或者直接 `Integer i1 = i;`。反着转换的话是 `int i2 = i1.intValue();`或者 `int i2 = i1;`。也就是说可以自动互相转换（自动拆箱）。字符串转成数字：Integer i = Integer.parseInt(s);
* 日期类。时间戳（获取系统时间）：System.currentTimeMillis()返回一个long类型的整数，从1970.1.1到现在的毫秒数。日期类Date(有两个，java.util和java.sql里都有名为Date的类，此处指前者)：创造出的Date对象直接打印就是当前的时间，但是为了格式化它，我们经常创造一个SimpleDateFormat类的对象sdf（创造方法new的参数是代表时间格式的字符串，即规则）；时间格式：y年，M月，d日（一个月中第几日）/D日（一年中第几日），h小时（12）/H小时（24），m分钟，s秒/S毫秒；然后sdf.format(time)可以将Date类的对象time按照这个规则格式化，返回字符串。sdf.parse(str)可以将符合这个sdf规则的字符串解析成Date对象（注意可以.var可以自动补全）。因此经常创建应该sdf规则，然后去解析字符串成日期，然后对日期类去运算，然后再转回来。Date对象常用方法：date.setTime(时间戳)可以根据时间戳构建date对象；date.getTime()是获取date的时间戳；d1.before(d2)看d1是否早于d2（true或false）（after晚于）。还可以用日历类Calendar（略）。
* 比较。基本数据类型，双等号比较值；引用数据类型，双等号比较地址（对引用类型的值的比较，应该使用s1.equals(s2)来判断）；且如果是自己定义的类的话可以自己重写equals、hashCode等方法来方便判定。

## Java异常

* 区分错误（不符合java语法）与异常（异常一般是正常情况下没问题，但是某些特定情况下可能会出问题）
* 分为两类：运行期异常（可以通过代码恢复正常逻辑执行的异常）（RuntimeException），编译期异常，其中编译器异常必须要通过下面的Exception语法来解决（否则不能编译运行）
* 语法：

```java
try{
	//可能会出现异常的代码,如果出现异常则JVM会对其封装成一个具体的异常类并抛出。
}catch(抛出的异常对象 异常引用){
	//catch用来捕捉抛出的异常对象，大括号里写解决异常的方案代码
}catch(IOException x){
	//对抛出的异常对象x可以有一些方法。
	//可能会出现多个异常，依次捕捉，一般先捕捉范围小、比较具体的异常
}finally{
	//不管有无异常，最后都要执行这个
}
```

* 常见异常。运行期：ArithmeticException算术异常（如除数为0）、NullPointerException空指针异常（对null对象调用了其成员属性或成员方法），ArrayIndexOutOfBoundsException数组越界异常，StringIndexOutOfBoundsException字符串越界异常（s.chatAt(index)），NumberFormatException格式化异常（如将不是数字的字符串abc用Integer.parseInt()转换成数字），ClassCastException类型转换错误
* 如果方法可能会出现异常，那么在方法名、参数后面加上throws 可能的Exception。如果想要让方法抛出某个指定的异常，可以方法内部try……catch之后在catch里throw new 要抛出的异常()，并将该方法throws的Exception也设为这种异常。
* 异常可以自己定义，略。

## 数据流IO

* 文件流。文件类型File，属于java.io包。File f = new File(s)，s为文件路径字符串。创建文件对象然后关联到系统文件。常用的文件对象的操作：.isFile()判断是是否是文件/.isDirectory是否是文件夹/.exists()文件对象是否存在关联；f.mkdirs()创建多级文件目录；f.createNewFile()创建新文件；f.getName()获取文件名(返回String)；f.length()获取文件长度(返回int)。
* 文件复制。文件输入流FileInputStream in = new FileInputStream(s1)（参数为文件名字符串），输出流FileOutputStream out = new FileOutputStream(s2)，需要抛出FileNotFoundException（可以直接抛IOException）。一般是先声明=null然后在try里创建并绑定然后进行一系列文件操作，在catch里抛出异常，最后在finally里判断如果不是null则in.close()关闭（关闭也需要抛出IOException异常）。读取数据：int data = in.read()，返回int（实际上是ASCII码）（需要抛出异常IOE），然后out.write(data)（实际上数据也是ASCII码）。这两个方法都是只读单个字符。文件读取完毕之后读取结果是-1（可用此作结束条件，然后循环去读取）
* 缓冲区（Buffer）。刚才的读写都是一个一个处理的。想更高效读写可以增加缓冲区。BufferedInputStream和BufferedOutputStream。这两个类的构建方法的参数就分别是刚才输入流和输出流（BufferedInputStream buffIn = new BufferedInputStream(in)）。具体使用方法略（因为对考试而言这个和上一个没多大区别，反正考试不卡时间）。
* 字符流。想要对读取的数据进行处理。可以先new一个StringBuilder对象ss，然后每次.read()读取的结果强制类型转换成char（在数据前面加(char)）然后ss.append(c)追加上，最后.toString()转换成字符串，可以用分隔等字符串操作。还可以把它.toCharArray()然后逐个写回去。进一步，可以用BufferedReader对象（这个东西构造方法的参数是一个FileReader对象）。可以BufferedReader r = new BufferedReader(new FileReader(f))，其中f是之前打开的文件；或者括号里是new InputStreamReader(System.in)用来实现控制台输入。这个r.readLine()可以读一行然后返回字符串（如果到了最后是null）。与之对应，有BufferedWriter、PrintWriter来写入（PrintWriter的构造方法的参数就是文件f，不需要在创建别的东西了），然后write.println等Print方法（与控制台输出类似，实际上控制台输出就是输出到Systrm.out的）
* 序列化：把对象变成字节码写入文件；反序列化：将文件中的字节读成对象。ObjectOutputStream。具体使用略。
* （更简单方便的还可以用Scanner来读取文件）

```java
import java.io.*;//为了File
import java.util.*;//Scanner
public class self1 {
    public static void main(String[] args) {
        File f = new File("./data.txt");//先打开文件
        Scanner scan = null;//声明Scanner对象并初始化
        try {
            scan = new Scanner(f);//括号里直接是f表示读取的数据来源为f指向的文件
            while(true){
                if(scan.hasNextLine()){//读一行，返回字符串
                    System.out.println(scan.nextLine());
                }else{
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            // new Scanner(f)会有异常
        }finally{
            scan.close();
        } 
    }
}

```
